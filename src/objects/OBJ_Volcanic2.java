package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_Volcanic2 extends SuperObject {
   
   public OBJ_Volcanic2() {
      
      name = "Volcanic2";
      dialogue = "Which operator would be used in order to test if two values\nwere equivalent?\n" +
              "(1) <\n" +
              "(2) >\n" +
              "(3) ==\n" +
              "(4) >=\n";
      answer = KeyEvent.VK_3;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}
