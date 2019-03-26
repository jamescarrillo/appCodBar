/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extras.impresionCodBar;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author James Carrillo
 */
public class Demo {

    public static void main(String[] args) {
        List<BeansCodBar> lista = new ArrayList<>();
        BeansCodBar beans1 = new BeansCodBar();
        beans1.setNombre("ARROZ CLASIFICADO");
        beans1.setPrecio("S/ 3.80");
        beans1.setCodigo(" 721557231234");
        BeansCodBar beans2 = new BeansCodBar();
        beans2.setNombre("LECHE NESTLÉ");
        beans2.setPrecio("S/ 5.80");
        beans2.setCodigo(" 721557231231");
        BeansCodBar beans3 = new BeansCodBar();
        beans3.setNombre("LECHE NESTLÉ 2");
        beans3.setPrecio("S/ 5.80");
        beans3.setCodigo(" 721557231234");
        lista.add(beans1);
        lista.add(beans2);
        //lista.add(beans3);
        ImpresionCB.imprimirBarCod("ARGOX", "Argox P4-250 PPLZ", "BODEGA DON PEPITO", "2x1", lista, (short) 2);
    }
}
