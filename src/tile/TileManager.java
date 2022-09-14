package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Sets the Array index of all tiles.
 *
 * @author Group 3
 * @version 5/4/2022
 */
public class TileManager {
   public Tile[] tiles;
   public int mapTileNumber[][];
   GamePanel gamePanel;
   
   /**
    * Constructs a TileManager Object.
    * @param gamePanel GamePanel
    */
   public TileManager(GamePanel gamePanel) {
      this.gamePanel = gamePanel;
      tiles = new Tile[201];
      mapTileNumber = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
      getTileImage();
      loadMap();
   }
   
   /**
    * Declares the index of all Tiles, as well as gets their image.
    */
   public void getTileImage() {
      
      try {
         
         // ********************************************
         // grassland
         // ********************************************
         
         tiles[0] = new Tile();
         tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/grass1.png"));
         
         tiles[1] = new Tile();
         tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/pathBare.png"));
         
         tiles[2] = new Tile();
         tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/pathCornerBR.png"));
         
         tiles[3] = new Tile();
         tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/pathBottom.png"));
         
         tiles[4] = new Tile();
         tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/pathCornerBL.png"));
         
         tiles[5] = new Tile();
         tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/pathLeft.png"));
         
         tiles[6] = new Tile();
         tiles[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/pathCornerTL.png"));
         
         tiles[7] = new Tile();
         tiles[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/pathTop.png"));
         
         tiles[8] = new Tile();
         tiles[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/pathCornerTR.png"));
         
         tiles[9] = new Tile();
         tiles[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/pathRight.png"));
         
         tiles[10] = new Tile();
         tiles[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/cliffCornerTL.png"));
         tiles[10].collision = true;
         
         tiles[11] = new Tile();
         tiles[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/cliffTop.png"));
         tiles[11].collision = true;
         
         tiles[12] = new Tile();
         tiles[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/cliffCornerTR.png"));
         tiles[12].collision = true;
         
         tiles[13] = new Tile();
         tiles[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/cliffRight.png"));
         tiles[13].collision = true;
         
         tiles[14] = new Tile();
         tiles[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/cliffCornerBR.png"));
         tiles[14].collision = true;
         
         tiles[15] = new Tile();
         tiles[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/cliffBottom.png"));
         tiles[15].collision = true;
         
         tiles[16] = new Tile();
         tiles[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/cliffCornerBL.png"));
         tiles[16].collision = true;
         
         tiles[17] = new Tile();
         tiles[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/cliffLeft.png"));
         tiles[17].collision = true;
         
         tiles[18] = new Tile();
         tiles[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/cliffCornerBR.png"));
         tiles[18].collision = true;
         
         tiles[19] = new Tile();
         tiles[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/bush1.png"));
         tiles[19].collision = true;
         
         tiles[20] = new Tile();
         tiles[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/bush2.png"));
         tiles[20].collision = true;
         
         tiles[21] = new Tile();
         tiles[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/flowerRed1.png"));
         
         tiles[22] = new Tile();
         tiles[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/flowerYellow1.png"));
         
         tiles[23] = new Tile();
         tiles[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/tree1.png"));
         tiles[23].collision = true;
         
         tiles[24] = new Tile();
         tiles[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/tree2.png"));
         tiles[24].collision = true;
         
         tiles[25] = new Tile();
         tiles[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/log1.png"));
         tiles[25].collision = true;
         
         tiles[26] = new Tile();
         tiles[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/stump1.png"));
         tiles[26].collision = true;
         
         tiles[27] = new Tile();
         tiles[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/water.png"));
         tiles[27].collision = true;
         
         tiles[28] = new Tile();
         tiles[28].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/pathCornerInsideBR.png"));
         
         tiles[29] = new Tile();
         tiles[29].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/pathCornerInsideBL.png"));
         
         tiles[30] = new Tile();
         tiles[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/pathCornerInsideTL.png"));
         
         tiles[31] = new Tile();
         tiles[31].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/pathCornerInsideTR.png"));
         
         tiles[32] = new Tile();
         tiles[32].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/cliffCornerInsideTL.png"));
         tiles[32].collision = true;
         
         tiles[33] = new Tile();
         tiles[33].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/cliffCornerInsideTR.png"));
         tiles[33].collision = true;
         
         tiles[34] = new Tile();
         tiles[34].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/cliffCornerInsideBR.png"));
         tiles[34].collision = true;
         
         tiles[35] = new Tile();
         tiles[35].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/cliffCornerInsideBL.png"));
         tiles[35].collision = true;
         
         tiles[36] = new Tile();
         tiles[36].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grasslands/dock.png"));
         
         // ********************************************
         // desert
         // ********************************************
         
         tiles[40] = new Tile();
         tiles[40].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/sand_1.png"));
         
         tiles[41] = new Tile();
         tiles[41].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/sand_2.png"));
         
         tiles[42] = new Tile();
         tiles[42].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/sand_3.png"));
         
         tiles[43] = new Tile();
         tiles[43].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/sand_4.png"));
         
         tiles[44] = new Tile();
         tiles[44].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/desert_dirt_path_outside_1.png"));
         
         tiles[45] = new Tile();
         tiles[45].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/desert_dirt_path_top.png"));
         
         tiles[46] = new Tile();
         tiles[46].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/desert_dirt_path_outside_3.png"));
         
         tiles[47] = new Tile();
         tiles[47].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/desert_dirt_path_right.png"));
         
         tiles[48] = new Tile();
         tiles[48].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/desert_dirt_path_outside_2.png"));
         
         tiles[49] = new Tile();
         tiles[49].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/desert_dirt_path_bottom.png"));
         
         tiles[50] = new Tile();
         tiles[50].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/desert_dirt_path_outside_4.png"));
         
         tiles[51] = new Tile();
         tiles[51].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/desert_dirt_path_left.png"));
         
         tiles[52] = new Tile();
         tiles[52].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/desert_dirt_path_inside_2.png"));
         
         tiles[53] = new Tile();
         tiles[53].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/desert_dirt_path_inside_4.png"));
         
         tiles[54] = new Tile();
         tiles[54].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/desert_dirt_path_inside_3.png"));
         
         tiles[55] = new Tile();
         tiles[55].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/desert_dirt_path_inside_1.png"));
         
         tiles[56] = new Tile();
         tiles[56].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/cactus.png"));
         tiles[56].collision = true;
         
         tiles[57] = new Tile();
         tiles[57].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/dead_shrub.png"));
         tiles[57].collision = true;
         
         tiles[58] = new Tile();
         tiles[58].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/desert_rock.png"));
         tiles[58].collision = true;
         
         tiles[59] = new Tile();
         tiles[59].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/sandWall.png"));
         tiles[59].collision = true;
         
         tiles[60] = new Tile();
         tiles[60].image = ImageIO.read(getClass().getResourceAsStream("/tiles/desert/sandWall.png"));
         
         // ********************************************
         // mountainous
         // ********************************************
         
         tiles[70] = new Tile();
         tiles[70].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt.png"));
         
         tiles[71] = new Tile();
         tiles[71].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/cave-dirt.png"));
         
         tiles[72] = new Tile();
         tiles[72].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/gravel.png"));
         
         tiles[73] = new Tile();
         tiles[73].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-corner-NW.png"));
         tiles[73].collision = true;
         
         tiles[74] = new Tile();
         tiles[74].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-edge-N.png"));
         tiles[74].collision = true;
         
         tiles[75] = new Tile();
         tiles[75].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-corner-NE.png"));
         tiles[75].collision = true;
         
         tiles[76] = new Tile();
         tiles[76].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-edge-E.png"));
         tiles[76].collision = true;
         
         tiles[77] = new Tile();
         tiles[77].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-corner-SE.png"));
         tiles[77].collision = true;
         
         tiles[78] = new Tile();
         tiles[78].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-edge-S.png"));
         tiles[78].collision = true;
         
         tiles[79] = new Tile();
         tiles[79].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-corner-SW.png"));
         tiles[79].collision = true;
         
         tiles[80] = new Tile();
         tiles[80].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-edge-W.png"));
         tiles[80].collision = true;
         
         tiles[81] = new Tile();
         tiles[81].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-inner-corner-SE.png"));
         tiles[81].collision = true;
         
         tiles[82] = new Tile();
         tiles[82].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-inner-corner-SW.png"));
         tiles[82].collision = true;
         
         tiles[83] = new Tile();
         tiles[83].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-inner-corner-NW.png"));
         tiles[83].collision = true;
         
         tiles[84] = new Tile();
         tiles[84].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-inner-corner-NE.png"));
         tiles[84].collision = true;
         
         tiles[85] = new Tile();
         tiles[85].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/cave-corner-NW.png"));
         tiles[85].collision = true;
         
         tiles[86] = new Tile();
         tiles[86].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/cave-edge-N.png"));
         tiles[86].collision = true;
         
         tiles[87] = new Tile();
         tiles[87].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/cave-corner-NE.png"));
         tiles[87].collision = true;
         
         tiles[88] = new Tile();
         tiles[88].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/cave-edge-E.png"));
         tiles[88].collision = true;
         
         tiles[89] = new Tile();
         tiles[89].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/cave-corner-SE.png"));
         tiles[89].collision = true;
         
         tiles[90] = new Tile();
         tiles[90].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/cave-edge-S.png"));
         tiles[90].collision = true;
         
         tiles[91] = new Tile();
         tiles[91].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/cave-corner-SW.png"));
         tiles[91].collision = true;
         
         tiles[92] = new Tile();
         tiles[92].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/cave-edge-W.png"));
         tiles[92].collision = true;
         
         tiles[93] = new Tile();
         tiles[93].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-boulder-NW.png"));
         tiles[93].collision = true;
         
         tiles[94] = new Tile();
         tiles[94].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-boulder-NE.png"));
         tiles[94].collision = true;
         
         tiles[95] = new Tile();
         tiles[95].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-boulder-SE.png"));
         tiles[95].collision = true;
         
         tiles[96] = new Tile();
         tiles[96].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-boulder-SW.png"));
         tiles[96].collision = true;
         
         tiles[97] = new Tile();
         tiles[97].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-rock.png"));
         tiles[97].collision = true;
         
         tiles[98] = new Tile();
         tiles[98].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt-shroom.png"));
         
         tiles[99] = new Tile();
         tiles[99].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/cave-fade.png"));
         
         tiles[100] = new Tile();
         tiles[100].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mountainous/dirt.png"));
         tiles[100].collision = true;
         
         // ********************************************
         // arctic
         // ********************************************
         
         tiles[101] = new Tile();
         tiles[101].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arctic/snow.png"));
         
         tiles[102] = new Tile();
         tiles[102].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arctic/snow_path_corner_SE.png"));
         
         tiles[103] = new Tile();
         tiles[103].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arctic/snow_path_corner_SW.png"));
         
         tiles[104] = new Tile();
         tiles[104].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arctic/snow_path_corner_NW.png"));
         
         tiles[105] = new Tile();
         tiles[105].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arctic/snow_path_corner_NE.png"));
         
         tiles[106] = new Tile();
         tiles[106].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arctic/snow_path_vertical.png"));
         
         tiles[107] = new Tile();
         tiles[107].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arctic/snow_path_horizontal.png"));
         
         tiles[108] = new Tile();
         tiles[108].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arctic/snow_bush.png"));
         tiles[108].collision = true;
         
         tiles[109] = new Tile();
         tiles[109].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arctic/snowman_top.png"));
         tiles[109].collision = true;
         
         tiles[110] = new Tile();
         tiles[110].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arctic/snowman_top_hat.png"));
         tiles[110].collision = true;
         
         tiles[111] = new Tile();
         tiles[111].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arctic/snowman_bottom.png"));
         tiles[111].collision = true;
         
         tiles[112] = new Tile();
         tiles[112].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arctic/igloo_wall.png"));
         tiles[112].collision = true;
         
         tiles[113] = new Tile();
         tiles[113].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arctic/Cute.png"));
         tiles[113].collision = true;
         
         // ********************************************
         // volcanic
         // ********************************************
         
         tiles[120] = new Tile();
         tiles[120].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/rock1.png"));
         
         tiles[122] = new Tile();
         tiles[122].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/rock2.png"));
         
         tiles[123] = new Tile();
         tiles[123].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceTLcorner.png"));
         tiles[123].collision = true;
         
         tiles[124] = new Tile();
         tiles[124].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceTRcorner.png"));
         tiles[124].collision = true;
         
         tiles[125] = new Tile();
         tiles[125].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceBRcorner.png"));
         tiles[125].collision = true;
         
         tiles[126] = new Tile();
         tiles[126].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceBLcorner.png"));
         tiles[126].collision = true;
         
         tiles[127] = new Tile();
         tiles[127].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceVertical.png"));
         tiles[127].collision = true;
         
         tiles[128] = new Tile();
         tiles[128].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceHorizontal.png"));
         tiles[128].collision = true;
         
         tiles[129] = new Tile();
         tiles[129].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/lava1.png"));
         tiles[129].collision = true;
         
         tiles[130] = new Tile();
         tiles[130].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/smallrock1.png"));
         tiles[130].collision = true;
         
         tiles[131] = new Tile();
         tiles[131].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/smallrock2.png"));
         tiles[131].collision = true;
         
         tiles[132] = new Tile();
         tiles[132].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/tallLampA.png"));
         tiles[132].collision = true;
         
         tiles[133] = new Tile();
         tiles[133].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/tallLampB.png"));
         tiles[133].collision = true;
         
         tiles[134] = new Tile();
         tiles[134].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/tallLampC.png"));
         
         tiles[135] = new Tile();
         tiles[135].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/rockTL.png"));
         
         tiles[136] = new Tile();
         tiles[136].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/rockTop.png"));
         
         tiles[137] = new Tile();
         tiles[137].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/rockTR.png"));
         
         tiles[138] = new Tile();
         tiles[138].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/rockRight.png"));
         
         tiles[139] = new Tile();
         tiles[139].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/rockBR.png"));
         
         tiles[140] = new Tile();
         tiles[140].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/rockBottom.png"));
         
         tiles[141] = new Tile();
         tiles[141].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/rockBL.png"));
         
         tiles[142] = new Tile();
         tiles[142].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/rockLeft.png"));
         
         tiles[143] = new Tile();
         tiles[143].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/rockInsideTL.png"));
         
         tiles[144] = new Tile();
         tiles[144].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/rockInsideTR.png"));
         
         tiles[145] = new Tile();
         tiles[145].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/rockInsideBR.png"));
         
         tiles[146] = new Tile();
         tiles[146].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/rockInsideBL.png"));
         
         tiles[147] = new Tile();
         tiles[147].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeTL.png"));
         tiles[147].collision = true;
         
         tiles[148] = new Tile();
         tiles[148].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeTop.png"));
         tiles[148].collision = true;
         
         tiles[149] = new Tile();
         tiles[149].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeTR.png"));
         tiles[149].collision = true;
         
         tiles[150] = new Tile();
         tiles[150].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeRight.png"));
         tiles[150].collision = true;
         
         tiles[151] = new Tile();
         tiles[151].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeBR.png"));
         tiles[151].collision = true;
         
         tiles[152] = new Tile();
         tiles[152].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeBottom.png"));
         tiles[152].collision = true;
         
         tiles[153] = new Tile();
         tiles[153].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeBL.png"));
         tiles[153].collision = true;
         
         tiles[154] = new Tile();
         tiles[154].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeLeft.png"));
         tiles[154].collision = true;
         
         tiles[155] = new Tile();
         tiles[155].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeInsideTL.png"));
         tiles[155].collision = true;
         
         tiles[156] = new Tile();
         tiles[156].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeInsideTR.png"));
         tiles[156].collision = true;
         
         tiles[157] = new Tile();
         tiles[157].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeInsideBR.png"));
         tiles[157].collision = true;
         
         tiles[158] = new Tile();
         tiles[158].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeInsideBL.png"));
         tiles[158].collision = true;
         
         tiles[159] = new Tile();
         tiles[159].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/lava2.png"));
         
         tiles[160] = new Tile();
         tiles[160].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeTopLE.png"));
         tiles[160].collision = true;
         
         tiles[161] = new Tile();
         tiles[161].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeTopRE.png"));
         tiles[161].collision = true;
         
         tiles[162] = new Tile();
         tiles[162].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeBottomLE.png"));
         tiles[162].collision = true;
         
         tiles[163] = new Tile();
         tiles[163].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeBottomRE.png"));
         tiles[163].collision = true;
         
         tiles[164] = new Tile();
         tiles[164].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeLeftTE.png"));
         tiles[164].collision = true;
         
         tiles[165] = new Tile();
         tiles[165].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeRightTE.png"));
         tiles[165].collision = true;
         
         tiles[166] = new Tile();
         tiles[166].image = ImageIO.read(getClass().getResourceAsStream("/tiles/volcanic/fenceEdgeRight.png"));
         
         tiles[200] = new Tile();
         tiles[200].image = ImageIO.read(getClass().getResourceAsStream("/tiles/100.png"));
         tiles[200].collision = false;
         
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   /**
    * Creates the map Based off the Tiles Array and the world.txt file.
    */
   public void loadMap() {
      try {
         InputStream is = getClass().getResourceAsStream("/maps/world01.txt");
         BufferedReader br = new BufferedReader(new InputStreamReader(is));
         
         int col = 0;
         int row = 0;
         
         while (col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow) {
            String line = br.readLine();
            while (col < gamePanel.maxWorldCol) {
               String numbers[] = line.split(" ");
               int num = Integer.parseInt(numbers[col]);
               mapTileNumber[col][row] = num;
               col++;
            }
            if (col == gamePanel.maxWorldCol) {
               col = 0;
               row++;
            }
         }
         br.close();
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   /**
    * Draws the map using the world.txt file and the tiles Array.
    * @param g2 Graphics2D Object
    */
   public void draw(Graphics2D g2) {
      int worldRow = 0;
      int worldCol = 0;
      
      
      while (worldCol < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow) {
         int tileNum = mapTileNumber[worldCol][worldRow];
         int worldX = worldCol * gamePanel.tileSize;
         int worldY = worldRow * gamePanel.tileSize;
         int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
         int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;
         
         if (worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                 worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                 worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                 worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {
            g2.drawImage(tiles[tileNum].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
            
         }
         
         worldCol++;
         
         if (worldCol == gamePanel.maxWorldCol) {
            worldCol = 0;
            worldRow++;
         }
      }
      
   }
}
