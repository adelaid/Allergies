/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.Risk;
import domain.TriggerLocation;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ada
 */
@Local
public interface RiskManagamentLocal {
      public ArrayList<Risk> getRiskMap(Long userId, Long factorId);
      public List<TriggerLocation> getAllLocations();
}
