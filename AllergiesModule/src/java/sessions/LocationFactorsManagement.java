/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.LocationFactors;
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
public class LocationFactorsManagement implements LocationFactorsManagementLocal {

    @PersistenceContext(unitName = "AllergiesModulePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
 @Override
    public void addFactorToLocation(long factorId, long locationId, int percentage) {
        Query q = em.createQuery("select lf FROM LocationFactors lf WHERE lf.locationid = :locationid and lf.factorid = :factorid");
        q.setParameter("locationid", locationId);
        q.setParameter("factorid", factorId);
        List resultList = q.getResultList();
        if (resultList == null || resultList.isEmpty()) {
            LocationFactors lf = new LocationFactors();
            lf.setFactorid(factorId);
            lf.setLocationid(locationId);
            lf.setPercent(percentage);
            em.persist(lf);
        }
    }
   @Override
    public Vector<LocationFactors> getAllowedLocations(Long factorId) {
        Query q = em.createQuery("select lf FROM LocationFactors lf WHERE lf.factorid != :factorid");
        q.setParameter("factorid", factorId);
        System.out.println("resultlist: " + q.getResultList().size());
        return (Vector<LocationFactors>) q.getResultList();
    }
    
    @Override
    public Vector<LocationFactors> getAvoidLocations(Long factorId) {
        System.out.println("in allowed");
        Query q = em.createQuery("select lf FROM LocationFactors lf WHERE lf.factorid = :factorid");
        q.setParameter("factorid", factorId);
        System.out.println("size "+q.getResultList().size());
        return (Vector<LocationFactors>) q.getResultList();
        
        
    }
}
