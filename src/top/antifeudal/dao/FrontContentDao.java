package top.antifeudal.dao;

import top.antifeudal.entity.FrontContent;

/**
 * @describe 前台信息获取
 * @author Luo
 * @date 2018/12/11
 * @version 1.0
 *
 */
public interface FrontContentDao {
	
	/**
	 * 根据id获取FrontContent类型的值
	 * @param id
	 * @return
	 */
	public FrontContent getFrontContentById(Integer id);
	
	/**
	 * 根据jsp和div获取FrontContent
	 * @param jspName
	 * @param divName
	 * @return
	 */
	public FrontContent getByJspAndDivName(String jspName, String divName);

}
