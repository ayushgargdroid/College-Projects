package dbsproject;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;







public class first extends JFrame implements ActionListener, KeyListener{
    JLabel custitle, name, address, phone, account_no, gender;
    JTextField t1,t2,t3,t4,t5;
    JButton sub,can,back;
     
    public first()
    {
        custitle=new JLabel("Customer form");
        add(custitle);
        custitle.setBounds(200,10,150,25);
        
        
        name= new JLabel("Name");
        add(name);
        name.setBounds(10,40,150,25);
        
        t1=new JTextField("");
        add(t1);
        t1.setBounds(100,40,400,25);
        
        address= new JLabel("Address");
        add(address);
        address.setBounds(10,70,150,25);
        
        t2=new JTextField("");
        add(t2);
        t2.setBounds(100,70,400,25);
        
        phone= new JLabel("Phone no.");
        add(phone);
        phone.setBounds(10,100,150,25);
        
         t2=new JTextField("");
        add(t2);
        t2.setBounds(100,100,400,25);
        
        account_no= new JLabel("Account no.");
        add(account_no);
        account_no.setBounds(10,130,150,25);
        
         t2=new JTextField("");
        add(t2);
        t2.setBounds(100,130,400,25);
        sub=new JButton("Submit");
        add(sub);
        sub.setBounds(100,160,100,25);
        sub.addActionListener(this);
        
        back=new JButton("Back");
        add(back);
        back.setBounds(100,190,100,25);
                        back.addActionListener(this);

             

        
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
        new first();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
     if(ae.getSource()==back)
     {
         new DBSproject();
     }
     if(ae.getSource()==sub)
     {
         System.out.println("sGSGSGS");
         String drivername = "oracle.jdbc.driver.OracleDriver";
         try {
             Class.forName(drivername);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
         }
               String servername = "MIT-STD-HY5";
        String serverport = "1521";
        String sid = "XE";
        String url = "jdbc:oracle:thin:@"+servername+":"+serverport+":"+sid;
        String username="system";
        String password="dragonnite";
         try {
             Connection con = DriverManager.getConnection(url,username,password);
             System.out.println("Connection Successful");
              Statement stmt = con.createStatement();
              String sql = "INSERT INTO Customer " +
                   "VALUES('Zara',9535010359,1234,'manipal')";
               stmt.executeUpdate(sql);
               System.out.println("Done Enter");
              
         } catch (SQLException ex) {
             Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
         }
            
     }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
    

