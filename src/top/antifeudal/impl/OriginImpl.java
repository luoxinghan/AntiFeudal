package top.antifeudal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import top.antifeudal.dao.OriginDao;
import top.antifeudal.entity.Origin;
import top.antifeudal.util.DBUtil;

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
			ps.setInt(1, oid);
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
	public List<Origin> getAllNotDeleteOrigins(){
		List<Origin> origins = new ArrayList<Origin>();
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

}
