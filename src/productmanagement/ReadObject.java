package productmanagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadObject {
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
