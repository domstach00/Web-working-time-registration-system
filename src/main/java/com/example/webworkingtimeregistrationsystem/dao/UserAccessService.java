package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("UserAccess")
public class UserAccessService implements UserDao {
	private String url = "jdbc:sqlite:src/database/project.db";

//	public static void main(String[] args) {
//		UserAccessService userAccessService = new UserAccessService();
//		User user = new User("TestMailNewsdXXX", "PAsswdX");
//		userAccessService.insertUser(user);
//
//	}

    @Override
    public boolean insertUser(User user) {
        try {
			Connection connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
            String query = ("INSERT INTO Users " +
					"(Email, Password, FirstName, LastName, PhoneNr, Fk_role) " +
					"VALUES ('%s', '%s', %s, %s, %s, %d)")
					.formatted(
							user.getEmail(),
							user.getPassword(),
							formatToInsert(user.getFirstName()),
							formatToInsert(user.getLastName()),
							formatToInsert(user.getPhoneNr()),
							user.getFk_role()
					);
			statement.executeUpdate(query);
			return true;

		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
    }

	@Override
	public List<User> selectUsers() {
		List<User> resoult = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			String query = ("SELECT Email, Password, FirstName, LastName, PhoneNr, Fk_role FROM Users");
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()){
				resoult.add(
						new User(
								resultSet.getString("Email"),
								resultSet.getString("Password"),
								resultSet.getString("FirstName"),
								resultSet.getString("LastName"),
								resultSet.getString("PhoneNr"),
								resultSet.getInt("Fk_role")
						)
				);
			}

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return resoult;
	}


	// Prepere String value to insert into query - if it's null we dont use '' in insert
	public String formatToInsert(String input){
		if (input == null)
			return null;
		return  "'" + input + "'";
	}
}
