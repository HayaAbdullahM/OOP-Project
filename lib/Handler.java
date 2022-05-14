import java.io.*;
import java.net.URL;
import java.util.regex.*;

import javax.swing.JOptionPane;

public class Handler {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    public static boolean isEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean isImage(String URLName) {
        boolean result = false;
        try {
            InputStream input = (new URL(URLName)).openStream();
            result = true;
        } catch (IOException ex) {
            System.out.println("Image does not exits :");
        }
        return result;
    }

    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error Occurred",
                JOptionPane.ERROR_MESSAGE);
    }

}
