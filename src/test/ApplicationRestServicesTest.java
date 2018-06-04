package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.junit.Test;

/**
 * 
 * @author Rajitha
 * This class is to Mock the REST Service calls.
 *
 */
public class ApplicationRestServicesTest {
	@Test
    public void shouldCheckURIs() throws IOException {

        Client client = ClientBuilder.newClient();

        // Valid URIs
        assertEquals(200, client.target("http://localhost:8080/VehicleInventoryService/vehicle/inventory?vehicleId=1NX45678923").request().get().getStatus());
        // Invalid URIs
        assertEquals(404, client.target("http://localhost:8080/VehicleInventory/vehicle/inventory?vehicleId=98GH4567892367").request().get().getStatus());
        

    }
}
