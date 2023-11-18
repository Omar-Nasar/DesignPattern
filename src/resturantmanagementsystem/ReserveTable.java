/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagementsystem;

import Classes.Casher;
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
import static resturantmanagementsystem.CompResrv.ID;
//import static resturantmanagementsystem.ShowAvailable.Name;

/**
 *
 * @author DELL
 */
public class ReserveTable  extends JFrame{
     private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private JButton res_btn, back_btn;
    private JLabel label;
    String Type;
//    static String Name;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    int h = 50, element_id;
    private Customer customer;
    private Casher casher;
    public ReserveTable(String type, Customer cust)
    {
        Type = type;
        customer = cust;
        initComponents();
        setTitle("Resturant Manegment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        conn = ResturantManagementSystem.ConnectDB();
        ShowData();
        ActionBack();
    }
    private void initComponents()
    {
        jScrollPane2 = new javax.swing.JScrollPane();
         jPanel1 = new javax.swing.JPanel();
         back_btn = new JButton("Back");
         back_btn.setBackground(new java.awt.Color(255,255,255));
         back_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 27));
         back_btn.setBounds(30 , 800, 120, 32);
        jPanel1.add(back_btn);
        label = new JLabel(Type + " Tables");
        label.setFont(new java.awt.Font("Tahoma", 1, 28));
        label.setBounds(370 , 20, 250, 32);
        jPanel1.add(label);
     setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(500, Short.MAX_VALUE)
                .addGap(327, 327, 327))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(600, Short.MAX_VALUE)
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
    
    private void ShowData()
    {
        int i = 0;
        try
        {
            String select = "SELECT * FROM Tables WHERE Rest_branch = ? AND Reserved = 'Not'";
            pst = conn.prepareStatement(select);
            pst.setString(1, Type);
            rs = pst.executeQuery();
            while(rs.next())
            {
                i++;
                JLabel TableNum = new JLabel("Table Number: " + i);
                 TableNum.setFont(new Font("Tahoma", 1, 25));
                TableNum.setBounds(20, 0 + h, 220, 100);
                jPanel1.add(TableNum);
                JLabel NumberOfSets = new JLabel("Number Of Sets: "+rs.getString("No_Seats").toString());
                 NumberOfSets.setFont(new Font("Times new Roman", 1, 22));
                NumberOfSets.setBounds(40, 50 + h, 200, 100);
                jPanel1.add(NumberOfSets);
                JLabel Price = new JLabel("Price: "+rs.getString("Price").toString() + "$");
                Price.setFont(new Font("Times new Roman", 1, 22));
                Price.setBounds(250, 50 + h, 200, 100);
                jPanel1.add(Price);
                
                element_id = Integer.parseInt(rs.getString("Table_ID"));
                res_btn = new JButton("Reserve");
                res_btn.setBackground(new java.awt.Color(255,255,255));
                res_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 27));
                res_btn.setBounds(460 , 80 + h, 120, 32);
                jPanel1.add(res_btn);
                ActionRes(element_id);
                h += 140;
            }
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
               new MianMenu(customer).setVisible(true);
                dispose();
            }
        });
   }
     private void ActionRes(int id){
        res_btn.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent evt) {
//                 new CompResrv(customer.getUserName(), id).setVisible(true);
                    casher = new Casher();
                    casher.CompleteReservation(customer.getUserName(), id);
//                dispose();

            }
        });
   }
}
