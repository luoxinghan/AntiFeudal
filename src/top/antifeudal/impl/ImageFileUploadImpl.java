package top.antifeudal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

import top.antifeudal.dao.ImageFileUploadDao;
import top.antifeudal.entity.ImageFile;
import top.antifeudal.util.DBUtil;

public class ImageFileUploadImpl implements ImageFileUploadDao{

	@Override
	public Boolean addNewFile(ImageFile image, Integer originId) {
		
		ImageFileGetImpl impl = new ImageFileGetImpl();
		Integer fId = impl.getMaxImageFilesId();
		ImageFileOriginImpl impl2 = new ImageFileOriginImpl();
		if (originId != 0) {
			impl2.addImageFileOrigin(fId + 1, originId);
		}
		
		String sql = "INSERT into sys_file(file_name, file_ext, file_path, file_des, file_size, is_show, create_time, is_delete, remark) VALUES(?,?,?,?,?,?,?,?,?);";
		Connection connection = DBUtil.open();
		System.out.println("=====>>" + sql);
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, image.getFileName());
			pstm.setString(2, image.getFileExt());
			pstm.setString(3, image.getFilePath());
			pstm.setString(4, image.getFileDescribe());
			pstm.setDouble(5, image.getFileSize());
			pstm.setByte(6, image.getIsShow());
			pstm.setTimestamp(7, new Timestamp(image.getCreateTime().getTime()));
			pstm.setByte(8, image.getIsDelete());
			pstm.setString(9, image.getRemark());
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
	public Boolean addSomeFiles(List<ImageFile> files) {
		// TODO Auto-generated method stub
		return null;
	}

}
