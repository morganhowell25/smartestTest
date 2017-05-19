package smartesttestserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBHandler {
    
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/smarttest_db";
    static final String USER = "root";
    static final String PASS = "goodyear123!@#";
    
    public static String httpsPost(String url, String datastr) throws Exception {
        //1. create url and request object
        URL urlObj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-length", String.valueOf(datastr.length()));
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0;Windows98;DigExt)");
        con.setDoOutput(true);
        con.setDoInput(true);

        //2. send request out
        DataOutputStream oos = new DataOutputStream(con.getOutputStream());
        oos.writeBytes(datastr);
        oos.close();

        //3. collect the https response
        DataInputStream iis = new DataInputStream(con.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(iis));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);// + "\n");
            line = br.readLine();
        }
        String sRet = sb.toString();
        return sRet;
    }

    public static ArrayList<String> execQuery(String qry) {
        ArrayList<String> arrStrings = new ArrayList<String>();
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(qry);

            while (rs.next()) {
                arrStrings.add(rs.getString(1));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return arrStrings;
    }
    
    // execQuerySSL method that returns an ArrayList<StudentScoresListStruct>. 
    // StudentScoresListStruct data type has two data members: String uname and String score.
    // Basically, it's a 2-D array where each element in the first array holds an array of two Strings,
    // but this implementation ensures that each uname is associated with the correct score.
    // That means that each uname is part of the same StudentScoresListStruct as its score.
    public static ArrayList<String> execQuerySSL(String qry) {
        ArrayList<String> arrSSLStruct = new ArrayList<String>();
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(qry);
            
            while (rs.next()) {
                String sslStruct = "";
                sslStruct += rs.getInt(1);
                sslStruct += rs.getString(2);
                sslStruct += rs.getString(3);
                arrSSLStruct.add(sslStruct);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        } 
        return arrSSLStruct;
        
    }

    public static void execNonQuery(String qry) {

        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();
            int res = stmt.executeUpdate(qry);

            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
