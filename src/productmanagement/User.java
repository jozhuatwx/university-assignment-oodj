package productmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class User {
  static User myAccount = new User("-1", "", "", "", "", "", "");
  private String userId, userName, userAddress, userEmail, userRole, userLoginName, userPassword;

  // Construct the User
  User(String userId, String userName, String userAddress, String userEmail, String userRole, String userLoginName,
      String userPassword) {
    this.userId = userId;
    this.userName = userName;
    this.userAddress = userAddress;
    this.userEmail = userEmail;
    this.userRole = userRole;
    this.userLoginName = userLoginName;
    this.userPassword = userPassword;
  }

  // Getters and setters
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
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

  // Generate the User ID
  public static String generateUserId() {
    // Set the default ID to 1
    int intUserId = 1;
    String userId = "U00000001";

    try {
      // Create an account array list
      ArrayList<String> accountArray = ReadObject.readArray("Account.txt");


      if (accountArray.size() > 0) {
        // Get the last line of the account array list
        String lastLine = accountArray.get(accountArray.size() - 1);
        // Split the line into an array
        String[] lastLineDetails = lastLine.split(",");
        // Read the ID of the line and add by 1
        intUserId = Integer.valueOf(lastLineDetails[0].substring(1)) + 1;
        // Add 'U' and leading zeros to the ID
        userId = "U" + String.format("%08d", intUserId);
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing accounts
    }
    // Return the value of the new User ID
    return userId;
  }

  // Log in the user
  public static void login(String userLoginName, String userPassword) {
    try {
      // Create an account array
      ArrayList<String> accountArray = ReadObject.readArray("Account.txt");

      // Iterate through the account array
      for (String account : accountArray) {
        // Split each line into an array
        String[] details = account.split(",");
        // Find the user login name in the array list
        if (details[5].equals(userLoginName)) {
          // Compare if the password equals the input password
          if (details[6].equals(userPassword)) {
            // Set the user's information into the session
            myAccount.setUserId(details[0]);
            myAccount.setUserName(details[1]);
            myAccount.setUserAddress(details[2]);
            myAccount.setUserEmail(details[3]);
            myAccount.setUserRole(details[4]);
            myAccount.setUserLoginName(details[5]);
            // Record the action into the log
            ActionLog.log("Login");
          } else {
            // Display the error message
            System.out.println("Wrong password");
          }
          // Stop the iteration
          break;
        }
      }
    } catch (FileNotFoundException e) {
      // Display the error message
      System.out.println(e);
    }
  }

  public static void register(User user) {
    // Set default registered user as false
    boolean registered = false;
    // Create an account array
    try {
      ArrayList<String> accountArray = ReadObject.readArray("Account.txt");
    
      // Iterate through the account array
      for (String account : accountArray) {
        // Split the line into an array
        String[] details = account.split(",");
        // Find if any existing user login name matches the registering user
        if (details[5].equals(user.getUserLoginName())) {
          // Set the user as registered
          registered = true;
          // Stop the iteration
          break;
        }
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing accounts
    }

    if (registered) {
      // Display the error message
      System.out.println("Username is taken");
    } else {
      // Record the new user into the Account database
      WriteObject.write(user, "Account.txt", true);
      // Record the action into the log
      ActionLog.log("Registered new user. User ID: " + user.getUserId());
    }
  }

  public static void update(User user) {
    int i = 0;
    File oldFile = new File("Account.txt");
    // Create a temporary file
    File tempFile = new File("TempAccount.txt");
    try {
      // Create an account array
      ArrayList<String> accountArray = ReadObject.readArray("Account.txt");

      // Iterate through the account array
      for (String account : accountArray) {
        // Split the line into an array
        String[] details = account.split(",");
        // Find the user with the matching ID
        if (details[0].equals(user.getUserId())) {
          // Write the new details into the temporary file
          WriteObject.write(user, "TempAccount.txt", true);
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(accountArray.get(i), "TempAccount.txt", true);
        }
        i++;
      }
      // Delete the old file
      oldFile.delete();
      // Rename the temporary file
      tempFile.renameTo(new File("Account.txt"));
      // Record the action into the log
      ActionLog.log("Updated user information");

      // Update the user's information in the session
      User.myAccount.setUserName(user.getUserName());
      User.myAccount.setUserAddress(user.getUserAddress());
      User.myAccount.setUserEmail(user.getUserEmail());
    } catch (FileNotFoundException e) {
      // Display the error message
      System.out.println(e);
    }
  }

  // Overrides the default toString() to display the information of the User class
  @Override
  public String toString() {
    return String.valueOf(getUserId()) + "," + getUserName() + "," + getUserAddress() + "," + getUserEmail() + "," + getUserRole() + "," + getUserLoginName() + "," + getUserPassword();
  }
}
