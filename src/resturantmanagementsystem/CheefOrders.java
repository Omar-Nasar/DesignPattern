/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagementsystem;

import Classes.ResturantManagementSystem;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static resturantmanagementsystem.MyReservations.Email;

/**
 *
 * @author DELL
 */
public class CheefOrders extends JFrame{
    private JLabel MyOrders ,order_num, order_items, price;
    private JButton delete_btn, back_btn;
            
    static String Email;
     Connection conn = null;
    ResultSet rs1 = null;
    PreparedStatement pst = null, pst2 = null;
    int h1 = 50, w1 = 170, element_id;
    public CheefOrders()
    {
        init();
//        Email = email;
        setTitle("Resturant Manegment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
         conn = ResturantManagementSystem.ConnectDB();
        ActionBack();
        ShowOrders();
    }
    
    private void init()
    {
        MyOrders = new JLabel("My Orders");
        MyOrders.setFont(new Font("Tahoma",1, 25));
        MyOrders.setBounds(300, 0, 300, 100);
        this.add(MyOrders);
        back_btn = new JButton("Back");
        back_btn.setBounds(350, 700 , 100, 40);
       back_btn.setBackground(new java.awt.Color(255,255,255));
       back_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 30));
       this.add(back_btn);
       
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(600, Short.MAX_VALUE)
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addContainerGap(700, Short.MAX_VALUE))
        );

        pack();
        
    }
    private void ActionBack(){
        back_btn.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent evt) {
                
//                    new MianMenu(Name).setVisible(true);
                    dispose();    
            }
        });
   }
    
    private void ShowOrders()
    {
        try
        {
            int i = 0;
            String select1 = "SELECT * FROM Orders";
            pst = conn.prepareStatement(select1);
//            pst.setString(1, Email);
            rs1 = pst.executeQuery();
            while(rs1.next())
            {
                i++;
                JLabel OrderNumer = new JLabel("Order Number: " + i);
                JLabel Items = new JLabel(""+rs1.getString("item").toString());
                JLabel Price = new JLabel("Price: "+rs1.getString("Price").toString() + "$");
                OrderNumer.setFont(new Font("Tahoma", 1, 18));
                OrderNumer.setBounds(50, 0 + h1, 200, 100);
                this.add(OrderNumer);
               
                Items.setFont(new Font("Times new Roman", 1, 18));
                Items.setBounds(60, 50 + h1, 450, 100);
                this.add(Items);
                Price.setFont(new Font("Times new Roman", 1, 18));
                Price.setBounds(320 + w1, 50 + h1, 200, 100);
                this.add(Price);
                
                element_id = Integer.parseInt(rs1.getString("order_ID"));
                delete_btn = new JButton("Complete");
                delete_btn.setBackground(new java.awt.Color(255,255,255));
                delete_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 20));
                delete_btn.setBounds(460 +w1 , 80 + h1, 120, 32);
                this.add(delete_btn);
                ActoinDelete(element_id);
                h1 += 120;
            }
            
            rs1.close();
            pst.close();
        }
        
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    private void ActoinDelete(int id){
        delete_btn.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent evt) {
                
                try
                {
                    String view = "DELETE FROM Orders WHERE order_ID = ?";
                    
                    pst2 = conn.prepareStatement(view);
                    pst2.setInt(1, id);
                    pst2.execute();
                    pst2.close();
                    JOptionPane.showMessageDialog(null, "Order Cooked", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
              
            }
        });
   }
}
