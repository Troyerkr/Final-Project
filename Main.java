import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
* main class that creates a game objet
* @author Kyle Troyer, Sam Green, Grady Lipp
* @version 4/20/21
*/
class Main {
  /**
  * main method
  */
 public static void main(String args[]) {
   SwingUtilities.invokeLater(new Runnable() {
    /**
    * run method
    */
     public void run() {
       Game g = new Game();
       
     }
   });
 }
} 