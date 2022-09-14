package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_ARCTIC1 extends SuperObject {
   
   public OBJ_ARCTIC1() {
      
      name = "ArcticQuestion1";
      dialogue = "If you wanted to separately print each letter of a given word,\n what kind of loop would you use?\n\n(1) While Loop\n(2) For Loop\n(3) When Loop\n(4) Open Loop";
      answer = KeyEvent.VK_2;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}
