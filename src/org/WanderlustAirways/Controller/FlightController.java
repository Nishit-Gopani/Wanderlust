package org.WanderlustAirways.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.WanderlustAirways.DAO.FlightBookDAO;
import org.WanderlustAirways.DAO.FlightStatusDAO;
import org.WanderlustAirways.Utilis.StoreConstant;
import org.WanderlustAirways.VO.FlightSearchVo;
import org.WanderlustAirways.VO.FlightstatusVO;

public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightStatusDAO dao;
	public FlightController() {
		super();
		dao = new FlightStatusDAO();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter(StoreConstant.ACTION)!=null && request.getParameter(StoreConstant.ACTION).equalsIgnoreCase(StoreConstant.ACTION_FLIGHTSTATUS)){
			try{
				if(request.getParameter("flightNumber")!=null && request.getParameter("flightdate")!=null){
					String flightNumber = request.getParameter("flightNumber");
					String Flight_Date = request.getParameter("flightdate");
					FlightstatusVO flightstatusVO = new FlightstatusVO();
					List<FlightstatusVO> list = dao.flightstatus(flightNumber, Flight_Date);
					request.setAttribute("list",list);
					RequestDispatcher rd= request.getRequestDispatcher("flightstatus.jsp");
					rd.forward(request, response);
				}
			}catch(Exception e){
				System.out.println(e);
			}
		}
}
}
