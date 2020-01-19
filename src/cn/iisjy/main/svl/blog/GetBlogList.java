package cn.iisjy.main.svl.blog;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.iisjy.main.dao.BlogDao;

/**
 * Servlet implementation class GetBlogList
 */
@WebServlet("/GetBlogList")
public class GetBlogList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetBlogList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String blogs = "NULL";
		String size_s = request.getParameter("size");
		if (size_s != null && "".equals(size_s)) {
			int size = Integer.parseInt(size_s);
			String page_s = request.getParameter("page");
			if(page_s != null && "".equals(page_s)) {
				int page = Integer.parseInt(page_s);
				try {
					blogs=BlogDao.getBlogListJson(size, page);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try {
					blogs=BlogDao.getBlogListJson(size);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			try {
				blogs=BlogDao.getBlogListJson();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.getWriter().append(blogs);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("This api is NOT for post methord!");
		response.setStatus(403);
	}

}
