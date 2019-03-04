package top.antifeudal.entity;

import java.util.Date;

/**
 * @describe 用户管理对应的用户实体
 * @author luoxinghan
 * @date 2019/03/03
 * @version 1.0
 */
public class BUser {

	/** user id */
	private Integer id;
	
	private String roleName;
	
	private String account;
	
	private String userName;
	
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleId(String roleName) {
		this.roleName = roleName;
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

	public BUser() {
		super();
	}

	public BUser(Integer id, String roleName, String account, String userName, String phoneNumber,
			Byte isLock, Date createTime, Byte isDelete, String remark) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.account = account;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.isLock = isLock;
		this.createTime = createTime;
		this.isDelete = isDelete;
		this.remark = remark;
	}
}
