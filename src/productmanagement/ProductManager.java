package productmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductManager extends User {
  // Constant variables
  public static final String ROLE = "PM";
  public static final String ACTIVE = "active";
  public static final String INACTIVE = "inactive";

  // Product Manager fields
  private String productManagerStatus;

  // Construct the Product Manager
  ProductManager(String userId, String userName, String userAddress, String userEmail, String userLoginName, String userPassword, String productManagerStatus) {
    super(userId, userName, userAddress, userEmail, ROLE, userLoginName, userPassword);
    this.productManagerStatus = productManagerStatus;
  }

  // Getters and Setters
  public String getProductManagerStatus() {
    return productManagerStatus;
  }
  
  public void setProductManagerStatus(String status) {
    this.productManagerStatus = status;
  }
  
  // Check if the user is a Product Manager
  public static boolean isProductManager() {
    if (myUser.getUserRole().equals(ROLE)) {
      return true;
    } else {
      return false;
    }
  }

  // Override User's function to account for deactivation
  public static boolean modify(ProductManager user) {
    int i = 0;
    File oldFile = new File(FILE_NAME);
    // Create a temporary file
    File tempFile = new File(TEMP_FILE_NAME);
    try {
      // Create an user array
      ArrayList<String> userArray = ReadObject.readArray(FILE_NAME);

      // Iterate through the user array
      for (String userDetails : userArray) {
        // Split the line into an array
        String[] details = userDetails.split(";");
        // Find the user with the matching ID
        if (details[0].equals(user.getUserId())) {
          if (user.getProductManagerStatus().equals(ACTIVE)) {
            // Write the new details into the temporary file and log the action
            WriteObject.write(user, TEMP_FILE_NAME, true, "Updated user information (" + user.getUserId() + ")");
          } else {
            WriteObject.write(user, TEMP_FILE_NAME, true, "Deactivated user information (" + user.getUserId() + ")");
          }
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(userArray.get(i), TEMP_FILE_NAME, true);
        }
        i++;
      }
      // Delete the old file
      oldFile.delete();
      // Rename the temporary file
      tempFile.renameTo(new File(FILE_NAME));

      if (user.getUserId().equals(User.myUser.getUserId())) {
        // Update the user's information in the session
        User.myUser.setUserName(user.getUserName());
        User.myUser.setUserAddress(user.getUserAddress());
        User.myUser.setUserEmail(user.getUserEmail());
      }
      return true;
    } catch (FileNotFoundException e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
    }
    return false;
  }

  public static ProductManager search(String keyword) {
    ProductManager productMan = new ProductManager("-1", "", "", "", "", "", ProductManager.ACTIVE);

    try {
      ArrayList<String> productManArray = ReadObject.readArray("ProductManager.txt");
      // Iterate through the Product Manager array
      for (String productManDetails : productManArray) {
        // Split the line into an array
        String[] details = productManDetails.split(";");
        // Find if any existing Product Manager matches the keyword
        if (details[1].contains(keyword) || details[2].contains(keyword) || details[3].contains(keyword) || details[4].contains(keyword)) {
          // Get Product Manager information
          productMan = new ProductManager(details[0], details[1], details[2], details[3], details[4], details[5], details[6]);
          // Stop the iteration
          break;
        }
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing Product Managers
    }
    return productMan;
  }

  // Overrides the default toString() to display the information of the Product Manager class
  @Override
  public String toString() {
    return String.valueOf(getUserId()) + ";" + getUserName() + ";" + getUserAddress() + ";" + getUserEmail() + ";" + getUserRole() + ";" + getUserLoginName() + ";" + getUserPassword() + ";" + getProductManagerStatus();
  }
}
