package top.antifeudal.entity;

import java.util.Date;

public class User {

	private Integer id;
	
	private Integer roleId;
	
	private String account;
	
	private String userName;
	
	private String password;
	
	private String phoneNumber;
	
	private Byte isLock;
	
	private Date createTime;
	
	private Byte isDelete;
	
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Byte getIsLock() {
		return isLock;
	}

	public void setIsLock(Byte isLock) {
		this.isLock = isLock;
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

	public User() {
		super();
	}

	public User(Integer id, Integer roleId, String account, String userName, String password, String phoneNumber,
			Byte isLock, Date createTime, Byte isDelete, String remark) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.account = account;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.isLock = isLock;
		this.createTime = createTime;
		this.isDelete = isDelete;
		this.remark = remark;
	}
}
