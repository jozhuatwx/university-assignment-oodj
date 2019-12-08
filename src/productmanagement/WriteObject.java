package productmanagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WriteObject {
  public static boolean write(Object obj, String filename, boolean append) {
    // Writes onto the file based on the path and whether to append or overwrite it
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, append))) {
      // Creates a new line in the file
      writer.newLine();
      // Writes the String of the object and ends
      writer.write(URLEncoder.encode(String.valueOf(obj), StandardCharsets.UTF_8));
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

  public static boolean saveImage(Path tempPath, String newPathString, String fileName) {
    String relativePath = Paths.get(".").toAbsolutePath().toString() + "/src";

    try {
      // Create directory if does not exist
      new File(relativePath + newPathString).mkdirs();

      // Convert String to Path
      Path newPath = Path.of(relativePath, newPathString, fileName);

      // Delete file if exist
      Files.deleteIfExists(newPath);

      // Copy the file
      Files.copy(tempPath, newPath);
    } catch (Exception e) {
      // Displays the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    return true;
  }
}
