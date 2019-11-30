package productmanagement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
  // Constant fields
  public final static String LOG_FILE_NAME = "Log.txt";

  public static boolean write(String action) {
    // Get the date and time in the format of YYYY-MM-dd HH:mm:ss
    String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));
    // Creates a log with the date, time, user ID, user role and the action made
    String log = dateTime + ";" + User.myUser.getUserId() + ";" + User.myUser.getUserRole() + ";" + action;
    // Writes the log into the file
    return WriteObject.write(log, LOG_FILE_NAME, true);
  }
}
