package productmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ProductCatalogue {
  private String catalogueId, catalogueTitle, catalogueBannerPath, catalogueDescription, catalogueUserId;
  private LocalDate catalogueStartDate, catalogueEndDate;
  private LocalDateTime catalogueGeneratedDateTime;

  // Construct the Product Catalogue
  ProductCatalogue(String catalogueId, String catalogueTitle, String catalogueBannerPath, String catalogueDescription, LocalDate catalogueStartDate, LocalDate catalogueEndDate, LocalDateTime catalogueGeneratedDateTime, String catalogueUserId) {
    this.catalogueId = catalogueId;
    this.catalogueTitle = catalogueTitle;
    this.catalogueBannerPath = catalogueBannerPath;
    this.catalogueDescription = catalogueDescription;
    this.catalogueStartDate = catalogueStartDate;
    this.catalogueEndDate = catalogueEndDate;
    this.catalogueGeneratedDateTime = catalogueGeneratedDateTime;
    this.catalogueUserId = catalogueUserId;
  }

  // Getters and setters
  public String getCatalogueId() {
    return catalogueId;
  }

  public void setCatalogueId(String catalogueId) {
    this.catalogueId = catalogueId;
  }

  public String getCatalogueTitle() {
    return catalogueTitle;
  }

  public void setCatalogueTitle(String catalogueTitle) {
    this.catalogueTitle = catalogueTitle;
  }

  public String getCatalogueBannerPath() {
    return catalogueBannerPath;
  }

  public void setCatalogueBannerPath(String catalogueBannerPath) {
    this.catalogueBannerPath = catalogueBannerPath;
  }

  public String getCatalogueDescription() {
    return catalogueDescription;
  }

  public void setCatalogueDescription(String catalogueDescription) {
    this.catalogueDescription = catalogueDescription;
  }

  public LocalDate getCatalogueStartDate() {
    return catalogueStartDate;
  }

  public void setCatalogueStartDate(LocalDate catalogueStartDate) {
    this.catalogueStartDate = catalogueStartDate;
  }

  public LocalDate getCatalogueEndDate() {
    return catalogueEndDate;
  }

  public void setCatalogueEndDate(LocalDate catalogueEndDate) {
    this.catalogueEndDate = catalogueEndDate;
  }

  public LocalDateTime getCatalogueGeneratedDateTime() {
    return catalogueGeneratedDateTime;
  }

  public void setCatalogueGeneratedDate(LocalDateTime catalogueGeneratedDateTime) {
    this.catalogueGeneratedDateTime = catalogueGeneratedDateTime;
  }

  public String getCatalogueUserId() {
    return catalogueUserId;
  }

  public void setCatalogueUserId(String catalogueUserId) {
    this.catalogueUserId = catalogueUserId;
  }

  // Generate the Product Catalogue ID
  public static String generateCatalogueId() {
    return ReadObject.generateId("CL", "ProductCatalogue.txt");
  }

  public static void register(ProductCatalogue catalogue) {
    // Set default registered Catalogue as false
    boolean registered = false;

    try {
      ArrayList<String> catalogueArray = ReadObject.readArray("ProductCatalogue.txt");
      // Iterate through the Catalogue array
      for (String catalogueDetails : catalogueArray) {
        // Split the line into an array
        String[] details = catalogueDetails.split(",");
        // Find if any existing Catalogue title matches the registering Catalogue
        if (details[1].equals(catalogue.getCatalogueTitle())) {
          // Set the Catalogue as registered
          registered = true;
          // Stop the iteration
          break;
        }
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing Catalogues
    }

    if (!registered) {
      // Write the new Catalogue into the Catalogue database and log action
      WriteObject.write(catalogue, "ProductCatalogue.txt", true, "Registered new Catalogue (" + catalogue.getCatalogueId() + ")");
    } else {
      // Display the error message
      System.out.println("Please use a different title");
    }
  }

  public static void modify(ProductCatalogue catalogue, boolean update) {
    int i = 0;
    File oldFile = new File("ProductCatalogue.txt");
    // Create a temporary file
    File tempFile = new File("TempProductCatalogue.txt");

    try {
      ArrayList<String> catalogueArray = ReadObject.readArray("ProductCatalogue.txt");
      // Iterate through the Catalogue array
      for (String catalogueDetails : catalogueArray) {
        // Split line into array
        String[] details = catalogueDetails.split(",");
        // Find the Catalogue with the matching ID
        if (details[0].equals(catalogue.getCatalogueId())) {
          if (update) {
            // Write the new details into the temporary file and log the action
            WriteObject.write(catalogue, "TempProductCatalogue.txt", true, "Updated product catalogue information (" + catalogue.getCatalogueId() + ")");
          } else {
            // Ignore the details and log the action
            WriteObject.log("Deleted product catalogue information (" + catalogue.getCatalogueId() + ")");
          }
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(catalogueArray.get(i), "TempProductCatalogue.txt", true);
        }
        i++;
      }
      // Delete the old file
      oldFile.delete();
      // Rename the temporary file
      tempFile.renameTo(new File("ProductCatalogue.txt"));
    } catch (FileNotFoundException e) {
      // Display the error message
      System.out.println(e);
    }
  }

  public static void update(ProductCatalogue catalogue) {
    modify(catalogue, true);
  }

  public static void delete(String catalogueId) {
    ProductCatalogue catalogue = new ProductCatalogue(catalogueId, "", "", "", LocalDate.now(), LocalDate.now(), LocalDateTime.now(), "");
    modify(catalogue, false);
  }

  public static ProductCatalogue search(String keyword) {
    ProductCatalogue catalogue = new ProductCatalogue("-1", "", "", "", LocalDate.now(), LocalDate.now(), LocalDateTime.now(), "");

    try {
      ArrayList<String> catalogueArray = ReadObject.readArray("ProductCatalogue.txt");
      // Iterate through the Catalogue array
      for (String catalogueDetails : catalogueArray) {
        // Split the line into an array
        String[] details = catalogueDetails.split(",");
        // Find if any existing Catalogue matches the keyword
        if (details[1].contains(keyword) || details[3].contains(keyword)) {
          // Get Catalogue information
          catalogue = new ProductCatalogue(details[0], details[1], details[2], details[3], LocalDate.parse(details[4]), LocalDate.parse(details[5]), LocalDateTime.parse(details[6]), details[7]);
          // Stop the iteration
          break;
        }
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing Catalogues
    }
    return catalogue;
  }

  // Overrides the default toString() to display the information of the Product Catalogue class
  @Override
  public String toString() {
    return String.valueOf(getCatalogueId()) + "," + getCatalogueTitle() + "," + getCatalogueBannerPath() + "," + getCatalogueDescription() + "," + getCatalogueStartDate() + "," + getCatalogueEndDate() + "," + getCatalogueGeneratedDateTime() + "," + getCatalogueUserId();
  }
}
