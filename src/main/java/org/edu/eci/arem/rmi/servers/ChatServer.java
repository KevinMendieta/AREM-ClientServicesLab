/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.eci.rmi.arem.servers;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author KevinMendieta
 */
public interface ChatServer extends Remote {
    
    public String response(String message) throws RemoteException;
    
}
