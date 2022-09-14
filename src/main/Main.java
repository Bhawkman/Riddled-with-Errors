package main;

import javax.swing.*;
import java.awt.*;

/**
 * Runs the game.
 *
 * @author Group 3
 * @version 5/4/2022
 */
public class Main {
   
   /**
    * command-line arguments.
    * @param args args
    */
   public static void main(String[] args) {
      JFrame window = new JFrame();
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setResizable(false);
      window.setTitle("Riddled With Errors");
      window.setBackground(Color.gray);
      
      GamePanel gamePanel = new GamePanel();
      window.add(gamePanel);
      
      window.pack();
      
      window.setLocationRelativeTo(null);
      window.setVisible(true);
      
      gamePanel.setUpGame();
      gamePanel.startGameThread();
      
      for (int i = 5; i < 8; i++) {
         gamePanel.sound.setFile(i);
      }
   }
}
