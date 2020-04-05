package ajp.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectAllRowsDemo {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/test_db";
		String username = "root";
		String password = "root";
		String query = "SELECT * from Movie";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		try {
			while (rs.next()) {
				int movie_id = rs.getInt("movie_id");
				String movie_name = rs.getString("movie_name");
				int movie_rating = rs.getInt("movie_rating");
				System.out.println(movie_id + ",  " + movie_name + ",  " + movie_rating );
			}
		}  finally {
			rs.close();
			st.close();
			con.close();
		}
	}
}
