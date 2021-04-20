//todo
//JFrame with tital bar with name of the game
//JLabel welcoming the user to the game
//JLabel that prints out the question text and how many points its worth
//four JButtons that contain one of the answer options
//JLabel that displays what the user's current score is
//JButton for next question
/*

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game implements ActionListener 
{

  String playerName = "";
  JLabel jlabWelcome; //wString playerName = "";
  JLabel jlabWelcome; //welcomes the player 
  JButton answerOne, answerTwo, answerThree, answerFour; //sets up the buttons used to choose your four possible answers
  JFrame frame = new JFrame("Group 11 Trivia Game");
  JFrame gameFrame = new JFrame("Group 11 Trivia Game");
  JLabel jlabRange, jlabLastGuess, jlabIntro, jlabQuestion, jlabPoints, currentScore, addressUser;
  JTextField userName, numQuestions;
  JButton submitName, nextQuestion;
  String[] chooseQuestions = {"10", "25", "50", "75", "100"};
  JComboBox numQuestions;
    Welcome() 
    {       
       
    

    frame.setSize(800, 400);

    frame.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    c.fill = GridBagConstraints.BOTH;
    c.ipady = 40;
    //c.gridwidth = 3;
    c.gridx = 1;
    c.gridy = 0;
    jlabWelcome = new JLabel("Welcome New Player to the Trivia Game!");
    frame.add(jlabWelcome, c);
    
    c.fill = GridBagConstraints.BOTH;
    c.ipady = 0;
    c.gridx = 0;
    c.gridy = 1;
    jlabIntro = new JLabel("Please Enter your name: ");
    frame.add(jlabIntro, c);

    c.fill = GridBagConstraints.BOTH;
    c.ipady = 0;
    c.gridx = 0;
    c.gridy = 1;
    

    c.fill = GridBagConstraints.BOTH;
    c.ipady = 0;
    c.weightx = 0;
    //c.insets = new Insets(5,5,5,5);
    c.gridx = 1;
    c.gridy = 1;
    userName = new JTextField(10);
    frame.add(userName, c);


    c.fill = GridBagConstraints.BOTH;
    c.ipady = 20;      //make this component tall
    c.weightx = 0.0;
    //c.insets = new Insets(0,0,0,0);
    c.gridx = 2;
    c.gridy = 1;
    submitName = new JButton("Submit");
    submitName.addActionListener(this);
    frame.add(submitName, c);

    numQuestions = new JComboBox(chooseQuestions);

    c.gridx = 3;
    c.gridy = 2;
    frame.add(numQuestions, c);


    //
    //Seperate Game Window Frame
    //

    addressUser = new JLabel("Hello " + playerName + "!");
    jlabQuestion = new JLabel("Question: ");
    jlabPoints = new JLabel("Points: ");
    answerOne = new JButton("Answer 1");
    answerTwo = new JButton("Answer 2");
    answerThree = new JButton("Answer 3");
    answerFour = new JButton("Answer 4");
    currentScore = new JLabel("Current Score: ");
    nextQuestion = new JButton("Next Question");

    gameFrame.setSize(800, 400);
    gameFrame.setLayout(new GridBagLayout());
    //GridBagConstraints cg = new GridBagConstraints();

    

    JPanel panel = new JPanel();
    panel.setBackground(Color.darkGray);
    panel.setSize(300,200);
    GridBagLayout layout = new GridBagLayout();
    panel.setLayout(layout);        
    GridBagConstraints gbc = new GridBagConstraints();


    c.fill = GridBagConstraints.HORIZONTAL;
    //c.ipady = 100;
    //c.ipadx = 100;
    c.gridx = 0;
    c.gridy = 0;
    gameFrame.add(addressUser, c);


    c.fill = GridBagConstraints.BOTH;
    //c.ipady = 100;
    //c.ipadx = 100;
    c.gridx = 0;
    c.gridy = 1;
    gameFrame.add(jlabQuestion, c);

    c.fill = GridBagConstraints.BOTH;
    c.gridx = 0;
    c.gridy = 2;
    gameFrame.add(jlabPoints, c);
    

    c.gridx = 0;
    c.gridy = 3;
    gameFrame.add(panel, c);

    c.fill = GridBagConstraints.BOTH;
    c.gridx = 0;
    c.gridy = 2;
    panel.add(answerOne, c);

    c.fill = GridBagConstraints.BOTH;
    c.gridx = 1;
    c.gridy = 2;
    panel.add(answerTwo, c);
    

    c.fill = GridBagConstraints.BOTH;
    c.gridx = 0;
    c.gridy = 3;
    panel.add(answerThree, c);
    

    c.fill = GridBagConstraints.BOTH;
    c.gridx = 1;
    c.gridy = 3;
    panel.add(answerFour, c);
    
    

    c.fill = GridBagConstraints.BOTH;
    c.gridx = 0;
    c.gridy = 5;
    gameFrame.add(currentScore, c);

    c.fill = GridBagConstraints.BOTH;
    c.gridx = 0;
    c.gridy = 6;
    gameFrame.add(nextQuestion, c);

    frame.setVisible(true); 
    
  }

  public void actionPerformed(ActionEvent ae) 
  { 
    if(ae.getActionCommand().equals("Submit")) 
    { 
      frame.setVisible(false);
      playerName = userName.getText();
      System.out.println(playerName);
      addressUser.setText("Hello "+ playerName + "!  Thanks for playing!");
      gameFrame.setVisible(true);
    }
  }
  
} 

