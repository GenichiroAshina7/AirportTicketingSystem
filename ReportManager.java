
import java.util.ArrayList;

public class ReportManager {
    private ArrayList<Report> reports = new ArrayList<>();

    public void addReport(Report r) {
        reports.add(r);
    }
    
    public void showAssignedAndCompleted() {
        boolean found = false;

        for (Report r : reports) {
            if (!r.getStatus().equals("Unassigned")) {
                r.displayBrief();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No assigned or completed reports.");
        }
    }


    public void showUnassigned() {
        for (Report r : reports) {
            if (r.getStatus().equals("Unassigned")) {
                System.out.println("");
                r.displayBrief();
            }
        }
    }

    public Report getReportById(int id) {
        for (Report r : reports) {
            if (r.getReportId() == id) return r;
        }
        return null;
    }
}
