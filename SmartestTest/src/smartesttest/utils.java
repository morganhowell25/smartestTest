/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;


public class utils {
    
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
