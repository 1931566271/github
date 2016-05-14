
import java.awt.*;
import javax.swing.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import sun.audio.AudioPlayer;

public class Music {


   public static void play(String file)
   {
	
      InputStream inputStream;

      try 
      {
         inputStream = new FileInputStream(new File(file));//file   指的是音乐的路径。
         AudioPlayer.player.start(inputStream);
      } 
      catch (FileNotFoundException e)
      {
         // TODO Auto-generated catch block
          e.printStackTrace();
      }
   }
}