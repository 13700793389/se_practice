package cs.ucas.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs.ucas.dao.StudentDAO;
import cs.ucas.dao.impl.StudentDAOImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private StudentDAO studao = null;
	public LoginServlet() {
		studao = new StudentDAOImpl();
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
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		int res = studao.checkUser(username, password);
		if(res==1) {
			String institution = studao.getInstitution(username);
			HttpSession session = req.getSession();
			session.setAttribute("cookie_username", username);
			session.setAttribute("cookie_institution", institution);
		}
		resp.getWriter().print(res);
	}
}
