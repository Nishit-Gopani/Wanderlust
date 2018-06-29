package org.WanderlustAirways.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.WanderlustAirways.DAO.UserDAO;
import org.WanderlustAirways.Utilis.EmailUtilis;
import org.WanderlustAirways.Utilis.StoreConstant;
import org.WanderlustAirways.VO.UserVo;
import org.json.JSONObject;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
	private String host;
	private String port;
	private String user;
	private String pass;
	String resultMessage = "";
	public LoginController() {
		super();
		dao = new UserDAO();
	}
	 public void init() {
			// reads SMTP server setting from web.xml file
			ServletContext context = getServletContext();
			host = context.getInitParameter("host");
			port = context.getInitParameter("port");
			user = context.getInitParameter("user");
			pass = context.getInitParameter("pass");
		}
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			JSONObject jsonObject = new JSONObject();
		if(request.getParameter(StoreConstant.ACTION)!=null && request.getParameter(StoreConstant.ACTION).equalsIgnoreCase(StoreConstant.ACTION_REGISTRATION)){
			try{
				if(request.getParameter("fname")!=null && request.getParameter("lname")!=null && request.getParameter("passportno")!=null && request.getParameter("address")!=null && request.getParameter("emailid")!=null && request.getParameter("contactno")!=null){
					response.setContentType("text/html");
					PrintWriter out = response.getWriter(); 
					UserVo userVo = new UserVo();
					userVo.setUser_role(StoreConstant.USER_ROLE);
					userVo.setFirst_Name(request.getParameter("fname"));
					userVo.setLast_Name(request.getParameter("lname"));
					userVo.setPassport_No(request.getParameter("passportno"));
					userVo.setAddress(request.getParameter("address"));
					userVo.setEmail_Id(request.getParameter("emailid"));
					userVo.setContact_No(Long.parseLong(request.getParameter("contactno")));
					userVo.setPassword(StoreConstant.PASSWORD);
					try {
						EmailUtilis.sendEmail(host, port, user, pass,request.getParameter("emailid"),StoreConstant.SUBJECT,
								StoreConstant.PASSWORD);
						dao.registerUser(userVo);
						resultMessage = "Password Email you successfully";
						out.println("<script type=\"text/javascript\">");
						   out.println("alert(resultMessage);");
						   out.println("</script>");
//						jsonObject.put("message",resultMessage + "U are registered Successfully");
//						jsonObject.put("isSuccess",true);
					} catch (Exception ex) {
						ex.printStackTrace();
						resultMessage = "There were an error: " + ex.getMessage();
					} 
				}else{
					 jsonObject.put("message", "Parameter Failure");
					 jsonObject.put("isSuccess",false);
				}
				 response.getWriter().write(jsonObject.toString());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(request.getParameter(StoreConstant.ACTION)!=null && request.getParameter(StoreConstant.ACTION).equalsIgnoreCase(StoreConstant.ACTION_SIGNUP)){ 
			if(request.getParameter("email")!=null && request.getParameter("password")!=null){
			try{
				UserVo userVo = dao.Authenticate(request.getParameter("email"),request.getParameter("password"));
				HttpSession session = request.getSession(true);
				HttpSession httpSession = request.getSession(true); 
				
				String emailId = userVo.getEmail_Id();
				int userId = userVo.getUser_Id();
				int user_role= userVo.getUser_role();
				if(user_role==1){
					session.setAttribute("currentUser",emailId);
					httpSession.setAttribute("userId", userId);
					response.sendRedirect(StoreConstant.SERVLET_BASE+"?"+StoreConstant.MODULE+"="+StoreConstant.MOD_ADMIN+"&"+StoreConstant.ACTION+"="+StoreConstant.ACTION_VIEW);
				}else{
				session.setAttribute("currentUser",emailId);
				httpSession.setAttribute("userId", userId);
				response.sendRedirect(StoreConstant.SERVLET_BASE+"?"+StoreConstant.MODULE+"="+StoreConstant.MOD_HOME+"&"+StoreConstant.ACTION+"="+StoreConstant.ACTION_VIEW);
				}
			}catch(Throwable e){
				RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
				if (e.getMessage() == null && e.getCause() != null) {
					request.setAttribute("message", e.getCause().getMessage());
				} else if (e.getMessage() != null) {
					request.setAttribute("message", e.getMessage());
				} else {
					StringWriter stringWriter = new StringWriter();
					e.printStackTrace(new PrintWriter(stringWriter));
					request.setAttribute("message", "<pre>" + stringWriter.toString() + "</pre>");
				}
				dispatcher.forward(request, response);
		   }
		}
	  }
		else if(request.getParameter(StoreConstant.ACTION)!=null && request.getParameter(StoreConstant.ACTION).equalsIgnoreCase(StoreConstant.ACTION_SIGNOUT)){
			HttpSession session = request.getSession();
			if (session != null) {
				session.removeAttribute("currentUser");
				session.invalidate();
				response.sendRedirect(StoreConstant.SERVLET_BASE+"?"+StoreConstant.MODULE+"="+StoreConstant.MOD_HOME+"&"+StoreConstant.ACTION+"="+StoreConstant.ACTION_SIGNOUT);
		}
	}
}
	}
