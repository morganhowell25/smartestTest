/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttestserver;

import java.util.ArrayList;
import static smartesttestserver.DBHandler.execNonQuery;
import static smartesttestserver.DBHandler.execQuery;
import static smartesttestserver.DBHandler.execQuerySSL;
import static smartesttestserver.utils.toObj;
import static smartesttestserver.utils.toStr;

/**
 *
 * @author csc190
 */
public class server {
    public static String mySeed = "halp";

    // What happens when teacher clicks "Manage Tests" in TeacherDash
    public static void pullTests(int tid){
        String query = "SELECT pincode FROM tbl_test WHERE tid='" + tid + "';";
        ArrayList<String> arrPincodes = execQuery(query);
        System.out.println(utils.toStr(arrPincodes));
    }
    
    // What happens when teacher clicks "LO" in ManageTestsScene
    public static void pullTestLO(String pincode){
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
        System.out.println(utils.toStr(arrTestLOs));
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
    public static void viewStudentScores(String pincode){
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
        
        System.out.println(utils.toStr(arrSSLStruct));
    }
    
    // What happens when student or teacher views an individual student's test
    // ***THIS WILL BE CALLED IN BOTH ViewStudentScoresSceneTeacher AND ViewStudentScoresScene***
    public static void pullStudentGradedTest(int id, int pincode){
        String query = "SELECT gradedTestObj FROM tbl_gradedtest WHERE sid='" + id + "' AND pincode='" + pincode + "';";
        ArrayList<String> strGradedTest = execQuery(query);
        GradedTest gradedTest = (GradedTest) toObj(strGradedTest.get(0));
        System.out.println(utils.toStr(gradedTest));
    }
    
    // What happens when teacher clicks "View Dept LOs" in TeacherDash
    public static void pullDepartmentLOs(){
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
        System.out.println(utils.toStr(arrDeptLOs));
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
    public static void pullTest(String pincode){
        String query = "SELECT testObj FROM tbl_test WHERE pincode='" + pincode +"';";
        ArrayList<String> test = execQuery(query);
        System.out.println(utils.toStr(test));
    }
    
    public static void pullTakenTestList(int id)
    {
        String query = "SELECT pincode FROM tbl_gradedtest WHERE sid='"+id+"';";
        ArrayList<String> pincodeList = execQuery(query);
        System.out.println(utils.toStr(pincodeList));
    }
    
    // What happens when student finishes taking a test and clicks "submit"
    public static void saveGradedTest(int sid, String pincode, String gt, String score){
        String query = "INSERT INTO tbl_gradedtest (sid, pincode, gradedTestObj, score) VALUES ('" +
                sid + "', '" + pincode + "', '" + gt + "', '" + score + "');";
        execNonQuery(query);
    }
    
   
    // Adds a user to the database when admin clicks "Submit" in AddUserScene
    public static void addUser(String userName, String userPass, String userRole){
        String query = "INSERT INTO tbl_user (role, uname, encodedPWD) VALUES ('" + userRole + "', '" +
                userName + "', '" + userPass + "');";
        execNonQuery(query);
    }
    
    // What happens when admin clicks "Manage Users" in AdminDash
    public static void pullUserList(){
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
        System.out.println(utils.toStr(arrUsers));
    }
    
    public static void pullUInfo(String uname){
        String queryu = "SELECT uname FROM tbl_user WHERE uname='" + uname + "';";
        String queryp = "SELECT encodedPWD FROM tbl_user WHERE uname='" + uname + "';";
        String queryr = "SELECT role FROM tbl_user WHERE uname='" + uname + "';";
        ArrayList<String> credentialsu = execQuery(queryu);
        ArrayList<String> credentialsp = execQuery(queryp);
        ArrayList<String> credentialsr = execQuery(queryr);
        //System.out.println(credentialsu.get(0) + " " + credentialsp.get(0) + " " + credentialsr.get(0));
        ArrayList<ArrayList<String>> arrUnames = new ArrayList<ArrayList<String>>();
        arrUnames.add(credentialsu);
        arrUnames.add(credentialsp);
        arrUnames.add(credentialsr);
        //System.out.println(arrUnames.get(0).get(0) + " " + arrUnames.get(1).get(0) + " " + arrUnames.get(2).get(0));
        String strArr = utils.toStr(arrUnames);
        System.out.println(strArr);
        //ArrayList<ArrayList<String>> arr = (ArrayList<ArrayList<String>>)utils.toObj(strArr);
        //Object obj1 = utils.toObj(strArr);
        //ArrayList<ArrayList<String>> arr1 = new ArrayList<ArrayList<String>>();
        //arr1 = (ArrayList<ArrayList<String>>)obj1;
        //System.out.println(arr.get(0).get(0) + " " + arr.get(1).get(0) + " " + arr.get(2).get(0));
        
    }
    
    // What happens when admin clicks "Reset password" in ManageUserScene
    public static void resetPWD(String newPass, int userID){
        String query = "UPDATE tbl_user SET encodedPWD='" + newPass + "' WHERE id=" + userID + ";";
        execNonQuery(query);
    }
    
    // What happens when teacher clicks "Finalize" after creating a Test
    public static void saveTest(String pincode , int teacherID, String myTest){
        //String testContent = toStr(myTest);
        String query = "INSERT INTO tbl_test (pincode, tid, testObj) VALUES ('" + pincode + "', '" +
                teacherID + "', '" + myTest + "');";
        execNonQuery(query); 
    }
    
    public static void uploadOneLO(String cat1, String cat2){
        String query = "INSERT INTO tbl_deptLOs (cat1, cat2, correct, total) VALUES ('" + cat1 + "', '" + cat2 + "', 'XX', 'ZZ');";
        execNonQuery(query);
    }
    
    public static void checkUname(String uname){
        String query = "SELECT uname from tbl_user WHERE uname='" + uname + "';";
        ArrayList<String> unames = execQuery(query);
        String arr = utils.toStr(unames);
        System.out.println(arr);
    }
    
    public static void pullID(String uname){
        String query = "SELECT id from tbl_user WHERE uname='" + uname + "';";
        ArrayList<String> arrID = execQuery(query);
        String arr = utils.toStr(arrID);
        System.out.println(arr);
    }
    
    public static void main(String[] args){
        String op = args[0];
        switch(op){
            case "pullTests":
                pullTests(Integer.parseInt(args[1]));
                break;
            case "pullTestLO":
                pullTestLO(args[1]);
                break;
            case "updateTestLOs":
                updateTestLOs(args[1],args[2],args[3],Boolean.getBoolean(args[4]));
                break;
            case "viewStudentScores":
                viewStudentScores(args[1]);
                break;
            case "pullStudentGradedTest":
                pullStudentGradedTest(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
                break;
            case "pullDepartmentLOs":
                pullDepartmentLOs();
                break;    
            case "updateDepartmentLOs":
                updateDepartmentLOs(args[1],args[2],Boolean.getBoolean(args[3]));
                break;
            case "pullTest":
                pullTest(args[1]);
                break;
            case "saveGradedTest":
                saveGradedTest(Integer.parseInt(args[1]),args[2],args[3],args[4]);
                break;
            case "addUser": 
                addUser(args[1],args[2],args[3]);
                break;
            case "pullUserList":
                pullUserList();
                break;
            case "pullUInfo":
                pullUInfo(args[1]);
                break;
            case "resetPWD":
                resetPWD(args[1],Integer.parseInt(args[2]));
                break;
            case "saveTest":
                saveTest(args[1],Integer.parseInt(args[2]),args[3]);
                break;
            case "pullTakenTestList":
                pullTakenTestList(Integer.parseInt(args[1]));
                break;
            case "uploadOneLO":
                uploadOneLO(args[1],args[2]);
                break;
            case "checkUname":
                checkUname(args[1]);
                break;
            case "pullID":
                pullID(args[1]);
                break;   
        }
    }
}
