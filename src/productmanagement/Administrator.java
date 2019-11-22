package productmanagement;

public class Administrator extends User {
  // Construct the Administrator
  Administrator(int userId, String userName, String userAddress, String userEmail, String userLoginName, String userPassword) {
    super(userId, userName, userAddress, userEmail, "AD", userLoginName, userPassword);
  }
}
