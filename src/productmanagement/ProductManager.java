package productmanagement;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ProductManager extends User {
  public static final String ROLE = "PM";
  public static final String ACTIVE = "active";
  public static final String INACTIVE = "inactive";
  private String pmStatus;

  // Construct the Product Manager
  ProductManager(String userId, String userName, String userAddress, String userEmail, String userLoginName, String userPassword, String pmStatus) {
    super(userId, userName, userAddress, userEmail, ROLE, userLoginName, userPassword);
    this.pmStatus = pmStatus;
  }

  // Getters and Setters
  public String getPmStatus() {
    return pmStatus;
  }
  
  public void setPmStatus(String status) {
    this.pmStatus = status;
  }
  
  // Check if the user is a Product Manager
  public static boolean isProductManager() {
    if (myUser.getUserRole().equals(ROLE)) {
      return true;
    } else {
      return false;
    }
  }

  public static ProductManager search(String keyword) {
    ProductManager productMan = new ProductManager("-1", "", "", "", "", "", ProductManager.ACTIVE);

    try {
      ArrayList<String> productManArray = ReadObject.readArray("ProductManager.txt");
      // Iterate through the Product Manager array
      for (String productManDetails : productManArray) {
        // Split the line into an array
        String[] details = productManDetails.split(",");
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
    return String.valueOf(getUserId()) + "," + getUserName() + "," + getUserAddress() + "," + getUserEmail() + "," + getUserRole() + "," + getUserLoginName() + "," + getUserPassword() + "," + getPmStatus();
  }
}
