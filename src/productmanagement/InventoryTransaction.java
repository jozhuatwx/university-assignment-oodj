package productmanagement;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InventoryTransaction {
  // Constant variables
  public static final String FILE_NAME = "InventoryTransaction.txt";
  public static final String TEMP_FILE_NAME = "TempInventoryTransaction.txt";

  // Inventory Transaction fields
  private String transactionId, itemId;
  private int transactionQuantity;

  // Construct the Inventory Transaction
  InventoryTransaction(String itemId, int transactionQuantity) {
    this.transactionId = generateTransactionId();
    this.itemId = itemId;
    this.transactionQuantity = transactionQuantity;
  }

  // Getters and setters
  public String getTransactionId() {
    return transactionId;
  }

  public LocalDateTime getTransactionDateTime() {
    return LocalDateTime.now();
  }

  public String getItemId() {
    return itemId;
  }

  public int getTransactionQuantity() {
    return transactionQuantity;
  }

  public static String generateTransactionId() {
    return ReadObject.generateId("IT", FILE_NAME);
  }

  public static void register(InventoryTransaction transaction) {
    // Write the new item into the Item database and log action
    WriteObject.write(transaction, FILE_NAME, true, "Added transaction (" + transaction.getTransactionId() + ")");
  }

  public static void topProductItems() {
    try {
      // Get the Items
      ArrayList<String> itemArrayList = ReadObject.readArray(ProductItem.FILE_NAME);
      String[][] itemArray = new String[itemArrayList.size()][4];

      for (int i = 0; i < itemArrayList.size(); i++) {
        String[] details = itemArrayList.get(i).split(";");
        // Item ID
        itemArray[i][0] = details[0];
        // Item Name
        itemArray[i][1] = details[1];
        // Item Brand
        itemArray[i][2] = details[3];
        // Item Total Transaction
        itemArray[i][3] = "0";
      }

      // Get the Transactions
      ArrayList<String> transactionArray = ReadObject.readArray(FILE_NAME);

      for (String transaction : transactionArray) {
        String[] details = transaction.split(";");
        // Only count the outgoing transactions
        if (Integer.valueOf(details[3]) < 0) {
          // Get the index in the array
          int index = Integer.valueOf(details[2].substring(2)) - 1;
          // Negate the negative value and add to the value in the item array
          itemArray[index][3] = String.valueOf(Integer.valueOf(itemArray[index][3]) - Integer.valueOf(details[3]));
        }
      }

      // Sort the Transactions
      Arrays.sort(itemArray, new Comparator<String[]>() {
        @Override
        public int compare(String[] o1, String[] o2) {
          Integer quantityOne = Integer.valueOf(o1[3]);
          Integer quantityTwo = Integer.valueOf(o2[3]);
          return quantityTwo.compareTo(quantityOne);
        }
      });

      System.out.println("Item id\t\tQuantity");
      for (int i = 0; i < itemArray.length; i++) {
        String[] itemRecord = itemArray[i];
        System.out.println(itemRecord[0] + "\t\t" + itemRecord[1] + "\t\t" + itemRecord[2] + "\t\t" + itemRecord[3]);
      }
    } catch (FileNotFoundException e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    // return topItems;
  }

  // Override the default toString() to display the information of the Inventory Transaction class
  @Override
  public String toString() {
    return getTransactionId() + ";" + getTransactionDateTime().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")) + ";" + getItemId() + ";" + String.valueOf(getTransactionQuantity()) + ";";
  }
}
