package cs.ucas.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cs.ucas.bean.Course;
import cs.ucas.bean.CourseDetail;
import cs.ucas.dao.CourseDAO;
import cs.ucas.db.DBConn;

public class CourseDAOImpl implements CourseDAO{

	@Override
	public List<Course> getCourseListBypage(int page, int limit) {
		List<Course> courseList = new ArrayList<Course>();
		DBConn jdbc = new DBConn();
		String sql = "select * from course limit ?,?";
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{(page-1)*limit,limit});
			while(res.next()) {
				Course course = new Course();
				course.setCourse_id(res.getInt("course_id"));
				course.setCourse_name(res.getString("course_name"));
				course.setCourse_period(res.getInt("course_period"));
				course.setCourse_credit(res.getFloat("course_credit"));
				course.setCourse_isdegree(res.getInt("course_isdegree"));
				course.setCourse_limitselection(res.getInt("course_limitselection"));
				course.setCourse_haveselection(res.getInt("course_haveselection"));
				course.setCourse_department(res.getString("course_department"));
				course.setCourse_teacher(res.getString("course_teacher"));
				course.setCourse_character(res.getString("course_character"));
				course.setCourse_week(res.getString("course_week"));
				course.setCourse_section(res.getString("course_section"));
				course.setCourse_site(res.getString("course_site"));
				courseList.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return courseList;
	}

	@Override
	public int getTotalCourseNum() {
		DBConn jdbc = new DBConn();
		String sql = "select count(*) as t from course";
		int num = 0;
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{});
			if(res.next()) {
				num = res.getInt("t");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return num;
	}

	@Override
	public List<Course> getMyCourseList(String username) {
		List<Course> courseList = new ArrayList<Course>();
		DBConn jdbc = new DBConn();
		String sql = "select course.course_id,course.course_name,course.course_credit,selectrecord.isdegree,course.course_week,course.course_section,course.course_site"
				+ " from course,selectrecord where course.course_id=selectrecord.course_id and selectrecord.student_username=?";
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{username});
			while(res.next()) {
				Course course = new Course();
				course.setCourse_id(res.getInt("course_id"));
				course.setCourse_name(res.getString("course_name"));
				course.setCourse_credit(res.getFloat("course_credit"));
				course.setCourse_isdegree(res.getInt("isdegree"));
				course.setCourse_week(res.getString("course_week"));
				course.setCourse_section(res.getString("course_section"));
				course.setCourse_site(res.getString("course_site"));
				courseList.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return courseList;
	}

	@Override
	public List<Course> getCourseListBypage(int page, int limit, String department) {
		List<Course> courseList = new ArrayList<Course>();
		DBConn jdbc = new DBConn();
		String sql = "select * from course where course_department = ? limit ?,?";
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{department,(page-1)*limit,limit});
			while(res.next()) {
				Course course = new Course();
				course.setCourse_id(res.getInt("course_id"));
				course.setCourse_name(res.getString("course_name"));
				course.setCourse_period(res.getInt("course_period"));
				course.setCourse_credit(res.getFloat("course_credit"));
				course.setCourse_isdegree(res.getInt("course_isdegree"));
				course.setCourse_limitselection(res.getInt("course_limitselection"));
				course.setCourse_haveselection(res.getInt("course_haveselection"));
				course.setCourse_department(res.getString("course_department"));
				course.setCourse_teacher(res.getString("course_teacher"));
				course.setCourse_character(res.getString("course_character"));
				course.setCourse_week(res.getString("course_week"));
				course.setCourse_section(res.getString("course_section"));
				course.setCourse_site(res.getString("course_site"));
				courseList.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return courseList;
	}

	@Override
	public List<Course> getCourseListBypage(int page, int limit, String department, String conditions) {
		List<Course> courseList = new ArrayList<Course>();
		DBConn jdbc = new DBConn();
		String sql = "select * from course where (course_name like ? or course_teacher like ? or course_character like ? )and course_department = ? limit ?,?";
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{conditions,conditions,conditions,department,(page-1)*limit,limit});
			while(res.next()) {
				Course course = new Course();
				course.setCourse_id(res.getInt("course_id"));
				course.setCourse_name(res.getString("course_name"));
				course.setCourse_period(res.getInt("course_period"));
				course.setCourse_credit(res.getFloat("course_credit"));
				course.setCourse_isdegree(res.getInt("course_isdegree"));
				course.setCourse_limitselection(res.getInt("course_limitselection"));
				course.setCourse_haveselection(res.getInt("course_haveselection"));
				course.setCourse_department(res.getString("course_department"));
				course.setCourse_teacher(res.getString("course_teacher"));
				course.setCourse_character(res.getString("course_character"));
				course.setCourse_week(res.getString("course_week"));
				course.setCourse_section(res.getString("course_section"));
				course.setCourse_site(res.getString("course_site"));
				courseList.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return courseList;
	}

	@Override
	public List<CourseDetail> getCourseDetail(int id) {
		List<CourseDetail> coursedetailList = new ArrayList<CourseDetail>();
		DBConn jdbc = new DBConn();
		String sql = "select coursedetail.course_id,course.course_name,course.course_week,course.course_section,course.course_site,coursedetail.course_require,coursedetail.course_outline,coursedetail.course_examination\r\n" + 
				"from coursedetail,course\r\n" + 
				"where coursedetail.course_id=? and coursedetail.course_id=course.course_id";
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{id});
			while(res.next()) {
				CourseDetail coursedetail = new CourseDetail();
				coursedetail.setCourse_id(res.getInt("course_id"));
				coursedetail.setCourse_name(res.getString("course_name"));
				coursedetail.setCourse_week(res.getString("course_week"));
				coursedetail.setCourse_section(res.getString("course_section"));
				coursedetail.setCourse_site(res.getString("course_site"));
				coursedetail.setCourse_require(res.getString("course_require"));
				coursedetail.setCourse_outline(res.getString("course_outline"));
				coursedetail.setCourse_examination(res.getString("course_examination"));
				coursedetailList.add(coursedetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return coursedetailList;
	}

	@Override
	public int realseCourse(Course course) {
		DBConn jdbc = new DBConn();
		String sql = "insert into course (course_id,course_name,course_period,course_week,"
				+ "course_credit,course_isdegree,course_limitselection,course_haveselection,course_department,course_teacher,course_character,course_section,course_site) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int flag = 0;
		try {
			flag = jdbc.do_Update(sql, new Object[]{course.getCourse_id(),course.getCourse_name(),course.getCourse_period(),course.getCourse_week(),
					course.getCourse_credit(),course.getCourse_isdegree(),course.getCourse_limitselection(),course.getCourse_haveselection(),course.getCourse_department(),
					course.getCourse_teacher(),course.getCourse_character(),course.getCourse_section(),course.getCourse_site()});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return flag;
	}

	@Override
	public int realseCourseDetail(CourseDetail coursedetail) {
		DBConn jdbc = new DBConn();
		String sql = "insert into coursedetail (course_id,course_require,course_examination,course_outline) values (?,?,?,?)";
		int flag = 0;
		try {
			flag = jdbc.do_Update(sql, new Object[]{coursedetail.getCourse_id(),coursedetail.getCourse_require(),coursedetail.getCourse_examination(),coursedetail.getCourse_outline()});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return flag;
	}
}
