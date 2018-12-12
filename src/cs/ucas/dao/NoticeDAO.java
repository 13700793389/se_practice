package cs.ucas.dao;

import java.util.List;

import cs.ucas.bean.Notice;

public interface NoticeDAO {
	public List<Notice> getNoticeListBypage(int page,int limit);
	public int getTotalNoticeNum();
	public List<Notice> getNoticeDetail(int notice_id);
	public int releaseNewNotice(Notice notice);
}
