/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import resturantmanagementsystem.*;
/**
 *
 * @author DELL
 */
public class Casher extends User{
    private int id;
    private String name, email, Work_type;
    private Customer cust;
    public Casher()
    {
        
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
    public void CompleteReservation(String name, int id)
    {
        cust = new Customer(name, "", 0, "", "", "");
        new CompResrv(cust.getUserName(), id).setVisible(true);
    }
}
