package top.antifeudal.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.antifeudal.entity.Role;
import top.antifeudal.entity.User;
import top.antifeudal.impl.RoleImpl;
import top.antifeudal.impl.UserImpl;

/**
 * Servlet implementation class UserUpdateCheck
 */
@WebServlet("/UserUpdateCheck")
public class UserUpdateCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateCheck() {
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
		Integer id = Integer.valueOf(request.getParameter("id"));
		User user = new UserImpl().findById(id);
		ArrayList<Role> roles = new RoleImpl().getAllNotDeleteRoles();
		if (user != null) {
			request.setAttribute("roles", roles);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/jsp/bUserUpdate.jsp").forward(request, response);	
		}
	}

}
