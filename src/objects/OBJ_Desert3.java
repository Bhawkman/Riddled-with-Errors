package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_Desert3 extends SuperObject {
   
   
   public OBJ_Desert3() {
      
      name = "Desert3";
      dialogue = "Which statement is correct?\n\n(1) Recursion makes use of more memory than iteration\n" +
              "(2) It is always better to use recursion instead of iteration\n" +
              "(3) It is always better to use iteration instead of recursion\n" +
              "(4) Iteration makes use of more memory than recursion";
      answer = KeyEvent.VK_1;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}
