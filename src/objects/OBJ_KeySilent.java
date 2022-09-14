package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_KeySilent extends SuperObject {
   
   public OBJ_KeySilent() {
      
      name = "KeySilent";
      dialogue = "";
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}