package cs.ucas.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs.ucas.dao.AdminDAO;
import cs.ucas.dao.StudentDAO;
import cs.ucas.dao.impl.AdminDAOImpl;
import cs.ucas.dao.impl.StudentDAOImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private StudentDAO studao = null;
	private AdminDAO admindao = null;
	public static final String SMTPSERVER = "smtp.163.com";
    public static final String SMTPPORT = "465";
    public static final String ACCOUT = "13700793389@163.com";
    public static final String PWD = "qqmima618";
	public LoginServlet() {
		studao = new StudentDAOImpl();
		admindao = new AdminDAOImpl();
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
		int res = 0;
		res = studao.checkUser(username, password);
		if(res == 1) {
			int status = studao.checkUserStatus(username);
			if(status==0) {
				try {
					sendMail(username,studao.getUidByUserName(username));
				} catch (Exception e) {
					e.printStackTrace();
				}
				res = 2;//账户名密码正确但未激活
			} else {
				String institution = studao.getInstitution(username);
				HttpSession session = req.getSession();
				session.setAttribute("cookie_username", username);
				session.setAttribute("cookie_institution", institution);
			}
		} else {
			res = admindao.checkAdmin(username, password);
			if(res == 1) {
				res = 3;//管理员
			}
		}
		resp.getWriter().print(res);
	}
	private void sendMail(String receiveAdd,int id) throws Exception {
		// 创建邮件配置
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", SMTPSERVER); // 发件人的邮箱的 SMTP 服务器地址
		props.setProperty("mail.smtp.port", SMTPPORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.auth", "true"); // 需要请求认证
		props.setProperty("mail.smtp.ssl.enable", "true");// 开启ssl

        // 根据邮件配置创建会话，注意session别导错包
        Session session = Session.getDefaultInstance(props);
        // 开启debug模式，可以看到更多详细的输入日志
        session.setDebug(true);
        //创建邮件
        MimeMessage message = createEmail(session,receiveAdd,id);
        //获取传输通道
        Transport transport = session.getTransport();
        transport.connect(SMTPSERVER,ACCOUT, PWD);
        //连接，并发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
	}

	public MimeMessage createEmail(Session session,String receiveAdd,int id) throws Exception {
		// 根据会话创建邮件
		MimeMessage msg = new MimeMessage(session);
		// address邮件地址, personal邮件昵称, charset编码方式
		InternetAddress fromAddress = new InternetAddress(ACCOUT, "UCAS选课系统", "utf-8");
		// 设置发送邮件方
		msg.setFrom(fromAddress);
		InternetAddress receiveAddress = new InternetAddress(receiveAdd, "Active", "utf-8");
		// 设置邮件接收方
		msg.setRecipient(RecipientType.TO, receiveAddress);
		// 设置邮件标题
		msg.setSubject("请激活您的账号", "utf-8");
		msg.setContent("<h1>Active your account</h1><h3><a href='https://ucassepractice.herokuapp.com/activemail?uid=" + id
				+ "'>_Active_</a></h3>", "text/html;chraset=utf-8");
		// 设置显示的发件时间
		msg.setSentDate(new Date());
		// 保存设置
		msg.saveChanges();
		return msg;
	}
}
