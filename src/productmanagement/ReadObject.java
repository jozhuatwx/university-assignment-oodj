package productmanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ReadObject {
  // Generate the latest ID
  public static String generateId(String prefix, String filename) {
    // Set the default ID to 1
    int intId = 1;
    String id = prefix + "00000001";

    ArrayList<String> array = readArray(filename);
    if (array.size() > 0) {
      // Get the last line of the array list
      String lastLine = array.get(array.size() - 1);
      // Split the line into an array
      String[] lastLineDetails = lastLine.split(";");
      // Read the ID of the line and add by 1
      intId = Integer.valueOf(lastLineDetails[0].substring(prefix.length())) + 1;
      // Add prefix and leading zeroes to the ID
      id = prefix + String.format("%08d", intId);
    }
    // Return the value of the new ID
    return id;
  }

  public static ArrayList<String> readArray(String filename) {
    File file = new File(filename);
    // Creates an array list
    ArrayList<String> data = new ArrayList<String>();
    
    // Reads the file based on the path
    try {
      // Create an empty file is it does not exist
      file.createNewFile();

      BufferedReader reader = new BufferedReader(new FileReader(filename));
      // Store the first line into a temporary variable
      String temp = reader.readLine();

      while (temp != null) {
        if (!temp.isBlank()) {
          // Add the temporary variable into the array list
          data.add(URLDecoder.decode(temp, StandardCharsets.UTF_8));
        }
        // Read the next line into the temporary variable
        temp = reader.readLine();
      }
      // Clears the resources in reader
      reader.close();
    } catch (Exception e) {
      // Displays the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    // Returns the array list data
    return data;
  }
}
