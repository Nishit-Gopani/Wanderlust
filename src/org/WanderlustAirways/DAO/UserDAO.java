package org.WanderlustAirways.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.WanderlustAirways.Dbutilis.DbManager;
import org.WanderlustAirways.VO.UserVo;

import com.mysql.jdbc.Statement;

public class UserDAO {
	private Connection connection;

	public UserDAO() {
		connection = DbManager.getConnection();
	}

	public void registerUser(UserVo userVo) {
		String Sql = "INSERT INTO USER(user_role,user_name,user_lname,passport_number,user_email,address,phone_number,password) VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(Sql);
			preparedStatement.setInt(1, userVo.getUser_role());
			preparedStatement.setString(2, userVo.getFirst_Name());
			preparedStatement.setString(3, userVo.getLast_Name());
			preparedStatement.setString(4, userVo.getPassport_No());
			preparedStatement.setString(5, userVo.getEmail_Id());
			preparedStatement.setString(6, userVo.getAddress());
			preparedStatement.setLong(7, userVo.getContact_No());
			preparedStatement.setString(8, userVo.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public UserVo Authenticate(String emailId, String Password) throws Exception{
	 try{	
		UserVo userVo = new UserVo();
		String sql = "SELECT * FROM USER WHERE USER_EMAIL='" + emailId + "'AND PASSWORD='" + Password + "'";
		java.sql.Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		if(resultSet.next()){
			if(emailId.equals(resultSet.getString("USER_EMAIL")) && Password.equals(resultSet.getString("PASSWORD"))){
				userVo.setEmail_Id(emailId);
				userVo.setPassword(Password);
				userVo.setUser_Id(resultSet.getInt("user_Id"));
				userVo.setUser_role(resultSet.getInt("USER_ROLE"));
			}
			return userVo;
		}else{
			throw new Exception("Invalid username or password");
		}
	  }catch(Throwable e){
  
		  throw e;
	  }
	}
	public static void sendEmail(String host, String port,
			final String userName, final String password, String toAddress,
			String subject, String message) throws AddressException,
			MessagingException {

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setText(message);

		// sends the e-mail
		Transport.send(msg);

	}
}
