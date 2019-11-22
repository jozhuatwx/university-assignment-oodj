package productmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Supplier {
  final static String ACTIVE = "active";
  final static String INACTIVE = "inactive";
  private String supplierId, supplierName, supplierAddress, supplierEmail, supplierContact, supplierStatus;

  // Construct the Supplier
  Supplier(String supplierId, String supplierName, String supplierAddress, String supplierEmail, String supplierContact, String supplierStatus) {
    this.supplierId = supplierId;
    this.supplierName = supplierName;
    this.supplierAddress = supplierAddress;
    this.supplierEmail = supplierEmail;
    this.supplierContact = supplierContact;
    this.supplierStatus = supplierStatus;
  }
  
  // Getters and setters
  public String getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(String supplierId) {
    this.supplierId = supplierId;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
  }

  public String getSupplierAddress() {
    return supplierAddress;
  }

  public void setSupplierAddress(String supplierAddress) {
    this.supplierAddress = supplierAddress;
  }

  public String getSupplierEmail() {
    return supplierEmail;
  }

  public void setSupplierEmail(String supplierEmail) {
    this.supplierEmail = supplierEmail;
  }

  public String getSupplierContact() {
    return supplierContact;
  }

  public void setSupplierContact(String supplierContact) {
    this.supplierContact = supplierContact;
  }

  public String getSupplierStatus() {
    return supplierStatus;
  }

  public void setSupplierStatus(String supplierStatus) {
    this.supplierStatus = supplierStatus;
  }

  // Generate the Supplier ID
  public static String generateSupplierId() {
    // Set default ID to 1
    int intSupplierId = 1;
    String supplierId = "S00000001";

    try {
      ArrayList<String> supplierArray = ReadObject.readArray("Supplier.txt");

      if (supplierArray.size() > 0) {
        // Get the last line of the Supplier array list
        String lastLine = supplierArray.get(supplierArray.size() - 1);
        // Split the line into an array
        String[] lastLineDetails = lastLine.split(",");
        // Read the ID of the line and add by 1
        intSupplierId = Integer.valueOf(lastLineDetails[0].substring(1)) + 1;
        // Add 'S' and leading zeros to the ID
        supplierId = "S" + String.format("%08d", intSupplierId);
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no exsting suppliers
    }
    // Return the value of the new Supplier ID
    return supplierId;
  }

  public static void register(Supplier supplier) {
    // Set default registered Supplier as false
    boolean registered = false;

    try {
      ArrayList<String> supplierArray = ReadObject.readArray("Supplier.txt");
      // Iterate through the Supplier array
      for (String supplierDetails : supplierArray) {
        // Split the line into an array
        String[] details = supplierDetails.split(",");
        // Find if any existing Supplier name matches the registering Supplier
        if (details[1].equals(supplier.getSupplierName())) {
          // Set the Supplier as registered
          registered = true;
          // Stop the iteration
          break;
        }
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing Suppliers
    }

    if (!registered) {
      // Write the new supplier into the Supplier database and log action
      WriteObject.write(supplier, "Supplier.txt", true, "Registered new Supplier (" + supplier.getSupplierId() + ")");
    } else {
      // Display the error message
      System.out.println("Supplier is registered");
    }
  }

  public static void update(Supplier supplier) {
    int i = 0;
    File oldFile = new File("Supplier.txt");
    // Create a temporary file
    File tempFile = new File("TempSupplier.txt");

    try {
      ArrayList<String> supplierArray = ReadObject.readArray("Supplier.txt");
      // Iterate through the Supplier array
      for (String supplierDetails : supplierArray) {
        // Split line into array
        String[] details = supplierDetails.split(",");
        // Find the Supplier with the matching ID
        if (details[0].equals(supplier.getSupplierId())) {
          // Write the new details into the temporary file and log action
          WriteObject.write(supplier, "TempSupplier.txt", true, "Updated supplier information (" + supplier.getSupplierId() + ")");
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(supplierArray.get(i), "TempSupplier.txt", true);
        }
        i++;
      }
      // Delete the old file
      oldFile.delete();
      // Rename the temporary file
      tempFile.renameTo(new File("Supplier.txt"));
    } catch (FileNotFoundException e) {
      // Display the error message
      System.out.println(e);
    }
  }

  public static Supplier search(String keyword) {
    Supplier supplier = new Supplier("-1", "", "", "", "", Supplier.ACTIVE);

    try {
      ArrayList<String> supplierArray = ReadObject.readArray("Supplier.txt");
      // Iterate through the Supplier array
      for (String supplierDetails : supplierArray) {
        // Split the line into an array
        String[] details = supplierDetails.split(",");
        // Find if any existing Supplier matches the keyword
        if (details[1].contains(keyword) || details[2].contains(keyword) || details[3].contains(keyword) || details[4].contains(keyword)) {
          // Get Supplier information
          supplier = new Supplier(details[0], details[1], details[2], details[3], details[4], details[5]);
          // Stop the iteration
          break;
        }
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing Suppliers
    }
    return supplier;
  }

  // Overrides the default toString() to display the information of the Supplier class
  @Override
  public String toString() {
    return String.valueOf(getSupplierId()) + "," + getSupplierName() + "," + getSupplierAddress() + "," + getSupplierEmail() + "," + getSupplierContact() + "," + getSupplierStatus();
  }
}
