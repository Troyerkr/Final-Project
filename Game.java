import java.io.*; import javax.swing.*; 
import java.util.*; import java.awt.event.*;
import java.awt.*; import java.lang.*;
import java.time.format.DateTimeFormatter; import java.time.LocalDateTime;

/**
* this class houses the java swift code used to run the trivia game as well as the methods used to make the game work
* @author Kyle Troyer, Sam Green, Grady Lipp
* @version 4/20/21
*/
public class Game implements  ActionListener {
  //ArrayList containing the reduced list of questions the size the player selects at the welcome screen
  private ArrayList<Question> qList = new ArrayList<Question>();
  //Array List that holds all of the possible question objects that a player can receive
  private ArrayList<Question> bigList = new ArrayList<Question>();
  //int varibales used to keep track of the current question's attributes
  private int current, currentCorrect, currentValue;
  //string (see line 16)
  private String currentQText;
  //ArrayList (see line 16)
  private ArrayList<String> currentAs;
  //player object
  private Player player;
  //String holding players name (it's the same as player.getName() but used in different contexts)
  private String playerName;
  //int of the max number of questions the player chooses to see in their game
  private int manyQuestions;
  //int playing the role of a boolean because I(Kyle) couldn't get the if statment later on to work at first
  //used to have certain methods behave differently when loading the first question then they do for other questions
  private int firstClick = 0;
  //string holding the user's selection for the manyQuestions
  private String maxNumber;

  JLabel jlabWelcome; //welcomes the player 
  JButton answerOne, answerTwo, answerThree, answerFour; //sets up the buttons used to choose your four possible answers
  JFrame frame = new JFrame("Group 11 Trivia Game"); //welcome frame
  JFrame gameFrame = new JFrame("Group 11 Trivia Game"); //Game frame
  JFrame endFrame = new JFrame("Congratulations"); //Final Screen
  JLabel jlabRange, jlabLastGuess, jlabIntro, jlabQuestion, jlabPoints, currentScore, addressUser, questionLbl, finalLbl; //Various Labels
  JTextField userName, numQuestions; //Text fields
  JButton submitName, nextQuestion; //Buttons
  GridBagConstraints c = new GridBagConstraints(); //This sets up constraints used to format the GUI in a GridBagLayout
  String[] chooseQuestions = {"10", "25", "50"}; //Possible number of questions
  JComboBox questionChoice; //Combo box list of possible number of questions
  //int holding the users current answer choice
  int selectedNumber = 0;


/**
* constructor method for the game class. 
* Its main purpose is to draw the welcome screen
*/
  public Game(){ //Sets up the welcome part of the game
  frame.setSize(800, 400);

    frame.setLayout(new GridBagLayout()); //uses gridbag layout to format the layout

    //gridbagconstraints holds all the variables for how its going to formated in a list and then essentially pastes it all when its added to the frame.  So each variable must be changed before every time something is added unless that constraint needs to stay the same.
    c.fill = GridBagConstraints.BOTH;
    c.ipady = 40; //verticle padding
    c.gridx = 1; //second column
    c.gridy = 0; //first row
    jlabWelcome = new JLabel("Welcome New Player to the Trivia Game!");
    frame.add(jlabWelcome, c); //add to frame using current c list of format variables
    
    c.fill = GridBagConstraints.BOTH;
    c.ipady = 0; //verticle padding
    c.gridx = 0; //first column
    c.gridy = 1; //second row
    jlabIntro = new JLabel("Please Enter your name: ");
    frame.add(jlabIntro, c); //add to frame using current c list of format variables

    c.fill = GridBagConstraints.BOTH;
    c.ipady = 0; 
    c.gridx = 0; 
    c.gridy = 1;
    

    c.fill = GridBagConstraints.BOTH;
    c.ipady = 20; 
    c.weightx = 0; //dont think this is needed but scared to remove it
    c.gridx = 1;  //second column
    c.gridy = 1; //second row
    userName = new JTextField(10);
    frame.add(userName, c);


    c.fill = GridBagConstraints.BOTH;
    c.ipady = 20;//make this component tall
    c.weightx = 0.0;
    c.gridx = 2; //third column
    c.gridy = 2; //third row
    submitName = new JButton("Submit");
    submitName.addActionListener(this); //add detection
    frame.add(submitName, c);

    questionChoice = new JComboBox(chooseQuestions);
    c.gridx = 1; //second column
    c.gridy = 2; //third row
    frame.add(questionChoice, c);

    questionLbl = new JLabel("Select # of Questions: ");
    c.gridx = 0; //first column
    c.gridy = 2; //second row
    frame.add(questionLbl, c);

    //make it so you can see the wlcome screen
    frame.setVisible(true);
  }
  /**
  * this method:
  * 1. loads all of the questions into the "bigList" ArrayList
  * 2. selects the number of questions the user specifies in the welcome screen and puts them into the "qList" ArrayList
  * 3. makes the main gameFrame.
  */
  public void startGame(){
  try{
      FileReader fR = new FileReader("trivia.txt");
      BufferedReader reader = new BufferedReader(fR);
      playerName = userName.getText();
      manyQuestions = Integer.parseInt(maxNumber);
      player = new Player(playerName);
      //read each line and put them in the corrisponding varibales
      while(reader.ready()){
        String question = reader.readLine();
        String a1 = reader.readLine();
        String a2 = reader.readLine();
        String a3 = reader.readLine();
        String a4 = reader.readLine();
        String aIndex = reader.readLine();
        String points = reader.readLine();
        //convert string to int could of just done it in the previous 2 lines but it was before I relized trim was needed
        int cA = Integer.parseInt(aIndex.trim());
        int qP = Integer.parseInt(points.trim());
        //create the answer string and add the values
        ArrayList<String> answers = new ArrayList<String>();
        answers.add(a1);
        answers.add(a2);
        answers.add(a3);
        answers.add(a4);
        //create a new question object and add it to the big list
        Question q = new Question(question,answers,cA,qP);
        bigList.add(q);
  }
  //close the reader
      reader.close();
  }catch(IOException e){
      System.out.println("An error occurred: " + e);
  }
  //for lop that adds the selected number of questions to the question list
    for (int i = 0; i < manyQuestions; i++) {
      qList.add(bigList.get(i));
    }

    //set curent question variables = to the first question
    current = 0;
    currentQText = qList.get(current).getQuestion();
    currentAs = qList.get(current).getAnswers();
    currentCorrect = qList.get(current).getCorrect();
    currentValue = qList.get(current).getValue();
    //--------------
    //make game frame
    //--------------
    addressUser = new JLabel("Hello " + playerName  + "!");
    jlabQuestion = new JLabel(currentQText);
    jlabPoints = new JLabel("Points: " + currentValue);
    answerOne = new JButton(currentAs.get(0));
    answerTwo = new JButton(currentAs.get(1));
    answerThree = new JButton(currentAs.get(2));
    answerFour = new JButton(currentAs.get(3));
    currentScore = new JLabel("Current Score: " + player.getScore());
    nextQuestion = new JButton("Submit");
    gameFrame.setSize(800, 400);
    gameFrame.setLayout(new GridBagLayout());

    //We make a separate panel to hold the buttons because it simplifies the layout of the entire frame.
    JPanel panel = new JPanel();
    panel.setBackground(Color.darkGray);
    panel.setSize(300,200);
    GridBagLayout layout = new GridBagLayout();
    panel.setLayout(layout);        
    
    //this is all adding to the frame and setting the formatting.  Reference Above Comments regarding how to format this
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 0;
    gameFrame.add(addressUser, c);

    c.fill = GridBagConstraints.BOTH;
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
    panel.add(answerOne, c); //add these to separate panel
    answerOne.addActionListener(this);
    answerOne.setBackground(Color.white);

    c.fill = GridBagConstraints.BOTH;
    c.gridx = 1;
    c.gridy = 2;
    panel.add(answerTwo, c); //add these to separate panel
    answerTwo.addActionListener(this);
    answerTwo.setBackground(Color.white);
    
    c.fill = GridBagConstraints.BOTH;
    c.gridx = 0;
    c.gridy = 3;
    panel.add(answerThree, c); //add these to separate panel
    answerThree.addActionListener(this);
    answerThree.setBackground(Color.white);
    
    c.fill = GridBagConstraints.BOTH;
    c.gridx = 1;
    c.gridy = 3;
    panel.add(answerFour, c); //add these to separate panel
    answerFour.addActionListener(this);
    answerFour.setBackground(Color.white);
    
    c.fill = GridBagConstraints.BOTH;
    c.gridx = 0;
    c.gridy = 5;
    gameFrame.add(currentScore, c);

    c.fill = GridBagConstraints.BOTH;
    c.gridx = 0;
    c.gridy = 6;
    gameFrame.add(nextQuestion, c);
    nextQuestion.addActionListener(this);

    //hide welcome screen
    frame.setVisible(false); 
    
  }

/**
* this method changes the question and runs the startGame, checkAnswer, and endGame methods
* it also sets the text to the next question
*/
  public void nextScreen(){ //sets up the next screen after the submit button is hit
    //if statement that runs the first time the user hits submit (the welcome screen)
    if(firstClick == 0){
        //store user's name
        playerName = userName.getText();
        //store max number of questions
        maxNumber = (String)questionChoice.getSelectedItem();
        startGame();
        //change firstClick so this doesn't run again
        firstClick ++;
    }else{
      if (current == manyQuestions - 1){
        //Final Screen stuff
        logScore();
        gameFrame.setVisible(false);
        endGame();
      }else{
        //did they get it right?
        checkAnswer();
        //next question
        current ++;
        //load the variable from the next question
        currentQText = qList.get(current).getQuestion();
        currentAs = qList.get(current).getAnswers();
        currentCorrect = qList.get(current).getCorrect();
        currentValue = qList.get(current).getValue();
        //change label and button text
        jlabQuestion.setText(currentQText);
        jlabPoints.setText("Points: " + currentValue);
        answerOne.setText(currentAs.get(0));
        answerTwo.setText(currentAs.get(1));
        answerThree.setText(currentAs.get(2));
        answerFour.setText(currentAs.get(3));
        currentScore.setText("Current Score: " + player.getScore());
        addressUser.setText("Hello "+ playerName + "!  Thanks for playing!");
      }
    }
  }
  /**
  * this method runs everytime the user hits submit and then if statements decide what happens as a result
  */
  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("Submit")) { 
      frame.setVisible(false);
      nextScreen();
      //checkAnswer();
      if(current != manyQuestions - 1){
      gameFrame.setVisible(true);
      }
    }
    //if the user picks answer 1
    else if(ae.getActionCommand().equals(answerOne.getText())) 
    {
      //changes the color of the highlighted answer
      answerOne.setBackground(Color.blue);
      answerTwo.setBackground(Color.white);
      answerThree.setBackground(Color.white);
      answerFour.setBackground(Color.white);

      //changes the text of the highlighted answer
      answerOne.setForeground(Color.white);
      answerTwo.setForeground(Color.black);
      answerThree.setForeground(Color.black);
      answerFour.setForeground(Color.black);

      selectedNumber = 1; //variable that holds which answer has been selected
    }
    //click on answer two
    else if(ae.getActionCommand().equals(answerTwo.getText())) 
    {
      //changes the color of the highlighted answer
      answerOne.setBackground(Color.white);
      answerTwo.setBackground(Color.blue);
      answerThree.setBackground(Color.white);
      answerFour.setBackground(Color.white);

      //changes the text of the highlighted answer
      answerOne.setForeground(Color.black);
      answerTwo.setForeground(Color.white);
      answerThree.setForeground(Color.black);
      answerFour.setForeground(Color.black);
      selectedNumber = 2;//variable that holds which answer has been selected
    }
    //click on answer three
    else if(ae.getActionCommand().equals(answerThree.getText())) 
    {
      //changes the color of the highlighted answer
      answerOne.setBackground(Color.white);
      answerTwo.setBackground(Color.white);
      answerThree.setBackground(Color.blue);
      answerFour.setBackground(Color.white);

      //changes the text of the highlighted answer
      answerOne.setForeground(Color.black);
      answerTwo.setForeground(Color.black);
      answerThree.setForeground(Color.white);
      answerFour.setForeground(Color.black);
      selectedNumber = 3;//variable that holds which answer has been selected
      

    }
    //click on answer four
    else if(ae.getActionCommand().equals(answerFour.getText())) 
    {
      //changes the color of the highlighted answer
      answerOne.setBackground(Color.white);
      answerTwo.setBackground(Color.white);
      answerThree.setBackground(Color.white);
      answerFour.setBackground(Color.blue);

      //changes the text of the highlighted answer
      answerOne.setForeground(Color.black);
      answerTwo.setForeground(Color.black);
      answerThree.setForeground(Color.black);
      answerFour.setForeground(Color.white);
      selectedNumber = 4;//variable that holds which answer has been selected
    }
  }
  /**
  * this method checks to see if the player selected the right answer
  * also resets the the color of the buttons to the default
  */
  public void checkAnswer(){ 
    if(firstClick == 0){ //do nothing
    }
    else if(selectedNumber == currentCorrect){
		  player.setScore(player.getScore() + currentValue);
	    }

      //resets background and font color upon reset of the screen
      answerOne.setBackground(Color.white);
      answerTwo.setBackground(Color.white);
      answerThree.setBackground(Color.white);
      answerFour.setBackground(Color.white);

      answerOne.setForeground(Color.black);
      answerTwo.setForeground(Color.black);
      answerThree.setForeground(Color.black);
      answerFour.setForeground(Color.black);
  }
  /**
  * this method add the players score to score.txt
  */
  private void logScore(){
	try{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
		LocalDateTime now = LocalDateTime.now();
    File f1 = new File("score.txt");
    if(!f1.exists()) {
      f1.createNewFile();
    }
    FileWriter fileWritter = new FileWriter(f1.getName(),true);
    BufferedWriter bw = new BufferedWriter(fileWritter);
    bw.newLine();
    bw.write("Player: " + playerName + " -- ");
    bw.write("Score: "+ Integer.toString(player.getScore()) + " -- ");
    bw.write("# of Question: " + Integer.toString(manyQuestions) + " -- ");
    bw.write("Date: " + dtf.format(now));
    bw.close();


	}
	catch(IOException exception){
		System.out.println("An error occurred: " + exception);
	}
}

/**
* this method houses the end screen a creates the leaderboard
* by reading the score.txt and putting the results in a JTable
*/
private void endGame(){
  //ArrayList with each row of score.txt
	ArrayList<String> leaderList = new ArrayList<String>();
  try{
  //file reader
	FileReader fR = new FileReader("score.txt");
    BufferedReader reader = new BufferedReader(fR);
    while(reader.ready()){
      //add the row to the ArrayList
		  leaderList.add(reader.readLine());
	  }
  //close reader
  reader.close();
  }
  catch(IOException e){
    System.out.println("An error occurred: " + e);
    
  }
  //create the arrays used to make the JTable
  String[] head = {"Leaderboard"};
  String[][] rows = new String [leaderList.size()][head.length];
  //add values to the "rows" 2D array
  for(int r = 0; r < leaderList.size(); r++){
    rows[r][0] = leaderList.get(r);
  }
  //create the leaderboard
	JTable leadboard = new JTable(rows,head);
  //make it scrollable
	JScrollPane sp = new JScrollPane(leadboard);
  //have it fill the container
	leadboard.setFillsViewportHeight(true);
  //--------------------------
  //frame for end score display
  //---------------------------
  endFrame.setSize(800, 400);
  endFrame.setLayout(new FlowLayout());
  endFrame.setVisible(true);
  finalLbl = new JLabel("Congratulations " + player.getName() + "! your final score was " + player.getScore() + "!");
  finalLbl.setForeground(Color.green);

  endFrame.add(finalLbl);
  endFrame.add(sp);
	}
}