package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_Volcanic1 extends SuperObject {
   
   public OBJ_Volcanic1() {
      
      name = "Volcanic1";
      dialogue = "If a is equal to 4 and b is equal to 9 is the following\nif-statement true or false?\n" +
              "        if (a > b)\n\n" +
              "(1) True\n" +
              "(2) False\n";
      answer = KeyEvent.VK_2;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}
