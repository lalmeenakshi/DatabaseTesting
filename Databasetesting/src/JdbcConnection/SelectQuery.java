package JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQuery {

	public static void main(String[] args) throws SQLException {
		String URL="jdbc:oracle:thin:Local SYS	SYSTEM@//localhost:1521/xe";
		String username= "SYSTEM";
		String password="password";
		Connection con=DriverManager.getConnection(URL,username,password);
		Statement stmt=con.createStatement();
		String s = "SELECT FIRSTNAME,LASTNAME FROM UserCredentials";
		ResultSet rs=stmt.executeQuery(s);
		while(rs.next()) {
			
			String firstname=rs.getString("FIRSTNAME");
			String lastname=rs.getString("LASTNAME");
			System.out.println(firstname);
			System.out.println(lastname);
		}
		con.close();
	}

}
