package cs.ucas.bean;

public class CourseDetail {
	private int course_id;
	private String course_name;
	private String course_require;
	private String course_outline;
	private String course_examination;
	private String course_section;
	private String course_site;
	private String course_week;
	public CourseDetail(){
		
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_require() {
		return course_require;
	}
	public void setCourse_require(String course_require) {
		this.course_require = course_require;
	}
	public String getCourse_outline() {
		return course_outline;
	}
	public void setCourse_outline(String course_outline) {
		this.course_outline = course_outline;
	}
	public String getCourse_examination() {
		return course_examination;
	}
	public void setCourse_examination(String course_examination) {
		this.course_examination = course_examination;
	}
	public String getCourse_site() {
		return course_site;
	}
	public void setCourse_site(String course_site) {
		this.course_site = course_site;
	}
	public String getCourse_section() {
		return course_section;
	}
	public void setCourse_section(String course_section) {
		this.course_section = course_section;
	}
	public String getCourse_week() {
		return course_week;
	}
	public void setCourse_week(String course_week) {
		this.course_week = course_week;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
}
