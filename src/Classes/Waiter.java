/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import resturantmanagementsystem.ShowMenuAll;
import resturantmanagementsystem.ShowOneMenu;

/**
 *
 * @author DELL
 */
public class Waiter extends User{
    private int id;
    private String name, email, Work_type;
    private OrderBuilder order_b;
    public Waiter()
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
    public ShowMenuAll AllMenus(String Emaill)
    {
        return new ShowMenuAll(Emaill);
    }
    public ShowOneMenu GetMenu(String Branch, Customer cust)
    {
        order_b = new OrderBuilder();
        return new ShowOneMenu(Branch, cust);
    }
}
