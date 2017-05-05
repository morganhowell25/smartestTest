package smartesttest;

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

public class DBHandler {
    
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/employees_db";
    static final String USER = "root";
    static final String PASS = "goodyear123!@#";
    
    public static String httpsPost(String url, String datastr) throws Exception {
        //1. create url and request object
        URL urlObj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-length", String.valueOf(datastr.length()));
        con.setRequestProperty("Content-Type", "application/x-www- form-urlencoded");
        con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0;Windows98;DigExt)");
        con.setDoOutput(true);
        con.setDoInput(true);

        //2. send request out
        DataOutputStream oos = new DataOutputStream(con.getOutputStream());
        oos.writeChars(datastr);
        oos.close();

        //3. collect the https response
        DataInputStream iis = new DataInputStream(con.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(iis));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line + "\n");
            line = br.readLine();
        }
        String sRet = sb.toString();
        return sRet;
    }

    public static String execQuery(String qry) {
        String res = null;
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(qry);

            while (rs.next()) {
                res = rs.getString(1);

            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
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
