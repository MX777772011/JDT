package com.devplatform.sys.action;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.devplatform.common.annotation.Auth;
import com.devplatform.common.utils.CustomException;
import com.devplatform.common.utils.FileTypeUtil;
import com.devplatform.sys.constant.ResultCodeEnum;
import com.devplatform.sys.utils.ResultUtil;

@RestController
@RequestMapping("/sysUpload")
public class FileUploadAction extends BaseAction {

	protected final static Logger log = Logger.getLogger(FileUploadAction.class);
	private ResourceBundle res = null;

	private static final boolean isCheck = true;
	private static final DateFormat FOLD_DF = new SimpleDateFormat("/yyyyMMdd/");;

	/**
	 * 将上传的文件，按照配置文件的N内容进行校验、存储，只能上传图片
	 * @param file 上传的文件
	 */
	@RequestMapping("/uploadImg")
	@Auth(verifyLogin = false, verifyURL = false)
	public void uploadImg(@RequestParam(value = "file", required = false) MultipartFile file) {
		uploadFile(file, response, "img");
	}

	/**
	 * 将上传的文件，按照配置文件的N内容进行校验、存储，只能上传视频
	 * @param file 上传的文件
	 */
	@RequestMapping("/uploadVideo")
	@Auth(verifyLogin = false, verifyURL = false)
	public void uploadVideo(@RequestParam(value = "file", required = false) MultipartFile file) {
		uploadFile(file, response, "video");
	}

	/**
	 * 将上传的文件，按照配置文件的N内容进行校验、存储，只能上传音频
	 * @param file 上传的文件
	 */
	@RequestMapping("/uploadAudio")
	@Auth(verifyLogin = false, verifyURL = false)
	public void uploadAudio(@RequestParam(value = "file", required = false) MultipartFile file) {
		uploadFile(file, response, "audio");
	}

	/**
	 * 将上传的文件，按照配置文件的N内容进行校验、存储，只能上传zip格式的压缩包
	 * @param file 上传的文件
	 */
	@RequestMapping("/uploadZip")
	@Auth(verifyLogin = false, verifyURL = false)
	public void uuZip(@RequestParam(value = "file", required = false) MultipartFile file) {
		uploadFile(file, response, "zip");
	}
	
	/**
	 * 根据type获取相应的配置，然后将上传的file根据配置文件写到相应的路径。
	 * @param file 要处理的上传文件
	 * @param httpServletResponse 响应对象，用于将json数据写回前台
	 * @param type
	 */
	private void uploadFile(MultipartFile file,HttpServletResponse httpServletResponse, String type){
		try {
			if (file == null || file.isEmpty()) {
				ResultUtil.sendJsonData(httpServletResponse, false, ResultCodeEnum.UPLOAD_FILE_NOTEXSIT, null);
				return;
			}
			// 判断文件类型
			boolean isImg = validateType("file."+type+".type", file);
			if (!isImg) {
				ResultUtil.sendJsonData(httpServletResponse, false, ResultCodeEnum.UPLOAD_FILE_TYPE_ERROR, null);
				return;
			}
			// 相对路径
			String vPath = writeFile(file, type);
			// 将结果输出
			ResultUtil.sendJsonData(httpServletResponse, true, ResultCodeEnum.COMMON_SUCCESS, "{fileName:\"" + vPath + "\"}");
			return;
		} catch (CustomException e) {
			ResultUtil.sendJsonData(httpServletResponse, false, e.getErrCode(), e.getMessage(), null);
		} catch (Exception e) {
			ResultUtil.sendJsonData(httpServletResponse, false, ResultCodeEnum.COMMON_FAILED.key, e.getMessage(), null);
		}
		return;
	}
	
	private boolean validateType(String checkConfig, MultipartFile file) throws IOException {
		if (!isCheck) {
			return !isCheck;
		}
		res = res == null ? ResourceBundle.getBundle("config/default/fileUrl") : res;
		String fileType = res.getString(checkConfig);
		return fileType.contains(FileTypeUtil.getType(file));

	}

	private String writeFile(MultipartFile file, String filetype) throws IllegalStateException, IOException {
		res = res == null ? ResourceBundle.getBundle("config/default/fileUrl") : res;
		// 相对目录
		String vPathDir = "upload/project/" + filetype + FOLD_DF.format(System.currentTimeMillis());
		// 文件名称
		String fileName = System.currentTimeMillis() + "" + Math.round(Math.random() * 899999 + 100000) + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).toLowerCase();
		// 相对路径
		String vPath = vPathDir + fileName;
		// 绝对路径
		String realPathDir = res.getString("file.suffix") + vPathDir;
		// 文件
		File targetFile = new File(realPathDir, fileName);
		// 目录不存在则建立目录
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 将文件上传指定位置
		file.transferTo(targetFile);
		return vPath;
	}

}
