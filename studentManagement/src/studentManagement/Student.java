package studentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class Student{
	
	//Add student detail to database
	public void addStudent(int id, String name, String dep) throws Exception{

		//MySql credentials
		String url = "jdbc:mysql://localhost:3306/student";
		String  userName = "root";
		String passWord = "Ajay@2001";
		
		// MySql Query to insert a value of student
		String query = "INSERT INTO student VALUES (?, ?, ?);";
		
		//JDBC connection
		Connection connection = DriverManager.getConnection(url, userName, passWord);
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		statement.setString(2, name);
		statement.setString(3, dep);
		statement.executeUpdate();
		connection.close();//To close JDBC connectivity
		
		System.out.println("Student added Successfully!!!!");
		System.out.println("================================");
	}
	
	static void entireStudent() throws Exception{

		//MySql credentials
		String url = "jdbc:mysql://localhost:3306/student";
		String  userName = "root";
		String passWord = "Ajay@2001";
		
		//JDBC connection
		Connection connection = DriverManager.getConnection(url, userName, passWord);
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM student;");
		
		while(result.next()) {
			System.out.printf("\n%-5S %-15S %-10S" , result.getInt(1), result.getString(2), result.getString(3));
		}
		System.out.println("\n\n============================================\n");
		connection.close();//Close JDBC Connectivity
	}
	
	public void particularStudent(int id) throws Exception{

		//MySql credentials
		String url = "jdbc:mysql://localhost:3306/student";
		String  userName = "root";
		String passWord = "Ajay@2001";
		
		//JDBC connection
		Connection connection = DriverManager.getConnection(url, userName, passWord);
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM student WHERE student_id =" + id + ";");
		
		while(result.next()) {
			System.out.printf("\n%-5S %-15S %-10S" , result.getInt(1), result.getString(2), result.getString(3));
		}
		System.out.println("\n\n============================================\n");
		connection.close();//Close JDBC Connectivity
	}
}
