package org.WanderlustAirways.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.WanderlustAirways.Utilis.StoreConstant;

public class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BaseController() {
		super();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher dispatcher = null;
//		if(request.getParameter(StoreConstant.MODULE)!=null || request.getParameter(StoreConstant.ACTION)!=null){
//			dispatcher = request.getRequestDispatcher("Home.jsp");
//			dispatcher.forward(request,response);
//		}
		 if(request.getParameter(StoreConstant.MODULE).equalsIgnoreCase(StoreConstant.MOD_USER)){
			dispatcher = request.getRequestDispatcher(StoreConstant.SERVLET_LOGIN);
			dispatcher.forward(request, response);
		}
		 else if(request.getParameter(StoreConstant.MODULE).equalsIgnoreCase(StoreConstant.MOD_HOME)){
			 dispatcher = request.getRequestDispatcher(StoreConstant.SERVLET_HOME);
			 dispatcher.forward(request, response);
		 }
		 else if(request.getParameter(StoreConstant.MODULE).equalsIgnoreCase(StoreConstant.MOD_ADMIN)){
			 dispatcher = request.getRequestDispatcher(StoreConstant.SERVLET_ADMIN);
			 dispatcher.forward(request, response);
		 }
		 else if(request.getParameter(StoreConstant.MODULE).equalsIgnoreCase(StoreConstant.MOD_BOOK)){
			 dispatcher = request.getRequestDispatcher(StoreConstant.SERVLET_BOOKFLIGHT);	
			 dispatcher.forward(request, response);
		 }
		 else if (request.getParameter(StoreConstant.MODULE).equalsIgnoreCase(StoreConstant.MOD_BLACKUSER)){
			 dispatcher = request.getRequestDispatcher(StoreConstant.SERVLET_CHECKUSER);
			 dispatcher.forward(request, response);
		 }
		 else if(request.getParameter(StoreConstant.MODULE).equalsIgnoreCase(StoreConstant.MOD_PAYMENT)){
			 dispatcher = request.getRequestDispatcher(StoreConstant.SERVLET_PAYMENTINFO);
			 dispatcher.forward(request, response);
		 }
		 else if(request.getParameter(StoreConstant.MODULE).equalsIgnoreCase(StoreConstant.MOD_FLIGHTSTATUS)){
			 dispatcher = request.getRequestDispatcher(StoreConstant.SERVLET_FLIGHTSTATUS);
			 dispatcher.forward(request, response);
		 }
	}
}
