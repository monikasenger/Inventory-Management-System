/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author shubham
 */
public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
          // st.executeUpdate("CREATE TABLE IF NOT EXISTS Employee (employee_id INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(200) NOT NULL, email VARCHAR(200) UNIQUE NOT NULL, gender varchar(100) NOT NULL, dob DATE NOT NULL,contact_number VARCHAR(15) UNIQUE NOT NULL,  employee_type VARCHAR(100) NOT NULL,education VARCHAR(100), work_shift VARCHAR(50),address VARCHAR(255), date_of_joining DATE NOT NULL,salary DECIMAL(10,2) NOT NULL,user_type VARCHAR(100) NOT NULL,   password VARCHAR(255) NOT NULL)") ;

            //st.executeUpdate("INSERT INTO Employee (name, email, gender, dob,contact_number,  employee_type,education, work_shift,address, date_of_joining,  salary,user_type, password)VALUES ('Monika','monika123@gmail.com', 'Female','2000-12-26','9876543210', 'Full-Time','MCA', 'Morning','faridabad',   '2022-06-01', 75000.00, 'Admin',    'Mona@123');");
           //  st.executeUpdate("create table Supplier(supplier_id int AUTO_INCREMENT primary key,invoice_number varchar(15), supplier_name varchar(200),supplier_contact varchar(15),supplier_description varchar(200))");
           // st.executeUpdate("create table Customer(customer_id int AUTO_INCREMENT primary key, customer_name varchar(200),customer_contact varchar(50), customer_email varchar(200))");
           //  st.executeUpdate("create table Category(category_id int AUTO_INCREMENT primary key, category_name varchar(200),category_description varchar(200))");
           // st.executeUpdate("create table Product(product_id int AUTO_INCREMENT primary key,category_name varchar(200),supplier_name varchar(200), product_name varchar(200), price int,quantity int, product_description varchar(500),status varchar(50))");
           // st.executeUpdate("CREATE TABLE order_items (order_item_id INT AUTO_INCREMENT PRIMARY KEY,order_id INT NOT NULL, product_id INT NOT NULL,quantity INT NOT NULL, price DECIMAL(10,2) NOT NULL, subtotal DECIMAL(10,2) GENERATED ALWAYS AS (quantity * price) STORED, FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,FOREIGN KEY (product_id) REFERENCES product(product_id) ON DELETE CASCADE)");
          //  st.executeUpdate("CREATE TABLE orders ( order_id INT AUTO_INCREMENT PRIMARY KEY, customer_id INT NOT NULL,order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, total_amount DECIMAL(10,2) NOT NULL,net_amount DECIMAL(10,2) NOT NULL, status VARCHAR(50) DEFAULT 'Pending',FOREIGN KEY (customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE)");
              
            st.executeUpdate("CREATE TABLE sales (bill_no INT PRIMARY KEY,customer_name VARCHAR(255) NOT NULL,phone VARCHAR(15) NOT NULL,date DATETIME NOT NULL,total_amount DECIMAL(10,2) NOT NULL,discount DECIMAL(10,2) NOT NULL,net_amount DECIMAL(10,2) NOT NULL,bill_details TEXT NOT NULL );");
             
            //st.executeUpdate("create table sales_items(item_id int auto_increment primary key, bill_id int, product_id int, product_name varchar(255), quantity int not null, price double not null, total_price double not null,foreign key(bill_id) references sales(bill_id) on delete cascade, foreign key(product_id) references product(product_id) on delete set null)");
             //  st.executeUpdate("");
               
              JOptionPane.showMessageDialog(null, "Table Created Successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                st.close();
            } catch (Exception e) {
            }
        }
    }
}
