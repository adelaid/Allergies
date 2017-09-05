/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.TriggerLocation;
import java.util.Vector;
import javax.ejb.Local;

/**
 *
 * @author Ada
 */
@Local
public interface TriggerLocationManagementLocal {
    public void addLocation(String name);
    public TriggerLocation getLocation(Long id);
    public Vector<TriggerLocation> getAllLocations();
}
