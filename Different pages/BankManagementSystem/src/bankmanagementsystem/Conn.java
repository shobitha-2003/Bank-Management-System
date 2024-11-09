package bankmanagementsystem;
import java.sql.*;  //sql driver 


public class Conn {
    
    Connection c;            //global class is created for connection
    Statement s;             //3rd step-create statement is declared
   public Conn(){           //contructor is created
      try{
          //some exception handling is done bcoz MySQl is external entity chances of runtime error is more
         //(this line is not required bcoz library is imported) Class.forName(com.mysql.cj.jdbc.Driver);  //Regsiter of driver by static name forName com... its is driver name
          c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Shobi@2003");        //connection is created
          s = c.createStatement();           //with the help of connection,statement is created
          
      }catch (Exception e){
          System.out.println(e);
      }
          
   }
    
}
