package productmanagement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ActionLog {
  public static void log(String action) {
    String log = String.valueOf(LocalDate.now()) + " " + String.valueOf(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))) + " " + String.valueOf(User.myAccount.getUserId()) + " " + User.myAccount.getUserRole() + " " + action;
    WriteObject.write(log, "Log.txt", true);
  }
}
