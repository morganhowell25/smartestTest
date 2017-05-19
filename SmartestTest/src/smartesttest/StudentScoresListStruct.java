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
// Essentially I created a Struct that has three data members: an int and two Strings.
// This will make it much easier to handle the query results for viewStudentScores.
// This info will be displayed on the StudentScoresListScene in three columns: one for ids, one for unames, and one for scores.
public class StudentScoresListStruct implements java.io.Serializable {
    public int id; // ID of student retrieved from SELECT query
    public String uname; // Username of student retrieved from SELECT query
    public String score; // Score of student retrieved from SELECT query
    
    @Override
    public String toString() {
        String result = "id = " + id + " uname = " + uname + " score " + score;
        return result;
    }
}