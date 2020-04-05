package ajp.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateSingleRowDemo {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/test_db";
		String username = "root";
		String password = "root";
		String query = "UPDATE Movie set movie_rating=3 WHERE movie_name='Bharat'";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		int updateCount = st.executeUpdate(query);
		try {
				System.out.println("The number of rows updated :"+updateCount );
		}  finally {
			
			st.close();
			con.close();
		}
	}
}
