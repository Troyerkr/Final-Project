public class Player {
  private String name;
  private int score;

  Player(String pName){
    name = pName;
    score = 0;
  }

  void setScore(int newScore){
    score = newScore;
  }

  public String getName(){
    return name;
  }

  public int getScore(){
    return score;
  }

}