
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu3Staff{
    public static void menu(Scanner sc, ReportManager manager, Staff staff){
        int choice;

        while(true){
            System.out.println("----------------------------------------------");
            System.out.println("----------------- STAFF MENU -----------------");
            System.out.println("----------------------------------------------");
            System.out.println("1. View My Tasks");
            System.out.println("2. Complete Task");
            System.out.println("3. View Full Report");
            System.out.println("4. Logout");
            System.out.print("Choice: ");

            try{
                choice = sc.nextInt();
                sc.nextLine();
                System.out.println("");
            }catch (InputMismatchException e){
                System.out.println("Invalid input. Enter a number.\n");
                sc.nextLine();
                System.out.println("");
                continue;
            }

            switch (choice){
                case 1:
                    System.out.println("---------------- Your Tasks ------------------");
                    staff.showTasks();
                    System.out.println("");
                    break;

                case 2:
                    System.out.print("Enter Report ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Report r = staff.getReportById(id);

                    if (r != null) {
                        r.complete();
                        System.out.println("Task completed successfully.");
                    } else {
                        System.out.println("Invalid task.");
                    }
                    System.out.println("");
                    break;

                case 3:
                    System.out.print("Enter Report ID: ");
                    int idc4 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("");
                    
                    Report rc4 = manager.getReportById(idc4);

                    if (rc4 != null){
                        rc4.displayFull();
                        System.out.println("");
                    }else{
                        System.out.println("Report not found.\n");
                    }
                    break;
                case 4:
                    System.out.println("Logging out.....\n");
                    return;

                default:
                    System.out.println("Invalid input. Try again");
            }
        }
    }
}