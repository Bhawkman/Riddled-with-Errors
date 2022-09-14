package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Node extends SuperObject {
   
   public OBJ_Node() {
      
      name = "Node";
      dialogue = "Nodes test your Knowledge with Q&A.\nThese will prvide you with Keys!\n\nPress\"F\" to exit Node";
      
      try {
         image = ImageIO.read(getClass().getResourceAsStream("/objects/node.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      collision = true;
   }
}