package productmanagement;

public class ProductManager extends User {
  final static String ACTIVE = "active";
  final static String INACTIVE = "inactive";
  private String pmStatus;

  // Construct the Product Manager
  ProductManager(String userId, String userName, String userAddress, String userEmail, String userLoginName, String userPassword, String pmStatus) {
    super(userId, userName, userAddress, userEmail, "PM", userLoginName, userPassword);
    this.pmStatus = pmStatus;
  }

  // Getters and Setters
  public String getPmStatus() {
    return pmStatus;
  }
  
  public void setPmStatus(String status) {
    this.pmStatus = status;
  }

  // Overrides the default toString() to display the information of the Product Manager class
  @Override
  public String toString() {
    return String.valueOf(getUserId()) + "," + getUserName() + "," + getUserAddress() + "," + getUserEmail() + "," + getUserRole() + "," + getUserLoginName() + "," + getUserPassword() + "," + getPmStatus();
  }
}
