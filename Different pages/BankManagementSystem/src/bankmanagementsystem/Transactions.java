package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;  //for image importing
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balancequery,exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); //it is used to load image."ClassLoader.getSystemResource("icons/atm.jpg") is used to get the URL of the image file atm.jpg located in the icons directory in the classpath.
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);  //getScaledInstance(900, 900, Image.SCALE_DEFAULT): Resizes the image to a width of 900 pixels and a height of 900 pixels using the default scaling algorithm (Image.SCALE_DEFAULT).
        ImageIcon i3 = new ImageIcon(i2); //new ImageIcon(i2): Creates a new ImageIcon object using the scaled Image object i2.
        JLabel image = new JLabel(i3); //JLabel image: Declares a variable image of type JLabel. JLabel is a component for displaying a short string or an image icon.
        image.setBounds(0,0,900,900);//It sets image to full output screen7
        add(image);
        
        JLabel text =new JLabel("Please Select Your Transactions");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.GREEN);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text); //image.add is written bcoz we want text above the image. Whether text will not visible.
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balancequery = new JButton("Balance Query ");
        balancequery.setBounds(355,485,150,30);
        balancequery.addActionListener(this);
        image.add(balancequery);
        
        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); //Compiling screen with x and - is not visible now
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()== withdrawl){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource() == balancequery){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource() == ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transactions("");
    }
    
}
