package productmanagement;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Supplier {
  // Constant fields
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

  Supplier(String[] details) {
    this(details[0], details[1], details[2], details[3], details[4], details[5]);
  }
  
  // Getters and setters
  public String getSupplierId() {
    return supplierId;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public String getSupplierAddress() {
    return supplierAddress;
  }

  public String getSupplierEmail() {
    return supplierEmail;
  }

  public String getSupplierContact() {
    return supplierContact;
  }

  public String getSupplierStatus() {
    return supplierStatus;
  }

  // Generate the Supplier ID
  public static String generateSupplierId() {
    return ReadObject.generateId("S", FILE_NAME);
  }

  public static boolean register(Supplier supplier) {
    // Set default registered Supplier as false
    boolean registered = false;

    try {
      ArrayList<String> supplierArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Supplier array
      for (String supplierDetails : supplierArray) {
        // Split the line into an array
        String[] details = supplierDetails.split(";");
        // Find if any existing Supplier name matches the registering Supplier
        if (details[1].equalsIgnoreCase(supplier.getSupplierName())) {
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
      return WriteObject.write(supplier, FILE_NAME, true, "Registered new Supplier (" + supplier.getSupplierId() + ")", true);
    } else {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), "Supplier already registered", "Warning", JOptionPane.WARNING_MESSAGE);
    }
    return false;
  }

  public static boolean modify(Supplier supplier, String oldStatus) {
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
        if (details[0].equalsIgnoreCase(supplier.getSupplierId())) {
          if (oldStatus.equalsIgnoreCase(INACTIVE) && supplier.getSupplierStatus().equalsIgnoreCase(ACTIVE)) {
            // Write the new details into the temporary file and log action
            WriteObject.write(supplier, TEMP_FILE_NAME, true, "Activated supplier (" + supplier.getSupplierId() + ")", true);
          } else if (oldStatus.equalsIgnoreCase(ACTIVE) && supplier.getSupplierStatus().equalsIgnoreCase(ACTIVE)) {
            WriteObject.write(supplier, TEMP_FILE_NAME, true, "Updated supplier (" + supplier.getSupplierId() + ")", true);
          } else if (oldStatus.equalsIgnoreCase(ACTIVE) && supplier.getSupplierStatus().equalsIgnoreCase(INACTIVE)) {
            WriteObject.write(supplier, TEMP_FILE_NAME, true, "Deactivated supplier (" + supplier.getSupplierId() + ")", true);
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
      return tempFile.renameTo(new File(FILE_NAME));
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return false;
  }

  public static ArrayList<Supplier> search(String keyword) {
    keyword = keyword.toLowerCase();
    ArrayList<Supplier> supplierArrayList = new ArrayList<>();

    try {
      ArrayList<String> supplierArray = ReadObject.readArray(FILE_NAME);
      // Iterate through the Supplier array
      for (String supplierDetails : supplierArray) {
        // Split the line into an array
        String[] details = supplierDetails.split(";");
        // Find if any existing Supplier matches the keyword
        if (details[1].toLowerCase().contains(keyword) || details[2].toLowerCase().contains(keyword) || details[3].toLowerCase().contains(keyword) || details[4].toLowerCase().contains(keyword)) {
          // Get Supplier information
          Supplier supplier = new Supplier(details);
          supplierArrayList.add(supplier);
        }
      }
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return supplierArrayList;
  }

  public static int[] totalSuppliers() {
    int[] suppliers = {0, 0, 0};

    ArrayList<String> supplierArray = ReadObject.readArray(FILE_NAME);
    // Iterate through the Supplier array
    for (String supplierDetails : supplierArray) {
      // Split the line into an array
      String[] details = supplierDetails.split(";");
      // Find active Suppliers
      if (details[5].equalsIgnoreCase(ACTIVE)) {
        suppliers[1] += 1;
      }
    }
    // Get total Suppliers
    suppliers[0] = supplierArray.size();

    // Calculate inactive Suppliers
    suppliers[2] = suppliers[0] - suppliers[1];
    
    return suppliers;
  }

  // Overrides the default toString() to display the information of the Supplier class
  @Override
  public String toString() {
    return getSupplierId() + ";" + getSupplierName() + ";" + getSupplierAddress() + ";" + getSupplierEmail() + ";" + getSupplierContact() + ";" + getSupplierStatus();
  }
}
