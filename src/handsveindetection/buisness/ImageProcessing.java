/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handsveindetection.buisness;
import java.util.Properties;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

/**
 *
 * @author Amar
 */
public class ImageProcessing {
    
    public VeinDetails getVeinDetails(){
        VeinDetails veinDetails=null;
        try{
            FileMonitor fileMonitor= new FileMonitor();
          Properties properties  = fileMonitor.getResourceLocation();
//          ConvertJPGToBMP cjpgtbmp= new ConvertJPGToBMP();
//          cjpgtbmp.convertJpegToBMP(properties.getProperty("filename"),properties.getProperty("directory"));        
//          HistogramEQ histogramEQ = new HistogramEQ();
//          histogramEQ.convertHistogramm(properties.getProperty("bmpfilename"),properties.getProperty("directory"));
//          CannyEdgeDetector cannyEdgeDetector = new CannyEdgeDetector();
//          cannyEdgeDetector.convertToCannyEdgeDetector(properties.getProperty("histogramimage"),properties.getProperty("directory"));
         setImageInIrGrayHistoSegmentedpasswordJlabel(null,null,null,null,null,null);
          HoughTransform houghTransform = new HoughTransform();
          veinDetails = houghTransform.getVeinDetails(properties.getProperty("canyedgeimage"),properties.getProperty("directory"));
          
        }catch(Throwable t){
            t.printStackTrace();;
            return null;
        }
        return veinDetails;
    }
    
    public void setImageInIrGrayHistoSegmentedpasswordJlabel(String imagePath,JLabel password,final JLabel grayscaleImagelabel,final JLabel histogramImagelabel,final JLabel iRImageLabel,final JLabel segementedImageLabel){
        try{
        FileMonitor fileMonitor= new FileMonitor();
          Properties properties  = fileMonitor.getResourceLocation();
          
         Crop crop= new Crop();
         if(password!=null)
         password.setIcon(new ImageIcon(crop.Crop(new ImageIcon(imagePath+ fileMonitor.getResourceLocation().getProperty("filename")))));
         if(iRImageLabel!=null)
         iRImageLabel.setIcon(new ImageIcon(crop.Crop(new ImageIcon(imagePath+ fileMonitor.getResourceLocation().getProperty("filename")))));
         
         ConvertJPGToBMP cjpgtbmp= new ConvertJPGToBMP();
         cjpgtbmp.convertJpegToBMP(properties.getProperty("filename"),properties.getProperty("directory")); 
         
         HistogramEQ histogramEQ = new HistogramEQ();
         histogramEQ.convertHistogramm(properties.getProperty("bmpfilename"),properties.getProperty("directory"));
         Image imagehisto = crop.Crop(new ImageIcon(ImageIO.read(new File(imagePath+ fileMonitor.getResourceLocation().getProperty("histogramimage")))));
         if(histogramImagelabel!=null)
         histogramImagelabel.setIcon(new ImageIcon(imagehisto));
         
         Grayscale.convertGrayImage(properties.getProperty("histogramimage"),properties.getProperty("directory"),fileMonitor);
         Image imageGray = crop.Crop(new ImageIcon(ImageIO.read(new File(imagePath+ fileMonitor.getResourceLocation().getProperty("grayscalimage")))));
         if(grayscaleImagelabel!=null)
         grayscaleImagelabel.setIcon(new ImageIcon(imageGray));

                 
          CannyEdgeDetector cannyEdgeDetector = new CannyEdgeDetector();
          cannyEdgeDetector.convertToCannyEdgeDetector(properties.getProperty("grayscalimage"),properties.getProperty("directory"));
          Image cannyEdge = crop.Crop(new ImageIcon(ImageIO.read(new File(imagePath+ fileMonitor.getResourceLocation().getProperty("canyedgeimage")))));
          if(segementedImageLabel!=null)
          segementedImageLabel.setIcon(new ImageIcon(cannyEdge));
//          
        }
        catch(Throwable t){
            t.printStackTrace();
        }
    }
}
