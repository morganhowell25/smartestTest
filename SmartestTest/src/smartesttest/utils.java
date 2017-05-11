package smartesttest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.Base64;

public class utils {
    
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
    }}
    
    
