package productmanagement;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductItem {
  // Constant fields
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

  ProductItem(String[] details) {
    this(details[0], details[1], details[2], Double.valueOf(details[3]), details[4], details[5], details[6], details[7], details[8]);
  }

  // Getters and setters
  public String getItemId() {
    return itemId;
  }

  public String getItemName() {
    return itemName;
  }

  public String getItemBrand() {
    return itemBrand;
  }

  public double getItemPrice() {
    return itemPrice;
  }

  public String getItemDescription() {
    return itemDescription;
  }

  public String getItemImagePath() {
    return itemImagePath;
  }

  public String getItemSupplierId() {
    return itemSupplierId;
  }

  public String getItemCategoryId() {
    return itemCategoryId;
  }

  public String getItemStatus() {
    return itemStatus;
  }

  // Generate the Product Item ID
  public static String generateItemId() {
    return ReadObject.generateId("PI", FILE_NAME);
  }

  public static boolean register(ProductItem item, int itemQuantity) {
    // Set default registered product item as false
    boolean registered = false;

    try {
      ArrayList<String> itemArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Item array
      for (String itemDetails : itemArray) {
        // Split the line into an array
        String[] details = itemDetails.split(";");
        // Find if any existing Item name and brand matches the registering Item
        if (details[1].equalsIgnoreCase(item.getItemName()) && details[2].equalsIgnoreCase(item.getItemBrand())) {
          // Set the Item as registered
          registered = true;
          // Stop the iteration
          break;
        }
      }
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    if (!registered) {
      // Write the new item into the Item database and log action
      WriteObject.write(item, FILE_NAME, true, "Registered new Item (" + item.getItemId() + ")", true);
      InventoryTransaction transaction = new InventoryTransaction(item.getItemId(), itemQuantity);
      return InventoryTransaction.register(transaction);
    } else {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), "Product item already registered", "Warning", JOptionPane.WARNING_MESSAGE);
    }
    return false;
  }

  public static boolean modify(ProductItem item, int itemQuantity, String oldStatus) {
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
        if (details[0].equalsIgnoreCase(item.getItemId())) {
          if (oldStatus.equalsIgnoreCase(INACTIVE) && item.getItemStatus().equalsIgnoreCase(ACTIVE)) {
            // Write the new details into the temporary file and log the action
            WriteObject.write(item, TEMP_FILE_NAME, true, "Activated product item (" + item.getItemId() + ")", true);
          } else if (oldStatus.equalsIgnoreCase(ACTIVE) && item.getItemStatus().equalsIgnoreCase(ACTIVE)) {
            WriteObject.write(item, TEMP_FILE_NAME, true, "Updated product item (" + item.getItemId() + ")", true);
          } else if (oldStatus.equalsIgnoreCase(ACTIVE) && item.getItemStatus().equalsIgnoreCase(INACTIVE)) {
            WriteObject.write(item, TEMP_FILE_NAME, true, "Deactivated product item (" + item.getItemId() + ")", true);
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
      if (itemQuantity != 0) {
        InventoryTransaction transaction = new InventoryTransaction(item.getItemId(), itemQuantity);
        return InventoryTransaction.register(transaction);
      } else {
        return true;
      }
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return false;
  }

  public static ArrayList<ProductItem> search(String keyword) {
    keyword = keyword.toLowerCase();
    ArrayList<ProductItem> itemArrayList = new ArrayList<>();

    try {
      ArrayList<String> itemArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Item array
      for (String itemDetails : itemArray) {
        // Split the line into an array
        String[] details = itemDetails.split(";");
        // Find if any existing Item matches the keyword
        if (details[1].toLowerCase().contains(keyword) || details[2].toLowerCase().contains(keyword) || details[5].toLowerCase().contains(keyword)) {
          // Get Item information
          ProductItem item = new ProductItem(details);
          itemArrayList.add(item);
        }
      }
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return itemArrayList;
  }
  
  // Overrides the default toString() to display the information of the Product Item class
  @Override
  public String toString() {
    return getItemId() + ";" + getItemName() + ";" + getItemBrand() + ";" + String.valueOf(getItemPrice()) + ";" + getItemDescription() + ";" + getItemImagePath() + ";" + getItemSupplierId() + ";" + getItemCategoryId() + ";" + getItemStatus();
  }
}
