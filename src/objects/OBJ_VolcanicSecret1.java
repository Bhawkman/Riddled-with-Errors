package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_VolcanicSecret1 extends SuperObject {
   
   public OBJ_VolcanicSecret1() {
      
      name = "VolcanicSecret1";
      dialogue = "You found a secret!";
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}
