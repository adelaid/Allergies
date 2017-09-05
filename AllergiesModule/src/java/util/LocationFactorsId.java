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
public class LocationFactorsId implements Serializable {
    private Long locationid;
    private Long factorid;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.locationid);
        hash = 67 * hash + (int) (this.factorid ^ (this.factorid >>> 32));
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
        final LocationFactorsId other = (LocationFactorsId) obj;
        if (this.factorid != other.factorid) {
            return false;
        }
        if (!Objects.equals(this.locationid, other.locationid)) {
            return false;
        }
        return true;
    }

    public Long getLocationid() {
        return locationid;
    }

    public void setLocationid(Long locationid) {
        this.locationid = locationid;
    }

    public Long getFactorid() {
        return factorid;
    }

    public void setFactorid(Long factorid) {
        this.factorid = factorid;
    }


    
    
    
}
