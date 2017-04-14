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
import java.sql.*;
import java.util.Random;
import static javax.swing.JFrame.EXIT_ON_CLOSE;







public class signup extends JFrame implements ActionListener{
    
    JButton sub,back;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    JLabel l1,l2,l3,l4,l5,l6;
    JComboBox cb;
    
    String address="",ssn="";
    
    public signup()
    {
        this.setTitle("Banking Databse");
        Random r = new Random();
        ssn = Integer.toString(r.nextInt(9999-1000+1)+1000);
        
        l1=new JLabel("Name");
        add(l1);
        l1.setBounds(80,60,100,25);
        
        t1=new JTextField("");
        add(t1);
        t1.setBounds(180,60,400,25);
        
        l2=new JLabel("Phone no.");
        add(l2);
        l2.setBounds(80,100,100,25);
        
        t2=new JTextField("");
        add(t2);
        t2.setBounds(180,100,400,25);
        
        l3=new JLabel("SSN");
        add(l3);
        l3.setBounds(80,140,100,25);
        
        t3=new JTextField("");
        t3.setText(ssn);
        t3.setEditable(false);
        add(t3);
        t3.setBounds(180,140,400,25);
        
        l4=new JLabel("Address");
        add(l4);
        l4.setBounds(80,180,100,25);
        
        t4=new JTextField("House no./Flat No.");
        add(t4);
        t4.setBounds(180,180,400,25);
        
        t5=new JTextField("Street");
        add(t5);
        t5.setBounds(180,220,400,25);
        
        t6=new JTextField("City");
        add(t6);
        t6.setBounds(180,260,400,25);
        
        t7=new JTextField("State");
        add(t7);
        t7.setBounds(180,300,400,25);
        
        t8=new JTextField("Country");
        add(t8);
        t8.setBounds(180,340,400,25);
        
        t9=new JTextField("Pin Code");
        add(t9);
        t9.setBounds(180,380,400,25);
        
        l6 = new JLabel("Branch Code");
        add(l6);
        l6.setBounds(80,420,100,25);
        
        String t2[]={"1" ,
                     "2" ,
                     "3" ,
                     "4" ,
                     "5"};        
        cb=new JComboBox(t2);    
        cb.setBounds(180,420,400,25);
        add(cb);
        
        sub=new JButton("Submit");
        add(sub);
        sub.setBounds(180,460,200,25);
        sub.addActionListener(this);
        
        back=new JButton("Back");
        add(back);
        back.setBounds(381,460,200,25);
        back.addActionListener(this);
        
        l5 = new JLabel("");
        add(l5);
        l5.setBounds(180,500,400,25);
        l5.setForeground(Color.RED);
        
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
        new signup();
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
    
    public boolean checkAuth()
    {
        String name = t1.getText();
        String phone = t2.getText();
        String ssn = t3.getText();
        String address1 = t4.getText();
        String address2 = t5.getText();
        String address3 = t6.getText();
        String address4 = t7.getText();
        String address5 = t8.getText();
        String address6 = t9.getText();
        
        if(name.isEmpty() || phone.isEmpty() || ssn.isEmpty() || address1.isEmpty() || address2.isEmpty() || address3.isEmpty() || address4.isEmpty() || address5.isEmpty() || address6.isEmpty())
        {
            l5.setText("All fields are mandatory.");
            return false;
        }
        
        if(!checkNumbers(phone))
        {
            l5.setText("Phone no. should only contain digits");
            return false;
        }
        
        if(!checkNumbers(ssn))
        {
            l5.setText("SSN should only contain digits");
            return false;
        }
        
        if(ssn.length()!=4)
        {
            l5.setText("SSN should contain 4 digits.");
            return false;
        }
        
        if(phone.length()<10)
        {
            l5.setText("Please enter a valid phone number.");
            return false;
        }
        
        if(!checkAlph(name))   
        {
            l5.setText("Name should not contain digits.");
            return false;
        }
        
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==sub)
        {
            if(!checkAuth())
            {
                System.out.println("Something's wrongly entered");
            }
            else
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
                String password="Vostro200";
                try {
                    Connection con = DriverManager.getConnection(url,username,password);
                    System.out.println("Connection Successful");
                    Statement stmt = con.createStatement();
                    address =  t4.getText() + "," + t5.getText() + "," + t6.getText() + "," + t7.getText() + "," + t8.getText() + "," + t9.getText();
                    java.sql.Timestamp times = new java.sql.Timestamp(System.currentTimeMillis());
                    String sql = "insert into customer values ('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+address+"',TO_TIMESTAMP('"+times.toString()+"','yyyy-mm-dd hh24:mi:ss.ff3'),'"+cb.getSelectedItem().toString()+"')";
                    System.out.println(sql);
                    stmt.executeUpdate(sql);
                    System.out.println("Customer Added");
                    new initial();
                    this.dispose();

                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                    if(ex.toString().contains("7035"))
                    {
                        l5.setText("Sorry, this SSN has already been taken. Please try again.");
                    }
                    else if(ex.toString().contains("7036"))
                    {
                        l5.setText("You already have an account.");
                    }
                    Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
        if(ae.getSource()==back)
        {
            this.dispose();
            new DBSproject();
        }
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}