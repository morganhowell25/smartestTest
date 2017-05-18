/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

/**
 *
 * @author csc190
 */
public class Test implements java.io.Serializable
{
    protected Question[] myQuestions;
    private String myPincode;
    private int myTeacherID;
    
    public Test()
    {
        myQuestions = new Question[]{new Question()};
        myPincode = "-1";
        myTeacherID= -1;
    }
    
    public Test(Question[] questions, String pincode, int teacherID)
    {
        setQuestions(questions);
        setPincode(pincode);
        setTeacherID(teacherID);
    }
    
    public Question[] getTestQuestions()
    {   return myQuestions;     }
    
    public String getPincode()
    {   return myPincode;       }
    
    public int getTeacherID()
    {   return myTeacherID;     }
    
    public void setQuestions(Question[] questions)
    {   myQuestions = questions;    }
    
    public void setPincode(String pincode)
    {   myPincode = pincode;    }
    
    public void setTeacherID(int teacherID)
    {   myTeacherID = teacherID;    }
    
    public String toString()
    {
        String temp = "";
        temp += ("Pincode: " + myPincode + "\n");
        temp += ("TeacherID: " + myTeacherID + "\n");
        for(int i=0; i <myQuestions.length; i++)
            temp += myQuestions[i].toString();
        return temp;
    }
}
