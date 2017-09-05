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
import util.LocationFactorsId;

/**
 *
 * @author Ada
 */
@Entity
@IdClass(LocationFactorsId.class)
public class LocationFactors implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
  //  private Long id;
    @Id
    private Long locationid;
    @Id
    private Long factorid;
    private int percent;

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
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

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    

//    @Override
//    public String toString() {
//        return "domain.LocationFactors[ id=" + id + " ]";
//    }
    
    
      @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.locationid);
        hash = 67 * hash + Objects.hashCode(this.factorid);
        hash = 67 * hash + this.percent;
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
        final LocationFactors other = (LocationFactors) obj;
        if (this.percent != other.percent) {
            return false;
        }
        if (!Objects.equals(this.locationid, other.locationid)) {
            return false;
        }
        if (!Objects.equals(this.factorid, other.factorid)) {
            return false;
        }
//        if (!Objects.equals(this.triggerFactor, other.triggerFactor)) {
//            return false;
//        }
//        if (!Objects.equals(this.triggerLocation, other.triggerLocation)) {
//            return false;
//        }
        return true;
    }

    
    
}
