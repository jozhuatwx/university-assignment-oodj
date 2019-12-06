package productmanagement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InventoryTransaction {
  // Constant fields
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

  private static String generateTransactionId() {
    return ReadObject.generateId("IT", FILE_NAME);
  }

  public static boolean register(InventoryTransaction transaction) {
    // Write the new item into the Item database and log action
    return WriteObject.write(transaction, FILE_NAME, true, "Added transaction (" + transaction.getTransactionId() + ")");
  }

  public static String[][] topProductItems() {
    String[][] topProductItems = new String[3][4];
    try {
      // Get the Items
      ArrayList<String> itemArrayList = ReadObject.readArray(ProductItem.FILE_NAME);
      String[][] itemArray = new String[itemArrayList.size()][4];

      // Iterate through the Item array list
      for (int i = 0; i < itemArrayList.size(); i++) {
        // Split line into array
        String[] details = itemArrayList.get(i).split(";");
        // Item ID
        itemArray[i][0] = details[0];
        // Item Name
        itemArray[i][1] = details[1];
        // Item Brand
        itemArray[i][2] = details[2];
        // Item Total Transaction
        itemArray[i][3] = "0";
      }

      if (itemArrayList.size() > 0) {
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

        // Sort the Transactions descending order
        Arrays.sort(itemArray, new Comparator<String[]>() {
          @Override
          public int compare(String[] o1, String[] o2) {
            Integer quantityOne = Integer.valueOf(o1[3]);
            Integer quantityTwo = Integer.valueOf(o2[3]);
            return quantityTwo.compareTo(quantityOne);
          }
        });

        // Get the top three
        if (itemArrayList.size() > 3) {
          for (int i = 0; i < topProductItems.length; i++) {
            for (int x = 0; x < 4; x++) {
              topProductItems[i][x] = itemArray[i][x];
            }
          }
        } else {
          for (int i = 0; i < itemArrayList.size(); i++) {
            for (int x = 0; x < 4; x++) {
              topProductItems[i][x] = itemArray[i][x];
            }
          }
        }
      }
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return topProductItems;
  }

  public static double totalRevenue(LocalDate startDatetime, LocalDate endDatetime) {
    double totalRevenue = 0.0;
    try {
      ArrayList<String> itemArray = ReadObject.readArray(ProductItem.FILE_NAME);
      ArrayList<String> transactionArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Transaction array
      for (String transactionDetails : transactionArray) {
        // Split line into array
        String[] details = transactionDetails.split(";");
        // Only count the outgoing transaction within the timeframe
        LocalDate transactionDate = LocalDateTime.parse(details[1]).toLocalDate();
        if ((transactionDate.isAfter(startDatetime) || transactionDate.isEqual(startDatetime)) && (transactionDate.isBefore(endDatetime) || transactionDate.isEqual(endDatetime)) && Double.valueOf(details[3]) < 0) {
          int index = Integer.valueOf(details[2].substring(2)) - 1;
          String[] item = itemArray.get(index).split(";");
          double price = Double.valueOf(item[3]);
          // Multiply the price and negate the negative value of the number of units
          totalRevenue -= price * Double.valueOf(details[3]);
        }
      }
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return totalRevenue;
  }

  public static double totalRevenue() {
    return totalRevenue(LocalDate.MIN, LocalDate.MAX);
  }

  public static int getItemQuantity(String itemId) {
    int itemQuantity = 0;
    try {
      ArrayList<String> transactionArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Transaction array
      for (String transactionDetails : transactionArray) {
        // Split line into array
        String[] details = transactionDetails.split(";");
        // If the Item id matches
        if (details[2].equalsIgnoreCase(itemId)) {
          // Add the value to the Item Quantity
          itemQuantity += Integer.valueOf(details[3]);
        }
      }
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return itemQuantity;
  }

  // Override the default toString() to display the information of the Inventory Transaction class
  @Override
  public String toString() {
    return getTransactionId() + ";" + getTransactionDateTime() + ";" + getItemId() + ";" + String.valueOf(getTransactionQuantity()) + ";";
  }
}
