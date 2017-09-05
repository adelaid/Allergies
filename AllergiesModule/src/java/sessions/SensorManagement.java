/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.Sensor;
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
public class SensorManagement implements SensorManagementLocal {

    @PersistenceContext(unitName = "AllergiesModulePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

     @Override
    public void addSensor(String name) {
        Sensor s = new Sensor();
        s.setSensorName(name);
        em.persist(s);
    }

    @Override
    public Sensor getSensor(Long id) {
        Sensor f = em.find(Sensor.class, id);
        return f;
    }

    @Override
    public Vector<Sensor> getSensors() {
        Query query = em.createQuery("SELECT s FROM Sensor s",Sensor.class);
        System.out.println("in session" + query.getResultList().size());
        return (Vector<Sensor>) query.getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


    @Override
    public Sensor getSensor(String name) {
        Query query =  em.createQuery("select s FROM Sensor s WHERE s.name LIKE :name",Sensor.class);
        query.setParameter("name", name);
        return (Sensor) query.getResultList().get(0);
    }
    
}
