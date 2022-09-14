package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_ARCTIC3 extends SuperObject {
   
   public OBJ_ARCTIC3() {
      
      name = "ArcticQuestion3";
      dialogue = "How many times will the following loop be executed?\n       for (int i = 0; i <= 5; i++)\n\n(1) 4\n(2) 5\n(3) 6\n(4) 10";
      answer = KeyEvent.VK_3;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}