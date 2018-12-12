package cs.ucas.bean;

public class Course {
	private int course_id;
	private String course_name;
	private int course_period;
	private String course_week;
	private float course_credit;;
	private int course_isdegree;
	private int course_limitselection;
	private int course_haveselection;
	private String course_department;
	private String course_teacher;
	private String course_character;
	private String course_section;
	private String course_site;
	public Course() {
		
	}
	public String getCourse_character() {
		return course_character;
	}
	public void setCourse_character(String course_character) {
		this.course_character = course_character;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getCourse_period() {
		return course_period;
	}
	public void setCourse_period(int course_period) {
		this.course_period = course_period;
	}
	public String getCourse_week() {
		return course_week;
	}
	public void setCourse_week(String course_week) {
		this.course_week = course_week;
	}
	public float getCourse_credit() {
		return course_credit;
	}
	public void setCourse_credit(float course_credit) {
		this.course_credit = course_credit;
	}
	public int getCourse_isdegree() {
		return course_isdegree;
	}
	public void setCourse_isdegree(int course_isdegree) {
		this.course_isdegree = course_isdegree;
	}
	public int getCourse_limitselection() {
		return course_limitselection;
	}
	public void setCourse_limitselection(int course_limitselection) {
		this.course_limitselection = course_limitselection;
	}
	public int getCourse_haveselection() {
		return course_haveselection;
	}
	public void setCourse_haveselection(int course_haveselection) {
		this.course_haveselection = course_haveselection;
	}
	public String getCourse_department() {
		return course_department;
	}
	public void setCourse_department(String course_department) {
		this.course_department = course_department;
	}
	public String getCourse_teacher() {
		return course_teacher;
	}
	public void setCourse_teacher(String course_teacher) {
		this.course_teacher = course_teacher;
	}
	
	public String getCourse_section() {
		return course_section;
	}
	public void setCourse_section(String course_section) {
		this.course_section = course_section;
	}
	public String getCourse_site() {
		return course_site;
	}
	public void setCourse_site(String course_site) {
		this.course_site = course_site;
	}
	public Course(int course_id, String course_name, int course_period, String course_week, float course_credit,
			int course_isdegree, int course_limitselection, int course_haveselection, String course_department,
			String course_teacher, String course_character, String course_section, String course_site) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_period = course_period;
		this.course_week = course_week;
		this.course_credit = course_credit;
		this.course_isdegree = course_isdegree;
		this.course_limitselection = course_limitselection;
		this.course_haveselection = course_haveselection;
		this.course_department = course_department;
		this.course_teacher = course_teacher;
		this.course_character = course_character;
		this.course_section = course_section;
		this.course_site = course_site;
	}
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_period=" + course_period
				+ ", course_week=" + course_week + ", course_credit=" + course_credit + ", course_isdegree="
				+ course_isdegree + ", course_limitselection=" + course_limitselection + ", course_haveselection="
				+ course_haveselection + ", course_department=" + course_department + ", course_teacher="
				+ course_teacher + ", course_character=" + course_character + ", course_section=" + course_section
				+ ", course_site=" + course_site + "]";
	}

}
