package org.WanderlustAirways.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.WanderlustAirways.DAO.PaymentDAO;
import org.WanderlustAirways.Utilis.StoreConstant;
import org.WanderlustAirways.VO.PaymentVo;
import org.json.JSONException;
import org.json.JSONObject;
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaymentDAO dao;
  
    public PaymentController() {
        super();
        dao = new PaymentDAO();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(request.getParameter(StoreConstant.ACTION)!=null && request.getParameter(StoreConstant.ACTION).equalsIgnoreCase(StoreConstant.ACTION_PAYMENT)){
			 JSONObject jsonObject = new JSONObject();
			try{
				if(request.getParameter("user_Id")!=null && request.getParameter("flight_Id")!=null && request.getParameter("cardType")!=null && request.getParameter("cardholder")!=null){
					PaymentVo paymentVo = new PaymentVo();
					paymentVo.setUserId(Integer.parseInt(request.getParameter("user_Id")));
					paymentVo.setFlightId(Integer.parseInt(request.getParameter("flight_Id")));
					paymentVo.setCardType(request.getParameter("cardType"));
					paymentVo.setCardHolderName(request.getParameter("cardholder"));
					dao.UserPayment(paymentVo);
					jsonObject.put("message","Payment Done Successfully");
					jsonObject.put("isSuccess", true);
					response.getWriter().write(jsonObject.toString());
			}else{
				jsonObject.put("message", "Oops Error in payment");
				jsonObject.put("isSuccess", false);
				response.getWriter().write(jsonObject.toString());
			}
		}
		catch(Throwable e){
			System.out.println(e);
			}
		 }
	 }
}
