
import java.util.Scanner;

public class Menu1Guest{        
    public static void submitReport(Scanner sc, ReportManager manager){  
        
        System.out.println("----------- Report Details to fill -----------");

        System.out.print("Guest Name: ");
        String name = sc.nextLine();

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Description: ");
        String description = sc.nextLine();

        System.out.print("Category: ");
        String category = sc.nextLine();

        System.out.print("Location: ");
        String location = sc.nextLine();

        System.out.print("Urgency: ");
        String urgency = sc.nextLine();

        Report r = new Report(name, title, description, category, location, urgency);
        manager.addReport(r);

        System.out.println("Report submitted successfully.\n");
    }

}
