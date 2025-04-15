package unihelp;
import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
public class TimeTableTest {
	 @Test
	    void timetableManagerStoresAndRetrievesClasses() {
	        TimetableManager tm = new TimetableManager();
	        tm.addClass("Monday", "9am - Math");
	        tm.addClass("Monday", "11am - Physics");
	        tm.addClass("Tuesday", "1pm - Chemistry");

	        Map<String, String> timetable = tm.getTimetable();
	        assertTrue(timetable.containsKey("Monday"));
	        assertTrue(timetable.get("Monday").contains("Math"));
	        assertTrue(timetable.get("Monday").contains("Physics"));
	        assertTrue(timetable.get("Tuesday").contains("Chemistry"));
	    }
}
