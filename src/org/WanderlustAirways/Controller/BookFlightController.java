package org.WanderlustAirways.Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.WanderlustAirways.DAO.FlightBookDAO;
import org.WanderlustAirways.Utilis.StoreConstant;
import org.WanderlustAirways.VO.FlightSearchVo;

public class BookFlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightBookDAO dao;
	public BookFlightController() {
		super();
		dao = new FlightBookDAO();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter(StoreConstant.ACTION)!=null && request.getParameter(StoreConstant.ACTION).equalsIgnoreCase(StoreConstant.ACTION_SEARCH)){
			try{
				if(request.getParameter("from")!=null && request.getParameter("To")!=null && request.getParameter("depdate")!=null){
					String From = request.getParameter("from");
					String To = request.getParameter("To");
					String Flight_Date = request.getParameter("depdate");
					HttpSession httpSession = request.getSession(true);
					FlightSearchVo flightSearchVo = new FlightSearchVo();
					List<FlightSearchVo> list = dao.SearchFlight(From,To,Flight_Date);
					request.setAttribute("list",list);
					RequestDispatcher rd= request.getRequestDispatcher("searchFlight.jsp");
					rd.forward(request, response);
				}
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
}
