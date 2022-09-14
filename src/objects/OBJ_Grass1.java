package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_Grass1 extends SuperObject {
   
   public OBJ_Grass1() {
      
      name = "GrassQuestion1";
      dialogue = "What Kind of ‘base’ system is binary known as?\n (Press 1, 2, 3, or 4 to answer)\n\n(1) Base 10\n(2) Base 2\n(3) Base 16\n(4) Base 8";
      answer = KeyEvent.VK_2;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}
