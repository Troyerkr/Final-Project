
/**
* this class keeps track of the user playing the game along with atributes like their name and their score
* @author Kyle Troyer, Sam Green, Grady Lipp
* @version 4/20/21
*/
public class Player {
  //player's name
  private String name;
  //player's score
  private int score;

/**
*this constructor method for the Player class asks for a players name then sets the player object's name value to that value and sets it's score to zero
* @param pName - player's name
*/
  Player(String pName){
    name = pName;
    score = 0;
  }
/**
* this mutator method for the score variable askes for the player's new score then set's the player object'score to the value passed through
* @param newScore - player's new score
*/
  void setScore(int newScore){
    score = newScore;
  }
/**
* this accessor method returns the player's name
* @returen returns the player's name
*/
  public String getName(){
    return name;
  }
/**
* this accessor method returns the player's score
* @returen returns the player's score
*/
  public int getScore(){
    return score;
  }

}