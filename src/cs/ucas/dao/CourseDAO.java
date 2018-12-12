package cs.ucas.dao;

import java.util.List;

import cs.ucas.bean.Course;
import cs.ucas.bean.CourseDetail;

public interface CourseDAO {
	public List<Course> getCourseListBypage(int page,int limit);
	public List<Course> getCourseListBypage(int page,int limit,String department);
	public List<Course> getCourseListBypage(int page,int limit,String department,String conditions);
	public List<Course> getMyCourseList(String username);
	public int getTotalCourseNum();
	public List<CourseDetail> getCourseDetail(int courseid);
	public int realseCourse(Course course);
	public int realseCourseDetail(CourseDetail coursedetail);
}