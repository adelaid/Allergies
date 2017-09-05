/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.Event;
import domain.TriggerLocation;
import java.util.Collection;
import java.util.HashMap;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.getTime;

/**
 *
 * @author Ada
 */
@Stateless
public class EventManagement implements EventManagementLocal {

    @PersistenceContext(unitName = "AllergiesModulePU")
    private EntityManager em;

    @Override
    public void registerEvent(long locationId) {
     
          TriggerLocation l = em.find(TriggerLocation.class, locationId);
        Event e = new Event();
        e.setLocation(l);
        e.setAllergyReaction("yes");
        e.setrTime(getTime.getTimestamp());
        em.persist(e);
        
    }

    @Override
    public void registerNoEvent(long locationId) {
        TriggerLocation l = em.find(TriggerLocation.class, locationId);
        Event e = new Event();
        e.setLocation(l);
        e.setAllergyReaction("no");
        e.setrTime(getTime.getTimestamp());
        em.persist(e);
    }

    @Override
    public HashMap<TriggerLocation, String> getAllLocationsWithEventProb() {
         Query q = em.createQuery("select l FROM TriggerLocation l");
        Collection<TriggerLocation> locations = q.getResultList();
        HashMap<TriggerLocation, String> hMap = new HashMap<>();
        for (TriggerLocation l : locations) {
            hMap.put(l, getAllVisitsAtLocation(l.getId()));
            System.out.println("locatia " +l);
            System.out.println("getAllVisitAtLocation "+ getAllVisitsAtLocation(l.getId()));
        }
        return hMap;
        
    }
    
     public String getAllVisitsAtLocation(Long locationId) {
        Query q = em.createQuery("select e FROM Event e WHERE e.location.id = :lId");
        q.setParameter("lId", locationId);
        Collection<Event> events = q.getResultList();
        int size = 0;
        int num = 0;
        for (Event e : events) {
            size = size + 1;
            if (e.getAllergyReaction().equals("yes")) {
                num = num + 1;
            }
        }
        
        return num + " allergic reactions per " + size + " visits";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
