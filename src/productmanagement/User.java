package productmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class User {
  // Constant variables
  public static final String FILE_NAME = "User.txt";
  public static final String TEMP_FILE_NAME = "TempUser.txt";

  // Session information
  static User myUser = new User("-1", "", "", "", "", "", "");

  // User fields
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
    return ReadObject.generateId("U", FILE_NAME);
  }

  public static boolean forgotPassword(String userLoginName) {
    boolean found = false;
    // Check if the User login name exists
    try {
      ArrayList<String> userArray = ReadObject.readArray(FILE_NAME);

      // Iterate through the User array
      for (String user : userArray) {
        // Split each line into an array
        String[] details = user.split(";");
        // Find the user login name in the array list
        if (details[5].equals(userLoginName)) {
          // Set the User as found
          found = true;
          // Log the User ID
          WriteObject.write(details[0] + ",FORGOT PASSWORD", FILE_NAME, true);
          return true;
        }
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing users
    }

    if (!found) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), "User not found", "Alert", JOptionPane.WARNING_MESSAGE);
    }
    return false;
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
  public static boolean login(String userLoginName, char[] userPassword) {
    try {
      ArrayList<String> userArray = ReadObject.readArray(FILE_NAME);

      // Iterate through the user array
      for (String user : userArray) {
        // Split each line into an array
        String[] details = user.split(";");
        // Find the user login name in the array list
        if (details[5].equals(userLoginName)) {
          // Compare if the password equals the input password
          if (Encryption.validatePassword(userPassword, details[6])) {
            // Set the user's information into the session
            myUser.setUserId(details[0]);
            myUser.setUserName(details[1]);
            myUser.setUserAddress(details[2]);
            myUser.setUserEmail(details[3]);
            myUser.setUserRole(details[4]);
            myUser.setUserLoginName(details[5]);
            // Record the action into the log
            WriteObject.log("Login");
            return true;
          } else {
            // Display the error message
            JOptionPane.showMessageDialog(new JFrame(), "Wrong password", "Alert", JOptionPane.WARNING_MESSAGE);
            return false;
          }
        } else {
          // Display the error message
          JOptionPane.showMessageDialog(new JFrame(), "Wrong login name", "Alert", JOptionPane.WARNING_MESSAGE);
          return false;
        }
      }
    } catch (FileNotFoundException e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
    }
    return false;
  }

  public static boolean register(User user) {
    // Set default registered user as false
    boolean registered = false;
    // Create an user array
    try {
      ArrayList<String> userArray = ReadObject.readArray(FILE_NAME);
    
      // Iterate through the user array
      for (String userDetails : userArray) {
        // Split the line into an array
        String[] details = userDetails.split(";");
        // Find if any existing user login name matches the registering user
        if (details[5].equals(user.getUserLoginName())) {
          // Set the user as registered
          registered = true;
          // Display the error message
          JOptionPane.showMessageDialog(new JFrame(), "Login name is taken, please try another login name", "Alert", JOptionPane.WARNING_MESSAGE);
          return false;
        }
      }
    } catch (FileNotFoundException e) {
      // Ignore as there may be no existing users
    }

    if (!registered) {
      // Record the new user into the User database and log action
      WriteObject.write(user, FILE_NAME, true, "Registered new User (" + user.getUserId() + ")");
      return true;
    }
    return false;
  }

  public static boolean modify(User user, boolean update) {
    int i = 0;
    File oldFile = new File(FILE_NAME);
    // Create a temporary file
    File tempFile = new File(TEMP_FILE_NAME);
    try {
      // Create an user array
      ArrayList<String> userArray = ReadObject.readArray(FILE_NAME);

      // Iterate through the user array
      for (String userDetails : userArray) {
        // Split the line into an array
        String[] details = userDetails.split(";");
        // Find the user with the matching ID
        if (details[0].equals(user.getUserId())) {
          if (update) {
            // Write the new details into the temporary file and log the action
            WriteObject.write(user, TEMP_FILE_NAME, true, "Updated user information (" + user.getUserId() + ")");
          } else {
            // Ignore the details and log the action
            WriteObject.log("Deleted user information (" + user.getUserId() + ")");
          }
        } else {
          // Write the old detail into the temporary file
          WriteObject.write(userArray.get(i), TEMP_FILE_NAME, true);
        }
        i++;
      }
      // Delete the old file
      oldFile.delete();
      // Rename the temporary file
      tempFile.renameTo(new File(FILE_NAME));

      if (user.getUserId().equals(User.myUser.getUserId())) {
        // Update the user's information in the session
        User.myUser.setUserName(user.getUserName());
        User.myUser.setUserAddress(user.getUserAddress());
        User.myUser.setUserEmail(user.getUserEmail());
      }
      return true;
    } catch (FileNotFoundException e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
    }
    return false;
  }

  public static boolean update(User user) {
    return modify(user, true);
  }

  public static boolean delete(String userId) {
    User user = new User(userId, "", "", "", "", "", "");
    return modify(user, false);
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
    return String.valueOf(getUserId()) + ";" + getUserName() + ";" + getUserAddress() + ";" + getUserEmail() + ";" + getUserRole() + ";" + getUserLoginName() + ";" + getUserPassword();
  }
}
