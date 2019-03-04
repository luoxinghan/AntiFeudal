package top.antifeudal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


import top.antifeudal.dao.ImageFileGetDao;
import top.antifeudal.entity.BImageFile;
import top.antifeudal.entity.ImageFile;
import top.antifeudal.util.DBUtil;

public class ImageFileGetImpl implements ImageFileGetDao{

	@Override
	public ImageFile getAImageFileById(Integer fid) {
		return null;
		/*Connection connection = DBUtil.getConnection();
		String sql = "insert into file_upload (file_name,file_path,create_time,is_delete,remark) "
				+ " values(?,?,?,?,?)";
		System.out.println(sql);

		try {
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setString(1, image.getFileName());
			pst.setString(2, image.getFilePath());
			pst.setDate(3, StringUtil.changeToSqlDate(image.getCreateTime()));
			pst.setByte(4, image.getIsDelete());
			pst.setString(5, image.getRemark());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			DBUtil.close(connection);
		}
		return true;*/
	}

	@Override
	public ArrayList<ImageFile> getImageFilesByOriginId(Integer oid) {
		ArrayList<ImageFile> imageFiles = new ArrayList<ImageFile>();
		Connection connection = DBUtil.open();
		String sql = "SELECT f.id, f.file_name, f.file_ext, f.file_path, f.file_des, f.file_size, "
				+ "f.is_show, f.create_time, f.is_delete, f.remark FROM sys_file AS f, sys_file_origin AS fo "
				+ "WHERE f.id = fo.file_id AND f.is_delete = 0 AND f.is_show = 1 AND fo.origin_id = '" + oid + "';";
		System.out.println("<<=====" + sql);

		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String fileName = rs.getString(2);
				String fileExt = rs.getString(3);
				String filePath = rs.getString(4);
				String fileDes = rs.getString(5);
				Double fileSize = rs.getDouble(6);
				Byte isShow = rs.getByte(7);
				Date createTime = rs.getTimestamp(8);
				Byte isDelete = rs.getByte(9);
				String remark = rs.getString(10);
				ImageFile imageFile = new ImageFile(id,fileName,fileExt,filePath,fileDes,fileSize,isShow,createTime,isDelete,remark);
				imageFiles.add(imageFile);
			}
			return imageFiles;
		} catch (SQLException e) {
			e.printStackTrace();
			return imageFiles;
		}finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Integer getMaxImageFilesId() {
		String sql = "select max(id) from sys_file; ";
		Connection connection = DBUtil.open();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			return  rs != null ? rs.getInt(1) : null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public ArrayList<BImageFile> getBackImageFiles(String fn, String um) {
		ArrayList<BImageFile> imageFiles = new ArrayList<BImageFile>();
		Connection connection = DBUtil.open();
		String sql = "SELECT f.id, f.file_name, o.country, u.user_name, f.file_ext, f.file_size, f.is_show " 
				+ "FROM sys_file AS f, sys_file_origin AS fo, sys_origin AS o, sys_user AS u "
				+ "WHERE f.id = fo.file_id AND fo.origin_id = o.id AND o.user_id = u.id AND "
				+ "u.user_name LIKE '%" + fn + "%' AND u.phone_number LIKE '%" + um +"%';";
		System.out.println("<<=====" + sql);

		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String fileName = rs.getString(2);
				String country = rs.getString(3);
				String userName = rs.getString(4);
				String fileExt = rs.getString(5);
				Double fileSize = rs.getDouble(6);
				Byte isShow = rs.getByte(7);
				BImageFile imageFile = new BImageFile(id,fileName,country,userName,fileExt,fileSize,isShow);
				imageFiles.add(imageFile);
			}
			return imageFiles;
		} catch (SQLException e) {
			e.printStackTrace();
			return imageFiles;
		}finally {
			DBUtil.close(connection);
		}
	}

}
