package org.WanderlustAirways.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.WanderlustAirways.Dbutilis.DbManager;
import org.WanderlustAirways.VO.BlacklistedVO;

public class BlacklistedDAO {
	private Connection connection;

	public BlacklistedDAO() {
		connection = DbManager.getConnection();
	}
	public BlacklistedVO checkUser(int user_Id){
		String sql = "select * from blacklisted_user where user_Id=?";
		BlacklistedVO blacklistedVO = new BlacklistedVO();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_Id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				blacklistedVO.setBlacklisted_Id(resultSet.getInt("blacklisted_Id"));
				blacklistedVO.setStar(resultSet.getInt("Star"));
				blacklistedVO.setUser_Id(resultSet.getInt("user_Id"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return blacklistedVO;
	}
	public List<BlacklistedVO> getUserDetails(){
		String sql = "SELECT * FROM   blacklisted_user INNER JOIN travel.USER on USER.USER_ID=blacklisted_user.user_Id";
		List<BlacklistedVO> list = new ArrayList<BlacklistedVO>();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				BlacklistedVO blacklistedVO = new BlacklistedVO();
				blacklistedVO.setBlacklisted_Id(resultSet.getInt("blacklisted_Id"));
				blacklistedVO.setUser_Id(resultSet.getInt("user_Id"));
				blacklistedVO.setEmail_Id(resultSet.getString("user_email"));
				//blacklistedVO.setUser_name(resultSet.getString("user_name"));
				blacklistedVO.setUser_Lname(resultSet.getString("user_Lname"));
				blacklistedVO.setPassportNumber(resultSet.getString("passport_number"));
				list.add(blacklistedVO);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
}
