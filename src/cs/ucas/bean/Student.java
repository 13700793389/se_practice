package cs.ucas.bean;

public class Student {
	private int stu_id;
	private String stu_username;
	private String stu_password;
	private String stu_name;
	private String stu_institution;
	private int student_master;
	private int student_status;
	public Student() {
		
	}
	public Student(int stu_id, String stu_username, String stu_password, String stu_name, String stu_institution,
			int student_master, int student_status) {
		super();
		this.stu_id = stu_id;
		this.stu_username = stu_username;
		this.stu_password = stu_password;
		this.stu_name = stu_name;
		this.stu_institution = stu_institution;
		this.student_master = student_master;
		this.student_status = student_status;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_username() {
		return stu_username;
	}
	public void setStu_username(String stu_username) {
		this.stu_username = stu_username;
	}
	public String getStu_password() {
		return stu_password;
	}
	public void setStu_password(String stu_password) {
		this.stu_password = stu_password;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_institution() {
		return stu_institution;
	}
	public void setStu_institution(String stu_institution) {
		this.stu_institution = stu_institution;
	}

	public int getStudent_master() {
		return student_master;
	}

	public void setStudent_master(int student_master) {
		this.student_master = student_master;
	}

	public int getStudent_status() {
		return student_status;
	}

	public void setStudent_status(int student_status) {
		this.student_status = student_status;
	}


}
