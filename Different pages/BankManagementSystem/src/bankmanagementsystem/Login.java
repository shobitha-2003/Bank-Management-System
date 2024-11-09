package bankmanagementsystem;

import javax.swing.*;  //* means all the package of swing is imported
import java.awt.*;   //to import image 
import java.awt.event.*;   //actionlistener
import java.sql.*; //Resultset is present

public class Login extends JFrame implements ActionListener {   //JFrame class of string it is imported using swing package
                                                                //implements ActionListener is used to login,signup actions
    
     JButton login, signup, clear;
     JTextField cardTextField;
     JPasswordField pinTextField;  //password is in dot format
     
    Login(){
        
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);  //by setLayout otherwise image is placed in the center only
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logooo.jpg")); //Imageicon is obj created classloader to load from sytem so get..
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);  //It is used to resize the image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3); //it can be uploaded with the help of Jlabel
        label.setBounds(70,10,100,100) ; //to place image where it is needed last 100 one is wdith and 2nd height
        add(label);
        
        JLabel text = new JLabel("Welcome To ATM"); // by using JLabel we can add text also
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno = new JLabel("Card No:"); 
        cardno.setFont(new Font("Raleway",Font.BOLD,28)); //28 is text size
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,230,30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,280,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,280,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,320,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.BLUE);
        
        setSize(800,400);   //size of frame
        setVisible(true);   //to get visible for user
        setLocation(350,200);  //350 from left,200 from top so it comes in middle
    }
    public void actionPerformed(ActionEvent ae){  //what happens after we press action buttons is defined here
       // login, singup, clear all are local defined in Jbutton in order to access here it should be globally defined and textfield also globally
       if(ae.getSource() == clear){
           cardTextField.setText("");
           pinTextField.setText("");
       }else if(ae.getSource() == login){
           Conn conn = new Conn(); //after entering the details by calling conn it goes to Atm frame
           String cardnumber = cardTextField.getText();
           String pinnumber = pinTextField.getText(); //getText is crossed bcoz its password field
           String query = "select * from login where cardnumber = '"+cardnumber+"' and pin ='"+pinnumber+"'"; //it should be matched
           try{
               ResultSet rs = conn.s.executeQuery(query); //if matches, ResultSet is returned,it is type of data. After query execution result is stored here
               if(rs.next()){
                   setVisible(false); //login frame is closed
                   new Transactions(pinnumber).setVisible(true); //Transactions frame should be opened
               }
               else{
                   JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin"); //dialogue box is opened
               }
           }catch(Exception e){
               System.out.println(e);
           }
       }else if(ae.getSource() == signup){ 
           setVisible(false);                 //if first time using if we press it will go to signup page,present screen visible is set to false and signup page visible becomes true
           new signupOne().setVisible(true);
           
       }
    }
   
 
    public static void main(String[] args) {
       new Login();
    }
    
}
