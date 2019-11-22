package productmanagement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ActionLog {
  public static void log(String action) {
    // Get the date and time in the format of YYYY-MM-DD HH:mm:ss
    String dateTime = String.valueOf(LocalDate.now()) + " " + String.valueOf(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    // Creates a log with the date, time, user ID, user role and the action made
    String log = dateTime + " User ID: " + User.myAccount.getUserId() + " Role: " + User.myAccount.getUserRole() + " Action: " + action;
    // Writes the log into the file
    WriteObject.write(log, "Log.txt", true);
  }
}
