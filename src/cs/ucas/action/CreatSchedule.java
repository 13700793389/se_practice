package cs.ucas.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.ucas.bean.Course;
import cs.ucas.bean.LayuiTable;
import cs.ucas.bean.PersonSchedule;
import cs.ucas.dao.CourseDAO;
import cs.ucas.dao.impl.CourseDAOImpl;
import net.sf.json.JSONArray;

@WebServlet("/getschedule")
public class CreatSchedule extends HttpServlet{
	private CourseDAO coursedao = null;
	public CreatSchedule() {
		coursedao = new CourseDAOImpl();
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
		String username = String.valueOf(req.getSession().getAttribute("cookie_username"));
		List<Course> courselist = coursedao.getMyCourseList(username);
		List<PersonSchedule> personschedulelist = new ArrayList<PersonSchedule>();
		PersonSchedule ps_1 = new PersonSchedule();
		PersonSchedule ps_2 = new PersonSchedule();
		PersonSchedule ps_3 = new PersonSchedule();
		PersonSchedule ps_4 = new PersonSchedule();
		PersonSchedule ps_5 = new PersonSchedule();
		PersonSchedule ps_6 = new PersonSchedule();
		PersonSchedule ps_7 = new PersonSchedule();
		PersonSchedule ps_8 = new PersonSchedule();
		PersonSchedule ps_9 = new PersonSchedule();
		PersonSchedule ps_10 = new PersonSchedule();
		ps_1.setNum(1);
		ps_2.setNum(2);
		ps_3.setNum(3);
		ps_4.setNum(4);
		ps_5.setNum(5);
		ps_6.setNum(6);
		ps_7.setNum(7);
		ps_8.setNum(8);
		ps_9.setNum(9);
		ps_10.setNum(10);
		personschedulelist.add(ps_1);
		personschedulelist.add(ps_2);
		personschedulelist.add(ps_3);
		personschedulelist.add(ps_4);
		personschedulelist.add(ps_5);
		personschedulelist.add(ps_6);
		personschedulelist.add(ps_7);
		personschedulelist.add(ps_8);
		personschedulelist.add(ps_9);
		personschedulelist.add(ps_10);
		
		for (Course course : courselist) {
			String info = course.getCourse_name() + ":" + course.getCourse_site() + "("+ course.getCourse_week() + "周)";
			String sec = course.getCourse_section();
			String[] lines = sec.split("-");
			for(String l : lines) {
				String[] line = l.split("\\|");
				String[] rows = line[1].split("\\.");
				for(String r:rows) {
					switch(r){
			        case "1":
			            if(line[0].equals("1")) {
			            	ps_1.setMonday(info);
			            }else if(line[0].equals("2")) {
			            	ps_1.setTuesday(info);
			            }else if(line[0].equals("3")) {
			            	ps_1.setWednesday(info);
			            }else if(line[0].equals("4")) {
			            	ps_1.setThursday(info);
			            }else if(line[0].equals("5")) {
			            	ps_1.setFriday(info);
			            }else if(line[0].equals("6")) {
			            	ps_1.setSaturday(info);
			            }else if(line[0].equals("7")) {
			            	ps_1.setSunday(info);
			            }
			            break;
			        case "2":
			            if(line[0].equals("1")) {
			            	ps_2.setMonday(info);
			            }else if(line[0].equals("2")) {
			            	ps_2.setTuesday(info);
			            }else if(line[0].equals("3")) {
			            	ps_2.setWednesday(info);
			            }else if(line[0].equals("4")) {
			            	ps_2.setThursday(info);
			            }else if(line[0].equals("5")) {
			            	ps_2.setFriday(info);
			            }else if(line[0].equals("6")) {
			            	ps_2.setSaturday(info);
			            }else if(line[0].equals("7")) {
			            	ps_2.setSunday(info);
			            }
			        	break;
			        case "3":
			            if(line[0].equals("1")) {
			            	ps_3.setMonday(info);
			            }else if(line[0].equals("2")) {
			            	ps_3.setTuesday(info);
			            }else if(line[0].equals("3")) {
			            	ps_3.setWednesday(info);
			            }else if(line[0].equals("4")) {
			            	ps_3.setThursday(info);
			            }else if(line[0].equals("5")) {
			            	ps_3.setFriday(info);
			            }else if(line[0].equals("6")) {
			            	ps_3.setSaturday(info);
			            }else if(line[0].equals("7")) {
			            	ps_3.setSunday(info);
			            }
			            break;
			        case "4":
			            if(line[0].equals("1")) {
			            	ps_4.setMonday(info);
			            }else if(line[0].equals("2")) {
			            	ps_4.setTuesday(info);
			            }else if(line[0].equals("3")) {
			            	ps_4.setWednesday(info);
			            }else if(line[0].equals("4")) {
			            	ps_4.setThursday(info);
			            }else if(line[0].equals("5")) {
			            	ps_4.setFriday(info);
			            }else if(line[0].equals("6")) {
			            	ps_4.setSaturday(info);
			            }else if(line[0].equals("7")) {
			            	ps_4.setSunday(info);
			            }
			            break;
			        case "5":
			            if(line[0].equals("1")) {
			            	ps_5.setMonday(info);
			            }else if(line[0].equals("2")) {
			            	ps_5.setTuesday(info);
			            }else if(line[0].equals("3")) {
			            	ps_5.setWednesday(info);
			            }else if(line[0].equals("4")) {
			            	ps_5.setThursday(info);
			            }else if(line[0].equals("5")) {
			            	ps_5.setFriday(info);
			            }else if(line[0].equals("6")) {
			            	ps_5.setSaturday(info);
			            }else if(line[0].equals("7")) {
			            	ps_5.setSunday(info);
			            }
			            break;
			        case "6":
			            if(line[0].equals("1")) {
			            	ps_6.setMonday(info);
			            }else if(line[0].equals("2")) {
			            	ps_6.setTuesday(info);
			            }else if(line[0].equals("3")) {
			            	ps_6.setWednesday(info);
			            }else if(line[0].equals("4")) {
			            	ps_6.setThursday(info);
			            }else if(line[0].equals("5")) {
			            	ps_6.setFriday(info);
			            }else if(line[0].equals("6")) {
			            	ps_6.setSaturday(info);
			            }else if(line[0].equals("7")) {
			            	ps_6.setSunday(info);
			            }
			            break;
			        case "7":
			            if(line[0].equals("1")) {
			            	ps_7.setMonday(info);
			            }else if(line[0].equals("2")) {
			            	ps_7.setTuesday(info);
			            }else if(line[0].equals("3")) {
			            	ps_7.setWednesday(info);
			            }else if(line[0].equals("4")) {
			            	ps_7.setThursday(info);
			            }else if(line[0].equals("5")) {
			            	ps_7.setFriday(info);
			            }else if(line[0].equals("6")) {
			            	ps_7.setSaturday(info);
			            }else if(line[0].equals("7")) {
			            	ps_7.setSunday(info);
			            }
			            break;
			        case "8":
			            if(line[0].equals("1")) {
			            	ps_8.setMonday(info);
			            }else if(line[0].equals("2")) {
			            	ps_8.setTuesday(info);
			            }else if(line[0].equals("3")) {
			            	ps_8.setWednesday(info);
			            }else if(line[0].equals("4")) {
			            	ps_8.setThursday(info);
			            }else if(line[0].equals("5")) {
			            	ps_8.setFriday(info);
			            }else if(line[0].equals("6")) {
			            	ps_8.setSaturday(info);
			            }else if(line[0].equals("7")) {
			            	ps_8.setSunday(info);
			            }
			            break;
			        case "9":
			            if(line[0].equals("1")) {
			            	ps_9.setMonday(info);
			            }else if(line[0].equals("2")) {
			            	ps_9.setTuesday(info);
			            }else if(line[0].equals("3")) {
			            	ps_9.setWednesday(info);
			            }else if(line[0].equals("4")) {
			            	ps_9.setThursday(info);
			            }else if(line[0].equals("5")) {
			            	ps_9.setFriday(info);
			            }else if(line[0].equals("6")) {
			            	ps_9.setSaturday(info);
			            }else if(line[0].equals("7")) {
			            	ps_9.setSunday(info);
			            }
			            break;
			        case "10":
			            if(line[0].equals("1")) {
			            	ps_10.setMonday(info);
			            }else if(line[0].equals("2")) {
			            	ps_10.setTuesday(info);
			            }else if(line[0].equals("3")) {
			            	ps_10.setWednesday(info);
			            }else if(line[0].equals("4")) {
			            	ps_10.setThursday(info);
			            }else if(line[0].equals("5")) {
			            	ps_10.setFriday(info);
			            }else if(line[0].equals("6")) {
			            	ps_10.setSaturday(info);
			            }else if(line[0].equals("7")) {
			            	ps_10.setSunday(info);
			            }
			            break;
			        default:
			            System.out.println("default");break;
			        }
				}
			}
		}
		LayuiTable<PersonSchedule> tableres = new LayuiTable<PersonSchedule>();
		tableres.setStatus(200);
		tableres.setMessage("");
		tableres.setTotal(coursedao.getTotalCourseNum());
		tableres.setRows(personschedulelist);
		resp.getWriter().write(JSONArray.fromObject(tableres).toString());
	}
}
