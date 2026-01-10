
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu2Admin {

    public static void menu(Scanner sc, ReportManager manager, StaffManager staffManager) {
        int choice;

        while (true) {
            System.out.println("");
            System.out.println("----------------------------------------------");
            System.out.println("----------------- ADMIN MENU -----------------");
            System.out.println("----------------------------------------------");
            System.out.println("1. View Unassigned Reports");
            System.out.println("2. Assign Report");
            System.out.println("3. View Assigned Reports");
            System.out.println("4. View Full Report");
            System.out.println("5. Add Staff");
            System.out.println("6. Remove Staff");
            System.out.println("7. Show all staff");
            System.out.println("8. Logout");
            System.out.print("Choice: ");

            try{
                choice = sc.nextInt();
                sc.nextLine();
                System.out.println("");
            }catch (InputMismatchException e){
                System.out.println("Invalid input. Enter a number.\n");
                sc.nextLine();
                continue;
            }
      
            switch (choice) {
                case 1:
                    System.out.print("------------- Unassigned Reports -------------");
                    manager.showUnassigned();
                    System.out.println("");
                    break;

                case 2:
                    System.out.print("Enter Report ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("");

                    Report r = manager.getReportById(id);

                    if (r != null && r.getStatus().equals("Unassigned")) {
                        staffManager.showStaffList();
                        System.out.print("Select staff number: ");
                        int staffChoice = sc.nextInt();
                        sc.nextLine();

                        Staff selected = staffManager.getStaffByIndex(staffChoice - 1);

                        if (selected != null) {
                            r.assignStaff(selected);
                            selected.assignReport(r); 
                            System.out.println("Report assigned to " + selected.getName());
                            System.out.println("");
                        } else {
                            System.out.println("Invalid staff selection.");
                        }
                    } else {
                        System.out.println("Invalid report ID or report already assigned.\n");
                    }
                    break;

                case 3:
                    System.out.println("");
                    System.out.println("------------- Assigned Reports --------------");
                    manager.showAssignedAndCompleted();
                    System.out.println("");
                    break;

                case 4:
                    System.out.print("Enter Report ID: ");
                    int idc4 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("");
                    
                    Report rc4 = manager.getReportById(idc4);

                    if (rc4 != null){
                        rc4.displayFull();
                        System.out.println("");
                    }else{
                        System.out.println("Report not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter staff name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter username: ");
                    String username = sc.nextLine();

                    if (staffManager.usernameExists(username)) {
                        System.out.println("Username already exists.");
                        break;
                    }

                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    staffManager.addStaff(username, password, name);
                    System.out.println("Staff added successfully.\n");
                    break; 

                case 6:
                    staffManager.showStaffList();
                    System.out.print("Enter staff name to remove: ");
                    String removeName = sc.nextLine();
                    
                    if (staffManager.removeStaffByName(removeName)) {
                        System.out.println("Staff removed successfully.\n");
                    } else {
                        System.out.println("Staff not found/removal failed.\n");
                    }
                    break;

                case 7:
                    staffManager.showStaffList();
                    break;

                case 8:
                    System.out.println("Logging out....\n");
                    return;

                default:
                    System.out.println("Invalid input. Try again.\n");
            }
        }
    }
}
