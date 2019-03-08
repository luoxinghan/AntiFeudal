package top.antifeudal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import top.antifeudal.dao.OriginDao;
import top.antifeudal.entity.BOrigin;
import top.antifeudal.entity.Origin;
import top.antifeudal.entity.PageBean;
import top.antifeudal.util.DBUtil;
import top.antifeudal.util.StringUtil;

public class OriginImpl implements OriginDao {

	@Override
	public Boolean addNewOrigin(Origin origin) {
		String sql = "INSERT into sys_origin(user_id, country, state, city, street, display_priority, create_time, is_delete, remark) VALUES(?,?,?,?,?,?,?,?,?);";
		Connection connection = DBUtil.open();
		System.out.println("=====>>" + sql);
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, origin.getUserId());
			pstm.setString(2, origin.getCountry());
			pstm.setString(3, origin.getState());
			pstm.setString(4, origin.getCity());
			pstm.setString(5, origin.getStreet());
			pstm.setByte(6, origin.getDisplayPriority());
			pstm.setTimestamp(7, new Timestamp(origin.getCreateTime().getTime()));
			pstm.setByte(8, origin.getIsDelete());
			pstm.setString(9, origin.getRemark());
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
	public Boolean deleteOriginById(Integer id) {
		String sql = "UPDATE sys_origin SET is_delete = 1 WHERE id = ?;";
		Connection connection = DBUtil.open();
		System.out.println("=====>>" + sql);
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, id);
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
	public Boolean changeOriginState(Integer id, Byte s) {
		String sql = "UPDATE sys_origin SET is_delete = ? WHERE id = ?;";
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
	public Boolean updateOrigin(Origin origin) {
		String sql = "UPDATE sys_origin SET user_id = ?,country = ?,state=?,city=?,street=?,display_priority=?,create_time=?, is_delete = ?,remark=? WHERE id = ?;";
		Connection connection = DBUtil.open();
		System.out.println("=====>>" + sql);
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, origin.getUserId());
			pstm.setString(2, origin.getCountry());
			pstm.setString(3, origin.getState());
			pstm.setString(4, origin.getCity());
			pstm.setString(5, origin.getStreet());
			pstm.setByte(6, origin.getDisplayPriority());
			pstm.setTimestamp(7, new Timestamp(origin.getCreateTime().getTime()));
			pstm.setByte(8, origin.getIsDelete());
			pstm.setString(9, origin.getRemark());
			pstm.setInt(10, origin.getId());
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
	public Origin getOriginById(Integer oid) {
		String sql = "SELECT * FROM sys_origin WHERE id = " + oid + " AND is_delete = 0;";
		System.out.println("<<=====" + sql);
		Origin origin = new Origin();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				origin.setId(rs.getInt(1));
				origin.setUserId(rs.getInt(2));
				origin.setCountry(rs.getString(3));
				origin.setState(rs.getString(4));
				origin.setCity(rs.getString(5));
				origin.setStreet(rs.getString(6));
				origin.setDisplayPriority(rs.getByte(7));
				Timestamp t = rs.getTimestamp(8);
			    origin.setCreateTime(t);
			    origin.setIsDelete(rs.getByte(9));
			    origin.setRemark(rs.getString(10));
			}
			return origin;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(connection);
		}
	}
	
	@Override
	public ArrayList<Origin> getAllNotDeleteOrigins(){
		ArrayList<Origin> origins = new ArrayList<Origin>();
        String sql = "SELECT * FROM sys_origin WHERE is_delete = 0 ORDER BY display_priority ASC;";
        Connection connection = DBUtil.open();
        try {
        	PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
            	Origin origin = new Origin();

            	origin.setId(rs.getInt(1));
				origin.setUserId(rs.getInt(2));
				origin.setCountry(rs.getString(3));
				origin.setState(rs.getString(4));
				origin.setCity(rs.getString(5));
				origin.setStreet(rs.getString(6));
				origin.setDisplayPriority(rs.getByte(7));
				Timestamp t = rs.getTimestamp(8);
			    origin.setCreateTime(t);
			    origin.setIsDelete(rs.getByte(9));
			    origin.setRemark(rs.getString(10));
                origins.add(origin);
            }
            
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
        return origins;
	}
	
	@Override
	public ArrayList<BOrigin> getAllEffectiveOrigins(){
		ArrayList<BOrigin> origins = new ArrayList<BOrigin>();
        String sql = "SELECT o.id, u.user_name, o.country, o.state, o.city, o.street, o.display_priority, o.is_delete FROM sys_origin AS o, sys_user AS u WHERE o.user_id = u.id AND o.is_delete = 0 ORDER BY user_id, display_priority ASC;";
        Connection connection = DBUtil.open();
        try {
        	PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
            	BOrigin origin = new BOrigin();
            	origin.setId(rs.getInt(1));
				origin.setUserName(rs.getString(2));
				origin.setCountry(rs.getString(3));
				origin.setState(StringUtil.emptyOrNull(rs.getString(4)));
				origin.setCity(StringUtil.emptyOrNull(rs.getString(5)));
				origin.setStreet(StringUtil.emptyOrNull(rs.getString(6)));
				origin.setDisplayPriority(rs.getByte(7));
			    origin.setIsDelete(rs.getByte(8));
                origins.add(origin);
            }
            
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
        return origins;
	}
	
	@Override
	public Integer getBackOriginSize(String un, String cty) {
		String sql = "SELECT COUNT(*) FROM sys_origin AS o, sys_user AS u "
				+ "WHERE o.user_id = u.id AND u.user_name LIKE '%" + un + "%' AND o.country "
				+ "LIKE '%" + cty + "%' ORDER BY display_priority ASC;";
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
	public PageBean<BOrigin> getAllBackOrigins(String un, String cty, Integer curPage, Integer pageSize) {
		ArrayList<BOrigin> origins = new ArrayList<BOrigin>();
		PageBean<BOrigin> page = new PageBean<BOrigin>(this.getBackOriginSize(un, cty), pageSize);
		page.setCurPage(curPage);
        String sql = "SELECT o.id, u.user_name, o.country, o.state, o.city, o.street, o.display_priority, "
        		+ "o.is_delete FROM sys_origin AS o, sys_user AS u WHERE o.user_id = u.id AND "
        		+ "u.user_name LIKE '%" + un + "%' AND o.country LIKE '%" + cty + "%' "
        		+ "ORDER BY user_id, display_priority ASC LIMIT " + page.getStartIndex() + ", " + page.getPageSize() + ";";
        Connection connection = DBUtil.open();
        System.out.println("<<=====" + sql);
        try {
        	PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
            	BOrigin origin = new BOrigin();
            	origin.setId(rs.getInt(1));
				origin.setUserName(rs.getString(2));
				origin.setCountry(rs.getString(3));
				origin.setState(StringUtil.emptyOrNull(rs.getString(4)));
				origin.setCity(StringUtil.emptyOrNull(rs.getString(5)));
				origin.setStreet(StringUtil.emptyOrNull(rs.getString(6)));
				origin.setDisplayPriority(rs.getByte(7));
			    origin.setIsDelete(rs.getByte(8));
                origins.add(origin);
            }
            page.setList(origins);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
        return page;
	}

}
