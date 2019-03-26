/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extras.impresionCodBar;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.ColorSupported;
import javax.print.attribute.standard.PrinterName;

/**
 *
 * @author James Carrillo
 */
public class ImpresoraCB {

    public static String imprimirCB(String comandosZPL, String nombreImpresora) {
        String respuestaImpresion = "";
        try {

            byte[] by = comandosZPL.getBytes();
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            Doc doc = new SimpleDoc(by, flavor, null);
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
// creamos el printjob
            DocPrintJob job = printService.createPrintJob();
            job.print(doc, null);
            /*
byte[] by = comandosZPL.getBytes();
DocFlavor docFormat = DocFlavor.BYTE_ARRAY.AUTOSENSE;
Doc document = new SimpleDoc(by, docFormat, null);
String printerName = nombreImpresora;
AttributeSet attributeSet = new HashAttributeSet();
attributeSet.add(new PrinterName(printerName, null));
attributeSet = new HashAttributeSet();
attributeSet.add(ColorSupported.NOT_SUPPORTED);
PrintService[] services = PrintServiceLookup.lookupPrintServices(docFormat, attributeSet);
boolean encontro = false;
for (PrintService service : services) {
if (service.getName().equals(printerName)) {
encontro = true;
break;
}
}
if (encontro) {
System.out.println("->encontro");
try {
DocPrintJob printJob = services[0].createPrintJob();
printJob.print(document, new HashPrintRequestAttributeSet());
respuestaImpresion = "CORRECTO";
} catch (PrintException ex) {
Logger.getLogger(ImpresoraCB.class.getName()).log(Level.SEVERE, null, ex);
}
} else {
respuestaImpresion = "No se imprimió, no se encontró la impresora con Nombre " + services[0].getName();
}
             */

        } catch (PrintException ex) {
            Logger.getLogger(ImpresoraCB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuestaImpresion;
    }

}
