import java.io.*; import javax.swing.*; 
import java.util.*; import java.awt.event.*;
import java.awt.*; import java.lang.*;

public class Game /*implements  ActionListener */ {
  private ArrayList<Question> qList = new ArrayList<Question>();
  private ArrayList<Question> bigList = new ArrayList<Question>();
  //use this to index the question list  
  private int current, currentQscore, currentAindex;
  private ArrayList<String> currentAs;
  private String currentQTxt;
  //there are 47 questions total
  //we could think of 3 for 50
  Game(int manyQuestions, String playerName){
  try{
      Player p = new Player(playerName);

      current = 0;
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
    currentQTxt = qlist.get(current).getQuestion();
    currentAs = qlist.get(current).getAnswers();
    currentAindex = qlist.get(current).getCorrect();
    currentQscore = qlist.get(current).getValue();
    /*
    //make this trigger on the next question button
    private void nextQuestion(int maxQuestion){
      //hide screen
      //check if they answerd correctly
      // add value to scores
      if (current == maxQuestion){
        //whatever the end screen is
      }else{
        current++
        currentQTxt = qlist.get(current).getQuestion();
        currentAs = qlist.get(current).getAnswers();
        currentAindex = qlist.get(current).getCorrect();
        currentQscore = qlist.get(current).getValue();
      }
      //reprint the screen
    }*/ 
    
  }
  

}



