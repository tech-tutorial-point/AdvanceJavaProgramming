package ajp.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteSingleRowDemo {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/test_db";
		String username = "root";
		String password = "root";
		String query = "DELETE FROM Movie Where movie_name='life'";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		try {
				st.executeUpdate(query);
				System.out.println("Table updated successfully");
			
		}  finally {
			st.close();
			con.close();
		}
	}
}
