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
public class ZPLArgox {

    public static String getZpl(String medida, String nombreEmpresa,
            String[] nombresProducto, String[] precios, String[] codigosProducto) {
        String zpl = "";
        switch (medida) {
            //PARAMETROS PULGADAS
            case "2x1":
                zpl = getZpl2x1(nombreEmpresa, nombresProducto, precios, codigosProducto);
                break;
            case "2x1.5":

                break;
            case "1.8x0.78":

                break;
        }
        return zpl;
    }

    private static String getZpl2x1(String nombreEmpresa, String[] nombresProducto,
            String[] precios, String[] codigosProducto) {
        //VALIDADO SOLO PARA DOS COLUMNAS
        String zpl;
        Map<String, String> parametros = new HashMap<>();
        parametros.put("corx_empresa1", "0");
        parametros.put("cory_empresa1", "30");
        parametros.put("corx_producto1", "0");
        parametros.put("cory_producto1", "55");
        parametros.put("corx_precio1", "0");
        parametros.put("cory_precio1", "75");
        parametros.put("corx_codigo1", "25");
        parametros.put("cory_codigo1", "100");

        parametros.put("corx_empresa2", "445");
        parametros.put("cory_empresa2", "30");
        parametros.put("corx_producto2", "445");
        parametros.put("cory_producto2", "55");
        parametros.put("corx_precio2", "445");
        parametros.put("cory_precio2", "75");
        parametros.put("corx_codigo2", "460");
        parametros.put("cory_codigo2", "100");
        zpl = AlgoritmosZPL.getZPL(parametros, "65", (short) 2, nombreEmpresa, nombresProducto, precios, codigosProducto);
        return zpl;
    }

}
