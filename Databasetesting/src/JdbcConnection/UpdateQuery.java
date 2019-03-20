package JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateQuery {

	public static void main(String[] args) throws SQLException {
		String URL="jdbc:oracle:thin:Local SYS	SYSTEM@//localhost:1521/xe";
		String username= "SYSTEM";
		String password="password";
		Connection conn=DriverManager.getConnection(URL,username,password);
		Statement statement=conn.createStatement();
		String s1="UPDATE UserCredentials SET PASSWORD='PASSWORD5' WHERE USERID=4";
		 //String s1="DELETE UserCredentials WHERE USERID=4 ";
		statement.executeQuery(s1);
		conn.close();
		System.out.println("data updated");
		//System.out.println("data deleted");

	}

}
