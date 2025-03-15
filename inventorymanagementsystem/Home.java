/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventorymanagementsystem;

import dao.ConnectionProvider;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author shubham
 */
public class Home extends javax.swing.JFrame {

    private String userName;
    private int EmployeeID = 0;
    private int SupplierID = 0;
    private int CustomerID = 0;
    private int CategoryID = 0;
    private int ProductID = 0;
    private int totalQuantity = 0;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        setLocationRelativeTo(null);
        
    }

    public Home(String userName) {
        initComponents(); // NetBeans auto-generated UI initialization

        // Set Welcome Message
        lblWelcomeName.setText("Welcome, " + userName + "");

        // Show current date & time
        showDate();
        showTime();
        loadDashboardCounts();
    }

    // Display the current date
    private void showDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String currentDate = sdf.format(new Date());
        lblDate.setText("Date: " + currentDate);
    }

    // Display the current time and update it every second
    private void showTime() {
        Timer timer = new Timer(1000, e -> {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String currentTime = sdf.format(new Date());
            lblTime.setText("Time: " + currentTime);
        });
        timer.start();
    }

    public void loadDashboardCounts() {
    try {
        Connection con = ConnectionProvider.getCon();

        // Queries to get the count of each entity
        String queryEmployee = "SELECT COUNT(*) FROM employee";
        String querySupplier = "SELECT COUNT(*) FROM supplier";
        String querySales = "SELECT COUNT(*) FROM sales";
        String queryProduct = "SELECT COUNT(*) FROM product";
        String queryCustomer = "SELECT COUNT(*) FROM customer";
        String queryCategory = "SELECT COUNT(*) FROM category";

        // Method to execute query and return count
        int employeeCount = getCountFromDB(con, queryEmployee);
        int supplierCount = getCountFromDB(con, querySupplier);
        int salesCount = getCountFromDB(con, querySales);
        int productCount = getCountFromDB(con, queryProduct);
        int customerCount = getCountFromDB(con, queryCustomer);
        int categoryCount = getCountFromDB(con, queryCategory);

        // Set values to text fields
        lblTotalEmployee.setText(String.valueOf(employeeCount));
        lblTotalSupplier.setText(String.valueOf(supplierCount));
       lblTotalSale.setText(String.valueOf(salesCount));
        lblTotalProduct.setText(String.valueOf(productCount));
       lblTotalCustomer.setText(String.valueOf(customerCount));
       lblTotalCategory.setText(String.valueOf(categoryCount));

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error fetching dashboard counts: " + e.getMessage());
    }
}

// Method to execute a query and return the count
private int getCountFromDB(Connection con, String query) throws SQLException {
    PreparedStatement pst = con.prepareStatement(query);
    ResultSet rs = pst.executeQuery();
    if (rs.next()) {
        return rs.getInt(1);
    }
    return 0;
}

    private boolean validateEmployeeFields(String formType) {
        if (formType.equals("edit") && !txtEmployeeName.getText().equals("") && !txtEmployeeEmail.getText().equals("") && !txtEmployeeContact.getText().equals("") && !txtEmployeeAddress.getText().equals("") && !txtEmployeeSalary.getText().equals("") && !DateDOB.getDate().equals("") && !DateJoining.getDate().equals("")) {
            return false;
        } else if (formType.equals("new") && !txtEmployeeName.getText().equals("") && !txtEmployeeEmail.getText().equals("") && !comboBoxGender.getSelectedItem().equals("") && !txtEmployeeContact.getText().equals("") && !comboBoxEmployeeType.getSelectedItem().equals("") && !comboBoxEducation.getSelectedItem().equals("") && !comboBoxWorkShift.getSelectedItem().equals("") && !txtEmployeeAddress.getText().equals("") && !txtEmployeeSalary.getText().equals("") && !txtEmployeePassword.getText().equals("") && !DateDOB.getDate().equals("") && !DateJoining.getDate().equals("") && !comboBoxUserType.getSelectedItem().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validateSupplierFields() {
        if (!txtInvoiceNumber.getText().equals("") && !txtSupplierName.getText().equals("") && !txtSupplierContact.getText().equals("") && !txtSupplierDescription.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validateCustomerFields() {
        if (!txtCustomerName.getText().equals("") && !txtCustomerContact.getText().equals("") && !txtCustomerEmail.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validateCategoryFields() {
        if (!txtCategoryName.getText().equals("") && !txtCategoryDescription.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validateProductFields(String formType) {
        if (formType.equals("edit") && !txtProductName.getText().equals("") && !txtProductPrice.getText().equals("") && !txtProductQuantity.getText().equals("") && !txtProductDescription.getText().equals("")) {
            return false;
        } else if (formType.equals("new") && !txtProductName.getText().equals("") && !txtProductPrice.getText().equals("") && !txtProductQuantity.getText().equals("") && !txtProductDescription.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        lblWelcomeName = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnSales = new javax.swing.JButton();
        btnProduct = new javax.swing.JButton();
        btnCategory = new javax.swing.JButton();
        btnCustomer = new javax.swing.JButton();
        btnSuplier = new javax.swing.JButton();
        btnEmployee = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        TabbedPane = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTotalEmployee = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblTotalSupplier = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblTotalCustomer = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblTotalCategory = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblTotalProduct = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblTotalSale = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        lableEmploye = new javax.swing.JLabel();
        lblBackE = new javax.swing.JLabel();
        comboBoxSelectEmployee = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmployee = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearchEmployee = new javax.swing.JButton();
        btnShowAllEmployee = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtEmployeeName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtEmployeeEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtEmployeeContact = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtEmployeeSalary = new javax.swing.JTextField();
        comboBoxGender = new javax.swing.JComboBox<>();
        DateDOB = new com.toedter.calendar.JDateChooser();
        comboBoxEducation = new javax.swing.JComboBox<>();
        comboBoxEmployeeType = new javax.swing.JComboBox<>();
        comboBoxWorkShift = new javax.swing.JComboBox<>();
        DateJoining = new com.toedter.calendar.JDateChooser();
        comboBoxUserType = new javax.swing.JComboBox<>();
        txtEmployeePassword = new javax.swing.JPasswordField();
        btnSaveEmployee = new javax.swing.JButton();
        btnUpdateEmployee = new javax.swing.JButton();
        btnDeleteEmployee = new javax.swing.JButton();
        btnClearEmployee = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEmployeeAddress = new javax.swing.JTextArea();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        lableEmploye1 = new javax.swing.JLabel();
        lblBacks = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSupplier = new javax.swing.JTable();
        txtSearchInvoiceNo = new javax.swing.JTextField();
        btnSearchSupplier = new javax.swing.JButton();
        btnShowAllSupplier = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        txtInvoiceNumber = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtSupplierContact = new javax.swing.JTextField();
        btnSaveSupplier = new javax.swing.JButton();
        btnUpdateSupplier = new javax.swing.JButton();
        btnDeleteSupplier = new javax.swing.JButton();
        btnClearSupplier = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtSupplierDescription = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtSupplierName = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        lableEmploye2 = new javax.swing.JLabel();
        lblBackC = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        txtSearchCustomer = new javax.swing.JTextField();
        btnSearchCustomer = new javax.swing.JButton();
        btnShowAllCustomer = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtCustomerContact = new javax.swing.JTextField();
        btnSaveCustomer = new javax.swing.JButton();
        btnUpdateCustomer = new javax.swing.JButton();
        btnDeleteCustomer = new javax.swing.JButton();
        btnClearCustomer = new javax.swing.JButton();
        txtCustomerEmail = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        lblCount = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        lblAmount = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        lblLastDate = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        comboBoxSelectCustomer = new javax.swing.JComboBox<>();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        lableEmploye3 = new javax.swing.JLabel();
        lblBackpc = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableCategory = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        txtCategoryName = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        btnSaveCategory = new javax.swing.JButton();
        btnUpdateCategory = new javax.swing.JButton();
        btnDeleteCategory = new javax.swing.JButton();
        btnClearCategory = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtCategoryDescription = new javax.swing.JTextArea();
        jLabel49 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        lableEmploye4 = new javax.swing.JLabel();
        lblBackp = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        txtSearchProduct = new javax.swing.JTextField();
        btnSearchProduct = new javax.swing.JButton();
        btnShowAllProduct = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        btnSaveProduct = new javax.swing.JButton();
        btnUpdateProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        btnClearProduct = new javax.swing.JButton();
        txtProductQuantity = new javax.swing.JTextField();
        comboBoxSelectProduct = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        comboBoxProductCategory = new javax.swing.JComboBox<>();
        comboBoxProductSupplier = new javax.swing.JComboBox<>();
        comboBoxProductStatus = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtProductDescription = new javax.swing.JTextArea();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        lableEmploye5 = new javax.swing.JLabel();
        lblBackb = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableCustomerBill = new javax.swing.JTable();
        txtSearchBill = new javax.swing.JTextField();
        btnSearchBill = new javax.swing.JButton();
        btnShowAllBill = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableOrderBill = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtCustomerBillArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inventory Management System");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/h1.jpg"))); // NOI18N

        btnLogout.setBackground(new java.awt.Color(255, 51, 0));
        btnLogout.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnLogout))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblWelcomeName.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblWelcomeName.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcomeName.setText("Welcome");

        lblDate.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("Date");

        lblTime.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setText("Time");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(lblWelcomeName, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcomeName)
                    .addComponent(lblDate)
                    .addComponent(lblTime))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1263, -1));

        jPanel4.setBackground(new java.awt.Color(0, 204, 153));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back10.jpeg"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(0, 204, 153));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Menu");

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        btnSales.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        btnSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sales.png"))); // NOI18N
        btnSales.setText("  Sales");
        btnSales.setBorder(null);
        btnSales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSales.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSales.setIconTextGap(5);
        btnSales.setMargin(new java.awt.Insets(200, 140, 1030, 104));
        btnSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesActionPerformed(evt);
            }
        });

        btnProduct.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        btnProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/product.png"))); // NOI18N
        btnProduct.setText("   Product");
        btnProduct.setBorder(null);
        btnProduct.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProduct.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnProduct.setIconTextGap(5);
        btnProduct.setMargin(new java.awt.Insets(200, 140, 1030, 104));
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });

        btnCategory.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        btnCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/category.png"))); // NOI18N
        btnCategory.setText("  Category");
        btnCategory.setBorder(null);
        btnCategory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCategory.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCategory.setIconTextGap(5);
        btnCategory.setMargin(new java.awt.Insets(200, 140, 1030, 104));
        btnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryActionPerformed(evt);
            }
        });

        btnCustomer.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        btnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/customers.png"))); // NOI18N
        btnCustomer.setText("  Customer");
        btnCustomer.setBorder(null);
        btnCustomer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCustomer.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCustomer.setIconTextGap(5);
        btnCustomer.setMargin(new java.awt.Insets(200, 140, 1030, 104));
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });

        btnSuplier.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        btnSuplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/supplier.png"))); // NOI18N
        btnSuplier.setText("   Supplier");
        btnSuplier.setBorder(null);
        btnSuplier.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSuplier.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSuplier.setIconTextGap(5);
        btnSuplier.setMargin(new java.awt.Insets(200, 140, 1030, 104));
        btnSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuplierActionPerformed(evt);
            }
        });

        btnEmployee.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        btnEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Users.png"))); // NOI18N
        btnEmployee.setText("  Employee");
        btnEmployee.setAlignmentX(0.5F);
        btnEmployee.setBorder(null);
        btnEmployee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEmployee.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEmployee.setIconTextGap(5);
        btnEmployee.setMargin(new java.awt.Insets(200, 140, 1030, 104));
        btnEmployee.setPreferredSize(new java.awt.Dimension(65, 37));
        btnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Exit.png"))); // NOI18N
        btnExit.setText("   Exit");
        btnExit.setBorder(null);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnExit.setIconTextGap(5);
        btnExit.setMargin(new java.awt.Insets(200, 140, 1030, 104));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSuplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSales, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 117, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 102, 0));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("InvenManSys");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(660, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(511, 511, 511))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel14))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 750, 1263, -1));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total Employee");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblTotalEmployee.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lblTotalEmployee.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalEmployee.setText("X");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/total employee.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTotalEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(97, 97, 97))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalEmployee)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(153, 0, 153));
        jPanel8.setPreferredSize(new java.awt.Dimension(205, 158));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Total Supplier");

        lblTotalSupplier.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lblTotalSupplier.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalSupplier.setText("X");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/total supplier.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalSupplier)
                .addGap(32, 32, 32))
        );

        jPanel10.setBackground(new java.awt.Color(255, 0, 204));
        jPanel10.setPreferredSize(new java.awt.Dimension(205, 158));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Total Customer");

        lblTotalCustomer.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lblTotalCustomer.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalCustomer.setText("X");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/total customer.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotalCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalCustomer)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(51, 204, 0));
        jPanel9.setPreferredSize(new java.awt.Dimension(205, 158));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Total Category");

        lblTotalCategory.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lblTotalCategory.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalCategory.setText("X");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/total category.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotalCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(109, 109, 109))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalCategory)
                .addGap(55, 55, 55))
        );

        jPanel12.setBackground(new java.awt.Color(0, 102, 153));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Total Product");

        lblTotalProduct.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lblTotalProduct.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalProduct.setText("X");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/total product.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotalProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel22)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalProduct)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 0, 0));
        jPanel11.setPreferredSize(new java.awt.Dimension(205, 158));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Total Sales");

        lblTotalSale.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lblTotalSale.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalSale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalSale.setText("X");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/total sale.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(lblTotalSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(107, 107, 107))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalSale)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, 138))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );

        TabbedPane.addTab("tab1", jPanel13);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(1018, 557));

        jPanel16.setBackground(new java.awt.Color(255, 51, 0));

        lableEmploye.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lableEmploye.setForeground(new java.awt.Color(255, 255, 255));
        lableEmploye.setText("MANAGE EMPLOYEE");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lableEmploye)
                .addGap(387, 387, 387))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lableEmploye, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        lblBackE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow.jpg"))); // NOI18N
        lblBackE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackEMouseClicked(evt);
            }
        });

        comboBoxSelectEmployee.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        comboBoxSelectEmployee.setForeground(new java.awt.Color(255, 0, 0));
        comboBoxSelectEmployee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search Employee By", "empID", "Name", "Gender", "Employee Type", "User Type", "Work Shift" }));

        tableEmployee.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tableEmployee.setForeground(new java.awt.Color(255, 51, 0));
        tableEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EmpID", "Name", "Email", "Gender", "Date of Birth", "Contact Number", "Employee Type", "Education", "Work Shift", "Address", "Date of Joining", "Salary", "User Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEmployee.setSelectionBackground(new java.awt.Color(255, 51, 0));
        tableEmployee.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEmployee);

        txtSearch.setToolTipText("");

        btnSearchEmployee.setBackground(new java.awt.Color(255, 51, 0));
        btnSearchEmployee.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSearchEmployee.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchEmployee.setText("Search");
        btnSearchEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEmployeeActionPerformed(evt);
            }
        });

        btnShowAllEmployee.setBackground(new java.awt.Color(255, 51, 0));
        btnShowAllEmployee.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnShowAllEmployee.setForeground(new java.awt.Color(255, 255, 255));
        btnShowAllEmployee.setText("Show All");
        btnShowAllEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllEmployeeActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 0));
        jLabel13.setText("NAME");

        txtEmployeeName.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtEmployeeName.setForeground(new java.awt.Color(255, 51, 0));
        txtEmployeeName.setToolTipText("");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 0));
        jLabel15.setText("DATE OF BIRTH");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 0));
        jLabel16.setText("EDUCATION");

        txtEmployeeEmail.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtEmployeeEmail.setForeground(new java.awt.Color(255, 51, 0));
        txtEmployeeEmail.setToolTipText("");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 0));
        jLabel17.setText("WORK SHIFT");

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 0));
        jLabel18.setText("CONTACT NUMBER");

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 51, 0));
        jLabel25.setText("EMAIL");

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 51, 0));
        jLabel26.setText("ADDRESS");

        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 51, 0));
        jLabel27.setText("EMPLOYEE TYPE");

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 51, 0));
        jLabel28.setText("GENDER");

        jLabel29.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 51, 0));
        jLabel29.setText("DATE OF JOINING");

        jLabel30.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 51, 0));
        jLabel30.setText("SALARY");

        txtEmployeeContact.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtEmployeeContact.setForeground(new java.awt.Color(255, 51, 0));
        txtEmployeeContact.setToolTipText("");

        jLabel31.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 51, 0));
        jLabel31.setText("USER TYPE");

        jLabel32.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 51, 0));
        jLabel32.setText("PASSWORD");

        txtEmployeeSalary.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtEmployeeSalary.setForeground(new java.awt.Color(255, 51, 0));
        txtEmployeeSalary.setToolTipText("");

        comboBoxGender.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        comboBoxGender.setForeground(new java.awt.Color(255, 0, 0));
        comboBoxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        DateDOB.setForeground(new java.awt.Color(255, 51, 0));
        DateDOB.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        comboBoxEducation.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        comboBoxEducation.setForeground(new java.awt.Color(255, 0, 0));
        comboBoxEducation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B.Tech", "BCA", "BBA", "MCA", "MBA", "M.Tech", "PHD", "B.Com", "M.Com", "B.Sc", "M.Sc", "LLB", "LLM", "Others" }));

        comboBoxEmployeeType.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        comboBoxEmployeeType.setForeground(new java.awt.Color(255, 51, 0));
        comboBoxEmployeeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full Time", "Part Time", "Contract" }));

        comboBoxWorkShift.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        comboBoxWorkShift.setForeground(new java.awt.Color(255, 0, 0));
        comboBoxWorkShift.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Morning", "Evening", "Night" }));

        DateJoining.setForeground(new java.awt.Color(255, 51, 0));
        DateJoining.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        comboBoxUserType.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        comboBoxUserType.setForeground(new java.awt.Color(255, 0, 0));
        comboBoxUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee", "Admin" }));

        btnSaveEmployee.setBackground(new java.awt.Color(255, 51, 0));
        btnSaveEmployee.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSaveEmployee.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveEmployee.setText("Save");
        btnSaveEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEmployeeActionPerformed(evt);
            }
        });

        btnUpdateEmployee.setBackground(new java.awt.Color(255, 51, 0));
        btnUpdateEmployee.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnUpdateEmployee.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateEmployee.setText("Update");
        btnUpdateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateEmployeeActionPerformed(evt);
            }
        });

        btnDeleteEmployee.setBackground(new java.awt.Color(255, 51, 0));
        btnDeleteEmployee.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnDeleteEmployee.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteEmployee.setText("Delete");
        btnDeleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEmployeeActionPerformed(evt);
            }
        });

        btnClearEmployee.setBackground(new java.awt.Color(255, 51, 0));
        btnClearEmployee.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnClearEmployee.setForeground(new java.awt.Color(255, 255, 255));
        btnClearEmployee.setText("Clear");
        btnClearEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearEmployeeActionPerformed(evt);
            }
        });

        txtEmployeeAddress.setColumns(20);
        txtEmployeeAddress.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtEmployeeAddress.setForeground(new java.awt.Color(255, 51, 0));
        txtEmployeeAddress.setRows(5);
        jScrollPane2.setViewportView(txtEmployeeAddress);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(btnSaveEmployee)
                        .addGap(82, 82, 82)
                        .addComponent(btnUpdateEmployee)
                        .addGap(84, 84, 84)
                        .addComponent(btnDeleteEmployee)
                        .addGap(76, 76, 76)
                        .addComponent(btnClearEmployee))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBackE)
                        .addGap(177, 177, 177)
                        .addComponent(comboBoxSelectEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearchEmployee)
                        .addGap(18, 18, 18)
                        .addComponent(btnShowAllEmployee))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                                        .addComponent(jLabel13)
                                                        .addGap(87, 87, 87))
                                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                                        .addComponent(jLabel15)
                                                        .addGap(30, 30, 30)))
                                                .addGroup(jPanel15Layout.createSequentialGroup()
                                                    .addComponent(jLabel16)
                                                    .addGap(46, 46, 46)))
                                            .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addComponent(jLabel29)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEmployeeName)
                                            .addComponent(DateDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(comboBoxEducation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(DateJoining, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addGap(62, 62, 62)
                                        .addComponent(comboBoxUserType, 0, 170, Short.MAX_VALUE)))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel17)
                                                .addComponent(jLabel30)
                                                .addComponent(jLabel32))
                                            .addGap(66, 66, 66))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                            .addComponent(jLabel25)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmployeeContact, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEmployeeSalary)
                                    .addComponent(txtEmployeeEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboBoxWorkShift, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEmployeePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comboBoxEmployeeType, javax.swing.GroupLayout.Alignment.LEADING, 0, 166, Short.MAX_VALUE)
                                    .addComponent(comboBoxGender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBackE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxSelectEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchEmployee)
                            .addComponent(btnShowAllEmployee))))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel13)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DateDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxEducation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DateJoining, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(comboBoxUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(txtEmployeeEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmployeeContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(comboBoxWorkShift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel30))
                            .addComponent(txtEmployeeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(txtEmployeePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(comboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(comboBoxEmployeeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveEmployee)
                    .addComponent(btnUpdateEmployee)
                    .addComponent(btnDeleteEmployee)
                    .addComponent(btnClearEmployee))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 1032, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );

        TabbedPane.addTab("tab2", jPanel14);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(1018, 557));

        jPanel18.setBackground(new java.awt.Color(255, 51, 0));

        lableEmploye1.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lableEmploye1.setForeground(new java.awt.Color(255, 255, 255));
        lableEmploye1.setText("MANAGE SUPPLIER");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(417, 417, 417)
                .addComponent(lableEmploye1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lableEmploye1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        lblBacks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow.jpg"))); // NOI18N
        lblBacks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBacksMouseClicked(evt);
            }
        });

        tableSupplier.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tableSupplier.setForeground(new java.awt.Color(255, 51, 0));
        tableSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SupID", "Invoice No", "Name", "Contact Number", "Description"
            }
        ));
        tableSupplier.setSelectionBackground(new java.awt.Color(255, 51, 0));
        tableSupplier.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSupplierMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableSupplier);

        txtSearchInvoiceNo.setToolTipText("");

        btnSearchSupplier.setBackground(new java.awt.Color(255, 51, 0));
        btnSearchSupplier.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSearchSupplier.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchSupplier.setText("Search");
        btnSearchSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSupplierActionPerformed(evt);
            }
        });

        btnShowAllSupplier.setBackground(new java.awt.Color(255, 51, 0));
        btnShowAllSupplier.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnShowAllSupplier.setForeground(new java.awt.Color(255, 255, 255));
        btnShowAllSupplier.setText("Show All");
        btnShowAllSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllSupplierActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 51, 0));
        jLabel34.setText("INVOICE NUMBER");

        txtInvoiceNumber.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtInvoiceNumber.setForeground(new java.awt.Color(255, 51, 0));
        txtInvoiceNumber.setToolTipText("");

        jLabel35.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 51, 0));
        jLabel35.setText("CONTACT NUMBER");

        jLabel36.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 51, 0));
        jLabel36.setText("DESCRIPTION");

        txtSupplierContact.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtSupplierContact.setForeground(new java.awt.Color(255, 51, 0));
        txtSupplierContact.setToolTipText("");

        btnSaveSupplier.setBackground(new java.awt.Color(255, 51, 0));
        btnSaveSupplier.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSaveSupplier.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveSupplier.setText("Save");
        btnSaveSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSupplierActionPerformed(evt);
            }
        });

        btnUpdateSupplier.setBackground(new java.awt.Color(255, 51, 0));
        btnUpdateSupplier.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnUpdateSupplier.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateSupplier.setText("Update");
        btnUpdateSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSupplierActionPerformed(evt);
            }
        });

        btnDeleteSupplier.setBackground(new java.awt.Color(255, 51, 0));
        btnDeleteSupplier.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnDeleteSupplier.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteSupplier.setText("Delete");
        btnDeleteSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSupplierActionPerformed(evt);
            }
        });

        btnClearSupplier.setBackground(new java.awt.Color(255, 51, 0));
        btnClearSupplier.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnClearSupplier.setForeground(new java.awt.Color(255, 255, 255));
        btnClearSupplier.setText("Clear");
        btnClearSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSupplierActionPerformed(evt);
            }
        });

        txtSupplierDescription.setColumns(20);
        txtSupplierDescription.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSupplierDescription.setForeground(new java.awt.Color(255, 51, 0));
        txtSupplierDescription.setRows(5);
        jScrollPane4.setViewportView(txtSupplierDescription);

        jLabel37.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 51, 0));
        jLabel37.setText("INVOICE NO.");

        jLabel38.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 51, 0));
        jLabel38.setText("SUPPLIER NAME");

        txtSupplierName.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtSupplierName.setForeground(new java.awt.Color(255, 51, 0));
        txtSupplierName.setToolTipText("");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel36))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(btnSaveSupplier)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdateSupplier)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteSupplier)
                                .addGap(18, 18, 18)
                                .addComponent(btnClearSupplier))
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel17Layout.createSequentialGroup()
                                    .addComponent(jLabel35)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSupplierContact, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                                    .addComponent(jLabel38)
                                    .addGap(66, 66, 66)
                                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(lblBacks)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel37)
                                .addGap(39, 39, 39)))
                        .addComponent(txtSearchInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearchSupplier)
                        .addGap(18, 18, 18)
                        .addComponent(btnShowAllSupplier)
                        .addGap(40, 40, 40))))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(lblBacks)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchSupplier)
                            .addComponent(btnShowAllSupplier)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txtInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSupplierContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSaveSupplier)
                            .addComponent(btnUpdateSupplier)
                            .addComponent(btnDeleteSupplier)
                            .addComponent(btnClearSupplier))
                        .addGap(65, 65, 65))))
        );

        TabbedPane.addTab("tab3", jPanel17);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(1018, 557));

        jPanel20.setBackground(new java.awt.Color(255, 51, 0));

        lableEmploye2.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lableEmploye2.setForeground(new java.awt.Color(255, 255, 255));
        lableEmploye2.setText("MANAGE CUSTOMER");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(417, 417, 417)
                .addComponent(lableEmploye2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lableEmploye2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        lblBackC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow.jpg"))); // NOI18N
        lblBackC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackCMouseClicked(evt);
            }
        });

        tableCustomer.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tableCustomer.setForeground(new java.awt.Color(255, 51, 0));
        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CustID", "Name", "Contact Number", "Email"
            }
        ));
        tableCustomer.setSelectionBackground(new java.awt.Color(255, 51, 0));
        tableCustomer.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableCustomer);

        txtSearchCustomer.setToolTipText("");

        btnSearchCustomer.setBackground(new java.awt.Color(255, 51, 0));
        btnSearchCustomer.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSearchCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchCustomer.setText("Search");
        btnSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCustomerActionPerformed(evt);
            }
        });

        btnShowAllCustomer.setBackground(new java.awt.Color(255, 51, 0));
        btnShowAllCustomer.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnShowAllCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnShowAllCustomer.setText("Show All");
        btnShowAllCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllCustomerActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 51, 0));
        jLabel40.setText("CUSTOMER NAME");

        txtCustomerName.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCustomerName.setForeground(new java.awt.Color(255, 51, 0));
        txtCustomerName.setToolTipText("");

        jLabel41.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 51, 0));
        jLabel41.setText("CONTACT NUMBER");

        jLabel42.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 51, 0));
        jLabel42.setText("EMAIL");

        txtCustomerContact.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCustomerContact.setForeground(new java.awt.Color(255, 51, 0));
        txtCustomerContact.setToolTipText("");

        btnSaveCustomer.setBackground(new java.awt.Color(255, 51, 0));
        btnSaveCustomer.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSaveCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveCustomer.setText("Save");
        btnSaveCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCustomerActionPerformed(evt);
            }
        });

        btnUpdateCustomer.setBackground(new java.awt.Color(255, 51, 0));
        btnUpdateCustomer.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnUpdateCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateCustomer.setText("Update");
        btnUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCustomerActionPerformed(evt);
            }
        });

        btnDeleteCustomer.setBackground(new java.awt.Color(255, 51, 0));
        btnDeleteCustomer.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnDeleteCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCustomer.setText("Delete");
        btnDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCustomerActionPerformed(evt);
            }
        });

        btnClearCustomer.setBackground(new java.awt.Color(255, 51, 0));
        btnClearCustomer.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnClearCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnClearCustomer.setText("Clear");
        btnClearCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearCustomerActionPerformed(evt);
            }
        });

        txtCustomerEmail.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCustomerEmail.setForeground(new java.awt.Color(255, 51, 0));
        txtCustomerEmail.setToolTipText("");

        jPanel21.setBackground(new java.awt.Color(0, 102, 204));

        lblCount.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lblCount.setForeground(new java.awt.Color(255, 255, 255));
        lblCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCount.setText("X");

        jPanel22.setBackground(new java.awt.Color(0, 51, 204));

        jLabel43.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("ORDER NUMBER");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCount)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(255, 0, 204));

        lblAmount.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lblAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAmount.setText("X");

        jPanel24.setBackground(new java.awt.Color(204, 0, 204));

        jLabel44.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("ORDER AMOUNT");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAmount)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel25.setBackground(new java.awt.Color(0, 255, 0));

        lblLastDate.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lblLastDate.setForeground(new java.awt.Color(255, 255, 255));
        lblLastDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLastDate.setText("X");

        jPanel26.setBackground(new java.awt.Color(0, 204, 0));

        jLabel45.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("LAST ORDER DATE");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLastDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLastDate)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        comboBoxSelectCustomer.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        comboBoxSelectCustomer.setForeground(new java.awt.Color(255, 0, 0));
        comboBoxSelectCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search Customer By", "CustID", "Name", "Order No." }));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBackC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnShowAllCustomer)
                .addGap(40, 40, 40))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(159, 159, 159))))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel40)
                                            .addComponent(jLabel41)
                                            .addComponent(jLabel42))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                            .addComponent(txtCustomerContact)
                                            .addComponent(txtCustomerEmail)))
                                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btnSaveCustomer)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdateCustomer)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteCustomer)
                                .addGap(18, 18, 18)
                                .addComponent(btnClearCustomer)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)))
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(comboBoxSelectCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchCustomer)))
                .addGap(16, 16, 16))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(lblBackC)
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearchCustomer)
                                    .addComponent(btnShowAllCustomer)
                                    .addComponent(comboBoxSelectCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCustomerContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSaveCustomer)
                            .addComponent(btnUpdateCustomer)
                            .addComponent(btnDeleteCustomer)
                            .addComponent(btnClearCustomer))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(103, Short.MAX_VALUE))))
        );

        TabbedPane.addTab("tab4", jPanel19);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setPreferredSize(new java.awt.Dimension(1018, 557));

        jPanel28.setBackground(new java.awt.Color(255, 51, 0));

        lableEmploye3.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lableEmploye3.setForeground(new java.awt.Color(255, 255, 255));
        lableEmploye3.setText("MANAGE PRODUCT CATEGORY");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(lableEmploye3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lableEmploye3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        lblBackpc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow.jpg"))); // NOI18N
        lblBackpc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackpcMouseClicked(evt);
            }
        });

        tableCategory.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tableCategory.setForeground(new java.awt.Color(255, 51, 0));
        tableCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category ID", "Category Name ", "Category Description"
            }
        ));
        tableCategory.setSelectionBackground(new java.awt.Color(255, 51, 0));
        tableCategory.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCategoryMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableCategory);

        jLabel47.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 51, 0));
        jLabel47.setText("CATEGORY NAME");

        txtCategoryName.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCategoryName.setForeground(new java.awt.Color(255, 51, 0));
        txtCategoryName.setToolTipText("");

        jLabel48.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 51, 0));
        jLabel48.setText("DESCRIPTION");

        btnSaveCategory.setBackground(new java.awt.Color(255, 51, 0));
        btnSaveCategory.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSaveCategory.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveCategory.setText("Save");
        btnSaveCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCategoryActionPerformed(evt);
            }
        });

        btnUpdateCategory.setBackground(new java.awt.Color(255, 51, 0));
        btnUpdateCategory.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnUpdateCategory.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateCategory.setText("Update");
        btnUpdateCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCategoryActionPerformed(evt);
            }
        });

        btnDeleteCategory.setBackground(new java.awt.Color(255, 51, 0));
        btnDeleteCategory.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnDeleteCategory.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCategory.setText("Delete");
        btnDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCategoryActionPerformed(evt);
            }
        });

        btnClearCategory.setBackground(new java.awt.Color(255, 51, 0));
        btnClearCategory.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnClearCategory.setForeground(new java.awt.Color(255, 255, 255));
        btnClearCategory.setText("Clear");
        btnClearCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearCategoryActionPerformed(evt);
            }
        });

        txtCategoryDescription.setColumns(20);
        txtCategoryDescription.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtCategoryDescription.setForeground(new java.awt.Color(255, 51, 0));
        txtCategoryDescription.setRows(5);
        jScrollPane7.setViewportView(txtCategoryDescription);

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/categoryback.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBackpc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addContainerGap(31, Short.MAX_VALUE)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCategoryName)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                                .addComponent(btnSaveCategory)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdateCategory)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteCategory)
                                .addGap(18, 18, 18)
                                .addComponent(btnClearCategory)
                                .addGap(88, 88, 88)))
                        .addGap(26, 26, 26))))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(lblBackpc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(txtCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSaveCategory)
                            .addComponent(btnUpdateCategory)
                            .addComponent(btnDeleteCategory)
                            .addComponent(btnClearCategory))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        TabbedPane.addTab("tab5", jPanel27);

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setPreferredSize(new java.awt.Dimension(1018, 557));

        jPanel30.setBackground(new java.awt.Color(255, 51, 0));

        lableEmploye4.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lableEmploye4.setForeground(new java.awt.Color(255, 255, 255));
        lableEmploye4.setText("MANAGE PRODUCT");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(417, 417, 417)
                .addComponent(lableEmploye4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lableEmploye4, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        lblBackp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow.jpg"))); // NOI18N
        lblBackp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackpMouseClicked(evt);
            }
        });

        tableProduct.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tableProduct.setForeground(new java.awt.Color(255, 51, 0));
        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "productID", "Category", "Supplier", "Name", "Price", "Quantity", "Status", "Description"
            }
        ));
        tableProduct.setSelectionBackground(new java.awt.Color(255, 51, 0));
        tableProduct.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tableProduct);

        txtSearchProduct.setToolTipText("");

        btnSearchProduct.setBackground(new java.awt.Color(255, 51, 0));
        btnSearchProduct.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSearchProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchProduct.setText("Search");
        btnSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProductActionPerformed(evt);
            }
        });

        btnShowAllProduct.setBackground(new java.awt.Color(255, 51, 0));
        btnShowAllProduct.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnShowAllProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnShowAllProduct.setText("Show All");
        btnShowAllProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllProductActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 51, 0));
        jLabel51.setText("PRODUCT NAME");

        txtProductName.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtProductName.setForeground(new java.awt.Color(255, 51, 0));
        txtProductName.setToolTipText("");

        jLabel52.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 51, 0));
        jLabel52.setText("PRICE");

        lblQuantity.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(255, 51, 0));
        lblQuantity.setText("QUANTITY");

        txtProductPrice.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtProductPrice.setForeground(new java.awt.Color(255, 51, 0));
        txtProductPrice.setToolTipText("");

        btnSaveProduct.setBackground(new java.awt.Color(255, 51, 0));
        btnSaveProduct.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSaveProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveProduct.setText("Save");
        btnSaveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProductActionPerformed(evt);
            }
        });

        btnUpdateProduct.setBackground(new java.awt.Color(255, 51, 0));
        btnUpdateProduct.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnUpdateProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateProduct.setText("Update");
        btnUpdateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProductActionPerformed(evt);
            }
        });

        btnDeleteProduct.setBackground(new java.awt.Color(255, 51, 0));
        btnDeleteProduct.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnDeleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteProduct.setText("Delete");
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });

        btnClearProduct.setBackground(new java.awt.Color(255, 51, 0));
        btnClearProduct.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnClearProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnClearProduct.setText("Clear");
        btnClearProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearProductActionPerformed(evt);
            }
        });

        txtProductQuantity.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtProductQuantity.setForeground(new java.awt.Color(255, 51, 0));
        txtProductQuantity.setToolTipText("");

        comboBoxSelectProduct.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        comboBoxSelectProduct.setForeground(new java.awt.Color(255, 0, 0));
        comboBoxSelectProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search Product By", "Category", "Supplier", "Product Name", "Price", "Status" }));

        jLabel54.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 51, 0));
        jLabel54.setText("SUPPLIER");

        jLabel55.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 51, 0));
        jLabel55.setText("STATUS");

        jLabel56.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 51, 0));
        jLabel56.setText("CATEGORY");

        comboBoxProductCategory.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        comboBoxProductCategory.setForeground(new java.awt.Color(255, 0, 0));
        comboBoxProductCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        comboBoxProductSupplier.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        comboBoxProductSupplier.setForeground(new java.awt.Color(255, 0, 0));
        comboBoxProductSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        comboBoxProductStatus.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        comboBoxProductStatus.setForeground(new java.awt.Color(255, 0, 0));
        comboBoxProductStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Active", "InActive" }));

        jLabel57.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 51, 0));
        jLabel57.setText("DESCRIPTION");

        txtProductDescription.setColumns(20);
        txtProductDescription.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtProductDescription.setForeground(new java.awt.Color(255, 51, 0));
        txtProductDescription.setRows(5);
        jScrollPane9.setViewportView(txtProductDescription);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBackp))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(btnSaveProduct)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdateProduct)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteProduct)
                                .addGap(18, 18, 18)
                                .addComponent(btnClearProduct))
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel52)
                                    .addComponent(lblQuantity)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel56)
                                    .addComponent(jLabel57))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtProductName)
                                        .addComponent(txtProductPrice)
                                        .addComponent(txtProductQuantity)
                                        .addComponent(comboBoxProductCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboBoxProductSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboBoxProductStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                        .addComponent(btnShowAllProduct)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                        .addComponent(comboBoxSelectProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchProduct)
                        .addGap(147, 147, 147))))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(lblBackp)
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearchProduct)
                                    .addComponent(btnShowAllProduct)
                                    .addComponent(comboBoxSelectProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(151, Short.MAX_VALUE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(comboBoxProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(comboBoxProductSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQuantity))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(comboBoxProductStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSaveProduct)
                            .addComponent(btnUpdateProduct)
                            .addComponent(btnDeleteProduct)
                            .addComponent(btnClearProduct))
                        .addGap(77, 77, 77))))
        );

        TabbedPane.addTab("tab4", jPanel29);

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setPreferredSize(new java.awt.Dimension(1018, 557));

        jPanel32.setBackground(new java.awt.Color(255, 51, 0));

        lableEmploye5.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lableEmploye5.setForeground(new java.awt.Color(255, 255, 255));
        lableEmploye5.setText("VIEW CUSTOMER BILLS");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(409, 409, 409)
                .addComponent(lableEmploye5)
                .addContainerGap(411, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lableEmploye5, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        lblBackb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow.jpg"))); // NOI18N
        lblBackb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackbMouseClicked(evt);
            }
        });

        tableCustomerBill.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tableCustomerBill.setForeground(new java.awt.Color(255, 51, 0));
        tableCustomerBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name"
            }
        ));
        tableCustomerBill.setSelectionBackground(new java.awt.Color(255, 51, 0));
        tableCustomerBill.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableCustomerBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerBillMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tableCustomerBill);

        txtSearchBill.setToolTipText("");

        btnSearchBill.setBackground(new java.awt.Color(255, 51, 0));
        btnSearchBill.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSearchBill.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchBill.setText("Search");
        btnSearchBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchBillActionPerformed(evt);
            }
        });

        btnShowAllBill.setBackground(new java.awt.Color(255, 51, 0));
        btnShowAllBill.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnShowAllBill.setForeground(new java.awt.Color(255, 255, 255));
        btnShowAllBill.setText("Show All");
        btnShowAllBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllBillActionPerformed(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 51, 0));
        jLabel59.setText("Bill No.");

        tableOrderBill.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tableOrderBill.setForeground(new java.awt.Color(255, 51, 0));
        tableOrderBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Bill ID", "Date", "Total Amount", "Net Amount"
            }
        ));
        tableOrderBill.setSelectionBackground(new java.awt.Color(255, 51, 0));
        tableOrderBill.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableOrderBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOrderBillMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tableOrderBill);

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel34.setBackground(new java.awt.Color(255, 0, 0));
        jPanel34.setForeground(new java.awt.Color(255, 255, 255));

        jLabel60.setBackground(new java.awt.Color(255, 51, 0));
        jLabel60.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("CUSTOMER BILL AREA");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        txtCustomerBillArea.setColumns(20);
        txtCustomerBillArea.setRows(5);
        jScrollPane12.setViewportView(txtCustomerBillArea);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane12)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12))
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchBill, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchBill)
                        .addGap(177, 177, 177))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnShowAllBill))
                        .addGap(70, 70, 70))))
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBackb))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBackb)
                .addGap(13, 13, 13)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchBill)
                    .addComponent(btnShowAllBill)
                    .addComponent(jLabel59))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        TabbedPane.addTab("tab5", jPanel31);

        jPanel1.add(TabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 74, -1, 670));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Do you want to Logout the application", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeActionPerformed
        // TODO add your handling code here:
        TabbedPane.setSelectedIndex(1);
    }//GEN-LAST:event_btnEmployeeActionPerformed

    private void btnSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuplierActionPerformed
        // TODO add your handling code here:
        TabbedPane.setSelectedIndex(2);
    }//GEN-LAST:event_btnSuplierActionPerformed

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        // TODO add your handling code here:
        TabbedPane.setSelectedIndex(3);
    }//GEN-LAST:event_btnCustomerActionPerformed

    private void btnSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesActionPerformed
        // TODO add your handling code here:
        TabbedPane.setSelectedIndex(6);
        loadCustomerBillData(); // Load customer names from sales table
    loadOrderBillData();
        
    }//GEN-LAST:event_btnSalesActionPerformed

    private void btnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryActionPerformed
        // TODO add your handling code here:
        TabbedPane.setSelectedIndex(4);
    }//GEN-LAST:event_btnCategoryActionPerformed

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
        // TODO add your handling code here:
        TabbedPane.setSelectedIndex(5);
    }//GEN-LAST:event_btnProductActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Do you want to Exit from the application", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    //employee
    public void loadEmployeeData() {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Employee ");

            // Get table model and clear existing data
            DefaultTableModel model = (DefaultTableModel) tableEmployee.getModel();
            model.setRowCount(0);

            // Add data row by row
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("employee_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("gender"),
                    rs.getString("dob"),
                    rs.getString("contact_number"),
                    rs.getString("employee_type"),
                    rs.getString("education"),
                    rs.getString("work_shift"),
                    rs.getString("address"),
                    rs.getString("date_of_joining"),
                    rs.getString("salary"),
                    rs.getString("user_type")

                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
    }

    public void EmployeeClear() {
        txtEmployeeName.setText("");
        txtEmployeeContact.setText("");
        txtEmployeeEmail.setText("");
        txtEmployeePassword.setText("");
        txtEmployeeAddress.setText("");
        comboBoxGender.setSelectedIndex(0);
        comboBoxEmployeeType.setSelectedIndex(0);
        comboBoxEducation.setSelectedIndex(0);
        comboBoxUserType.setSelectedIndex(0);
        comboBoxWorkShift.setSelectedIndex(0);
        txtEmployeeSalary.setText("");
        DateDOB.setDate(null);
        DateJoining.setDate(null);
    }
    private void btnClearEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearEmployeeActionPerformed
        // TODO add your handling code here:
        EmployeeClear();
    }//GEN-LAST:event_btnClearEmployeeActionPerformed

    private void btnDeleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEmployeeActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("Delete from employee where employee_id=?");
            ps.setInt(1, EmployeeID);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully!");
                loadEmployeeData(); 
                EmployeeClear();// Refresh the UI
            } else {
                JOptionPane.showMessageDialog(null, "No employee found with this ID.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnDeleteEmployeeActionPerformed

    private void btnUpdateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateEmployeeActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String employeeName = txtEmployeeName.getText();
        String employeeContact = txtEmployeeContact.getText();
        String employeeEmail = txtEmployeeEmail.getText();
        String employeePassword = txtEmployeePassword.getText();
        String employeeAddress = txtEmployeeAddress.getText();
        String employeeGender = ((String) comboBoxGender.getSelectedItem()).trim();
        String employee_type = (String) comboBoxEmployeeType.getSelectedItem();
        String dob = sdf.format(DateDOB.getDate());
        String education = (String) comboBoxEducation.getSelectedItem();
        String date_of_joining = sdf.format(DateJoining.getDate());
        String user_type = (String) comboBoxUserType.getSelectedItem();
        String work_shift = (String) comboBoxWorkShift.getSelectedItem();
        String salary = txtEmployeeSalary.getText();

        if (validateEmployeeFields("edit")) {
            JOptionPane.showMessageDialog(null, "All field are required");
        } else {
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("update Employee set name=? , email=? , gender=? , dob=? ,contact_number=? ,employee_type=? ,education=? , work_shift=? ,address=? , date_of_joining=? ,  salary=? ,user_type=? , password=? where employee_id=?");
                ps.setString(1, employeeName);
                ps.setString(2, employeeEmail);
                ps.setString(3, employeeGender);
                ps.setString(4, dob);
                ps.setString(5, employeeContact);
                ps.setString(6, employee_type);
                ps.setString(7, education);
                ps.setString(8, work_shift);
                ps.setString(9, employeeAddress);
                ps.setString(10, date_of_joining);
                ps.setString(11, salary);
                ps.setString(12, user_type);
                ps.setString(13, employeePassword);
                ps.setInt(14, EmployeeID);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Employee Updated Successfully");
                loadEmployeeData();
                EmployeeClear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnUpdateEmployeeActionPerformed

    private void btnSaveEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEmployeeActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String employeeName = txtEmployeeName.getText();
        String employeeContact = txtEmployeeContact.getText();
        String employeeEmail = txtEmployeeEmail.getText();
        String employeePassword = txtEmployeePassword.getText();
        String employeeAddress = txtEmployeeAddress.getText();
        String employeeGender = ((String) comboBoxGender.getSelectedItem()).trim();
        String employee_type = (String) comboBoxEmployeeType.getSelectedItem();
        String dob = sdf.format(DateDOB.getDate());
        String education = (String) comboBoxEducation.getSelectedItem();
        String date_of_joining = sdf.format(DateJoining.getDate());
        String user_type = (String) comboBoxUserType.getSelectedItem();
        String work_shift = (String) comboBoxWorkShift.getSelectedItem();
        String salary = txtEmployeeSalary.getText();

        if (validateEmployeeFields("new")) {
            JOptionPane.showMessageDialog(null, "All field are required");
        } else {
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("INSERT INTO Employee (name, email, gender, dob,contact_number,  employee_type,education, work_shift,address, date_of_joining,  salary,user_type, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, employeeName);
                ps.setString(2, employeeEmail);
                ps.setString(3, employeeGender);
                ps.setString(4, dob);
                ps.setString(5, employeeContact);
                ps.setString(6, employee_type);
                ps.setString(7, education);
                ps.setString(8, work_shift);
                ps.setString(9, employeeAddress);
                ps.setString(10, date_of_joining);
                ps.setString(11, salary);
                ps.setString(12, user_type);
                ps.setString(13, employeePassword);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                loadEmployeeData();
                EmployeeClear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnSaveEmployeeActionPerformed

    private void btnShowAllEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllEmployeeActionPerformed
        // TODO add your handling code here:
        loadEmployeeData();
    }//GEN-LAST:event_btnShowAllEmployeeActionPerformed

    private void btnSearchEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchEmployeeActionPerformed
        // TODO add your handling code here:
        String searchBy = comboBoxSelectEmployee.getSelectedItem().toString();
        String searchText = txtSearch.getText();
        if (searchText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a search keyword");
            return;
        }

        String query = "select * from employee where ";
        switch (searchBy) {
            case "empID":
                query += "employee_id like ?";
                break;
            case "Name":
                query += "name like ?";
                break;
            case "Gender":
                query += "gender like ?";
                break;
            case "Employee Type":
                query += "employee_type like ?";
                break;
            case "User Type":
                query += "user_type like ?";
                break;
            case "Work Shift":
                query += "work_shift like ?";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ivalid search ");
                return;
        }
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + searchText + "%");
            ResultSet rs = ps.executeQuery();

            // Get table model and clear existing data
            DefaultTableModel model = (DefaultTableModel) tableEmployee.getModel();
            model.setRowCount(0);
            boolean foundData = false;
            // Add data row by row
            while (rs.next()) {
                foundData = true;
                model.addRow(new Object[]{
                    rs.getInt("employee_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("gender"),
                    rs.getString("dob"),
                    rs.getString("contact_number"),
                    rs.getString("employee_type"),
                    rs.getString("education"),
                    rs.getString("work_shift"),
                    rs.getString("address"),
                    rs.getString("date_of_joining"),
                    rs.getString("salary"),
                    rs.getString("user_type")

                });
            }
            if (!foundData) {
                JOptionPane.showMessageDialog(null, "No records found!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSearchEmployeeActionPerformed

//supplier
    public void loadSupplierData() {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Supplier ");

            // Get table model and clear existing data
            DefaultTableModel model = (DefaultTableModel) tableSupplier.getModel();
            model.setRowCount(0);

            // Add data row by row
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("supplier_id"),
                    rs.getString("invoice_number"),
                    rs.getString("supplier_name"),
                    rs.getString("supplier_contact"),
                    rs.getString("supplier_description")

                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
    }

    public void SupplierClear() {
        txtInvoiceNumber.setText("");
        txtSupplierName.setText("");
        txtSupplierContact.setText("");
        txtSupplierDescription.setText("");
    }
    private void btnSearchSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSupplierActionPerformed
        // TODO add your handling code here:
        String invoiceNo = txtSearchInvoiceNo.getText();
        if (invoiceNo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a search keyword");
            return;
        }

        String query = "SELECT * FROM Supplier WHERE invoice_number = ? ";

        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, invoiceNo);
            ResultSet rs = ps.executeQuery();

            // Get table model and clear existing data
            DefaultTableModel model = (DefaultTableModel) tableSupplier.getModel();
            model.setRowCount(0);
            boolean foundData = false;
            // Add data row by row
            while (rs.next()) {
                foundData = true;
                model.addRow(new Object[]{
                    rs.getInt("supplier_id"),
                    rs.getString("invoice_number"),
                    rs.getString("supplier_name"),
                    rs.getString("supplier_contact"),
                    rs.getString("supplier_description")

                });
            }
            if (!foundData) {
                JOptionPane.showMessageDialog(null, "No records found!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSearchSupplierActionPerformed

    private void btnShowAllSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllSupplierActionPerformed
        // TODO add your handling code here:
        loadSupplierData();
    }//GEN-LAST:event_btnShowAllSupplierActionPerformed

    private void btnSaveSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSupplierActionPerformed
        // TODO add your handling code here:
        String invoiceNo = txtInvoiceNumber.getText();
        String supplierName = txtSupplierName.getText();
        String supplierContact = txtSupplierContact.getText();
        String supplierDescription = txtSupplierDescription.getText();

        if (validateSupplierFields()) {
            JOptionPane.showMessageDialog(null, "All field are required");

        } else {
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("INSERT INTO Supplier (invoice_number,supplier_name,supplier_contact,supplier_description) VALUES (?, ?, ?, ?)");
                ps.setString(1, invoiceNo);
                ps.setString(2, supplierName);
                ps.setString(3, supplierContact);
                ps.setString(4, supplierDescription);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Supplier Added Successfully");
                loadSupplierData(); // Refresh Table after adding
                SupplierClear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnSaveSupplierActionPerformed

    private void btnUpdateSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSupplierActionPerformed
        // TODO add your handling code here:
        String invoiceNo = txtInvoiceNumber.getText();
        String supplierName = txtSupplierName.getText();
        String supplierContact = txtSupplierContact.getText();
        String supplierDescription = txtSupplierDescription.getText();

        if (validateSupplierFields()) {
            JOptionPane.showMessageDialog(null, "All field are required");
        } else {
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("update Supplier set invoice_number=? ,supplier_name=? ,supplier_contact=? ,supplier_description=? where supplier_id=?");
                ps.setString(1, invoiceNo);
                ps.setString(2, supplierName);
                ps.setString(3, supplierContact);
                ps.setString(4, supplierDescription);
                ps.setInt(5, SupplierID);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Supplier Updated Successfully");
                loadSupplierData();
                SupplierClear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnUpdateSupplierActionPerformed

    private void btnDeleteSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSupplierActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("Delete from supplier where supplier_id=?");
            ps.setInt(1, SupplierID);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Supplier Deleted Successfully!");
                loadSupplierData();  // Refresh the UI
                SupplierClear();
            } else {
                JOptionPane.showMessageDialog(null, "No Supplier found with this ID.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnDeleteSupplierActionPerformed

    private void btnClearSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSupplierActionPerformed
        // TODO add your handling code here:
        SupplierClear();

    }//GEN-LAST:event_btnClearSupplierActionPerformed

    //customer
    public void loadCustomerData() {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM customer ");

            // Get table model and clear existing data
            DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
            model.setRowCount(0);

            // Add data row by row
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("customer_id"),
                    rs.getString("customer_name"),
                    rs.getString("customer_contact"),
                    rs.getString("customer_email")

                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void clearCustomerFields() {
        txtCustomerName.setText("");
        txtCustomerContact.setText("");
        txtCustomerEmail.setText("");
    }
    private void btnSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCustomerActionPerformed
        // TODO add your handling code here:
        String searchBy = comboBoxSelectCustomer.getSelectedItem().toString();
        String searchText = txtSearchCustomer.getText();
        if (searchText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a search keyword");
            return;
        }

        String query = "SELECT customer.customer_id, customer.customer_name, customer.customer_contact, customer.customer_email, COUNT(orders.order_id) AS order_count"
                + "FROM customer LEFT JOIN orders ON customer.customer_id = orders.customer_id WHERE";
        switch (searchBy) {
            case "custID":
                query += "customere_id like ?";
                break;
            case "Name":
                query += "customer_name like ?";
                break;
            case "Order no":
                query += "order_count like ?";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid search ");
                return;
        }
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + searchText + "%");
            ResultSet rs = ps.executeQuery();

            // Get table model and clear existing data
            DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
            model.setRowCount(0);
            boolean foundData = false;
            // Add data row by row
            while (rs.next()) {
                foundData = true;
                model.addRow(new Object[]{
                    rs.getInt("customer_id"),
                    rs.getString("customer_name"),
                    rs.getString("customer_contact"),
                    rs.getString("customer_email")

                });
            }
            if (!foundData) {
                JOptionPane.showMessageDialog(null, "No records found!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSearchCustomerActionPerformed

    private void btnShowAllCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllCustomerActionPerformed
        // TODO add your handling code here:
        loadCustomerData();
    }//GEN-LAST:event_btnShowAllCustomerActionPerformed

    private void btnSaveCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCustomerActionPerformed
        // TODO add your handling code here:
        String customerName = txtCustomerName.getText();
        String customerContact = txtCustomerContact.getText();
        String customerEmail = txtCustomerEmail.getText();

        if (validateCustomerFields()) {
            JOptionPane.showMessageDialog(null, "All field are required");
        } else {
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into customer(customer_name,customer_contact,customer_email) values (?,?,?)");
                ps.setString(1, customerName);
                ps.setString(2, customerContact);
                ps.setString(3, customerEmail);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Customer Added Successfully");

                loadCustomerData();
                clearCustomerFields();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnSaveCustomerActionPerformed

    private void btnUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCustomerActionPerformed
        // TODO add your handling code here:
        String customerName = txtCustomerName.getText();
        String customerContact = txtCustomerContact.getText();
        String customerEmail = txtCustomerEmail.getText();

        if (validateCustomerFields()) {
            JOptionPane.showMessageDialog(null, "All field are required");
        } else {
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("update customer set customer_name=?,customer_contact=? ,customer_email=? where customer_id=?");
                ps.setString(1, customerName);
                ps.setString(2, customerContact);
                ps.setString(3, customerEmail);
                ps.setInt(4, CustomerID);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Customer updated Successfully");

                loadCustomerData();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnUpdateCustomerActionPerformed

    private void btnDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCustomerActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("Delete from customer where customer_id=?");
            ps.setInt(1, CustomerID);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Customer Deleted Successfully!");
                loadCustomerData();
                clearCustomerFields();
            } else {
                JOptionPane.showMessageDialog(null, "No Customer found with this ID.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btnDeleteCustomerActionPerformed

    private void btnClearCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearCustomerActionPerformed
        // TODO add your handling code here:
        clearCustomerFields();
    }//GEN-LAST:event_btnClearCustomerActionPerformed

    //category
    public void loadCategoryData() {
    DefaultTableModel model = (DefaultTableModel) tableCategory.getModel();
    model.setRowCount(0); // Clear existing data

    try {
        Connection con = ConnectionProvider.getCon();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM category");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("category_id"),
                rs.getString("category_name"),
                rs.getString("category_description")
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error loading category data: " + e.getMessage());
    }
}
    private void clearCategoryFields() {
        txtCategoryName.setText("");
        txtCategoryDescription.setText("");
    }
    private void btnSaveCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCategoryActionPerformed
        // TODO add your handling code here:
        String categoryName = txtCategoryName.getText();
        String categorydescription = txtCategoryDescription.getText();

        if (validateCategoryFields()) {
            JOptionPane.showMessageDialog(null, "All field are required");
        } else {
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into category(category_name,category_description) values (?,?)");
                ps.setString(1, categoryName);
                ps.setString(2, categorydescription);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Category Added Successfully");

                loadCategoryData();
                clearCategoryFields();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnSaveCategoryActionPerformed

    private void btnUpdateCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCategoryActionPerformed
        // TODO add your handling code here:
        String categoryName = txtCategoryName.getText();
        String categorydescription = txtCategoryDescription.getText();

        if (validateCategoryFields()) {
            JOptionPane.showMessageDialog(null, "All field are required");
        } else {
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("update category set category_name=? ,category_description=? where category_id=?");
                ps.setString(1, categoryName);
                ps.setString(2, categorydescription);
                 ps.setInt(3, CategoryID);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Category Updated Successfully");

                loadCategoryData();
                clearCategoryFields();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnUpdateCategoryActionPerformed

    private void btnDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCategoryActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("Delete from category where category_id=?");
            ps.setInt(1, CategoryID);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Category Deleted Successfully!");
                loadCategoryData();
                clearCategoryFields();
            } else {
                JOptionPane.showMessageDialog(null, "No Category found with this ID.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnDeleteCategoryActionPerformed

    private void btnClearCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearCategoryActionPerformed
        // TODO add your handling code here:
        clearCategoryFields();
    }//GEN-LAST:event_btnClearCategoryActionPerformed

    //product
    private void getAllProductCategory() {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from category");
            comboBoxProductCategory.removeAllItems();
            while (rs.next()) {
                comboBoxProductCategory.addItem( rs.getString("category_name"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void getAllSupplier() {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from supplier");
            comboBoxProductSupplier.removeAllItems();
            while (rs.next()) {
                comboBoxProductSupplier.addItem( rs.getString("supplier_name"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void loadProductData() {
    getAllProductCategory();
    getAllSupplier();
    
    DefaultTableModel model = (DefaultTableModel) tableProduct.getModel();
    model.setRowCount(0); // Clear table before loading new data

    try {
        Connection con = ConnectionProvider.getCon();

        // ✅ JOIN category and supplier tables to fetch names instead of IDs
        String query = "SELECT p.product_id, c.category_name, s.supplier_name, p.product_name, "
                     + "p.price, p.quantity, p.status, p.product_description "
                     + "FROM product p "
                     + "JOIN category c ON p.category_name = c.category_name "
                     + "JOIN supplier s ON p.supplier_name = s.supplier_name "; // ✅ Show only active products

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("product_id"),        // Product ID
                rs.getString("category_name"),  // Category Name
                rs.getString("supplier_name"),  // Supplier Name
                rs.getString("product_name"),   // Product Name
                rs.getDouble("price"),          // Price
                rs.getInt("quantity"),          // Quantity
                rs.getString("status"),         // Status
                rs.getString("product_description") // Description
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error loading products: " + e.getMessage());
    }
}


    public void clearProductFields() {
    txtProductName.setText("");
    comboBoxProductCategory.setSelectedIndex(0); // Reset dropdown
    comboBoxProductSupplier.setSelectedIndex(0); // Reset dropdown
    txtProductPrice.setText("");
    txtProductQuantity.setText("");
    txtProductDescription.setText("");
    comboBoxProductStatus.setSelectedIndex(0); // Reset status dropdown
    txtProductName.requestFocus(); // Set focus back to the first field
}

    private void btnSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProductActionPerformed
        // TODO add your handling code here:
        String searchBy = comboBoxSelectProduct.getSelectedItem().toString(); // Selected criteria from ComboBox
        String searchText = txtSearchProduct.getText().trim(); // Get search input

        if (searchText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a search keyword!");
            return;
        }

        String query = "SELECT * FROM product WHERE ";

        // ✅ Determine the search condition based on ComboBox selection
        switch (searchBy) {
            case "Product Name":
                query += "product_name LIKE ?";
                break;
            case "Category ":
                query += "category_name LIKE ?";
                break;
            case "Supplier ":
                query += "supplier_name LIKE ?";
                break;
            case "Price":
                query += "price = ?";
                break;
            case "Status":
                query += "status LIKE ?";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid search option selected!");
                return;
        }

        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement(query);

            // ✅ If searching by price, set it as an integer; otherwise, use LIKE for text searches
            if (searchBy.equals("Price")) {
                ps.setInt(1, Integer.parseInt(searchText));
            } else {
                ps.setString(1, "%" + searchText + "%"); // Use wildcard for LIKE queries
            }

            ResultSet rs = ps.executeQuery();

            // ✅ Get table model and clear previous search results
            DefaultTableModel model = (DefaultTableModel) tableProduct.getModel();
            model.setRowCount(0);

            boolean foundData = false;
            while (rs.next()) {
                foundData = true;
                model.addRow(new Object[]{
                    rs.getInt("product_id"),
                    rs.getString("category_name"), // ✅ Fetch category name directly
                    rs.getString("supplier_name"), // ✅ Fetch supplier name directly
                    rs.getString("product_name"),
                    rs.getInt("price"),
                    rs.getInt("quantity"),
                    rs.getString("status"),
                    rs.getString("product_description")
                });
            }

            if (!foundData) {
                JOptionPane.showMessageDialog(null, "No records found!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error searching data: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSearchProductActionPerformed

    private void btnShowAllProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllProductActionPerformed
        // TODO add your handling code here:
        loadProductData();
    }//GEN-LAST:event_btnShowAllProductActionPerformed

    private void btnSaveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProductActionPerformed
        // TODO add your handling code here:
        String productName = txtProductName.getText();
        String category = (String) comboBoxProductCategory.getSelectedItem(); // Category Name
        String supplier = (String) comboBoxProductSupplier.getSelectedItem(); // Supplier Name
        String price = txtProductPrice.getText();
        String quantity = txtProductQuantity.getText();
        String description = txtProductDescription.getText();
        String status = (String) comboBoxProductStatus.getSelectedItem(); // Active or Inactive   

        if (validateProductFields("new")) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
        } else {
            try {
                Connection con = ConnectionProvider.getCon();
// ✅ Insert product using category and supplier names directly
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO product ( category_name, supplier_name,product_name, price, quantity,  status,product_description) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)"
                );

                ps.setString(1, category);  // ✅ Directly storing category name
                ps.setString(2, supplier);  // ✅ Directly storing supplier name
                ps.setString(3, productName);
                ps.setDouble(4, Double.parseDouble(price));
                ps.setInt(5, Integer.parseInt(quantity));
                ps.setString(6, status);
                ps.setString(7, description);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Product Added Successfully");

                loadProductData(); // Refresh product table after adding
                clearProductFields(); // Clear input fields

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveProductActionPerformed

    private void btnUpdateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProductActionPerformed
        // TODO add your handling code here:
        String productName = txtProductName.getText();
        String category = (String) comboBoxProductCategory.getSelectedItem(); // Category Name
        String supplier = (String) comboBoxProductSupplier.getSelectedItem(); // Supplier Name
        String price = txtProductPrice.getText();
        String quantity = txtProductQuantity.getText();
        String description = txtProductDescription.getText();
        String status = (String) comboBoxProductStatus.getSelectedItem(); // Active or Inactive   

        if (validateProductFields("edit")) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
        } else {
            try {
                Connection con = ConnectionProvider.getCon();
// ✅ Insert product using category and supplier names directly
                PreparedStatement ps = con.prepareStatement(
                        "update product set category_name=?, supplier_name=?, product_name=? , price=?, quantity=?, status=?, product_description=? where product_id=? "
                );
                ps.setString(1, category);  // ✅ Directly storing category name
                ps.setString(2, supplier);  // ✅ Directly storing supplier name
                ps.setString(3, productName);
                 ps.setDouble(4, Double.parseDouble(price));
                ps.setInt(5, Integer.parseInt(quantity));
                ps.setString(6, status);
                ps.setString(7, description);
                ps.setInt(8, ProductID);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Product Updated Successfully");

                loadProductData(); // Refresh product table after adding
                clearProductFields(); // Clear input fields

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateProductActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("Delete from product where product_id=?");
            ps.setInt(1, ProductID);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Product Deleted Successfully!");
              loadProductData(); // Refresh product table after adding
                clearProductFields();
            } else {
                JOptionPane.showMessageDialog(null, "No Product found with this ID.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnClearProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearProductActionPerformed
        // TODO add your handling code here:
        clearProductFields();
    }//GEN-LAST:event_btnClearProductActionPerformed

    //bills
    private void loadsearchBill() {
    String billNo = txtSearchBill.getText().trim(); // Get bill number from text field

    if (billNo.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter a Bill Number!");
        return;
    }

    try {
        Connection con = ConnectionProvider.getCon();
        String query = "SELECT bill_no, customer_name, phone, date, total_amount, discount, net_amount FROM sales WHERE bill_no = ?";
        
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, Integer.parseInt(billNo)); // Convert billNo to Integer
        
        ResultSet rs = pst.executeQuery();
        
        DefaultTableModel model = (DefaultTableModel) tableOrderBill.getModel();
        model.setRowCount(0); // Clear previous search results

        boolean found = false;
        while (rs.next()) {
            found = true;
            Object[] row = {
                rs.getInt("bill_no"),
                rs.getString("date"),
                rs.getDouble("total_amount"),
                rs.getDouble("discount"),
                rs.getDouble("net_amount")
            };
            model.addRow(row);
        }
DefaultTableModel model1 = (DefaultTableModel) tableCustomerBill.getModel();
        model1.setRowCount(0); // Clear previous search results

        boolean found1 = false;
        while (rs.next()) {
            found1 = true;
            Object[] row = {
                rs.getString("customer_name"),
            };
            model1.addRow(row);
        }
        if (!found1) {
            JOptionPane.showMessageDialog(null, "No bill found for Bill No: " + billNo);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid Bill Number! Please enter a valid number.");
    }
}

    private void loadCustomerBillData() {
    try {
        Connection con = ConnectionProvider.getCon();
        String query = "SELECT DISTINCT  customer_name FROM sales"; // Get unique customers
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) tableCustomerBill.getModel();
        model.setRowCount(0); // Clear old data

        while (rs.next()) {
         
            String name = rs.getString("customer_name");

            // Add row to tableCustomerBill
            model.addRow(new Object[]{ name});
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading customer data: " + e.getMessage());
    }
}

    private void loadOrderBillData() {
    try {
        Connection con = ConnectionProvider.getCon();
        String query = "SELECT bill_no, total_amount, net_amount, date FROM sales";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) tableOrderBill.getModel();
        model.setRowCount(0); // Clear old data

        while (rs.next()) {
            int billNumber = rs.getInt("bill_no");
            double totalAmount = rs.getDouble("total_amount");
            double netAmount = rs.getDouble("net_amount");
            String orderDate = rs.getString("date");

            // Add row to tableOrderBill
            model.addRow(new Object[]{billNumber, orderDate, totalAmount, netAmount});
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading order data: " + e.getMessage());
    }
}

    private void btnSearchBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBillActionPerformed
        // TODO add your handling code here:
       loadsearchBill();
       txtSearchBill.setText("");
    }//GEN-LAST:event_btnSearchBillActionPerformed

    private void btnShowAllBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllBillActionPerformed
        // TODO add your handling code here:
        loadCustomerBillData();
        loadOrderBillData();
    }//GEN-LAST:event_btnShowAllBillActionPerformed

    private void lblBackbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackbMouseClicked
        // TODO add your handling code here:
        new Home(userName).setVisible(true); // Open Home Page with Username
        dispose();
    }//GEN-LAST:event_lblBackbMouseClicked

    private void lblBackpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackpMouseClicked
        // TODO add your handling code here:
        new Home(userName).setVisible(true); // Open Home Page with Username
        dispose();
    }//GEN-LAST:event_lblBackpMouseClicked

    private void lblBackpcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackpcMouseClicked
        // TODO add your handling code here:
        new Home(userName).setVisible(true); // Open Home Page with Username
        dispose();
    }//GEN-LAST:event_lblBackpcMouseClicked

    private void lblBackCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackCMouseClicked
        // TODO add your handling code here:
        new Home(userName).setVisible(true); // Open Home Page with Username
        dispose();
    }//GEN-LAST:event_lblBackCMouseClicked

    private void lblBacksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBacksMouseClicked
        // TODO add your handling code here:
        new Home(userName).setVisible(true); // Open Home Page with Username
        dispose();
    }//GEN-LAST:event_lblBacksMouseClicked

    private void lblBackEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackEMouseClicked
        // TODO add your handling code here:
        new Home(userName).setVisible(true); // Open Home Page with Username
        dispose();
    }//GEN-LAST:event_lblBackEMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        loadEmployeeData();
        loadSupplierData();
        loadCustomerData();
        loadCategoryData();
        loadProductData();
    }//GEN-LAST:event_formComponentShown

    private void tableEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmployeeMouseClicked
        // TODO add your handling code here:
        int index = tableEmployee.getSelectedRow(); // Get selected row index
        TableModel model = tableEmployee.getModel();
        String empid = model.getValueAt(index, 0).toString();
        EmployeeID = Integer.parseInt(empid);
        String empName = model.getValueAt(index, 1).toString();
        txtEmployeeName.setText(empName);
        String empEmail = model.getValueAt(index, 2).toString();
        txtEmployeeEmail.setText(empEmail);
        String empGender = model.getValueAt(index, 3).toString();
        comboBoxGender.setSelectedItem(empGender);
        String empDOB = model.getValueAt(index, 4).toString();
        DateDOB.setDate(java.sql.Date.valueOf(empDOB));
        String empContact = model.getValueAt(index, 5).toString();
        txtEmployeeContact.setText(empContact);
        String empType = model.getValueAt(index, 6).toString();
        comboBoxEmployeeType.setSelectedItem(empType);
        String empEducation = model.getValueAt(index, 7).toString();
        comboBoxEducation.setSelectedItem(empEducation);
        String empShift = model.getValueAt(index, 8).toString();
        comboBoxWorkShift.setSelectedItem(empShift);
        String empAddress = model.getValueAt(index, 9).toString();
        txtEmployeeAddress.setText(empAddress);
        String empJoining = model.getValueAt(index, 10).toString();
        DateJoining.setDate(java.sql.Date.valueOf(empJoining));
        String empSalary = model.getValueAt(index, 11).toString();
        txtEmployeeSalary.setText(empSalary);
        String empUserType = model.getValueAt(index, 12).toString();
        comboBoxUserType.setSelectedItem(empUserType);

        txtEmployeePassword.setEditable(false);
        txtEmployeePassword.setBackground(Color.ORANGE);
    }//GEN-LAST:event_tableEmployeeMouseClicked

    private void tableSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSupplierMouseClicked
        // TODO add your handling code here:
        int index = tableSupplier.getSelectedRow(); // Get selected row index
        TableModel model = tableSupplier.getModel();
        String supid = model.getValueAt(index, 0).toString();
        SupplierID = Integer.parseInt(supid);
        String invoiceNo = model.getValueAt(index, 1).toString();
        txtInvoiceNumber.setText(invoiceNo);
        String supName = model.getValueAt(index, 2).toString();
        txtSupplierName.setText(supName);
        String supContact = model.getValueAt(index, 3).toString();
        txtSupplierContact.setText(supContact);
        String supDescription = model.getValueAt(index, 4).toString();
        txtSupplierDescription.setText(supDescription);


    }//GEN-LAST:event_tableSupplierMouseClicked

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
        // TODO add your handling code here:
     
        
        int index = tableCustomer.getSelectedRow();

// ✅ Ensure a row is selected
if (index == -1) {
    JOptionPane.showMessageDialog(null, "Please select a customer from the table!");
    return;
}

try {
    TableModel model = tableCustomer.getModel();

    // ✅ Ensure row index is within bounds
    if (index >= model.getRowCount()) {
        JOptionPane.showMessageDialog(null, "Invalid row selection!");
        return;
    }

    // ✅ Retrieve values safely, handling potential null values
    String id = model.getValueAt(index, 0) != null ? model.getValueAt(index, 0).toString() : "0";
    CustomerID = Integer.parseInt(id);

    String customerName = model.getValueAt(index, 1) != null ? model.getValueAt(index, 1).toString() : "";
    txtCustomerName.setText(customerName);

    String customerContact = model.getValueAt(index, 2) != null ? model.getValueAt(index, 2).toString() : "";
    txtCustomerContact.setText(customerContact);

    String customerEmail = model.getValueAt(index, 3) != null ? model.getValueAt(index, 3).toString() : "";
    txtCustomerEmail.setText(customerEmail);

    if (customerName.trim().isEmpty()) {
        return;
    }

    Connection con = ConnectionProvider.getCon();

    // ✅ Query to fetch order count, total spent, and last order date
    String query = "SELECT COUNT(order_id) AS order_count, " +
                   "COALESCE(SUM(total_amount), 0) AS total_spent, " +
                   "COALESCE(MAX(order_date), '-') AS last_order_date " +
                   "FROM orders WHERE customer_id = ?";

    PreparedStatement pst = con.prepareStatement(query);
    pst.setInt(1, CustomerID);
    ResultSet rs = pst.executeQuery();

    int orderCount = 0;
    double totalSpent = 0;
    String lastOrderDate = "-";

    if (rs.next()) {
        orderCount = rs.getInt("order_count");
        totalSpent = rs.getDouble("total_spent");
        lastOrderDate = rs.getString("last_order_date") != null ? rs.getString("last_order_date") : "-";
    }

    // ✅ Display results in UI
    lblCount.setText(String.valueOf(orderCount));  
    lblAmount.setText("Rs. " + String.format("%.2f", totalSpent));
    lblLastDate.setText(lastOrderDate);

} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error fetching order details: " + e.getMessage());
} catch (Exception ex) {
    JOptionPane.showMessageDialog(null, "Unexpected error: " + ex.getMessage());
}



    }//GEN-LAST:event_tableCustomerMouseClicked

    private void tableCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCategoryMouseClicked
        // TODO add your handling code here:
        int index = tableCategory.getSelectedRow(); // Get selected row index
        TableModel model = tableCategory.getModel();
        String catid = model.getValueAt(index, 0).toString();
        CategoryID = Integer.parseInt(catid);
        String catName = model.getValueAt(index, 1).toString();
        txtCategoryName.setText(catName);
        String catDescription = model.getValueAt(index, 2).toString();
        txtCategoryDescription.setText(catDescription);
    }//GEN-LAST:event_tableCategoryMouseClicked

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        // TODO add your handling code here:
        int index = tableProduct.getSelectedRow();
        TableModel model = tableProduct.getModel();
        String id = model.getValueAt(index, 0).toString();
        ProductID = Integer.parseInt(id);
        comboBoxProductCategory.removeAllItems();
        String categoryName = model.getValueAt(index, 1).toString();
        comboBoxProductCategory.addItem(categoryName);
        getAllProductCategory();

        comboBoxProductSupplier.removeAllItems();
        String supplierName = model.getValueAt(index, 2).toString();
        comboBoxProductSupplier.addItem(supplierName);
        getAllSupplier();

        String productname = model.getValueAt(index, 3).toString();
        txtProductName.setText(productname);
        String productprice = model.getValueAt(index, 4).toString();
        txtProductPrice.setText(productprice);
        String productquantity = model.getValueAt(index, 5).toString();
        totalQuantity = 0;
        lblQuantity.setText("Add Quantity");
        totalQuantity = Integer.parseInt(productquantity);

        String status = model.getValueAt(index, 6).toString();
        comboBoxProductStatus.removeAllItems();
        if (status.equals("Active")) {
            comboBoxProductStatus.addItem("Active");
            comboBoxProductStatus.addItem("InActive");
        } else {
            comboBoxProductStatus.addItem("InActive");
            comboBoxProductStatus.addItem("Active");
        }

        String productdescription = model.getValueAt(index, 7).toString();
        txtProductDescription.setText(productdescription);


    }//GEN-LAST:event_tableProductMouseClicked

    private void tableCustomerBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerBillMouseClicked
        // TODO add your handling code here:
        int index = tableCustomerBill.getSelectedRow();
    if (index == -1) {
        return; // No row selected
    }

    DefaultTableModel model = (DefaultTableModel) tableCustomerBill.getModel();
    int customerId = Integer.parseInt(model.getValueAt(index, 0).toString()); // Get selected customer's ID

    try {
        Connection con = ConnectionProvider.getCon();
        String query = "SELECT bill_no,  total_amount, net_amount, date FROM sales WHERE customer_id = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, customerId); // Filter orders by customer ID
        ResultSet rs = pst.executeQuery();

        DefaultTableModel orderModel = (DefaultTableModel) tableOrderBill.getModel();
        orderModel.setRowCount(0); // Clear previous bills

        while (rs.next()) {
            int billNumber = rs.getInt("bill_number");
               String orderDate = rs.getString("order_date");  
               double totalAmount = rs.getDouble("total_amount");
            double netAmount = rs.getDouble("net_amount");
       

            // Add row to tableOrderBill
            orderModel.addRow(new Object[]{billNumber, orderDate, totalAmount, netAmount});
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading customer orders: " + e.getMessage());
    }
    }//GEN-LAST:event_tableCustomerBillMouseClicked

    private void tableOrderBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOrderBillMouseClicked
        // TODO add your handling code here:
        
int index = tableOrderBill.getSelectedRow();
TableModel model = tableOrderBill.getModel();
String billNumber = model.getValueAt(index, 0).toString();

try {
    Connection con = ConnectionProvider.getCon();
    String query = "SELECT bill_details FROM sales WHERE bill_no = ?";
    PreparedStatement pst = con.prepareStatement(query);
    pst.setString(1, billNumber);
    ResultSet rs = pst.executeQuery();

    if (rs.next()) {
        String billContent = rs.getString("bill_details");
        txtCustomerBillArea.setText(billContent); // ✅ Show bill in TextArea
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error fetching bill details: " + e.getMessage());
}

    }//GEN-LAST:event_tableOrderBillMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateDOB;
    private com.toedter.calendar.JDateChooser DateJoining;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JButton btnCategory;
    private javax.swing.JButton btnClearCategory;
    private javax.swing.JButton btnClearCustomer;
    private javax.swing.JButton btnClearEmployee;
    private javax.swing.JButton btnClearProduct;
    private javax.swing.JButton btnClearSupplier;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnDeleteCategory;
    private javax.swing.JButton btnDeleteCustomer;
    private javax.swing.JButton btnDeleteEmployee;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnDeleteSupplier;
    private javax.swing.JButton btnEmployee;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProduct;
    private javax.swing.JButton btnSales;
    private javax.swing.JButton btnSaveCategory;
    private javax.swing.JButton btnSaveCustomer;
    private javax.swing.JButton btnSaveEmployee;
    private javax.swing.JButton btnSaveProduct;
    private javax.swing.JButton btnSaveSupplier;
    private javax.swing.JButton btnSearchBill;
    private javax.swing.JButton btnSearchCustomer;
    private javax.swing.JButton btnSearchEmployee;
    private javax.swing.JButton btnSearchProduct;
    private javax.swing.JButton btnSearchSupplier;
    private javax.swing.JButton btnShowAllBill;
    private javax.swing.JButton btnShowAllCustomer;
    private javax.swing.JButton btnShowAllEmployee;
    private javax.swing.JButton btnShowAllProduct;
    private javax.swing.JButton btnShowAllSupplier;
    private javax.swing.JButton btnSuplier;
    private javax.swing.JButton btnUpdateCategory;
    private javax.swing.JButton btnUpdateCustomer;
    private javax.swing.JButton btnUpdateEmployee;
    private javax.swing.JButton btnUpdateProduct;
    private javax.swing.JButton btnUpdateSupplier;
    private javax.swing.JComboBox<String> comboBoxEducation;
    private javax.swing.JComboBox<String> comboBoxEmployeeType;
    private javax.swing.JComboBox<String> comboBoxGender;
    private javax.swing.JComboBox<String> comboBoxProductCategory;
    private javax.swing.JComboBox<String> comboBoxProductStatus;
    private javax.swing.JComboBox<String> comboBoxProductSupplier;
    private javax.swing.JComboBox<String> comboBoxSelectCustomer;
    private javax.swing.JComboBox<String> comboBoxSelectEmployee;
    private javax.swing.JComboBox<String> comboBoxSelectProduct;
    private javax.swing.JComboBox<String> comboBoxUserType;
    private javax.swing.JComboBox<String> comboBoxWorkShift;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lableEmploye;
    private javax.swing.JLabel lableEmploye1;
    private javax.swing.JLabel lableEmploye2;
    private javax.swing.JLabel lableEmploye3;
    private javax.swing.JLabel lableEmploye4;
    private javax.swing.JLabel lableEmploye5;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblBackC;
    private javax.swing.JLabel lblBackE;
    private javax.swing.JLabel lblBackb;
    private javax.swing.JLabel lblBackp;
    private javax.swing.JLabel lblBackpc;
    private javax.swing.JLabel lblBacks;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblLastDate;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTotalCategory;
    private javax.swing.JLabel lblTotalCustomer;
    private javax.swing.JLabel lblTotalEmployee;
    private javax.swing.JLabel lblTotalProduct;
    private javax.swing.JLabel lblTotalSale;
    private javax.swing.JLabel lblTotalSupplier;
    private javax.swing.JLabel lblWelcomeName;
    private javax.swing.JTable tableCategory;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTable tableCustomerBill;
    private javax.swing.JTable tableEmployee;
    private javax.swing.JTable tableOrderBill;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTable tableSupplier;
    private javax.swing.JTextArea txtCategoryDescription;
    private javax.swing.JTextField txtCategoryName;
    private javax.swing.JTextArea txtCustomerBillArea;
    private javax.swing.JTextField txtCustomerContact;
    private javax.swing.JTextField txtCustomerEmail;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextArea txtEmployeeAddress;
    private javax.swing.JTextField txtEmployeeContact;
    private javax.swing.JTextField txtEmployeeEmail;
    private javax.swing.JTextField txtEmployeeName;
    private javax.swing.JPasswordField txtEmployeePassword;
    private javax.swing.JTextField txtEmployeeSalary;
    private javax.swing.JTextField txtInvoiceNumber;
    private javax.swing.JTextArea txtProductDescription;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtProductQuantity;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchBill;
    private javax.swing.JTextField txtSearchCustomer;
    private javax.swing.JTextField txtSearchInvoiceNo;
    private javax.swing.JTextField txtSearchProduct;
    private javax.swing.JTextField txtSupplierContact;
    private javax.swing.JTextArea txtSupplierDescription;
    private javax.swing.JTextField txtSupplierName;
    // End of variables declaration//GEN-END:variables
}
