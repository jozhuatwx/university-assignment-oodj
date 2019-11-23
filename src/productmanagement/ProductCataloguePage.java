package productmanagement;

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

  // Overrides the default toString() method to display the information of the Product Catalogue Page class
  @Override
  public String toString() {
    String string = getPageId() + ";";
    
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
