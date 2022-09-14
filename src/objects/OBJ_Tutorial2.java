package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Tutorial2 extends SuperObject {
   
   public OBJ_Tutorial2() {
      
      name = "Tutorial2";
      dialogue = "The Key above you can be used\nto open doors! Doors are locked until\nyou get enough keys from finishing\nchallenges\nWalk over the key to grab it";
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/tutorial1.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = false;
   }
}