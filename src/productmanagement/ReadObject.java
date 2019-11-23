package productmanagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadObject {
  // Generate the latest ID
  public static String generateId(String prefix, String filename) {
    // Set the default ID to 1
    int intId = 1;
    String id = prefix + "00000001";

    try {
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
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing file
    }
    // Return the value of the new ID
    return id;
  }

  public static ArrayList<String> readArray(String filename) throws FileNotFoundException {
    // Creates an array list
    ArrayList<String> data = new ArrayList<String>();
    
    // Reads the file based on the path
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      // Store the first line into a temporary variable
      String temp = reader.readLine();

      while (temp != null) {
        // Add the temporary variable into the array list
        data.add(temp);
        // Read the next line into the temporary variable
        temp = reader.readLine();
      }
      // Clears the resources in reader
      reader.close();
    } catch (IOException e) {
      // Displays the error message
      System.out.println(e);
    }
    // Returns the array list data
    return data;
  }
}
