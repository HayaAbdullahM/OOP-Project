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

    public static boolean dateChecker(String input) {

        if (input.equalsIgnoreCase("SOON")) {
            return true;
        }

        if (input.length() == 10) {
            if (isNumber(input.charAt(0) + "") && isNumber(input.charAt(1) + "") && input.charAt(2) == '/'
                    && isNumber(input.charAt(3) + "") && isNumber(input.charAt(4) + "") && input.charAt(5) == '/'
                    && isNumber(input.charAt(6) + "") && isNumber(input.charAt(7) + "")
                    && isNumber(input.charAt(8) + "") && isNumber(input.charAt(9) + "")) {
                return true;
            }
        }

        return false;
    }

    public static boolean timeChecker(String input) {

        if (input.equalsIgnoreCase("SOON")) {
            return true;
        }

        if (input.length() == 5) {
            if (isNumber(input.charAt(0) + "") && isNumber(input.charAt(1) + "") && input.charAt(2) == ':'
                    && isNumber(input.charAt(3) + "") && isNumber(input.charAt(4) + "")) {
                return true;
            }
        }

        return false;
    }

    public static boolean isNumber(String numbers) {
        try {
            Integer.parseInt(numbers);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
