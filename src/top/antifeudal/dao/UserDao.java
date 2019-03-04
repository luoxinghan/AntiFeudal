package top.antifeudal.dao;

import java.util.ArrayList;

import top.antifeudal.entity.BUser;
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
	 * @Title: findAllBackUsers   
	 * @Description: TODO(后台管理获取用户)      
	 * @return: ArrayList<User>      
	 * @throws
	 */
	public ArrayList<BUser> findAllBackUsers(String userName, String telephone);
	
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
	 * 根据可登录的信息查找用户
	 * @param str
	 * @return
	 */
	public User findByInfo(String str);
}
