/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author nrs
 */
public class oddeven {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        // creating server
        ServerSocket ss = new ServerSocket(5555);
        
        // accept incoming connection from the client
        Socket incoming = ss.accept();
        
        //reading and sending messages to the client
        InputStream is = incoming.getInputStream();
        OutputStream os = incoming.getOutputStream();
        
        //reading data from the client
        Scanner sc = new Scanner(is,"UTF-8");
        
        //writing data from the client
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os,"UTF-8"),true);
        pw.println("Enter Bye for Exit.....");
        
        while(sc.hasNextLine()) {
        String line = sc.nextLine();
        int num = Integer.parseInt(line);
        if(line.equals("Bye")) {
            pw.print("Connection is closed");
            incoming.close();
            ss.close();
            break;
        }
            if(num % 2 == 0) {
                pw.println("\nEven");
            }
            else {
                pw.println("\nOdd");
                }
        }
        
    }
    
}
