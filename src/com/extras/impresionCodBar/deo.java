/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extras.impresionCodBar;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

/**
 *
 * @author James Carrillo
 */
public class deo {

    public static void main(String[] args) {

        try {
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
            //NUM MAXIMO DE CARACTERES 33

            /*String zplCommand = "^XA\n"
                    + "^FO10,0^ARN,11,7^FD SOME TEXT ^FS\n"
                    + "^FO300,0^ARN,11,7^FD SOME VALUE ^FS\n"
                    + "^FO10,35^ARN,11,7^FD SOME TEXT ^FS\n"
                    + "^FO300,35^ARN,11,7^FD SOME VALUE ^FS\n"
                    + "^FO10,70^ARN,11,7^FD SOME CODE ^FS\n"
                    + "^FO10,115^ARN,11,7^BCN,60,Y,Y,N^FD 23749237439827 ^FS\n"
                    + "^XZ";
             */
            String zplCommand;
            zplCommand = "^XA\n"
                    + "^MMC\n"
                    + "^PW650\n"
                    + "^LL0223\n"
                    + "^LS0\n"
                    + "^BY2,3,87^FT366,148^B3N,N,,Y,N\n"
                    + "^FDbarcode-1^FS\n"
                    + "^BY2,3,87^FT33,148^B3N,N,,Y,N\n"
                    + "^FDbarcode-2^FS\n"
                    + "^PQ1,1,1,Y^XZ";

            
            zplCommand = "^XA\n"
                    + "^FO0,30 ^ADN ^FD" + centrarTexto("NOVEDADES JAMES") + "^FS\n"
                    + "^FO0,55 ^ADN ^FD" + centrarTexto("LECHE") + "^FS \n"
                    + "^FO0,75 ^ADN ^FD" + centrarTexto("S/ 2.30") + "^FS \n"
                    + "^BY2,2,65\n"
                    + "^FO25,100^BC ^FD 721557221234^FS\n"
                    + "^FO 445,30 ^ADN ^FD " + centrarTexto("NOVEDADES JAMES") + " ^FS\n"
                    + "^FO 445,55 ^ADN ^FD " + centrarTexto("Azucar Blanca ") + " ^FS \n"
                    + "^FO 445,75 ^ADN ^FD " + centrarTexto("S/ 3.40") + " ^FS \n"
                    + "^BY2,2,65\n"
                    + "^FO460,100^BC ^FD 721557231234^FS\n"
                    + "^XZ";
             
 /*
            zplCommand = "^XA\n"
                    + "^FO0,40 ^ADN ^FD RED SOLUCIONES^FS\n"
                    + "^FO 60,70 ^ADN ^FD Leche ^FS \n"
                    + "^BY2,2,70\n"
                    + "^FO0,100^BC ^FD72155722^FS\n"
                    
                    + "^FO400,40 ^ADN ^FD RED SOLUCIONES^FS\n"
                    + "^FO 460,70 ^ADN ^FD Leche 2 ^FS \n"
                    + "^BY2,2,70\n"
                    + "^FO360,100^BC ^FD72155723^FS\n"
                     
                    + "^XZ";
             */
// convertimos el comando a bytes
            byte[] by = zplCommand.getBytes();
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            Doc doc = new SimpleDoc(by, flavor, null);

// creamos el printjob
            DocPrintJob job = printService.createPrintJob();

// imprimimos
            job.print(doc, null);
        } catch (PrintException ex) {
            Logger.getLogger(deo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String centrarTexto(String nombreEmpresa) {
        String cadena = "";//SUPUESTO TXT
        String linea = nombreEmpresa;
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

}
