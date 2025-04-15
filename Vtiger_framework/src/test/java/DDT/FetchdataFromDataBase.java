package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchdataFromDataBase {
	public static void main(String[] args) throws Throwable {
		// register driver/load mysql database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		// get connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details", "root",
				"admin@123");
		// create sql statement
		Statement state = conn.createStatement();
		String query = "select* from employee";
		// execute statement/query
		ResultSet result = state.executeQuery(query);
		while (result.next()) {
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t"
					+ result.getString(4));

		}
		// close the database connection
		conn.close();

	}

}
