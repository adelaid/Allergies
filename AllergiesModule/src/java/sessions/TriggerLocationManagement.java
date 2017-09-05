/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.TriggerLocation;
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
public class TriggerLocationManagement implements TriggerLocationManagementLocal {

    @PersistenceContext(unitName = "AllergiesModulePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
   @Override
    public void addLocation(String name) {
        TriggerLocation location = new TriggerLocation();
        location.setName(name);
        em.persist(location);
    }

    @Override
    public TriggerLocation getLocation(Long id){
        TriggerLocation location = em.find(TriggerLocation.class, id);
        return location;
    }
    
    @Override
    public Vector<TriggerLocation> getAllLocations(){
        Query query = em.createQuery("SELECT tl FROM TriggerLocation tl",TriggerLocation.class);
        return (Vector<TriggerLocation>) query.getResultList();
    }

   
}
