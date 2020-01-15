package cn.iisjy.main.svl.image;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.iisjy.main.dao.ImageDao;

/**
 * Servlet implementation class getpic
 */
@WebServlet("/getpic")
public class getpic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getpic() {
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
		String imghash = request.getParameter("hash");
		if (imghash != null && !imghash.equals("")) {
			String imgInfo = ImageDao.getImage(imghash);
			if (imgInfo != null && !imgInfo.equals("")) {
				response.getWriter().append(imgInfo);
				return;
			}
		}
		// return 404 code
		response.getWriter().append("404");
		response.setStatus(404);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("This api is NOT for post methord!").append(request.getContextPath());
	}

}
