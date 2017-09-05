/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.TriggerLocation;
import java.util.HashMap;
import javax.ejb.Local;

/**
 *
 * @author Ada
 */
@Local
public interface EventManagementLocal {
     void registerEvent(long locationId);
    void registerNoEvent(long locationId);
    HashMap<TriggerLocation,String> getAllLocationsWithEventProb();
}
