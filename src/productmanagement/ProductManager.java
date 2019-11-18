package productmanagement;

public class ProductManager extends User {
  ProductManager(int userId, String userName, String userAddress, String userEmail, String userLoginName, String userPassword) {
    super(userId, userName, userAddress, userEmail, "PM", userLoginName, userPassword);
  }
}
