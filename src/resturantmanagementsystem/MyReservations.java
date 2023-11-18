/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagementsystem;

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
public class MyReservations extends JFrame{
    
    private JButton delete_btn, back_btn;
    private JLabel table_num, num_of_seat, price, date, My_res;
    
    static String Email; 
    Connection conn = null;
    ResultSet rs1 = null, rs2 = null, rs3 = null;
    PreparedStatement pst = null, pst_d = null;
    int h1 = 50, w1 = 170, element_id;
    String phon_num;
    public MyReservations(String email)
    {
        initComp();
        Email = email;
        setTitle("Resturant Manegment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        conn = ResturantManagementSystem.ConnectDB();
        GetMyRes();
        ActionBack();
    }
    private void initComp()
    {
        My_res = new JLabel("My Reservations");
        back_btn = new JButton("Close");
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
    private void GetMyRes()
    {
        My_res.setFont(new Font("Tahoma",1, 25));
        My_res.setBounds(300, 0, 300, 100);
        this.add(My_res);
        try
        {
            int i = 0;
            String select1 = "SELECT * FROM Reservation WHERE cust_email = ?";
            pst = conn.prepareStatement(select1);
            pst.setString(1, Email);
            rs1 = pst.executeQuery();
            System.out.println("hii");
//            String select3 = "SELECT phone FROM Customer WHERE email = ?";
//            pst = conn.prepareStatement(select3);
//            pst.setString(1, Email);
//            rs3 = pst.executeQuery();
//            phon_num = rs3.getString("phone");
//            rs3.close();
            while(rs1.next())
            {
                System.out.println("hii");
                String select2 = "SELECT * FROM Tables WHERE Table_ID = ?";
                pst = conn.prepareStatement(select2);
                pst.setInt(1, Integer.parseInt(rs1.getString("table_ID").toString()));
                rs2 = pst.executeQuery();
                if(rs2.next())
                {
                   i++;
                JLabel TableNum = new JLabel("Table Number: " + i);
                JLabel NumberOfSets = new JLabel("Number Of Sets: "+rs2.getString("No_Seats").toString());
                JLabel Price = new JLabel("Price: "+rs2.getString("Price").toString() + "$");
                JLabel Branch = new JLabel("Branch: "+rs2.getString("Rest_branch").toString());
                TableNum.setFont(new Font("Tahoma", 1, 18));
                TableNum.setBounds(50, 0 + h1, 200, 100);
                this.add(TableNum);
               
                NumberOfSets.setFont(new Font("Times new Roman", 1, 18));
                NumberOfSets.setBounds(80, 50 + h1, 200, 100);
                this.add(NumberOfSets);
                Price.setFont(new Font("Times new Roman", 1, 18));
                Price.setBounds(100 + w1, 50 + h1, 200, 100);
                this.add(Price);
                Branch.setFont(new Font("Times new Roman", 1, 18));
                Branch.setBounds(300 + w1, 50 + h1, 200, 100);
                this.add(Branch);
                
                element_id = Integer.parseInt(rs2.getString("Table_ID"));
                delete_btn = new JButton("Delete");
                delete_btn.setBackground(new java.awt.Color(255,255,255));
                delete_btn.setFont(new java.awt.Font("Microsoft Uighur", 1, 20));
                delete_btn.setBounds(460 +w1 , 80 + h1, 120, 32);
                this.add(delete_btn);
                ActoinDelete(element_id, phon_num);
                h1 += 120;
                }
            }
            
            rs1.close();
            rs2.close();
//            rs3.close();
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
                
//                    new MianMenu(Name).setVisible(true);
                    dispose();    
            }
        });
   }
     private void ActoinDelete(int id, String phone){
        delete_btn.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println(phone);
                try
                {
                    String view = "DELETE FROM Reservation WHERE table_ID = ?";
                    pst_d = conn.prepareStatement(view);
                    pst_d.setInt(1, id);
                    pst_d.execute();
                    JOptionPane.showMessageDialog(null, "Table Deleted", "Alert", JOptionPane.INFORMATION_MESSAGE);
//                    pst_d.close();
//                    Mail m = new Mail();
                    
//                    m.sms("omarnsar", "Omar123456", "+201146574186", "Your Reservation Has been Canciled");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                try
                {
                   String update = "UPDATE Tables SET Reserved = 'Not' WHERE Table_ID = ?";
                        pst_d = conn.prepareStatement(update);
                        pst_d.setInt(1, id);
                        pst_d.execute();
//                        pst_d.close();
                        System.out.println("Updated");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        });
   }
}
