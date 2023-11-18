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
public class Customer extends User{
    private int CustId;
    private String CustName, Gender, Phone, Password;
    public Customer(String Email, String Password, int id, String name, String gender, String phone)
    {
        this.UserName = Email;
        this.Password = Password;
        this.CustId = id;
        this.CustName = name;
        this.Gender = gender;
        this.Phone = phone;
    }

    public String getPhone() {
        return Phone;
    }

    public String getUserName() {
        return UserName;
    }
    
}
