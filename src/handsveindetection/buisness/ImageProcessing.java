/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handsveindetection.buisness;
import java.util.Properties;
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
          ConvertJPGToBMP cjpgtbmp= new ConvertJPGToBMP();
          cjpgtbmp.convertJpegToBMP(properties.getProperty("filename"),properties.getProperty("directory"));        
          HistogramEQ histogramEQ = new HistogramEQ();
          histogramEQ.grayscaleHistogramm(properties.getProperty("bmpfilename"),properties.getProperty("directory"));
          CannyEdgeDetector cannyEdgeDetector = new CannyEdgeDetector();
          cannyEdgeDetector.convertToCannyEdgeDetector(properties.getProperty("histogramimage"),properties.getProperty("directory"));
          HoughTransform houghTransform = new HoughTransform();
          veinDetails = houghTransform.getVeinDetails(properties.getProperty("canyedgeimage"),properties.getProperty("directory"));
          
        }catch(Throwable t){
            t.printStackTrace();;
            return null;
        }
        return veinDetails;
    }
}
