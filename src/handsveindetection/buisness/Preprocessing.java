package handsveindetection.buisness;

import ij.IJ;
import ij.ImagePlus;

import java.awt.image.BufferedImage;

public class Preprocessing {
	
	// Binarizacion...
	public BufferedImage umbralizarFirma(BufferedImage firma) {
		ImagePlus imp;
		imp = new ImagePlus("firmaOriginal", firma);
		IJ.runPlugIn(imp,"ij.plugin.filter.Binary", "Make Binary");
		BufferedImage bf = (BufferedImage) imp.getImage();
		return bf;
	}
	// Skeletonize...
	public BufferedImage skeletonFirma(BufferedImage firma) {
		ImagePlus imp;
		imp = new ImagePlus("firmaOriginal", firma);
		IJ.runPlugIn(imp,"ij.plugin.filter.Binary", "Skeletonize");
		BufferedImage bf = (BufferedImage) imp.getImage();
		return bf;
	}
}