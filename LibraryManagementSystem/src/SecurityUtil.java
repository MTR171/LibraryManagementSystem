import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

    // Method to hash the password using SHA-256
    public static String hashPassword(String password) {
        try {
            // Create an instance of SHA-256 MessageDigest
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes());

            // Convert the byte array to a hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            // Return the hashed password in hexadecimal format
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null; // Return null if hashing fails
    }

    static void saveCredentials(String newUsername, String newPassword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
