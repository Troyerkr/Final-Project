import java.io.*; import javax.swing.*; 
import java.util.*; import java.awt.event.*;
import java.awt.*; import java.lang.*;

public class Game /*implements  ActionListener */ {
  private ArrayList<Question> qList = new ArrayList<Question>();
  private ArrayList<Question> bigList = new ArrayList<Question>();
  private int current, currentCorrect, currentValue;
  private String currentQText;
  private ArrayList<String> currentAs;
  private String playerName;
  private int manyQuestions;
  
  public Game(){
  

  }

  public void startGame(){
  try{
      FileReader fR = new FileReader("trivia.txt");
      BufferedReader reader = new BufferedReader(fR);
      
      while(reader.ready()){
        String question = reader.readLine();
        String a1 = reader.readLine();
        String a2 = reader.readLine();
        String a3 = reader.readLine();
        String a4 = reader.readLine();
        int aIndex = Integer.parseInt(reader.readLine());
        int points = Integer.parseInt(reader.readLine());
    
        ArrayList<String> answers = new ArrayList<String>();
        answers.add(a1);
        answers.add(a2);
        answers.add(a3);
        Question q = new Question(question,answers,aIndex,points);
        bigList.add(q);
        //print out what it reads
        System.out.println(question);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(aIndex);
        System.out.println(points);
  }
      reader.close();
  }catch(IOException e){
      System.out.println("An error occurred: " + e);
  }
    for (int i = 0; i < manyQuestions; i++) {
      qList.add(bigList.get(i));
    }
    current = 0;
    currentQText = qList.get(current).getQuestion();
    currentAs = qList.get(current).getAnswers();
    currentCorrect = qList.get(current).getCorrect();
    currentValue = qList.get(current).getValue();
    //run next screen method
  }
  public void nextScreen(){
    if (current == manyQuestions){
      //Final Screen stuff
    }
    else{
      current ++;
      currentQText = qList.get(current).getQuestion();
      currentAs = qList.get(current).getAnswers();
      currentCorrect = qList.get(current).getCorrect();
      currentValue = qList.get(current).getValue();
      //print screen stuff





    }

  }

}



