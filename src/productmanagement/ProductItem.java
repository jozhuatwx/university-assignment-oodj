package productmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ProductItem {
  private String itemId, itemName, itemBrand, itemDescription, itemImagePath, itemSupplierId;
  private int itemQuantity;
  private double itemPrice;

  // Construct the Product Item
  ProductItem(String itemId, String itemName, String itemBrand, int itemQuantity, double itemPrice, String itemDescription, String itemImagePath, String itemSupplierId) {
    this.itemId = itemId;
    this.itemName = itemName;
    this.itemBrand = itemBrand;
    this.itemQuantity = itemQuantity;
    this.itemPrice = itemPrice;
    this.itemDescription = itemDescription;
    this.itemImagePath = itemImagePath;
    this.itemSupplierId = itemSupplierId;
  }

  // Getters and setters
  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getItemBrand() {
    return itemBrand;
  }

  public void setItemBrand(String itemBrand) {
    this.itemBrand = itemBrand;
  }

  public int getItemQuantity() {
    return itemQuantity;
  }

  public void setItemQuantity(int itemQuantity) {
    this.itemQuantity = itemQuantity;
  }

  public double getItemPrice() {
    return itemPrice;
  }

  public void setItemPrice(double itemPrice) {
    this.itemPrice = itemPrice;
  }

  public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  public String getItemImagePath() {
    return itemImagePath;
  }

  public void setItemImagePath(String itemImagePath) {
    this.itemImagePath = itemImagePath;
  }

  public String getItemSupplierId() {
    return itemSupplierId;
  }

  public void setItemSupplierId(String itemSupplierId) {
    this.itemSupplierId = itemSupplierId;
  }

    // Generate the Product Item ID
  public static String generateItemId() {
    // Set default ID to 1
    int intItemId = 1;
    String itemId = "PI00000001";

    try {
      // Create a item array list
      ArrayList<String> itemArray = ReadObject.readArray("Item.txt");

      if (itemArray.size() > 0) {
        // Get the last line of the item array list
        String lastLine = itemArray.get(itemArray.size() - 1);
        // Split the line into an array
        String[] lastLineDetails = lastLine.split(",");
        // Read the ID of the line and add by 1
        intItemId = Integer.valueOf(lastLineDetails[0].substring(1)) + 1;
        // Add 'PI' and leading zeros to the ID
        itemId = "PI" + String.format("%08d", intItemId);
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no exsting items
    }
    
    // Return the value of the new Item ID
    return itemId;
  }

  public static void register(ProductItem item) {
    // Write the new item into the Item database
    WriteObject.write(item, "Item.txt", true);
    // Record the action into the log
    ActionLog.log("Registered new Item (" + item.getItemId() + ")");
  }

  public static void update(ProductItem item) {
    int i = 0;
    File oldFile = new File("Item.txt");
    // Create a temporary file
    File tempFile = new File("TempItem.txt");

    try {
      // Create a item array list
      ArrayList<String> itemArray = ReadObject.readArray("Item.txt");
      // Iterate through the item array
      for (String itemDetails : itemArray) {
        // Split line into array
        String[] details = itemDetails.split(",");
        // Find the item with the matching ID
        if (details[0].equals(item.getItemId())) {
          // Write the new details into the temporary file
          WriteObject.write(item, "TempItem.txt", true);
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(itemArray.get(i), "TempItem.txt", true);
        }
        i++;
      }
      // Delete the old file
      oldFile.delete();
      // Rename the temporary file
      tempFile.renameTo(new File("Item.txt"));
      // Record the action into the log
      ActionLog.log("Updated item information (" + item.getItemId() + ")");
    } catch (FileNotFoundException e) {
      // Display the error message
      System.out.println(e);
    }
  }
  
  // Overrides the default toString() to display the information of the Product Item class
  @Override
  public String toString() {
    return String.valueOf(getItemId()) + "," + getItemName() + "," + getItemBrand() + "," + String.valueOf(getItemQuantity()) + "," + String.valueOf(getItemPrice()) + "," + getItemDescription() + "," + getItemImagePath() + "," + getItemSupplierId();
  }
}
