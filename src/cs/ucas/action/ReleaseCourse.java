package cs.ucas.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.ucas.bean.Course;
import cs.ucas.bean.CourseDetail;
import cs.ucas.dao.CourseDAO;
import cs.ucas.dao.impl.CourseDAOImpl;

@WebServlet("/releasecourse")
public class ReleaseCourse extends HttpServlet{
	private CourseDAO coursedao = null;
	public ReleaseCourse() {
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
		Course newcourse = new Course();
		newcourse.setCourse_id(Integer.parseInt(req.getParameter("id")));
		newcourse.setCourse_name(req.getParameter("name"));
		newcourse.setCourse_period(Integer.parseInt(req.getParameter("period")));
		newcourse.setCourse_week(req.getParameter("week"));
		newcourse.setCourse_credit(Float.parseFloat(req.getParameter("credit")));
		newcourse.setCourse_isdegree(Integer.parseInt(req.getParameter("isdegree")));
		newcourse.setCourse_teacher(req.getParameter("teacher"));
		newcourse.setCourse_character(req.getParameter("character"));
		newcourse.setCourse_department(req.getParameter("department"));
		newcourse.setCourse_section(req.getParameter("section"));
		newcourse.setCourse_site(req.getParameter("site"));
		newcourse.setCourse_limitselection(Integer.parseInt(req.getParameter("limitselection")));
		newcourse.setCourse_haveselection(0);
		
		CourseDetail coursedetail = new CourseDetail();
		coursedetail.setCourse_id(Integer.parseInt(req.getParameter("id")));
		coursedetail.setCourse_require(req.getParameter("require"));
		coursedetail.setCourse_examination(req.getParameter("examination"));
		coursedetail.setCourse_outline(req.getParameter("outline"));
		int flag = 0;//0表示表示已经添加过 1表示添加成功 other 出错了
		if(coursedao.realseCourseDetail(coursedetail)==1&&coursedao.realseCourse(newcourse)==1) {
			flag = 1;
		}
		resp.getWriter().print(flag);
	}

}
