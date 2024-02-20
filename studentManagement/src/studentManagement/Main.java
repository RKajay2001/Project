package studentManagement;

//import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.Scanner;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Welcome...!");
		Scanner input = new Scanner(System.in);
		int n = 0;
		
		//JDBC connection invoking
		String url = "jdbc:mysql://localhost:3306/student";
		String userName = "root";
		String passWord = "Ajay@2001";
		
		Connection connection = DriverManager.getConnection(url, userName, passWord);
		Statement statement = connection.createStatement();
		
		
//		LinkedList<Student> student = new LinkedList<Student>();
		try {
			while (n != 4) {

				System.out.println("Press 1 to add a Student detail");
				System.out.println("Press 2 to display the entire Student detail");
				System.out.println("Press 3 to display specific Student detail");
				System.out.println("Press 4 to Exit from Student Management");
			
				n = input.nextInt();
				switch (n){
				case 1:
					System.out.println("You pressed 1");
					System.out.println(" ");
					System.out.println("Enter Student ID: ");
					int id = input.nextInt();
					System.out.println("Enter Student name: ");
					String name = input.next();
					System.out.println("Enter Student department: ");
					String department = input.next();
					Student student =new Student();
					student.addStudent(id, name, department);
					break;
				case 2:
					System.out.println("You pressed 2");
					System.out.println("The Entire student detail are shown below");
					System.out.println("===========================================");
					
					// SELECT Query to display all the data in student table
					Student entireData = new Student();
					entireData.entireStudent();
					
					break;
				case 3:
					System.out.println("You pressed 3");
					System.out.println("Please enter the student ID of student you want");
					int student_id = input.nextInt();
					Student particularData = new Student();
					particularData.particularStudent(student_id);
					break;
				case 4:
					System.out.println("You pressed 4");
					System.out.println("And your existed from Student Management");
					break;
				default:
					System.out.println("You pressed " + n);
					System.out.println("Invaild number");
					break;
				}
			}
		}catch(Exception e) {
				System.out.println("You entered INVALID INPUT");
				System.out.println("Rerun again!!!!!");
			}
	}

}
