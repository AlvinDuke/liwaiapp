package top.duyt.dto;

import java.io.File;

public class AttachmentDto {

	private File[] files;
	private String[] filesName;
	private String[] filesContentType;

	public AttachmentDto() {
		super();
	}

	public AttachmentDto(File[] files, String[] filesName,
			String[] filesContentType) {
		super();
		this.files = files;
		this.filesName = filesName;
		this.filesContentType = filesContentType;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public String[] getFilesName() {
		return filesName;
	}

	public void setFilesName(String[] filesName) {
		this.filesName = filesName;
	}

	public String[] getFilesContentType() {
		return filesContentType;
	}

	public void setFilesContentType(String[] filesContentType) {
		this.filesContentType = filesContentType;
	}

}
