package cs.ucas.dao;
import java.util.List;

import cs.ucas.bean.Student;
public interface StudentDAO {
	public List<Student> getStudentListBypage(int page,int limit);
	public int getTotalStuNum();
	public int checkUser(String username,String password);
	public String getInstitution(String username);
}
