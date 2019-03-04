package top.antifeudal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import top.antifeudal.dao.UserDao;
import top.antifeudal.entity.BUser;
import top.antifeudal.entity.User;
import top.antifeudal.util.DBUtil;

public class UserImpl implements UserDao{

	@Override
	public ArrayList<User> findValidUser() {
		String sql = "SELECT * FROM sys_user u WHERE u.is_lock = 0 AND u.is_delete = 0";
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
	
	@Override
	public ArrayList<BUser> findAllBackUsers(String um, String telephone) {
		String sql = "SELECT u.id, r.role_name, u.account, u.user_name, u.phone_number, u.is_lock, "
				+ "u.create_time, u.is_delete, u.remark FROM sys_user u, sys_role r "
				+ "WHERE u.role_id = r.id AND u.user_name LIKE '%" + um + "%' AND u.phone_number LIKE '%" + telephone +"%';";
		System.out.println("<<=====" + sql);
		ArrayList<BUser> userList = new ArrayList<BUser>();
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
			return userList;
		} catch(Exception e) {
			e.printStackTrace();
			return userList;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
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
