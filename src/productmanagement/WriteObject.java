package productmanagement;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteObject {
  public static void write(Object obj, String filename, boolean append) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, append))) {
      writer.write(String.valueOf(obj) + ";");
      writer.newLine();
      writer.close();
    } catch (Exception e) {

    }
  }
}
