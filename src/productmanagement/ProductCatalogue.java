package productmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductCatalogue {
  // Constant variables
  public static final String FILE_NAME = "ProductCatalogue.txt";
  public static final String TEMP_FILE_NAME = "TempProductCatalogue.txt";
  public static final String ACTIVE = "active";
  public static final String INACTIVE = "inactive";

  // Product Catalogue fields
  private String catalogueId, catalogueTitle, catalogueBannerPath, catalogueDescription, catalogueUserId, catalogueStatus;
  private int cataloguePages;
  private LocalDate catalogueStartDate, catalogueEndDate;
  private LocalDateTime catalogueGeneratedDateTime;

  // Construct the Product Catalogue
  ProductCatalogue(String catalogueId, String catalogueTitle, String catalogueBannerPath, String catalogueDescription, int cataloguePages, LocalDate catalogueStartDate, LocalDate catalogueEndDate, LocalDateTime catalogueGeneratedDateTime, String catalogueUserId, String catalogueStatus) {
    this.catalogueId = catalogueId;
    this.catalogueTitle = catalogueTitle;
    this.catalogueBannerPath = catalogueBannerPath;
    this.catalogueDescription = catalogueDescription;
    this.cataloguePages = cataloguePages;
    this.catalogueStartDate = catalogueStartDate;
    this.catalogueEndDate = catalogueEndDate;
    this.catalogueGeneratedDateTime = catalogueGeneratedDateTime;
    this.catalogueUserId = catalogueUserId;
    this.catalogueStatus = catalogueStatus;
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

  public int getCataloguePages() {
    return cataloguePages;
  }

  public void setCataloguePages(int cataloguePages) {
    this.cataloguePages = cataloguePages;
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

  public void setCatalogueGeneratedDateTime(LocalDateTime catalogueGeneratedDateTime) {
    this.catalogueGeneratedDateTime = catalogueGeneratedDateTime;
  }

  public String getCatalogueUserId() {
    return catalogueUserId;
  }

  public void setCatalogueUserId(String catalogueUserId) {
    this.catalogueUserId = catalogueUserId;
  }

  public String getCatalogueStatus() {
    return catalogueStatus;
  }

  public void setCatalogueStatus(String catalogueStatus) {
    this.catalogueStatus = catalogueStatus;
  }

  // Generate the Product Catalogue ID
  public static String generateCatalogueId() {
    return ReadObject.generateId("CL", FILE_NAME);
  }

  public static void register(ProductCatalogue catalogue) {
    // Set default registered Catalogue as false
    boolean registered = false;

    try {
      ArrayList<String> catalogueArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Catalogue array
      for (String catalogueDetails : catalogueArray) {
        // Split the line into an array
        String[] details = catalogueDetails.split(";");
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
      WriteObject.write(catalogue, FILE_NAME, true, "Registered new Catalogue (" + catalogue.getCatalogueId() + ")");
    } else {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), "Catalogue title is taken, please try another title", "Alert", JOptionPane.WARNING_MESSAGE);
    }
  }

  public static void modify(ProductCatalogue catalogue, boolean update) {
    int i = 0;
    File oldFile = new File(FILE_NAME);
    // Create a temporary file
    File tempFile = new File(TEMP_FILE_NAME);

    try {
      ArrayList<String> catalogueArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Catalogue array
      for (String catalogueDetails : catalogueArray) {
        // Split line into array
        String[] details = catalogueDetails.split(";");
        // Find the Catalogue with the matching ID
        if (details[0].equals(catalogue.getCatalogueId())) {
          if (update) {
            // Write the new details into the temporary file and log the action
            WriteObject.write(catalogue, TEMP_FILE_NAME, true, "Updated product catalogue information (" + catalogue.getCatalogueId() + ")");
          } else {
            // Ignore the details and log the action
            WriteObject.log("Deleted product catalogue information (" + catalogue.getCatalogueId() + ")");
          }
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(catalogueArray.get(i), TEMP_FILE_NAME, true);
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

  public static void update(ProductCatalogue catalogue) {
    modify(catalogue, true);
  }

  public static void delete(String catalogueId) {
    ProductCatalogue catalogue = new ProductCatalogue(catalogueId, "", "", "", 0, LocalDate.now(), LocalDate.now(), LocalDateTime.now(), "", INACTIVE);
    modify(catalogue, false);
  }

  public static ProductCatalogue search(String keyword) {
    ProductCatalogue catalogue = new ProductCatalogue("-1", "", "", "", 0, LocalDate.now(), LocalDate.now(), LocalDateTime.now(), "", ACTIVE);

    try {
      ArrayList<String> catalogueArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Catalogue array
      for (String catalogueDetails : catalogueArray) {
        // Split the line into an array
        String[] details = catalogueDetails.split(";");
        // Find if any existing Catalogue matches the keyword
        if (details[1].contains(keyword) || details[3].contains(keyword)) {
          // Get Catalogue information
          catalogue = new ProductCatalogue(details[0], details[1], details[2], details[3], Integer.valueOf(details[4]), LocalDate.parse(details[5]), LocalDate.parse(details[6]), LocalDateTime.parse(details[7]), details[8], details[9]);
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
    return String.valueOf(getCatalogueId()) + ";" + getCatalogueTitle() + ";" + getCatalogueBannerPath() + ";" + getCatalogueDescription() + ";" + getCatalogueStartDate() + ";" + getCatalogueEndDate() + ";" + getCatalogueGeneratedDateTime() + ";" + getCatalogueUserId() + ";" + getCatalogueStatus();
  }
}
