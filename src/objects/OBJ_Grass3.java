package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_Grass3 extends SuperObject {
   
   public OBJ_Grass3() {
      
      name = "GrassQuestion3";
      dialogue = "What was the number hidden in the flowers?\n (Press 1, 2, 3, or 4 to answer)\n\n(1) Three" +
              "\n(2) Seven\n(3) Ten\n(4) Eight";
      answer = KeyEvent.VK_3;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}
