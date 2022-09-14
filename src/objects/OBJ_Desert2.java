package objects;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class OBJ_Desert2 extends SuperObject {
   
   
   public OBJ_Desert2() {
      
      name = "Desert2";
      dialogue = "Assuming n never becomes 0.\nHow would you compute the Factorial of N?\n\n(1) n * factorial(n-1)\n" +
              "(2) factorial(n-1)\n(3) n * factorial(n+1)\n(4) factorial(n+1)";
      answer = KeyEvent.VK_1;
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}
