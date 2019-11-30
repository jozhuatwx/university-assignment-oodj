package productmanagement;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Log {
  // Constant fields
  public final static String FILE_NAME = "Log.txt";

  // Log fields
  private LocalDateTime logDateTime;
  private String logUserId, logUserRole, logAction;

  Log(LocalDateTime logDateTime, String logUserId, String logUserRole, String logAction) {
    this.logDateTime = logDateTime;
    this.logUserId = logUserId;
    this.logUserRole = logUserRole;
    this.logAction = logAction;
  }
  
  Log(String[] details) {
    this(LocalDateTime.parse(details[0]), details[1], details[2], details[3]);
  }

  // Getters and setters
  public LocalDateTime getLogDateTime() {
    return logDateTime;
  }

  public String getLogUserId() {
    return logUserId;
  }

  public String getLogUserRole() {
    return logUserRole;
  }
  
  public String getLogAction() {
    return logAction;
  }

  public static boolean write(String action) {
    // Creates a log with the date, time, user ID, user role and the action made
    String log = LocalDateTime.now() + ";" + User.myUser.getUserId() + ";" + User.myUser.getUserRole() + ";" + action;
    // Writes the log into the file
    return WriteObject.write(log, FILE_NAME, true);
  }

  public static ArrayList<Log> search(String keyword) {
    keyword = keyword.toLowerCase();
    ArrayList<Log> logArrayList = new ArrayList<>();

    try {
      ArrayList<String> logArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Log array
      for (String logDetails : logArray) {
        // Split the line into an array
        String[] details = logDetails.split(";");
        // Find if any existing Log matches the keyword
        Log log = new Log(details);
        if (String.valueOf(log.getLogDateTime()).toLowerCase().contains(keyword) || log.getLogUserId().toLowerCase().contains(keyword) || log.getLogAction().toLowerCase().contains(keyword)) {
          logArrayList.add(log);
        }
      }
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return logArrayList;
  }
}
