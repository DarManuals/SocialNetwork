package ua.dp.daragan.sn.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by bogdan on 17.09.16.
 */
public class HashString {

    public static String strToHash(String password) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);

            if (hex.length() == 1) {
                hexString.append('0');
            }

            hexString.append(hex);
        }
        return hexString.toString();
    }
}