package org.WanderlustAirways.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.WanderlustAirways.Dbutilis.DbManager;
import org.WanderlustAirways.VO.PaymentVo;

public class PaymentDAO {
	private Connection connection;
	public PaymentDAO() {
		connection = DbManager.getConnection();
	}
	public void UserPayment(PaymentVo paymentVo){
		String sql = "INSERT INTO PAYMENTINFO(flight_Id,user_Id,cardType,cardHolderName) VALUES(?,?,?,?)";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,paymentVo.getFlightId());
			preparedStatement.setInt(2,paymentVo.getUserId());
			preparedStatement.setString(3,paymentVo.getCardType());
			preparedStatement.setString(4,paymentVo.getCardHolderName());
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
