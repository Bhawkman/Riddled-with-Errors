package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Player Class for implementing how the player character
 * interacts with the world.
 *
 * @author Group 3
 * @version 5/4/2022
 */
public class Player extends Entity {
   
   public final int screenX;
   public final int screenY;
   
   public int hasKey;
   public int worldCount;
   public int answer = -999;
   
   GamePanel gp;
   KeyHandler keyH;
   
   /**
    * Constructs a player Object.
    * @param gp GamePanel
    * @param keyH KeyHandler
    */
   public Player(GamePanel gp, KeyHandler keyH) {
      this.gp = gp;
      this.keyH = keyH;
      
      screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
      screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
      
      solidArea = new Rectangle();
      solidArea.x = 8;
      solidArea.y = 7;
      solidAreaDefaultX = solidArea.x;
      solidAreaDefaultY = solidArea.y;
      solidArea.width = 32;
      solidArea.height = 32;
      
      setDefaultValues();
      getPlayerImage();
   }
   
   /**
    * Default Spawn state, speed, location, life, and number of keys.
    */
   public void setDefaultValues() {
      worldX = gp.tileSize * 10;
      worldY = gp.tileSize * 112;
      
      speed = 9;
      direction = "down";
      worldCount = 0;
      hasKey = 0;
      maxLife = 6;
      life = maxLife;
   }
   
   /**
    * Gets the player image for their current velocity.
    */
   public void getPlayerImage() {
      
      try {
         up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
         up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
         down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
         down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
         left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
         left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
         right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
         right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
         
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   /**
    * Updates the player position / information (60 times a second).
    */
   public void update() {
      
      if (keyH.downPressed || keyH.leftPressed ||
              keyH.upPressed || keyH.rightPressed) {
         
         if (keyH.upPressed) {
            direction = "up";
         }
         if (keyH.downPressed) {
            direction = "down";
         }
         if (keyH.leftPressed) {
            direction = "left";
         }
         if (keyH.rightPressed) {
            direction = "right";
         }
         
         //Check Tile Collision
         collisionOn = false;
         gp.cChecker.checkTile(this);
         
         //Check Object Collision
         int objIndex = gp.cChecker.checkObject(this, true);
         objectEvent(objIndex);
         
         //If Collision is false the player can move
         if (!collisionOn) {
            switch (direction) {
               case "up" -> worldY -= speed;
               case "down" -> worldY += speed;
               case "left" -> worldX -= speed;
               case "right" -> worldX += speed;
            }
         }
         
         spriteCounter++;
         if (spriteCounter > 12) {
            if (spriteNum == 1) {
               spriteNum = 2;
            } else if (spriteNum == 2) {
               spriteNum = 1;
            }
            spriteCounter = 0;
         }
      }
   }
   
   /**
    * Determines what happens when the player interacts with an Object.
    * @param i hte index of the Object in the obj Array
    */
   public void objectEvent(int i) {
      
      if (i != 999) {
         
         String objectName = gp.obj[i].name;
         
         //Normal objects
         switch (objectName) {
            case "Tutorial1", "Tutorial2", "Tutorial3", "VolcanicSecret1",
                    "VolcanicSecret2", "Congrats":
               gp.gameState = gp.dialogueState;
               gp.ui.getCurrentDialogue(i);
               gp.obj[i] = null;
               break;
            case "Key":
               hasKey++;
               gp.obj[i] = null;
               gp.playSE(6);
               gp.ui.showMessage("You Got A Key!");
               break;
            case "KeySilent":
               hasKey++;
               gp.obj[i] = null;
               gp.playSE(6);
               break;
            case "InfoNode":
               gp.gameState = gp.dialogueState;
               gp.ui.getCurrentDialogue(i);
               break;
            case "Door":
               if (hasKey >= 1) {
                  hasKey -= 1;
                  gp.obj[i] = null;
                  gp.ui.showMessage("You Unlocked A New Area!");
                  gp.playSE(5);
               } else {
                  gp.ui.showMessage("Sorry, You Need A Key!");
               }
               break;
            case "Door2":
               if (hasKey >= 2) {
                  hasKey -= 2;
                  gp.obj[i] = null;
                  gp.ui.showMessage("You Unlocked A New Area!");
                  gp.playSE(5);
               } else {
                  gp.ui.showMessage("Sorry, You Need 2 Keys!");
               }
               break;
            case "Door3":
               if (hasKey >= 3) {
                  hasKey -= 3;
                  gp.obj[i] = null;
                  gp.ui.showMessage("You Unlocked A New Area!");
                  gp.playSE(5);
               } else {
                  gp.ui.showMessage("Sorry, You Need 3 Keys!");
               }
               break;
            case "Door4":
               if (hasKey >= 4) {
                  hasKey -= 4;
                  gp.obj[i] = null;
                  gp.ui.showMessage("You Unlocked A New Area!");
                  gp.playSE(5);
               } else {
                  gp.ui.showMessage("Sorry, You Need 4 Keys!");
               }
               break;
            case "Node":
               gp.gameState = gp.dialogueState;
               gp.ui.getCurrentDialogue(i);
               hasKey++;
               gp.obj[i] = null;
               gp.ui.showMessage("You Got A Key!");
               break;
            case "Pit":
               gp.ui.showMessage("You found a Secret!");
               gp.player.life--;
               break;
            case "World", "World2", "World3", "World4", "World5":
               gp.player.worldCount++;
               gp.obj[i] = null;
               break;
            case "Stop":
               gp.sound.stop();
               gp.stopMusic();
               gp.obj[i] = null;
               break;
         }
         
         //Questions
         switch (objectName) {
            case "TutorialNode", "TutorialNode2", "GrassQuestion1", "GrassQuestion2", "GrassQuestion3",
                    "Desert1", "Desert2", "Desert3", "Hills1", "Hills2", "Hills3", "ArcticQuestion1",
                    "ArcticQuestion2", "ArcticQuestion3", "Volcanic1", "Volcanic2", "Volcanic3" -> {
               gp.gameState = gp.questionState;
               gp.ui.getCurrentDialogue(i);
               answer = gp.ui.getAnswer(i);
               gp.obj[i] = null;
            }
            case "Helper" -> {
               gp.ui.showArray();
               gp.obj[i] = null;
            }
            case "Helper2" -> {
               gp.ui.arrayMessage = false;
               gp.ui.messageOn = false;
               gp.ui.showMessage("Great Job!");
               gp.obj[i] = null;
            }
         }
      }
   }
   
   /**
    * Draws the Player Object (60 times a second).
    * @param g2 Graphics2D Object
    */
   public void draw(Graphics2D g2) {
      
      BufferedImage image = null;
   
      switch (direction) {
         case "up" -> {
            if (spriteNum == 1) {
               image = up1;
            }
            if (spriteNum == 2) {
               image = up2;
            }
         }
         case "down" -> {
            if (spriteNum == 1) {
               image = down1;
            }
            if (spriteNum == 2) {
               image = down2;
            }
         }
         case "left" -> {
            if (spriteNum == 1) {
               image = left1;
            }
            if (spriteNum == 2) {
               image = left2;
            }
         }
         case "right" -> {
            if (spriteNum == 1) {
               image = right1;
            }
            if (spriteNum == 2) {
               image = right2;
            }
         }
      }
      
      g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
   }
}
