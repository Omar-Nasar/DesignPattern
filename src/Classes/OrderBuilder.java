/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author DELL
 */
public class OrderBuilder {
    private Order order;
    String Tot_item;
    int Tot_price;
    public OrderBuilder(){
        order = new Order();
        this.Tot_item = "";
        this.Tot_price = 0;
        order.setName("");
        order.setPrice(0);
    }

    public String getTot_item() {
        return order.getName();
    }

    public void setTot_item(String Tot_item) {
        this.Tot_item =this.Tot_item  + " " + Tot_item;
        order.setName(this.Tot_item);
    }

    public int getTot_price() {
        return order.getPrice();
    }

    public void setTot_price(int Tot_price) {
        this.Tot_price += Tot_price;
        order.setPrice(this.Tot_price);
    }
    public void InitItem()
    {
        this.Tot_item = "";
        this.Tot_price = 0;
        order.setName("");
        order.setPrice(0);
    }
}
