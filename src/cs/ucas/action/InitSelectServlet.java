package cs.ucas.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.ucas.dao.TimeTableDAO;
import cs.ucas.dao.impl.TimeTableDAOImpl;

@WebServlet("/initselect")
public class InitSelectServlet extends HttpServlet{
	private TimeTableDAO timetableDAO= null;
	public InitSelectServlet() {
		timetableDAO = new TimeTableDAOImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int res = 0;
		res = timetableDAO.getTimetable_can();
		resp.getWriter().print(res);
	}
}
