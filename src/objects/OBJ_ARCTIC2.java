package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_ARCTIC2 extends SuperObject {
   
   public OBJ_ARCTIC2() {
      
      name = "ArcticQuestion2";
      dialogue = "If you wanted to run a piece of code over and over forever,\nwhat kind of loop could you use?\n\n" +
              "(1) While Loop\n(2) For Loop\n(3) Both types of loops would work";
      answer = KeyEvent.VK_3;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}
