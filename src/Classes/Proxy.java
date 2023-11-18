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
public class Proxy implements ProxyOrder{
    Connection conn = null;
    ResultSet rs = null, rs2 = null;
    PreparedStatement pst = null, pst2 = null;
    Order p_order;
    public Proxy(){
        conn = ResturantManagementSystem.ConnectDB();
    }
    
    public boolean CheckRes(Customer cust, String branch)
    {
        try
        {
            System.out.println(cust.getUserName());
            String view = "SELECT * FROM Reservation WHERE cust_email = ?";
            pst = conn.prepareStatement(view);
            pst.setString(1, cust.getUserName());
            rs = pst.executeQuery();
            while(rs.next())
            {
//                System.out.println(rs.getString("Date"));
                try
                {
                    System.out.println("ID: " + rs.getInt("table_ID"));
                    String get = "SELECT * FROM Tables WHERE Table_ID = ? AND Rest_branch = ?";
                    pst2 = conn.prepareStatement(get);
                    pst2.setInt(1, rs.getInt("table_ID"));
                    pst2.setString(2, branch);
                    rs2 = pst2.executeQuery();
                    if(rs2.next())
                    {
                        System.out.println("hi");
                        rs.close();
                        rs2.close();
                        pst2.close();
                        return true;
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                 
            }
            rs.close();
            rs2.close();
            pst2.close();
            pst.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    

    @Override
    public void AddOrder(Order order, Customer cus)
    {
        p_order = order;
        order.AddOrder(p_order, cus);

    }
}
