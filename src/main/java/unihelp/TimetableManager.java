package unihelp;

import java.util.LinkedHashMap;
import java.util.Map;

public class TimetableManager {
    private Map<String, String> timetable = new LinkedHashMap<>();

  
    public void addClass(String day, String details) {
        timetable.put(day, timetable.getOrDefault(day, "") + details + "\n");
        System.out.println("Class added to timetable.");
    }

    public Map<String, String> getTimetable() {
        return timetable;
    }

    public void viewTimetable() {
        if (timetable.isEmpty()) {
            System.out.println("No classes scheduled.");
            return;
        }
        System.out.println("\n=== Weekly Timetable ===");
        for (String day : timetable.keySet()) {
            System.out.println(day + ":\n" + timetable.get(day));
        }
    }
}

