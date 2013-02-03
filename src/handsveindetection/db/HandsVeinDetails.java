/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handsveindetection.db;
import java.util.Date;
/**
 *
 * @author Amar
 */
public class HandsVeinDetails {
    private Integer pk;
    private String userName;
    private String contactNumber;
    private String email;
    private String address;
    private long noofvein;
    private long noofcrosspoint;
    private byte [] password;
    private Date registrationDate;
    private String userGeneratedId;
   
    private int totalLength;
    private int numOfTrees;
    private int averageBranchLength;
    private int branches;
    private int endPoints;
    private int graph;
    private int junctions;
    private int junctionVoxels;
    private int listOfEndPoints;
    private int bifurcation;

  //  private int maximumBranchLength;
    private int numberOfVoxels;
    private int quadruples;
    
     private int branchLengths;
    private int histogrammlength;
   
    
//    System.out.println("totalLength "+totalLength);
//  System.out.println("cumulativeLengthOfShortestPaths "+cumulativeLengthOfShortestPaths);
//System.out.println("getNumOfTrees "+skelResult.getNumOfTrees());
//System.out.println("getAverageBranchLength "+skelResult.getAverageBranchLength().length);
//System.out.println("getBranches "+skelResult.getBranches().length);
//System.out.println("getEndPoints "+skelResult.getEndPoints().length);
//System.out.println("getGraph "+skelResult.getGraph().length);
//System.out.println("getJunctions "+skelResult.getJunctions().length);
//System.out.println("getJunctionVoxels "+skelResult.getJunctionVoxels().length);
//System.out.println("getListOfEndPoints "+skelResult.getListOfEndPoints().size());
//System.out.println("getListOfJunctionVoxels "+skelResult.getListOfJunctionVoxels().size());
//System.out.println("getMaximumBranchLength "+skelResult.getMaximumBranchLength().length);
//System.out.println("getNumberOfVoxels "+skelResult.getNumberOfVoxels().length);
//System.out.println("getQuadruples "+skelResult.getQuadruples().length);
//    
   public int getBifurcation() {
        return bifurcation;
    }

    public void setBifurcation(int bifurcation) {
        this.bifurcation = bifurcation;
    }
    
     public int getBranchLengths() {
        return branchLengths;
    }

    public void setBranchLengths(int branchLengths) {
        this.branchLengths = branchLengths;
    }
   

    public int getHistogrammlength() {
        return histogrammlength;
    }

    public void setHistogrammlength(int histogrammlength) {
        this.histogrammlength = histogrammlength;
    }
    public int getAverageBranchLength() {
        return averageBranchLength;
    }

    public void setAverageBranchLength(int averageBranchLength) {
        this.averageBranchLength = averageBranchLength;
    }

    public int getBranches() {
        return branches;
    }

    public void setBranches(int branches) {
        this.branches = branches;
    }

   

    public int getEndPoints() {
        return endPoints;
    }

    public void setEndPoints(int endPoints) {
        this.endPoints = endPoints;
    }

    public int getGraph() {
        return graph;
    }

    public void setGraph(int graph) {
        this.graph = graph;
    }

    public int getJunctionVoxels() {
        return junctionVoxels;
    }

    public void setJunctionVoxels(int junctionVoxels) {
        this.junctionVoxels = junctionVoxels;
    }

    public int getJunctions() {
        return junctions;
    }

    public void setJunctions(int junctions) {
        this.junctions = junctions;
    }

    public int getListOfEndPoints() {
        return listOfEndPoints;
    }

    public void setListOfEndPoints(int listOfEndPoints) {
        this.listOfEndPoints = listOfEndPoints;
    }

//    public int getMaximumBranchLength() {
//        return maximumBranchLength;
//    }
//
//    public void setMaximumBranchLength(int maximumBranchLength) {
//        this.maximumBranchLength = maximumBranchLength;
//    }

    public int getNumOfTrees() {
        return numOfTrees;
    }

    public void setNumOfTrees(int numOfTrees) {
        this.numOfTrees = numOfTrees;
    }

    public int getNumberOfVoxels() {
        return numberOfVoxels;
    }

    public void setNumberOfVoxels(int numberOfVoxels) {
        this.numberOfVoxels = numberOfVoxels;
    }

    public int getQuadruples() {
        return quadruples;
    }

    public void setQuadruples(int quadruples) {
        this.quadruples = quadruples;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(int totalLength) {
        this.totalLength = totalLength;
    }

    public String getUserGeneratedId() {
        return userGeneratedId;
    }

    public void setUserGeneratedId(String userGeneratedId) {
        this.userGeneratedId = userGeneratedId;
    }

    public Date getDate() {
        return registrationDate;
    }

    public void setDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public long getNoofcrosspoint() {
        return noofcrosspoint;
    }

    public void setNoofcrosspoint(long noofcrosspoint) {
        this.noofcrosspoint = noofcrosspoint;
    }

    public long getNoofvein() {
        return noofvein;
    }

    public void setNoofvein(long noofvein) {
        this.noofvein = noofvein;
    }
   

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

   
}
