/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Naming;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class TempClient {
     public static void main(String[] args) {
         try {
             TempInterface r = (TempInterface)Naming.lookup("//localhost/TempServer");
             String input=JOptionPane.showInputDialog("Enter fahrenheit ");
             Double celsius = Double.parseDouble(input);
             Double response=r.convertF2C(celsius);
             DecimalFormat df2 = new DecimalFormat(".##");
             System.out.println("Celsius = "+ df2.format(response));
             
             
         } catch (NumberFormatException ex) {
           System.out.println("Please input Numbers Only");
           }
           catch (Exception ex) {
           System.out.println(ex.toString());
           }
         
         
     }
}
