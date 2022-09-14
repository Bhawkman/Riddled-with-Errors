package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_Volcanic3 extends SuperObject {
   
   public OBJ_Volcanic3() {
      
      name = "Volcanic3";
      dialogue = "Assuming that a is 3, b is 10, and c is 5 which expression is\ncorrect?\n" +
              "(1) a + c > b\n" +
              "(2) a + b < c\n" +
              "(3) a * c > b\n" +
              "(4) a == b - c\n";
      answer = KeyEvent.VK_3;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}
