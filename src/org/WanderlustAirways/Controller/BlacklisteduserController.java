package org.WanderlustAirways.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.WanderlustAirways.DAO.BlacklistedDAO;
import org.WanderlustAirways.Utilis.StoreConstant;
import org.WanderlustAirways.VO.BlacklistedVO;
import org.WanderlustAirways.VO.PaymentVo;
import org.json.JSONException;
import org.json.JSONObject;

public class BlacklisteduserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlacklistedDAO dao;

	public BlacklisteduserController() {
		super();
		dao = new BlacklistedDAO();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter(StoreConstant.ACTION)!=null && request.getParameter(StoreConstant.ACTION).equalsIgnoreCase(StoreConstant.ACTION_CHECK)){
			try{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				JSONObject jsonObject = new JSONObject();
				if(request.getParameter("user_Id")!=null){
					BlacklistedVO blacklistedVO = new BlacklistedVO() ;
					blacklistedVO.setUser_Id(Integer.parseInt(request.getParameter("user_Id")));
					blacklistedVO=dao.checkUser(Integer.parseInt(request.getParameter("user_Id")));
					int star = blacklistedVO.getStar();
					if(star==1){
						jsonObject.put("message","We Need Your More Information");
						jsonObject.put("isSuccess",star);
						response.getWriter().write(jsonObject.toString());
					}
					else if(star==2){
						jsonObject.put("message","Redirecting to Payment Page");
						jsonObject.put("isSuccess",star);
						response.getWriter().write(jsonObject.toString());				
						}
					else if (star==3){
						jsonObject.put("message","SORRY U can't Proceed Contact Customer Department For that");
						jsonObject.put("isSuccess",false);
						response.getWriter().write(jsonObject.toString());
//						RequestDispatcher dispatcher = request.getRequestDispatcher("");
//						dispatcher.forward(request, response);
					}
					else{
						jsonObject.put("message","Redirecting to Payment Page");
						jsonObject.put("isSuccess",true);
						response.getWriter().write(jsonObject.toString());		
					}
				}
			}catch(Exception e){
				 System.out.println(e);
			}
		}
		else if(request.getParameter(StoreConstant.ACTION)!=null && request.getParameter(StoreConstant.ACTION).equalsIgnoreCase(StoreConstant.ACTION_SELECTION)){
			JSONObject jsonObject = new JSONObject();
			try{
				if(request.getParameter("flightId")!=null){
					int flight_Id=Integer.parseInt(request.getParameter("flightId"));
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("flight_Id",flight_Id);
					jsonObject.put("message","Fill Out same Basic Question");
					jsonObject.put("isSuccess", true);
					response.getWriter().write(jsonObject.toString());				
				}
			}catch(Exception e){
				System.out.println(e);
			}
		}
		else if(request.getParameter(StoreConstant.ACTION)!=null && request.getParameter(StoreConstant.ACTION).equalsIgnoreCase(StoreConstant.ACTION_BLACKLISTEDUSERDETAILS)){
			try{
				List<BlacklistedVO> list = dao.getUserDetails();
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("list",list);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("isSuccess", true);
				jsonObject.put("message", "Blacklisted User");
  			}catch(Exception e){
				System.out.println(e);
			}
		}
		
	}
}
