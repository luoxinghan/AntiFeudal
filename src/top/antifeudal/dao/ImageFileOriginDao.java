package top.antifeudal.dao;

import java.util.List;

import top.antifeudal.entity.ImageFile;

public interface ImageFileOriginDao {
	
	/**
	 * 添加一个照片地点关联
	 * @Title: addImageFileOrigin   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: fid
	 * @param: oid 
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean addImageFileOrigin(Integer fid, Integer oid);
	
	/**
	 * 根据地区id获取所有的图片信息，此处必须未删除且有效展示
	 * @Title: getAllShowImageFilesByOId   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param oid
	 * @param: @return      
	 * @return: List<ImageFile>      
	 * @throws
	 */
	public List<ImageFile> getAllShowImageFilesByOId(Integer oid);
	
	/**
	 * 根据地区id获取这个地区的照片数量
	 * @Title: getCountImageFileByOId   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: oid     
	 * @return: Integer      
	 * @throws
	 */
	public Integer getCountImageFileByOId(Integer oid);

}
