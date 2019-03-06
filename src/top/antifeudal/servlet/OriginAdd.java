package top.antifeudal.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.antifeudal.entity.Origin;
import top.antifeudal.impl.OriginImpl;

/**
 * Servlet implementation class OriginsAdd
 */
@WebServlet("/OriginAdd")
public class OriginAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OriginAdd() {
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
		Integer userId = 3;
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		Byte priority = Byte.valueOf(request.getParameter("priority"));
		String remark = request.getParameter("remark");
		Origin origin = new Origin(null, userId, country, state, city, street, priority, new Date(), Byte.valueOf("0"), remark);
		OriginImpl originImpl = new OriginImpl();
		originImpl.addNewOrigin(origin);
		request.getRequestDispatcher("OriginManagement").forward(request, response);
	}

}
