package top.antifeudal.entity;

import java.util.Date;

public class FrontContent {
	
	private Integer id;
	
	private String jspName;
	
	private String divName;
	
	private String content;
	
	private Date createTime;
	
	private Byte isDelete;
	
	private String remark;

	public FrontContent() {
		super();
	}

	public FrontContent(Integer id, String jspName, String divName, String content, Date createTime, Byte isDelete,
			String remark) {
		super();
		this.id = id;
		this.jspName = jspName;
		this.divName = divName;
		this.content = content;
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

	public String getJspName() {
		return jspName;
	}

	public void setJspName(String jspName) {
		this.jspName = jspName;
	}

	public String getDivName() {
		return divName;
	}

	public void setDivName(String divName) {
		this.divName = divName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
