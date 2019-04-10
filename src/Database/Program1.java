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
            String query = "select  ctrg.ctrg_name,i.item_name, i.item_price ,c.cart_quantity ,i.item_price* c.cart_quantity as Total \n" +
                    "from ((items as i \n" +
                    "inner join cart as c on i.item_id = c.item_id)\n" +
                    "inner join category as ctrg on i.ctrg_id = ctrg.ctrg_id)\n";
            int totalbill = 0;
            ResultSet rs = cmd.executeQuery(query);
            while(rs.next()){
                String ctrg = rs.getString(1);
                String name = rs.getString(2);
                String price = rs.getString(3);
                String quantity = rs.getString(4);
                String total = rs.getString(5);
                totalbill = totalbill+ Integer.parseInt(total);
                System.out.println(ctrg+"  "+ name+"  "+ price+"  "+quantity+"  "+total);
            }
                System.out.println("Total Bill:-  "+totalbill);            
            con.close();
        } catch (Exception e) {
            
        }
    }
    
}
