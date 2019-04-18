/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mca237
 */
public class DatabaseHelper {

    Connection con;
    ArrayList<ShoppingItem> ShoppingList;
    
    public DatabaseHelper() {
        getConnection();
        ShoppingList = getShoppingItems();
    }
    private void getConnection(){
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://localhost:3306/shopping_database";
            con = DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            System.out.println("Error in connection "+e.getMessage());
        }
    }
    public ArrayList<ShoppingItem> getShoppingItems(){
        ArrayList<ShoppingItem> itemList = new ArrayList<>(); 
        try {
            Statement cmd = con.createStatement();
            String query = "select * from items";
            ResultSet rs = cmd.executeQuery(query);
            while(rs.next()){
                ShoppingItem item = new ShoppingItem();
                item.id = rs.getInt("item_id");          // we can also use colom names
                item.name = rs.getString(2);
                item.price = rs.getInt(3);
                item.ctrg_id = rs.getInt(4);
                itemList.add(item);
            }
        } catch (Exception e) {
             System.out.println("Error in Getting items "+e.getMessage());
        }
        return itemList;
    }
    private int insertRecord(ShoppingItem s){
        ArrayList<ShoppingItem> itemList = new ArrayList<>();
         int status = 0;
        try {
            Statement cmd = con.createStatement();
            String query = "insert into items values (NULL,'"+s.name+"','"+s.getPrice()+"',"+s.getCtrg_id()+")";
            status= cmd.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
             System.out.println("Error in insert item "+e.getMessage());
        }
        return status;
    }
    private int updateRecord(ShoppingItem s){
        return 0;
    }
    private int deleteRecord(int id){
        return 0;
    }
}
