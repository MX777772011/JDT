package com.devplatform.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author ChengWei
 * 
 */
public class FileTypeUtil {

	/**
	 * byte数组转换成16进制字符串
	 * 
	 * @param src
	 * @return
	 */
	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	public final static Map<String, String> FILE_TYPE_MAP = getAllFileType();

	private static Map<String, String> getAllFileType() {
		Map<String, String> file_type_map = new HashMap<String, String>();
		file_type_map.put("ffd8ffe000104a464946", "jpg"); // JPEG (jpg)
		file_type_map.put("89504e470d0a1a0a0000", "png"); // PNG (png)
		file_type_map.put("47494638396126026f01", "gif"); // GIF (gif)
		file_type_map.put("49492a00227105008037", "tif"); // TIFF (tif)
		file_type_map.put("424d228c010000000000", "bmp"); // 16色位图(bmp)
		file_type_map.put("424d8240090000000000", "bmp"); // 24位位图(bmp)
		file_type_map.put("424d8e1b030000000000", "bmp"); // 256色位图(bmp)
		file_type_map.put("41433130313500000000", "dwg"); // CAD (dwg)
		file_type_map.put("3c21444f435459504520", "html"); // HTML (html)
		file_type_map.put("3c21646f637479706520", "htm"); // HTM (htm)
		file_type_map.put("48544d4c207b0d0a0942", "css"); // css
		file_type_map.put("696b2e71623d696b2e71", "js"); // js
		file_type_map.put("7b5c727466315c616e73", "rtf"); // Rich Text Format
		file_type_map.put("38425053000100000000", "psd"); // Photoshop (psd)
		file_type_map.put("46726f6d3a203d3f6762", "eml"); // Email [Outlook
		file_type_map.put("d0cf11e0a1b11ae10000", "doc"); // MS office
		file_type_map.put("d0cf11e0a1b11ae10000", "vsd"); // Visio 绘图
		file_type_map.put("5374616E64617264204A", "mdb"); // MS Access (mdb)
		file_type_map.put("252150532D41646F6265", "ps");
		file_type_map.put("255044462d312e350d0a", "pdf"); // Adobe Acrobat (pdf)
		file_type_map.put("2e524d46000000120001", "rmvb"); // rmvb/rm相同
		file_type_map.put("464c5601050000000900", "flv"); // flv与f4v相同
		file_type_map.put("00000020667479706d70", "mp4");
		file_type_map.put("49443303000000002176", "mp3");
		file_type_map.put("000001ba210001000180", "mpg"); //
		file_type_map.put("3026b2758e66cf11a6d9", "wmv"); // wmv与asf相同
		file_type_map.put("52494646e27807005741", "wav"); // Wave (wav)
		file_type_map.put("52494646d07d60074156", "avi");
		file_type_map.put("4d546864000000060001", "mid"); // MIDI (mid)
		file_type_map.put("504b0304140000000800", "zip");
		file_type_map.put("526172211a0700cf9073", "rar");
		file_type_map.put("235468697320636f6e66", "ini");
		file_type_map.put("504b03040a0000000000", "jar");
		file_type_map.put("4d5a9000030000000400", "exe");// 可执行文件
		file_type_map.put("3c25402070616765206c", "jsp");// jsp文件
		file_type_map.put("4d616e69666573742d56", "mf");// MF文件
		file_type_map.put("3c3f786d6c2076657273", "xml");// xml文件
		file_type_map.put("494e5345525420494e54", "sql");// xml文件
		file_type_map.put("7061636b616765207765", "java");// java文件
		file_type_map.put("406563686f206f66660d", "bat");// bat文件
		file_type_map.put("1f8b0800000000000000", "gz");// gz文件
		file_type_map.put("6c6f67346a2e726f6f74", "properties");// bat文件
		file_type_map.put("cafebabe0000002e0041", "class");// bat文件
		file_type_map.put("49545346030000006000", "chm");// bat文件
		file_type_map.put("04000000010000001300", "mxp");// bat文件
		file_type_map.put("504b0304140006000800", "docx");// docx文件
		file_type_map.put("d0cf11e0a1b11ae10000", "wps");// WPS文字wps、表格et、演示dps都是一样的
		file_type_map.put("6431303a637265617465", "torrent");
		file_type_map.put("6D6F6F76", "mov"); // Quicktime (mov)
		file_type_map.put("FF575043", "wpd"); // WordPerfect (wpd)
		file_type_map.put("CFAD12FEC5FD746F", "dbx"); // Outlook Express (dbx)
		file_type_map.put("2142444E", "pst"); // Outlook (pst)
		file_type_map.put("AC9EBD8F", "qdf"); // Quicken (qdf)
		file_type_map.put("E3828596", "pwl"); // Windows Password (pwl)
		file_type_map.put("2E7261FD", "ram"); // Real Audio (ram)
		return file_type_map;
	}

	/**
	 * 根据文件流读取图片文件真实类型
	 * 
	 * @param is
	 * @return
	 */
	public static String getTypeByStream(InputStream is) {
		byte[] b = new byte[10];
		try {
			is.read(b, 0, b.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String filecode = bytesToHexString(b).toUpperCase();
		String type = "";
		Iterator<String> keyIter = FILE_TYPE_MAP.keySet().iterator();
		while (keyIter.hasNext()) {
			String key = keyIter.next();
			if (key.toLowerCase().startsWith(filecode.toLowerCase()) || filecode.toLowerCase().startsWith(key.toLowerCase())) {
				type = FILE_TYPE_MAP.get(key);
				break;
			}
		}

		return type;
	}
	public static String getType(MultipartFile file) {
		String fname = file.getName();
		return fname.lastIndexOf(".")!=-1?fname.substring(fname.lastIndexOf(".")):"";
		
	}

}
