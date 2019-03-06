package top.antifeudal.dao;

import java.util.ArrayList;

import top.antifeudal.entity.BImageFile;
import top.antifeudal.entity.ImageFile;
import top.antifeudal.entity.PageBean;


public interface ImageFileGetDao {

	/**
	 * 根据图片id找到一张图片
	 * @Title: getAImageFileByOriginId   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param id    
	 * @return: ImageFile      
	 * @throws
	 */
	public ImageFile getAImageFileById(Integer fid);
	
	/**
	 * 根据地区id找到所有图片
	 * @Title: getImageFilesByOriginId   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param id   
	 * @return: ArrayList<ImageFile>      
	 * @throws
	 */
	public ArrayList<ImageFile> getImageFilesByOriginId(Integer oid);
	
	/**
	 * 获取最大的图片文件id
	 * @Title: getMaxFilesId   
	 * @Description: TODO(这里用一句话描述这个方法的作用)        
	 * @return: Integer      
	 * @throws
	 */
	public Integer getMaxImageFilesId();
	
	/**
	 * @Title: getBackImageFiles   
	 * @Description: TODO(根据文件名或用户名获取所有文件信息)   
	 * @param: @param fileName
	 * @param: @param userName
	 * @param: @return      
	 * @return: ArrayList<ImageFile>      
	 * @throws
	 */
	public PageBean<BImageFile> getAllBackImageFiles(String fileName, String userName, Integer curPage, Integer pageSize);
	
	/**
	 * @Title: getBackImageFileSize   
	 * @Description: TODO(图片文件后台获取长度)   
	 * @param: @param fn
	 * @param: @param um
	 * @param: @return      
	 * @return: Integer      
	 * @throws
	 */
	public Integer getBackImageFileSize(String fn, String um);
}
