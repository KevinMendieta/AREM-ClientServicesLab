/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.eci.arem.url;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class URLTest {
    
    public void main(String[] args) {
        try {
            URL specificURL = new URL("https://outlook.office.com/owa/?realm=mail.escuelaing.edu.co&exsvurl=1&ll-cc=3082&modurl=0&path=/mail/inbox");
            System.out.println("Protocol used -->" + specificURL.getProtocol());
            System.out.println("Authority used -->" + specificURL.getAuthority());
            System.out.println("Host used -->" + specificURL.getHost());
            System.out.println("Port used -->" + specificURL.getPort());
            System.out.println("Path used -->" + specificURL.getPath());
            System.out.println("Query used -->" + specificURL.getQuery());
            System.out.println("File used -->" + specificURL.getFile());
            System.out.println("Reference used -->" + specificURL.getRef());
        } catch (MalformedURLException e) {
            Logger.getLogger(URLTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
