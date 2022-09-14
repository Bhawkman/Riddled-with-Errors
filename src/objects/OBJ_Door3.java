package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door3 extends SuperObject {
   
   public OBJ_Door3() {
      
      name = "Door3";
      dialogue = "";
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}
