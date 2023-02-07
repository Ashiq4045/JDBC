package org.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Connection1 {
	public static WebDriver driver;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ameen\\eclipse-workspace\\JDBC\\Driver\\chromedriver.exe");
		
		driver=new ChromeDriver();
		//driver.get("https://www.facebook.com/login/");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","12345");
		String sql="select * from instagramLogin";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		ResultSet resultSet = prepareStatement.executeQuery();
		while(resultSet.next()) {
			String  string = resultSet.getString("username");
			//driver.findElement(By.id("email")).sendKeys(string);
			System.out.println(string);
			String string2 = resultSet.getString("password");
			System.out.println(string2);
			//driver.findElement(By.id("pass")).sendKeys(string2);
			
			//driver.findElement(By.name("login")).click();
		}
	
		connection.close();
		
		
		
		
		
	}

}
