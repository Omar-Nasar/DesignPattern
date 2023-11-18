/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Order implements ProxyOrder{
    private String name;
    private int price;
     Connection conn = null;
    ResultSet rs = null, rs2 = null;
    PreparedStatement pst = null, pst2 = null;
    Order p_order;  
    public Order()
    {
        name = "";
        price = 0;
        conn = ResturantManagementSystem.ConnectDB();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void AddOrder(Order order, Customer cus) {
       try
        {
            String insert = "INSERT INTO Orders (item, Price, cust_email) VALUES (?,?,?)";
            pst = conn.prepareStatement(insert);
            pst.setString(1, order.getName());
            pst.setInt(2, order.getPrice());
            pst.setString(3, cus.getUserName());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Order Added", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
