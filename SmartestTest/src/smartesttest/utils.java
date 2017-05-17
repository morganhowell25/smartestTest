package smartesttest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;

public class utils {

    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/smartTest_db";
    static final String USER = "root";
    static final String PASS = "goodyear123!@#";
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  
    // Converts an object into a string
    public static String toStr(Serializable obj){
        String sRet = null;

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            byte[] barr = baos.toByteArray();
            sRet = Base64.getEncoder().encodeToString(barr);
            sRet = URLEncoder.encode(sRet, "UTF-8");

        } catch (Exception exc) {
            System.out.println(exc);
        } finally {
            return sRet;
        }
    }
    
    // Converts a string into an object
    public static Object toObj(String str) {
        Object obj = null;
        try {
            //String sDecoded = URLDecoder.decode(str, "UTF-8");
            byte[] barr = Base64.getDecoder().decode(str);
            ByteArrayInputStream bios = new ByteArrayInputStream(barr);
            ObjectInputStream ois = new ObjectInputStream(bios);
            obj = ois.readObject();
        } catch (Exception exc) {
            System.out.println(exc);
        } finally {
            return obj;
        }
    }
    
    public static String encrypt(String passText){
        String cipherText = "";
        for (int i = 0; i < passText.length(); i++){
            int charPosition = ALPHABET.indexOf(passText.charAt(i));
            int keyVal = (3 + charPosition) % 62;
            char newChar = ALPHABET.charAt(keyVal);
            cipherText += newChar;
        }
    return cipherText;
    }
    
    public static String decrypt(String cipherText){
        String passText = "";
        for (int i = 0; i < cipherText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - 3) % 62;
            if (keyVal < 0){
                keyVal = ALPHABET.length() + keyVal;
            }
            char newChar = ALPHABET.charAt(keyVal);
            passText += newChar;
        }
    return passText;
    }
}
