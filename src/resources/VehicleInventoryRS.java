/**
 * VehicleInventoryRS
 */
package resources;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import dao.VehicleInventoryDAO;
import data.VehicleDetails;

/**
 * @author Rajitha
 * 
 * Resource to search, create, update and delete vehicle inventory details
 *
 */
@Path("/inventory")
public class VehicleInventoryRS {
	
	VehicleInventoryDAO vehicleInventoryDAO;
	
	/*
	 * Search the vehicle details based off vehicle id
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchVehicleDetails(@QueryParam("vehicleId") String id) {
		List<VehicleDetails> vehicleDetailsList;
		vehicleInventoryDAO = new VehicleInventoryDAO();
		
		try {
			vehicleDetailsList = vehicleInventoryDAO.searchVehicleDetails(id);
			if(vehicleDetailsList != null)
			{
				return Response.ok(vehicleDetailsList).build();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Response.status(404).build();
	}
	
	/*
	 * Create the vehicle details
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public ResponseBuilder createVehicle(@FormParam("id") String id,
      @FormParam("licnum") String licnum,
      @FormParam("type") String type,
      @FormParam("model") String model,
      @FormParam("state") String state,
      @FormParam("year") int year,
      @Context HttpServletResponse servletResponse) throws IOException{
		vehicleInventoryDAO = new VehicleInventoryDAO();
	      VehicleDetails vehicledetails = new VehicleDetails(id,licnum,type,model,state,year);
	      int result = vehicleInventoryDAO.addVehicle(vehicledetails);
	      if(result == 1){
	    	  return Response.status(200);
	      }
	      return Response.status(400);
	   }


	/*
	 * Delete the vehicle details
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBuilder deleteVehicleDetails(@QueryParam("vehicleId") String id) {
		vehicleInventoryDAO = new VehicleInventoryDAO();
		
		try {
			int result = vehicleInventoryDAO.deleteVehicleDetails(id);
			if(result == 1){
		    	  return Response.status(200);
		      }
		      
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Response.status(404);
	}

	
	/*
	 * Save or update vehicle details
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public ResponseBuilder saveOrUpdateVehicle(@FormParam("id") String id,
      @FormParam("licnum") String licnum,
      @FormParam("type") String type,
      @FormParam("model") String model,
      @FormParam("state") String state,
      @FormParam("year") int year,
      @Context HttpServletResponse servletResponse) throws IOException{
		vehicleInventoryDAO = new VehicleInventoryDAO();
	      VehicleDetails vehicledetails = new VehicleDetails(id,licnum,type,model,state,year);
	      int result = vehicleInventoryDAO.saveOrUpdateVehicle(vehicledetails);
	      if(result == 1){
	    	  return Response.status(200);
	      }
	      return Response.status(400);
	   }
}
