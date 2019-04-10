
package networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class SocketServer implements Runnable{
    Socket s;
    public SocketServer(Socket s){
    this.s=s;}
    @Override
    public void run() {
        InputStream in = null;
        try {
            in = s.getInputStream();
            OutputStream os = s.getOutputStream();
            PrintWriter out = new PrintWriter(new OutputStreamWriter(os,"UTF-8"),true);
            Scanner sc = new Scanner(in,"UTF-8");
            out.println("ewewfew");
            while(sc.hasNextLine()){
            String line = sc.nextLine();
            out.println(line);
            }
            
            
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

}
public class test{
    public static void main(String argf[]){
    ServerSocket ss;
       try {
           ss = new ServerSocket(5555);
    while(true){
       
            
            Socket s = ss.accept();
            System.out.println("cwe");
            Thread t = new Thread(new SocketServer(s));
            t.start();
    }
        } catch (IOException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
}
