package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Tutorial3 extends SuperObject {
   
   public OBJ_Tutorial3() {
      
      name = "Tutorial3";
      dialogue = "You can PAUSE the game at any\ntime\n\n\nPress \"P\" to PAUSE the game";
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/tutorial1.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = false;
   }
}