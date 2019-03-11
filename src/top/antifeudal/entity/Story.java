package top.antifeudal.entity;

import java.util.Date;

/**
 * Title: Story
 * Description: 文章表对应故事类
 * @author luoxinghan
 * @date 2019年3月11日 上午4:51:56
 *
 */
public class Story {
	
	private Integer id;
	
	private Integer userId;
	
	private String articleTitle;
	
	private String articleContent;
	
	private String articleDes;
	
	private Date createTime;
	
	private Date updateTime;
	
	private Byte isDelete;

	public Story() {
		super();
	}

	public Story(Integer id, Integer userId, String articleTitle, String articleContent, String articleDes,
			Date createTime, Date updateTime, Byte isDelete) {
		super();
		this.id = id;
		this.userId = userId;
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
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
