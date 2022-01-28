package com.udodov.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;


public class DbUtil {
	
	private DataSource dataSource;
	
	public DbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public Double getMaterialStrength(String electrode) throws Exception{
		
		Double strength = null;
		String theElectrode = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			theElectrode = electrode;
			myConn = dataSource.getConnection();
			String sql = "select * from electrodes where brand = ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, theElectrode);
			myRs = myStmt.executeQuery();
			
			if(myRs.next()) {
				strength = myRs.getDouble("yield_strength");
			}
			else {
				throw new Exception ("Could not find such electrode in database: " + theElectrode);
			}
			
		return strength;
		
	} finally {
		close(myConn, myStmt, myRs);
	}
		
	}

	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if(myRs!=null) {
				myRs.close();
			}
			
			if(myStmt!=null) {
				myStmt.close();
			}
			
			if(myConn!=null) {
				myConn.close();
			}
			
		}catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
