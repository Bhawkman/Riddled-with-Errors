package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Tutorial1 extends SuperObject {
   
   public OBJ_Tutorial1() {
      
      name = "Tutorial1";
      dialogue = "Welcome to The Tutorial!\nThese dialogue boxes with the\n'i' will give you info\n\nPress \"F\" to Exit this window.";
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/tutorial1.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = false;
   }
}