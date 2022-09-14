package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door4 extends SuperObject {
   
   public OBJ_Door4() {
      
      name = "Door4";
      dialogue = "";
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}