package top.antifeudal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.antifeudal.entity.BUser;
import top.antifeudal.entity.PageBean;
import top.antifeudal.impl.UserImpl;
import top.antifeudal.util.StringUtil;

/**
 * Servlet implementation class BUsers
 */
@WebServlet("/UserManagement")
public class UserManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManagement() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String pnum = request.getParameter("p");
		//初始值为1
		int pageNum = 1;
		if(pnum != null){
			pageNum = Integer.parseInt(pnum);
		}
		
		String userName = request.getParameter("userName");
		String telephone = request.getParameter("telephone");
		UserImpl userImpl = new UserImpl();
		PageBean<BUser> page = (PageBean<BUser>) userImpl.getAllBackUsers(
				StringUtil.emptyOrNull(userName), StringUtil.emptyOrNull(telephone), pageNum, 8);
		
		if(page != null){
			request.setAttribute("page", page);
			request.getRequestDispatcher("/jsp/bUser.jsp").forward(request, response);
		}
	}

}
