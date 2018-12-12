package cs.ucas.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.ucas.bean.Course;
import cs.ucas.bean.CourseDetail;
import cs.ucas.bean.LayuiTable;
import cs.ucas.dao.CourseDAO;
import cs.ucas.dao.impl.CourseDAOImpl;
import net.sf.json.JSONArray;

@WebServlet("/showcoursedetail")
public class ShowCourseDetail extends HttpServlet{
	private CourseDAO coursedao = null;
	public ShowCourseDetail() {
		coursedao = new CourseDAOImpl();
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
		int courseid = Integer.parseInt(req.getParameter("courseid"));
		List<CourseDetail> coursedetailList = coursedao.getCourseDetail(courseid);
		CourseDetail coursedetail = coursedetailList.get(0);
		String sec = coursedetail.getCourse_section();
		String newSec = "";
		String[] lines = sec.split("-");
		for(String l : lines) {
			String[] line = l.split("\\|");
			newSec += "周" + line[0] + "第" +line[1]+ "节\t";
		}
		coursedetail.setCourse_section(newSec);
		LayuiTable<CourseDetail> tableres = new LayuiTable<CourseDetail>();
		tableres.setStatus(200);
		tableres.setMessage("");
		tableres.setTotal(coursedao.getTotalCourseNum());
		tableres.setRows(coursedetailList);
		resp.getWriter().write(JSONArray.fromObject(tableres).toString());
	}
}
