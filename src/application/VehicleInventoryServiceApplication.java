/**
 * VehicleInventoryServiceApplication.java
 */
package application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import resources.VehicleInventoryRS;

/**
 * @author Rajitha
 * This is the Main Application class
 *
 */
@ApplicationPath("vehicle")
public class VehicleInventoryServiceApplication extends Application {
	/*
	 * This method is used to configure all the resources in the application.
	 *
	 * (non-Javadoc)
	 * @see javax.ws.rs.core.Application#getClasses()
	 */
	public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(VehicleInventoryRS.class);
        return s;
    }
}
