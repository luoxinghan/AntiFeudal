package top.antifeudal.servlet;


import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.antifeudal.entity.User;
import top.antifeudal.impl.UserImpl;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserImpl userImpl = new UserImpl();
		User user = userImpl.findByInfo(userName);
		if(user == null) {
			request.setAttribute("hint", "noUser");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		} else if ((userName.equals(user.getAccount()) || userName.equals(user.getPhoneNumber()) || userName.equals(user.getUserName())) 
				&& password.equals(user.getPassword())) {
			if(user.getRoleId() == 2) {
				request.getRequestDispatcher("/jsp/birth.jsp").forward(request, response);
			} else {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("hint", "wrongPass");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}