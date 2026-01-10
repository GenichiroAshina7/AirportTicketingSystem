
public class Report {
    private static int counter = 1;

    private int reportId;           
    private String guestName;       
    private String title;
    private String description;
    private String category;
    private String location;
    private String urgency;
    private String status;
    private Staff assignedStaff;

    public Report(String guestName, String title, String description, String category, String location, String urgency){
        this.reportId = counter++;
        this.guestName = guestName;
        this.title = title;
        this.description = description;
        this.category = category;
        this.location = location;
        this.urgency = urgency;
        this.status = "Unassigned";
    }

    public int getReportId(){  
        return reportId;
    }

    public String getStatus(){ 
        return status;
    }

    public Staff getAssignedStaff(){ 
        return assignedStaff;
    }

    public void assignStaff (Staff assignedStaff){ 
        this.assignedStaff = assignedStaff;
        this.status = "Assigned";
    }

    public void complete(){ 
        this.status = "Completed";
    }

    public void displayBrief(){ 
        System.out.println(reportId+" | "+title+" | "+urgency+" | "+status);
    }

    public void displayFull() { 
        System.out.println("---------------- Full Report -----------------");
        System.out.println("Report ID: " + reportId);
        System.out.println("Guest: " + guestName);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Category: " + category);
        System.out.println("Location: " + location);
        System.out.println("Urgency: " + urgency);
        System.out.println("Status: " + status);
        System.out.println("Assigned Staff: " +  (assignedStaff != null ? assignedStaff.getName() : "None"));
    }
}
