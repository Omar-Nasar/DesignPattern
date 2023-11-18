/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagementsystem;

import Classes.*;
import Classes.ResturantManagementSystem;
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
import javax.swing.JTextField;
import static resturantmanagementsystem.Register.Cust_name;
import static resturantmanagementsystem.Register.email;
//import static resturantmanagementsystem.ShowMenuAll.Name;

/**
 *
 * @author DELL
 */
public class ShowOneMenu extends JFrame{
    private JLabel FoodType_lbl, name_lbl, price, extra_lbl, soup_lbl, drink_lbl, salad_lbl, cost_lbl;
     private JButton back_btn, order_btn, clear_btn, submit_btn;
     private JTextField cost;
    private int c = 0;
//    static String Name;
    private String type;
    
     Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    int h = 20, h2 = 20;
    int Total_cost = 0 ,elem_id;
    String total_order = "";
    String elem_name, elem_price;
    private Customer customer;
    private Proxy proxy;
    private OrderBuilder order_build;
    private Order order;
    public ShowOneMenu(String type, Customer cust)
    {
        this.customer = cust;
        proxy = new Proxy();
        order_build = new OrderBuilder();
        order = new Order();
        this.type = type;
      setTitle("Resturant Manegment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
//        setLocationRelativeTo(this);
        conn = ResturantManagementSystem.ConnectDB();
        init();
        GetData();
        ActionBack();
        
    }
    private void init()
    {
        drink_lbl = new JLabel("Drink");
        soup_lbl = new JLabel("Soup");
        extra_lbl = new JLabel("Extras");
        salad_lbl = new JLabel("Salad");
        cost = new JTextField("");
        cost.setFont(new Font("Times New Roman",1, 22));
        cost.setBounds(840, 600, 150, 50);
        this.add(cost);
        cost.setRequestFocusEnabled(false);
        cost_lbl = new JLabel("Total Cost:");
        cost_lbl.setFont(new Font("Times New Roman",1, 22));
        cost_lbl.setBounds(700, 600, 150, 50);
        this.add(cost_lbl);
        clear_btn = new JButton("Clear");
        clear_btn.setBounds(850, 670 , 100, 40);
        clear_btn.setBackground(new java.awt.Color(255,255,255));
        clear_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 25));
       this.add(clear_btn);
       submit_btn = new JButton("Submit Order");
       submit_btn.setBounds(400, 790 , 200, 40);
        submit_btn.setBackground(new java.awt.Color(255,255,255));
        submit_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 25));
        this.add(submit_btn);
        if(type.equals("Cairo"))
        {
            FoodType_lbl = new JLabel("Beef");
             FoodType_lbl.setFont(new Font("Times New Roman",1, 33));
            FoodType_lbl.setBounds(20, 20, 200, 100);
            this.add(FoodType_lbl);
           
        }
        else if(type.equals("Alex"))
        {
            FoodType_lbl = new JLabel("Fish");
            FoodType_lbl.setFont(new Font("Times New Roman",1, 33));
            FoodType_lbl.setBounds(20, 20, 200, 100);
            this.add(FoodType_lbl);
        }
        else if(type.equals("Giza"))
        {
            FoodType_lbl = new JLabel("Pizza");
            FoodType_lbl.setFont(new Font("Times New Roman",1, 33));
            FoodType_lbl.setBounds(20, 20, 200, 100);
            this.add(FoodType_lbl);
        }
        back_btn = new JButton("Back");
        back_btn.setBounds(40, 800 , 110, 45);
       back_btn.setBackground(new java.awt.Color(255,255,255));
       back_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 33));
       this.add(back_btn);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(850, Short.MAX_VALUE)
                .addGap(149, 149, 149))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addContainerGap(650, Short.MAX_VALUE))
        );

        pack();
        
        
    }
    private void GetData()
    {
        try
        {
            String Select = "SELECT Name, Price FROM Menu WHERE Rest_Branch = ?";
            pst = conn.prepareStatement(Select);
            pst.setString(1, type);
            rs = pst.executeQuery();
            rs = pst.executeQuery();
            while(rs.next())
            {
                h += 50;
                JLabel name = new JLabel("" + rs.getString("Name"));
                name.setFont(new Font("Tahoma",0, 18));
                name.setBounds(30, h, 200, 100);
                this.add(name);
                JLabel Price = new JLabel("" + rs.getString("Price") + "$");
                Price.setFont(new Font("Tahoma",0, 18));
                Price.setBounds(280, h, 200, 100);
                this.add(Price);
                order_btn = new JButton("Add To Order");
                order_btn.setBounds(340, h + 35 , 140, 32);
                order_btn.setBackground(new java.awt.Color(255,255,255));
                order_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 20));
                this.add(order_btn);
                Actionorder((rs.getString("Name")), rs.getString("Price"));
//                h_fish += 40;
            }
            rs.close();
            pst.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        h += 100;
        soup_lbl.setFont(new Font("Times New Roman",1, 33));
        soup_lbl.setBounds(20, h, 200, 100);
        this.add(soup_lbl);
        try
        {
            String Select = "SELECT Name, Price FROM Menu WHERE Rest_Branch = 'All' AND Section = 'Soup'";
            pst = conn.prepareStatement(Select);
            rs = pst.executeQuery();
            rs = pst.executeQuery();
            while(rs.next())
            {
                h += 50;
                JLabel name = new JLabel("" + rs.getString("Name"));
                name.setFont(new Font("Tahoma",0, 18));
                name.setBounds(30, h, 200, 100);
                this.add(name);
                JLabel Price = new JLabel("" + rs.getString("Price") + "$");
                Price.setFont(new Font("Tahoma",0, 18));
                Price.setBounds(280, h, 200, 100);
                this.add(Price);
                order_btn = new JButton("Add To Order");
                order_btn.setBounds(340, h + 35 , 140, 32);
                order_btn.setBackground(new java.awt.Color(255,255,255));
                order_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 20));
                this.add(order_btn);
                Actionorder((rs.getString("Name")), rs.getString("Price"));
            }
            rs.close();
            pst.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        h += 100;
        drink_lbl.setFont(new Font("Times New Roman",1, 33));
        drink_lbl.setBounds(20, h, 200, 100);
        this.add(drink_lbl);
        try
        {
            String Select = "SELECT Name, Price FROM Menu WHERE Rest_Branch = 'All' AND Section = 'Drinks'";
            pst = conn.prepareStatement(Select);
            rs = pst.executeQuery();
            rs = pst.executeQuery();
            while(rs.next())
            {
                h += 50;
                JLabel name = new JLabel("" + rs.getString("Name"));
                name.setFont(new Font("Tahoma",0, 18));
                name.setBounds(30, h, 200, 100);
                this.add(name);
                JLabel Price = new JLabel("" + rs.getString("Price") + "$");
                Price.setFont(new Font("Tahoma",0, 18));
                Price.setBounds(280, h, 200, 100);
                this.add(Price);
                order_btn = new JButton("Add To Order");
                order_btn.setBounds(340, h + 35 , 140, 32);
                order_btn.setBackground(new java.awt.Color(255,255,255));
                order_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 20));
                this.add(order_btn);
                Actionorder((rs.getString("Name")), rs.getString("Price"));
            }
            rs.close();
            pst.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
//        h += 100;
        extra_lbl.setFont(new Font("Times New Roman",1, 33));
        extra_lbl.setBounds(600, h2, 200, 100);
        this.add(extra_lbl);
        try
        {
            String Select = "SELECT Name, Price FROM Menu WHERE Rest_Branch = 'All' AND Section = 'Extras'";
            pst = conn.prepareStatement(Select);
            rs = pst.executeQuery();
            rs = pst.executeQuery();
            while(rs.next())
            {
                h2 += 50;
                JLabel name = new JLabel("" + rs.getString("Name"));
                name.setFont(new Font("Tahoma",0, 18));
                name.setBounds(620, h2, 200, 100);
                this.add(name);
                JLabel Price = new JLabel("" + rs.getString("Price") + "$");
                Price.setFont(new Font("Tahoma",0, 18));
                Price.setBounds(800, h2, 200, 100);
                this.add(Price);
                order_btn = new JButton("Add To Order");
                order_btn.setBounds(850, h2 + 35 , 140, 32);
                order_btn.setBackground(new java.awt.Color(255,255,255));
                order_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 20));
                this.add(order_btn);
                Actionorder((rs.getString("Name")), rs.getString("Price"));
            }
            rs.close();
            pst.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
     private void ActionBack(){
        back_btn.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent evt) {
                if(type.equals("Cairo"))
                {
                    new CairoRestFrame(customer).setVisible(true);
                    dispose();     
                }
                else if(type.equals("Alex"))
                {
                    new AlexRestFrame(customer).setVisible(true);
                    dispose();     
                }
                else if(type.equals("Giza"))
                {
                    new GizaRestFrame(customer).setVisible(true);
                    dispose();     
                }
            }
        });
   }
     private void Actionorder(String name_of_item, String Price){
        order_btn.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent evt) {
                
                System.out.println(type);
                boolean check = proxy.CheckRes(customer, type);
                if(check)
                {
                    int p = Integer.parseInt(Price);
                    order_build.setTot_item(name_of_item);
                    System.out.println(order_build.getTot_item());
                    order_build.setTot_price(p);
                    cost.setText(String.valueOf(order_build.getTot_price()) + " $");
                    order.setName(order_build.getTot_item());
                    order.setPrice(order_build.getTot_price());
                    ClearAction();
//                    proxy.AddToOrder(order);
                    SubmitAction(order.getName(), order.getPrice());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "You Did'nt Reserv Any Table", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
   }
     private void ClearAction(){
        clear_btn.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent evt) {
                c = 0;
//                order_build = new OrderBuilder();
                  order_build.InitItem();
//                order = new Order();
                cost.setText("");
                 
            }
        });
   }
      private void SubmitAction(String name, int tot_cost){
        submit_btn.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent evt) {
                    
                
                
                if(cost.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "You Should Order First", "Alert", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(c <1)
                {
                    c++;
                    proxy.AddOrder(order, customer);
                }
            }
        });
   }
}
