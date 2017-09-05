/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.TriggerFactor;
import domain.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ada
 */
@Stateless
public class UsersManagement implements UsersManagementLocal {

    @PersistenceContext(unitName = "AllergiesModulePU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addUser(String email, String firstName, String lastName, String password, String username) {
        User u = new User();
        u.setEmail(email);
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setPassword(password);
        u.setUsername(username);
        em.persist(u);
        
        
    }

    @Override
    public User getUser(String username) {
       Query query = em.createQuery("SELECT u FROM User AS u WHERE u.username = '" + username + "'", User.class);
        return (User) query.getSingleResult();
    }
      @Override
       public void addFactor(TriggerFactor factor, Long userId) {
        System.out.println(factor.toString());
        System.out.println(userId);
        User dbUser = em.find(User.class, userId);
        dbUser.setFactor(factor);
        em.persist(dbUser);
    }
    
}
