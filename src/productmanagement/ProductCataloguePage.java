package productmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ProductCataloguePage {
  // Constant variables
  public static final String FILE_NAME = "ProductCataloguePage.txt";
  public static final String TEMP_FILE_NAME = "TempProductCataloguePage.txt";

  // Product Catalogue Page fields
  private String pageId, pageCatalogueId;
  private int pageNumber;
  private String[] pageItemIds;

  // Construct the Product Catalogue Page
  ProductCataloguePage(String pageId, int pageNumber, String[] pageItemIds, String pageCatalogueId) {
    this.pageId = pageId;
    this.pageNumber = pageNumber;
    this.pageItemIds = pageItemIds;
    this.pageCatalogueId = pageCatalogueId;
  }

  // Getters and setters
  public String getPageId() {
    return pageId;
  }

  public void setPageId(String pageId) {
    this.pageId = pageId;
  }

  public int getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  public String[] getPageItemIds() {
    return pageItemIds;
  }

  public void setPageItemIds(String[] pageItemIds) {
    this.pageItemIds = pageItemIds;
  }

  public int getPageNumberOfItems() {
    return getPageItemIds().length;
  }

  public String getPageCatalogueId() {
    return pageCatalogueId;
  }

  public void setPageCatalogueId(String pageCatalogueId) {
    this.pageCatalogueId = pageCatalogueId;
  }

  // Generate the Product Catalogue Page ID
  public static String generatePageId() {
    return ReadObject.generateId("PG", FILE_NAME);
  }

  public static void register(ProductCataloguePage page) {
    // Write the new Page into the Page database and log the action
    WriteObject.write(page, FILE_NAME, true, "Registered new Catalogue Page (" + page.getPageCatalogueId() + ")");
  }

  public static void modify(ProductCataloguePage page, boolean update) {
    int i = 0;
    File oldFile = new File(FILE_NAME);
    // Create a temporary file
    File tempFile = new File(TEMP_FILE_NAME);

    try {
      ArrayList<String> pageArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Page array
      for (String pageDetails : pageArray) {
        // Split line into array
        String[] details = pageDetails.split(";");
        // Find the Page with the matching ID
        if (details[0].equals(page.getPageId())) {
          if (update) {
            // Write the new details into the temporary file and log the action
            WriteObject.write(page, TEMP_FILE_NAME, true, "Updated product catalogue page information (" + page.getPageId() + ")");
          } else {
            // Ignore the details and log the action
            WriteObject.log("Deleted product catalogue page information (" + page.getPageId() + ")");
          }
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(pageArray.get(i), FILE_NAME, true);
        }
        i++;
      }
      // Delete the old file
      oldFile.delete();
      // Rename the temporary file
      tempFile.renameTo(new File(FILE_NAME));
    } catch (FileNotFoundException e) {
      // Display the error message
      System.out.println(e);
    }
  }

  public static void update(ProductCataloguePage page) {
    modify(page, true);
  }

  public static void delete(String pageId) {
    ProductCataloguePage page = new ProductCataloguePage(pageId, -1, null, "");
    modify(page, false);
  }

  // Overrides the default toString() method to display the information of the Product Catalogue Page class
  @Override
  public String toString() {
    String string = getPageId() + ";" + String.valueOf(getPageNumber()) + ";";
    
    // Set default first as true
    boolean first = true;
    // Convert string array into a string
    for (String itemId : getPageItemIds()) {
      if (!first) {
        string += "," + itemId;
      } else {
        string += itemId;
      }
    }

    string += ";" + getPageCatalogueId();
    return string;
  }
}
