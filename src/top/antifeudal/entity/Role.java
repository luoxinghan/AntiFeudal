package top.antifeudal.entity;

import java.util.Date;

public class Role {
	
	private Integer id;
	
	private String roleName;
	
	private Date createTime;
	
	private Byte isDelete;
	
	private String remark;

	public Role() {
		super();
	}

	public Role(Integer id, String roleName, Date createTime, Byte isDelete, String remark) {
		super();
		this.id = id;
		this.roleName = roleName;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
