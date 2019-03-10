package top.antifeudal.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.antifeudal.entity.PageBean;
import top.antifeudal.entity.Role;
import top.antifeudal.impl.RoleImpl;
import top.antifeudal.util.DateUtil;
import top.antifeudal.util.StringUtil;


/**
 * Servlet implementation class Role
 */
@WebServlet("*.rl")
public class RoleManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleManagement() {
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
		// 获取请求的URI地址信息
        String url = request.getRequestURI();
        // 截取其中的方法名
        String methodName = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf("."));
        Method method = null;
        try {
            // 使用反射机制获取在本类中声明了的方法
            method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 执行方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            throw new RuntimeException("调用方法出错！");
        }
	}
	
	private void RolesGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String pnum = request.getParameter("p");
		//初始值为1
		int pageNum = 1;
		if(pnum != null){
			pageNum = Integer.parseInt(pnum);
		}
		
		String roleName = request.getParameter("roleName");
		RoleImpl roleImpl = new RoleImpl();
		PageBean<Role> page = (PageBean<Role>) roleImpl.getAllRoles(
				StringUtil.emptyOrNull(roleName), pageNum, 8);
		
		if(page != null){
			request.setAttribute("page", page);
			request.getRequestDispatcher("/jsp/bRole.jsp").forward(request, response);
		}
	}

	private void RoleDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Byte state = Byte.valueOf(request.getParameter("s"));
		RoleImpl roleImpl = new RoleImpl();
		roleImpl.deleteRoleById(id, state);
		request.getRequestDispatcher("RolesGet.rl").forward(request, response);
	}
	
	private void RoleUpdateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Role role = new RoleImpl().getRoleById(id);
		if (role != null) {
			request.setAttribute("role", role);
			request.getRequestDispatcher("/jsp/bRoleUpdate.jsp").forward(request, response);	
		}
	}
	
	private void RoleUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Integer id = Integer.valueOf(request.getParameter("id"));
		String roleName = request.getParameter("roleName");
		Date createTime = DateUtil.stringToDate((request.getParameter("ct")));
		String remark = request.getParameter("remark");
		Role role = new Role(id, roleName, createTime, Byte.valueOf("0"), remark);
		RoleImpl roImpl = new RoleImpl();
		roImpl.updateRole(role);
		request.getRequestDispatcher("RolesGet.rl").forward(request, response);
	}
	
	private void RoleAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String roleName = request.getParameter("roleName");
		String remark = request.getParameter("remark");
		Role role = new Role(null, roleName, new Date(), Byte.valueOf("0"), remark);
		RoleImpl roleImpl = new RoleImpl();
		roleImpl.addNewRole(role);
		request.getRequestDispatcher("RolesGet.rl").forward(request, response);
	}
	
}
