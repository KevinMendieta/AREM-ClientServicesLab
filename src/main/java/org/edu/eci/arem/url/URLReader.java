/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.eci.arem.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinMendieta
 */
public class URLReader {
    
    public static void main(String[] args) {
        URL specificURL;
        BufferedReader reader;
        BufferedWriter writer;
        try{
            String inputURL = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            specificURL = new URL(inputURL);
            reader = new BufferedReader(new InputStreamReader(specificURL.openStream()));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/Users/Kevin/Documents/NetBeansProjects/ClientsServicesLab/index.html"), "utf-8"));
            String content = "";
            while(reader.ready()){
                content += reader.readLine();
            }
            writer.write(content);
            writer.close();
        } catch (IOException e){
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
}
