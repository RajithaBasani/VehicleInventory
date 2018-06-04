/**
 * VehicleInventoryDAO
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.VehicleDetails;

/**
 * @author Rajitha
 * 
 * This DAO class maintains the DB Connections and Persistence through queries.
 *
 */
public class VehicleInventoryDAO {
	
	public static Connection myH2DbConnection;
	public Statement stmt;
	public ResultSet vehicleIdResultSet;
	List<VehicleDetails> vehicleDetailsList;
	
	/**
	 * Return DB Connection
	 * @return
	 * @throws SQLException
	 */
	public Connection getDbConnection() throws SQLException
	{
		try {
			Class.forName ("org.h2.Driver"); 
			myH2DbConnection = DriverManager.getConnection ("jdbc:h2:~/test", "testdb","testpass"); 
		}
		catch(ClassNotFoundException exception)
		{
			exception.printStackTrace();
		}
		return myH2DbConnection;
	}
	
	/**
	 * Returns vehicle details result set based on vehicle id search
	 * @param vehicleId
	 * 
	 * @return
	 */
	public List<VehicleDetails> searchVehicleDetails(String vehicleId)
	{
		try {
			myH2DbConnection = getDbConnection();
			stmt = myH2DbConnection.createStatement();
			vehicleIdResultSet = stmt.executeQuery("select * from vehicle_inventory where id='"+vehicleId+"'");
			if(vehicleIdResultSet != null)
			{
				vehicleDetailsList = new ArrayList <VehicleDetails>();
				while (vehicleIdResultSet.next()) {
				    VehicleDetails vehicleDetails = new VehicleDetails();
				    
				    vehicleDetails.setvId(vehicleIdResultSet.getString("ID"));
				    vehicleDetails.setLicNum(vehicleIdResultSet.getString("LICNUM"));
				    vehicleDetails.setType(vehicleIdResultSet.getString("TYPE")); 
				    vehicleDetails.setModel(vehicleIdResultSet.getString("MODEL")); 
				    vehicleDetails.setState(vehicleIdResultSet.getString("STATE")); 
				    vehicleDetails.setYear(vehicleIdResultSet.getInt("YEAR"));
				    
				    vehicleDetailsList.add(vehicleDetails);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();;
		}
		finally
		{
			//finally block used to close resources
	      try{
	         if(myH2DbConnection!=null)
	         {
	        	 myH2DbConnection.close();
	         }
	      }catch(SQLException exception){
	    	  exception.printStackTrace();
	      }
		}//end finally
		return vehicleDetailsList;
	}

	/** Create vehicle details
	 * 
	 * @param vehicledetails
	 * @return
	 */
	public int addVehicle(VehicleDetails vehicledetails) {
		try {
				myH2DbConnection = getDbConnection();
				String sql="insert into vehicle_inventory(id,licnum,type,model,state,year) values (?,?,?,?,?,?)";
				PreparedStatement preStmt = myH2DbConnection.prepareStatement(sql);
				
				if(vehicledetails != null)
				{
					preStmt.setString(1, vehicledetails.getvId());
					preStmt.setString(2, vehicledetails.getLicNum());
					preStmt.setString(3, vehicledetails.getType());
					preStmt.setString(4, vehicledetails.getModel());
					preStmt.setString(5, vehicledetails.getState());
					preStmt.setInt(6, vehicledetails.getYear());
					    
					preStmt.executeUpdate();
				}			
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//finally block used to close resources
	      try{
	         if(myH2DbConnection!=null)
	         {
	        	 myH2DbConnection.close();
	         }
	      }catch(SQLException exception){
	    	  exception.printStackTrace();
	      }
		}//end finally
		return 1;
	}
	
	
	/**
	 * Delete vehicle details
	 * @param vehicleId
	 * 
	 * @return
	 */
	public int deleteVehicleDetails(String vehicleId)
	{
		try {
			myH2DbConnection = getDbConnection();
			stmt = myH2DbConnection.createStatement();
			boolean result = stmt.execute("delete from vehicle_inventory where id='"+vehicleId+"'");
			if(result)
			{
				return 1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();;
		}
		finally
		{
			//finally block used to close resources
	      try{
	         if(myH2DbConnection!=null)
	         {
	        	 myH2DbConnection.close();
	         }
	      }catch(SQLException exception){
	    	  exception.printStackTrace();
	      }
		}//end finally
		return 0;
	}

	/** Create vehicle details
	 * 
	 * @param vehicledetails
	 * @return
	 */
	public int saveOrUpdateVehicle(VehicleDetails vehicledetails) {
		try {
				myH2DbConnection = getDbConnection();
				String sql="update vehicle_inventory set licnum=?,type=?,model=?,state=?,year=? where id=?";
				PreparedStatement preStmt = myH2DbConnection.prepareStatement(sql);
				
				if(vehicledetails != null)
				{
					preStmt.setString(1, vehicledetails.getLicNum());
					preStmt.setString(2, vehicledetails.getType());
					preStmt.setString(3, vehicledetails.getModel());
					preStmt.setString(4, vehicledetails.getState());
					preStmt.setInt(5, vehicledetails.getYear());
					preStmt.setString(6, vehicledetails.getvId());
					    
					preStmt.executeUpdate();
				}			
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//finally block used to close resources
	      try{
	         if(myH2DbConnection!=null)
	         {
	        	 myH2DbConnection.close();
	         }
	      }catch(SQLException exception){
	    	  exception.printStackTrace();
	      }
		}//end finally
		return 1;
	}

}
