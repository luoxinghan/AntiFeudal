package top.antifeudal.dao;

import java.util.ArrayList;

import top.antifeudal.entity.BUser;
import top.antifeudal.entity.PageBean;
import top.antifeudal.entity.User;

/**
 * 用户信息
 * @author lxh
 * @date 2018.10.09
 * 
 */
public interface UserDao {
	
	/**
	 * 找到所有未锁的用户
	 * @return
	 */
	public ArrayList<User> findValidUser();
	
	/**
	 * @Title: findAllUser   
	 * @Description: TODO(获取所有的用户)        
	 * @return: ArrayList<User>      
	 * @throws
	 */
	public ArrayList<User> findAllUser();
	
	/**
	 * 添加一个新的用户
	 * @return
	 */
	public Boolean addNewUser();
	
	/**
	 * @Title: getBackUserSize   
	 * @Description: TODO(获取所有用户)   
	 * @param: @param userName
	 * @param: @param telephone
	 * @param: @return      
	 * @return: Integer      
	 * @throws
	 */
	public Integer getBackUserSize(String userName, String telephone);
	
	/**
	 * @Title: findAllBackUsers   
	 * @Description: TODO(后台管理获取用户)      
	 * @return: ArrayList<User>      
	 * @throws
	 */
	public PageBean<BUser> getAllBackUsers(String userName, String telephone, Integer curPage, Integer pageSize);
	
	/**
	 * 根据用户id删除用户
	 * @param id
	 * @return
	 */
	public Boolean deleteById(int id);
	
	/**
	 * 更改一个用户的所有信息
	 * @param user
	 * @return
	 */
	public Boolean updateUser(User user);
	
	/***
	 * 根据用户Id查找用户
	 * @param id
	 * @return
	 */
	public User findById(int id);
	
	/**
	 * @Title: changeUserState   
	 * @Description: TODO(改变用户是否锁定状态)   
	 * @param: @param id
	 * @param: @param s
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean changeUserState(Integer id, Byte s);
	
	/**
	 * 根据可登录的信息查找用户
	 * @param str
	 * @return
	 */
	public User findByInfo(String str);
}
