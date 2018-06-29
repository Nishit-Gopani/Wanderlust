package org.WanderlustAirways.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.WanderlustAirways.Dbutilis.DbManager;
import org.WanderlustAirways.VO.FlightSearchVo;
import org.WanderlustAirways.VO.FlightstatusVO;

public class FlightStatusDAO {
	private Connection connection;

	public FlightStatusDAO() {
		connection = DbManager.getConnection();
	}
	public List<FlightstatusVO> flightstatus(String flightNumber,String Flight_Date){
		List<FlightstatusVO> list = new ArrayList<FlightstatusVO>();
		String Sql = "select * from flight_status WHERE flightNo = "+ flightNumber + " AND flightDate = "+ Flight_Date +"";
		try {
			PreparedStatement preparedStatement  = connection.prepareStatement(Sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				FlightstatusVO flightstatusVO = new FlightstatusVO();
				flightstatusVO.setFlightStatusId(resultSet.getInt("flightstatus_id"));
				flightstatusVO.setFlightno(resultSet.getString("flightNo"));
				flightstatusVO.setArrivalTime(resultSet.getString("arrival_time"));
				flightstatusVO.setDepartureTime(resultSet.getString("departure_time"));
				flightstatusVO.setOriginCode(resultSet.getString("origin_code"));
				flightstatusVO.setDestinationCode(resultSet.getString("destination_code"));
				list.add(flightstatusVO); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
  	}
}
