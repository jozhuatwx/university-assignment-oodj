package productmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class User {
  static User myUser = new User("-1", "", "", "", "", "", "");
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
    return ReadObject.generateId("U", "User.txt");
  }

  public static void forgotPassword(String userLoginName) {
    boolean found = false;
    // Check if the User login name exists
    try {
      ArrayList<String> userArray = ReadObject.readArray("User.txt");

      // Iterate through the User array
      for (String user : userArray) {
        // Split each line into an array
        String[] details = user.split(",");
        // Find the user login name in the array list
        if (details[5].equals(userLoginName)) {
          // Set the User as found
          found = true;
          // Log the User ID
          WriteObject.write(details[0] + ",FORGOT PASSWORD", "User.txt", true);
          // Stop the iteration
          break;
        }
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing users
    }

    if (!found) {
      // Display the error message
      System.out.println("User not found");
    }
  }

  // Check if the user is logged in
  public static boolean isLoggedIn() {
    if (!myUser.getUserId().equals("-1")) {
      return true;
    } else {
      return false;
    }
  }

  // Log in the user
  public static void login(String userLoginName, String userPassword) {
    try {
      ArrayList<String> userArray = ReadObject.readArray("User.txt");

      // Iterate through the user array
      for (String user : userArray) {
        // Split each line into an array
        String[] details = user.split(",");
        // Find the user login name in the array list
        if (details[5].equals(userLoginName)) {
          // Compare if the password equals the input password
          if (details[6].equals(userPassword)) {
            // Set the user's information into the session
            myUser.setUserId(details[0]);
            myUser.setUserName(details[1]);
            myUser.setUserAddress(details[2]);
            myUser.setUserEmail(details[3]);
            myUser.setUserRole(details[4]);
            myUser.setUserLoginName(details[5]);
            // Record the action into the log
            WriteObject.log("Login");
          } else {
            // Display the error message
            System.out.println("Wrong password");
          }
          // Stop the iteration
          break;
        } else {
          // Display the error message
          System.out.println("Wrong login name");
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
    // Create an user array
    try {
      ArrayList<String> userArray = ReadObject.readArray("User.txt");
    
      // Iterate through the user array
      for (String userDetails : userArray) {
        // Split the line into an array
        String[] details = userDetails.split(",");
        // Find if any existing user login name matches the registering user
        if (details[5].equals(user.getUserLoginName())) {
          // Set the user as registered
          registered = true;
          // Stop the iteration
          break;
        }
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing users
    }

    if (!registered) {
      // Record the new user into the User database and log action
      WriteObject.write(user, "User.txt", true, "Registered new User (" + user.getUserId() + ")");
    } else {
      // Display the error message
      System.out.println("User login name is taken");
    }
  }

  public static void update(User user) {
    int i = 0;
    File oldFile = new File("User.txt");
    // Create a temporary file
    File tempFile = new File("TempUser.txt");
    try {
      // Create an user array
      ArrayList<String> userArray = ReadObject.readArray("User.txt");

      // Iterate through the user array
      for (String userDetails : userArray) {
        // Split the line into an array
        String[] details = userDetails.split(",");
        // Find the user with the matching ID
        if (details[0].equals(user.getUserId())) {
          // Write the new details into the temporary file and log action
          WriteObject.write(user, "TempUser.txt", true, "Updated user information (" + user.getUserId() + ")");
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(userArray.get(i), "TempUser.txt", true);
        }
        i++;
      }
      // Delete the old file
      oldFile.delete();
      // Rename the temporary file
      tempFile.renameTo(new File("User.txt"));

      if (user.getUserId().equals(User.myUser.getUserId())) {
        // Update the user's information in the session
        User.myUser.setUserName(user.getUserName());
        User.myUser.setUserAddress(user.getUserAddress());
        User.myUser.setUserEmail(user.getUserEmail());
      }
    } catch (FileNotFoundException e) {
      // Display the error message
      System.out.println(e);
    }
  }

  public static void logout() {
    // Record action into log
    WriteObject.log("Logout");
    // Clear the user's information from the session
    myUser.setUserId("-1");
    myUser.setUserName("");
    myUser.setUserAddress("");
    myUser.setUserEmail("");
    myUser.setUserRole("");
    myUser.setUserLoginName("");
  }

  // Overrides the default toString() to display the information of the User class
  @Override
  public String toString() {
    return String.valueOf(getUserId()) + "," + getUserName() + "," + getUserAddress() + "," + getUserEmail() + "," + getUserRole() + "," + getUserLoginName() + "," + getUserPassword();
  }
}
