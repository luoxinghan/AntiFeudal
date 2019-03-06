package top.antifeudal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.antifeudal.entity.BOrigin;
import top.antifeudal.entity.PageBean;
import top.antifeudal.impl.OriginImpl;
import top.antifeudal.util.StringUtil;

/**
 * Servlet implementation class OriginsManagement
 */
@WebServlet("/OriginManagement")
public class OriginManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OriginManagement() {
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
		String country = request.getParameter("country");
		OriginImpl originImpl = new OriginImpl();
		PageBean<BOrigin> page = (PageBean<BOrigin>) originImpl.getAllBackOrigins(
				StringUtil.emptyOrNull(userName), StringUtil.emptyOrNull(country), pageNum, 8);
		if(page != null){
			request.setAttribute("page", page);
			request.getRequestDispatcher("/jsp/bOrigin.jsp").forward(request, response);
		}
	}

}
