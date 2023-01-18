import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Ddl {
    Scanner scan = new Scanner(System.in);
    public static void main() {
        
    }
    public void ddl(){
            System.out.println("WELCOME TO DDL OPERATIONS");
            System.out.println("PRESS 1 FOR CREATE");
            System.out.println("PRESS 2 FOR TRAVERSE");
            System.out.print("Enter your choice: ");
            int Choice = scan.nextInt();
            if(Choice==1)
               create();
            else if (Choice==2)
               traverse();
            else
               System.out.println("INVALID INPUT..");

    }
    public void create(){
        System.out.print("enter user name:");
        String userName=scan.next();
        System.out.print("enter password:");
        String passWord=scan.next();
        try
    
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/", userName, passWord);
            Statement stmt=con.createStatement();
            System.out.println("enter database name");
            String dbName=scan.next();
            String query="create database "+dbName;
            stmt.executeUpdate(query);
            System.out.println("database created");
            System.out.println("enter 1 to create new table: ");
            int choice=scan.nextInt();
            if (choice==1)
            {
                String query1="";
                String dataType="";
                String field="";
                System.out.println("enter table name");
                String tableName=scan.next();
                System.out.println("enter number of fields");
                int columnSize=scan.nextInt();
                query1="create table "+tableName+" (";
                for(int i=0;i<columnSize;i++ ){
                    System.out.println("enter column"+i+" name");
                    field=scan.next();
                    query1+=" "+field;
                    System.out.println("enter column"+i+" datatype");
                    dataType=scan.next();
                    query1+=" "+dataType+"(255),";
                


                }
                int strlen=query1.length();

                StringBuffer commandString1=new StringBuffer(query1);
                commandString1.deleteCharAt(strlen-1);
                String query2=query1.toString();
                query2+=")";
                System.out.println(query2);
                Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, userName, passWord);
                Statement statementObject2=con2.createStatement();

                statementObject2.executeUpdate(query2);

            }
        else{
            System.out.println("invalid input");
        }
    }
        catch(Exception e){
            System.out.println(e);
        }


    }
    public void traverse(){
        System.out.print("enter user name: ");
        String userName=scan.next();
        System.out.println("enter password: ");
        String passWord=scan.next();
        System.out.print("enter database to use: ");
        String dbName=scan.next();
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, userName, passWord);
                Statement stmt=con.createStatement();
                System.out.println("enter the name of an existing table: ");
                String tableName=scan.nextLine();   
                System.out.println("Enter 1 for viewing");
                System.out.println("Enter 2 for structure");
                System.out.print("Enter your choice: ");
                int Choice=scan.nextInt();
                if (Choice==1){
                    ResultSet rs=stmt.executeQuery("select*from "+tableName);
                    while(rs.next()){
                        System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(3));
                    }
                    con.close();
                }
                else if(Choice==2){
                    ResultSet rsd=stmt.executeQuery("describe "+tableName);
                    System.out.println("Field   Type     Null");
                    while(rsd.next()){  
                        System.out.println(rsd.getString(1)+" "+rsd.getString(2)+" "+rsd.getString(3));
                    }
                    con.close();
                }
                else{
                    System.out.println("Invalid output");
                }
            }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
