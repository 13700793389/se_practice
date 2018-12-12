package cs.ucas.dao;

public interface SelectCourseDAO {
	public int isSelect(String username,int courseid);
	public int addRecord(String username,int courseid,int isdegree);
}
