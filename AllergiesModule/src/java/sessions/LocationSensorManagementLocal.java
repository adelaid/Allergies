/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.LocationSensors;
import java.util.Vector;
import javax.ejb.Local;

/**
 *
 * @author Ada
 */
@Local
public interface LocationSensorManagementLocal {
    public void addSensorToLocation(long sensorId, long locationId, int quality);
    public Vector<LocationSensors> getAvoidLocations(Long sensorId);
    public Vector<LocationSensors> getAllowedLocations(Long sensorId);
    
}
