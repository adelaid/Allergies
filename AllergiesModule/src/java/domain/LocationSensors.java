/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import util.LocationSensorsId;

/**
 *
 * @author Ada
 */
@Entity
@IdClass(LocationSensorsId.class)
public class LocationSensors implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    @Id
    private Long locationid;
    @Id
    private Long sensorid;
    
    private int quality;

    public Long getLocationid() {
        return locationid;
    }

    public void setLocationid(Long locationid) {
        this.locationid = locationid;
    }

    public Long getSensorid() {
        return sensorid;
    }

    public void setSensorid(Long sensorid) {
        this.sensorid = sensorid;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
    
    
    
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
 @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.locationid);
        hash = 37 * hash + Objects.hashCode(this.sensorid);
        hash = 37 * hash + this.quality;
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
        final LocationSensors other = (LocationSensors) obj;
        if (this.quality != other.quality) {
            return false;
        }
        if (!Objects.equals(this.locationid, other.locationid)) {
            return false;
        }
        if (!Objects.equals(this.sensorid, other.sensorid)) {
            return false;
        }
        return true;
    }

   

//    @Override
//    public String toString() {
//        return "domain.LocationSensors[ id=" + id + " ]";
//    }
    
}
