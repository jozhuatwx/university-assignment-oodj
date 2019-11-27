package productmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductItem {
  // Constant variables
  public static final String FILE_NAME = "ProductItem.txt";
  public static final String TEMP_FILE_NAME = "TempProductItem.txt";
  public static final String ACTIVE = "active";
  public static final String INACTIVE = "inactive";

  // Product Item fields
  private String itemId, itemName, itemBrand, itemDescription, itemImagePath, itemSupplierId, itemCategoryId, itemStatus;
  private double itemPrice;

  // Construct the Product Item
  ProductItem(String itemId, String itemName, String itemBrand, double itemPrice, String itemDescription, String itemImagePath, String itemSupplierId, String itemCategoryId, String itemStatus) {
    this.itemId = itemId;
    this.itemName = itemName;
    this.itemBrand = itemBrand;
    this.itemPrice = itemPrice;
    this.itemDescription = itemDescription;
    this.itemImagePath = itemImagePath;
    this.itemSupplierId = itemSupplierId;
    this.itemCategoryId = itemCategoryId;
    this.itemStatus = itemStatus;
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

  public String getItemStatus() {
    return itemStatus;
  }

  public void setItemStatus(String itemStatus) {
    this.itemStatus = itemStatus;
  }

  // Generate the Product Item ID
  public static String generateItemId() {
    return ReadObject.generateId("PI", FILE_NAME);
  }

  public static void register(ProductItem item, int itemQuantity) {
    // Set default registered product item as false
    boolean registered = false;

    try {
      ArrayList<String> itemArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Item array
      for (String itemDetails : itemArray) {
        // Split the line into an array
        String[] details = itemDetails.split(";");
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
      WriteObject.write(item, FILE_NAME, true, "Registered new Item (" + item.getItemId() + ")");
      InventoryTransaction transaction = new InventoryTransaction(item.getItemId(), itemQuantity);
      InventoryTransaction.register(transaction);
    } else {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), "Product item already registered", "Warning", JOptionPane.WARNING_MESSAGE);
    }
  }

  public static void modify(ProductItem item) {
    int i = 0;
    File oldFile = new File(FILE_NAME);
    // Create a temporary file
    File tempFile = new File(TEMP_FILE_NAME);

    try {
      // Create a item array list
      ArrayList<String> itemArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Item array
      for (String itemDetails : itemArray) {
        // Split line into array
        String[] details = itemDetails.split(";");
        // Find the Item with the matching ID
        if (details[0].equals(item.getItemId())) {
          if (item.getItemStatus().equals(ACTIVE)) {
            // Write the new details into the temporary file and log the action
            WriteObject.write(item, TEMP_FILE_NAME, true, "Updated item product information (" + item.getItemId() + ")");
          } else {
            WriteObject.write(item, TEMP_FILE_NAME, true, "Deactivated item product information (" + item.getItemId() + ")");
          }
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(itemArray.get(i), TEMP_FILE_NAME, true);
        }
        i++;
      }
      // Delete the old file
      oldFile.delete();
      // Rename the temporary file
      tempFile.renameTo(new File(FILE_NAME));
    } catch (FileNotFoundException e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  public static ProductItem search(String keyword) {
    ProductItem item = new ProductItem("-1", "", "", 0.0, "", "", "", "", ACTIVE);

    try {
      ArrayList<String> itemArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Item array
      for (String itemDetails : itemArray) {
        // Split the line into an array
        String[] details = itemDetails.split(";");
        // Find if any existing Item matches the keyword
        if (details[1].contains(keyword) || details[2].contains(keyword) || details[5].contains(keyword)) {
          // Get Item information
          item = new ProductItem(details[0], details[1], details[2], Double.valueOf(details[3]), details[4], details[5], details[6], details[7], details[8]);
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
    return getItemId() + ";" + getItemName() + ";" + getItemBrand() + ";" + String.valueOf(getItemPrice()) + ";" + getItemDescription() + ";" + getItemImagePath() + ";" + getItemSupplierId() + ";" + getItemStatus();
  }
}
