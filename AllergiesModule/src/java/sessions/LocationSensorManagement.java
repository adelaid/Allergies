/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.LocationSensors;
import java.util.List;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ada
 */
@Stateless
public class LocationSensorManagement implements LocationSensorManagementLocal {

    @PersistenceContext(unitName = "AllergiesModulePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

      @Override
    public void addSensorToLocation(long sensorId, long locationId, int quality) {
        Query q = em.createQuery("select ls FROM LocationSensors ls WHERE ls.locationid = :locationid and ls.sensorid = :sensorid");
        q.setParameter("locationid", locationId);
        q.setParameter("sensorid", sensorId);
        List resultList = q.getResultList();
        if (resultList == null || resultList.isEmpty()) {
            LocationSensors ls = new LocationSensors();
            ls.setSensorid(sensorId);
            ls.setLocationid(locationId);
            ls.setQuality(quality);
            em.persist(ls);
        }
    }

    @Override
    public Vector<LocationSensors> getAvoidLocations(Long sensorId) {
        Query q = em.createQuery("select lf FROM LocationSensors lf WHERE lf.sensorid = :sensorid");
        q.setParameter("sensorid", sensorId);
        return (Vector<LocationSensors>) q.getResultList();

    }

    @Override
    public Vector<LocationSensors> getAllowedLocations(Long sensorId) {
        Query q = em.createQuery("select lf FROM LocationSensors lf WHERE lf.sensorid <> :sensorid");
        q.setParameter("sensorId", sensorId);
        return (Vector<LocationSensors>) q.getResultList();

    }
    
}
