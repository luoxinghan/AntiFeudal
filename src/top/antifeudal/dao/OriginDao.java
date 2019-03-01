package top.antifeudal.dao;

import java.util.List;

import top.antifeudal.entity.Origin;

public interface OriginDao {
	
	/**
	 * 添加一个新的照片地点
	 * @Title: addANewOrigin   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: origin    
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean addNewOrigin(Origin origin);
	
	/**
	 * 根据id删除一个照片地点，删除后不能显示。
	 * @Title: deleteOriginById   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: id   
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean deleteOriginById(Integer id);
	
	/**
	 * 根据一个照片地点进行修改
	 * @Title: updateOrigin   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: origin   
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean updateOrigin(Origin origin);
	
	/**
	 * 根据照片地点id找到照片地点
	 * @Title: getAOriginById   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: oid    
	 * @return: Origin      
	 * @throws
	 */
	public Origin getOriginById(Integer oid);
	
	/**
	 * 获取所有未删除的地点信息
	 * @Title: getAllNotDeleteOrigins   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return      
	 * @return: List<Origin>      
	 * @throws
	 */
	public List<Origin> getAllNotDeleteOrigins();
}
