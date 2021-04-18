import java.utill.*;

public class Question {
 private String qText;
 private Arraylist answers;
 private int aIndex;
 private int qValue;
 
 void Question(String question, Arraylist aList, int correct, int points){
   qText = question;
   answers = aList;
   aIndex = correct;
   qValue = points;
 }

 public String getQuestion(){
   return qText;
 }

  public Arraylist getAnswers(){
   return answers;
 }

  public String getAnswers(int qNumber){
    x = qNumber - 1;
   return answers.get(x);
 }

  public int getCorrect(){
    return qValue;
  }

    public int getValue(){
    return aIndex;
  }
}