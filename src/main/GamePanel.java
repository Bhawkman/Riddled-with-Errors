package main;

import entity.Player;
import objects.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

/**
 * GamePanel Class, sets and Instantiates the run conditions for the game.
 *
 * @author Group 3
 * @version 5/4/2022
 */
public class GamePanel extends JPanel implements Runnable {
   
   //World Settings
   public final int maxWorldRow = 120;
   public final int maxWorldCol = 171;
   public final int titleState = 0;
   public final int playState = 1;
   public final int pauseState = 2;
   public final int dialogueState = 3;
   public final int questionState = 4;
   
   //Screen Settings
   public final int maxScreenCol = 17;
   public final int maxScreenRow = 12;
   final int originalTileSize = 16;
   final int scale = 4;
   public final int tileSize = originalTileSize * scale;
   public final int screenWidth = tileSize * maxScreenCol;
   public final int screenHeight = tileSize * maxScreenRow;
   public KeyHandler keyH = new KeyHandler(this);
   public Sound sound = new Sound();
   public CollisionChecker cChecker = new CollisionChecker(this);
   public AssetSetter aSetter = new AssetSetter(this);
   public UI ui = new UI(this);
   
   //entity and Object
   public Player player = new Player(this, keyH);
   public SuperObject[] obj = new SuperObject[100];
   
   //Game State
   public int gameState;
   
   // Debug
   public int deaths = -1;
   
   //Frames Per Second
   int FPS = 60;
   
   //System
   TileManager tileM = new TileManager(this);
   Thread gameThread;
   
   /**
    * Constructs a GamePanel objects and instantiates all run conditions.
    */
   public GamePanel() {
      this.setPreferredSize(new Dimension(screenWidth, screenHeight));
      this.setBackground(Color.black);
      this.setDoubleBuffered(true);
      this.addKeyListener(keyH);
      this.setFocusable(true);
   }
   
   /**
    * Sets the defaults for running the game.
    */
   public void setUpGame() {
      aSetter.index = 0;
      aSetter.setObject();
      gameState = titleState;
      
      deaths++;
   }
   
   /**
    * Starts the game Thread (Tells the computer how to run the game).
    */
   public void startGameThread() {
      gameThread = new Thread(this);
      gameThread.start();
   }
   
   @Override
   public void run() {
      
      double drawInterval = 1000000000 / FPS;
      double nextDrawTime = System.nanoTime() + drawInterval;
      
      while (gameThread != null) {
         
         update();
         repaint();
         
         try {
            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime / 1000000;
            if (remainingTime < 0) {
               remainingTime = 0;
            }
            Thread.sleep((long) remainingTime);
            
            nextDrawTime += drawInterval;
            
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
   
   /**
    * Updates the GameState 60 times a second.
    */
   public void update() {
      
      if (player.life < 1) {
         player.setDefaultValues();
         setUpGame();
         gameState = playState;
      }
      
      if (gameState == playState) {
         player.update();
      }
   }
   
   /**
    * repaints the screen 60 times a second.
    * @param g Graphics object
    */
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      
      // TITLE SCREEN
      if (gameState == titleState) {
         ui.draw(g2);
         
      } else {
         
         //Tile
         tileM.draw(g2);
         
         //Object
         for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
               obj[i].draw(g2, this);
            }
         }
         
         //Player
         player.draw(g2);
         
         //UI
         ui.draw(g2);
         g2.dispose();
      }
   }
   
   /**
    * Plays music on a continuous loop.
    * @param i the index of the sound file to use
    */
   public void playMusic(int i) {
      sound.setFile(i);
      sound.play();
   }
   
   /**
    * Stops the music
    */
   public void stopMusic() {
      sound.stop();
   }
   
   /**
    * plays a sound effect (no loop).
    * @param i the index of the sound file to use
    */
   public void playSE(int i) {
      sound.setFile(i);
      sound.play();
   }
}
