package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.mail.Session;
import resturantmanagementsystem.*;

/**
 *
 * @author DELL
 */
public class ResturantManagementSystem {
static Connection conn = null;
    public static Connection ConnectDB()
    {
        if(conn == null)
        {
            try{
                Class.forName("org.sqlite.JDBC");
                Connection conn = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
                System.out.println("Succes");
                return conn;
            }
            catch(Exception e){
                System.out.println("Failed " + e);
                return null;
            }
        }
        else
        {
            return conn;
        }
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
       new Login().setVisible(true);
//           new ShowMenuAll().setVisible(true);
//new ShowAvailable().setVisible(true);
//            new CairoRestFrame("omar").setVisible(true);
//        new ReserveTable("Cairo").setVisible(true);
           

    }
    
}
