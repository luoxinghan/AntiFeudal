package top.antifeudal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import top.antifeudal.dao.FrontContentDao;
import top.antifeudal.entity.FrontContent;
import top.antifeudal.util.DBUtil;

public class FrontContentImpl implements FrontContentDao{

	@Override
	public FrontContent getFrontContentById(Integer fcid) {
		String sql = "SELECT * FROM sys_front_content sfc WHERE "
				+ "sfc.id = '" + fcid + "' AND sfc.is_delete = 0;";
		System.out.println("<<=====" + sql);
		ArrayList<FrontContent> list = new ArrayList<FrontContent>();
		Connection connection = DBUtil.open();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Integer id = rs.getInt(1);
				String jspName = rs.getString(2);
				String divName = rs.getString(3);
				String content = rs.getString(4);
				Date createTime = rs.getTimestamp(5);
				Byte isDelete = rs.getByte(6);
				String remark = rs.getString(7);
				
				FrontContent frontContent = new FrontContent(id, jspName, divName, content, createTime, isDelete, remark);
				list.add(frontContent);
			}
			return list != null ? list.get(0) : null;
		} catch(Exception e) {
			e.printStackTrace();
			return list != null ? list.get(0) : null;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public FrontContent getByJspAndDivName(String fcjspName, String fcdivName) {
		String sql = "SELECT * FROM sys_front_content sfc WHERE "
				+ "sfc.jsp_name = '"+ fcjspName +"' AND sfc.div_name = '" + fcdivName +"' AND sfc.is_delete = 0;";
		System.out.println("<<=====" + sql);
		ArrayList<FrontContent> list = new ArrayList<FrontContent>();
		Connection connection = DBUtil.open();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Integer id = rs.getInt(1);
				String jspName = rs.getString(2);
				String divName = rs.getString(3);
				String content = rs.getString(4);
				Date createTime = rs.getTimestamp(5);
				Byte isDelete = rs.getByte(6);
				String remark = rs.getString(7);
				
				FrontContent frontContent = new FrontContent(id, jspName, divName, content, createTime, isDelete, remark);
				list.add(frontContent);
			}
			return list != null ? list.get(0) : null;
		} catch(Exception e) {
			e.printStackTrace();
			return list != null ? list.get(0) : null;
		} finally {
			DBUtil.close(connection);
		}
	}

}
