package top.antifeudal.entity;

import java.util.Date;

/**
 * Title: BStory
 * Description: 文章管理所需要的后台类
 * @author luoxinghan
 * @date 2019年3月11日 上午4:54:14
 *
 */
public class BStory {
	
	private Integer id;
	
	private String userName;
	
	private String articleTitle;
	
	private String articleDes;
	
	private Date createTime;
	
	private Date updateTime;
	
	private Byte isDelete;

	public BStory() {
		super();
	}

	public BStory(Integer id, String userName, String articleTitle, String articleDes, Date createTime, Date updateTime, Byte isDelete) {
		super();
		this.id = id;
		this.userName = userName;
		this.articleTitle = articleTitle;
		this.articleDes = articleDes;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isDelete = isDelete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleDes() {
		return articleDes;
	}

	public void setArticleDes(String articleDes) {
		this.articleDes = articleDes;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}
}
