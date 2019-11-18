package productmanagement;

public class Administrator extends User {
  Administrator(int userId, String userName, String userAddress, String userEmail, String userLoginName, String userPassword) {
    super(userId, userName, userAddress, userEmail, "AD", userLoginName, userPassword);
  }
}
