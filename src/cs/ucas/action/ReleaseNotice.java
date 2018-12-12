package cs.ucas.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.ucas.bean.Notice;
import cs.ucas.dao.NoticeDAO;
import cs.ucas.dao.impl.NoticeDAOImpl;

@WebServlet("/releasenotice")
public class ReleaseNotice extends HttpServlet{
	NoticeDAO noticedao = null;
	public ReleaseNotice() {
		noticedao = new NoticeDAOImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		Notice notice = new Notice();
		notice.setNotice_title(req.getParameter("title"));
		notice.setNotice_time(req.getParameter("date"));
		notice.setNotice_department(req.getParameter("department"));
		notice.setNotice_content(req.getParameter("content"));
		int flag = 0;//1表示添加成功 other 出错了
		if(noticedao.releaseNewNotice(notice)==1) {
			flag = 1;
		}
		resp.getWriter().print(flag);
	}
}
