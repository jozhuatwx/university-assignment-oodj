package productmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ProductItem {
  private String itemId, itemName, itemBrand, itemDescription, itemImagePath, itemSupplierId, itemCategoryId;
  private int itemQuantity;
  private double itemPrice;

  // Construct the Product Item
  ProductItem(String itemId, String itemName, String itemBrand, int itemQuantity, double itemPrice, String itemDescription, String itemImagePath, String itemSupplierId, String itemCategoryId) {
    this.itemId = itemId;
    this.itemName = itemName;
    this.itemBrand = itemBrand;
    this.itemQuantity = itemQuantity;
    this.itemPrice = itemPrice;
    this.itemDescription = itemDescription;
    this.itemImagePath = itemImagePath;
    this.itemSupplierId = itemSupplierId;
    this.itemCategoryId = itemCategoryId;
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

  public String getItemCategoryId() {
    return itemCategoryId;
  }

  public void setItemCategoryId(String itemCategoryId) {
    this.itemCategoryId = itemCategoryId;
  }

  // Generate the Product Item ID
  public static String generateItemId() {
    // Set default ID to 1
    int intItemId = 1;
    String itemId = "PI00000001";

    try {
      ArrayList<String> itemArray = ReadObject.readArray("Item.txt");

      if (itemArray.size() > 0) {
        // Get the last line of the Item array list
        String lastLine = itemArray.get(itemArray.size() - 1);
        // Split the line into an array
        String[] lastLineDetails = lastLine.split(",");
        // Read the ID of the line and add by 1
        intItemId = Integer.valueOf(lastLineDetails[0].substring(2)) + 1;
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
    // Set default registered product item as false
    boolean registered = false;

    try {
      ArrayList<String> itemArray = ReadObject.readArray("Item.txt");
      // Iterate through the Item array
      for (String itemDetails : itemArray) {
        // Split the line into an array
        String[] details = itemDetails.split(",");
        // Find if any existing Item name and brand matches the registering Item
        if (details[1].equals(item.getItemName()) && details[2].equals(item.getItemBrand())) {
          // Set the Item as registered
          registered = true;
          // Stop the iteration
          break;
        }
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing Items
    }

    if (!registered) {
      // Write the new item into the Item database and log action
      WriteObject.write(item, "Item.txt", true, "Registered new Item (" + item.getItemId() + ")");
    } else {
      // Display the error message
      System.out.println("Product item is registered");
    }
  }

  public static void modify(ProductItem item, boolean update) {
    int i = 0;
    File oldFile = new File("Item.txt");
    // Create a temporary file
    File tempFile = new File("TempItem.txt");

    try {
      // Create a item array list
      ArrayList<String> itemArray = ReadObject.readArray("Item.txt");
      // Iterate through the Item array
      for (String itemDetails : itemArray) {
        // Split line into array
        String[] details = itemDetails.split(",");
        // Find the Item with the matching ID
        if (details[0].equals(item.getItemId())) {
          if (update) {
            // Write the new details into the temporary file and log the action
            WriteObject.write(item, "TempItem.txt", true, "Updated item product information (" + item.getItemId() + ")");
          } else {
            // Ignore the details and log the action
            WriteObject.log("Deleted product item information (" + item.getItemId() + ")");
          }
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
    } catch (FileNotFoundException e) {
      // Display the error message
      System.out.println(e);
    }
  }

  public static void update(ProductItem item) {
    modify(item, true);
  }

  public static void delete(String itemId) {
    ProductItem item = new ProductItem(itemId, "", "", 0, 0.0, "", "", "", "");
    modify(item, false);
  }

  public static ProductItem search(String keyword) {
    ProductItem item = new ProductItem("-1", "", "", 0, 0.0, "", "", "", "");

    try {
      ArrayList<String> itemArray = ReadObject.readArray("Item.txt");
      // Iterate through the Item array
      for (String itemDetails : itemArray) {
        // Split the line into an array
        String[] details = itemDetails.split(",");
        // Find if any existing Item matches the keyword
        if (details[1].contains(keyword) || details[2].contains(keyword) || details[5].contains(keyword)) {
          // Get Item information
          item = new ProductItem(details[0], details[1], details[2], Integer.valueOf(details[3]), Double.valueOf(details[4]), details[5], details[6], details[7], details[8]);
          // Stop the iteration
          break;
        }
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing Items
    }
    return item;
  }
  
  // Overrides the default toString() to display the information of the Product Item class
  @Override
  public String toString() {
    return String.valueOf(getItemId()) + "," + getItemName() + "," + getItemBrand() + "," + String.valueOf(getItemQuantity()) + "," + String.valueOf(getItemPrice()) + "," + getItemDescription() + "," + getItemImagePath() + "," + getItemSupplierId();
  }
}
