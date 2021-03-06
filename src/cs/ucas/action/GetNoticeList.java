package cs.ucas.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.ucas.bean.LayuiTable;
import cs.ucas.bean.Notice;
import cs.ucas.dao.NoticeDAO;
import cs.ucas.dao.impl.NoticeDAOImpl;
import net.sf.json.JSONArray;

@WebServlet("/getnoticelist")
public class GetNoticeList extends HttpServlet{
	private NoticeDAO noticedao = null;
	public GetNoticeList() {
		noticedao = new NoticeDAOImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		int page = Integer.parseInt(req.getParameter("page"));
		int limit = Integer.parseInt(req.getParameter("limit"));
		List<Notice> noticelist;
		noticelist = noticedao.getNoticeListBypage(page, limit);
		LayuiTable<Notice> tableres = new LayuiTable<Notice>();
		tableres.setStatus(200);
		tableres.setMessage("");
		tableres.setTotal(noticedao.getTotalNoticeNum());
		tableres.setRows(noticelist);
		resp.getWriter().write(JSONArray.fromObject(tableres).toString());
	}
}
