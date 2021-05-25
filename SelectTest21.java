package com.jnr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = null;
		int deptNo = 0;
		Connection con=null;
		Statement st =null;
		ResultSet rs = null;
		try {
		sc=new Scanner(System.in);
		if (sc != null) {
		System.out.println("Enter DeptNo::");
		deptNo = sc.nextInt();
		
		} //end if
		
	//Establish DB connection	
		 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"SYSTEM","Manager") ;
		if(con != null) 
		 st=con.createStatement();
		
		String query="SELECT * FROM EMP WHERE DEPTNO ="+deptNo+" ORDER BY DEPTNO";
		System.out.println("\n");
		System.out.println(query);
		System.out.println("\n");
		if (st != null)
		 rs = st.executeQuery(query);
		if(rs != null) {
		System.out.println("******************** Employee details ********************");
		while (rs.next()!=false) {
			
			System.out.println(rs.getInt(1)+" " +rs.getString(2)+"   "+rs.getString(3)+"    "+rs.getInt(4)+" "+rs.getDate(5)+" "+rs.getFloat(6)+" "+rs.getFloat(7)+" "+rs.getInt(8));
			
			}//while
		}//if
		
	} //try
		catch (SQLException se) {
		System.out.println(se.toString());
	}
		catch(Exception e) {
			e.printStackTrace();
	}

	
		finally {
			try {
				if(rs != null)
				rs.close();
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(st != null)
				st.close();
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(con != null)
				con.close();
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		} //finally

	}

}
