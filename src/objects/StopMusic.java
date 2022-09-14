package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class StopMusic extends SuperObject {
   
   public StopMusic() {
      
      name = "Stop";
      dialogue = "";
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/tutorial1.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}
