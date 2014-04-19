/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hudsonhui.wunderlisttoastrid.astrid;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author HiM
 */
public class IdGenerator {
    
    private static Set<Long> generatedIds = new HashSet<>();
    private static Random r = new Random();
    
    public static synchronized long generate() {
        long id;
        do {
            id = Math.abs(r.nextLong());
        } while (generatedIds.contains(id));
        generatedIds.add(id);
        return id;
    }
    
}
