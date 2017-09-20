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
 * @author KevinMendieta
 */
public class MathServer {
    
    public static int currentState;
    public static final int SIN_STATE = 1;
    public static final int COS_STATE = 2;
    public static final int TAN_STATE = 3;
    
    public static double makeCalc(double number) {
        double result = 0;
        if (currentState == SIN_STATE) {
            result = Math.sin(number);
        } else if (currentState == COS_STATE) {
            result = Math.cos(number);
        } else if (currentState == TAN_STATE) {
            result = Math.tan(number);
        }
        return result;
    }
    
    public static void changeState(String prefix) {
        if (prefix.equals("sin")) {
            currentState = SIN_STATE;
        } else if (prefix.equals("tan")) {
            currentState = TAN_STATE;
        } else {
            currentState = COS_STATE;
        }
    }
    
    public static void main(String[] args) throws IOException {
        currentState = COS_STATE;
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
            if (!inputLine.equals("")) {
                if(inputLine.startsWith("fun:")){
                    changeState(inputLine.substring(4));
                    outputLine = "Changed to: " + inputLine.substring(4);
                }else {
                    outputLine = makeCalc(Double.parseDouble(inputLine)) + "";
                }
                out.println(outputLine);
            } else {
                out.println("Bye!!");
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
