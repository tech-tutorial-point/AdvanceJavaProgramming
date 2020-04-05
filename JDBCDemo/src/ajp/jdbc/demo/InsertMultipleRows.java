package ajp.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertMultipleRows {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/test_db";
		String username = "root";
		String password = "root";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		while(true){
			
			System.out.println("Enter Movie ID:");
			int movie_id =sc.nextInt();
			System.out.println("Enter Movie Name:");
			String movie_name=sc.next();
			System.out.println("Enter Movie Rating out of 5:");
			int movie_rating=sc.nextInt();
			String query = String.format("INSERT INTO Movie VALUES(%d,'%s',%d)"
					,movie_id,movie_name,movie_rating);
            st.executeUpdate(query);
            System.out.println("Record Inserted Successfully");
            String flag = sc.next();
            if (flag.equalsIgnoreCase("No")){
            	break;
            }
		}
		st.close();
		con.close();
	}
}
