/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.eci.arem.rmi.clients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.edu.eci.rmi.arem.servers.ChatServer;

/**
 *
 * @author KevinMendieta
 */
public class ChatClient {

    public void ejecutaServicio(String ipRmiregistry, int puertoRmiRegistry,
            String nombreServicio) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Registry registry = LocateRegistry.getRegistry(ipRmiregistry, puertoRmiRegistry);
            ChatServer echoServer = (ChatServer) registry.lookup(nombreServicio);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                System.out.println(echoServer.response(userInput));
                if (userInput.equals("")) break;
            }
        } catch (Exception e) {
            System.err.println("Hay un problema:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatClient ec = new ChatClient();
        ec.ejecutaServicio("127.0.0.1", 23000, "echoServer");
    }

}
