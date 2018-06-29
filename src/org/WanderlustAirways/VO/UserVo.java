package org.WanderlustAirways.VO;

public class UserVo {

	private int User_Id;
	private String First_Name;
	private String Last_Name;
	private String Passport_No;
	private String Password;
	private String Email_Id;
	private String Address;
	private int user_role;
	private Long Contact_No;

	public int getUser_role() {
		return user_role;
	}

	public void setUser_role(int user_role) {
		this.user_role = user_role;
	}

	public int getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getPassport_No() {
		return Passport_No;
	}

	public void setPassport_No(String passport_No) {
		Passport_No = passport_No;
	}

	public String getEmail_Id() {
		return Email_Id;
	}

	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Long getContact_No() {
		return Contact_No;
	}

	public void setContact_No(Long contact_No) {
		Contact_No = contact_No;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
}
