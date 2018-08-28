package com.devplatform.common.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class FileUtils {

	public static File createFile(String targetPath, String fileName, String fileExt) {

		File folder = new File(targetPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File beanFile = new File(targetPath, fileName + "." + fileExt);
		try {
			beanFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			throw new CustomException("文件创建出错", "E0102");
		}
		return beanFile;
	}

	public static void createFolder(String targetPath) {
		if (!targetPath.endsWith(File.separator)) {
			targetPath = targetPath + File.separator;
		}
		File folder = new File(targetPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}

	public static void writeFile(File beanFile, String content) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(beanFile), "UTF-8"));
			bw.write(content);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("文件写出错", "E0103");
		}
	}

	public static void deleteFileAndDir(String targetPath) {
		File file = new File(targetPath);
		// 判断目录或文件是否存在
		if (!file.exists()) { // 不存在返回
			return;
		}
		if (file.isFile()) { // 为文件时调用删除文件方法
			file.delete();
		} else { // 为目录时调用删除目录方法
			deleteDirectory(targetPath);
		}
	}

	private static void deleteFile(String targetPath) {
		File file = new File(targetPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
		}

	}

	private static void deleteDirectory(String targetPath) {
		// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		if (!targetPath.endsWith(File.separator)) {
			targetPath = targetPath + File.separator;
		}
		File dirFile = new File(targetPath);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return;
		}
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				deleteFile(files[i].getAbsolutePath());
			} // 删除子目录
			else {
				deleteDirectory(files[i].getAbsolutePath());
			}
		}
		// 删除当前目录
		dirFile.delete();
	}

	/**
	 * 复制整个目录的结构
	 * 
	 * @param srcDirName
	 *            待复制目录的目录名
	 * @param targetDirName
	 *            目标目录名
	 * @param overlay
	 *            如果目标目录存在，是否覆盖
	 * @return 如果复制成功返回true，否则返回false
	 */
	public static boolean copyDirectory(String srcDirName, String targetDirName, boolean overlay) {
		// 判断源目录是否存在
		File srcDir = new File(srcDirName);
		if (!srcDir.exists()) {
			return false;
		}
		if (!srcDir.isDirectory()) {
			return false;
		}

		// 如果目标目录名不是以文件分隔符结尾，则加上文件分隔符
		if (!targetDirName.endsWith(File.separator)) {
			targetDirName = targetDirName + File.separator;
		}
		File targetDir = new File(targetDirName);
		// 如果目标文件夹存在
		if (targetDir.exists()) {
			// 如果允许覆盖则删除已存在的目标目录
			if (overlay) {
				deleteFileAndDir(targetDirName);
			} else {
				return false;
			}
		} else {
			// 创建目的目录
			if (!targetDir.mkdirs()) {
				return false;
			}
		}

		boolean flag = true;
		File[] files = srcDir.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 复制文件
			if (files[i].isFile()) {
				flag = copyFile(files[i].getAbsolutePath(), targetDirName + files[i].getName(), overlay);
				if (!flag)
					break;
			} else if (files[i].isDirectory()) {
				flag = copyDirectory(files[i].getAbsolutePath(), targetDirName + files[i].getName(), overlay);
				if (!flag)
					break;
			}
		}
		if (!flag) {

			return false;
		} else {
			return true;
		}
	}

	public static boolean copyFile(String srcFileName, String targetFileName, boolean overlay) {
		File srcFile = new File(srcFileName);

		// 判断源文件是否存在
		if (!srcFile.exists()) {
			return false;
		} else if (!srcFile.isFile()) {
			return false;
		}

		// 判断目标文件是否存在
		File destFile = new File(targetFileName);
		if (destFile.exists()) {
			// 如果目标文件存在并允许覆盖
			if (overlay) {
				// 删除已经存在的目标文件，无论目标文件是目录还是单个文件
				new File(targetFileName).delete();
			}else{
				return false;
			}
		} else {
			// 如果目标文件所在目录不存在，则创建目录
			if (!destFile.getParentFile().exists()) {
				// 目标文件所在目录不存在
				if (!destFile.getParentFile().mkdirs()) {
					// 复制文件失败：创建目标文件所在目录失败
					return false;
				}
			}
		}

		// 复制文件
		int byteread = 0; // 读取的字节数
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);
			byte[] buffer = new byte[1024];
			while ((byteread = in.read(buffer)) != -1) {
				out.write(buffer, 0, byteread);
			}
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		String srcDirName = "C:/test/test0/test1";
		String destDirName = "c:/ttt";
		copyDirectory(srcDirName, destDirName, true);
	}
}
