/*
 Write a java program to get date time from server using socket programing.
 */
package networking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Viral
 */
public class socket1 {
    public static void main(String srgs[]) throws IOException{
        //Socket s = new Socket("time-a.nist.gov",13);
        //s.setSoTimeout(10000);
        
        Socket s = new Socket();
        s.connect(new InetSocketAddress("time-a.nist.gov",13), 10000);
        Scanner sc = new Scanner (s.getInputStream(),"UTF-8");
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
    }
    }
}