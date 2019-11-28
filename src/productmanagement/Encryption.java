package productmanagement;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Encryption {
  // Validate a password
  public static boolean validatePassword(char[] password, String hashedPassword) {
    try {
      // Split hashed password into parts
      String[] parts = hashedPassword.split(":");
      // Get the iterations, salt and encoded hashed password
      int iterations = Integer.valueOf(parts[0]);
      byte[] salt = fromHex(parts[1]);
      byte[] hash = fromHex(parts[2]);

      // Hash the input password using the same salt and iteration
      PBEKeySpec pbeKeySpec = new PBEKeySpec(password, salt, iterations, hash.length * 8);
      // Set the Secret Key algorithm
      SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
      // Encode the hashed input password with the secret key
      byte[] newHash = secretKeyFactory.generateSecret(pbeKeySpec).getEncoded();

      // Compare the hashed password and hashed input password
      int diff = hash.length ^ newHash.length;
      for (int i = 0; i < hash.length && i < newHash.length; i++) {
        diff |= hash[i] ^ newHash[i];
      }
      // Return the boolean if there is a difference
      return diff == 0;
    } catch (Exception e) {
      // Display the error message
      JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    // Default return false
    return false;
  }

  // Hash a password with salt
  public static String encryptPassword(char[] password) throws NoSuchAlgorithmException, InvalidKeySpecException {
    // Set the number of iterations
    int iterations = 1000;
    byte[] salt = generateSalt();

    // Hash the password
    PBEKeySpec pbeKeySpec = new PBEKeySpec(password, salt, iterations, 64 * 8);
    // Set the Secret Key algorithm
    SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    // Encode the hashed password with the secret key
    byte[] hash = secretKeyFactory.generateSecret(pbeKeySpec).getEncoded();
    // Return the number of iterations, salt in hex, and encoded hashed password in hex
    return iterations + ":" + toHex(salt) + ":" + toHex(hash);
  }

  // Generate a random salt securely
  private static byte[] generateSalt() throws NoSuchAlgorithmException {
    byte[] salt = new byte[16];
    // Securely generate random numbers
    SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
    // Copy random numbers into the salt
    secureRandom.nextBytes(salt);
    // Return the salt
    return salt;
  }

  // Convert bytes to hex
  private static String toHex(byte[] array) throws NoSuchAlgorithmException {
    // Convert bytes to Big Integar
    BigInteger bi = new BigInteger(1, array);
    // Convert bytes to Hex in string
    String hex = bi.toString(16);
    
    // Set hex length
    // Byte is 8 bits, Hex is 16 bits
    int paddingLength = (array.length * 2) - hex.length();
    if (paddingLength > 0) {
      // Add additional zeros before the hex
      return String.format("%0" + paddingLength + "d", 0) + hex;
    } else {
      return hex;
    }
  }

  // Convert hex to bytes
  private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
    // Set byte length
    byte[] bytes = new byte[hex.length() / 2];
    // Convert Hex in string into int and into byte and store in array
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
    }
    // Return the bytes array
    return bytes;
  }
}
