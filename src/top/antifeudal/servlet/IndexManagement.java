package top.antifeudal.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.antifeudal.entity.BStory;
import top.antifeudal.entity.ImageFile;
import top.antifeudal.entity.User;
import top.antifeudal.impl.ImageFileGetImpl;
import top.antifeudal.impl.StoryImpl;
import top.antifeudal.util.EmailUtil;

/**
 * Servlet implementation class IndexManagement
 */
@WebServlet("*.wc")
public class IndexManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexManagement() {
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
	
	private void GetToWelcome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImageFile imageFile = new ImageFileGetImpl().getARandomImageFile();
		ArrayList<BStory> stories = new StoryImpl().getLastStories(3);
		request.setAttribute("photo", imageFile);
		request.setAttribute("stories", stories);
		request.getRequestDispatcher("/jsp/bwelcome.jsp").forward(request, response);
	}
	
	private void Suggestions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Integer userId = 1;
		String userName = "";
		User user = (User) request.getSession().getAttribute("buser");
		String title = request.getParameter("title");
		String suggestion = request.getParameter("suggestion");
		if (user != null) {
			try {
				EmailUtil.sentAEmail(user, title, suggestion);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("GetToWelcome.wc").forward(request, response);
	}

}
