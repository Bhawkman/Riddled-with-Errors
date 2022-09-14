package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_InfoNode extends SuperObject {
   
   public OBJ_InfoNode() {
      
      name = "InfoNode";
      dialogue = "Find the number hidden in the flowers that welcome\nyou to this world...just past the tutorial on the cliff\n\nThen take your findings to the top of the map to find\nthe final key";
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/tutorial1.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = false;
   }
}
