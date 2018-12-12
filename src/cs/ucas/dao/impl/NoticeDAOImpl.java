package cs.ucas.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cs.ucas.bean.Notice;
import cs.ucas.dao.NoticeDAO;
import cs.ucas.db.DBConn;

public class NoticeDAOImpl implements NoticeDAO{

	@Override
	public List<Notice> getNoticeListBypage(int page, int limit) {
		List<Notice> noticeList = new ArrayList<Notice>();
		DBConn jdbc = new DBConn();
		String sql = "select * from notice limit ?,?";
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{(page-1)*limit,limit});
			while(res.next()) {
				Notice notice = new Notice();
				//SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-mm-dd");
				notice.setNotice_id(res.getInt("notice_id"));
				notice.setNotice_title(res.getString("notice_title"));
				notice.setNotice_time(res.getString("notice_time"));
				notice.setNotice_department(res.getString("notice_department"));
				notice.setNotice_content(res.getString("notice_content"));
				noticeList.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return noticeList;
	}

	@Override
	public int getTotalNoticeNum() {
		DBConn jdbc = new DBConn();
		String sql = "select count(*) as t from notice";
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
	public List<Notice> getNoticeDetail(int notice_id) {
		List<Notice> noticeList = new ArrayList<Notice>();
		DBConn jdbc = new DBConn();
		String sql = "select * from notice where notice_id=?";
		try {
			ResultSet res = jdbc.do_Query(sql, new Object[]{notice_id});
			while(res.next()) {
				Notice notice = new Notice();
				notice.setNotice_id(res.getInt("notice_id"));
				notice.setNotice_title(res.getString("notice_title"));
				notice.setNotice_time(res.getString("notice_time"));
				notice.setNotice_department(res.getString("notice_department"));
				notice.setNotice_content(res.getString("notice_content"));
				noticeList.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return noticeList;
	}

	@Override
	public int releaseNewNotice(Notice notice) {
		DBConn jdbc = new DBConn();
		String sql = "insert into notice (notice_title,notice_time,notice_department,notice_content) values (?,?,?,?)";
		int flag = 0;
		try {
			flag = jdbc.do_Update(sql, new Object[]{notice.getNotice_title(),notice.getNotice_time(),notice.getNotice_department(),notice.getNotice_content()});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbc.do_close();
		}
		return flag;
	}
}
