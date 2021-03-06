package top.antifeudal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import top.antifeudal.dao.UserDao;
import top.antifeudal.entity.BUser;
import top.antifeudal.entity.PageBean;
import top.antifeudal.entity.User;
import top.antifeudal.util.DBUtil;
import top.antifeudal.util.StringUtil;

public class UserImpl implements UserDao{

	@Override
	public ArrayList<User> findValidUser() {
		String sql = "SELECT * FROM sys_user u WHERE u.is_lock = 0 AND u.is_delete = 0;";
		System.out.println("<<=====" + sql);
		ArrayList<User> userList = new ArrayList<User>();
		Connection connection = DBUtil.open();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Integer id = rs.getInt(1);
				Integer roleId = rs.getInt(2);
				String account = rs.getString(3);
				String userName = rs.getString(4);
				String password = rs.getString(5);
				String phoneNumber = rs.getString(6);
				Byte isLock = rs.getByte(7);
				Date createTime = rs.getTimestamp(8);
				Byte isDelete = rs.getByte(9);
				String remark = rs.getString(10);
				
				User user = new User(id, roleId, account, userName, password, phoneNumber, isLock, createTime, isDelete, remark);
				userList.add(user);
			}
			return userList;
		} catch(Exception e) {
			e.printStackTrace();
			return userList;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public ArrayList<User> findAllUser() {
		String sql = "SELECT * FROM sys_user u";
		System.out.println("<<=====" + sql);
		ArrayList<User> userList = new ArrayList<User>();
		Connection connection = DBUtil.open();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Integer id = rs.getInt(1);
				Integer roleId = rs.getInt(2);
				String account = rs.getString(3);
				String userName = rs.getString(4);
				String password = rs.getString(5);
				String phoneNumber = rs.getString(6);
				Byte isLock = rs.getByte(7);
				Date createTime = rs.getTimestamp(8);
				Byte isDelete = rs.getByte(9);
				String remark = rs.getString(10);
				
				User user = new User(id, roleId, account, userName, password, phoneNumber, isLock, createTime, isDelete, remark);
				userList.add(user);
			}
			return userList;
		} catch(Exception e) {
			e.printStackTrace();
			return userList;
		} finally {
			DBUtil.close(connection);
		}
	}
	
	public Integer getBackUserSize(String userName, String telephone) {
		String sql = "SELECT COUNT(*) FROM sys_user u, sys_role r "
				+ "WHERE u.role_id = r.id AND u.user_name LIKE '%" + userName + "%' AND u.phone_number "
				+ "LIKE '%" + telephone +"%';";
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
	public PageBean<BUser> getAllBackUsers(String um, String tp, Integer curPage, Integer pageSize) {
		ArrayList<BUser> userList = new ArrayList<BUser>();
		PageBean<BUser> page = new PageBean<BUser>(this.getBackUserSize(um, tp), pageSize);
		page.setCurPage(curPage);
		String sql = "SELECT u.id, r.role_name, u.account, u.user_name, u.phone_number, u.is_lock, "
				+ "u.create_time, u.is_delete, u.remark FROM sys_user u, sys_role r "
				+ "WHERE u.role_id = r.id AND u.user_name LIKE '%" + um + "%' AND u.phone_number "
				+ "LIKE '%" + tp +"%'LIMIT " + page.getStartIndex() + ", " + page.getPageSize() + ";";
		System.out.println("<<=====" + sql);
		
		Connection connection = DBUtil.open();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Integer id = rs.getInt(1);
				String roleName = rs.getString(2);
				String account = rs.getString(3);
				String userName = rs.getString(4);
				String phoneNumber = rs.getString(5);
				Byte isLock = rs.getByte(6);
				Date createTime = rs.getTimestamp(7);
				Byte isDelete = rs.getByte(8);
				String remark = rs.getString(9);
				
				BUser bUser = new BUser(id, roleName, account, userName, phoneNumber, isLock, createTime, isDelete, remark);
				userList.add(bUser);
			}
			page.setList(userList);
			return page;
		} catch(Exception e) {
			e.printStackTrace();
			return page;
		} finally {
			DBUtil.close(connection);
		}
	}
	
	@Override
	public Boolean addNewUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateUser(User user) {
		String sql = "UPDATE sys_user SET role_id = ?,account = ?,user_name=?,password=?,phone_number=?,is_lock=?,create_time=?, is_delete = ?,remark=? WHERE id = ?;";
		Connection connection = DBUtil.open();
		System.out.println("=====>>" + sql);
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, user.getRoleId());
			pstm.setString(2, user.getAccount());
			pstm.setString(3, user.getUserName());
			pstm.setString(4, user.getPassword());
			pstm.setString(5, user.getPhoneNumber());
			pstm.setByte(6, user.getIsLock());
			pstm.setTimestamp(7, new Timestamp(user.getCreateTime().getTime()));
			pstm.setByte(8, user.getIsDelete());
			pstm.setString(9, user.getRemark());
			pstm.setInt(10, user.getId());
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
	public Boolean changeUserState(Integer id, Byte s) {
		String sql = "UPDATE sys_user SET is_lock = ? WHERE id = ?;";
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
	public User findById(int uId) {
		String sql = "SELECT * FROM sys_user WHERE id = " + uId + " AND is_lock = 0 AND is_delete = 0;";
		System.out.println("<<=====" + sql);
		User user = new User();
		Connection connection = DBUtil.open();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Integer id = rs.getInt(1);
				Integer roleId = rs.getInt(2);
				String account = rs.getString(3);
				String userName = rs.getString(4);
				String password = rs.getString(5);
				String phoneNumber = rs.getString(6);
				Byte isLock = rs.getByte(7);
				Date createTime = rs.getTimestamp(8);
				Byte isDelete = rs.getByte(9);
				String remark = StringUtil.emptyOrNull(rs.getString(10));
				
				user = new User(id, roleId, account, userName, password, phoneNumber, isLock, createTime, isDelete, remark);
			}
			return user;
		} catch(Exception e) {
			e.printStackTrace();
			return user;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public User findByInfo(String str) {
		String sql = "SELECT * FROM (SELECT * FROM sys_user u "
				+ "WHERE u.account = '" + str + "' OR u.phone_number = '" + str + "' OR u.user_name = '" + str + "' ) "
				+ "us WHERE us.is_lock = 0 AND us.is_delete = 0;";
		System.out.println("<<=====" + sql);
		ArrayList<User> userList = new ArrayList<User>();
		Connection connection = DBUtil.open();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Integer id = rs.getInt(1);
				Integer roleId = rs.getInt(2);
				String account = rs.getString(3);
				String userName = rs.getString(4);
				String password = rs.getString(5);
				String phoneNumber = rs.getString(6);
				Byte isLock = rs.getByte(7);
				Date createTime = rs.getTimestamp(8);
				Byte isDelete = rs.getByte(9);
				String remark = rs.getString(10);
				
				User user = new User(id, roleId, account, userName, password, phoneNumber, isLock, createTime, isDelete, remark);
				userList.add(user);
			}
			return userList.size() > 0 ? userList.get(0) : null;
		} catch(Exception e) {
			e.printStackTrace();
			return userList.size() > 0 ? userList.get(0) : null;
		} finally {
			DBUtil.close(connection);
		}
	}

}
