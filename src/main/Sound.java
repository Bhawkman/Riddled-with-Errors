package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

/**
 * Class for implementing sounds into the game.
 *
 * @author Group 3
 * @version 5/4/2022
 */
public class Sound {
   
   Clip clip;
   URL[] soundURL = new URL[30];
   
   /**
    * Constructs and fills the soundURL Array.
    */
   public Sound() {
      soundURL[5] = getClass().getResource("/sound/squeak.wav");
      soundURL[6] = getClass().getResource("/sound/bling.wav");
      soundURL[7] = getClass().getResource("/sound/hurt.wav");
   }
   
   /**
    * Sets the file to the correct index in the soundURL Array.
    * @param i the index
    */
   public void setFile(int i) {
      try {
         AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
         clip = AudioSystem.getClip();
         clip.open(ais);
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   /**
    * Plays the sound.
    */
   public void play() {
      clip.start();
   }
   
   /**
    * Stops the sound.
    */
   public void stop() {
      clip.stop();
      clip.close();
   }
}
