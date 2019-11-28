package productmanagement;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductCategory {
  // Constant variables
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

  // Getters and setters
  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getCategoryDescription() {
    return categoryDescription;
  }

  public void setCategoryDescription(String categoryDescription) {
    this.categoryDescription = categoryDescription;
  }

  public String getCategoryStatus() {
    return categoryStatus;
  }

  public void setCategoryStatus(String categoryStatus) {
    this.categoryStatus = categoryStatus;
  }

  // Generate the Product Category ID
  public static String generateCategoryId() {
    return ReadObject.generateId("CT", FILE_NAME);
  }

  public static void register(ProductCategory category) {
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
    } else {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), "Product category already exists", "Warning", JOptionPane.WARNING_MESSAGE);
    }
  }

  public static void modify(ProductCategory category) {
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
          if (category.getCategoryStatus().equalsIgnoreCase(ACTIVE)) {
            // Write the new details into the temporary file and log the action
            WriteObject.write(category, TEMP_FILE_NAME, true, "Updated product category information (" + category.getCategoryId() + ")", true);
          } else {
            WriteObject.write(category, TEMP_FILE_NAME, true, "Deactivated product category information (" + category.getCategoryId() + ")", true);
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
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  public static ProductCategory search(String keyword) {
    ProductCategory category = new ProductCategory("-1", "", "", ACTIVE);

    try {
      ArrayList<String> categoryArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Category array
      for (String categoryDetails : categoryArray) {
        // Split the line into an array
        String[] details = categoryDetails.split(";");
        // Find if any existing Category matches the keyword
        if (details[1].contains(keyword) || details[2].contains(keyword)) {
          // Get Category information
          category = new ProductCategory(details[0], details[1], details[2], details[3]);
          // Stop the iteration
          break;
        }
      }
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return category;
  }

  // Overrides the default toString() to display the information of the Product Category class
  @Override
  public String toString() {
    return String.valueOf(getCategoryId()) + ";" + getCategoryName() + ";" + getCategoryDescription() + ";" + getCategoryStatus();
  }
}
