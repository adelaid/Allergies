/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.LocationFactors;
import java.util.Vector;
import javax.ejb.Local;

/**
 *
 * @author Ada
 */
@Local
public interface LocationFactorsManagementLocal {
    public void addFactorToLocation(long factorId, long locationId, int percentage);
    public Vector<LocationFactors> getAvoidLocations(Long factorId);
    public Vector<LocationFactors> getAllowedLocations(Long factorId);
}
