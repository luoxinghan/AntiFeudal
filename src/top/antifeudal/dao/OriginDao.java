package top.antifeudal.dao;

import java.util.ArrayList;
import top.antifeudal.entity.BOrigin;
import top.antifeudal.entity.Origin;
import top.antifeudal.entity.PageBean;

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
	 * @Title: changeOriginState   
	 * @Description: TODO(改变origin删除状态)   
	 * @param: @param id
	 * @param: @param s
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean changeOriginState(Integer id, Byte s);
	
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
	public ArrayList<Origin> getAllNotDeleteOrigins();
	
	/**
	 * 获取所有有效的origin
	 * @Title: getAllEffectiveOrigins   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return      
	 * @return: ArrayList<BOrigin>      
	 * @throws
	 */
	public ArrayList<BOrigin> getAllEffectiveOrigins();
	
	/**
	 * @Title: getAllBackOrigins   
	 * @Description: TODO(获取所有的图片分享地址)   
	 * @param: @param un
	 * @param: @param cty
	 * @param: @return      
	 * @return: List<BOrigin>      
	 * @throws
	 */
	public PageBean<BOrigin> getAllBackOrigins(String un, String cty, Integer curPage, Integer pageSize);
	
	/**
	 * @Title: getBackOriginSize   
	 * @Description: TODO(获取后台显示的所有Origin)   
	 * @param: @param un
	 * @param: @param cty
	 * @param: @return      
	 * @return: Integer      
	 * @throws
	 */
	public Integer getBackOriginSize(String un, String cty);
}
