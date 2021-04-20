import java.util.*;

public class Question {
 private String qText;
 private ArrayList<String> answers;
 private int aIndex;
 private int qValue;
 
 public Question(){
   qText = "";
   answers = new ArrayList<String>();
   aIndex = 0;
   qValue = 0;
 }
 
 public Question(String question, ArrayList<String> aList, int correct, int points){
   qText = question;
   answers = aList;
   aIndex = correct;
   qValue = points;
 }

 public String getQuestion(){
   return qText;
 }

  public ArrayList<String> getAnswers(){
   return answers;
 }

  public String getAnswers(int qNumber){
    int x = qNumber - 1;
   return answers.get(x);
 }

  public int getCorrect(){
    return qValue;
  }

    public int getValue(){
    return aIndex;
  }
}