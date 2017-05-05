/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import java.util.Base64;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 *
 * @author csc190
 */
public class utils {
    
    public static String mySeed = "halp";
    
    public byte[] hasher(String hashInput){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(mySeed);
        String encrypted = encryptor.encrypt(hashInput);
        byte[] bytesEncoded = Base64.getEncoder().encode(encrypted.getBytes());
        return bytesEncoded;
    } 
    
    public String toStr(Object myObj){
        return "a";
    }
    
    public void addUser(String userName, String userPass, String userRole){
        
    }
    
    public String[][] pullUserList(){
        String[][] userArr = {{"a","b"},{"c","d"}};
        return userArr; 
    }
    
    public void resetPWD(String newPass, int userID){
        
    }
    
    //make sure to change parameter type on this one
    public void saveTest(Test myTest){
        
    }

    public int[] pullTests(int tid){
        return new int[5];
    }
    
    public String[][] pullTestLO(int pincode){
        return new String[5][5];
    }
    
    public String[][] pullTeacherGradedTest(int pincode){
        return new String[5][5];
    }
    
    public GradedTest pullStudentGradedTest(int id, int pincode){
        return new GradedTest();
    }
    
    public String[][] pullDepartmentLOs(){
        return new String[5][5];
    }
    
    public Test pullTest(int pincode){
        return new Test();
    }
    
    public void saveGradedTest(GradedTest gT){
        
    }
}
