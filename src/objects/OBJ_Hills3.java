package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_Hills3 extends SuperObject {
   
   public OBJ_Hills3() {
      
      name = "Hills3";
      dialogue = "How would you declare and initialize an Array\nof type Rectangle called rectArray with length 7?\n\n(1) Array Rectangle = new rectArray[7];\n(2) Rectangle[] = new rectArray[7];\n(3) rectArray[7] = new Rectangle;\n(4) Rectangle[] rectArray = new Rectangle[7];";
      answer = KeyEvent.VK_4;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}