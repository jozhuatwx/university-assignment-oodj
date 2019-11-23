package productmanagement;

public class Administrator extends User {
  // Constant variables
  public static final String ROLE = "AD";

  // Construct the Administrator
  Administrator(String userId, String userName, String userAddress, String userEmail, String userLoginName, String userPassword) {
    super(userId, userName, userAddress, userEmail, ROLE, userLoginName, userPassword);
  }
  
  // Check if the user is an Administrator
  public static boolean isAdministrator() {
    if (myUser.getUserRole().equals(ROLE)) {
      return true;
    } else {
      return false;
    }
  }
}
