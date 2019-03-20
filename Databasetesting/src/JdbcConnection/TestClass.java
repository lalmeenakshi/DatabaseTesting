package JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {
	WebDriver driver;

	public static void main(String[] args) throws SQLException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Kumar\\Downloads\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://classic.crmpro.com/login.cfm");
		String URL="jdbc:oracle:thin:Local SYS	SYSTEM@//localhost:1521/xe";
		String username= "SYSTEM";
		String password1="password";
		Connection con=DriverManager.getConnection(URL,username,password1);
		Statement stmt=con.createStatement();
		String s = "SELECT FIRSTNAME,PASSWORD FROM UserCredentials";
		ResultSet rs=stmt.executeQuery(s);
		while(rs.next()) {
			
			String firstname=rs.getString("FIRSTNAME");
			String password=rs.getString("PASSWORD");
			driver.findElement(By.name("username")).sendKeys(firstname);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.xpath("//input[@value='Login']")).submit();
			if(driver.getTitle().equals("CRMPRO")) {
				System.out.println("TEST CASE PASSED ");
			}
			else {
				System.out.println("TEST CASE FAILED");
			}
			//driver.findElement(By.xpath("//a[contains(@href,'https://classic.crmpro.com/index.cfm?logout=1')]")).click();
		}

driver.quit();
	}

}
