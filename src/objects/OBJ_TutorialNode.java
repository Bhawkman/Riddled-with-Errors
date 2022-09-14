package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_TutorialNode extends SuperObject {
   
   public OBJ_TutorialNode() {
      
      name = "TutorialNode";
      dialogue = "What color is an apple?\n(Press 1, 2, 3, or 4 to answer)\n\n(1) Blue\n(2) Orange\n(3) Red\n(4) Aquamarine";
      answer = KeyEvent.VK_3;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}