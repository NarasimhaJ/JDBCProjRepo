//DBConnTest.java
import java.sql.*;


public class DBConnTest {

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub

		
	//	oracle.jdbc.driver.OracleDriver  obj= new oracle.jdbc.driver.OracleDriver();
	//	DriverManager.registerDriver(obj);
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
													"SYSTEM","Manager") ;
		System.out.println("Object Class Name" +con.getClass());
		
		if (con == null)
			System.out.println("DB Connection Not Established");
		else
			System.out.println("DB Connection Established");
		
		Statement st=con.createStatement();
		
		System.out.println("Statement object Calss name:: "+st.getClass());
			
		
		
	}

}
