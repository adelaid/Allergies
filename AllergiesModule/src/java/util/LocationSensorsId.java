/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Ada
 */
public class LocationSensorsId implements Serializable{
    private Long locationid;
    private Long sensorid;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.locationid);
        hash = 37 * hash + (int) (this.sensorid ^ (this.sensorid >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LocationSensorsId other = (LocationSensorsId) obj;
        if (this.sensorid != other.sensorid) {
            return false;
        }
        if (!Objects.equals(this.locationid, other.locationid)) {
            return false;
        }
        return true;
    }

 
    
    
}
