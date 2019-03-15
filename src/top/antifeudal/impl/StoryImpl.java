package top.antifeudal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import top.antifeudal.dao.StoryDao;
import top.antifeudal.entity.BStory;
import top.antifeudal.entity.PageBean;
import top.antifeudal.entity.Story;
import top.antifeudal.util.DBUtil;
import top.antifeudal.util.StringUtil;

public class StoryImpl implements StoryDao {

	@Override
	public Boolean addNewStory(Story story) {
		String sql = "INSERT into sys_article(user_id, article_title, article_content, article_des, create_time, update_time, is_delete) VALUES(?,?,?,?,?,?,?);";
		Connection connection = DBUtil.open();
		System.out.println("=====>>" + sql);
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, story.getUserId());
			pstm.setString(2, story.getArticleTitle());
			pstm.setString(3, story.getArticleContent());
			pstm.setString(4, story.getArticleDes());
			pstm.setTimestamp(5, new Timestamp(story.getCreateTime().getTime()));
			pstm.setTimestamp(6, new Timestamp(story.getUpdateTime().getTime()));
			pstm.setByte(7, story.getIsDelete());
			pstm.executeUpdate();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Boolean changeStoryState(Integer id, Byte s) {
		String sql = "UPDATE sys_article SET is_delete = ? WHERE id = ?;";
		Connection connection = DBUtil.open();
		System.out.println("=====>>" + sql);
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setByte(1, s);
			pstm.setInt(2, id);
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Boolean updateStory(Story story) {
		String sql = "UPDATE sys_article SET user_id = ?,article_title = ?,article_content=?,article_des=?,create_time=?,update_time=?,is_delete = ? WHERE id = ?;";
		Connection connection = DBUtil.open();
		System.out.println("=====>>" + sql);
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, story.getUserId());
			pstm.setString(2, story.getArticleTitle());
			pstm.setString(3, story.getArticleContent());
			pstm.setString(4, story.getArticleDes());
			pstm.setTimestamp(5, new Timestamp(story.getCreateTime().getTime()));
			pstm.setTimestamp(6, new Timestamp(story.getUpdateTime().getTime()));
			pstm.setByte(7, story.getIsDelete());
			pstm.setInt(8, story.getId());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Story getStoryById(Integer sid) {
		String sql = "SELECT * FROM sys_article WHERE id = " + sid + " AND is_delete = 0;";
		System.out.println("<<=====" + sql);
		Story story = new Story();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				story.setId(rs.getInt(1));
				story.setUserId(rs.getInt(2));
				story.setArticleTitle(rs.getString(3));
				story.setArticleContent(rs.getString(4));
				story.setArticleDes(rs.getString(5));
				story.setCreateTime(rs.getTimestamp(6));
				story.setUpdateTime(rs.getTimestamp(7));
				story.setIsDelete(rs.getByte(8));
			}
			return story;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(connection);
		}
	}
	

	@Override
	public BStory getBackStoryById(Integer sid) {
		String sql = "SELECT a.id, u.user_name, a.article_title,a.article_content, a.article_des, a.create_time, "
				+ "a.update_time, a.is_delete FROM sys_user u, sys_article a "
				+ "WHERE a.user_id = u.id AND a.is_delete = 0 AND a.id = " + sid + ";";
		System.out.println("<<=====" + sql);
		BStory bStory = new BStory();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bStory.setId(rs.getInt(1));
            	bStory.setUserName(rs.getString(2));
            	bStory.setArticleTitle(rs.getString(3));
            	bStory.setArticleContent(rs.getString(4));
            	bStory.setArticleDes(StringUtil.emptyOrNull(rs.getString(5)));
            	bStory.setCreateTime(rs.getTimestamp(6));
            	bStory.setUpdateTime(rs.getTimestamp(7));
            	bStory.setIsDelete(rs.getByte(8));
			}
			return bStory;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(connection);
		}
	}


	@Override
	public ArrayList<Story> getAllNotDeleteStories() {
		ArrayList<Story> stories = new ArrayList<Story>();
        String sql = "SELECT * FROM sys_article WHERE is_delete = 0 ORDER BY update_time DESC;";
        System.out.println("<<=====" + sql);
        Connection connection = DBUtil.open();
        try {
        	PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
            	Story story = new Story();

            	story.setId(rs.getInt(1));
				story.setUserId(rs.getInt(2));
				story.setArticleTitle(rs.getString(3));
				story.setArticleContent(rs.getString(4));
				story.setArticleDes(rs.getString(5));
				story.setCreateTime(rs.getTimestamp(6));
				story.setUpdateTime(rs.getTimestamp(7));
				story.setIsDelete(rs.getByte(8));
                stories.add(story);
            }
            
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
        return stories;
	}

	@Override
	public PageBean<BStory> getAllBackStories(String un, String st, Integer curPage, Integer pageSize) {
		ArrayList<BStory> stories = new ArrayList<BStory>();
		PageBean<BStory> page = new PageBean<BStory>(this.getBackStorySize(un, st), pageSize);
		page.setCurPage(curPage);
        String sql = "SELECT a.id, u.user_name, a.article_title, a.article_content, a.article_des, a.create_time, a.update_time, a.is_delete "
        		+ "FROM sys_user AS u, sys_article AS a WHERE a.user_id = u.id AND "
        		+ "u.user_name LIKE '%" + un + "%' AND a.article_title LIKE '%" + st + "%' "
        		+ "ORDER BY update_time DESC LIMIT " + page.getStartIndex() + ", " + page.getPageSize() + ";";
        Connection connection = DBUtil.open();
        System.out.println("<<=====" + sql);
        try {
        	PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
            	BStory bStory = new BStory();
            	bStory.setId(rs.getInt(1));
            	bStory.setUserName(rs.getString(2));
            	bStory.setArticleTitle(rs.getString(3));
            	bStory.setArticleContent(rs.getString(4));
            	bStory.setArticleDes(StringUtil.emptyOrNull(rs.getString(5)));
            	bStory.setCreateTime(rs.getTimestamp(6));
            	bStory.setUpdateTime(rs.getTimestamp(7));
            	bStory.setIsDelete(rs.getByte(8));
                stories.add(bStory);
            }
            page.setList(stories);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
        return page;
	}

	@Override
	public Integer getBackStorySize(String un, String st) {
		String sql = "SELECT COUNT(*) FROM sys_article AS a, sys_user AS u "
				+ "WHERE a.user_id = u.id AND u.user_name LIKE '%" + un + "%' AND a.article_title "
				+ "LIKE '%" + st + "%' ORDER BY update_time DESC;";
		Integer count = 0;
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				count = rs.getInt(1);
			}
			return count;
		} catch(Exception e) {
			e.printStackTrace();
			return count;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public ArrayList<BStory> getLastStories(Integer size) {
		ArrayList<BStory> stories = new ArrayList<BStory>();
        String sql = "SELECT a.id, u.user_name, a.article_title, a.article_content, a.article_des, a.create_time, a.update_time, a.is_delete "
        		+ "FROM sys_user AS u, sys_article AS a WHERE a.user_id = u.id AND a.is_delete = 0 "
        		+ "ORDER BY update_time DESC LIMIT 0, " + size + ";";
        Connection connection = DBUtil.open();
        System.out.println("<<=====" + sql);
        try {
        	PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
            	BStory bStory = new BStory();
            	bStory.setId(rs.getInt(1));
            	bStory.setUserName(rs.getString(2));
            	bStory.setArticleTitle(rs.getString(3));
            	bStory.setArticleContent(rs.getString(4));
            	bStory.setArticleDes(StringUtil.emptyOrNull(rs.getString(5)));
            	bStory.setCreateTime(rs.getTimestamp(6));
            	bStory.setUpdateTime(rs.getTimestamp(7));
            	bStory.setIsDelete(rs.getByte(8));
                stories.add(bStory);
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
        return stories;
	}
}
