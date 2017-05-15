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
    private int myPincode;
    private int myTeacherID;
    
    public Test()
    {
        myQuestions = new Question[]{new Question()};
        myPincode = -1;
        myTeacherID= -1;
    }
    
    public Test(Question[] questions, int pincode, int teacherID)
    {
        setQuestions(questions);
        setPincode(pincode);
        setTeacherID(teacherID);
    }
    
    public Question[] getTestQuestions()
    {   return myQuestions;     }
    
    public int getPincode()
    {   return myPincode;       }
    
    public int getTeacherID()
    {   return myTeacherID;     }
    
    public void setQuestions(Question[] questions)
    {   myQuestions = questions;    }
    
    public void setPincode(int pincode)
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
