/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handsveindetection.buisness;

/**
 *
 * @author Amar
 */
public class VeinDetails{
            private int noOfVein;
            private int noOfIntersectionPointInVein;

            public int getNoOfIntersectionPointInVein() {
                return noOfIntersectionPointInVein;
            }

            public void setNoOfIntersectionPointInVein(int noOfIntersectionPointInVein) {
                this.noOfIntersectionPointInVein = noOfIntersectionPointInVein;
            }

            public int getNoOfVein() {
                return noOfVein;
            }

            public void setNoOfVein(int noOfVein) {
                this.noOfVein = noOfVein;
            }
       }