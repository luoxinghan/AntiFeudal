package top.antifeudal.entity;

public class BImageFile {

	private Integer id;
	
	private String fileName;
	
	private String fileDes;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private Double fileSize;
	
	private Byte isShow;

	public BImageFile() {
		super();
	}

	public BImageFile(Integer id, String fileName, String fileDes, String country, String state, String city, Double fileSize,
			Byte isShow) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileDes = fileDes;
		this.country = country;
		this.state = state;
		this.city = city;
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

	public String getFileDes() {
		return fileDes;
	}

	public void setFileDes(String fileDes) {
		this.fileDes = fileDes;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
