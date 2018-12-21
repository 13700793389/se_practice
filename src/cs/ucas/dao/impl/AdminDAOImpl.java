package cs.ucas.dao.impl;

import java.sql.ResultSet;

import cs.ucas.dao.AdminDAO;
import cs.ucas.db.DBConn;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public int checkAdmin(String username, String password) {
		DBConn jdbc = new DBConn();
		int num = 0;
		String sql = "select * from admin where admin_username=? and admin_password=?";
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

}
