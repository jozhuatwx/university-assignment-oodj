package productmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ProductCategory {
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
    return ReadObject.generateId("CT", "ProductCategory.txt");
  }

  public static void register(ProductCategory category) {
    // Set default registered Category as false
    boolean registered = false;

    try {
      ArrayList<String> categoryArray = ReadObject.readArray("ProductCategory.txt");
      // Iterate through the Category array
      for (String categoryDetails : categoryArray) {
        // Split the line into an array
        String[] details = categoryDetails.split(",");
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
      // Write the new category into the Category database and log action
      WriteObject.write(category, "ProductCategory.txt", true, "Registered new Category (" + category.getCategoryId() + ")");
    } else {
      // Display the error message
      System.out.println("Product category already exists");
    }
  }

  public static void modify(ProductCategory category, boolean update) {
    int i = 0;
    File oldFile = new File("ProductCategory.txt");
    // Create a temporary file
    File tempFile = new File("TempProductCategory.txt");

    try {
      ArrayList<String> categoryArray = ReadObject.readArray("ProductCategory.txt");
      // Iterate through the Category array
      for (String categoryDetails : categoryArray) {
        // Split line into array
        String[] details = categoryDetails.split(",");
        // Find the Category with the matching ID
        if (details[0].equals(category.getCategoryId())) {
          if (update) {
            // Write the new details into the temporary file and log the action
            WriteObject.write(category, "TempProductCategory.txt", true, "Updated product category information (" + category.getCategoryId() + ")");
          } else {
            // Ignore the details and log the action
            WriteObject.log("Deleted product category information (" + category.getCategoryId() + ")");
          }
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(categoryArray.get(i), "TempProductCategory.txt", true);
        }
        i++;
      }
      // Delete the old file
      oldFile.delete();
      // Rename the temporary file
      tempFile.renameTo(new File("ProductCategory.txt"));
    } catch (FileNotFoundException e) {
      // Display the error message
      System.out.println(e);
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
      ArrayList<String> categoryArray = ReadObject.readArray("ProductCategory.txt");
      // Iterate through the Category array
      for (String categoryDetails : categoryArray) {
        // Split the line into an array
        String[] details = categoryDetails.split(",");
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
    return String.valueOf(getCategoryId()) + "," + getCategoryName() + "," + getCategoryDescription();
  }
}
