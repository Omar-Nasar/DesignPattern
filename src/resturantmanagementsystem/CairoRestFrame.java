/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagementsystem;

import Classes.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author DELL
 */
public class CairoRestFrame extends javax.swing.JFrame implements Resturant{

//    static String name;
    
    private Customer customer;
    private Reseptionest resp;
    private Waiter waiter;
    public CairoRestFrame(Customer cust) {
        initComponents();
        this.customer = (Customer)cust;
        resp = new Reseptionest();
        waiter = new Waiter();
        setTitle("Resturant Manegment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        Reserv();
        Menu();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        reserv_btn = new javax.swing.JButton();
        menu_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        jLabel1.setText("Cairo Resturant");

        reserv_btn.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        reserv_btn.setText("Make Reservation");
        reserv_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserv_btnActionPerformed(evt);
            }
        });

        menu_btn.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        menu_btn.setText("Menu");

        back_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(244, 244, 244))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(menu_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reserv_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addGap(271, 271, 271))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(110, 110, 110)
                .addComponent(reserv_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(menu_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(back_btn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        new MianMenu(customer).setVisible(true);
        dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void reserv_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserv_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reserv_btnActionPerformed

@Override
public void Menu(){
    menu_btn.addActionListener(new ActionListener() {
       @Override
        public void actionPerformed(ActionEvent evt) {
            waiter.GetMenu("Cairo", customer).setVisible(true);
            dispose();    
        }
    });
}

public void Reserv(){
        reserv_btn.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent evt) {
                    resp.Reserv("Cairo", customer).setVisible(true);
                    dispose();    
            }
        });
   }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton menu_btn;
    private javax.swing.JButton reserv_btn;
    // End of variables declaration//GEN-END:variables

    
   
}
