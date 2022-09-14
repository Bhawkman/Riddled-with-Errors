package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Congrats extends SuperObject {
   
   public Congrats() {
      
      name = "Congrats";
      dialogue = "\n                        CONGRATULATIONS!\n\n                           You beat the game!";
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}