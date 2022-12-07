/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;
import java.sql.*;

/**
 *
 * @author MSI MODERN
 */
public class ProductDao {
    public static void save(Product product){
        String query = "insert into product (name, category, price, quantity) values ('"+product.getName()+"', '"+product.getCategory()+"', '"+product.getPrice()+"', '"+product.getQuantity()+"')";
        DbOperation.setDataOrDelete(query, "Product Added Successfully !");
    }
    
    public static ArrayList<Product> getAllRecords(){
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperation.getData("Select * from product");
            while (rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                product.setQuantity(rs.getString("quantity"));
                arrayList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList; 
    }
    
    public static void update(Product product){
        String query = "update product set name = '"+product.getName()+"', category = '"+product.getCategory()+"', price = '"+product.getPrice()+"', quantity = '"+product.getQuantity()+"' where id = '"+product.getId()+"'";
        DbOperation.setDataOrDelete(query, "Product Updated Successfully !");
    }
    
    public static void delete(String id){
        String query = "delete from product where id = '"+id+"'";
        DbOperation.setDataOrDelete(query, "Product Deleted Successfully !");
    }
}
