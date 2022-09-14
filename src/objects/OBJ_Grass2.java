package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_Grass2 extends SuperObject {
   
   public OBJ_Grass2() {
      
      name = "GrassQuestion2";
      dialogue = "What is an overflow error?\n (Press 1, 2, 3, or 4 to answer)\n\n(1) When a call to an Array exceeded the Arrays length" +
              "\n(2) When the compiler fails to read the binary information\n(3) When a stack gets too full\n(4) When the addition of two binary numbers leaves an extra\n digit that can’t be processed";
      answer = KeyEvent.VK_4;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}
