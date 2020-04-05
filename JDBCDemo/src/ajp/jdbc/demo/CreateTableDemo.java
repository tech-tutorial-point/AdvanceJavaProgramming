package ajp.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableDemo {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/test_db";
		String username = "root";
		String password = "root";
		String query = "create table Movie(movie_id int(11), movie_name varchar(50), movie_rating int(11);";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		try {
				st.execute(query);
				System.out.println("Table created successfully");
			
		}  finally {
			st.close();
			con.close();
		}
	}
}
