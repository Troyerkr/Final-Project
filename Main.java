import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
class Main {
 public static void main(String args[]) {
   SwingUtilities.invokeLater(new Runnable() {
     public void run() {
       Game g = new Game(1,2);
     }
   });
 }
} 