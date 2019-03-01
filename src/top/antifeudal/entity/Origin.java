package top.antifeudal.entity;

import java.util.Date;

/**
 * 照片地区设置，每张照片上传的时候需要选择地区，上传后进行展示。
 * Title: Origin
 * Description: 
 * @author luoxinghan
 * @date 2019年2月25日 上午2:41:45
 *
 */
public class Origin {

	private Integer id;
	
	private Integer userId;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String street;
	
	private Byte displayPriority;
	
	private Date createTime;
	
	private Byte isDelete;
	
	private String remark;

	public Origin() {
		super();
	}

	public Origin(Integer id, Integer userId, String country, String state, String city, String street,
			Byte displayPriority, Date createTime, Byte isDelete, String remark) {
		super();
		this.id = id;
		this.userId = userId;
		this.country = country;
		this.state = state;
		this.city = city;
		this.street = street;
		this.displayPriority = displayPriority;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Byte getDisplayPriority() {
		return displayPriority;
	}

	public void setDisplayPriority(Byte displayPriority) {
		this.displayPriority = displayPriority;
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
