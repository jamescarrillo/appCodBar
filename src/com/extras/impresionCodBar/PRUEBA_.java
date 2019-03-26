/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.extras.impresionCodBar;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author James Carrillo
 */
public class PRUEBA_ {

    public static void main(String[] args) throws IOException {
        /*
        Socket clientSocket = new Socket("", 123);
        String zpl = "";
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        outToServer.writeBytes(zpl);
        clientSocket.close();
        */
        System.out.println(getZPL());
        
    }
    
    public static String getZPL() {
        String cmd = ZPLArgox.getZpl("2x1", "BODEGA DON PEPE", new String[]{"ARROZ", "ACEITE"},
                new String[]{"2.50", "2.80"}, new String[]{"00000001", "00000002"});
        return cmd;
    }

}
