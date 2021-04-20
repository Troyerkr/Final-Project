import java.util.*;
/**
* this class represents a single trivia question
* @author Kyle Troyer, Sam Green, Grady Lipp
* @version 4/20/21
*/
public class Question {
  //question text
  private String qText;
  //array list of all 4 possible answers to the question
  private ArrayList<String> answers;
  //index of the correct answer within the arraylist of possible answers + 1 
  private int aIndex;
  //point value for the question
  private int qValue;
 
 /**
* this constructor method for the Question class sets all of the questions class's variables 
* to either an empty string/ArrayList or sets it equal to 0.
*/
 public Question(){
   qText = "";
   answers = new ArrayList<String>();
   aIndex = 0;
   qValue = 0;
 }

/**
* this constructor method for the Question class sets all of the questions class's variables equal to the parameters passed as arguments
* @param question - question text, aList - ArrayList of possible answers, correct - index of the correct answer within the 'aList' + 1, points - point value of the question  
*/
 public Question(String question, ArrayList<String> aList, int correct, int points){
   qText = question;
   answers = aList;
   aIndex = correct;
   qValue = points;
 }

/**
* this accessor method returns the question text
* @returen returns question text
*/
 public String getQuestion(){
   return qText;
 }

/**
* this accessor method returns the ArrayList of possible answers
* @returen returns ArrayList of possible answers
*/
  public ArrayList<String> getAnswers(){
   return answers;
 }

/**
* this accessor method returns a specific answer from the ArrayList of answers based on the index number you pass through
* @param qNumber - index value of the answer you want returned within answer ArrayList (for answer 1 put "1")
* @returen returns a specific answer from the ArrayList of answers based on the index number you pass through
*/
  public String getAnswers(int qNumber){
    int x = qNumber - 1;
   return answers.get(x);
 }
/**
* this accessor method returns the index value of the correct answer in the ArrayList of possible answers + 1
* @return returns the index value of the correct answer in the ArrayList of possible answers + 1
*/
  public int getCorrect(){
    return aIndex;
  }
/**
* this accessor returns the current question's point value
* @returen returns the current question's point value
*/
    public int getValue(){
    return qValue;
  }
}