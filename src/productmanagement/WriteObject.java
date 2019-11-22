package productmanagement;

import java.io.BufferedWriter;
import java.io.FileWriter;

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
      System.out.println(e);
    }
  }
}
