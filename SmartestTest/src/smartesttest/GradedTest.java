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
public class GradedTest implements java.io.Serializable
{
    private Test myTest;
    private int myStuID;
    private int[] myStuAns;
    private int myNumCorrect;
    private int myScore;
    private double myPercent;
    private int myTotalPoints;
    
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
    
    public int getNumCorrect()
    {   return myNumCorrect;    }
    
    public int getScore()
    {   return myScore; }
    
    public int getTotalPoints()
    {   return myTotalPoints;   }
    
    public double getPercent()
    {   return myPercent;   }
    
    public void grade()
    {
        //for every question
        Question[] questionList = myTest.getTestQuestions();
        for(int i =0; i < questionList.length; i ++)
        {
            //for every LO in that Question
            int k = questionList[i].getLOs().get(1).size();
            for(int j=0; j< k; j++){
                //updates department LO
                String cat1 = questionList[i].getLOs().get(0).get(j);
                String cat2 = questionList[i].getLOs().get(1).get(j);
                server.updateDepartmentLOs(cat1, cat2, 
                       gradeQuestion(myStuAns[i], questionList[i].getCorrectAnswer()));
                //updates department LO category overall
                String cat3 = questionList[i].getLOs().get(0).get(j);
                server.updateDepartmentLOs(cat3,
                       "default", gradeQuestion(myStuAns[i], questionList[i].getCorrectAnswer()));
               
                //updatesTest los
                server.updateTestLO(""+myTest.getPincode(), questionList[i].getLOs().get(0).get(j),
                       questionList[i].getLOs().get(1).get(j), 
                       gradeQuestion(myStuAns[i], questionList[i].getCorrectAnswer()));
                //updates test lo category overall
                server.updateTestLO(""+myTest.getPincode(), questionList[i].getLOs().get(0).get(j),
                       "default", gradeQuestion(myStuAns[i], questionList[i].getCorrectAnswer()));
            }
            
            if(gradeQuestion(myStuAns[i], questionList[i].getCorrectAnswer()))
            {
                myScore += questionList[i].getPointValue();
                myNumCorrect++;
            }
        }
        for(Question q: myTest.getTestQuestions())
        {
            myTotalPoints += q.getPointValue();
        }
        myPercent = Math.round((double)myScore/(double)myTotalPoints *100);
    }
    
    private boolean gradeQuestion(int ans, int correctAns)
    {   return ans == correctAns;   }
    
}
