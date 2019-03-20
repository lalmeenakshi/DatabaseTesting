package JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuery {
public static void main(String args[]) throws SQLException{
	String URL="jdbc:oracle:thin:Local SYS	SYSTEM@//localhost:1521/xe";
	String username= "SYSTEM";
	String password="password";
	Connection con= DriverManager.getConnection(URL,username,password);
	Statement stmt=con.createStatement();
	String s = "INSERT INTO UserCredentials VALUES (4,'DEEPA','BHARTI','PASSWORD4')";
	stmt.executeQuery(s);
	con.close();
	System.out.println("data inserted");
	

}
}
