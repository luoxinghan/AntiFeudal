package top.antifeudal.entity;

import java.util.Date;

/**
 * @describe 文件表对应的文件实体，用于存储上传文件的信息。
 * @author luoxinghan
 * @date 2018/12/08
 * @version 1.0
 */
public class ImageFile {
	
	private Integer id;
	
	private String fileName;
	
	private String fileExt;
	
	private String filePath;
	
	private String fileDescribe;
	
	private Double fileSize;
	
	private Byte isShow;
	
	private Date createTime;
	
	private Byte isDelete;
	
	private String remark;
	
	public ImageFile() {
		super();
	}
	
	public ImageFile(Integer id, String fileName, String fileExt, String filePath,String fileDescribe, Double fileSize, Byte isShow,
			Date createTime, Byte isDelete, String remark) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileExt = fileExt;
		this.filePath = filePath;
		this.fileDescribe = fileDescribe;
		this.fileSize = fileSize;
		this.isShow = isShow;
		this.createTime = createTime;
		this.isDelete = isDelete;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileDescribe() {
		return fileDescribe;
	}

	public void setFileDescribe(String fileDescribe) {
		this.fileDescribe = fileDescribe;
	}

	public Double getFileSize() {
		return fileSize;
	}

	public void setFileSize(Double fileSize) {
		this.fileSize = fileSize;
	}

	public Byte getIsShow() {
		return isShow;
	}

	public void setIsShow(Byte isShow) {
		this.isShow = isShow;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
