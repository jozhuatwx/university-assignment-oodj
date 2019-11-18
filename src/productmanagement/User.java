package productmanagement;

import java.io.File;
import java.util.ArrayList;

public class User {
  static User myAccount = new User(-1, "", "", "", "", "", "");
  private int userId;
  private String userName, userAddress, userEmail, userRole, userLoginName, userPassword;

  User(int userId, String userName, String userAddress, String userEmail, String userRole, String userLoginName,
      String userPassword) {
    this.userId = userId;
    this.userName = userName;
    this.userAddress = userAddress;
    this.userEmail = userEmail;
    this.userRole = userRole;
    this.userLoginName = userLoginName;
    this.userPassword = userPassword;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }

  public String getUserLoginName() {
    return userLoginName;
  }

  public void setUserLoginName(String userLoginName) {
    this.userLoginName = userLoginName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public static int generateUserId() {
    int userId = 1;

    ArrayList<String> accountArray = ReadObject.readArray("Account.txt");
    if (accountArray.size() > 0) {
      userId = Integer.valueOf(accountArray.get(accountArray.size() - 1).split(",")[0]) + 1;
    }

    return userId;
  }

  public static void login(String userLoginName, String userPassword) {
    for (String account : ReadObject.readArray("Account.txt")) {
      String[] details = account.split(",");
      if (details[5].equals(userLoginName) && details[6].equals(userPassword)) {
        myAccount.setUserId(Integer.valueOf(details[0]));
        myAccount.setUserName(details[1]);
        myAccount.setUserAddress(details[2]);
        myAccount.setUserEmail(details[3]);
        myAccount.setUserRole(details[4]);
        myAccount.setUserLoginName(details[5]);
        ActionLog.log("Login");
        break;
      }
    }
  }

  public static void register(User user) {
    boolean registered = false;

    for (String account : ReadObject.readArray("Account.txt")) {
      String[] details = account.split(",");
      if (details[5].equals(user.getUserLoginName())) {
        registered = true;
        break;
      }
    }

    if (registered) {
      System.out.println("Username is taken");
    } else {
      WriteObject.write(user, "Account.txt", true);
      ActionLog.log("Registered new user: " + user);
    }
  }

  public static void update(User user) {
    int i = 0;
    File tempFile = new File("TempAccount.txt");

    ArrayList<String> accountArray = ReadObject.readArray("Account.txt");

    for (String account : accountArray) {
      String[] details = account.split(",");
      if (Integer.valueOf(details[0]).equals(user.getUserId())) {
        WriteObject.write(user, "TempAccount.txt", true);
      } else {
        WriteObject.write(accountArray.get(i), "TempAccount.txt", true);
      }
      i++;
    }
    File oldFile = new File("Account.txt");
    oldFile.delete();
    tempFile.renameTo(new File("Account.txt"));
    ActionLog.log("Updated user information");

    User.myAccount.setUserName(user.getUserName());
    User.myAccount.setUserAddress(user.getUserAddress());
    User.myAccount.setUserEmail(user.getUserEmail());
  }

  @Override
  public String toString() {
    return String.valueOf(getUserId()) + "," + getUserName() + "," + getUserAddress() + "," + getUserEmail() + "," + getUserRole() + "," + getUserLoginName() + "," + getUserPassword();
  }
}
