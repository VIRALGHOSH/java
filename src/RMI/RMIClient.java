/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Naming;
import javax.swing.JOptionPane;

public class RMIClient {
    public static void main(String[] args) {
        try
        {
            RMIInterface r=(RMIInterface)Naming.lookup("//localhost/MyServer");
           System.out.println(r.hello("Viral"));
            // String text=JOptionPane.showInputDialog("Enter your name");
            // String response=r.hello(text);
           //  JOptionPane.showMessageDialog(null, response);
            
        }catch(Exception w)
        {
            System.err.println(w.getMessage());
            
        }
        
    }
}