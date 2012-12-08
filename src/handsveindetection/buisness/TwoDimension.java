package handsveindetection.buisness;
public class TwoDimension{
  public static void main(String[] args) {
  int[][] a2 = new int[5][2];
 // System.out.println("Length :"+a2.length);
  for (int i=0; i<a2.length; i++) {
  for (int j=0; j<a2[i].length; j++) {
	  a2[i][j] = i;
  System.out.print(" " +"["+i+"]"+"["+j+"]"+ a2[i][j]);
  }
  System.out.println("");
  }
  }
}