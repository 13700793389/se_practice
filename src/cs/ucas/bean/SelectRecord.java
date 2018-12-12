package cs.ucas.bean;

public class SelectRecord {
	private String student_username;
	private int course_id;
	private int isdegree;
	public SelectRecord() {
		
	}
	public SelectRecord(String student_username, int course_id, int isdegree) {
		super();
		this.student_username = student_username;
		this.course_id = course_id;
		this.isdegree = isdegree;
	}
	public String getStudent_username() {
		return student_username;
	}
	public void setStudent_username(String student_username) {
		this.student_username = student_username;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getIsdegree() {
		return isdegree;
	}
	public void setIsdegree(int isdegree) {
		this.isdegree = isdegree;
	}
	@Override
	public String toString() {
		return "Select [student_username=" + student_username + ", course_id=" + course_id + ", isdegree=" + isdegree
				+ "]";
	}
}
