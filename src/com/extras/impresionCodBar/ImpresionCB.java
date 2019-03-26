/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extras.impresionCodBar;

import java.util.List;

/**
 *
 * @author James Carrillo
 */
public class ImpresionCB {

    public static String imprimirBarCod(String marcaImpresora, String nombreImpresora, String nombreEmpresa, String medida, 
            List<BeansCodBar> lista, short cantColumnas) {
        String respuesta = "";
        switch (marcaImpresora) {
            case "ZEBRA":
                
                break;
            case "ARGOX":
                ImpresoraCB.imprimirCB(getComandosZPL_ARGOX(lista, nombreEmpresa, medida, cantColumnas), nombreImpresora);
                break;
        }
        return respuesta;
    }

    private static String getComandosZPL_ARGOX(List<BeansCodBar> lista, String nombreEmpresa, String medida, short cantColumnas) {
        String cadenaComandosZPL = "";
        String[] nombresProducto = new String[3];
        String[] precios = new String[3];
        String[] codigosProducto = new String[3];
        for (int i = 0; i < lista.size(); i = i + cantColumnas) {
            nombresProducto[0] = lista.get(i).getNombre();
            precios[0] = lista.get(i).getPrecio();
            codigosProducto[0] = lista.get(i).getCodigo();
            switch (cantColumnas) {
                case 2:
                    nombresProducto[1] = lista.get(i + 1).getNombre();
                    precios[1] = lista.get(i + 1).getPrecio();
                    codigosProducto[1] = lista.get(i + 1).getCodigo();
                    break;
                case 3:
                    nombresProducto[1] = lista.get(i + 1).getNombre();
                    precios[1] = lista.get(i + 1).getPrecio();
                    codigosProducto[1] = lista.get(i + 1).getCodigo();

                    nombresProducto[2] = lista.get(i + 2).getNombre();
                    precios[2] = lista.get(i + 2).getPrecio();
                    codigosProducto[2] = lista.get(i + 2).getCodigo();
                    break;
            }
            cadenaComandosZPL = cadenaComandosZPL + getComandoZPL_ARGOX(medida, nombreEmpresa, nombresProducto, precios, codigosProducto);
        }
        return cadenaComandosZPL;
    }

    private static String getComandosZPL_ZEBRA(List<BeansCodBar> lista, String nombreEmpresa, String medida, short cantColumnas) {
        String cadenaComandosZPL = "";
        String[] nombresProducto = new String[3];
        String[] precios = new String[3];
        String[] codigosProducto = new String[3];
        for (int i = 0; i < lista.size(); i = i + cantColumnas) {
            nombresProducto[0] = lista.get(i).getNombre();
            precios[0] = lista.get(i).getPrecio();
            codigosProducto[0] = lista.get(i).getCodigo();
            switch (cantColumnas) {
                case 2:
                    nombresProducto[1] = lista.get(i + 1).getNombre();
                    precios[1] = lista.get(i + 1).getPrecio();
                    codigosProducto[1] = lista.get(i + 1).getCodigo();
                    break;
                case 3:
                    nombresProducto[1] = lista.get(i + 1).getNombre();
                    precios[1] = lista.get(i + 1).getPrecio();
                    codigosProducto[1] = lista.get(i + 1).getCodigo();

                    nombresProducto[2] = lista.get(i + 2).getNombre();
                    precios[2] = lista.get(i + 2).getPrecio();
                    codigosProducto[2] = lista.get(i + 2).getCodigo();
                    break;
            }
            cadenaComandosZPL = cadenaComandosZPL + getComandoZPL_ZEBRA(medida, nombreEmpresa, nombresProducto, precios, codigosProducto);
        }
        return cadenaComandosZPL;
    }

    private static String getComandoZPL_ARGOX(String medida, String nombreEmpresa, String[] nombresProducto, String[] precios, String[] codigosProducto) {
        return ZPLArgox.getZpl(medida, nombreEmpresa, nombresProducto, precios, codigosProducto);
    }

    private static String getComandoZPL_ZEBRA(String medida, String nombreEmpresa, String[] nombresProducto, String[] precios, String[] codigosProducto) {
        return ZPLArgox.getZpl(medida, nombreEmpresa, nombresProducto, precios, codigosProducto);
    }

}
