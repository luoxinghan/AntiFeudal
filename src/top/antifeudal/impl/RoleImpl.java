package top.antifeudal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import top.antifeudal.dao.RoleDao;
import top.antifeudal.entity.PageBean;
import top.antifeudal.entity.Role;
import top.antifeudal.util.DBUtil;

public class RoleImpl implements RoleDao {

	@Override
	public Role getRoleById(Integer rid) {
		String sql = "SELECT * FROM sys_role WHERE id = " + rid + " AND is_delete = 0;";
		System.out.println("<<=====" + sql);
		Role role = new Role();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				role.setId(rs.getInt(1));
				role.setRoleName(rs.getString(2));
				Timestamp t = rs.getTimestamp(3);
				role.setCreateTime(t);
				role.setIsDelete(rs.getByte(4));
				role.setRemark(rs.getString(5));
			}
			return role;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public ArrayList<Role> getAllNotDeleteRoles() {
		ArrayList<Role> roles = new ArrayList<Role>();
        String sql = "SELECT * FROM sys_role WHERE is_delete = 0;";
        System.out.println("<<=====" + sql);
        Connection connection = DBUtil.open();
        try {
        	PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
            	Role role = new Role();

            	role.setId(rs.getInt(1));
				role.setRoleName(rs.getString(2));
				Timestamp t = rs.getTimestamp(3);
				role.setCreateTime(t);
				role.setIsDelete(rs.getByte(4));
				role.setRemark(rs.getString(5));
                roles.add(role);
            }
            
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
        return roles;
	}

	@Override
	public PageBean<Role> getAllRoles(String rn, Integer curPage, Integer pageSize) {
		ArrayList<Role> roles = new ArrayList<Role>();
		PageBean<Role> page = new PageBean<Role>(this.getBackRoleSize(rn), pageSize);
		page.setCurPage(curPage);
        String sql = "SELECT * FROM sys_role WHERE is_delete = 0 AND role_name LIKE '%" + rn + "%' LIMIT " + page.getStartIndex() + ", " + page.getPageSize() + ";";
        Connection connection = DBUtil.open();
        System.out.println("<<=====" + sql);
        try {
        	PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
            	Role role = new Role();
            	role.setId(rs.getInt(1));
				role.setRoleName(rs.getString(2));
				Timestamp t = rs.getTimestamp(3);
				role.setCreateTime(t);
				role.setIsDelete(rs.getByte(4));
				role.setRemark(rs.getString(5));
                roles.add(role);
            }
            page.setList(roles);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
        return page;
	}

	@Override
	public Integer getBackRoleSize(String rn) {
		String sql = "SELECT * FROM sys_role WHERE is_delete = 0 AND role_name LIKE '%" + rn + "%';";
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
	public Boolean addNewRole(Role role) {
		String sql = "INSERT into sys_role(role_name, create_time, is_delete, remark) VALUES(?,?,?,?);";
		Connection connection = DBUtil.open();
		System.out.println("=====>>" + sql);
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, role.getRoleName());
			pstm.setTimestamp(2, new Timestamp(role.getCreateTime().getTime()));
			pstm.setByte(3, role.getIsDelete());
			pstm.setString(4, role.getRemark());
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
	public Boolean deleteRoleById(Integer id, Byte s) {
		String sql = "UPDATE sys_role SET is_delete = ? WHERE id = ?;";
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
	public Boolean updateRole(Role role) {
		String sql = "UPDATE sys_role SET role_name = ?, create_time=?, is_delete = ?,remark=? WHERE id = ?;";
		Connection connection = DBUtil.open();
		System.out.println("=====>>" + sql);
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, role.getRoleName());
			pstm.setTimestamp(2, new Timestamp(role.getCreateTime().getTime()));
			pstm.setByte(3, role.getIsDelete());
			pstm.setString(4, role.getRemark());
			pstm.setInt(5, role.getId());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
	}
}
