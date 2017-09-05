/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Ada
 */
public class Risk implements Serializable {
    private HashMap<TriggerFactor,Integer> factor;
    private TriggerLocation location;

    public HashMap<TriggerFactor, Integer> getFactor() {
        return factor;
    }

    public void setFactor(HashMap<TriggerFactor, Integer> factor) {
        this.factor = factor;
    }

    public TriggerLocation getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Risk{" + "factor=" + factor + ", location=" + location + '}';
    }

    public void setLocation(TriggerLocation location) {
        this.location = location;
    }
    
    
    
}
