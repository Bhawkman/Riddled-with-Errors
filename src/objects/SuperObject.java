package objects;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Generic Object class.
 *
 * @author Group 3
 * @version 5/4/2022
 */
public class SuperObject {
   
   public BufferedImage image, image2, image3;
   
   public String name, dialogue;
   public int answer;
   
   public boolean collision = false;
   
   public int worldX, worldY;
   public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
   public int solidAreaDefaultX = 0;
   public int solidAreaDefaultY = 0;
   
   /**
    * Draws the object in the JPanel.
    * @param g2 Graphics2D Object
    * @param gamePanel GamePanel
    */
   public void draw(Graphics2D g2, GamePanel gamePanel) {
      
      int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
      int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;
      
      if (((worldX + gamePanel.tileSize) > (gamePanel.player.worldX - gamePanel.player.screenX)) &&
              ((worldX - gamePanel.tileSize) < (gamePanel.player.worldX + gamePanel.player.screenX)) &&
              ((worldY + gamePanel.tileSize) > (gamePanel.player.worldY - gamePanel.player.screenY)) &&
              ((worldY - gamePanel.tileSize) < (gamePanel.player.worldY + gamePanel.player.screenY))) {
         
         g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
         
      }
   }
}
