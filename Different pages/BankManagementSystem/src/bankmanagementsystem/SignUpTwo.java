package bankmanagementsystem;

import javax.swing.*; //JFrame is present inside it
import java.awt.*;    //color is present inside it
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener { //actionListener is imported to perform a action
    
    JTextField pan,adhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,edu,occup;
    String formno; //signupOne & Signup two form are connected

    
    SignUpTwo(String formno){
    
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");    
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel reli = new JLabel("Religion:");
        reli.setFont(new Font("Raleway",Font.BOLD,20));
        reli.setBounds(100,140,100,30);
        add(reli);
        
        String valReligion[] = {"Hindu","Muslim","Christian","Sikh","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel categ = new JLabel("Category:");
        categ.setFont(new Font("Raleway",Font.BOLD,20));
        categ.setBounds(100,190,200,30);
        add(categ);
        
        String valCategory[] = {"OBC","General","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel inc = new JLabel("Income:");
        inc.setFont(new Font("Raleway",Font.BOLD,20));
        inc.setBounds(100,240,200,30);
        add(inc);
        
        String valIncome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,290,200,30);
        add(education);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        
        String valEducation[] = {"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
        edu = new JComboBox(valEducation);
        edu.setBounds(300,315,400,30);
        edu.setBackground(Color.WHITE);
        add(edu);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        
        String valOccupation[] = {"Salaried","Self-Employed","Businessman","Student","Retired","Others"};
        occup = new JComboBox(valOccupation);
        occup.setBounds(300,390,400,30);
        occup.setBackground(Color.WHITE);
        add(occup);
        
        JLabel panNumber = new JLabel("PAN Number:");
        panNumber.setFont(new Font("Raleway",Font.BOLD,20));
        panNumber.setBounds(100,440,200,30);
        add(panNumber);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);

        
        JLabel adharNumber = new JLabel("Adhar Number:");
        adharNumber.setFont(new Font("Raleway",Font.BOLD,20));
        adharNumber.setBounds(100,490,200,30);
        add(adharNumber);
        
        adhar = new JTextField();
        adhar.setFont(new Font("Raleway",Font.BOLD,14));
        adhar.setBounds(300,490,400,30);
        add(adhar);
        
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorCitizen.setBounds(100,540,200,30);
        add(seniorCitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);
        
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway",Font.BOLD,20));
        existingAccount.setBounds(100,590,200,30);
        add(existingAccount);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup emaritalGroup = new ButtonGroup();
        emaritalGroup.add(syes);
        emaritalGroup.add(sno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.BLUE);
        
        setSize(850,900);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        //String formno = "" + random; //formno is long inorder to convert to string in db
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)edu.getSelectedItem();
        String soccupation = (String)occup.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }else if(sno.isSelected()){
            seniorcitizen = "No";
        }
       
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }else if(eno.isSelected()){
            existingaccount = "No";
        }
        
        String span = pan.getText();
        String sadhar = adhar.getText();
        
        try{
                Conn c = new Conn(); //If name is not empty then it is stored to db using creating obj for connection
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar+"','"+seniorcitizen+"','"+existingaccount+"')";      //here using single quote variable is treated as string, in db we create table for signup and all the data are filled to that table as form is filled
                c.s.executeUpdate(query); //query is excuted in mysql

                //signup3 obj is created
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
        } catch(Exception e){
            System.out.println(e);  //Mysql is external entity it will show error during runtime it can be handled by exception
        }
                
    }
public static void main(String[] args) {
        new SignUpTwo("");  //obj of signup class
    }
    
}
