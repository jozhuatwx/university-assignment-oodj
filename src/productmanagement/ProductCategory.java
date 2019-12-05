package productmanagement;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductCategory {
  // Constant fields
  public static final String FILE_NAME = "ProductCategory.txt";
  public static final String TEMP_FILE_NAME = "TempProductCategory.txt";
  public static final String ACTIVE = "active";
  public static final String INACTIVE = "inactive";

  // Product Category fields
  private String categoryId, categoryName, categoryDescription, categoryStatus;

  // Construct the Product Category
  ProductCategory(String categoryId, String categoryName, String categoryDescription, String categoryStatus) {
    this.categoryId = categoryId;
    this.categoryName = categoryName;
    this.categoryDescription = categoryDescription;
    this.categoryStatus = categoryStatus;
  }

  ProductCategory(String[] details) {
    this(details[0], details[1], details[2], details[3]);
  }

  // Getters and setters
  public String getCategoryId() {
    return categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public String getCategoryDescription() {
    return categoryDescription;
  }

  public String getCategoryStatus() {
    return categoryStatus;
  }

  // Generate the Product Category ID
  public static String generateCategoryId() {
    return ReadObject.generateId("CT", FILE_NAME);
  }

  public static boolean register(ProductCategory category) {
    // Set default registered Category as false
    boolean registered = false;

    try {
      ArrayList<String> categoryArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Category array
      for (String categoryDetails : categoryArray) {
        // Split the line into an array
        String[] details = categoryDetails.split(";");
        // Find if any existing Category name matches the registering Category
        if (details[1].equalsIgnoreCase(category.getCategoryName())) {
          // Set the Category as registered
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
      // Write the new Category into the Category database and log the action
      WriteObject.write(category, FILE_NAME, true, "Registered new Category (" + category.getCategoryId() + ")", true);
      return true;
    } else {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), "Product category already exists", "Warning", JOptionPane.WARNING_MESSAGE);
    }
    return false;
  }

  public static boolean modify(ProductCategory category, String oldStatus) {
    int i = 0;
    File oldFile = new File(FILE_NAME);
    // Create a temporary file
    File tempFile = new File(TEMP_FILE_NAME);

    try {
      ArrayList<String> categoryArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Category array
      for (String categoryDetails : categoryArray) {
        // Split line into array
        String[] details = categoryDetails.split(";");
        // Find the Category with the matching ID
        if (details[0].equalsIgnoreCase(category.getCategoryId())) {
          if (oldStatus.equalsIgnoreCase(INACTIVE) && category.getCategoryStatus().equalsIgnoreCase(ACTIVE)) {
            // Write the new details into the temporary file and log the action
            WriteObject.write(category, TEMP_FILE_NAME, true, "Activated product category (" + category.getCategoryId() + ")", true);
          } else if (oldStatus.equalsIgnoreCase(ACTIVE) && category.getCategoryStatus().equalsIgnoreCase(ACTIVE)) {
            WriteObject.write(category, TEMP_FILE_NAME, true, "Updated product category (" + category.getCategoryId() + ")", true);
          } else if (oldStatus.equalsIgnoreCase(ACTIVE) && category.getCategoryStatus().equalsIgnoreCase(INACTIVE)) {
            WriteObject.write(category, TEMP_FILE_NAME, true, "Deactivated product category (" + category.getCategoryId() + ")", true);
          }
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(categoryArray.get(i), TEMP_FILE_NAME, true);
        }
        i++;
      }
      // Delete the old file
      oldFile.delete();
      // Rename the temporary file
      tempFile.renameTo(new File(FILE_NAME));
      return true;
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return false;
  }

  public static ArrayList<ProductCategory> search(String keyword) {
    keyword = keyword.toLowerCase();
    ArrayList<ProductCategory> categoryArrayList = new ArrayList<>();

    try {
      ArrayList<String> categoryArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Category array
      for (String categoryDetails : categoryArray) {
        // Split the line into an array
        String[] details = categoryDetails.split(";");
        // Find if any existing Category matches the keyword
        if (details[1].toLowerCase().contains(keyword) || details[2].toLowerCase().contains(keyword)) {
          // Get Category information
          ProductCategory category = new ProductCategory(details);
          categoryArrayList.add(category);
        }
      }
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return categoryArrayList;
  }

  // Overrides the default toString() to display the information of the Product Category class
  @Override
  public String toString() {
    return getCategoryId() + ";" + getCategoryName() + ";" + getCategoryDescription() + ";" + getCategoryStatus();
  }
}
