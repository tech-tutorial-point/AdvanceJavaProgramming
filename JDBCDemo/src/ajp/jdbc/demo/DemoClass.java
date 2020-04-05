package ajp.jdbc.demo;

import java.sql.*;

public class DemoClass {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/sql_store";
		String username = "root";
		String password = "root";
		String query = "Select * from sql_store.customers;";

		// Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		try {
			while (rs.next()) {
				int customer_id = rs.getInt("customer_id");
				String f_name = rs.getString("first_name");
				String l_name = rs.getString("last_name");
				String birth_date = rs.getString("birth_date");
				String phone_no = rs.getString("phone");
				String address = rs.getString("address");
				String city = rs.getString("city");
				System.out.println(customer_id + ", " + f_name + ", " + l_name + ", " + birth_date + ", " + phone_no+ ", " + address+ ", " + city);
			}
		}  finally {
			rs.close();
			st.close();
			con.close();
		}
	}
}
