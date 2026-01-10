
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp{
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       ReportManager manager = new ReportManager();
       StaffManager staffManager = new StaffManager();
       Admin admin = new Admin("admin", "admin123", "Big Boss");
       
       int decision;

       while (true){
            System.out.println("----------------------------------------------");
            System.out.println("==== Welcome to Airport Maintenance System ====");
            System.out.println("----------------------------------------------");
            System.out.println("1. Guest");
            System.out.println("2. Admin");
            System.out.println("3. Staff");
            System.out.print(  "Choice: ");

            try{
                decision = sc.nextInt();
                sc.nextLine();
                System.out.println("");
            }catch (InputMismatchException e){
                System.out.println("Invalid input. Enter a number.\n");
                sc.nextLine();
                continue;
            }

            switch (decision){
                case 1: 
                    Menu1Guest.submitReport(sc, manager);
                break;

                case 2:
                    System.out.println("------------------- Login --------------------");
                    System.out.print("Username: ");
                    String usernameAdmin = sc.nextLine();
                    System.out.print("Password: ");
                    String passwordAdmin = sc.nextLine();
                    System.out.println("");

                    if (admin.login(usernameAdmin, passwordAdmin)){
                        Menu2Admin.menu(sc, manager, staffManager);
                    }else{
                        System.out.println("Invalid credentials. Try again.\n");
                    }
                break;

                case 3:
                    System.out.println("-------------------- Login -------------------");
                    System.out.print("Username: ");
                    String username = sc.nextLine();
                    System.out.print("Password: ");
                    String password = sc.nextLine();
                    System.out.println("");

                    Staff loggedInStaff = staffManager.authenticate(username, password);
                    if (loggedInStaff != null){
                        Menu3Staff.menu(sc, manager, loggedInStaff);
                    }else{
                        System.out.println("Invalid credentials. Try again.\n");
                    }
                    break;

                default:
                System.out.println("Wrong input. Try again");
            }

        }

    }
}
