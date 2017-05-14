/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import java.util.ArrayList;
import static smartesttest.DBHandler.execNonQuery;
import static smartesttest.DBHandler.execQuery;
import static smartesttest.DBHandler.execQuerySSL;
import static smartesttest.utils.toObj;
import static smartesttest.utils.toStr;

/**
 *
 * @author csc190
 */
public class server {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    // What happens when teacher clicks "Manage Tests" in TeacherDash
    public static ArrayList<String> pullTests(int tid){
        String query = "SELECT pincode FROM tbl_test WHERE tid='" + tid + "';";
        ArrayList<String> arrPincodes = execQuery(query);
        return arrPincodes;
    }
    
    // What happens when teacher clicks "LO" in ManageTestsScene
    public static ArrayList<ArrayList<String>> pullTestLO(String pincode){
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
    
    //increments the tests individual LOs upon a question being grading
    public static void updateTestLOs(String pincode,String cat1, String cat2, Boolean right){
        String query1 = "SELECT correct FROM tbl_testLOs WHERE pincode='" + pincode + "' AND cat1='"+ cat1 +"' AND cat2='" + cat2 + "';";
        ArrayList<String> correctS = execQuery(query1);
        String query2 = "SELECT total FROM tbl_testLOs WHERE pincode='" + pincode + "' AND cat1='"+ cat1 +"' AND cat2='" + cat2 + "';";
        ArrayList<String> totalS = execQuery(query2);
        int correct = Integer.valueOf(correctS.get(0)); int total = Integer.valueOf(totalS.get(0));
        if (right){correct++; total++;}
        else {total++;}
        String query3 = "UPDATE correct FROM tbl_testLOs WHERE pincode='" + pincode + "' AND cat1='"+ cat1 +"' AND cat2='" + cat2 + "' VALUE('" + correct +"');";
        execNonQuery(query3);
        String query4 = "UPDATE total FROM tbl_testLOs WHERE pincode='" + pincode + "' AND cat1='"+ cat1 +"' AND cat2='" + cat2 + "' VALUE('" + total +"');";
        execNonQuery(query4);
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
    public static GradedTest pullStudentGradedTest(int id, int pincode){
        String query = "SELECT gradedTestObj FROM tbl_gradedtest WHERE sid='" + id + "' AND pincode='" + pincode + "';";
        ArrayList<String> strGradedTest = execQuery(query);
        GradedTest gradedTest = (GradedTest) toObj(strGradedTest.get(0));
        return gradedTest;
    }
    
    // What happens when teacher clicks "View Dept LOs" in TeacherDash
    public static ArrayList<ArrayList<String>> pullDepartmentLOs(){
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
    
    //increments the department LOs upon a question being grading
    public static void updateDepartmentLOs(String cat1, String cat2, Boolean right){
        String query1 = "SELECT correct FROM tbl_deptLOs WHERE cat1='"+ cat1 +"' AND cat2='" + cat2 + "';";
        ArrayList<String> correctS = execQuery(query1);
        String query2 = "SELECT total FROM tbl_deptLOs WHERE cat1='"+ cat1 +"' AND cat2='" + cat2 + "';";
        ArrayList<String> totalS = execQuery(query2);
        int correct = Integer.valueOf(correctS.get(0)); int total = Integer.valueOf(totalS.get(0));
        if (right){correct++; total++;}
        else {total++;}
        String query3 = "UPDATE correct FROM tbl_deptLOs WHERE cat1='"+ cat1 +"' AND cat2='" + cat2 + "' VALUE('" + correct +"');";
        execNonQuery(query3);
        String query4 = "UPDATE total FROM tbl_deptLOs WHERE cat1='"+ cat1 +"' AND cat2='" + cat2 + "' VALUE('" + total +"');";
        execNonQuery(query4);
    }
    
    // What happens when student clicks "Take a Test" after they enter valid pincode
    public static ArrayList<String> pullTest(String pincode){
        String query = "SELECT testObj FROM tbl_test WHERE pincode='" + pincode +"';";
        ArrayList<String> test = execQuery(query);
        return test;
    }
    
    // What happens when student finishes taking a test and clicks "submit"
    public static void saveGradedTest(int sid, String pincode, GradedTest gt, String score){
        String gtContent = toStr(gt);
        String query = "INSERT INTO tbl_gradedtest (sid, pincode, gradedTestObj, score) VALUES ('" +
                sid + "', '" + pincode + "', '" + gtContent + "', '" + score + "');";
        execNonQuery(query);
    }
    
    // Encodes a user's password by converting the input String into a byte array
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
    
    // Adds a user to the database when admin clicks "Submit" in AddUserScene
    public static void addUser(String userName, String userPass, String userRole){
        String encodedPWD = encrypt(userPass);
        String query = "INSERT INTO tbl_user (role, uname, encodedPWD) VALUES ('" + userRole + "', '" +
                userName + "', '" + encodedPWD + "');";
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
        String encodedPWD = encrypt(newPass); // May change with implementation of hasher
        String query = "UPDATE tbl_user SET encodedPWD='" + encodedPWD + "' WHERE id=" + userID + ";";
        execNonQuery(query);
    }
    
    // What happens when teacher clicks "Finalize" after creating a Test
    public static void saveTest(int pincode , int teacherID, Test myTest){
        String testContent = toStr(myTest);
        String query = "INSERT INTO tbl_test (pincode, tid, testObj) VALUES ('" + pincode + "', '" +
                teacherID + "', '" + testContent + "');";
        execNonQuery(query); 
    }
}
