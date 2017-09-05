/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.TriggerFactor;
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
public class TriggerFactorManagement implements TriggerFactorManagementLocal {

    @PersistenceContext(unitName = "AllergiesModulePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
@Override
    public void addFactor(String name) {
        TriggerFactor f = new TriggerFactor();
        f.setFactorName(name);
        em.persist(f);

    }

    @Override
    public TriggerFactor getFactor(Long id) {
        TriggerFactor f = em.find(TriggerFactor.class, id);
        return f;
    }

    @Override
    public Vector<TriggerFactor> getFactors() {
        Query query = em.createQuery("SELECT t FROM TriggerFactor t",TriggerFactor.class);
        return (Vector<TriggerFactor>) query.getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
   

    @Override
    public TriggerFactor getFactorName(String name) {
        Query query =  em.createQuery("select f FROM TriggerFactor f WHERE f.name LIKE :name",TriggerFactor.class);
        query.setParameter("name", name);
        return (TriggerFactor) query.getResultList().get(0);
    }
}
