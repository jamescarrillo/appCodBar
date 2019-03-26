/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extras.impresionCodBar;

import static com.extras.impresionCodBar.AlgoritmosZPL.centrarTexto;
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
 * @author james
 */
public class jamescar {

    public static void main(String[] args) {
        try {
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
            /*
^XA
^MMT
^PW479
^LL0406
^LS0
^FT310,315^A0I,28,28^FH\^FDOne Line^FS
^FT291,269^A0I,28,28^FH\^FDSecond Line^FS
^FT326,219^A0I,28,28^FH\^FDThird Line^FS
^FT302,167^A0I,28,28^FH\^FDFour Line^FS
^FT273,118^A0I,28,28^FH\^FDFifth Line1^FS
^PQ1,0,1,Y^XZ         
             */
            StringBuilder cmds = new StringBuilder();
            cmds.append("^XA");
            cmds.append("^MMT");
            cmds.append("^PW479");
            cmds.append("^LL0406");
            cmds.append("^LS0");
            cmds.append("^FT310,315^A0I,28,28^FH\\^FDOne Line^FS");
            cmds.append("^FT291,269^A0I,28,28^FH\\^FDSecond Line^FS");
            cmds.append("^FT326,219^A0I,28,28^FH\\^FDThird Line^FS");
            cmds.append("^FT302,167^A0I,28,28^FH\\^FDFour Line^FS");
            cmds.append("^FT273,118^A0I,28,28^FH\\^FDFifth Line1^FS");
            cmds.append("^PQ1,0,1,Y^XZ");

            byte[] by = getZPL().getBytes();
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            Doc doc = new SimpleDoc(by, flavor, null);

// creamos el printjob
            DocPrintJob job = printService.createPrintJob();

// imprimimos
            job.print(doc, null);
        } catch (PrintException ex) {
            Logger.getLogger(jamescar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getZPL() {
        /*
        cmd = ZPLArgox.getZpl("2x1", "BODEGA DON PEPE", new String[]{"ARROZ", "ACEITE"},
                new String[]{"2.50", "2.80"}, new String[]{"00000001", "00000002"});
         */
        StringBuilder s = new StringBuilder();
        /*
        ^XA
        ^FO250, 70^ADN, 11, 7^FD CORPORACION TECTRONIC SA de CV^FS
        ^FO320, 105^ADN, 11, 7^FD Prueba 1 ^FS
        ^FO30, 150^ADN, 11, 7^FD Texto de muestra 1 ^FS
        ^FO350, 200^ADN, 11, 7
        ^BCN, 80, Y, Y, N^FD corptectr>147896325 ^FS
        ^XZ 
         */
        s.append("^XA");
        s.append("^FO250, 70^ADN, 11, 7^FD CORPORACION TECTRONIC SA de CV^FS");
        s.append("^FO320, 105^ADN, 11, 7^FD Prueba 1 ^FS");
        s.append("^FO30, 150^ADN, 11, 7^FD Texto de muestra 1 ^FS");
        s.append("^FO350, 200^ADN, 11, 7");
        s.append("^BCN, 80, Y, Y, N^FD corptectr>147896325 ^FS");
        s.append("^XZ");
        s.setLength(0);
        s.append("^XA");
        s.append("BODEGA DON PEPE");
        s.append("^BCN, 80, Y, Y, N >147896325 ^FS");
        s.append("^XZ");
        return s.toString();
    }

}
