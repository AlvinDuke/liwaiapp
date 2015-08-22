package top.duyt.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import top.duyt.dto.AttachmentDto;

public class FileUtil {

	/**
	 * �ϴ�����
	 * @param adto
	 * @param uploadPath
	 * @param newFileNames
	 * @throws IOException
	 */
	public static void uploadAttachments(AttachmentDto adto,String uploadPath,List<String> newFileNames) throws IOException{
		//�����������ϴ����и���
		File tempFile = null;
		//ԭ�ļ���
		String[] fileNames = adto.getFilesName();
		for (int i = 0 ; i < adto.getFiles().length ;i++) {
			tempFile = new File(uploadPath + "/" + newFileNames.get(i) + "." + FilenameUtils.getExtension(fileNames[i]));
			//�����ǰ�ļ��Ǹ�Ŀ¼�����Ѵ��ڣ�����ɾ���ٴ���
			if (tempFile.isDirectory()||tempFile.exists()) {
				tempFile.delete();
				tempFile = new File(uploadPath + "/" + newFileNames.get(i) + "." + FilenameUtils.getExtension(fileNames[i]));
			}
			FileUtils.copyFile(adto.getFiles()[i], tempFile);
		}
	}
	
}
