package top.antifeudal.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.antifeudal.entity.BStory;
import top.antifeudal.entity.PageBean;
import top.antifeudal.entity.Story;
import top.antifeudal.entity.User;
import top.antifeudal.impl.StoryImpl;
import top.antifeudal.impl.UserImpl;
import top.antifeudal.util.DateUtil;
import top.antifeudal.util.StringUtil;

/**
 * Servlet implementation class StoryManagement
 */
@WebServlet("*.sr")
public class StoryManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoryManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取请求的URI地址信息
        String url = request.getRequestURI();
        // 截取其中的方法名
        String methodName = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf("."));
        Method method = null;
        try {
            // 使用反射机制获取在本类中声明了的方法
            method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 执行方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            throw new RuntimeException("调用方法出错！");
        }
	}
	
	private void StoriesGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String pnum = request.getParameter("p");
		//初始值为1
		int pageNum = 1;
		if(pnum != null){
			pageNum = Integer.parseInt(pnum);
		}
		
		String userName = request.getParameter("userName");
		String articleTitle = request.getParameter("articleTitle");
		StoryImpl storyImpl = new StoryImpl();
		PageBean<BStory> page = (PageBean<BStory>) storyImpl.getAllBackStories(StringUtil.emptyOrNull(userName), StringUtil.emptyOrNull(articleTitle), pageNum, 8);
		
		if(page != null){
			request.setAttribute("page", page);
			request.getRequestDispatcher("/jsp/bStory.jsp").forward(request, response);
		}
	}
	
	private void StoryDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Byte state = Byte.valueOf(request.getParameter("s"));
		StoryImpl storyImpl = new StoryImpl();
		storyImpl.changeStoryState(id, state);
		request.getRequestDispatcher("StoriesGet.sr").forward(request, response);
	}
	
	private void StoryUpdateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Story story = new StoryImpl().getStoryById(id);
		ArrayList<User> users = new UserImpl().findValidUser();
		if (story != null) {
			request.setAttribute("story", story);
			request.setAttribute("users", users);
			request.getRequestDispatcher("/jsp/bStoryUpdate.jsp").forward(request, response);	
		}
	}
	
	private void StoryUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer uid = Integer.valueOf(request.getParameter("user"));
		String articleTitle = request.getParameter("articleTitle");
		String articleContent = request.getParameter("articleContent");
		String articleDes = request.getParameter("articleDes");
		Date createTime = DateUtil.stringToDate((request.getParameter("ct")));
		Date updateTime = new Date();
		Story story = new Story(id, uid, articleTitle, articleContent, articleDes, createTime, updateTime, Byte.valueOf("0"));
		StoryImpl storyImpl = new StoryImpl();
		storyImpl.updateStory(story);
		request.getRequestDispatcher("StoriesGet.sr").forward(request, response);
	}

	private void StoryAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Integer userId = 1;
		User user = (User) request.getSession().getAttribute("buser");
		if (user != null) {
			userId = user.getId();
		}
		String articleTitle = request.getParameter("articleTitle");
		String articleContent = request.getParameter("articleContent");
		String articleDes = request.getParameter("articleDes");
		Date t = new Date();
		Story story = new Story(null, userId, articleTitle, articleContent, articleDes, t, t, Byte.valueOf("0"));
		StoryImpl storyImpl = new StoryImpl();
		storyImpl.addNewStory(story);
		request.getRequestDispatcher("StoriesGet.sr").forward(request, response);
	}
	
	private void FrontStories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BStory> stories = new StoryImpl().getLastStories(20);
		request.setAttribute("stories", stories);
		request.getRequestDispatcher("/jsp/stories.jsp").forward(request, response);
	}
}
