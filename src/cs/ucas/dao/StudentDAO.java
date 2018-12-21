package cs.ucas.dao;
import java.util.List;

import cs.ucas.bean.Student;
public interface StudentDAO {
	public List<Student> getStudentListBypage(int page,int limit);
	public int getTotalStuNum();
	public int checkUser(String username,String password);
	public int checkUserStatus(String username);
	public int getUidByUserName(String username);
	public void activeUserById(int id);
	public String getInstitution(String username);
}