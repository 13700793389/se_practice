package cs.ucas.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.ucas.dao.StudentDAO;
import cs.ucas.dao.impl.StudentDAOImpl;

@WebServlet("/activemail")
public class ActiveServlet extends HttpServlet{
	private StudentDAO studao = null;
	public ActiveServlet() {
		studao = new StudentDAOImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userid = Integer.parseInt(req.getParameter("uid"));
		studao.activeUserById(userid);
		resp.sendRedirect("activesuccess.html");
	}
}
