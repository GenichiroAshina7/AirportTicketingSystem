
import java.util.ArrayList;

public class StaffManager {
    private ArrayList<Staff> staffList = new ArrayList<>();

    public StaffManager() {
        staffList.add(new Staff("ahmad", "123", "Ahmad"));
        staffList.add(new Staff("ali", "123", "Ali"));
        staffList.add(new Staff("abu", "123", "Abu"));
    }

    public Staff authenticate(String u, String p) {
        for (Staff s : staffList) {
            if (s.login(u, p)) return s;
        }
        return null;
    }

    public void showStaffList() {
        System.out.println("------------------Staff List------------------");
        for (int i = 0; i < staffList.size(); i++) {
            System.out.println((i + 1) + ". " + staffList.get(i).getName());
        }
    }

    public Staff getStaffByIndex(int index) {
        if (index < 0 || index >= staffList.size()) return null;
        return staffList.get(index);
    }

    public void addStaff(String username, String password, String name) {
        staffList.add(new Staff(username, password, name));
    }

    public boolean removeStaffByName(String name) {
        for (int i = 0; i < staffList.size(); i++) {
            Staff s = staffList.get(i);

            if (s.getName().equalsIgnoreCase(name)) {

                if (s.hasTasks()) {
                    System.out.println("Cannot remove staff with active tasks.");
                    return false;
                }

                staffList.remove(i);
                return true;
            }
        }
        return false;
    }

    //depreceated
    //public boolean removeStaffByUsername(String username) {
    //    for (int i = 0; i < staffList.size(); i++) {
    //        if (staffList.get(i).username.equals(username)) {
    //            staffList.remove(i);
    //            return true;
    //        }
    //    }
    //    return false;
    //}

    public boolean usernameExists(String username) {
        for (Staff s : staffList) {
            if (s.getUsername().equals(username)) return true;
        }
        return false;
    }
}
