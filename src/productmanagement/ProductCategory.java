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
    // Set default ID to 1
    int intCategoryId = 1;
    String categoryId = "CT00000001";

    try {
      // Create a category array list
      ArrayList<String> categoryArray = ReadObject.readArray("Category.txt");

      if (categoryArray.size() > 0) {
        // Get the last line of the category array list
        String lastLine = categoryArray.get(categoryArray.size() - 1);
        // Split the line into an array
        String[] lastLineDetails = lastLine.split(",");
        // Read the ID of the line and add by 1
        intCategoryId = Integer.valueOf(lastLineDetails[0].substring(1)) + 1;
        // Add 'CT' and leading zeros to the ID
        categoryId = "CT" + String.format("%08d", intCategoryId);
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no exsting categorys
    }
    
    // Return the value of the new Category ID
    return categoryId;
  }

  public static void register(ProductCategory category) {
    // Set default registered Category as false
    boolean registered = false;
    // Create a category array
    try {
      ArrayList<String> categoryArray = ReadObject.readArray("Category.txt");

      // Iterate through the category array
      for (String categoryDetails : categoryArray) {
        // Split the line into an array
        String[] details = categoryDetails.split(",");
        // Find if any existing category name matches the registering category
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
      WriteObject.write(category, "Category.txt", true, "Registered new Category (" + category.getCategoryId() + ")");
    } else {
      // Display the error message
      System.out.println("Product category already exists");
    }
  }

  public static void update(ProductCategory category) {
    int i = 0;
    File oldFile = new File("Category.txt");
    // Create a temporary file
    File tempFile = new File("TempCategory.txt");

    try {
      // Create a category array list
      ArrayList<String> categoryArray = ReadObject.readArray("Category.txt");
      // Iterate through the category array
      for (String categoryDetails : categoryArray) {
        // Split line into array
        String[] details = categoryDetails.split(",");
        // Find the category with the matching ID
        if (details[0].equals(category.getCategoryId())) {
          // Write the new details into the temporary file and log action
          WriteObject.write(category, "TempCategory.txt", true, "Updated category information (" + category.getCategoryId() + ")");
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(categoryArray.get(i), "TempCategory.txt", true);
        }
        i++;
      }
      // Delete the old file
      oldFile.delete();
      // Rename the temporary file
      tempFile.renameTo(new File("Category.txt"));
    } catch (FileNotFoundException e) {
      // Display the error message
      System.out.println(e);
    }
  }

  public static ProductCategory search(String categoryName) {
    ProductCategory category = new ProductCategory("-1", "", "");

    try {
      ArrayList<String> categoryArray = ReadObject.readArray("Category.txt");

      // Iterate through the category array
      for (String categoryDetails : categoryArray) {
        // Split the line into an array
        String[] details = categoryDetails.split(",");
        // Find if any existing category name matches the registering category
        if (details[1].equals(categoryName)) {
          // Get category information
          category = new ProductCategory(details[0], details[1], details[2]);
          // Stop the iteration
          break;
        }
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing categorys
    }
    return category;
  }

  // Overrides the default toString() to display the information of the Product Category class
  @Override
  public String toString() {
    return String.valueOf(getCategoryId()) + "," + getCategoryName() + "," + getCategoryDescription();
  }
}
