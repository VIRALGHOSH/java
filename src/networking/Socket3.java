/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;


import java.io.*;
import java.net.*;
import java.util.Scanner;
//its an single server-client program
public class Socket3 {
    public static void main(String []p){
        try {
            //need to provide 4 digit port number
            ServerSocket ss = new ServerSocket(4444);
            //making a connection & accept method returns a socket itself
            Socket incoming = ss.accept();
            //reading & writing messages to the client
            InputStream is = incoming.getInputStream();
            OutputStream os = incoming.getOutputStream();
            //Reading data from the client
            Scanner sc = new Scanner(is, "UTF-8");
            //Sending data to the client
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(os, "UTF-8"),true /*autoflush*/);
            out.println("Type BYE to exit");
            //Reading data from client
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line.equals("BYE") || line.equals("bye")){
                 incoming.close();
                 ss.close();
                 break;
                }
                out.println("Server Responded : " + line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    } 
}