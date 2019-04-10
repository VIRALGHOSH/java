/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author mca237
 */
public class Program1 {
    public static void main(String[] args) {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://localhost:3306/shopping_database";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement cmd = con.createStatement();
            String query = "select  a.item_name, a.item_price ,b.cart_quantity ,a.item_price* b.cart_quantity as Total from items as a join cart as b on a.item_id = b.item_id";
            int totalbill = 0;
            ResultSet rs = cmd.executeQuery(query);
            while(rs.next()){
                String name = rs.getString(1);
                String price = rs.getString(2);
                String quantity = rs.getString(3);
                String total = rs.getString(4);
                totalbill = totalbill+ Integer.parseInt(total);
                System.out.println( name+"  "+ price+"  "+quantity+"  "+total);
            }
                System.out.println("Total Bill:-  "+totalbill);            
            con.close();
        } catch (Exception e) {
            
        }
    }
    
}
