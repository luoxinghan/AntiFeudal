package top.antifeudal.dao;

import java.util.ArrayList;

import top.antifeudal.entity.BStory;
import top.antifeudal.entity.PageBean;
import top.antifeudal.entity.Story;

public interface StoryDao {
	
	/**
	 * @Title: addNewStory   
	 * @Description: TODO(新增一个故事)   
	 * @param: @param story
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean addNewStory(Story story);
	
	/**
	 * @Title: changeStoryState   
	 * @Description: TODO(根据id和改变状态修改story得状态，包括删除和恢复)   
	 * @param: @param id
	 * @param: @param s
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean changeStoryState(Integer id, Byte s);
	
	/**
	 * @Title: updateStory   
	 * @Description: TODO(更新一个故事)   
	 * @param: @param story
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean updateStory(Story story);
	
	/**
	 * @Title: getStoryById   
	 * @Description: TODO(根据一个id找到故事)   
	 * @param: @param sid
	 * @param: @return      
	 * @return: Story      
	 * @throws
	 */
	public Story getStoryById(Integer sid);
	
	/**
	 * @Title: getAllNotDeleteStories   
	 * @Description: TODO(获得所有未删除的故事)   
	 * @param: @return      
	 * @return: ArrayList<Story>      
	 * @throws
	 */
	public ArrayList<Story> getAllNotDeleteStories();
	
	/**
	 * @Title: getAllBackStories   
	 * @Description: TODO(后台故事管理)   
	 * @param: @param un
	 * @param: @param st
	 * @param: @param curPage
	 * @param: @param pageSize
	 * @param: @return      
	 * @return: PageBean<BStory>      
	 * @throws
	 */
	public PageBean<BStory> getAllBackStories(String un, String st, Integer curPage, Integer pageSize);
	
	/**
	 * @Title: getBackStorySize   
	 * @Description: TODO(获得故事的个数)   
	 * @param: @param un
	 * @param: @param st
	 * @param: @return      
	 * @return: Integer      
	 * @throws
	 */
	public Integer getBackStorySize(String un, String st);
}
