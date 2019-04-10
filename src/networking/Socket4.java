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
 * @author mca237
 */
class ThreadServer implements Runnable{
    Socket s;
    public ThreadServer(Socket s) {
        this.s =s;
    }    
    @Override
    public void run() {
        try {
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            
            Scanner sc = new Scanner(in,"UTF-8");
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out),true);
            pw.println("Type bye to Exit");
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                pw.println("Server Responded "+line);
                if(line.equals("bye")){
                    s.close();
                    break;
                }
            }
        } catch (Exception e) {
            
        }
    }
}
public class Socket4 {
    public static void main(String args[]) throws IOException{
        int count = 1;
        ServerSocket ss = new ServerSocket(9858);
        while (true) {            
       Socket s = ss.accept();
       System.out.println("Thread " + count+ " Created");
       Thread t = new Thread(new ThreadServer(s));
       t.start();
       count++;
        }
       
    }
}
