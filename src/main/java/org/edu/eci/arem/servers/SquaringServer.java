/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.eci.arem.servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class SquaringServer {
    
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            Logger.getLogger(SquaringServer.class.getName()).log(Level.SEVERE, null, e);
        }
        Socket clientSocket = null;
        try {
         clientSocket = serverSocket.accept();
        } catch (IOException e) {
            Logger.getLogger(SquaringServer.class.getName()).log(Level.SEVERE, null, e);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            if(!inputLine.equals("")){
                outputLine = Integer.parseInt(inputLine) * Integer.parseInt(inputLine) + "";
                out.println(outputLine);
            }else{
                break;
            }            
        }
        System.out.println("Closed server");
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
    
}
