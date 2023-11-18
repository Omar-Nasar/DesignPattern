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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;  
//import static resturantmanagementsystem.ShowMenuAll.Name;

/**
 *
 * @author DELL
 */
public class Search extends JFrame{
//    static String Name;
    private javax.swing.JButton back_btn, delete_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    JLabel TableNum, NumberOfSets;
    private JLabel avail_lbl;
    private JSeparator sep;
    Connection conn = null;
    ResultSet rs = null, rs2 = null;
    PreparedStatement pst = null, pst2 = null ;
    int h1 = 120, w1 = 250, h2 = 0;
    int element_id;
    private Customer cust;
    String Date;
     public Search(String name, String date) {
         this.Date = date;
         cust = new Customer(name, "", 0, "", "", "");
//         this.Name = name;
        initComponents();
        setTitle("Resturant Manegment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        conn = ResturantManagementSystem.ConnectDB();
        Show();
        ActionBack();
    }
    private void Show()
    {
        avail_lbl.setFont(new Font("Tahoma",1, 25));
        avail_lbl.setBounds(300, 0, 300, 100);
        jPanel1.add(avail_lbl);
         sep.setBounds(40, 100 , 750, 100);
         jPanel1.add(sep);
         
        int i = 0;
        try
        {
            String Select = "SELECT * FROM Tables WHERE Reserved = 'Not'";
//            String select = "SELECT t.* FROM Tables t , Reservation r WHERE t.Table_ID=r.table_ID AND r.Date = ?";
            pst = conn.prepareStatement(Select);
//            pst.setString(1, Date);
            rs = pst.executeQuery();
            while(rs.next())
            {
                i++;
                TableNum = new JLabel("Table Number: " + i);
                JLabel NumberOfSets = new JLabel("Number Of Sets: "+rs.getString("No_Seats").toString());
                JLabel Price = new JLabel("Price: "+rs.getString("Price").toString() + "$");
                JLabel Branch = new JLabel("Branch: "+rs.getString("Rest_branch").toString());
                TableNum.setFont(new Font("Tahoma", 1, 18));
                TableNum.setBounds(50, 0 + h1, 200, 100);
                jPanel1.add(TableNum);
               
                NumberOfSets.setFont(new Font("Times new Roman", 1, 18));
                NumberOfSets.setBounds(80, 50 + h1, 200, 100);
                jPanel1.add(NumberOfSets);
                Price.setFont(new Font("Times new Roman", 1, 18));
                Price.setBounds(80 + w1, 50 + h1, 200, 100);
                jPanel1.add(Price);
                jPanel1.add(sep);
                Branch.setFont(new Font("Times new Roman", 1, 18));
                Branch.setBounds(320 + w1, 50 + h1, 200, 100);
                jPanel1.add(Branch);
                jPanel1.add(sep);
                 
//                 if(cust.getUserName().equals("Admin"))
//                 {
//                    element_id = Integer.parseInt(rs.getString("Table_ID"));
//                    delete_btn = new JButton("Delete");
//                    delete_btn.setBackground(new java.awt.Color(255,255,255));
//                    delete_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 20));
//                    delete_btn.setBounds(460 +w1 , 80 + h1, 120, 32);
//                    jPanel1.add(delete_btn);
//                    ActoinDelete(element_id);
//                 }
                 h1 += 150;
                 
            }
             rs.close();
             pst.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        try
        {
            
            h2 = h1;
            System.out.println(h1);
            String select = "SELECT t.* FROM Tables t , Reservation r WHERE t.Table_ID=r.table_ID AND r.Date <> ?";
            pst2 = conn.prepareStatement(select);
//            System.out.println("1");
            pst2.setString(1, Date);
//            System.out.println("2");
            rs2 = pst2.executeQuery();
//            System.out.println("3");
            while(rs2.next())
            {
//                System.out.println("4");
                i++;
                TableNum = new JLabel("Table Number: " + i);
                JLabel NumberOfSets = new JLabel("Number Of Sets: "+rs2.getString("No_Seats").toString());
                JLabel Price = new JLabel("Price: "+rs2.getString("Price").toString() + "$");
                JLabel Branch = new JLabel("Branch: "+rs2.getString("Rest_branch").toString());
                TableNum.setFont(new Font("Tahoma", 1, 18));
                TableNum.setBounds(50, 0 + h2, 200, 100);
                jPanel1.add(TableNum);
               
                NumberOfSets.setFont(new Font("Times new Roman", 1, 18));
                NumberOfSets.setBounds(80, 50 + h2, 200, 100);
                jPanel1.add(NumberOfSets);
                Price.setFont(new Font("Times new Roman", 1, 18));
                Price.setBounds(80 + w1, 50 + h2, 200, 100);
                jPanel1.add(Price);
                jPanel1.add(sep);
                Branch.setFont(new Font("Times new Roman", 1, 18));
                Branch.setBounds(320 + w1, 50 + h2, 200, 100);
                jPanel1.add(Branch);
                jPanel1.add(sep);
                 h2 += 150;
            }
            rs2.close();
            pst2.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
     
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        sep = new JSeparator();
        avail_lbl = new JLabel("Available Tables");
        jPanel1 = new javax.swing.JPanel();
        back_btn = new JButton("Back");
         back_btn.setBounds(20, 40 , 100, 40);
       back_btn.setBackground(new java.awt.Color(255,255,255));
       back_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 30));
       jPanel1.add(back_btn);
//        jPanel2 = new javax.swing.JPanel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(600, Short.MAX_VALUE)
                .addGap(327, 327, 327))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(1800, Short.MAX_VALUE)
                .addGap(279, 279, 279))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        pack();
    }
    
    private void ActionBack(){
        back_btn.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent evt) {
                if(cust.getUserName().equals("Admin"))
                {
                    new AdminMenu().setVisible(true);
                    dispose();
                }
                else
                {
                    new MianMenu(cust).setVisible(true);
                    dispose();    
                }
                
            }
        });
   }
    private void ActoinDelete(int id){
            delete_btn.addActionListener(new ActionListener() {
               @Override
                public void actionPerformed(ActionEvent evt) {
                    try
                    {
                        String view = "DELETE FROM Tables WHERE Table_ID = ?";
                        pst = conn.prepareStatement(view);
                        pst.setInt(1, id);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Table Deleted", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        rs.close();
                        pst.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
//                    delete_btn.setVisible(false);
                    
                }
            });
       }
}
