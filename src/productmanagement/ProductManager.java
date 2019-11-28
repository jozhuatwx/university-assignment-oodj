package productmanagement;

import java.io.File;
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
  public static boolean modify(ProductManager user, boolean updatePassword) {
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
          if (!updatePassword) {
            user.setUserPassword(details[6]);
          }
          if (user.getProductManagerStatus().equals(ACTIVE)) {
            // Write the new details into the temporary file and log the action
            String action = "Updated user information (" + user.getUserId() + ")";
            WriteObject.write(user, TEMP_FILE_NAME, true, action);
            // Display the success message
            JOptionPane.showMessageDialog(new JFrame(), action, "Success", JOptionPane.INFORMATION_MESSAGE);
          } else {
            String action = "Deactivated user information (" + user.getUserId() + ")";
            WriteObject.write(user, TEMP_FILE_NAME, true, action);
            // Display the success message
            JOptionPane.showMessageDialog(new JFrame(), action, "Success", JOptionPane.INFORMATION_MESSAGE);
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
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return false;
  }

  // Overrides the default toString() to display the information of the Product Manager class
  @Override
  public String toString() {
    return String.valueOf(getUserId()) + ";" + getUserName() + ";" + getUserAddress() + ";" + getUserEmail() + ";" + getUserRole() + ";" + getUserLoginName() + ";" + getUserPassword() + ";" + getProductManagerStatus();
  }
}
