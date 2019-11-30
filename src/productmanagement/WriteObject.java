package productmanagement;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WriteObject {
  public static boolean write(Object obj, String filename, boolean append) {
    // Writes onto the file based on the path and whether to append or overwrite it
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, append))) {
      // Writes the String of the object and ends
      writer.write(String.valueOf(obj));
      // Creates a new line in the file
      writer.newLine();
      // Clears the resources in writer
      writer.close();
      return true;
    } catch (Exception e) {
      // Displays the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return false;
  }

  public static boolean write(Object obj, String fileName, boolean append, String action) {
    // Default to not show message
    return write(obj, fileName, append, action, false);
  }

  public static boolean write(Object obj, String fileName, boolean append, String action, boolean displayMessage) {
    // Writes original file
    boolean write = write(obj, fileName, append);

    // Writes actions into log
    boolean log = Log.write(action);

    if (displayMessage) {
      // Display the success message
      JOptionPane.showMessageDialog(new JFrame(), action, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    if (write && log) {
      return true;
    }
    return false;
  }
}
