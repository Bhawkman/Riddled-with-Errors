package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class for handling key inputs by the user.
 *
 * @author Group 3
 * @version 5/4/2022
 */
public class KeyHandler implements KeyListener {
   
   public boolean upPressed, leftPressed, rightPressed, downPressed;
   public int keyAnswer = -999;
   public boolean isAnswered;
   GamePanel gp;
   
   public KeyHandler(GamePanel gp) {
      this.gp = gp;
   }
   
   @Override
   public void keyTyped(KeyEvent e) { }
   
   @Override
   public void keyPressed(KeyEvent e) {
      int code = e.getKeyCode();
      
      //Title State
      if (gp.gameState == gp.titleState) {
         if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            gp.ui.commandNum--;
            if (gp.ui.commandNum < 0) {
               gp.ui.commandNum = 1;
            }
         }
         if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            gp.ui.commandNum++;
            if (gp.ui.commandNum > 1) {
               gp.ui.commandNum = 0;
            }
         }
         if (code == KeyEvent.VK_ENTER) {
            if (gp.ui.commandNum == 0) {
               gp.gameState = gp.playState;
               //gp.playMusic(0);
            }
            if (gp.ui.commandNum == 1) {
               System.exit(0);
            }
         }
      }
      
      //Play state
      if (gp.gameState == gp.playState) {
         if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            upPressed = true;
         }
         if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            downPressed = true;
         }
         if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            leftPressed = true;
         }
         if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
         }
         if (code == KeyEvent.VK_P) {
            gp.gameState = gp.pauseState;
         }
      }
      
      //Pause state
      else if (gp.gameState == gp.pauseState) {
         if (code == KeyEvent.VK_P) {
            gp.gameState = gp.playState;
         }
         
      }
      
      //Dialogue state
      else if (gp.gameState == gp.dialogueState) {
         if (code == KeyEvent.VK_F) {
            gp.gameState = gp.playState;
         }
      }
      
      //Question state
      else if (gp.gameState == gp.questionState) {
         if (code == KeyEvent.VK_1 || code == KeyEvent.VK_2 || code == KeyEvent.VK_3 || code == KeyEvent.VK_4
                 || code == KeyEvent.VK_5 || code == KeyEvent.VK_6 || code == KeyEvent.VK_7
                 || code == KeyEvent.VK_8 || code == KeyEvent.VK_9 || code == KeyEvent.VK_0) {
            
            if (code == gp.player.answer) {
               gp.ui.showCorrect();
   
            } else {
               gp.ui.showIncorrect();
               gp.player.life -= 2;
               gp.playSE(7);
            }
            gp.player.hasKey++;
            gp.gameState = gp.playState;
         }
      }
   }
   
   @Override
   public void keyReleased(KeyEvent e) {
      int code = e.getKeyCode();
      
      if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
         upPressed = false;
      }
      if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
         downPressed = false;
      }
      if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
         leftPressed = false;
      }
      if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
         rightPressed = false;
      }
   }
}
