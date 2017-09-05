/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.LocationFactors;
import domain.Risk;
import domain.TriggerFactor;
import domain.TriggerLocation;
import domain.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ada
 */
@Stateless
public class RiskManagament implements RiskManagamentLocal {

    @PersistenceContext(unitName = "AllergiesModulePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public ArrayList<Risk> getRiskMap(Long userId, Long factorId) {
        ArrayList<Risk> riskMap = new ArrayList<>();
        //   User user = em.find(User.class, userId);
        Collection<TriggerLocation> locations = (Collection<TriggerLocation>) getAllLocations();
        for (TriggerLocation l : locations) {
            HashMap<TriggerFactor, Integer> factors = new HashMap<>();
            Query q = em.createQuery("select lf FROM LocationFactors lf where lf.locationid = :locationid", LocationFactors.class);
            q.setParameter("locationid", l.getId());
            List<LocationFactors> resultList = q.getResultList(); //factorid + percentage
            for (LocationFactors lf : resultList) {
                factors.put(em.find(TriggerFactor.class, lf.getFactorid()), lf.getPercent()); //hm add fct+ perc

            }
            Risk r = new Risk();
            r.setFactor(factors);
            r.setLocation(l);
            riskMap.add(r);
        }
        return riskMap;
    }

    @Override
    public List<TriggerLocation> getAllLocations() {
        Query q = em.createQuery("select l FROM TriggerLocation l");
        return (List<TriggerLocation>) q.getResultList();
    }

}
