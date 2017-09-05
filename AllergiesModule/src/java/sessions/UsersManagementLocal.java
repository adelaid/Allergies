/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.TriggerFactor;
import domain.User;
import javax.ejb.Local;

/**
 *
 * @author Ada
 */
@Local
public interface UsersManagementLocal {
      public void addUser(String email, String firstName, String lastName, String password,String username); 
       public User getUser(String username);
        public void addFactor(TriggerFactor factor, Long userId);
}
