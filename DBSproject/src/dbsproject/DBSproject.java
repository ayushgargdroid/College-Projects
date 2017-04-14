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







public class DBSproject extends JFrame implements ActionListener{
    
    JButton log,sign;
    public DBSproject()
    {
        this.setTitle("Banking Databse");
        log=new JButton("Log in");
        add(log);
        log.setBounds(80,100,400,25);
        log.addActionListener(this);
        
        sign=new JButton("Sign up");
        add(sign);
        sign.setBounds(80,200,400,25);
        sign.addActionListener(this);
        
        
        
        
        
        
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
        new DBSproject();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==log){
            this.dispose();
            new initial();
        }
        
        if(ae.getSource()==sign){
            this.dispose();
            new signup();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}