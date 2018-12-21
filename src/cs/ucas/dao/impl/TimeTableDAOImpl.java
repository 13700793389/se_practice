package cs.ucas.dao.impl;

import java.sql.ResultSet;

import cs.ucas.dao.TimeTableDAO;
import cs.ucas.db.DBConn;

public class TimeTableDAOImpl implements TimeTableDAO {
	@Override
	public int getTimetable_can() {
		DBConn jdbc = new DBConn();
		int can = 0;
		String sql = "select * from timetable";
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{});
			if(res.next()) {
				can = res.getInt("timetable_can");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return can;
	}


	@Override
	public int updateTimetable_can(int can) {
		DBConn jdbc = new DBConn();
		String sql = "update timetable set timetable_can = ? where timetable_id = ?";
		int res = 0;
		try {
			res = jdbc.do_Update(sql, new Object[]{can,1});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return res;
	}

}
