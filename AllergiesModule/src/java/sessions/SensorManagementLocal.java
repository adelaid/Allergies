/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.Sensor;
import java.util.Vector;
import javax.ejb.Local;

/**
 *
 * @author Ada
 */
@Local
public interface SensorManagementLocal {
    public void addSensor(String name);
     public Sensor getSensor(Long id);
     public Vector<Sensor> getSensors();
     public Sensor getSensor(String name);
}
