package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataIntoDataBase {

public static void main(String[] args) throws Throwable {
		
	

		// step1:- Register driver/load mysql database
		Driver driverRef = new Driver();

		DriverManager.registerDriver(driverRef);

		// step2:- get connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details", "root",
				"admin@123");

		// step3:- create SQL statement
		Statement state = conn.createStatement();
		String query = "insert into employee values('4','boo','ram','goa')";

		int result = state.executeUpdate(query);
		if (result == 1) {
			System.out.println("Data is inserted");
		} else {
			System.out.println("Data is not inserted");
		}

		conn.close();
	}

}
