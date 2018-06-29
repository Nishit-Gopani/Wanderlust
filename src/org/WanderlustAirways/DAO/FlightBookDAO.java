package org.WanderlustAirways.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.WanderlustAirways.Dbutilis.DbManager;
import org.WanderlustAirways.VO.FlightSearchVo;

public class FlightBookDAO {
	private Connection connection;

	public FlightBookDAO() {
		connection = DbManager.getConnection();
	}
	public List<FlightSearchVo> SearchFlight(String From,String To,String Flight_Date){
		List<FlightSearchVo> list = new ArrayList<FlightSearchVo>();
		String Sql = "select * from flight_book where origin_code = '"+ From +"' AND Destination_code = '"+ To + "'AND Flight_Date ='"+ Flight_Date +"'";
		try {
			PreparedStatement preparedStatement  = connection.prepareStatement(Sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				FlightSearchVo bookVo = new FlightSearchVo();
				bookVo.setFlightId(resultSet.getInt("Flight_Id"));
				bookVo.setFlightName(resultSet.getString("Flight_Name"));
				bookVo.setOriginCode(resultSet.getString("Origin_code"));
				bookVo.setDestinationCode(resultSet.getString("Destination_code"));
				bookVo.setFlightDate(resultSet.getString("Flight_Date"));
				bookVo.setFlightName(resultSet.getString("Flight_Name"));
				bookVo.setDepatureTime(resultSet.getString("Flight_Dept_Time"));
				bookVo.setArrivalTime(resultSet.getString("Flight_Arrival_Time"));
				bookVo.setPrice(resultSet.getString("Price"));
				list.add(bookVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
  	}
}
 