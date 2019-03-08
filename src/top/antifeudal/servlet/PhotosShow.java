package top.antifeudal.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.antifeudal.entity.BOrigin;
import top.antifeudal.entity.ImageFile;
import top.antifeudal.entity.OriginPhotos;
import top.antifeudal.impl.ImageFileGetImpl;
import top.antifeudal.impl.OriginImpl;

/**
 * Servlet implementation class PhotosShow
 */
@WebServlet("/PhotosShow")
public class PhotosShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotosShow() {
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
		OriginImpl originImpl = new OriginImpl();
		ArrayList<OriginPhotos> oList = new ArrayList<OriginPhotos>();
		ArrayList<BOrigin> origins = new ArrayList<BOrigin>();
		origins = originImpl.getAllEffectiveOrigins();
		if (origins != null) {
			for(int i = 0; i < origins.size(); i++) {
				ArrayList<ImageFile> imageFiles = new ArrayList<ImageFile>();
				imageFiles = new ImageFileGetImpl().getImageFilesByOriginId(origins.get(i).getId());
				OriginPhotos originPhotos = new OriginPhotos(origins.get(i), imageFiles);
				oList.add(originPhotos);
			}
			request.setAttribute("oList", oList);
			request.getRequestDispatcher("/jsp/photos.jsp").forward(request, response);
		}
	}
}
