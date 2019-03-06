package top.antifeudal.dao;

import java.util.List;

import top.antifeudal.entity.ImageFile;

public interface ImageFileUploadDao {

	/**
	 * 添加一个文件
	 * @param image
	 * @return
	 */
	public Boolean addNewFile(ImageFile image, Integer originId);
	
	/**
	 * 一次性添加多个文件到数据库
	 * @param files
	 * @return
	 */
	public Boolean addSomeFiles(List<ImageFile> files);
}
