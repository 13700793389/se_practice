package cs.ucas.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs.ucas.dao.SelectCourseDAO;
import cs.ucas.dao.impl.SelectCourseDAOImpl;

@WebServlet("/addcourse")
public class AddCourseServlet extends HttpServlet{
	private SelectCourseDAO selectcoursedao = null;
	public AddCourseServlet() {
		selectcoursedao = new SelectCourseDAOImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		String username = (String)(session.getAttribute("cookie_username"));
		int flag = 0;//0表示未登录 1表示添加成功 2表示已经添加过 3出错了
		if(username != null) {
			int courseid = Integer.parseInt(req.getParameter("courseid"));
			int isdegree = 0;
			if(Boolean.valueOf(req.getParameter("isdegree")) == true) {
				isdegree = 1;//是学位课
			}
			if(selectcoursedao.isSelect(username, courseid)==1) {
				flag = 2;//已经添加过了
			} else {
				if(selectcoursedao.addRecord(username, courseid, isdegree)==1) {
					flag = 1;//添加成功
				} else {
					flag = 3;//出错了
				}
			}
		}
		resp.getWriter().print(flag);
	}

}
