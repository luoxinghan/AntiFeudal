package top.antifeudal.entity;
 
import java.util.List;
 
public class PageBean<T> {
	
	//当前页
	private int curPage;
	
	private List<T> list;
	
	//默认每页显示条数
	private int pageSize = 5;
	
	//总条数
	private int totalSize;
	
	/**
	 * 传进来数据库里的总条数以及每页显示的条数
	 * @param count
	 * @param pageSize
	 */
	public  PageBean(int count , int pageSize) {
		setTotalSize(count);
		setPageSize(pageSize);
	}
	
	/**
	 * 获取起始行数下标
	 * @return
	 */
	public int getStartIndex() {
		return (getCurPage()-1) * getPageSize();
	}
	
	/**
	 * 获取总页数
	 * @return
	 */
	public int getTotalPage(){
		int page = getTotalSize()/getPageSize();
		if(getTotalSize()%getPageSize() != 0){
			page++;
		}
		return page;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotalSize() {
		return totalSize;
	}
	
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	
	public int getCurPage() {
		return curPage;
	}
	
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	
	public List<T> getList() {
		return list;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}
}