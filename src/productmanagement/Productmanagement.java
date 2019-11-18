package productmanagement;

public class Productmanagement {
  public static void main(String[] args) {
    User.login("ccw", "password123");

    int userId = User.generateUserId();
    String userName = "Chun Wei";
    String userAddress = "Home";
    String userEmail = "ccw@gmail.com";
    String userLoginName = "www";
    String userPassword = "password123";
    ProductManager pm = new ProductManager(userId, userName, userAddress, userEmail, userLoginName, userPassword);
    User.register(pm);
  }
}
