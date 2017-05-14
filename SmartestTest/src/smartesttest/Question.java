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
public class Question implements java.io.Serializable 
{
    //The question being asked
    private String myQuestion;
    //An array of Strings that represent the answers to the question
    private String[] myAnswers;
    //The point value of this question
    private int myPointValue;
    //An int that represents the index value of the correct answer 
    //within myAnswers
    private int myCorrectAnswer;
    //An array of the corresponding LO's 
    private String[][] myLOs;
    
    //Default constructor
    public Question()
    {
        myQuestion = "default question";
        myAnswers = new String[]{"ans1", "ans2", "ans3", "ans4"};
        myPointValue = -1;
        myCorrectAnswer = -1;
        myLOs = new String[][]{{"null"}, {"null"}};        
    }
    
    //A Constructor that allows all the values to be set
    public Question(String question, String[] answers, int pointValue, int correctAns, String[][] LOs)
    {
        setQuestion(question);
        setAnswers(answers);
        setPointValue(pointValue);
        setCorrectAnswer(correctAns);
        setLOs(LOs);        
    }
    
    public String getQuestion()
    {   return myQuestion;  }
    
    public String[] getAnswers()
    {   return myAnswers;   }
    
    public int getPointValue()
    {   return myPointValue;    }
    
    public int getCorrectAnswer()
    {   return myCorrectAnswer;     }
    
    public String[][] getLOs()
    {   return myLOs;   }
    
    public void setQuestion(String question)
    {   myQuestion = question;  }
    
    public void setAnswers(String[] answers)
    {   myAnswers = answers;    }
    
    public void setPointValue(int pointValue)
    {   myPointValue = pointValue;  }
    
    public void setCorrectAnswer(int correctAns)
    {   myCorrectAnswer = correctAns;   }
    
    public void setLOs(String[][] LOs)
    {   myLOs = LOs;    }
    
    public String toString()
    {
        String temp = "";
        temp += myQuestion + "/n";
        for(int i =0; i < myAnswers.length; i++)
            temp += ((i+1) + ") " + myAnswers[i] + "\n");
        temp += ("Point Value: " + myPointValue + "\n");
        temp += ("Correct Answer: " + (myCorrectAnswer+1) + "\n");
        temp += "My Learning Outcomes:\n";
        for(int i =0; i < myLOs.length; i++)
            temp += ((i+1) + ") " + myLOs[i] + "\n");
        return temp;
    }
}
