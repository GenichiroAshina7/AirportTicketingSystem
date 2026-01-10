
import java.util.ArrayList;

public class Staff extends User {
    private ArrayList<Report> assignedReports = new ArrayList<>();

    public Staff(String username, String password, String name) {
        super(username, password, name);
    }

    public void assignReport(Report r) {
        assignedReports.add(r);
    }

    public void showTasks() {
        if (assignedReports.isEmpty()) {
            System.out.println("No assigned tasks.");
            return;
        }

        for (Report r : assignedReports) {
            r.displayBrief();
        }
    }

    public Report getReportById(int id) {
        for (Report r : assignedReports) {
            if (r.getReportId() == id) return r;
        }
        return null;
    }

    public boolean hasTasks(){
        return !assignedReports.isEmpty();
    }
}
