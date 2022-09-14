package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_Desert1 extends SuperObject {
   
   
   public OBJ_Desert1() {
      
      name = "Desert1";
      dialogue = "What needs to be determined first in a recursive algorithm?\n\n(1) End case\n(2) Levels of " +
              "Recursion\n(3) Base Case\n(4) Current Recursion depth";
      answer = KeyEvent.VK_3;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}
