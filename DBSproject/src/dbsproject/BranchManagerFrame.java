/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbsproject;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 *
 * @author ayushgarg
 */
public class BranchManagerFrame extends javax.swing.JFrame implements ActionListener
{
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    
    String name,EID,designation,branch,q1,q2,q3,q4,q5,q6,q7,q8,q9,q10;
    java.sql.Timestamp up;
    java.sql.Timestamp times;
    Object customerData[][],staffData[][];
    String staffName[],staffEID[],custName[],custSSN[];
    
    BranchManagerFrame(String EID,String branch)
    {
        this.branch = branch;
        this.EID = EID;
        up = null;
        initComponents();
    }
    BranchManagerFrame(String EID,String branch,java.sql.Timestamp x)
    {
        this.branch = branch;
        up = x;
        this.EID = EID;
        initComponents();
    }
    
    private void initComponents() {
        Random r = new Random();
        this.setTitle("Banking Databse");
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel("Designation");
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        
        queryEngine();
        
        jLabel16.setText("EID: "+EID);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            customerData,
            new String [] {
                "SSN", "Name", "Phone", "Address"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            staffData,
            new String [] {
                "EID", "Name", "Designation", "Phone"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Good Morning,");

        jLabel11.setText("Mr. "+name);

        jLabel12.setText(designation);

        jLabel13.setText("Last login: "+times.toString().substring(0,19));

        jLabel14.setText("Branch: "+branch);

        jTabbedPane2.addTab("Customers", jScrollPane1);

        jTabbedPane2.addTab("Staff", jScrollPane2);

        jLabel15.setText("Total No. of employees: "+q1);

        jLabel17.setText("Toatl No. of Customers: "+q2);

        jLabel18.setText("Total Amount in Accounts: "+q3);

        jLabel19.setText("Total Amount in Loans: "+q4);

        jLabel20.setText("No. of Accounts opened: "+q5);

        jLabel21.setText("No. of Accounts opened today: "+q6);

        jLabel22.setText("No. of Loans issued: "+q7);

        jLabel23.setText("No. of Loans issued today: "+q8);

        jLabel2.setText("No. of Accounts opened by you: "+q9);

        jLabel3.setText("No. of loans issued by you: "+q10);
        
        jLabel9.setForeground(Color.red);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Details", jPanel3);

        jLabel4.setText("Name");

        jLabel5.setText("EID");

        jTextField2.setText("jTextField2");
        jTextField2.setText(Integer.toString(r.nextInt(999999999-100000000+1)+100000000));
        jTextField2.setEditable(false);

        jLabel6.setText("Phone no.");

        jButton1.setText("Add");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel9)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add a Staff Member", jPanel1);

        jLabel7.setText("Name ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(staffName));

        jButton2.setText("Delete");
        

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(255, 255, 255))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Delete a Staff Member", jPanel2);

        jLabel8.setText("Name");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(custName));

        jButton3.setText("Delete");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel8)
                .addGap(42, 42, 42)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(245, 245, 245))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Delete a Customer", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14))
                    .addComponent(jTabbedPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        if(!designation.equals("Sen. Branch Manager"))
        {
            jTabbedPane2.setEnabledAt(3,false);
            jTabbedPane2.setEnabledAt(4,false);
        }
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        pack();
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    public static void main(String args[])
    {
        new BranchManagerFrame("3000000000","3");
    }
    
    private void queryEngine()
    {
        String drivername = "oracle.jdbc.driver.OracleDriver";
        try {
            Class.forName(drivername);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
        }
        String servername = "ayushgarg-HP-ProBook-440-G2";
        String serverport = "9001";
        String sid = "XE";
        String url = "jdbc:oracle:thin:@"+servername+":"+serverport+":"+sid;
        String username="system";
        String password="";
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Successful");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql = "select name,designation,logindate,branch from staff where EID="+EID;
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                name = rs.getString("name");
                designation = rs.getString("designation");
                branch = rs.getString("branch");
                times = rs.getTimestamp("logindate");
                if(up!=null)
                {
                    rs.updateTimestamp("logindate", up);
                    rs.updateRow();
                }
            }
            rs.close();
            sql = "select name,ssn,phone,address from customer where branch="+branch+" order by ssn";
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
            int rows = 0;
            while(rs.next())
            {
                rows++;
            }
            rs.close();
            q2 = Integer.toString(rows);
            customerData = new Object[rows][4];
            for(int i=0;i<rows;i++)
            {
                for(int j=0;j<4;j++)
                    customerData[i][j] = null;
            }
            rs = stmt.executeQuery(sql);
            int k = 0;
            System.out.println("Got the no. of rows for account"+rows);
            while(rs.next() && k<rows)
            {
                customerData[k][0] = rs.getString("ssn");
                customerData[k][1] = rs.getString("name");
                customerData[k][2] = rs.getString("phone");
                customerData[k][3] = rs.getString("address");
                k++;
            }
            System.out.println(sql);
            System.out.println(rows);
            rs.close();
            sql = "select EID,name,designation,phone from staff where branch="+branch+" order by EID";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            rows = 0;
            while(rs.next())
            {
                System.out.println("FGSDHS");
                rows++;
            }
            rs.close();
            q1 = Integer.toString(rows);
            staffData = new Object[rows][4];
            for(int i=0;i<rows;i++)
            {
                for(int j=0;j<4;j++)
                    staffData[i][j] = null;
            }
            rs = stmt.executeQuery(sql);
            k = 0;
            System.out.println("Got the no. of rows for loan"+rows);
            while(rs.next() && k<rows)
            {
                staffData[k][0] = rs.getString("EID");
                staffData[k][1] = rs.getString("name");
                staffData[k][2] = rs.getString("designation");
                staffData[k][3] = rs.getString("phone");
                k++;
            }
            rs.close();
            sql = "select sum(balance) totBal from account where branch="+branch;
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                q3 = Double.toString(rs.getDouble("totBal"));
            }
            sql = "select sum(amount) totAmt from loan where branch="+branch;
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                q4 = Double.toString(rs.getDouble("totAmt"));
            }
            rs.close();
            sql = "select count(account_no) c from account where branch="+branch;
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                q5 = Integer.toString(rs.getInt("c"));
            }
            rs.close();
            sql = "select DOC from account where branch="+branch;
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            int counter = 0;
            java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
            while(rs.next())
            {
                if(rs.getDate("DOC").toString().contains(today.toString()))
                    counter++;
            }
            rs.close();
            q6 = Integer.toString(counter);
            sql = "select DOC from loan where branch="+branch;
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            counter = 0;
            while(rs.next())
            {
                if(rs.getDate("DOC").toString().contains(today.toString()))
                    counter++;
            }
            rs.close();
            q8 = Integer.toString(counter);
            sql = "select count(loan_id) c from loan where branch="+branch;
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                q7 = Integer.toString(rs.getInt("c"));
            }
            rs.close();
            sql = "select count(account_no) c from account where EID="+EID;
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                q9 = Integer.toString(rs.getInt("c"));
            }
            rs.close();
            sql = "select count(loan_id) c from loan where EID="+EID;
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                q10 = Integer.toString(rs.getInt("c"));
            }
            rs.close();
            sql = "select count(EID) c from staff where branch="+branch;
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                rows = rs.getInt("c");
            }
            k = 0;
            staffName = new String[rows];
            staffEID = new String[rows];
            sql = "select name,EID from staff where branch="+branch;
            System.out.println(sql);
            
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                staffName[k] = rs.getString("name");
                staffEID[k]  =rs.getString("EID");
                k++;
            }
            rs.close();
            for(String s:staffName)
                System.out.println(s);
            sql = "select count(ssn) c from customer where branch="+branch;
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                rows = rs.getInt("c");
            }
            k = 0;
            custName = new String[rows];
            custSSN = new String[rows];
            sql = "select name,ssn from customer where branch="+branch;
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                custName[k] = rs.getString("name");
                custSSN[k]  =rs.getString("ssn");
                k++;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean checkAlph(String s)
    {
        for(char c:s.toCharArray())
        {
            if(!Character.isLetter(c))
            {
                if(c!=' ')
                    return false;
            }
        }
        return true;
    }
    
    public boolean checkNumbers(String s)
    {
        for(char c:s.toCharArray())
        {
            if(!Character.isDigit(c))
                return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String drivername = "oracle.jdbc.driver.OracleDriver";
        try {
            Class.forName(drivername);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
        }
        String servername = "ayushgarg-HP-ProBook-440-G2";
        String serverport = "9001";
        String sid = "XE";
        String url = "jdbc:oracle:thin:@"+servername+":"+serverport+":"+sid;
        String username="system";
        String password="";
        if(e.getSource()==jButton1)
        {
            String sName = jTextField1.getText();
            String sEID = jTextField2.getText();
            String sDes = jTextField4.getText();
            String sPhone = jTextField3.getText();
            if(checkNumbers(sPhone) && checkAlph(sName) && sPhone.length()>=10 && sName.length()>=3)
            {
                try {
                    Connection con = DriverManager.getConnection(url,username,password);
                    System.out.println("Connection Successful");
                    Statement stmt = con.createStatement();
                    java.sql.Timestamp times = new java.sql.Timestamp(System.currentTimeMillis());
                    String sql = "insert into staff values ('"+sName+"','"+sDes+"','"+sPhone+"','"+sEID+"','"+branch+"',TO_TIMESTAMP('"+times.toString()+"','yyyy-mm-dd hh24:mi:ss.ff3'))";
                    System.out.println(sql);
                    stmt.executeUpdate(sql);
                    System.out.println("Staff Added");
                    jLabel9.setText("Staff Added.");
                    new BranchManagerFrame(EID,branch);

                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                    if(ex.toString().contains("7035"))
                    {
                        jLabel9.setText("Sorry, this SSN has already been taken. Please try again.");
                    }
                    Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                jLabel9.setText("Invalid input. Please, try again.");
        }
        if(e.getSource()==jButton2)
        {
            int iStaff = jComboBox1.getSelectedIndex();
            try {
                Connection con = DriverManager.getConnection(url,username,password);
                System.out.println("Connection Successful");
                Statement stmt = con.createStatement();
                String sql = "delete from staff where EID="+staffEID[iStaff];
                System.out.println(sql);
                stmt.executeUpdate(sql);
                System.out.println("Staff Deleted");
                jLabel9.setText("Staff Deleted.");
                this.dispose();
                new BranchManagerFrame(EID,branch);
                
            } 
            catch (SQLException ex) {
                System.out.println(ex.toString());
                if(ex.toString().contains("7035"))
                {
                    jLabel9.setText("Sorry, this SSN has already been taken. Please try again.");
                }
                Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(e.getSource()==jButton3)
        {
            int iCust = jComboBox2.getSelectedIndex();
            try {
                Connection con = DriverManager.getConnection(url,username,password);
                System.out.println("Connection Successful");
                Statement stmt = con.createStatement();
                String sql = "delete from customer where ssn="+custSSN[iCust];
                System.out.println(sql);
                stmt.executeUpdate(sql);
                System.out.println("Customer Deleted");
                jLabel9.setText("Customer Deleted.");
                this.dispose();
                new BranchManagerFrame(EID,branch);
            } 
            catch (SQLException ex) {
                System.out.println(ex.toString());
                if(ex.toString().contains("7035"))
                {
                    jLabel9.setText("Sorry, this SSN has already been taken. Please try again.");
                }
                Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
