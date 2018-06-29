package org.WanderlustAirways.VO;

public class BlacklistedVO {
	private int blacklisted_Id;
	private int user_Id;
	private int star;
	private String user_name;
	private String user_Lname;
	private String passportNumber;
	private String email_Id;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_Lname() {
		return user_Lname;
	}

	public void setUser_Lname(String user_Lname) {
		this.user_Lname = user_Lname;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public int getBlacklisted_Id() {
		return blacklisted_Id;
	}

	public void setBlacklisted_Id(int blacklisted_Id) {
		this.blacklisted_Id = blacklisted_Id;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}
}
