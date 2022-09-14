package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door2 extends SuperObject {
   
   public OBJ_Door2() {
      
      name = "Door2";
      dialogue = "";
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}