package cs.ucas.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cs.ucas.bean.Student;
import cs.ucas.dao.StudentDAO;
import cs.ucas.db.DBConn;

public class StudentDAOImpl implements StudentDAO{

	@Override
	public List<Student> getStudentListBypage(int page,int limit) {

		List<Student> stuList = new ArrayList<Student>();
		DBConn jdbc = new DBConn();
		String sql = "select * from student limit ?,?";
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{(page-1)*limit,limit});
			while(res.next()) {
				Student std = new Student();
				std.setStu_id(res.getInt("student_id"));
				std.setStu_username(res.getString("student_username"));
				std.setStu_password(res.getString("student_password"));
				std.setStu_name(res.getString("student_name"));
				std.setStu_institution(res.getString("student_institution"));
				stuList.add(std);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return stuList;
	}

	@Override
	public int getTotalStuNum() {
		DBConn jdbc = new DBConn();
		String sql = "select count(*) as t from student";
		int num = 0;
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{});
			if(res.next()) {
				num = res.getInt("t");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return num;
	}

	@Override
	public int checkUser(String username, String password) {
		DBConn jdbc = new DBConn();
		int num = 0;
		String sql = "select * from student where student_username=? and student_password=?";
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{username,password});
			if(res.next()) {
				num = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return num;
	}

	@Override
	public String getInstitution(String username) {
		DBConn jdbc = new DBConn();
		String sql = "select student_institution from student where student_username=?";
		String institution = null;
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{username});
			if(res.next()) {
				institution = res.getString("student_institution");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return institution;
	}

	@Override
	public int checkUserStatus(String username) {
		DBConn jdbc = new DBConn();
		int num = 0;
		String sql = "select * from student where student_username=?";
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{username});
			if(res.next()) {
				num = res.getInt("student_status");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return num;
	}

	@Override
	public int getUidByUserName(String username) {
		DBConn jdbc = new DBConn();
		int uid = 0;
		String sql = "select * from student where student_username=?";
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{username});
			if(res.next()) {
				uid = res.getInt("student_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return uid;
	}

	@Override
	public void activeUserById(int id) {
		DBConn jdbc = new DBConn();
		String sql = "update student set student_status=? where student_id=?";
		try {
			jdbc.do_Update(sql, new Object[]{1,id});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
	}
}
