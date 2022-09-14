package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_Hills1 extends SuperObject {
   
   public OBJ_Hills1() {
      
      name = "Hills1";
      dialogue = "At what index does an array start?\n\n(1) 0\n(2) 1\n(3) null\n(4) Arrays don’t have a start index";
      answer = KeyEvent.VK_1;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}