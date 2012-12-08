/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handsveindetection.buisness;

/**
 *
 * @author Amar
 */
import java.net.URL;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FileMonitor
{
    Properties properties = new Properties();
     URL url=getClass().getClassLoader().getResource("handsveindetection/resources/handsvein.properties");
     String path=url.getPath();
    static Timer timer;
   public static void  startFileMonitor(final String dir,final String filext,final JLabel password){
 	 timer= new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
                                final String imagePath=dir;
				File file= new File(dir);
                                file.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
							String fileNameList[] = dir.list();
							if(fileNameList !=null && fileNameList.length>0){
								for(String fileName:fileNameList){
									if(fileName.endsWith(filext)){
                                                                       //  Crop crop= new Crop();
                                                                       //  password.setIcon(new ImageIcon(crop.Crop(new ImageIcon(imagePath+"002.jpg"))));
                                                                             password.setIcon(new ImageIcon(imagePath+"002.jpg"));
                                                                            System.out.println("Image file found");
									    stopFileMonitor();
                                                                            return true;
									}
								}
							}
                                                return true;
					}
				});
			}
		},2000,2000);
    }
   
   
    public static void  stopFileMonitor(){
        timer.cancel();
    }
    
    public  Properties getResourceLocation(){
       try{
              properties.load(new FileInputStream(url.getPath()));
              return properties;
       }catch(Exception t){
           t.printStackTrace();;
           return null;
       }
       
    }
    
}

 
class Crop extends JFrame {

  Image image;

  Insets insets;

  public Image Crop(ImageIcon icon) {
  //  ImageIcon icon = new ImageIcon(imageLocation);
    image = icon.getImage();
    image = createImage(new FilteredImageSource(image.getSource(),
        new CropImageFilter(0, 0, 230, 205)));
    return image;
  }

}
           
                 