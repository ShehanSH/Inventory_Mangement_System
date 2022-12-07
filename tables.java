/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author MSI MODERN
 */
public class tables {

    public static void main(String[] args) {
        try {
            String userTable = "create table user(id int AUTO_INCREMENT primary key, name varchar(100), email varchar(100), mobileNumber varchar(15), address varchar(200), password varchar(100), securityQuestion varchar(200), answer varchar(150), status varchar(20), UNIQUE (email))";
            String adminDetails = "insert into user(name, email, mobileNumber, address, password, securityQuestion, answer, status) values('Admin', 'admin@gmail.com', '1234567890', 'colombo', 'admin', 'What is the our company name ?', 'easy laundry', 'true')";
            String categoryTable = "create table category (id int AUTO_INCREMENT primary key, name varchar(100))";
            String productTable = "create table product(id int AUTO_INCREMENT primary key, name varchar(100), category varchar(200), price varchar(100), quantity varchar(10))";
            DbOperation.setDataOrDelete(userTable, "User Table Created Successfully !");
            DbOperation.setDataOrDelete(adminDetails, "Admin Details Added Successfully !");
            DbOperation.setDataOrDelete(categoryTable, "categoryTable Created Successfully !");
            DbOperation.setDataOrDelete(productTable, "Product Table Created Successfully !");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
