package productmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductCategory {
  // Constant variables
  public static final String FILE_NAME = "ProductCategory.txt";
  public static final String TEMP_FILE_NAME = "TempProductCategory.txt";

  // Product Category fields
  private String categoryId, categoryName, categoryDescription;

  // Construct the Product Category
  ProductCategory(String categoryId, String categoryName, String categoryDescription) {
    this.categoryId = categoryId;
    this.categoryName = categoryName;
    this.categoryDescription = categoryDescription;
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
        if (details[1].equals(category.getCategoryName())) {
          // Set the Category as registered
          registered = true;
          // Stop the iteration
          break;
        }
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing categorys
    }

    if (!registered) {
      // Write the new Category into the Category database and log the action
      WriteObject.write(category, FILE_NAME, true, "Registered new Category (" + category.getCategoryId() + ")");
    } else {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), "Product category already exists", "Alert", JOptionPane.WARNING_MESSAGE);
    }
  }

  public static void modify(ProductCategory category, boolean update) {
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
        if (details[0].equals(category.getCategoryId())) {
          if (update) {
            // Write the new details into the temporary file and log the action
            WriteObject.write(category, TEMP_FILE_NAME, true, "Updated product category information (" + category.getCategoryId() + ")");
          } else {
            // Ignore the details and log the action
            WriteObject.log("Deleted product category information (" + category.getCategoryId() + ")");
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
    } catch (FileNotFoundException e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
    }
  }

  public static void update(ProductCategory category) {
    modify(category, true);
  }

  public static void delete(String categoryId) {
    ProductCategory category = new ProductCategory(categoryId, "", "");
    modify(category, false);
  }

  public static ProductCategory search(String keyword) {
    ProductCategory category = new ProductCategory("-1", "", "");

    try {
      ArrayList<String> categoryArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Category array
      for (String categoryDetails : categoryArray) {
        // Split the line into an array
        String[] details = categoryDetails.split(";");
        // Find if any existing Category matches the keyword
        if (details[1].contains(keyword) || details[2].contains(keyword)) {
          // Get Category information
          category = new ProductCategory(details[0], details[1], details[2]);
          // Stop the iteration
          break;
        }
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing Categories
    }
    return category;
  }

  // Overrides the default toString() to display the information of the Product Category class
  @Override
  public String toString() {
    return String.valueOf(getCategoryId()) + ";" + getCategoryName() + ";" + getCategoryDescription();
  }
}
