package main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import beans.Courses;
import service.serviceInterface;
import service.serviceExecute;

public class mainClass {
	
	Scanner sc = new Scanner(System.in);
	static serviceInterface object;
	
	public mainClass() throws ClassNotFoundException, SQLException {
		object = new serviceExecute();
	}
	
	public static void main(String args[]) throws SQLException, ClassNotFoundException{
		mainClass obj = new mainClass();
		obj.getData();
	}
	
	public void getData() throws SQLException {
		
		try {
		List<Courses> c1 = serviceInterface.getAllData();
		System.out.println(c1);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public void Insert() {
		System.out.println("Enter the fields of database:");
		String coursenm = sc.next();
		String category = sc.next();
		int duration = sc.nextInt();
		int noOfTests= sc.nextInt();
		
		try {
			boolean c = serviceInterface.doInsert(coursenm,category,duration,noOfTests);
			System.out.println(c);
			
			}
			catch(Exception e) {
				System.out.println(e);
			}
		
	}
	
	public void update() {
		System.out.println("Enter the new coursename and category");
		String coursenm = sc.next();
		String category = sc.next();
		try 
		{
			boolean c = serviceInterface.updateNameData(coursenm, category);
			System.out.println(c);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public void delete() {
		System.out.println("Enter the new coursename ");
		String coursenm = sc.next();
		try 
		{
			boolean c = serviceInterface.deleteData(coursenm);
			System.out.println(c);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
}