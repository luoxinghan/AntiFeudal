package top.antifeudal.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.antifeudal.entity.User;
import top.antifeudal.impl.UserImpl;
import top.antifeudal.util.DateUtil;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
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
		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer roleId = Integer.valueOf(request.getParameter("role"));
		String account = request.getParameter("account");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		Date createTime = DateUtil.stringToDate((request.getParameter("ct")));
		String remark = request.getParameter("remark");
		User user = new User(id, roleId, account, username, password, phone, Byte.valueOf("0"), createTime, Byte.valueOf("0"), remark);
		UserImpl userImpl = new UserImpl();
		userImpl.updateUser(user);
		request.getRequestDispatcher("UserManagement").forward(request, response);
	}

}
