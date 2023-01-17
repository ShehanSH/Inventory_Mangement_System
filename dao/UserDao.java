/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author MSI MODERN
 */
public class UserDao {

    public static void save(User user) {
        String query = "insert into user(name, email, mobileNumber, address, password, securityQuestion, answer, status) values ('" + user.getName() + "','" + user.getEmail() + "','" + user.getMobileNumber() + "','" + user.getAddress() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "', '" + user.getAnswer() + "', 'false')";
        DbOperation.setDataOrDelete(query, "Registered Successfully! Wait for Admin Approvel!");
    }

    public static User login(String email, String password) {
        User user = null;
        try {
            ResultSet rs = DbOperation.getData("Select * from user where email = '" + email + "' and password = '" + password + "'");
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return user;
    }

    public static User getSecurityQuestion(String email) {
        User user = null;
        try {
            ResultSet rs = DbOperation.getData("select * from user where email = '" + email + "'");
            while (rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static void update(String email, String newPassword) {
        String query = "update user set password = '" + newPassword + "' where email = '" + email + "'";
        DbOperation.setDataOrDelete(query, "Password change Successfully");
    }
    
    public static ArrayList<User> getAllRecords(String email){
        ArrayList<User> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperation.getData("select * from user where email like '%"+email+"%'");
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                
                arrayList.add(user);
                        
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
        
    }
    
    public static void changeStatus(String email, String status){
        String query = "Update user set status = '"+status+"' where email = '"+email+"'";
        DbOperation.setDataOrDelete(query, "Status Change Successfully !");
    }
}
