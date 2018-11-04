package hoon.util;

public class AuthUtil {

    public static String encode(String word) {
        return word + "_itWasEncrypt";
    }

    public static boolean match(CharSequence rawPassword, String encodedPassword) {
        return (rawPassword + "_itWasEncrypt").equals(encodedPassword);
    }
}
