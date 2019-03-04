package top.antifeudal.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.antifeudal.entity.BUser;
import top.antifeudal.impl.UserImpl;
import top.antifeudal.util.StringUtil;

/**
 * Servlet implementation class BUsers
 */
@WebServlet("/UsersManagement")
public class UsersManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersManagement() {
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
		String userName = request.getParameter("userName");
		String telephone = request.getParameter("telephone");
		UserImpl userImpl = new UserImpl();
		ArrayList<BUser> blist = new ArrayList<BUser>();
		blist = userImpl.findAllBackUsers(StringUtil.emptyOrNull(userName), StringUtil.emptyOrNull(telephone));
		request.setAttribute("blist", blist);
		request.getRequestDispatcher("/jsp/busers.jsp").forward(request, response);
	}

}
