package productmanagement;

import java.time.LocalDate;
import java.time.LocalTime;

public class ActionLog {
  public static void log(String action) {
    String log = User.myAccount.getUserName();
    // String log = String.valueOf(LocalDate.now()) + " " + String.valueOf(LocalTime.now()) + " " + String.valueOf(User.myAccount.getUserId()) + " " + User.myAccount.getUserRole() + " " + action;
    WriteObject.write(log, "Log.txt", true);
  }
}
