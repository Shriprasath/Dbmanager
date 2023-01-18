import java.util.Scanner;
public class Db{
    
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("                                  WELCOME TO MYSQL"+"\n");
        System.out.println("PRESS 1 FOR DDL COMMANDS");
        System.out.println("PRESS 2 FOR DML COMMANDS");
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();
        if(choice==1){
            Ddl output1 = new Ddl();
            output1.ddl();
        }
        else if(choice==2){
            Dml output2 = new Dml();
            output2.dml();
        }
        else{
            System.out.println("Invalid Input");
        }

    }
}    
