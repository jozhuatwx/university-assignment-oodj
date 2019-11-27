package productmanagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WriteObject {
  public static void write(Object obj, String filename, boolean append) {
    // Writes onto the file based on the path and whether to append or overwrite it
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, append))) {
      // Writes the String of the object and ends 
      writer.write(String.valueOf(obj));
      // Creates a new line in the file
      writer.newLine();
      // Clears the resources in writer
      writer.close();
    } catch (Exception e) {
      // Displays the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  public static void log(String action) {
    // Get the date and time in the format of YYYY-MM-dd HH:mm:ss
    String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));
    // Creates a log with the date, time, user ID, user role and the action made
    String log = dateTime + ";" + User.myUser.getUserId() + ";" + User.myUser.getUserRole() + ";" + action;
    // Writes the log into the file
    write(log, "Log.txt", true);
  }

  public static void write(Object obj, String filename, boolean append, String action) {
    // Writes original file
    write(obj, filename, append);

    // Writes actions into log
    log(action);
  }
}
