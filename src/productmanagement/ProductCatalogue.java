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
    // Set default ID to 1
    int intCatalogueId = 1;
    String catalogueId = "CL00000001";

    try {
      // Create a catalogue array list
      ArrayList<String> catalogueArray = ReadObject.readArray("Catalogue.txt");

      if (catalogueArray.size() > 0) {
        // Get the last line of the catalogue array list
        String lastLine = catalogueArray.get(catalogueArray.size() - 1);
        // Split the line into an array
        String[] lastLineDetails = lastLine.split(",");
        // Read the ID of the line and add by 1
        intCatalogueId = Integer.valueOf(lastLineDetails[0].substring(1)) + 1;
        // Add 'CT' and leading zeros to the ID
        catalogueId = "CL" + String.format("%08d", intCatalogueId);
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no exsting catalogues
    }
    
    // Return the value of the new Catalogue ID
    return catalogueId;
  }

  public static void register(ProductCatalogue catalogue) {
    // Write the new catalogue into the Catalogue database and log action
    WriteObject.write(catalogue, "Catalogue.txt", true, "Registered new Catalogue (" + catalogue.getCatalogueId() + ")");
  }

  public static void update(ProductCatalogue catalogue) {
    int i = 0;
    File oldFile = new File("Catalogue.txt");
    // Create a temporary file
    File tempFile = new File("TempCatalogue.txt");

    try {
      // Create a catalogue array list
      ArrayList<String> catalogueArray = ReadObject.readArray("Catalogue.txt");
      // Iterate through the catalogue array
      for (String catalogueDetails : catalogueArray) {
        // Split line into array
        String[] details = catalogueDetails.split(",");
        // Find the catalogue with the matching ID
        if (details[0].equals(catalogue.getCatalogueId())) {
          // Write the new details into the temporary file and log action
          WriteObject.write(catalogue, "TempCatalogue.txt", true, "Updated catalogue information (" + catalogue.getCatalogueId() + ")");
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(catalogueArray.get(i), "TempCatalogue.txt", true);
        }
        i++;
      }
      // Delete the old file
      oldFile.delete();
      // Rename the temporary file
      tempFile.renameTo(new File("Catalogue.txt"));
    } catch (FileNotFoundException e) {
      // Display the error message
      System.out.println(e);
    }
  }

  // Overrides the default toString() to display the information of the Product Catalogue class
  @Override
  public String toString() {
    return String.valueOf(getCatalogueId()) + "," + getCatalogueTitle() + "," + getCatalogueBannerPath() + "," + getCatalogueDescription() + "," + getCatalogueStartDate() + "," + getCatalogueEndDate() + "," + getCatalogueGeneratedDateTime() + "," + getCatalogueUserId();
  }
}
