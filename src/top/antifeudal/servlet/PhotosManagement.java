package top.antifeudal.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.antifeudal.entity.BImageFile;
import top.antifeudal.impl.ImageFileGetImpl;
import top.antifeudal.util.StringUtil;

/**
 * Servlet implementation class PhotosManagement
 */
@WebServlet("/PhotosManagement")
public class PhotosManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotosManagement() {
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
		String fileName = request.getParameter("fileName");
		String userName = request.getParameter("userName");
		ImageFileGetImpl imageFileGetImpl = new ImageFileGetImpl();
		ArrayList<BImageFile> blist = new ArrayList<BImageFile>();
		blist = imageFileGetImpl.getBackImageFiles(StringUtil.emptyOrNull(fileName), StringUtil.emptyOrNull(userName));
		request.setAttribute("blist", blist);
		request.getRequestDispatcher("/jsp/bphotos.jsp").forward(request, response);
	}

}
