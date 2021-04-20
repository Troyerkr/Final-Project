import java.io.*; import javax.swing.*; 
import java.util.*; import java.awt.event.*;
import java.awt.*; import java.lang.*;
import java.time.format.DateTimeFormatter;import java.time.LocalDateTime;

public class Game implements  ActionListener {
  private ArrayList<Question> qList = new ArrayList<Question>();
  private ArrayList<Question> bigList = new ArrayList<Question>();
  private int current, currentCorrect, currentValue;
  private String currentQText;
  private ArrayList<String> currentAs;
  private Player player;
  private String playerName;
  private int manyQuestions;
  private int firstClick = 0;
  private String maxNumber;

  //JLabel jlabWelcome; //wString playerName = "";
  JLabel jlabWelcome; //welcomes the player 
  JButton answerOne, answerTwo, answerThree, answerFour; //sets up the buttons used to choose your four possible answers
  JFrame frame = new JFrame("Group 11 Trivia Game");
  JFrame gameFrame = new JFrame("Group 11 Trivia Game");
  JFrame endFrame = new JFrame("Congradulations");
  JLabel jlabRange, jlabLastGuess, jlabIntro, jlabQuestion, jlabPoints, currentScore, addressUser, questionLbl, finalLbl;
  JTextField userName, numQuestions;
  JButton submitName, nextQuestion;
  GridBagConstraints c = new GridBagConstraints();
  String[] chooseQuestions = {"10", "25", "50"};
  JComboBox questionChoice;
  int selectedNumber = 0;

  public Game(){
  frame.setSize(800, 400);

    frame.setLayout(new GridBagLayout());

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
    c.ipady = 20; 
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
    c.gridy = 2;
    submitName = new JButton("Submit");
    submitName.addActionListener(this);
    frame.add(submitName, c);
    frame.setVisible(true);    //kyle added
    System.out.println("constructor is working !");
    
    questionChoice = new JComboBox(chooseQuestions);
    c.gridx = 1;
    c.gridy = 2;
    frame.add(questionChoice, c);

    questionLbl = new JLabel("Select # of Questions: ");
    c.gridx = 0;
    c.gridy = 2;
    frame.add(questionLbl, c);
  }

  public void startGame(){
  try{
      FileReader fR = new FileReader("trivia.txt");
      BufferedReader reader = new BufferedReader(fR);
      playerName = userName.getText();
      manyQuestions = Integer.parseInt(maxNumber);
      player = new Player(playerName);
      System.out.println(player.getName() + ": player constructor worked");
      while(reader.ready()){
        String question = reader.readLine();
        String a1 = reader.readLine();
        String a2 = reader.readLine();
        String a3 = reader.readLine();
        String a4 = reader.readLine();
        String aIndex = reader.readLine();
        String points = reader.readLine();
        int cA = Integer.parseInt(aIndex.trim());
        int qP = Integer.parseInt(points.trim());
    
        ArrayList<String> answers = new ArrayList<String>();
        answers.add(a1);
        answers.add(a2);
        answers.add(a3);
        answers.add(a4);
        Question q = new Question(question,answers,cA,qP);
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
       System.out.println("file read");
  }catch(IOException e){
      System.out.println("IO ERROR :(");
      System.out.println("An error occurred: " + e);
  }
    for (int i = 0; i < manyQuestions; i++) {
      qList.add(bigList.get(i));
    }
    System.out.println("question list loop worked");
    //set curent question variables = to the first question
    current = 0;
    currentQText = qList.get(current).getQuestion();
    currentAs = qList.get(current).getAnswers();
    currentCorrect = qList.get(current).getCorrect();
    currentValue = qList.get(current).getValue();
    System.out.println("setcurrents worked");
    //make game frame
    //currentValue -- current question Value
    //player.getScore() returns player's score
    System.out.println(player.getScore());
    addressUser = new JLabel("Hello " + "playerName " + "!");
    jlabQuestion = new JLabel(currentQText);
    jlabPoints = new JLabel("Points: " + currentValue);
    answerOne = new JButton(currentAs.get(0));
    answerTwo = new JButton(currentAs.get(1));
    answerThree = new JButton(currentAs.get(2));
    answerFour = new JButton(currentAs.get(3));
    currentScore = new JLabel("Current Score: " + player.getScore());
    nextQuestion = new JButton("Submit");
    System.out.println("objects created");
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
    answerOne.addActionListener(this);
    answerOne.setBackground(Color.white);


    c.fill = GridBagConstraints.BOTH;
    c.gridx = 1;
    c.gridy = 2;
    panel.add(answerTwo, c);
    answerTwo.addActionListener(this);
    answerTwo.setBackground(Color.white);
    

    c.fill = GridBagConstraints.BOTH;
    c.gridx = 0;
    c.gridy = 3;
    panel.add(answerThree, c);
    answerThree.addActionListener(this);
    answerThree.setBackground(Color.white);
    

    c.fill = GridBagConstraints.BOTH;
    c.gridx = 1;
    c.gridy = 3;
    panel.add(answerFour, c);
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

    frame.setVisible(true); 
    
  }

  public void nextScreen(){
    if(firstClick == 0){
        System.out.println("firstClick 'if' worked");
        playerName = userName.getText();
        maxNumber = (String)questionChoice.getSelectedItem();
      System.out.println(maxNumber);
        System.out.println(playerName);
        startGame();
        firstClick ++;
    }else{
      if (current == manyQuestions - 1){
        //Final Screen stuff
        logScore();
        gameFrame.setVisible(false);
        endGame();
        System.out.println("game over");
      }else{
        checkAnswer();
        current ++;
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
  public void actionPerformed(ActionEvent ae) { 
    if(ae.getActionCommand().equals("Submit")) { 
      frame.setVisible(false);
      nextScreen();
      //checkAnswer();
      if(current != manyQuestions - 1){
      gameFrame.setVisible(true);
      }
    }

    else if(ae.getActionCommand().equals(answerOne.getText()))
    {
      answerOne.setBackground(Color.blue);
      answerTwo.setBackground(Color.white);
      answerThree.setBackground(Color.white);
      answerFour.setBackground(Color.white);

      answerOne.setForeground(Color.white);
      answerTwo.setForeground(Color.black);
      answerThree.setForeground(Color.black);
      answerFour.setForeground(Color.black);

      selectedNumber = 1;
    }
    else if(ae.getActionCommand().equals(answerTwo.getText()))
    {
      answerOne.setBackground(Color.white);
      answerTwo.setBackground(Color.blue);
      answerThree.setBackground(Color.white);
      answerFour.setBackground(Color.white);

      answerOne.setForeground(Color.black);
      answerTwo.setForeground(Color.white);
      answerThree.setForeground(Color.black);
      answerFour.setForeground(Color.black);
      selectedNumber = 2;
    }
    else if(ae.getActionCommand().equals(answerThree.getText()))
    {
      answerOne.setBackground(Color.white);
      answerTwo.setBackground(Color.white);
      answerThree.setBackground(Color.blue);
      answerFour.setBackground(Color.white);

      answerOne.setForeground(Color.black);
      answerTwo.setForeground(Color.black);
      answerThree.setForeground(Color.white);
      answerFour.setForeground(Color.black);
      selectedNumber = 3;
      

    }
    else if(ae.getActionCommand().equals(answerFour.getText()))
    {
      answerOne.setBackground(Color.white);
      answerTwo.setBackground(Color.white);
      answerThree.setBackground(Color.white);
      answerFour.setBackground(Color.blue);

      answerOne.setForeground(Color.black);
      answerTwo.setForeground(Color.black);
      answerThree.setForeground(Color.black);
      answerFour.setForeground(Color.white);
      selectedNumber = 4;


    }
  }

  public void checkAnswer(){
    if(firstClick == 0){ //do nothing
    }
    else if(selectedNumber == currentCorrect){
		  player.setScore(player.getScore() + currentValue);
	    }

      answerOne.setBackground(Color.white);
      answerTwo.setBackground(Color.white);
      answerThree.setBackground(Color.white);
      answerFour.setBackground(Color.white);

      answerOne.setForeground(Color.black);
      answerTwo.setForeground(Color.black);
      answerThree.setForeground(Color.black);
      answerFour.setForeground(Color.black);
  }

  private void logScore(){
	try{
    System.out.println("log score start");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");  
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
    bw.write("Date/Time: " + dtf.format(now) + " -- ");
    bw.close();
    System.out.println("Done");


	}
	catch(IOException exception){
		System.out.println("An error occurred: " + exception);
	}
}

//run after the log score method
private void endGame(){
	ArrayList<String> leaderList = new ArrayList<String>();
  try{
	FileReader fR = new FileReader("score.txt");
    BufferedReader reader = new BufferedReader(fR);
    while(reader.ready()){
		leaderList.add(reader.readLine());
    
	}
  reader.close();
  }
  catch(IOException e){
    System.out.println("An error occurred: " + e);
    
  }
  String[] head = {"Leaderboard"};
  String[][] rows = new String [leaderList.size()][head.length];
  for(int r = 0; r < leaderList.size(); r++){
    rows[r][0] = leaderList.get(r);
  }
	JTable leadboard = new JTable(rows,head);
	JScrollPane sp = new JScrollPane(leadboard);
	leadboard.setFillsViewportHeight(true);

  endFrame.setSize(800, 400);
  endFrame.setLayout(new FlowLayout());
  endFrame.setVisible(true);
  finalLbl = new JLabel("Congradulations " + player.getName() + "! your final score was " + player.getScore() + "!");

  endFrame.add(finalLbl);
  endFrame.add(sp);

	}
}



