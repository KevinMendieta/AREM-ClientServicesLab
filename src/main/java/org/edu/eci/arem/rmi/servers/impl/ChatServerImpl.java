/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.eci.arem.rmi.servers.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.edu.eci.rmi.arem.servers.ChatServer;

/**
 *
 * @author KevinMendieta
 */
public class ChatServerImpl implements ChatServer {
    
    
    public ChatServerImpl(String ipRMIregistry, int puertoRMIregistry, String nombreDePublicacion) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            ChatServer echoServer = (ChatServer) UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.getRegistry(ipRMIregistry, puertoRMIregistry);
            registry.rebind(nombreDePublicacion, echoServer);
            System.out.println("Echo server ready...");
        } catch (Exception e) {
            System.err.println("Echo server exception:");
            e.printStackTrace();
        }
    }
    
    @Override
    public String response(String message) throws RemoteException {
        String newMessage = "";
        try {
            newMessage = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        } catch (IOException ex) {
            Logger.getLogger(ChatServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newMessage;
    }
    
    public static void main(String[] args) {
        ChatServerImpl ec = new ChatServerImpl("127.0.0.1", 23000, "chatServer");
    }
    
}
