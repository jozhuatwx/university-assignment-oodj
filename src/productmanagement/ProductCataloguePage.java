package productmanagement;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductCataloguePage {
  // Constant variables
  public static final String FILE_NAME = "ProductCataloguePage.txt";
  public static final String TEMP_FILE_NAME = "TempProductCataloguePage.txt";
  public static final String ACTIVE = "active";
  public static final String INACTIVE = "inactive";

  // Product Catalogue Page fields
  private String pageId, pageCatalogueId, pageStatus;
  private int pageNumber;
  private String[] pageItemIds;

  // Construct the Product Catalogue Page
  ProductCataloguePage(String pageId, int pageNumber, String[] pageItemIds, String pageCatalogueId, String pageStatus) {
    this.pageId = pageId;
    this.pageNumber = pageNumber;
    this.pageItemIds = pageItemIds;
    this.pageCatalogueId = pageCatalogueId;
    this.pageStatus = pageStatus;
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

  public String getPageStatus() {
    return pageStatus;
  }
  
  public void setPageStatus(String pageStatus) {
    this.pageStatus = pageStatus;
  }

  // Generate the Product Catalogue Page ID
  public static String generatePageId() {
    return ReadObject.generateId("PG", FILE_NAME);
  }

  public static void register(ProductCataloguePage page) {
    // Write the new Page into the Page database and log the action
    WriteObject.write(page, FILE_NAME, true, "Registered new Catalogue Page (" + page.getPageCatalogueId() + ")", true);
  }

  public static void modify(ProductCataloguePage page) {
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
        if (details[0].equalsIgnoreCase(page.getPageId())) {
          if (page.getPageStatus().equalsIgnoreCase(ACTIVE)) {
            // Write the new details into the temporary file and log the action
            WriteObject.write(page, TEMP_FILE_NAME, true, "Updated product catalogue page information (" + page.getPageId() + ")", true);
          } else {
            WriteObject.write(page, TEMP_FILE_NAME, true, "Deactived product catalogue page information (" + page.getPageId() + ")", true);
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
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
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

    string += ";" + getPageCatalogueId() + ";" + getPageStatus();
    return string;
  }
}
