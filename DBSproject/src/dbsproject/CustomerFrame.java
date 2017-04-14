package dbsproject;
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
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 *
 * @author ayushgarg
 */
public class CustomerFrame extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form CustomerFrame
     */
    
    JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6,jLabel7,jLabel8,jLabel9,jLabel10,jLabel11,jLabel12,jLabel13,jLabel14,jLabel15,jLabel16;
    JTabbedPane jTabbedPane1,jTabbedPane2;
    JScrollPane jScrollPane1,jScrollPane2;
    JTable jTable1,jTable2;
    JButton jButton1,jButton2;
    
    String name,ssn,phone,branch;
    String address[] = new String[6];
    java.sql.Timestamp up;
    java.sql.Timestamp times;
    Object accountData[][],loanData[][];
    Double totAmt,totBal;
    
    public CustomerFrame(String y,java.sql.Timestamp a) {
        up = a;
        ssn = y;
        totAmt = totBal = 0.0;
        initComponents();
    }
    
    public CustomerFrame(String y) {
        ssn = y;
        up = null;
        totAmt = totBal = 0.0;
        initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Banking Databse");
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton("New Account");
        jButton2 = new javax.swing.JButton("New Loan");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        queryEngine();

        jLabel1.setText("Good Morning,");

        jLabel2.setText(name);

        jLabel3.setText("SSN: "+ssn);

        jLabel4.setText("Address: ");

        jLabel5.setText(address[0]);

        jLabel6.setText(address[1]);

        jLabel7.setText(address[2]);

        jLabel8.setText(address[3]);

        jLabel9.setText(address[4]);

        jLabel10.setText("Phone no:"+phone);

        jLabel11.setText("Pin Code: "+address[5]);
        
        

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            accountData,
            new String [] {
                "Account No.", "Type", "DOC", "Balance"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Accounts", jScrollPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            loanData,
            new String [] {
                "Loan ID", "Type", "DOC", "Amount"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane1.addTab("Loans", jScrollPane2);

        jLabel12.setText("Total Balance: "+totBal);

        jLabel13.setText("Total Loan: "+totAmt);

        jLabel14.setText("Last Login Date:");

        jLabel15.setText(times.toString());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16,javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel12)
                .addGap(74, 74, 74)
                .addComponent(jLabel13)
                .addContainerGap(174, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        pack();
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        
        /* Create and display the form */
        
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
            String sql = "select name,phone,address,logindate,branch from customer where ssn="+ssn;
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                name = rs.getString("name");
                phone = rs.getString("phone");
                branch = rs.getString("branch");
                jLabel16.setText("Branch Code: "+branch);
                String tempAddress = rs.getString("address");
                StringTokenizer st = new StringTokenizer(tempAddress,",");
                int c = st.countTokens();
                for(int i=0;i<c;i++)
                {
                    address[i] = st.nextToken();
                }
                times = rs.getTimestamp("logindate");
                if(up!=null)
                {
                    rs.updateTimestamp("logindate", up);
                    rs.updateRow();
                }
            }
            rs.close();
            sql = "select account_type,account_no,balance,DOC from account where ssn="+ssn+" order by balance desc";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            System.out.println("Executed account query");
            int rows = 0;
            while(rs.next())
            {
                rows++;
            }
            rs.close();
            accountData = new Object[rows][4];
            for(int i=0;i<rows;i++)
            {
                for(int j=0;j<4;j++)
                    accountData[i][j] = null;
            }
            rs = stmt.executeQuery(sql);
            int k = 0;
            System.out.println("Got the no. of rows for account"+rows);
            while(rs.next() && k<rows)
            {
                accountData[k][0] = rs.getString("account_no");
                accountData[k][1] = rs.getString("account_type");
                accountData[k][2] = rs.getDate("DOC").toString();
                accountData[k][3] = rs.getDouble("balance");
                k++;
            }
            rs.close();
            sql = "select loan_type,loan_id,amount,DOC from loan where ssn="+ssn+" order by amount desc";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            rows = 0;
            System.out.println("Executed loan query");
            while(rs.next())
            {
                rows++;
            }
            rs.close();
            loanData = new Object[rows][4];
            for(int i=0;i<rows;i++)
            {
                for(int j=0;j<4;j++)
                    loanData[i][j] = null;
            }
            rs = stmt.executeQuery(sql);
            k = 0;
            System.out.println("Got the no. of rows for loan"+rows);
            while(rs.next() && k<rows)
            {
                loanData[k][0] = rs.getString("loan_id");
                loanData[k][1] = rs.getString("loan_type");
                loanData[k][2] = rs.getDate("DOC").toString();
                loanData[k][3] = rs.getDouble("amount");
                k++;
            }
            rs.close();
            sql = "select sum(balance) totBal from account where ssn="+ssn;
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                totBal = rs.getDouble("totBal");
            }
            sql = "select sum(amount) totAmt from loan where ssn="+ssn;
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                totAmt = rs.getDouble("totAmt");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==jButton1)
        {
            this.dispose();
            new Account(ssn,branch);
        }
        else if(e.getSource()==jButton2)
        {
            this.dispose();
            new Loan(ssn,branch);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
                   
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

