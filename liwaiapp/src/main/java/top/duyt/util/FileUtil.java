package top.duyt.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import top.duyt.dto.AttachmentDto;

public class FileUtil {

	/**
	 * 上传附件
	 * @param adto
	 * @param uploadPath
	 * @param newFileNames
	 * @throws IOException
	 */
	public static void uploadAttachments(AttachmentDto adto,String uploadPath,List<String> newFileNames) throws IOException{
		//保存无误则上传所有附件
		File tempFile = null;
		//原文件名
		String[] fileNames = adto.getFilesName();
		for (int i = 0 ; i < adto.getFiles().length ;i++) {
			tempFile = new File(uploadPath + "/" + newFileNames.get(i) + "." + FilenameUtils.getExtension(fileNames[i]));
			//如果当前文件是个目录或者已存在，则先删除再创建
			if (tempFile.isDirectory()||tempFile.exists()) {
				tempFile.delete();
				tempFile = new File(uploadPath + "/" + newFileNames.get(i) + "." + FilenameUtils.getExtension(fileNames[i]));
			}
			FileUtils.copyFile(adto.getFiles()[i], tempFile);
		}
	}
	
}
