package top.antifeudal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.antifeudal.impl.ImageFileGetImpl;

/**
 * Servlet implementation class PhotoDelete
 */
@WebServlet("/PhotoDelete")
public class PhotoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoDelete() {
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
		Byte state = Byte.valueOf(request.getParameter("s"));
		ImageFileGetImpl imageFileGetImpl = new ImageFileGetImpl();
		imageFileGetImpl.changeImageFileState(id, state);
		request.getRequestDispatcher("PhotoManagement").forward(request, response);
	}

}
