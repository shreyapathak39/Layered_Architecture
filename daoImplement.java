package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.courses;

public class daoImplement implements daoInterface{
	
	daoUtil obj = new daoUtil();
	PreparedStatement ps;
	Connection con;
	public daoImplement() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		daoUtil.dbconnect();
		
	}
	@Override
	public boolean doInsert(String courseName, String category, int duration, int numberOfTests) throws SQLException {
		// TODO Auto-generated method stub
		String query = "insert into COURSES values(?,?,?,?)";
		ps = con.prepareStatement(query);
		ps.setString(1, courseName);
		ps.setString(2, category);
		ps.setInt(3, duration);
		ps.setInt(4, numberOfTests);
		
		int i = ps.executeUpdate();
		if(i>0) {
			return true;
		}
		else {
			return false;
		}
		//Use executeQuery for select statement
		
	}

	@Override
	public List<courses> getAllData() throws SQLException {
		// TODO Auto-generated method stub
		List <courses> list1 = new <courses> ArrayList(); 
		String selectquery = "select * from COURSES";
		ps = con.prepareStatement(selectquery);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String cname = rs.getString("COURSENAME");
			String category = rs.getString("CATEGORY");
			int duration = rs.getInt("DURATION");
			int number = rs.getInt("TESTINCLUDE");
			
			list1.add(new courses(cname,category,duration,number));
			System.out.println(list1);
		}
		return list1;
	}

	@Override
	public List<courses> getCourseByDurationAndCategory(int duration, String category) throws SQLException {
		// TODO Auto-generated method stub
		//String sql = "select * from courses where category like '"+category+"' and duration = "+duration;
		String sql = "select * from COURSES where category like ? and duration = ?";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, category);
		ps.setInt(2, duration);
		
		
		ResultSet rs = ps.executeQuery();
		List<courses> list = new ArrayList<>(); // empty list
		
		while(rs.next())
		{
			String courseName = rs.getString("COURSENAME");
			String category2 = rs.getString("CATEGORY");
			int duration2 = rs.getInt("DURATION");
			int numberOfTests = rs.getInt("TESTINCLUDE");
			
			list.add(new courses(courseName, category2, duration2, numberOfTests));
			
			
		}	//end of rs	
		return list;
	}
	@Override
	public boolean updateNameData(String courseName, String category) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update COURSES set COURSENAME = ? where CATEGORY = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, courseName);
		ps.setString(2, category);
		
		int i = ps.executeUpdate();
		
		if(i>0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteData(String cname) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from COURSES where COURSENAME = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, cname);
		int i = ps.executeUpdate();
		
		if(i>0) {
			return true;
		}
		return false;
	}
	
	

}