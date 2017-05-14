/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

/**
 *
 * @author Morgan Howell
 */
public class GradedTest extends Test
{
    private Test myTest;
    private int myStuID;
    private int[] myStuAns;
    private int myScore;
    
    public GradedTest()
    {
        
    }
    
    public GradedTest(Test test, int[] ans, int stuID)
    {
        myTest = test;
        myStuAns = ans;
        myStuID = stuID;
    }
    
    public Test getTest()
    {   return myTest;  }
    
    public int getStudentID()
    {   return myStuID; }
    
    public int[] getStuAns()
    {   return myStuAns;    }
    
    public int getScore()
    {   return myScore; }
    
    public int getTotalQuestions()
    {   return myTest.getTestQuestions().length;    }
    
    public void grade()
    {
        Question[] questionList = myTest.getTestQuestions();
        for(int i =0; i < questionList.length; i ++)
        {
            for(int j=0; j< questionList[i].getLOs().length; j++){
               // server.updateDepartmentLOs(cat1, cat2, gradeQuestion(myStuAns[i], questionList[i].getCorrectAnswer()));
               //update the db 4 times per LO per question
               // TestLo Overall and indivuial
               //Department Overall and indivual
               
            }
        }
    }
    
    private boolean gradeQuestion(int ans, int correctAns)
    {   return ans == correctAns;   }
    
}
