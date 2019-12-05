package productmanagement;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductManager extends User {
  // Constant fields
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

  ProductManager(String[] details) {
    this(details[0], details[1], details[2], details[3], details[5], details[6], details[7]);
  }

  // Getters and Setters
  public String getProductManagerStatus() {
    return productManagerStatus;
  }
  
  // Check if the user is a Product Manager
  public static boolean isProductManager() {
    if (myUser.getUserRole().equalsIgnoreCase(ROLE)) {
      return true;
    } else {
      return false;
    }
  }

  // Override User's function to account for deactivation
  public static boolean modify(ProductManager user, boolean updatePassword, String oldStatus) {
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
        if (details[0].equalsIgnoreCase(user.getUserId())) {
          if (oldStatus.equalsIgnoreCase(INACTIVE) && user.getProductManagerStatus().equalsIgnoreCase(ACTIVE)) {
            // Write the new details into the temporary file and log the action
            WriteObject.write(user, TEMP_FILE_NAME, true, "Activated user (" + user.getUserId() + ")", true);
          } else if (oldStatus.equalsIgnoreCase(ACTIVE) && user.getProductManagerStatus().equalsIgnoreCase(ACTIVE)) {
            if (!updatePassword) {
              user.setUserPassword(details[6]);
            }
            WriteObject.write(user, TEMP_FILE_NAME, true, "Updated user (" + user.getUserId() + ")", true);
          } else if (oldStatus.equalsIgnoreCase(ACTIVE) && user.getProductManagerStatus().equalsIgnoreCase(INACTIVE)) {
            WriteObject.write(user, TEMP_FILE_NAME, true, "Deactivated user (" + user.getUserId() + ")", true);
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

      if (user.getUserId().equalsIgnoreCase(User.myUser.getUserId())) {
        // Update the user's information in the session
        User.myUser.setUserName(user.getUserName());
        User.myUser.setUserAddress(user.getUserAddress());
        User.myUser.setUserEmail(user.getUserEmail());
      }
      return true;
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return false;
  }

  // Overrides the default toString() to display the information of the Product Manager class
  @Override
  public String toString() {
    return getUserId() + ";" + getUserName() + ";" + getUserAddress() + ";" + getUserEmail() + ";" + getUserRole() + ";" + getUserLoginName() + ";" + getUserPassword() + ";" + getProductManagerStatus();
  }
}
