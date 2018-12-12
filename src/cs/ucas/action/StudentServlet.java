package cs.ucas.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.ucas.bean.LayuiTable;
import cs.ucas.bean.Student;
import cs.ucas.dao.StudentDAO;
import cs.ucas.dao.impl.StudentDAOImpl;
import net.sf.json.JSONArray;

@WebServlet("/getstdlist")
public class StudentServlet extends HttpServlet{
	private StudentDAO studao = null;
	public StudentServlet() {
		studao = new StudentDAOImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		int page = Integer.parseInt(req.getParameter("page"));
		int limit = Integer.parseInt(req.getParameter("limit"));
		List<Student> stulist = studao.getStudentListBypage(page, limit);
		LayuiTable<Student> tableres = new LayuiTable<Student>();
		tableres.setStatus(200);
		tableres.setMessage("");
		tableres.setTotal(studao.getTotalStuNum());
		tableres.setRows(stulist);
		// System.out.println(JSONArray.fromObject(stulist));
		resp.getWriter().write(JSONArray.fromObject(tableres).toString());

	}
}
