package cs.ucas.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	private String dbDriver;
	private String url;
	private String user;
	private String passWord;
	private Connection conn;
	public Connection getConn() throws Exception {
		dbDriver="com.mysql.cj.jdbc.Driver";
		url="jdbc:mysql://xefi550t7t6tjn36.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/btl9rfhq64v81frm?useSSL=false&serverTimezone=GMT%2B8";
		user="eiqhs5i9s0walyqp";
		passWord="jro1pouhgy930a1p";
		Class.forName(dbDriver);
		conn = DriverManager.getConnection(url, user, passWord);
		return conn;
	}
	public int do_Update(String sql,Object[] params) {
		int res = 0;
		try {
			conn = this.getConn();
			PreparedStatement st = conn.prepareStatement(sql);
			for(int i=0; i<params.length; i++) {
				st.setObject(i+1, params[i]);
			}
			res = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	public ResultSet do_Query(String sql,Object[] params) {
		ResultSet res = null;
		try {
			conn = this.getConn();
			PreparedStatement st = conn.prepareStatement(sql);
			for(int i=0; i<params.length; i++) {
				st.setObject(i+1, params[i]);
			}
			res = st.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	public void do_close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}