package main;

import objects.*;

/**
 * Sets the location and type of assets to be placed on the map.
 *
 * @author Group 3
 * @version 5/4/2022
 */
public class AssetSetter {
   
   GamePanel gp;
   public int index = 0;
   
   /**
    * AssetSetter Object.
    * @param gp GamePanel
    */
   public AssetSetter(GamePanel gp) {
      this.gp = gp;
   }
   
   /**
    * Sets the Object into the world.
    */
   public void setObject() {
   
      // ********************************************
      // Tutorial
      // ********************************************
      
      setObjecthelper(new OBJ_Tutorial1(), 960, 7168);
      setObjecthelper(new OBJ_Tutorial2(), 1785, 7168);
      setObjecthelper(new OBJ_Tutorial3(), 1800, 6023);
      setObjecthelper(new OBJ_TutorialNode(), 1455, 6516);
      setObjecthelper(new OBJ_TutorialNode2(), 2105, 6516);
      setObjecthelper(new Test_Damage_Pit(), 505, 5851);
      setObjecthelper(new OBJ_Node(), 1785, 6716);
      setObjecthelper(new OBJ_Key(), 1785, 6941);
      setObjecthelper(new OBJ_Door4(), 2625, 5820);
      setObjecthelper(new OBJ_World(), 2625, 5622);
   
      // ********************************************
      // Grassland
      // ********************************************
      
      setObjecthelper(new OBJ_Grass1(), 768, 5184);
      setObjecthelper(new OBJ_Grass2(), 1600, 1920);
      setObjecthelper(new OBJ_Grass3(), 2060, 640);
      setObjecthelper(new OBJ_InfoNode(), 2620, 1152);
      setObjecthelper(new OBJ_Door3(), 2960, 1110);
      setObjecthelper(new OBJ_World2(), 3160, 1108);
   
      // ********************************************
      // Desert
      // ********************************************
      
      setObjecthelper(new OBJ_Desert1(), 5120, 1920);
      setObjecthelper(new OBJ_Desert2(), 5951, 1408);
      setObjecthelper(new OBJ_Desert3(), 6015, 4160);
      setObjecthelper(new OBJ_Door3(), 5300, 4416);
      setObjecthelper(new OBJ_World3(), 5246, 4418);
   
      // ********************************************
      // Mountains
      // ********************************************
      
      setObjecthelper(new OBJ_Hills1(), 4415, 2945);
      setObjecthelper(new OBJ_Hills2(), 4250, 5440);
      setObjecthelper(new OBJ_Hills3(), 7440, 6350);
      setObjecthelper(new Helper(), 4140, 5440);
      setObjecthelper(new Helper2(), 7140, 5990);
      setObjecthelper(new OBJ_KeySilent(), 5890, 5780);
      setObjecthelper(new OBJ_Door4(), 7600, 6976);
      setObjecthelper(new OBJ_World4(), 7682, 6980);
   
      // ********************************************
      // Arctic
      // ********************************************
      
      setObjecthelper(new OBJ_ARCTIC1(), 10176, 6016);
      setObjecthelper(new OBJ_ARCTIC2(), 9025, 4672);
      setObjecthelper(new OBJ_ARCTIC3(), 9474, 6952);
      setObjecthelper(new OBJ_Door3(), 9024, 3648);
      setObjecthelper(new OBJ_World5(), 9026, 3542);
   
      // ********************************************
      // Volcanic
      // ********************************************
      
      setObjecthelper(new OBJ_Volcanic1(), 9728, 2112);
      setObjecthelper(new OBJ_Volcanic2(), 7552, 1856);
      setObjecthelper(new OBJ_Volcanic3(), 8448, 960);
      setObjecthelper(new OBJ_VolcanicSecret1(), 7360, 1088);
      setObjecthelper(new OBJ_VolcanicSecret2(), 10688, 2240);
      setObjecthelper(new OBJ_VolcanicSecret1(), 5500, 2362);
      setObjecthelper(new OBJ_Door(), 9280, 2304);
      setObjecthelper(new OBJ_Door(), 8000, 1856);
      setObjecthelper(new OBJ_Door(), 8832, 1024);
      setObjecthelper(new Congrats(), 9922, 490);
   }
   
   /**
    * Helper method for placing objects.
    * @param object the object to be placed
    * @param x the x coordinate
    * @param y the y coordinate
    */
   public void setObjecthelper(SuperObject object, int x, int y) {
      gp.obj[this.index] = object;
      gp.obj[this.index].worldX = x;
      gp.obj[this.index].worldY = y;
      this.index++;
   }
   
}
