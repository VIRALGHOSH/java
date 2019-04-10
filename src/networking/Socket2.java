/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Viral
 */
public class Socket2 {
    public static void main(String args[]){
        try {
           //InetAddress address = InetAddress.getLocalHost();
            System.out.println("Address of Localhost : "+ InetAddress.getLocalHost());
            InetAddress addressList[] = InetAddress.getAllByName("google.co.in");
           for (InetAddress a : addressList){
           System.out.println(a);
           }
           System.out.println(InetAddress.getByName("localhost"));
           System.out.println(InetAddress.getLoopbackAddress());
   
        } catch (UnknownHostException ex) {
            Logger.getLogger(Socket2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
