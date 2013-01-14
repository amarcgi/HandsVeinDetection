package handsveindetection.buisness;
import java.io.*;
import java.util.Properties;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class ConvertJPGToBMP
{
    
    
    public boolean convertJpegToBMP(String file,String dir){
         try{  
	  File input = new File(dir+file);
	  BufferedImage image = ImageIO.read(input);
	  FileMonitor fileMonitor= new FileMonitor();
          Properties properties  = fileMonitor.getResourceLocation();
	  File output = new File(dir+properties.getProperty("bmpfilename"));
	  ImageIO.write(image, "bmp", output);
	  System.out.println("Your image has been converted successfully");
          }catch(FileNotFoundException e){
          System.out.println("Error:"+e.getMessage());
           return false;
          }catch(IOException e)
          {
            System.out.println("Error:"+e.getMessage());
             return false;
          }
          catch(Exception e){
            System.out.println(e.getMessage());
            return false;
          }
        return true;
}
}