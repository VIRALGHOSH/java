/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author mca237
 */
public class Update {
      public static void main(String[] args) {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://localhost:3306/shopping_database";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement cmd = con.createStatement();
            Scanner sc = new Scanner(System.in);
            System.out.println("Updated Item name :-");
            String name = sc.nextLine();
            System.out.println("Item  ID :-");
            int mainid = sc.nextInt();
            String query = "update items set item_name='"+name+"' where item_id="+mainid;
    
            int count=  cmd.executeUpdate(query);
            if(count==1)
            System.out.println("Succefull");
            else
            System.out.println("NAhhhs");
           
         
            con.close();
        } catch (Exception e) {
            
        }
    }
}
