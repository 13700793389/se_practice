package cs.ucas.bean;

public class Student {
	private int stu_id;
	private String stu_username;
	private String stu_password;
	private String stu_name;
	private String stu_institution;
	public Student() {
		
	}
	public Student(int stu_id, String stu_username, String stu_password, String stu_name,
			String stu_institution) {
		this.stu_id = stu_id;
		this.stu_username = stu_username;
		this.stu_password = stu_password;
		this.stu_name = stu_name;
		this.stu_institution = stu_institution;
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
	@Override
	public String toString() {
		return "StudentDAOImpl [stu_id=" + stu_id + ", stu_username=" + stu_username + ", stu_password=" + stu_password
				+ ", stu_name=" + stu_name + ", stu_institution=" + stu_institution + "]";
	}
}
