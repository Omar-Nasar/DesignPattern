/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagementsystem;

import Classes.Casher;
import Classes.ResturantManagementSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import static resturantmanagementsystem.ReserveTable.Name;

/**
 *
 * @author DELL
 */
public class CompResrv extends javax.swing.JFrame {

    /**
     * Creates new form CompResrv
     */
    static String Name;
    static  int ID;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null, pst2 = null;
    private Casher casher;
    public CompResrv(String name, int id) {
        Name = name; ID = id;
        initComponents();
        setTitle("Resturant Manegment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        conn = ResturantManagementSystem.ConnectDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        date_txt = new javax.swing.JTextField();
        method_cmp = new javax.swing.JComboBox<>();
        visa_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comp_btn = new javax.swing.JButton();
        cancel_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel1.setText("Complete Your Reservation");

        date_txt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        method_cmp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        method_cmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Visa", "Cash" }));

        visa_txt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Date");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Payment Method");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Cridet Card");

        comp_btn.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        comp_btn.setText("Complete");
        comp_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_btnActionPerformed(evt);
            }
        });

        cancel_btn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cancel_btn.setText("Cancel");
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Must be: dd/mm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(137, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel4)
                                .addGap(57, 57, 57))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(71, 71, 71)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(method_cmp, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(visa_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(186, 186, 186))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cancel_btn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(comp_btn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(63, 63, 63)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(method_cmp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(visa_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(comp_btn)
                .addGap(40, 40, 40)
                .addComponent(cancel_btn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btnActionPerformed
        dispose();
    }//GEN-LAST:event_cancel_btnActionPerformed

    private void comp_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_btnActionPerformed
        Complete();
        

    }//GEN-LAST:event_comp_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompResrv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompResrv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompResrv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompResrv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompResrv(Name, ID).setVisible(true);
            }
        });
    }
    private void Complete()
    {
        if(!date_txt.equals("") && date_txt.getText().contains("/"))
        {
            if(method_cmp.getSelectedItem().toString().equals("Visa"))
            {
                if(visa_txt.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter Your Visa Cart Number", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    Res();
                }
            }
            else if(method_cmp.getSelectedItem().toString().equals("Cash"))
            {
                if(visa_txt.getText().equals(""))
                {
                      Res();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Data", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Enter Fall Data", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void Res()
    {
        try
        {
            System.out.println(ID + " "+ Name);
            String insert = "INSERT INTO Reservation (Date, table_ID, cust_email) VALUES(?,?,?)";
            pst = conn.prepareStatement(insert);
            pst.setString(1, date_txt.getText());
            pst.setInt(2, ID);
            pst.setString(3, Name);
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Resrved", "Alert", JOptionPane.INFORMATION_MESSAGE);
            Mail m = new Mail();
//            m.sms("omarnsar", "Omar123456", "+201146574186", "Your Reservation Has been Done");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        try
        {
            String update = "UPDATE Tables SET Reserved = 'Res' WHERE Table_ID = ?";
            pst2 = conn.prepareStatement(update);
            pst2.setInt(1, ID);
            pst2.execute();
            pst2.close();
            System.out.println("Updated");
            dispose();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_btn;
    private javax.swing.JButton comp_btn;
    private javax.swing.JTextField date_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> method_cmp;
    private javax.swing.JTextField visa_txt;
    // End of variables declaration//GEN-END:variables
}
