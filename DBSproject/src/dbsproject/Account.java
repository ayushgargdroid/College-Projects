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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;







public class Account extends JFrame implements ActionListener, KeyListener{
    
    JLabel custitle, ssn,account_type, address, phone, account_no, gender,error,jLabel1;
    JTextField t1,t3,t4,t5;
    JButton sub,can,back;
    String sssn,type,bal,accNo,branch;
    int iStaff = 0;
    String staffName[],staffSSN[];
    JComboBox cb,cb1; 
    
    public Account(String x,String y)
    {
        this.setTitle("Banking Databse");
        Random r = new Random();
        sssn = x;
        branch = y;
        queryEngine();
        custitle=new JLabel("Customer form");
        add(custitle);
        custitle.setBounds(200,10,150,25);
        
        String t2[]={"CURRENT" ,
                     "Saving" ,
                     "RECURRING" ,
                     "FIXED"};        
        cb=new JComboBox(t2);    
        cb.setBounds(100,80,400,25);
        add(cb);
    
        
        ssn= new JLabel("SSN");
        add(ssn);
        ssn.setBounds(10,40,150,25);
        
        t1=new JTextField("");
        t1.setEditable(false);
        add(t1);
        t1.setBounds(100,40,400,25);
        t1.setText(sssn);
        
        account_type=new JLabel("Account type");
        add(account_type);
        account_type.setBounds(10,80,150,25);
       
        phone= new JLabel("Account no.");
        add(phone);
        phone.setBounds(10,120,120,25);
        
        t3=new JTextField("");
        t3.setText(Integer.toString(r.nextInt(999999999-100000000+1)+100000000));
        t3.setEditable(false);
        add(t3);
        t3.setBounds(100,120,400,25);
        
        account_no= new JLabel("Balance");
        add(account_no);
        account_no.setBounds(10,160,150,25);
        
        t4=new JTextField("");
        add(t4);
        t4.setBounds(100,160,400,25);
        
        jLabel1= new JLabel("Staff Mem.");
        add(jLabel1);
        jLabel1.setBounds(10,200,150,25);
        
        cb1=new JComboBox(staffName);    
        cb1.setBounds(100,200,400,25);    
        add(cb1);  
        
        
        sub=new JButton("Submit");
        add(sub);
        sub.setBounds(100,240,100,25);
        sub.addActionListener(this);
        
        back=new JButton("Back");
        add(back);
        back.setBounds(250,240,100,25);
        back.addActionListener(this);
        
        error= new JLabel("");
        error.setForeground(Color.red);
        add(error);
        error.setBounds(100,400,150,25);
        
        setLayout(null);
        setSize(600,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    private void queryEngine()
    {
        String drivername = "oracle.jdbc.driver.OracleDriver";
        try {
            Class.forName(drivername);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("QueryEngine");
        String servername = "ayushgarg-HP-ProBook-440-G2";
        String serverport = "9001";
        String sid = "XE";
        String url = "jdbc:oracle:thin:@"+servername+":"+serverport+":"+sid;
        String username="system";
        String password="Vostro200";
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Successful");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql = "select count(EID) c from staff where branch="+branch;  
            ResultSet rs = stmt.executeQuery(sql);
            int rows = 0;
            while(rs.next())
            {
                rows = rs.getInt("c");
            }
            System.out.println(rows);
            staffName = new String[rows];
            staffSSN = new String[rows];
            sql = "select name,EID from staff where branch="+branch;
            rs = stmt.executeQuery(sql);
            int i=0;
            while(rs.next() && i<rows)
            {
                staffName[i] = rs.getString("name");
                staffSSN[i] = rs.getString("EID");
                i++;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
    public boolean checkNumbers(String s)
    {
        for(char c:s.toCharArray())
        {
            if(!Character.isDigit(c))
                if(c!='.')
                    return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back)
        {
            this.dispose();
            new CustomerFrame(sssn);
        }
        if(ae.getSource()==sub)
        {
            if(checkNumbers(t4.getText()))
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
                        accNo = t3.getText();
                        bal = t4.getText();
                        type = cb.getSelectedItem().toString();
                        iStaff = cb1.getSelectedIndex();
                        Connection con = DriverManager.getConnection(url,username,password);
                        System.out.println("Connection Successful");
                        Statement stmt = con.createStatement();
                        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
                        String sql = "insert into account values ('"+sssn+"','"+type+"','"+accNo+"',"+bal+",DATE '"+date.toString()+"','"+branch+"','"+staffSSN[iStaff]+"')";
                        System.out.println(sql);
                        stmt.executeUpdate(sql);
                        System.out.println("Account Added");
                        this.dispose();
                        new CustomerFrame(sssn);

                    } 
                catch (SQLException ex) {
                        Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            else
                error.setText("Amount should not contain alphabets.");
            
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
    

