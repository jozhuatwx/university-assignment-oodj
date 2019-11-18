package productmanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadObject {
  public static ArrayList<String> readArray(String filename) {
    ArrayList<String> data = new ArrayList<String>();
    
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String temp = reader.readLine();
      temp = temp.substring(0, temp.length() - 1);

      while (temp != null) {
        data.add(temp);
        temp = reader.readLine().substring(0, temp.length() - 1);
      };
      reader.close();
    } catch (Exception e) {
      
    }
    return data;
  }

  public static int getLineNumber(String filename, int id) {
    int line = 0;

    for (String account : ReadObject.readArray("Account.txt")) {
      String[] details = account.split(",");
      if (Integer.valueOf(details[0]).equals(id)) {
        return line;
      }
      line++;
    }
    return -1;
  }
}
