/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.TriggerFactor;
import java.util.Vector;
import javax.ejb.Local;

/**
 *
 * @author Ada
 */
@Local
public interface TriggerFactorManagementLocal {
     public void addFactor(String name);
     public TriggerFactor getFactor(Long id);
     public Vector<TriggerFactor> getFactors();
     public TriggerFactor getFactorName(String name);
}
