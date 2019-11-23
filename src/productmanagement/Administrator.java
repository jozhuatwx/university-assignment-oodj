package productmanagement;

public class Administrator extends User {
  final static String ROLE = "AD";

  // Construct the Administrator
  Administrator(String userId, String userName, String userAddress, String userEmail, String userLoginName, String userPassword) {
    super(userId, userName, userAddress, userEmail, ROLE, userLoginName, userPassword);
  }
}
