/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extras.impresionCodBar;

import java.util.Map;

/**
 *
 * @author James Carrillo
 */
public class AlgoritmosZPL {

    public static String centrarTexto(String cadenaParametro) {
        String cadena = "";//SUPUESTO TXT
        String linea = cadenaParametro;
        boolean linealarga = false;
        boolean salto = false;
        int cantidadDigitosLineaTemp = 0;
        int tamañosiguientepalabra = 0;
        String cadenaTemp = "";//va a almacenar caracter por caracter hasta que complete la linea
        if (linea.length() > 33) {
            linealarga = true;
        }
        int iterador = 0;//iterador de los caracteres de cada linea
        for (int i = 0; i < linea.length(); i++) {
            //SI ES LINEA LARGA O GRANDE
            if (linealarga) {
                //VERIFICAMOS EL TAMAÑO DE LA SIGUIENTE PALABRA
                if (linea.substring(i, i + 1).equals(" ")) {
                    for (int j = i + 1; j < linea.length(); j++) {
                        tamañosiguientepalabra++;
                        if (linea.substring(j, j + 1).equals(" ")) {
                            break;
                        }
                    }
                }
                //VERIFICAMOS SI ALCANZA O NO LA SIGUIENTE PALABRA
                if (iterador + tamañosiguientepalabra < 33) {
                    cadenaTemp = cadenaTemp + linea.substring(i, i + 1);
                    iterador++;
                    cantidadDigitosLineaTemp++;
                    if (i == linea.length() - 1) {
                        salto = true;
                    }
                } else {
                    //ENTRA ACA SI NO ALCANZA Y DARA UN SALTO DE LINEA
                    cadenaTemp = cadenaTemp + "\n";
                    iterador = 0;
                    salto = true;
                }
                tamañosiguientepalabra = 0;
            } else {
                if (linea.substring(i, i + 1).equals(" ")) {
                    for (int j = i + 1; j < linea.length(); j++) {
                        tamañosiguientepalabra++;
                        if (linea.substring(j, j + 1).equals(" ")) {
                            break;
                        }
                    }
                }
                if (iterador + tamañosiguientepalabra < 33) {
                    cadenaTemp = cadenaTemp + linea.substring(i, i + 1);
                    iterador++;
                    cantidadDigitosLineaTemp++;
                    if (i == linea.length() - 1) {
                        salto = true;
                    }
                }

                tamañosiguientepalabra = 0;
            }
            //CENTRAR LA LINEA TEMPO            
            //solo si salto entrara a centrar
            if (salto) {
                String nuevaLineaTemp = "";
                int espaciosParaCentrar = (33 - cantidadDigitosLineaTemp) / 2;
                for (int j = 0; j < espaciosParaCentrar; j++) {
                    nuevaLineaTemp = nuevaLineaTemp + " ";
                }
                nuevaLineaTemp = nuevaLineaTemp + cadenaTemp;//sus espacios mas la cadtempo
                cadena = cadena + nuevaLineaTemp; //lo que tenia + nueva linea temp
                cantidadDigitosLineaTemp = 0;
                cadenaTemp = "";
            }
            salto = false;
        }
        return cadena;
    }

    public static String getZPL(Map<String, String> parametros, String altoCodBar, short cantColumnas, String nombreEmpresa, String nombresProducto[],
            String[] precios, String[] codigosProducto) {
        String zpl;
        zpl = "^XA \n";
        for (int i = 0; i < cantColumnas; i++) {
            zpl = zpl + "^FO " + parametros.get("corx_empresa" + (i + 1)) + "," + parametros.get("cory_empresa" + (i + 1)) + " ^ADN ^FD" + centrarTexto(nombreEmpresa) + "^FS \n"
                    + "^FO " + parametros.get("corx_producto" + (i + 1)) + "," + parametros.get("cory_producto" + (i + 1)) + " ^ADN ^FD" + centrarTexto(nombresProducto[i]) + "^FS \n"
                    + "^FO " + parametros.get("corx_precio" + (i + 1)) + "," + parametros.get("cory_precio" + (i + 1)) + " ^ADN ^FD" + centrarTexto(precios[i]) + "^FS \n"
                    + "^BY 2,2," + altoCodBar + " \n" //BY 2 = 128TPO DE CODBAR, 2 = NOSE, 65 = ALTO CODIGO BAR
                    + "^FO " + parametros.get("corx_codigo" + (i + 1)) + "," + parametros.get("cory_codigo" + (i + 1)) + "^BC^FD" + codigosProducto[i] + "^FS \n";
        }
        zpl = zpl + "^XZ";
        return zpl;
    }

}
