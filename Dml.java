import java.util.Scanner;
import java.sql.*;
public class Dml {
    Scanner scan = new Scanner(System.in);
    public static void main() {
        
    }
    public  void dml(){
        System.out.println("WELCOME TO DML OPERATIONS");
        System.out.println("PRESS 1 FOR INSERT");
        System.out.println("PRESS 2 FOR DELETE");
        System.out.println("Enter your choice: ");
        int Choice = scan.nextInt();
        if(Choice==1)
           insert();
        else if (Choice==2)
           delete();
        else
           System.out.println("INVALID INPUT..");
    }       
    public void insert(){
        System.out.print("enter user name: ");
        String userName=scan.next();
        System.out.print("enter password: ");
        String passWord=scan.next();
        System.out.println("enter database to use: ");
        String dbName=scan.next();
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, userName, passWord);
                Statement statementObject2=con.createStatement();
                System.out.println("enter the name of an existing table: ");
        String tableName=scan.next(); 
        String query="insert into "+tableName+" (";
        System.out.println("enter the number of columns: ");
        int columnSize2=scan.nextInt();
        for(int i=0;i<columnSize2;i++)
        {
            System.out.println("enter column"+i+" name: ");
            query+=scan.next()+",";


        }
        int strlen=query.length();

        StringBuffer query2=new StringBuffer(query);
                query2.deleteCharAt(strlen-1);
                String query3=query2.toString()+") values (";
                for(int i=0;i<columnSize2;i++)
                {
                    System.out.println("enter column"+i+" values: ");
                    query3+="'"+scan.next()+"'"+",";


                }
                StringBuffer query4=new StringBuffer(query3);
                int strlen2=query3.length();
                query4.deleteCharAt(strlen2-1);
                query3=query4.toString()+")";
                
        System.out.println(query3);
        statementObject2.executeUpdate(query3);


        }
        catch(Exception e){
            System.out.println(e);
        }

    }
    public void delete() {  
        System.out.print("enter user name: ");
        String userName=scan.next();
        System.out.print("enter password: ");
        String passWord=scan.next();
        System.out.println("enter database to use: ");
        String dbName=scan.next();
        System.out.println("PRESS 1 FOR DATABASE");
        System.out.println("PRESS 2 FOR TABLES");
        int Choice=scan.nextInt();
        if(Choice==1){
            try{
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/", userName, passWord);
                Statement stmt=con.createStatement();
        {		      
        String query = "drop database"+" "+dbName;
        stmt.executeUpdate(query);
        System.out.println("database deleted ");   	  
        }
        }
        catch (Exception e) {
        System.out.println(e);
        } 
        }
        else if(Choice==2){
            System.out.println("enter the name of the table: ");
            String deleteTableName=scan.next();
            try{
                Connection connectionObject4=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, userName, passWord);
                Statement stmt=connectionObject4.createStatement();
        {		      
        String query = "drop table"+" "+deleteTableName;
        stmt.executeUpdate(query);
        System.out.println("table deleted");   	  
        }
        }
        catch (Exception e) {
        System.out.println(e);
        }      
    }
    else{
        System.out.println("Invalid Input");
    }
 }
}
