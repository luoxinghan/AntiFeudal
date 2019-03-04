package top.antifeudal.entity;

public class BImageFile {

	private Integer id;
	
	private String fileName;
	
	private String country;
	
	private String userName;
	
	private String fileExt;
	
	private Double fileSize;
	
	private Byte isShow;

	public BImageFile() {
		super();
	}

	public BImageFile(Integer id, String fileName, String country, String userName, String fileExt, Double fileSize,
			Byte isShow) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.country = country;
		this.userName = userName;
		this.fileExt = fileExt;
		this.fileSize = fileSize;
		this.isShow = isShow;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
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
}
