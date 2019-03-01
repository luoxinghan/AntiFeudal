package top.antifeudal.entity;

import java.util.Date;

/**
 * 前台展示内容，为了及时修改，使用从数据库读取的方式。
 * Title: FrontContent
 * Description: 
 * @author luoxinghan
 * @date 2019年2月25日 上午2:40:45
 *
 */
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
