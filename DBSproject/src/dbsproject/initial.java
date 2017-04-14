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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class initial extends JFrame implements ActionListener{
    
    JButton b5,back;
    JLabel user,pw,errorMsg;
    JTextField t1,t2;
    
    public initial()
    {
        this.setTitle("Banking Databse");
        user=new JLabel("User name");
        add(user);
        user.setBounds(80,100,400,25);
        
        t1=new JTextField("");
        add(t1);
        t1.setBounds(220,100,200,25);
        
        
        pw=new JLabel("Password");
        add(pw);
        pw.setBounds(80,130,400,25);
        
        
        t2=new JTextField("");
        add(t2);
        t2.setBounds(220,130,200,25);
        
        b5=new JButton("Login");
        add(b5);
        b5.setBounds(100,230,200,25);
        b5.addActionListener(this);
        
        back=new JButton("Back");
        add(back);
        back.setBounds(301,230,200,25);
        back.addActionListener(this);
        
        errorMsg=new JLabel("");
        add(errorMsg);
        errorMsg.setBounds(100,270,400,25);
        errorMsg.setForeground(Color.RED);
        
        setLayout(null);
        setSize(600,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new initial();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==b5)
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
                Statement stmt = con.createStatement();
                String sql = "select name,ssn from customer";
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next())
                {
                    String name = rs.getString("name");
                    String ssn = rs.getString("ssn");
                    if(t1.getText().equals(name) && t2.getText().equals(ssn)){
                        System.out.println("Welcome Customer");
                        java.sql.Timestamp times = new java.sql.Timestamp(System.currentTimeMillis());  
                        this.dispose();
                        new CustomerFrame(ssn,times);
                    }
                }
                rs.close();
                sql = "select name,EID,designation,branch from staff";
                rs = stmt.executeQuery(sql);
                while(rs.next())
                {
                    String EID = rs.getString("EID");
                    String name = rs.getString("name");
                    String branch = rs.getString("branch");
                    System.out.println(name);
                    if(t1.getText().equals(name) && t2.getText().equals(EID))
                    {
                        System.out.println("Welcome Staff Member");
                        java.sql.Timestamp times = new java.sql.Timestamp(System.currentTimeMillis());
                        this.dispose();
                        new BranchManagerFrame(EID,branch,times);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
            }
            errorMsg.setText("Invalid Credentials.");
        }
        
        if(ae.getSource()==back)
        {
            this.dispose();
            new DBSproject();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
