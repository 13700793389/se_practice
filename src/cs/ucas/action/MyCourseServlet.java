package cs.ucas.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.ucas.bean.Course;
import cs.ucas.bean.LayuiTable;
import cs.ucas.dao.CourseDAO;
import cs.ucas.dao.impl.CourseDAOImpl;
import net.sf.json.JSONArray;
@WebServlet("/getmycourselist")
public class MyCourseServlet extends HttpServlet{
	private CourseDAO coursedao = null;
	public MyCourseServlet() {
		coursedao = new CourseDAOImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		String username = String.valueOf(req.getSession().getAttribute("cookie_username"));
		List<Course> courselist = coursedao.getMyCourseList(username);
		LayuiTable<Course> tableres = new LayuiTable<Course>();
		tableres.setStatus(200);
		tableres.setMessage("");
		tableres.setTotal(0);
		tableres.setRows(courselist);
		resp.getWriter().write(JSONArray.fromObject(tableres).toString());
	}
}
