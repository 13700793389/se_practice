package cs.ucas.dao.impl;

import java.sql.ResultSet;

import cs.ucas.dao.SelectCourseDAO;
import cs.ucas.db.DBConn;

public class SelectCourseDAOImpl implements SelectCourseDAO{

	@Override
	public int isSelect(String username, int courseid) {
		DBConn jdbc = new DBConn();
		String sql = "select * from selectrecord where student_username=? and course_id=?";
		int flag = 0;
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{username,courseid});
			if(res.next()) {
				flag = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return flag;
	}

	@Override
	public int addRecord(String username, int courseid, int isdegree) {
		DBConn jdbc = new DBConn();
		String sql = "insert into selectrecord (student_username,course_id,isdegree) values (?,?,?)";
		int flag = 0;
		try {
			flag = jdbc.do_Update(sql, new Object[]{username,courseid,isdegree});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return flag;
	}

}
