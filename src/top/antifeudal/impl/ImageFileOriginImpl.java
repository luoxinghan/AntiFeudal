package top.antifeudal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import top.antifeudal.dao.ImageFileOriginDao;
import top.antifeudal.entity.ImageFile;
import top.antifeudal.util.DBUtil;

public class ImageFileOriginImpl implements ImageFileOriginDao {

	@Override
	public Boolean addImageFileOrigin(Integer fid, Integer oid) {
		String sql = "INSERT into sys_file_origin(file_id, origin_id) VALUES(" + fid + "," + oid + ");";
		Connection connection = DBUtil.open();
		System.out.println("=====>>" + sql);
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
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
	public List<ImageFile> getAllShowImageFilesByOId(Integer oid) {
		List<ImageFile> imageFiles = new ArrayList<ImageFile>();
        String sql = "SELECT sf.id, sf.file_name, sf.file_ext, sf.file_path, sf.file_des,"
        		+ " sf.file_size, sf.is_show, sf.create_time, sf.is_delete, sf.remark "
        		+ "FROM sys_file AS sf, sys_file_origin AS sfo WHERE sf.id = sfo.file_id "
        		+ "AND sf.is_show = 1 AND sfo.origin_id = " + oid + ";";
        System.out.println("<<=====" + sql);
        Connection connection = DBUtil.open();
        try {
        	PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
            	ImageFile imageFile = new ImageFile();

            	imageFile.setId(rs.getInt(1));
            	imageFile.setFileName(rs.getString(2));
            	imageFile.setFileExt(rs.getString(3));
            	imageFile.setFilePath(rs.getString(4));
            	imageFile.setFileDescribe(rs.getString(5));
            	imageFile.setFileSize(rs.getDouble(6));
            	imageFile.setIsShow(rs.getByte(7));
				Timestamp t = rs.getTimestamp(8);
				imageFile.setCreateTime(t);
				imageFile.setIsDelete(rs.getByte(9));
				imageFile.setRemark(rs.getString(10));
				imageFiles.add(imageFile);
            }
            
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
        return imageFiles;
	}

	@Override
	public Integer getCountImageFileByOId(Integer oid) {
		Integer count = 0;
        String sql = "SELECT count(*) FROM sys_file AS sf, sys_file_origin AS sfo "
        		+ "WHERE sf.id = sfo.file_id AND sf.is_show = 1 AND sfo.origin_id = " + oid + ";";
        System.out.println("<<=====" + sql);
        Connection connection = DBUtil.open();
        try {
        	PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
            	count = rs.getInt(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
	}

}
