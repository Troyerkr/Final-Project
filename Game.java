import java.io.*; import javax.swing.*; 
import java.util.*; import java.awt.event.*;
import java.awt.*; import java.lang.*;

public class Game /*implements  ActionListener */ {
  private ArrayList<Question> qList = new ArrayList<Question>();
  private ArrayList<Question> bigList = new ArrayList<Question>();
  Game(int manyQuestions, int manyPlayers){
  try{
      FileReader fR = new FileReader("trivia.txt");
      BufferedReader reader = new BufferedReader(fR);
      int m = manyPlayers;
      int qu = manyQuestions;
      
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
        /*print out what it reads
        System.out.println(question);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(aIndex);
        System.out.println(points);*/
  }
      reader.close();
  }catch(IOException e){
      System.out.println("An error occurred: " + e);
  }
    for (int i = 0; i < manyQuestions; i++) {
      qList.add(bigList.get(i));
    }

    
  }
}



