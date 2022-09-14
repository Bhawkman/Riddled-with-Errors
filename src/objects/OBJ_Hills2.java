package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_Hills2 extends SuperObject {
   
   public OBJ_Hills2() {
      
      name = "Hills2";
      dialogue = "What is the Point value for this 2D Array:\n      sampleArray[5][10]\n\n(1) (5, 5)\n(2) (5, 10)\n(3) (10, 5)\n(4) (10 ,10)";
      answer = KeyEvent.VK_2;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}