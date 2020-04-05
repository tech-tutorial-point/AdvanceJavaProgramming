package ajp.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementDemo {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/test_db";
		String username = "root";
		String password = "root";
		String query = "INSERT into Movie values (?,?,?)";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pst = con.prepareStatement(query);           
			pst.setInt(1, 5);
            pst.setString(2, "MIB");
            pst.setInt(3, 3);
            pst.executeUpdate();
            System.out.println("RecordInsertedSuccessfully");
		con.close();
	}
}
