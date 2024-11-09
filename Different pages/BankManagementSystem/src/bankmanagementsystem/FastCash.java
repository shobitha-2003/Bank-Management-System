package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;  //for image importing
import java.awt.event.*;
import java.sql.*; //Reset is present inside this
import java.util.Date; //for date

public class FastCash extends JFrame implements ActionListener{

    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balancequery,exit;
    String pinnumber;
    
    FastCash(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); //it is used to load image."ClassLoader.getSystemResource("icons/atm.jpg") is used to get the URL of the image file atm.jpg located in the icons directory in the classpath.
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);  //getScaledInstance(900, 900, Image.SCALE_DEFAULT): Resizes the image to a width of 900 pixels and a height of 900 pixels using the default scaling algorithm (Image.SCALE_DEFAULT).
        ImageIcon i3 = new ImageIcon(i2); //new ImageIcon(i2): Creates a new ImageIcon object using the scaled Image object i2.
        JLabel image = new JLabel(i3); //JLabel image: Declares a variable image of type JLabel. JLabel is a component for displaying a short string or an image icon.
        image.setBounds(0,0,900,900);//It sets image to full output screen7
        add(image);
        
        JLabel text =new JLabel("Select Withdrawl Amount");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.GREEN);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text); //image.add is written bcoz we want text above the image. Whether text will not visible.
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balancequery = new JButton("Rs 10000");
        balancequery.setBounds(355,485,150,30);
        balancequery.addActionListener(this);
        image.add(balancequery);
        
        exit = new JButton("Back");
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
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3); //1st char-R,2nd char-s,3rd char-space(in Rs 500) after that sub the amount
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("Select * from bank where pin='"+pinnumber+"'"); //rs helps to loop in every row of bank
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){ //in bank row if type = Deposit means
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount")); //or it will subtract 
                    }
                }
                if(ae.getSource()!= exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount +" Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
    
}
