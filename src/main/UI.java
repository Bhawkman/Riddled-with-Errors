package main;

import objects.OBJ_Heart;
import objects.OBJ_Key;
import objects.SuperObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

/**
 * Class for implementing all UI elements.
 *
 * @author Group 3
 * @version 5/4/2022
 */
public class UI {
   
   public boolean messageOn = false;
   public String message = "";
   public String message2 = "";
   public boolean correctMessage = false;
   public boolean incorrectMessage = false;
   public boolean arrayMessage = false;
   public int messageCounter;
   public String currentDialogue = "";
   
   public int commandNum = 0;
   GamePanel gp;
   Graphics2D g2;
   
   Font worldFont;
   Font keyFont;
   Font pauseFont;
   BufferedImage keyImage;
   BufferedImage heart_full, heart_half, heart_blank;
   
   double gameTime;
   
   DecimalFormat df = new DecimalFormat("#0.00");
   
   /**
    * Constructs a UI object.
    * @param gp GamePanel
    */
   public UI(GamePanel gp) {
      this.gp = gp;
      
      worldFont = new Font("Arial", Font.BOLD, 30);
      pauseFont = new Font("Arial", Font.ITALIC, 50);
      keyFont = new Font("Arial", Font.PLAIN, 35);
      
      OBJ_Key key = new OBJ_Key();
      keyImage = key.image;
      
      //Create heart object
      SuperObject heart = new OBJ_Heart(gp);
      heart_full = heart.image;
      heart_half = heart.image2;
      heart_blank = heart.image3;
   }
   
   /**
    * Shows a typed message on screen.
    * @param text the message
    */
   public void showMessage(String text) {
      message = text;
      messageOn = true;
   }
   
   /**
    * Shows a CORRECT! message on screen.
    */
   public void showCorrect() {
      message = "CORRECT!";
      correctMessage = true;
   }
   
   /**
    * Shows an INCORRECT! message on screen.
    */
   public void showIncorrect() {
      message = "INCORRECT!";
      incorrectMessage = true;
   }
   
   /**
    * Shows the array panel used in the Mountain level
    */
   public void showArray() {
      message = "Directions = [down], [right], [up], [left], [up], [right],";
      message2 = "[Straight], [down], [right], [up], [right], [down], [right]";
      arrayMessage = true;
   }
   
   /**
    * Draws the UI elements on screen (60 times a second).
    * @param g2 Graphics2D Object
    */
   public void draw(Graphics2D g2) {
      this.g2 = g2;
      
      // Title State
      if (gp.gameState == gp.titleState) {
         drawTitleScreen();
         
      } else {
         //World
         g2.setFont(worldFont);
         g2.setColor(Color.white);
         g2.drawString("World " + gp.player.worldCount, 15, 32);
         
         //Key
         g2.setFont(keyFont);
         g2.setColor(Color.yellow);
         g2.drawImage(keyImage, (gp.tileSize / 2) - 30, (gp.tileSize / 2) + 10, gp.tileSize, gp.tileSize, null);
         g2.drawString("= " + gp.player.hasKey, 65, 85);
         
         //Time
         if (gp.gameState != gp.pauseState) {
            gameTime += (double) 1 / 60;
         }
         g2.setFont(worldFont.deriveFont(22F));
         g2.setColor(Color.white);
         g2.drawString("Time: " + df.format(gameTime), gp.tileSize * 15, 45);
         
         //Deaths
         g2.setFont(worldFont.deriveFont(22F));
         g2.setColor(Color.white);
         g2.drawString("Deaths: " + gp.deaths, gp.tileSize * 15, 70);
         
         //Message
         if (messageOn) {
            g2.setFont(keyFont.deriveFont(35F));
            g2.setColor(Color.white);
            g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);
            
            messageCounter++;
            if (messageCounter > 120) {
               messageCounter = 0;
               messageOn = false;
            }
         }
         
         if (correctMessage) {
            g2.setFont(worldFont.deriveFont(50F));
            g2.setColor(Color.GREEN);
            g2.drawString(message, gp.tileSize * 7 - 30, gp.tileSize * 2 + 10);
            
            messageCounter++;
            if (messageCounter > 120) {
               messageCounter = 0;
               correctMessage = false;
            }
         }
         
         if (incorrectMessage) {
            g2.setFont(worldFont.deriveFont(50F));
            g2.setColor(Color.RED);
            g2.drawString(message, gp.tileSize * 7 - 50, gp.tileSize * 2 + 10);
            
            messageCounter++;
            if (messageCounter > 120) {
               messageCounter = 0;
               incorrectMessage = false;
            }
         }
         
         if (arrayMessage) {
            int x = gp.tileSize * 2 - 25;
            int y = gp.tileSize;
            int width = gp.screenWidth - (gp.tileSize * 3);
            int height = gp.tileSize * 3;
            g2.setColor(Color.black);
            g2.fillRoundRect(x, y, width, height, 35, 30);
            
            g2.setFont(worldFont.deriveFont(30F));
            g2.setColor(Color.white);
            g2.drawString(message, gp.tileSize * 3 - 50, gp.tileSize * 2 + 10);
            g2.drawString(message2, gp.tileSize * 3 - 50, gp.tileSize * 3 + 10);
            
            Color c = new Color(250, 250, 250, 255);
            g2.setColor(c);
            g2.setStroke(new BasicStroke(5));
            g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 30, 25);
         }
      }
      
      //Play state
      if (gp.gameState == gp.playState) {
         drawPlayerLife();
      }
      
      //Pause state
      if (gp.gameState == gp.pauseState) {
         drawPlayerLife();
         drawPauseScreen();
      }
      
      //Dialogue state
      if (gp.gameState == gp.dialogueState) {
         drawPlayerLife();
         drawDialogueScreen();
      }
      
      //Question state
      if (gp.gameState == gp.questionState) {
         drawPlayerLife();
         drawQuestionScreen();
      }
   }
   
   /**
    * Draws the Title screen.
    */
   public void drawTitleScreen() {
      g2.setColor(Color.darkGray);
      g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
      //Title Name
      g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
      String text = "Riddled With Errors";
      int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
      int x = gp.screenWidth / 2 - length / 2;
      int y = gp.tileSize * 3;
      
      //shadow
      g2.setColor(Color.GRAY);
      g2.drawString(text, x + 5, y + 5);
      
      g2.setColor(Color.WHITE);
      g2.drawString(text, x, y);
      
      // Image
      x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
      y += gp.tileSize * 2;
      g2.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);
      
      //Menu
      text = "NEW GAME";
      g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
      
      length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
      x = gp.screenWidth / 2 - length / 2;
      y += gp.tileSize * 3.5;
      g2.drawString(text, x, y);
      if (commandNum == 0) {
         g2.drawString(">", x - gp.tileSize, y);
      }
      
      text = "QUIT";
      length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
      x = gp.screenWidth / 2 - length / 2;
      y += gp.tileSize;
      g2.drawString(text, x, y);
      if (commandNum == 1) {
         g2.drawString(">", x - gp.tileSize, y);
      }
   }
   
   /**
    * Draws the Player life hearts.
    */
   public void drawPlayerLife() {
      int x = gp.tileSize * 7;
      int y = gp.tileSize / 4;
      int i = 0;
      
      //Draw blank hearts
      while (i < gp.player.maxLife / 2) {
         g2.drawImage(heart_blank, x, y, gp.tileSize, gp.tileSize, null);
         i++;
         x += gp.tileSize;
      }
      
      //Reset
      x = gp.tileSize * 7;
      y = gp.tileSize / 4;
      i = 0;
      
      //Draw current life
      while (i < gp.player.life) {
         g2.drawImage(heart_half, x, y, gp.tileSize, gp.tileSize, null);
         i++;
         if (i < gp.player.life) {
            g2.drawImage(heart_full, x, y, gp.tileSize, gp.tileSize, null);
         }
         i++;
         x += gp.tileSize;
      }
      
   }
   
   /**
    * Draws the dialogue window.
    */
   public void drawDialogueScreen() {
      int x = gp.tileSize * 2;
      int y = gp.tileSize * 7;
      int width = gp.screenWidth - (gp.tileSize * 4);
      int height = gp.tileSize * 5;
      
      drawSubWindow(x, y, width, height);
      
      g2.setFont(g2.getFont().deriveFont(Font.PLAIN).deriveFont(30F));
      x += gp.tileSize;
      y += gp.tileSize;
      
      for (String line : currentDialogue.split("\n")) {
         g2.drawString(line, x, y);
         y += 40;
      }
   }
   
   /**
    * Dialogue helper.
    * @param x x coordinate
    * @param y y coordinate
    * @param width width of the window
    * @param height height of the window
    */
   public void drawSubWindow(int x, int y, int width, int height) {
      Color c = new Color(0, 0, 0, 180);
      g2.setColor(c);
      g2.fillRoundRect(x, y, width, height, 35, 30);
      
      c = new Color(250, 250, 250, 255);
      g2.setColor(c);
      g2.setStroke(new BasicStroke(5));
      g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
   }
   
   /**
    * Gets the current Objects dialogue to be displayed.
    * @param i the index of the Object in the obj Array.
    */
   public void getCurrentDialogue(int i) {
      if (gp.obj[i].dialogue != null) {
         currentDialogue = gp.obj[i].dialogue;
      }
   }
   
   /**
    * Gets the current Objects answer to be parsed.
    * @param i the index of the Object in the obj Array.
    * @return the answer as a KeyEvent
    */
   public int getAnswer(int i) {
      return gp.obj[i].answer;
   }
   
   /**
    * Draws the Pause screen.
    */
   public void drawPauseScreen() {
      Color c = new Color(255, 255, 255, 150);
      g2.setColor(c);
      g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
      
      g2.setFont(pauseFont);
      c = new Color(0, 0, 0);
      g2.setColor(c);
      
      String text;
      int textLength;
      int x;
      int y;
      
      text = "PAUSE";
      textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
      x = gp.screenWidth / 2 - textLength / 2;
      y = gp.screenHeight / 2;
      
      g2.drawString(text, x, y);
   }
   
   /**
    * Draws the Question dialogue window.
    */
   public void drawQuestionScreen() {
      int x = gp.tileSize * 2 - 25;
      int y = gp.tileSize * 2;
      int width = gp.screenWidth - (gp.tileSize * 3);
      int height = gp.tileSize * 8;
      
      drawQuestionSubWindow(x, y, width, height);
      
      g2.setFont(g2.getFont().deriveFont(Font.PLAIN).deriveFont(30F));
      x += gp.tileSize;
      y += gp.tileSize;
      
      for (String line : currentDialogue.split("\n")) {
         g2.drawString(line, x, y);
         y += 40;
      }
   }
   
   /**
    * Question dialogue helper.
    * @param x x coordinate
    * @param y y coordinate
    * @param width width of the window
    * @param height height of the window
    */
   public void drawQuestionSubWindow(int x, int y, int width, int height) {
      Color c = new Color(0, 0, 0, 180);
      g2.setColor(c);
      g2.fillRoundRect(x, y, width, height, 35, 30);
      
      c = new Color(250, 250, 250, 255);
      g2.setColor(c);
      g2.setStroke(new BasicStroke(5));
      g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 30, 25);
   }
   
}
