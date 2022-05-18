package com.example.webworkingtimeregistrationsystem.system_DO_NOT_USE_NOW.users;

import java.sql.*;


public class User {
	static private int errorLoginCount = 0;
	private int FirstName;
	private int LastName;
	private int PhoneNr;
	private int Email;
	private int Password;

	public User() {
	}

	public static void main(String[] args) {
//		Login("email@email.com", "User1234");
	}

	public boolean Login(String inputEmail, String inputPassword) {
		String url = "jdbc:sqlite:src/database/project.db";
		try {
			Connection connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();

			ResultSet result = statement.executeQuery("SELECT * FROM Users WHERE Email = '" + inputEmail + "'");

			if (errorLoginCount > 5){
				System.out.println("Zbyt wiele prob logowania");
			}
			else if (result.getString("Email").equals(inputEmail) && result.getString("Password").equals(inputPassword)){
				errorLoginCount = 0;
				System.out.println("ZALOGOWANO");
				return true;
			}
			else
				errorLoginCount++;
			return false;

		} catch (SQLException e){
			errorLoginCount++;
			e.printStackTrace();
		}
		return false;
	}


}