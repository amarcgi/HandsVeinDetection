/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handsveindetection.buisness;
import handsveindetection.db.HandsVeinDetails;
import java.util.Properties;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import ij.IJ;
import ij.process.ImageProcessor;
import ij.process.ColorProcessor;
import ij.ImagePlus;
import ij.process.ImageConverter;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import skeleton_analysis.AnalyzeSkeleton_;
import skeleton_analysis.SkeletonResult;
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
    
    public HandsVeinDetails processImageForBifurcationEndPointetc(String location,HandsVeinDetails handsVeinDetails)throws Exception{
        /*ImagePlus ip1 = IJ.openImage("C:\\Documents and Settings\\amarnath.poddar\\Desktop\\vase.png");
	ImageProcessor ip = new ColorProcessor(ip1.getWidth(), ip1.getHeight());
	System.out.println("Histogramm "+ip.getHistogram().length);;*/
	//System.out.println("Edge 1"+ip.FIND_EDGES);
	//ip.findEdges();
	
	//ColorProcessor ipc = new ColorProcessor( ImageIO.read(   new File( "D:\\projwkspace\\ImageHistogramm\\colorgrayhands_1_avg.bmp")));
    //ipc.findEdges();
    
  //  ImageIO.write(ipc.getBufferedImage(), "png",new File( "C:\\Documents and Settings\\amarnath.poddar\\Desktop\\Edgevase.png"));
  //  System.out.println("Edge 2"+ipc.FIND_EDGES);
	/*BufferedImage bimg = ipc.getBufferedImage();
    ImagePlus imp = new ImagePlus("firmaOriginal", bimg);
	IJ.runPlugIn(imp,"ij.plugin.filter.Binary", "Skeletonize");
	BufferedImage binaryImage = (BufferedImage) imp.getImage();
	ImageIO.write(binaryImage, "bmp",new File( "C:\\Documents and Settings\\amarnath.poddar\\Desktop\\Edgehands.bmp"));
    */
       ImagePlus ip1 = IJ.openImage(location);
	ImageProcessor ip = new ColorProcessor(ip1.getWidth(), ip1.getHeight());
        handsVeinDetails.setHistogrammlength(ip.getHistogram().length);
	System.out.println("Histogramm "+ip.getHistogram().length);;
        
        
        
	Preprocessing binarize = new Preprocessing();
	ImagePlus impt = new ImagePlus(" ", binarize.umbralizarFirma(ImageIO.read(new File(location))) );
	IJ.runPlugIn(impt,"ij.plugin.filter.Binary", "Make Binary");
	//BufferedImage bf = (BufferedImage) impt.getImage();
	
	
	//ImageIO.write(bf,"bmp",new File("C:\\Users\\Amar\\Documents\\NetBeansProjects\\JavaApplication7\\src\\bifurBinary.bmp"));
  
   
        // Takes a binary image as input
        // ImagePlus imp = IJ.openImage("C:\\Users\\Amar\\Documents\\NetBeansProjects\\JavaApplication7\\src\\bifurBinary.bmp");// get current open image
        //convert garscale 8bit
        ImageConverter  imageConverter= new ImageConverter(impt);
        imageConverter.convertToGray8();
  
  
        // Skeletonize the image
        IJ.run(impt, "Skeletonize", "");
        // IJ.runPlugIn(imp,"ij.plugin.filter.Binary", "Skeletonize");
  
 // Initialize AnalyzeSkeleton_
      AnalyzeSkeleton_ skel = new AnalyzeSkeleton_();
     skel.calculateShortestPath = true;
     skel.setup("", impt);
  
 // Perform analysis in silent mode
 // (work on a copy of the ImagePlus if you don't want it displayed)
 // run(int pruneIndex, boolean pruneEnds, boolean shortPath, ImagePlus origIP, boolean silent, boolean verbose)
 SkeletonResult skelResult = skel.run(AnalyzeSkeleton_.NONE, false, true, null, true, false);
 
 // Read the results
 Object shortestPaths[] = skelResult.getShortestPathList().toArray();
 double branchLengths[] = skelResult.getAverageBranchLength();
 int branchNumbers[] = skelResult.getBranches();
  
 int totalLength = 0;
 for (int i = 0; i < branchNumbers.length; i++) {
     totalLength += branchNumbers[i] * branchLengths[i];
 }
 
  handsVeinDetails.setBranchLengths(branchLengths.length);

 handsVeinDetails.setTotalLength(totalLength);
 
  System.out.println("totalLength "+totalLength);

 handsVeinDetails.setNumOfTrees(skelResult.getNumOfTrees());
 System.out.println("getNumOfTrees "+skelResult.getNumOfTrees());

 handsVeinDetails.setAverageBranchLength(skelResult.getAverageBranchLength().length);
 System.out.println("getAverageBranchLength "+skelResult.getAverageBranchLength().length);
 
System.out.println("getBranches "+skelResult.getBranches().length);

handsVeinDetails.setEndPoints(totalLength);
System.out.println("getEndPoints "+skelResult.getEndPoints().length);

handsVeinDetails.setGraph(skelResult.getGraph().length);
System.out.println("getGraph "+skelResult.getGraph().length);

handsVeinDetails.setJunctions(skelResult.getJunctions().length);
System.out.println("getJunctions "+skelResult.getJunctions().length);

handsVeinDetails.setJunctionVoxels(skelResult.getJunctionVoxels().length);
System.out.println("getJunctionVoxels "+skelResult.getJunctionVoxels().length);

handsVeinDetails.setListOfEndPoints(skelResult.getListOfEndPoints().size());
System.out.println("getListOfEndPoints "+skelResult.getListOfEndPoints().size());

handsVeinDetails.setBifurcation(skelResult.getListOfJunctionVoxels().size());
System.out.println("getListOfJunctionVoxels "+skelResult.getListOfJunctionVoxels().size());

//handsVeinDetails.setMaximumBranchLength(skelResult.getMaximumBranchLength().length);
System.out.println("getMaximumBranchLength "+skelResult.getMaximumBranchLength().length);

handsVeinDetails.setNumberOfVoxels(skelResult.getNumberOfVoxels().length);
System.out.println("getNumberOfVoxels "+skelResult.getNumberOfVoxels().length);
handsVeinDetails.setQuadruples(skelResult.getQuadruples().length);
System.out.println("getQuadruples "+skelResult.getQuadruples().length);
return handsVeinDetails;
    }
    
}
