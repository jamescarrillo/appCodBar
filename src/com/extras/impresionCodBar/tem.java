/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extras.impresionCodBar;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author James Carrillo
 */
public class tem {

    public static void main(String[] args) {
        Map<String, String> parametros = new HashMap<>();
        parametros.put("key1", "val1");
        parametros.put("key2", "val2");

        for (int i = 0; i < 10; i = i + 2) {
            System.out.println("-> " +i);
        }
    }
}
