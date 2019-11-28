package productmanagement;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Supplier {
  // Constant variables
  public static final String FILE_NAME = "Supplier.txt";
  public static final String TEMP_FILE_NAME = "TempSupplier.txt";
  public static final String ACTIVE = "active";
  public static final String INACTIVE = "inactive";

  // Supplier fields
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
    return ReadObject.generateId("S", FILE_NAME);
  }

  public static void register(Supplier supplier) {
    // Set default registered Supplier as false
    boolean registered = false;

    try {
      ArrayList<String> supplierArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Supplier array
      for (String supplierDetails : supplierArray) {
        // Split the line into an array
        String[] details = supplierDetails.split(";");
        // Find if any existing Supplier name matches the registering Supplier
        if (details[1].equals(supplier.getSupplierName())) {
          // Set the Supplier as registered
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
      // Write the new supplier into the Supplier database and log action
      WriteObject.write(supplier, FILE_NAME, true, "Registered new Supplier (" + supplier.getSupplierId() + ")");
    } else {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), "Supplier already registered", "Warning", JOptionPane.WARNING_MESSAGE);
    }
  }

  public static void modify(Supplier supplier, boolean update) {
    int i = 0;
    File oldFile = new File(FILE_NAME);
    // Create a temporary file
    File tempFile = new File(TEMP_FILE_NAME);

    try {
      ArrayList<String> supplierArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Supplier array
      for (String supplierDetails : supplierArray) {
        // Split line into array
        String[] details = supplierDetails.split(";");
        // Find the Supplier with the matching ID
        if (details[0].equals(supplier.getSupplierId())) {
          if (update) {
            // Write the new details into the temporary file and log action
            WriteObject.write(supplier, TEMP_FILE_NAME, true, "Updated supplier information (" + supplier.getSupplierId() + ")");
          } else {
            // Ignore the details and log the action
            WriteObject.log("Deleted supplier information (" + supplier.getSupplierId() + ")");
          }
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(supplierArray.get(i), TEMP_FILE_NAME, true);
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

  public static void update(Supplier supplier) {
    modify(supplier, true);
  }

  public static void delete(String supplierId) {
    Supplier supplier = new Supplier(supplierId, "", "", "", "", Supplier.INACTIVE);
    modify(supplier, false);
  }

  public static Supplier search(String keyword) {
    Supplier supplier = new Supplier("-1", "", "", "", "", Supplier.ACTIVE);

    try {
      ArrayList<String> supplierArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Supplier array
      for (String supplierDetails : supplierArray) {
        // Split the line into an array
        String[] details = supplierDetails.split(";");
        // Find if any existing Supplier matches the keyword
        if (details[1].contains(keyword) || details[2].contains(keyword) || details[3].contains(keyword) || details[4].contains(keyword)) {
          // Get Supplier information
          supplier = new Supplier(details[0], details[1], details[2], details[3], details[4], details[5]);
          // Stop the iteration
          break;
        }
      }
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return supplier;
  }

  // Overrides the default toString() to display the information of the Supplier class
  @Override
  public String toString() {
    return String.valueOf(getSupplierId()) + ";" + getSupplierName() + ";" + getSupplierAddress() + ";" + getSupplierEmail() + ";" + getSupplierContact() + ";" + getSupplierStatus();
  }
}
