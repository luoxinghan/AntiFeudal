package top.antifeudal.dao;

import java.util.ArrayList;

import top.antifeudal.entity.PageBean;
import top.antifeudal.entity.Role;

/**
 * Title: RoleDao
 * Description: 添加RoleDao准备填写Role管理
 * @author luoxinghan
 * @date 2019年3月10日 上午4:03:18
 *
 */
public interface RoleDao {
	
	/**
	 * @Title: getRoleById   
	 * @Description: TODO(根据id找到对应角色)   
	 * @param: @param id
	 * @param: @return      
	 * @return: Role      
	 * @throws
	 */
	public Role getRoleById(Integer id);
	
	/**
	 * @Title: getAllNotDeleteRoles   
	 * @Description: TODO(找到所有未删除的角色)   
	 * @param: @return      
	 * @return: ArrayList<Role>      
	 * @throws
	 */
	public ArrayList<Role> getAllNotDeleteRoles();
	
	/**
	 * @Title: getAllRoles   
	 * @Description: TODO(获取所有后台管理的Role)   
	 * @param: @param roleName
	 * @param: @param curPage
	 * @param: @param pageSize
	 * @param: @return      
	 * @return: PageBean<Role>      
	 * @throws
	 */
	public PageBean<Role> getAllRoles(String roleName, Integer curPage, Integer pageSize);
	
	/**
	 * @Title: getBackRoleSize   
	 * @Description: TODO(获取后台角色个数)   
	 * @param: @param rn
	 * @param: @return      
	 * @return: Integer      
	 * @throws
	 */
	public Integer getBackRoleSize(String rn);
	
	/**
	 * @Title: addNewRole   
	 * @Description: TODO(新增一个角色)   
	 * @param: @param role
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean addNewRole(Role role);
	
	/**
	 * @Title: deleteRoleById   
	 * @Description: TODO(根据id删除一个角色)   
	 * @param: @param id
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean deleteRoleById(Integer id, Byte s);
	
	/**
	 * @Title: updateRole   
	 * @Description: TODO(修改一个角色)   
	 * @param: @param role
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean updateRole(Role role);
}
