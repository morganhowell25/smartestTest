/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import static smartesttest.DBHandler.execNonQuery;
import static smartesttest.DBHandler.execQuery;
import java.util.Base64;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import static smartesttest.DBHandler.execQuerySSL;

public class utils {
    public static String mySeed = "halp";
    
    // What happens when teacher clicks "Manage Tests" in TeacherDash
    public ArrayList<String> pullTests(int tid){
        String query = "SELECT pincode FROM tbl_test WHERE tid='" + tid + "';";
        ArrayList<String> arrPincodes = execQuery(query);
        return arrPincodes;
    }
    
    // What happens when teacher clicks "LO" in ManageTestsScene
    public ArrayList<ArrayList<String>> pullTestLO(String pincode){
        String query1 = "SELECT cat1 FROM tbl_testLOs WHERE pincode='" + pincode + "';";
        ArrayList<String> arrCat1 = execQuery(query1);
        String query2 = "SELECT cat2 FROM tbl_testLOs WHERE pincode='" + pincode + "';";
        ArrayList<String> arrCat2 = execQuery(query2);
        String query3 = "SELECT correct FROM tbl_testLOs WHERE pincode='" + pincode + "';";
        ArrayList<String> arrCorrect = execQuery(query3);
        String query4 = "SELECT total FROM tbl_testLOs WHERE pincode='" + pincode + "';";
        ArrayList<String> arrTotal = execQuery(query4);
        ArrayList<ArrayList<String>> arrTestLOs = new ArrayList<ArrayList<String>>();
        arrTestLOs.add(arrCat1);
        arrTestLOs.add(arrCat2);
        arrTestLOs.add(arrCorrect);
        arrTestLOs.add(arrTotal);
        return arrTestLOs;
    }
    
    // What happens when teacher clicks "View Student Scores" in ManageTestsScene
    public static ArrayList<StudentScoresListStruct> viewStudentScores(String pincode){
        // Pull all student ids for the students who took the specific test
        // Pull all unames for each sid
        // Pull all scores associated with each uname
        // Store each uname and associated score in a StudentScoresListStruct, which has two data members: String uname and String score.
        String query = "SELECT tbl_user.id, uname, score FROM tbl_user JOIN tbl_gradedtest ON tbl_gradedtest.sid = tbl_user.id" + 
                " WHERE pincode='" + pincode +"';";
        ArrayList<StudentScoresListStruct> arrSSLStruct = execQuerySSL(query);
        //String query2 = "SELECT uname FROM tbl_user JOIN tbl_gradedtest ON tbl_gradedtest.sid = tbl_user.id" +
        //        " WHERE pincode='" + pincode + "';";
        //ArrayList<String> arrUnames = execQuery(query2);*/
        
        return arrSSLStruct;
    }
    
    // What happens when student or teacher views an individual student's test
    // ***THIS WILL BE CALLED IN BOTH ViewStudentScoresSceneTeacher AND ViewStudentScoresScene***
    public GradedTest pullStudentGradedTest(int id, int pincode){
        String query = "SELECT gradedTestObj FROM tbl_gradedtest WHERE sid='" + id + "' AND pincode='" + pincode + "';";
        ArrayList<String> strGradedTest = execQuery(query);
        GradedTest gradedTest = (GradedTest) toObj(strGradedTest.get(0));
        return gradedTest;
    }
    
    // What happens when teacher clicks "View Dept LOs" in TeacherDash
    public ArrayList<ArrayList<String>> pullDepartmentLOs(){
        String query1 = "SELECT cat1 FROM tbl_deptLOs;";
        ArrayList<String> arrCat1 = execQuery(query1);
        String query2 = "SELECT cat2 FROM tbl_deptLOs;";
        ArrayList<String> arrCat2 = execQuery(query2);
        String query3 = "SELECT correct FROM tbl_deptLOs;";
        ArrayList<String> arrCorrect = execQuery(query3);
        String query4 = "SELECT total FROM tbl_deptLOs;";
        ArrayList<String> arrTotal = execQuery(query4);
        ArrayList<ArrayList<String>> arrDeptLOs = new ArrayList<ArrayList<String>>();
        arrDeptLOs.add(arrCat1);
        arrDeptLOs.add(arrCat2);
        arrDeptLOs.add(arrCorrect);
        arrDeptLOs.add(arrTotal);
        return arrDeptLOs;
    }
    
    // What happens when student clicks "Take a Test" after they enter valid pincode
    public Test pullTest(String pincode){
        String query = "SELECT testObj FROM tbl_test WHERE pincode='" + pincode +"';";
        ArrayList<String> test = execQuery(query);
        Test myTest = (Test) toObj(test.get(0));
        return myTest;
    }
    
    // What happens when student finishes taking a test and clicks "submit"
    public static void saveGradedTest(int sid, String pincode, GradedTest gt, String score){
        String gtContent = toStr(gt);
        String query = "INSERT INTO tbl_gradedtest (sid, pincode, gradedTestObj, score) VALUES ('" +
                sid + "', '" + pincode + "', '" + gtContent + "', '" + score + "');";
        execNonQuery(query);
    }
    
    // Encodes a user's password by converting the input String into a byte array
    public static byte[] hasher(String hashInput){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(mySeed);
        String encrypted = encryptor.encrypt(hashInput);
        byte[] bytesEncoded = Base64.getEncoder().encode(encrypted.getBytes());
        return bytesEncoded;
    } 
    
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
    public Object toObj(String str) {
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
    
    // Adds a user to the database when admin clicks "Submit" in AddUserScene
    public static void addUser(String userName, String userPass, String userRole){
        String query = "INSERT INTO tbl_user (role, uname, encodedPWD) VALUES ('" + userRole + "', '" +
                userName + "', '" + userPass + "');";
        execNonQuery(query);
    }
    
    // What happens when admin clicks "Manage Users" in AdminDash
    public static ArrayList<ArrayList<String>> pullUserList(){
        String query1 = "SELECT id FROM tbl_user;";
        ArrayList<String> arrIDs = execQuery(query1);
        String query2 = "SELECT role FROM tbl_user;";
        ArrayList<String> arrRoles = execQuery(query2);
        String query3 = "SELECT uname FROM tbl_user;";
        ArrayList<String> arrUnames = execQuery(query3);
        ArrayList<ArrayList<String>> arrUsers = new ArrayList<ArrayList<String>>();
        arrUsers.add(arrIDs);
        arrUsers.add(arrRoles);
        arrUsers.add(arrUnames);
        return arrUsers;
    }
    
    // What happens when admin clicks "Reset password" in ManageUserScene
    public static void resetPWD(String newPass, int userID){
        byte[] encodedPWD = hasher(newPass); // May change with implementation of hasher
        String query = "UPDATE tbl_user SET encodedPWD='" + encodedPWD + "' WHERE id=" + userID + ";";
        execNonQuery(query);
    }
    
    // What happens when teacher clicks "Finalize" after creating a Test
    public void saveTest(int pincode , int teacherID, Test myTest){
        String testContent = toStr(myTest);
        String query = "INSERT INTO tbl_test (pincode, tid, testObj) VALUES ('" + pincode + "', '" +
                teacherID + "', '" + testContent + "');";
        execNonQuery(query); 
    }
}
