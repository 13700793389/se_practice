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
@WebServlet("/getcourselist")
public class CourseServlet extends HttpServlet{
	private CourseDAO coursedao = null;
	public CourseServlet() {
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
		int page = Integer.parseInt(req.getParameter("page"));
		int limit = Integer.parseInt(req.getParameter("limit"));
		String department = req.getParameter("department");
		String conditions = req.getParameter("conditions");
		List<Course> courselist;
		if(department!=null) {
			//System.out.println(new String(department.getBytes("iso-8859-1"), "utf-8"));//tomcat内部默认设置的编码为iso-8859-1
			if(conditions!=null) {
				conditions = "%" + conditions + "%";
				courselist = coursedao.getCourseListBypage(page,limit,department,conditions);
			}else{
				courselist = coursedao.getCourseListBypage(page,limit,department);
			}
		}else {
			courselist = coursedao.getCourseListBypage(page,limit);
		}
		LayuiTable<Course> tableres = new LayuiTable<Course>();
		tableres.setStatus(200);
		tableres.setMessage("");
		tableres.setTotal(coursedao.getTotalCourseNum());
		tableres.setRows(courselist);
		resp.getWriter().write(JSONArray.fromObject(tableres).toString());
	}
}
