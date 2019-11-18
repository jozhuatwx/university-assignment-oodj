package productmanagement;

public class ProductManager extends User {
  private String status;

  public String getStatus() {
    return status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }

  ProductManager(int userId, String userName, String userAddress, String userEmail, String userLoginName, String userPassword) {
    super(userId, userName, userAddress, userEmail, "PM", userLoginName, userPassword);
  }
}
