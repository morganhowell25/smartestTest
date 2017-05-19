/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import java.net.URLEncoder;
import java.util.ArrayList;

/**
 *
 * @author csc190
 */
public class server {
    
    // What happens when teacher clicks "Manage Tests" in TeacherDash
    public static ArrayList<String> pullTests(int tid) {
        String hold = "";
        try {
            String dataStr = "op=pullTests&tid=" + URLEncoder.encode(String.valueOf(tid), "UTF-8");
            String url = "http://localhost/smartestTest.php";
            hold = DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
        return (ArrayList<String>)utils.toObj(hold);
    }

    // What happens when teacher clicks "LO" in ManageTestsScene
    public static ArrayList<ArrayList<String>> pullTestLO(String pincode) {
        String hold = "";
        try {
            String dataStr = "op=pullTestLO&pincode=" + URLEncoder.encode(pincode, "UTF-8");
            String url = "http://localhost/smartestTest.php";
            hold = DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
        return (ArrayList<ArrayList<String>>)utils.toObj(hold);
    }

    //increments the tests individual LOs upon a question being grading
    public static void updateTestLOs(String pincode, String cat1, String cat2, boolean right) {
        try {
            String dataStr = "op=updateTestLOs&pincode=" + URLEncoder.encode(pincode, "UTF-8")
                    + "&cat1=" + URLEncoder.encode(cat1, "UTF-8")
                    + "&cat2=" + URLEncoder.encode(cat2, "UTF-8")
                    + "&right=" + URLEncoder.encode(String.valueOf(right), "UTF-8");
            String url = "http://localhost/smartestTest.php";
            DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    // What happens when teacher clicks "View Student Scores" in ManageTestsScene
    public static ArrayList<StudentScoresListStruct> viewStudentScores(String pincode) {
        String hold = "";
        try {
            String dataStr = "op=viewStudentScores&pincode=" + URLEncoder.encode(pincode, "UTF-8");
            String url = "http://localhost/smartestTest.php";
            hold = DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
        
        return (ArrayList<StudentScoresListStruct>)utils.toObj(hold);
    }
    
    
    public static ArrayList<String> pullTakenTestList(int id)
    {
        String hold = "";
        try {
            String dataStr = "op=pullTakenTestList&id=" + URLEncoder.encode(String.valueOf(id), "UTF-8");
            String url = "http://localhost/smartestTest.php";
            hold = DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
        return (ArrayList<String>)utils.toObj(hold);
    }

    // What happens when student or teacher views an individual student's test
    // ***THIS WILL BE CALLED IN BOTH ViewStudentScoresSceneTeacher AND ViewStudentScoresScene***
    public static GradedTest pullStudentGradedTest(int id, String pincode) {
        String hold = "";
        try {
            String dataStr = "op=pullStudentGradedTest&id=" + URLEncoder.encode(String.valueOf(id), "UTF-8")
                    +"&pincode=" + URLEncoder.encode(pincode, "UTF-8");
            String url = "http://localhost/smartestTest.php";
            hold = DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
        return (GradedTest)utils.toObj(hold);
    }

    // What happens when teacher clicks "View Dept LOs" in TeacherDash
    public static ArrayList<ArrayList<String>> pullDepartmentLOs() {
        String hold = "";
        try {
            String dataStr = "op=pullDepartmentLOs";
            String url = "http://localhost/smartestTest.php";
            hold = DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
        return (ArrayList<ArrayList<String>>)utils.toObj(hold);
    }

    //increments the department LOs upon a question being grading
    public static void updateDepartmentLOs(String cat1, String cat2, boolean right) {
        try {
            String dataStr = "op=updateDepartmentLOs&cat1=" + URLEncoder.encode(cat1, "UTF-8")
                    + "&cat2=" + URLEncoder.encode(cat2, "UTF-8")
                    + "&right=" + URLEncoder.encode(String.valueOf(right), "UTF-8");
            String url = "http://localhost/smartestTest.php";
            DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    // What happens when student clicks "Take a Test" after they enter valid pincode
    public static ArrayList<String> pullTest(String pincode) {
        String hold = "";
        try {
            String dataStr = "op=pullTest&pincode=" + URLEncoder.encode(String.valueOf(pincode), "UTF-8");
            String url = "http://localhost/smartestTest.php";
            hold = DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
        return (ArrayList<String>)utils.toObj(hold);
    }

    // What happens when student finishes taking a test and clicks "submit"
    public static void saveGradedTest(int sid, String pincode, GradedTest gt, String score) {
        try {
            String dataStr = "op=saveGradedTest&sid=" + URLEncoder.encode(String.valueOf(sid), "UTF-8")
                    + "&pincode=" + URLEncoder.encode(pincode, "UTF-8")
                    + "&gt=" + URLEncoder.encode(utils.toStr(gt), "UTF-8")
                    + "&score=" + URLEncoder.encode(score, "UTF-8");
            String url = "http://localhost/smartestTest.php";
            DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
    
    // Adds a user to the database when admin clicks "Submit" in AddUserScene
    public static void addUser(String userName, String userPass, String userRole){
        try {
            String dataStr = "op=addUser&userName=" + URLEncoder.encode(userName, "UTF-8")
                    + "&userPass=" + URLEncoder.encode(userPass, "UTF-8")
                    + "&userRole=" + URLEncoder.encode(userRole, "UTF-8");
            String url = "http://localhost/smartestTest.php";
            DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    // What happens when admin clicks "Manage Users" in AdminDash
    public static ArrayList<ArrayList<String>> pullUserList() {
        String hold = "";
        try {
            String dataStr = "op=pullUserList";
            String url = "http://localhost/smartestTest.php";
            hold = DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
        return (ArrayList<ArrayList<String>>)utils.toObj(hold);
    }

    public static ArrayList<ArrayList<String>> pullUInfo(String uname) {
        String hold = "";
        try {
            String dataStr = "op=pullUInfo&uname="+URLEncoder.encode(uname, "UTF-8");
            String url = "http://localhost/smartestTest.php";
            hold = DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
        ArrayList<ArrayList<String>> arr = (ArrayList<ArrayList<String>>)utils.toObj(hold);
        return arr;
    }
    
    

    // What happens when admin clicks "Reset password" in ManageUserScene

    public static void resetPWD(String newPass, int userID){
        try {
            String dataStr = "op=resetPWD&newPass=" + URLEncoder.encode(newPass, "UTF-8")
                    + "&userID=" + URLEncoder.encode(String.valueOf(userID), "UTF-8");
            String url = "http://localhost/smartestTest.php";
            DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    // What happens when teacher clicks "Finalize" after creating a Test
    public static void saveTest(String pincode, int teacherID, Test myTest) {
        try {
            String dataStr = "op=saveTest&pincode=" + URLEncoder.encode(pincode, "UTF-8")
                    + "&teacherID=" + URLEncoder.encode(String.valueOf(teacherID), "UTF-8")
                    + "&myTest=" + URLEncoder.encode(utils.toStr(myTest), "UTF-8");
            String url = "http://localhost/smartestTest.php";
            DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
    
    // Uploads one pair of category 1 and 2 learning outcomes
    public static void uploadOneLO(String cat1, String cat2){
        try {
            String dataStr = "op=uploadOneLO&cat1=" + URLEncoder.encode(cat1, "UTF-8")
                    + "&cat2=" + URLEncoder.encode(cat2, "UTF-8");
            String url = "http://localhost/smartestTest.php";
            DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
    
    // Checks for duplicate username in database
    public static ArrayList<String> checkUname(String uname){
        String hold = "";
        try {
            String dataStr = "op=checkUname&uname=" + URLEncoder.encode(uname, "UTF-8");
            String url = "http://localhost/smartestTest.php";
            hold = DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
        return (ArrayList<String>)utils.toObj(hold);
    }
    
    // Pulls id of username
    public static ArrayList<String> pullID(String uname){
        String hold = "";
        try {
            String dataStr = "op=pullID&uname=" + URLEncoder.encode(uname, "UTF-8");
            String url = "http://localhost/smartestTest.php";
            hold = DBHandler.httpsPost(url, dataStr);
        } catch (Exception exc) {
            System.out.println(exc);
        }
        return (ArrayList<String>)utils.toObj(hold);
    }
}
