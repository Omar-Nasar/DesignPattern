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
import resturantmanagementsystem.*;
/**
 *
 * @author DELL
 */
public class Reseptionest extends User{
    private int id;
    private String name, email, Work_type;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public Reseptionest()
    {
     conn = ResturantManagementSystem.ConnectDB();   
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWork_type() {
        return Work_type;
    }

    public void setWork_type(String Work_type) {
        this.Work_type = Work_type;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    
    public ReserveTable Reserv(String TypeOfBranch, Customer cust)
    {  
        if(TypeOfBranch.equals("Cairo"))
        {
           return new ReserveTable("Cairo", cust);
        }
        else if(TypeOfBranch.equals("Alex"))
        {
            return new ReserveTable("Alex", cust);
        }
        else
        {
            return new ReserveTable("Giza", cust);
        }
    }
    public void AddNewTable(int num_of_sets, String res, int price, String branch)
    {
        try
            {
                String view = "INSERT INTO Tables (No_Seats, Reserved, Price, Rest_Branch) VALUES (?,?,?,?)";
                pst = conn.prepareStatement(view);
                pst.setInt(1, num_of_sets);
                pst.setString(2, "Not");
                pst.setInt(3, price);
                pst.setString(4, branch);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Tables Added", "Alert", JOptionPane.INFORMATION_MESSAGE);
                pst.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
    }
    public void SerchWithDate(String name, String Date)
    {
        new Search(name, Date).setVisible(true);
    }
}
