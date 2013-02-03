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
   static  Timer timer=null;
   public static void  startFileMonitor(final String dir,final String filext,final JLabel password,final JLabel grayscaleImagelabel,final JLabel histogramImagelabel,final JLabel iRImageLabel,final JLabel segementedImageLabel) {
    	 timer = new Timer();;
       timer.schedule(new TimerTask() {
			@Override
			public void run() {
                              final String imagePath=dir;
				File file= new File(dir);
                                file.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
                                            System.out.println("Accept ");
                                            String fileNameList[] = dir.list();
							if(fileNameList !=null && fileNameList.length>0){
								for(String fileName:fileNameList){
                                                                        System.out.println("File Name "+fileName);
									if(fileName.endsWith(filext)){
                                                                           // FileMonitor fileMonitor= new FileMonitor();
                                                                            //  Crop crop= new Crop();
                                                                       //  password.setIcon(new ImageIcon(crop.Crop(new ImageIcon(imagePath+"002.jpg"))));
                                                                        //    password.setIcon(new ImageIcon(crop.Crop(new ImageIcon(imagePath+ fileMonitor.getResourceLocation().getProperty("filename")))));
                                                                          //  password.setIcon(new ImageIcon(imagePath+ fileMonitor.getResourceLocation().getProperty("filename")));
                                                                            System.out.println("Image file found");
									  ImageProcessing imageProcessing= new ImageProcessing();
                                                                          imageProcessing.setImageInIrGrayHistoSegmentedpasswordJlabel(imagePath, password, grayscaleImagelabel, histogramImagelabel, iRImageLabel, segementedImageLabel);
                                                                           timer.cancel(); 
                                                                           timer.purge();
                                                                           
                                                                          stopFileMonitor();
                                                                         //   break; 
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
        System.out.println("shut down Timer");
        timer.cancel();
        timer.purge();
    }
    
   public  Properties getResourceLocation(){
       try{
    	   properties.load(FileMonitor.class.getClassLoader().getResourceAsStream("handsveindetection/resources/handsvein.properties"));  
    	 //  properties.load(new FileInputStream(url.getPath()));
              return properties;
       }catch(Exception t){
           t.printStackTrace();;
           return null;
       }
       
    }
   
   public void fileDelete(){
        File file = new File(getResourceLocation().getProperty("directory"));        
        String[] myFiles;      
            if(file.isDirectory()){  
                myFiles = file.list();  
                for (int i=0; i<myFiles.length; i++) {  
                    File myFile = new File(file, myFiles[i]);   
                    myFile.delete();  
                }  
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
        new CropImageFilter(50, 20, 240, 150)));
    return image;
  }

}
           
                 