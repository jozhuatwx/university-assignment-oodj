package productmanagement;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductCataloguePage {
  // Constant fields
  public static final String FILE_NAME = "ProductCataloguePage.txt";
  public static final String TEMP_FILE_NAME = "TempProductCataloguePage.txt";
  public static final String ACTIVE = "active";
  public static final String INACTIVE = "inactive";

  // Product Catalogue Page fields
  private String pageId, pageCatalogueId, pageStatus;
  private int pageNumberOfItems, pageNumber;
  private String[] pageItemIds;

  // Construct the Product Catalogue Page
  ProductCataloguePage(String pageId, int pageNumber, int pageNumberOfItems, String[] pageItemIds, String pageCatalogueId, String pageStatus) {
    this.pageId = pageId;
    this.pageNumber = pageNumber;
    this.pageNumberOfItems = pageNumberOfItems;
    this.pageItemIds = pageItemIds;
    this.pageCatalogueId = pageCatalogueId;
    this.pageStatus = pageStatus;
  }

  ProductCataloguePage(String[] details) {
    this(details[0], Integer.valueOf(details[1]), Integer.valueOf(details[2]), details[3].split(","), details[4], details[5]);
  }

  // Getters and setters
  public String getPageId() {
    return pageId;
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
    return pageNumberOfItems;
  }

  public void setPageNumberOfItems(int pageNumberOfItems) {
    this.pageNumberOfItems = pageNumberOfItems;
  }

  public String getPageCatalogueId() {
    return pageCatalogueId;
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

  public static boolean register(ProductCataloguePage page) {
    // Write the new Page into the Page database and log the action
    return WriteObject.write(page, FILE_NAME, true, "Registered new Catalogue Page (" + page.getPageCatalogueId() + ")");
  }

  public static boolean modify(ArrayList<ProductCataloguePage> pageArrayList) {
    // Sort the Pages according to Product Catalogue Page Id
    Collections.sort(pageArrayList, ProductCataloguePage.idComparator);

    int i = 0, currentpage = 0;
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
        if (details[0].equalsIgnoreCase(pageArrayList.get(currentpage).getPageId())) {
          // Write the new details into the temporary file
          WriteObject.write(pageArrayList.get(currentpage), TEMP_FILE_NAME, true);
          if (pageArrayList.size() == (currentpage + 1)) {
            break;
          }
          // Next page
          currentpage++;
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(pageArray.get(i), TEMP_FILE_NAME, true);
        }
        i++;
      }
      // Delete the old file
      oldFile.delete();
      // Rename the temporary file
      tempFile.renameTo(new File(FILE_NAME));
      // Log the action
      Log.write("Updated product catalogue pages in " + pageArrayList.get(0).getPageCatalogueId());
      return true;
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return false;
  }

  // Overrides the default compare method to sort the Pages based on Page number
  public static Comparator<ProductCataloguePage> pageComparator = new Comparator<ProductCataloguePage>() {
    @Override
    public int compare(ProductCataloguePage page1, ProductCataloguePage page2) {
      if (page1.getPageNumber() < page2.getPageNumber()) {
        return -1;
      } else {
        if (page1.getPageNumber() == page2.getPageNumber()) {
          return 0;
        } else {
          return 1;
        }
      }
    }
  };

  // Overrides the default compare method to sort the Pages based on Page number
  public static Comparator<ProductCataloguePage> idComparator = new Comparator<ProductCataloguePage>() {
    @Override
    public int compare(ProductCataloguePage page1, ProductCataloguePage page2) {
      if (Integer.valueOf(page1.getPageId().substring(2)) < Integer.valueOf(page2.getPageId().substring(2))) {
        return -1;
      } else {
        if (page1.getPageId() == page2.getPageId()) {
          return 0;
        } else {
          return 1;
        }
      }
    }
  };

  // Overrides the default toString() method to display the information of the Product Catalogue Page class
  @Override
  public String toString() {
    String string = getPageId() + ";" + String.valueOf(getPageNumber()) + ";" + String.valueOf(getPageNumberOfItems())  + ";";
    
    int i = 0;
    // Convert string array into a string
    for (String itemId : getPageItemIds()) {
      if (i > 0) {
        string += "," + itemId;
      } else {
        string += itemId;
      }
      i++;
    }

    // At least four items
    for (; i < 4; i++) {
      if (i > 0) {
        string += ", ";
      } else {
        string += " ";
      }
    }

    string += ";" + getPageCatalogueId() + ";" + getPageStatus();
    return string;
  }
}
