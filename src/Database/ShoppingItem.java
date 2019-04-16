/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author mca237
 */
public class ShoppingItem {
    int id;
    String name;
    int price;
    int ctrg_id;

    public ShoppingItem() {
        id=0;
        name="NA";
        price=0;
        ctrg_id=0;
    }

    public ShoppingItem(int id, String name, int price, int ctrg_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ctrg_id = ctrg_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCtrg_id() {
        return ctrg_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCtrg_id(int ctrg_id) {
        this.ctrg_id = ctrg_id;
    }

    @Override
    public String toString() {
        return "ShoppingItem{" + "id=" + id + ", name=" + name + ", price=" + price + ", ctrg_id=" + ctrg_id + '}';
    }
    
}
