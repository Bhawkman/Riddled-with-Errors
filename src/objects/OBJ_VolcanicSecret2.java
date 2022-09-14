package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_VolcanicSecret2 extends SuperObject {
   
   public OBJ_VolcanicSecret2() {
      
      name = "VolcanicSecret2";
      dialogue = "You found a secret!";
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}
