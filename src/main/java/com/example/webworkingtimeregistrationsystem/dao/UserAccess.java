package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.datasource.DataSource;
import com.example.webworkingtimeregistrationsystem.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("UserAccess")
public class UserAccess implements UserDao {
	private final String url = DataSource.url;

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
					"VALUES (%s, %s, %s, %s, %s, %d)")
					.formatted(
							DataSource.formatStringToInsert(user.getEmail()),
							DataSource.formatStringToInsert(user.getPassword()),
							DataSource.formatStringToInsert(user.getFirstName()),
							DataSource.formatStringToInsert(user.getLastName()),
							DataSource.formatStringToInsert(user.getPhoneNr()),
							user.getFk_role()
					);
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<User> selectUsers() {
		List<User> resoult = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			String query = "SELECT Email, Password, FirstName, LastName, PhoneNr, Fk_role FROM Users";
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
			return null;
		}
		return resoult;
	}

	@Override
	public User selectUser(int id) {
		try {
			Connection connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			String query = "SELECT Email, Password, FirstName, LastName, PhoneNr, Fk_role FROM Users WHERE IdU = %d"
					.formatted(id);
			ResultSet resultSet = statement.executeQuery(query);
			return new User(
					resultSet.getString("Email"),
					resultSet.getString("Password"),
					resultSet.getString("FirstName"),
					resultSet.getString("LastName"),
					resultSet.getString("PhoneNr"),
					resultSet.getInt("Fk_role")
			);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return null;
		}
	}

	@Override
	public User selectUser(String email) {
		try {
			Connection connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			String query = "SELECT Email, Password, FirstName, LastName, PhoneNr, Fk_role FROM Users WHERE Email = '%s'"
					.formatted(email);
			ResultSet resultSet = statement.executeQuery(query);
			return new User(
					resultSet.getString("Email"),
					resultSet.getString("Password"),
					resultSet.getString("FirstName"),
					resultSet.getString("LastName"),
					resultSet.getString("PhoneNr"),
					resultSet.getInt("Fk_role")
			);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return null;
		}
	}

	@Override
	public User selectUser(String email, String password) {
		try {
			Connection connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			String query = (
					"SELECT Email, Password, FirstName, LastName, PhoneNr, Fk_role " +
					"FROM Users WHERE Email = '%s' AND Password = '%s'"
			)
					.formatted(email, password);
			ResultSet resultSet = statement.executeQuery(query);
			return new User(
					resultSet.getString("Email"),
					resultSet.getString("Password"),
					resultSet.getString("FirstName"),
					resultSet.getString("LastName"),
					resultSet.getString("PhoneNr"),
					resultSet.getInt("Fk_role")
			);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return null;
		}
	}

	// TODO: User update
	@Override
	public boolean updateUser(User user) {
		if (user == null)
			return false;

		try {
			Connection connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			String query = "UPDATE Users SET %s = %s WHERE Email = '%s'".formatted("", "", user.getEmail());
			statement.executeUpdate(query);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}
		return true;
	}
}
