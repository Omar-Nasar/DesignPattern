/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagementsystem;

import Classes.Customer;
import Classes.ResturantManagementSystem;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.layout.Background;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ShowMenuAll extends JFrame{
//    static String Name;
    private JLabel fish_lbl, beef_lbl, pizza_lbl, drink_lbl, soup_lbl, extra_lbl, salad_lbl;
    private JButton back_btn, delete_btn;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    int h_fish = 10, h2 = 10, h3 = 10, w = 30, w2 = 530, w3 = 1020, c1 = 100, c2 = 600, c3 = 1100;
    int element_id;
    private Customer customer;
    public ShowMenuAll(String name)
    {
        customer = new Customer(name, "", 0, "", "", "");
        init();
        setTitle("Resturant Manegment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        conn = ResturantManagementSystem.ConnectDB();
        GetAllMenus();
        ActionBack();
//        if(name.equals("Admin"))
//        {
//            ActoinDelete(element_id);
//        }
    }
    
    public void GetAllMenus()
    {
//        int h = 50, w =20;
        fish_lbl.setFont(new Font("Times New Roman",1, 33));
        fish_lbl.setBounds(c1, h_fish, 200, 100);
        this.add(fish_lbl);
        
        try
        {
           
            String Select = "SELECT * FROM Menu WHERE Section = 'Fish'";
            pst = conn.prepareStatement(Select);
            rs = pst.executeQuery();
            while(rs.next())
            {
                h_fish += 50;
                JLabel name = new JLabel("" + rs.getString("Name"));
                name.setFont(new Font("Tahoma",0, 19));
                name.setBounds(w, h_fish, 200, 100);
                this.add(name);
                JLabel Price = new JLabel("" + rs.getString("Price") + "$");
                Price.setFont(new Font("Tahoma",0, 19));
                Price.setBounds(w + 250, h_fish, 200, 100);
                this.add(Price);
                if(customer.getUserName().equals("Admin"))
                {
                    element_id = Integer.parseInt(rs.getString("menu_ID"));
                    delete_btn = new JButton("Delete");
                    delete_btn.setBackground(new java.awt.Color(255,255,255));
                    delete_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 20));
                    delete_btn.setBounds(w + 300, h_fish + 40, 140, 32);
                    this.add(delete_btn);
                    ActoinDelete(element_id);
                }
//                h_fish += 40;
            }
             rs.close();
             pst.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        beef_lbl.setFont(new Font("Times New Roman",1, 33));
        h_fish += 80;
        beef_lbl.setBounds(c1, h_fish, 200, 100);
        this.add(beef_lbl);
        try
        {
            String Select = "SELECT * FROM Menu WHERE Section = 'Beef'";
            pst = conn.prepareStatement(Select);
            rs = pst.executeQuery();
            while(rs.next())
            {
                h_fish += 50;
                JLabel name = new JLabel("" + rs.getString("Name"));
                name.setFont(new Font("Tahoma",0, 19));
                name.setBounds(w, h_fish, 200, 100);
                this.add(name);
                JLabel Price = new JLabel("" + rs.getString("Price") + "$");
                Price.setFont(new Font("Tahoma",0, 19));
                Price.setBounds(w + 250, h_fish, 200, 100);
                this.add(Price);
                if(customer.getUserName().equals("Admin"))
                {
                    element_id = Integer.parseInt(rs.getString("menu_ID"));
                    delete_btn = new JButton("Delete");
                    delete_btn.setBackground(new java.awt.Color(255,255,255));
                    delete_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 20));
                    delete_btn.setBounds(w + 300, h_fish + 40, 140, 32);
                    this.add(delete_btn);
                    ActoinDelete(element_id);
                }
            }
             rs.close();
             pst.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        pizza_lbl.setFont(new Font("Times New Roman",1, 33));
        h_fish += 80;
        pizza_lbl.setBounds(c1, h_fish, 200, 100);
        this.add(pizza_lbl);
        try
        {
            String Select = "SELECT * FROM Menu WHERE Section = 'Pizza'";
            pst = conn.prepareStatement(Select);
            rs = pst.executeQuery();
            while(rs.next())
            {
                h_fish += 50;
                JLabel name = new JLabel("" + rs.getString("Name"));
                name.setFont(new Font("Tahoma",0, 19));
                name.setBounds(w, h_fish, 200, 100);
                this.add(name);
                JLabel Price = new JLabel("" + rs.getString("Price") + "$");
                Price.setFont(new Font("Tahoma",0, 19));
                Price.setBounds(w + 250, h_fish, 200, 100);
                this.add(Price);
                if(customer.getUserName().equals("Admin"))
                {
                    element_id = Integer.parseInt(rs.getString("menu_ID"));
                    delete_btn = new JButton("Delete");
                    delete_btn.setBackground(new java.awt.Color(255,255,255));
                    delete_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 20));
                    delete_btn.setBounds(w + 300, h_fish + 40, 140, 32);
                    this.add(delete_btn);
                    ActoinDelete(element_id);
                }
                
            }
             rs.close();
             pst.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        drink_lbl.setFont(new Font("Times New Roman",1, 33));
        drink_lbl.setBounds(c2, h2, 200, 100);
        this.add(drink_lbl);
        try
        {
            String Select = "SELECT * FROM Menu WHERE Section = 'Drinks'";
            pst = conn.prepareStatement(Select);
            rs = pst.executeQuery();
            while(rs.next())
            {
                h2 += 50;
                JLabel name = new JLabel("" + rs.getString("Name"));
                name.setFont(new Font("Tahoma",0, 19));
                name.setBounds(w2, h2, 200, 100);
                this.add(name);
                JLabel Price = new JLabel("" + rs.getString("Price") + "$");
                Price.setFont(new Font("Tahoma",0, 19));
                Price.setBounds(w2 + 250, h2, 200, 100);
                this.add(Price);
                if(customer.getUserName().equals("Admin"))
                {
                    element_id = Integer.parseInt(rs.getString("menu_ID"));
                    delete_btn = new JButton("Delete");
                    delete_btn.setBackground(new java.awt.Color(255,255,255));
                    delete_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 18));
                    delete_btn.setBounds(w2 + 300, h2 + 40, 120, 32);
                    this.add(delete_btn);
                    ActoinDelete(element_id);
                }
                
            }
            rs.close();
            pst.close();
        }
         
        catch(Exception e)
        {
            System.out.println(e);
        }
        soup_lbl.setFont(new Font("Times New Roman",1, 33));
        h2 += 80;
        soup_lbl.setBounds(c2, h2, 200, 100);
        this.add(soup_lbl);
        try
        {
            String Select = "SELECT * FROM Menu WHERE Section = 'Soup'";
            pst = conn.prepareStatement(Select);
            rs = pst.executeQuery();
            while(rs.next())
            {
                h2 += 50;
                JLabel name = new JLabel("" + rs.getString("Name"));
                name.setFont(new Font("Tahoma",0, 19));
                name.setBounds(w2, h2, 200, 100);
                this.add(name);
                JLabel Price = new JLabel("" + rs.getString("Price") + "$");
                Price.setFont(new Font("Tahoma",0, 19));
                Price.setBounds(w2 + 250, h2, 200, 100);
                this.add(Price);
                if(customer.getUserName().equals("Admin"))
                {
                    element_id = Integer.parseInt(rs.getString("menu_ID"));
                    delete_btn = new JButton("Delete");
                    delete_btn.setBackground(new java.awt.Color(255,255,255));
                    delete_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 18));
                    delete_btn.setBounds(w2 + 300, h2 + 40, 120, 32);
                    this.add(delete_btn);
                    ActoinDelete(element_id);
                }
                
            }
            rs.close();
            pst.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        salad_lbl.setFont(new Font("Times New Roman",1, 33));
        h2 += 80;
        salad_lbl.setBounds(c2, h2, 200, 100);
        this.add(salad_lbl);
        try
        {
            String Select = "SELECT * FROM Menu WHERE Section = 'Salad'";
            pst = conn.prepareStatement(Select);
            rs = pst.executeQuery();
            while(rs.next())
            {
                h2 += 50;
                JLabel name = new JLabel("" + rs.getString("Name"));
                 name.setFont(new Font("Tahoma",0, 19));
                name.setBounds(w2, h2, 200, 100);
                this.add(name);
                JLabel Price = new JLabel("" + rs.getString("Price") + "$");
                Price.setFont(new Font("Tahoma",0, 19));
                Price.setBounds(w2 + 250, h2, 200, 100);
                this.add(Price);
                if(customer.getUserName().equals("Admin"))
                {
                    element_id = Integer.parseInt(rs.getString("menu_ID"));
                    delete_btn = new JButton("Delete");
                    delete_btn.setBackground(new java.awt.Color(255,255,255));
                    delete_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 20));
                    delete_btn.setBounds(w2 + 300, h2 + 40, 140, 32);
                    this.add(delete_btn);
                    ActoinDelete(element_id);
                }
                
            }
            rs.close();
            pst.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        extra_lbl.setFont(new Font("Times New Roman",1, 33));
        extra_lbl.setBounds(c3, h3, 200, 100);
        this.add(extra_lbl);
        try
        {
            String Select = "SELECT * FROM Menu WHERE Section = 'Extras'";
            pst = conn.prepareStatement(Select);
            rs = pst.executeQuery();
            while(rs.next())
            {
                h3 += 50;
                JLabel name = new JLabel("" + rs.getString("Name"));
                name.setFont(new Font("Tahoma",0, 19));
                name.setBounds(w3, h3, 200, 100);
                this.add(name);
                JLabel Price = new JLabel("" + rs.getString("Price") + "$");
                Price.setFont(new Font("Tahoma",0, 19));
                Price.setBounds(w3 + 250, h3, 200, 100);
                this.add(Price);
                if(customer.getUserName().equals("Admin"))
                {
                    element_id = Integer.parseInt(rs.getString("menu_ID"));
                    delete_btn = new JButton("Delete");
                    delete_btn.setBackground(new java.awt.Color(255,255,255));
                    delete_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 20));
                    delete_btn.setBounds(w3 + 300, h3 + 40, 140, 32);
                    this.add(delete_btn);
                    ActoinDelete(element_id);
                }
                
            }
            rs.close();
            pst.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
    }
    
    private void init()
    {
       
        fish_lbl = new JLabel("Fish  (Alex)");
        beef_lbl = new JLabel("Beef  (Cairo)");
        pizza_lbl = new JLabel("Pizza  (Giza)");
        drink_lbl = new JLabel("Drink");
        soup_lbl = new JLabel("Soup");
        extra_lbl = new JLabel("Extras");
        salad_lbl = new JLabel("Salad");
        back_btn = new JButton("Back");
        back_btn.setBounds(650, 800 , 110, 45);
       back_btn.setBackground(new java.awt.Color(255,255,255));
       back_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 33));
       this.add(back_btn);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1300, Short.MAX_VALUE)
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
    
    private void ActionBack(){
        back_btn.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent evt) {
                if(customer.getUserName().equals("Admin"))
                {
                    new AdminMenu().setVisible(true);
                    dispose();
                }
                else
                {
                    new MianMenu(customer).setVisible(true);
                    dispose();    
                }
                
                
            }
        });
   }
    private void ActoinDelete(int id){
            delete_btn.addActionListener(new ActionListener() {
               @Override
                public void actionPerformed(ActionEvent evt) {
                    System.out.println(id);
                    try
                    {
                        String view = "DELETE FROM Menu WHERE menu_ID = ?";
                        pst = conn.prepareStatement(view);
//                        System.out.println("1");
                        pst.setInt(1, id);
//                        System.out.println("2");
                        pst.execute();
                        pst.close();
                        JOptionPane.showMessageDialog(null, "Item Deleted", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }
            });
       }
}
