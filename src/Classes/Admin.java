/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author DELL
 */
public class Admin extends User{
    private static Admin admin = null;
    private String Password, name;
    private Admin()
    {
        this.UserName = "admin";
        this.Password = "123";
        this.name = "Omar";
    }
    public static Admin GetInstance()
    {
        if(admin == null)
        {
            admin = new Admin();
        }
        return admin;
    }
    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }
    
}
