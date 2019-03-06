package top.antifeudal.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.antifeudal.entity.Origin;
import top.antifeudal.entity.User;
import top.antifeudal.impl.OriginImpl;
import top.antifeudal.impl.UserImpl;

/**
 * Servlet implementation class OriginUpdate
 */
@WebServlet("/OriginUpdateCheck")
public class OriginUpdateCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OriginUpdateCheck() {
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
		Origin origin = new OriginImpl().getOriginById(id);
		ArrayList<User> users = new UserImpl().findValidUser();
		if (origin != null) {
			request.setAttribute("origin", origin);
			request.setAttribute("users", users);
			request.getRequestDispatcher("/jsp/bOriginUpdate.jsp").forward(request, response);	
		}
	}

}
