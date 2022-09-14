package main;

import entity.Entity;

/**
 * Class for checking / implementing collision on tiles and objects.
 *
 * @author Group 3
 * @version 5/4/2022
 */
public class CollisionChecker {
   
   GamePanel gamePanel;
   
   /**
    * Constructs a CollisionChecker object.
    * @param gamePanel GamePanel
    */
   public CollisionChecker(GamePanel gamePanel) {
      this.gamePanel = gamePanel;
   }
   
   /**
    * Checks the tile for collision and prevents the player from walking through it.
    * @param entity the player
    */
   public void checkTile(Entity entity) {
      
      int entityLeftWorldX = entity.worldX + entity.solidArea.x;
      int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
      int entityTopWorldY = entity.worldY + entity.solidArea.y;
      int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
      
      int entityLeftCol = entityLeftWorldX / gamePanel.tileSize;
      int entityRightCol = entityRightWorldX / gamePanel.tileSize;
      int entityTopRow = entityTopWorldY / gamePanel.tileSize;
      int entityBottomRow = entityBottomWorldY / gamePanel.tileSize;
      
      int tileNum1, tileNum2;
      
      switch (entity.direction) {
         case "up" -> {
            entityTopRow = (entityTopWorldY - entity.speed) / gamePanel.tileSize;
            tileNum1 = gamePanel.tileM.mapTileNumber[entityLeftCol][entityTopRow];
            tileNum2 = gamePanel.tileM.mapTileNumber[entityRightCol][entityTopRow];
            if (gamePanel.tileM.tiles[tileNum1].collision || gamePanel.tileM.tiles[tileNum2].collision) {
               entity.collisionOn = true;
            }
         }
         case "down" -> {
            entityBottomRow = (entityBottomWorldY + entity.speed) / gamePanel.tileSize;
            tileNum1 = gamePanel.tileM.mapTileNumber[entityLeftCol][entityBottomRow];
            tileNum2 = gamePanel.tileM.mapTileNumber[entityRightCol][entityBottomRow];
            if (gamePanel.tileM.tiles[tileNum1].collision || gamePanel.tileM.tiles[tileNum2].collision) {
               entity.collisionOn = true;
            }
         }
         case "left" -> {
            entityLeftCol = (entityLeftWorldX - entity.speed) / gamePanel.tileSize;
            tileNum1 = gamePanel.tileM.mapTileNumber[entityLeftCol][entityTopRow];
            tileNum2 = gamePanel.tileM.mapTileNumber[entityLeftCol][entityBottomRow];
            if (gamePanel.tileM.tiles[tileNum1].collision || gamePanel.tileM.tiles[tileNum2].collision) {
               entity.collisionOn = true;
            }
         }
         case "right" -> {
            entityRightCol = (entityRightWorldX + entity.speed) / gamePanel.tileSize;
            tileNum1 = gamePanel.tileM.mapTileNumber[entityRightCol][entityTopRow];
            tileNum2 = gamePanel.tileM.mapTileNumber[entityRightCol][entityBottomRow];
            if (gamePanel.tileM.tiles[tileNum1].collision || gamePanel.tileM.tiles[tileNum2].collision) {
               entity.collisionOn = true;
            }
         }
      }
   }
   
   /**
    * Checks the object for collision and prevents the player from walking through it.
    * @param entity the object
    * @param player the player
    */
   public int checkObject(Entity entity, boolean player) {
      int index = 999;
      
      for (int i = 0; i < gamePanel.obj.length; i++) {
         if (gamePanel.obj[i] != null) {
            
            // get Entity's solidArea position
            entity.solidArea.x = entity.worldX + entity.solidArea.x;
            entity.solidArea.y = entity.worldY + entity.solidArea.y;
            
            // get the Object's solidArea position
            gamePanel.obj[i].solidArea.x = gamePanel.obj[i].worldX + gamePanel.obj[i].solidArea.x;
            gamePanel.obj[i].solidArea.y = gamePanel.obj[i].worldY + gamePanel.obj[i].solidArea.y;
   
            switch (entity.direction) {
               case "up" -> {
                  entity.solidArea.y -= entity.speed;
                  if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
                     if (gamePanel.obj[i].collision) {
                        entity.collisionOn = true;
                     }
                     if (player) {
                        index = i;
                     }
                  }
               }
               case "down" -> {
                  entity.solidArea.y += entity.speed;
                  if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
                     if (gamePanel.obj[i].collision) {
                        entity.collisionOn = true;
                     }
                     if (player) {
                        index = i;
                     }
                  }
               }
               case "left" -> {
                  entity.solidArea.x -= entity.speed;
                  if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
                     if (gamePanel.obj[i].collision) {
                        entity.collisionOn = true;
                     }
                     if (player) {
                        index = i;
                     }
                  }
               }
               case "right" -> {
                  entity.solidArea.x += entity.speed;
                  if (entity.solidArea.intersects(gamePanel.obj[i].solidArea)) {
                     if (gamePanel.obj[i].collision) {
                        entity.collisionOn = true;
                     }
                     if (player) {
                        index = i;
                     }
                  }
               }
            }
            
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            gamePanel.obj[i].solidArea.x = gamePanel.obj[i].solidAreaDefaultX;
            gamePanel.obj[i].solidArea.y = gamePanel.obj[i].solidAreaDefaultY;
         }
      }
      
      return index;
   }
   
}
