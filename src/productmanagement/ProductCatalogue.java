package productmanagement;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductCatalogue {
  // Constant fields
  public static final String FILE_NAME = "ProductCatalogue.txt";
  public static final String TEMP_FILE_NAME = "TempProductCatalogue.txt";
  public static final String ACTIVE = "active";
  public static final String INACTIVE = "inactive";

  // Product Catalogue fields
  private String catalogueId, catalogueTitle, catalogueBannerPath, catalogueDescription, catalogueUserId, catalogueStatus;
  private LocalDate catalogueStartDate, catalogueEndDate;
  private LocalDateTime catalogueGeneratedDateTime;

  // Construct the Product Catalogue
  ProductCatalogue(String catalogueId, String catalogueTitle, String catalogueBannerPath, String catalogueDescription, LocalDate catalogueStartDate, LocalDate catalogueEndDate, LocalDateTime catalogueGeneratedDateTime, String catalogueUserId, String catalogueStatus) {
    this.catalogueId = catalogueId;
    this.catalogueTitle = catalogueTitle;
    this.catalogueBannerPath = catalogueBannerPath;
    this.catalogueDescription = catalogueDescription;
    this.catalogueStartDate = catalogueStartDate;
    this.catalogueEndDate = catalogueEndDate;
    this.catalogueGeneratedDateTime = catalogueGeneratedDateTime;
    this.catalogueUserId = catalogueUserId;
    this.catalogueStatus = catalogueStatus;
  }

  ProductCatalogue(String[] details) {
    this(details[0], details[1], details[2], details[3], LocalDate.parse(details[4]), LocalDate.parse(details[5]), LocalDateTime.parse(details[6]), details[7], details[8]);
  }

  // Getters and setters
  public String getCatalogueId() {
    return catalogueId;
  }

  public String getCatalogueTitle() {
    return catalogueTitle;
  }

  public String getCatalogueBannerPath() {
    return catalogueBannerPath;
  }

  public String getCatalogueDescription() {
    return catalogueDescription;
  }

  public LocalDate getCatalogueStartDate() {
    return catalogueStartDate;
  }

  public LocalDate getCatalogueEndDate() {
    return catalogueEndDate;
  }

  public LocalDateTime getCatalogueGeneratedDateTime() {
    return catalogueGeneratedDateTime;
  }

  public String getCatalogueUserId() {
    return catalogueUserId;
  }

  public String getCatalogueStatus() {
    return catalogueStatus;
  }

  // Generate the Product Catalogue ID
  public static String generateCatalogueId() {
    return ReadObject.generateId("CL", FILE_NAME);
  }

  public static boolean register(ProductCatalogue catalogue) {
    // Set default registered Catalogue as false
    boolean registered = false;

    try {
      ArrayList<String> catalogueArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Catalogue array
      for (String catalogueDetails : catalogueArray) {
        // Split the line into an array
        String[] details = catalogueDetails.split(";");
        // Find if any existing Catalogue title matches the registering Catalogue
        if (details[1].equalsIgnoreCase(catalogue.getCatalogueTitle())) {
          // Set the Catalogue as registered
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
      // Write the new Catalogue into the Catalogue database and log action
      return WriteObject.write(catalogue, FILE_NAME, true, "Registered new Catalogue (" + catalogue.getCatalogueId() + ")", true);
    } else {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), "Catalogue title is taken, please try another title", "Warning", JOptionPane.WARNING_MESSAGE);
    }
    return false;
  }

  public static boolean modify(ProductCatalogue catalogue, String oldStatus) {
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
        if (details[0].equalsIgnoreCase(catalogue.getCatalogueId())) {
          if (oldStatus.equalsIgnoreCase(INACTIVE) && catalogue.getCatalogueStatus().equalsIgnoreCase(ACTIVE)) {
            // Write the new details into the temporary file and log the action
            WriteObject.write(catalogue, TEMP_FILE_NAME, true, "Activated product catalogue (" + catalogue.getCatalogueId() + ")", true);
          } else if (oldStatus.equalsIgnoreCase(ACTIVE) && catalogue.getCatalogueStatus().equalsIgnoreCase(ACTIVE)) {
            WriteObject.write(catalogue, TEMP_FILE_NAME, true, "Updated product catalogue (" + catalogue.getCatalogueId() + ")", true);
          } else if (oldStatus.equalsIgnoreCase(ACTIVE) && catalogue.getCatalogueStatus().equalsIgnoreCase(INACTIVE)) {
            WriteObject.write(catalogue, TEMP_FILE_NAME, true, "Deactivated product catalogue (" + catalogue.getCatalogueId() + ")", true);
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
      return tempFile.renameTo(new File(FILE_NAME));
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return false;
  }

  public static ArrayList<ProductCatalogue> search(String keyword) {
    keyword = keyword.toLowerCase();
    ArrayList<ProductCatalogue> catalogueArrayList = new ArrayList<>();

    try {
      ArrayList<String> catalogueArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Catalogue array
      for (String catalogueDetails : catalogueArray) {
        // Split the line into an array
        String[] details = catalogueDetails.split(";");
        // Find if any existing Catalogue matches the keyword
        if (details[1].toLowerCase().contains(keyword) || details[3].toLowerCase().contains(keyword)) {
          // Get Catalogue information
          ProductCatalogue catalogue = new ProductCatalogue(details);
          catalogueArrayList.add(catalogue);
        }
      }
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return catalogueArrayList;
  }

  public static String[] latestCatalogue() {
    String[] latestCatalogue = {"", "No Catalogue", "", "", "", "", "", "", ""};
    try {
      ArrayList<String> catalogueArray = ReadObject.readArray(FILE_NAME);
      if (catalogueArray.size() > 0) {
        latestCatalogue = catalogueArray.get(catalogueArray.size() - 1).split(";");
        // Format the date to dd-MM-YYYY
        latestCatalogue[4] = LocalDate.parse(latestCatalogue[4]).format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
        latestCatalogue[5] = LocalDate.parse(latestCatalogue[5]).format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
      }

    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return latestCatalogue;
  }

  // Overrides the default toString() to display the information of the Product Catalogue class
  @Override
  public String toString() {
    return getCatalogueId() + ";" + getCatalogueTitle() + ";" + getCatalogueBannerPath() + ";" + getCatalogueDescription() + ";" + getCatalogueStartDate() + ";" + getCatalogueEndDate() + ";" + getCatalogueGeneratedDateTime() + ";" + getCatalogueUserId() + ";" + getCatalogueStatus();
  }
}
