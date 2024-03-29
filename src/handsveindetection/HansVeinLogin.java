/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HansVeinLogin.java
 *
 * Created on Oct 24, 2012, 9:57:50 AM
 */
package handsveindetection;

import handsveindetection.buisness.FileMonitor;
import handsveindetection.buisness.ImageProcessing;
import handsveindetection.buisness.VeinDetails;
import handsveindetection.db.HandsVeinDBInstantiate;
import handsveindetection.db.HandsVeinDao;
import handsveindetection.db.HandsVeinDetails;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import java.util.Properties;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.ByteArrayOutputStream;
/**
 *
 * @author Amar
 */
public class HansVeinLogin extends javax.swing.JPanel {

    /** Creates new form HansVeinLogin */
    public HansVeinLogin() {
        initComponents();
    }
//code im master branch
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userIdLabel = new javax.swing.JLabel();
        userIdtext = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        SubmitButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(600, 480));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Login with your User Id and Hands Vein");

        userIdLabel.setText("User Id");

        userIdtext.setText("jTextField1");

        passwordLabel.setText("Password");

        imageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userIdLabel)
                            .addComponent(passwordLabel))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(SubmitButton)
                            .addComponent(userIdtext, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))))
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userIdLabel)
                    .addComponent(userIdtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel)
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SubmitButton)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
    FileMonitor fileMonitor= new FileMonitor();
    label:{
    if(validateField()){
         
                String userId=userIdtext.getText();
                int length = userId.length();
                int findcharIndex=0;
                for(int i=0;i<length;i++){
                   if(userId.charAt(i)=='@'){
                       findcharIndex=i;
                       break;
                   }
                 }
                String pk=userId.substring(findcharIndex+1, length);
                int pkValue=0;
                try{
                   pkValue= Integer.parseInt(pk);  
                }catch(NumberFormatException e){
                     e.printStackTrace();
                  JOptionPane.showMessageDialog(this, "userId not valid");
                    break label;
                 }
                 HandsVeinDao handsVeinDao = HandsVeinDBInstantiate.getHandsVeinDao();
                 
                 Properties properties= fileMonitor.getResourceLocation();
                 if(handsVeinDao.checkUserId(pkValue,userId)){
                      ImageProcessing imageProcessing= new ImageProcessing();
                      VeinDetails loginveinDetails =imageProcessing.getVeinDetails();
                      System.out.println("No of Vein"+loginveinDetails.getNoOfVein());
                      System.out.println("No of cross point"+loginveinDetails.getNoOfIntersectionPointInVein());
                      HandsVeinDetails handsVeinDetailsLogin= new HandsVeinDetails();
                      String Imagandloc=properties.getProperty("directory")+properties.getProperty("canyedgeimage");
                       try{
                      handsVeinDetailsLogin = imageProcessing.processImageForBifurcationEndPointetc(Imagandloc,handsVeinDetailsLogin);
                      BufferedImage bufferedImage =  ImageIO.read(new File(properties.getProperty("directory") + properties.getProperty("canyedgeimage")));
                    // bufferedImage.ge
                       ByteArrayOutputStream byteArrayOutputStream=null;
                          try{
                                byteArrayOutputStream= new ByteArrayOutputStream();
                                ImageIO.write(bufferedImage, "bmp", byteArrayOutputStream);
                                byte imagebyte[] = byteArrayOutputStream.toByteArray();
                                handsVeinDetailsLogin.setPassword(imagebyte);


                          }catch(Throwable t){
                              t.printStackTrace();
                          }finally{
                              try{
                                   byteArrayOutputStream.close();
                              }catch(Throwable e){
                                  e.printStackTrace();;
                              }
                             }
                       }catch(Exception t){
                         t.printStackTrace(); 
                     }
                       
                       if(handsVeinDao.checkPassword(loginveinDetails, pkValue,handsVeinDetailsLogin)){
                        
                           JOptionPane.showMessageDialog(this, "Login Sucessfull");
                        String url = "https://netbanking.hdfcbank.com/netbanking/";
                        if(java.awt.Desktop.isDesktopSupported()){
                            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                            try{
                                desktop.browse(new java.net.URI(url)); 
                            }catch(Exception t){
                                t.printStackTrace();;
                            }
                        }
                       }
                     else{
                        JOptionPane.showMessageDialog(this, "You are not authorized User");
                       }
                      
                      //ImageIcon icon=(ImageIcon) imageLabel.getIcon();
//                     Image image= icon.getImage();
//                     ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                     try{
//                       ImageIO.write(new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_BYTE_GRAY), "jpg", baos);  
//                     }catch(Exception t){
//                         t.printStackTrace(); 
//                     }

//                   if(handsVeinDao.checkPassword(loginveinDetails, pkValue)){
//                        JOptionPane.showMessageDialog(this, "Login Sucessfull");
//                       }
//                    else{
//                        JOptionPane.showMessageDialog(this, "You are not authorized User");
//                    }
                 } 
                 else{
                    JOptionPane.showMessageDialog(this, "User Id Does Not Exist Please Registared");  
                 }
          }
 }
   
    fileMonitor.fileDelete();
    HandsVeinWindow.hansVeinLogin.imageLabel.setIcon(null);
    HandsVeinWindow.hansVeinLogin.userIdtext.setText("");
}//GEN-LAST:event_SubmitButtonActionPerformed

 public boolean validateField(){
        if(userIdtext.getText().trim().length()==0){
            JOptionPane.showMessageDialog(HansVeinLogin.this, "Plase Enetr Valid User ID");
            return false;
        }
        if(imageLabel.getIcon()==null){
            JOptionPane.showMessageDialog(HansVeinLogin.this, "Plase Enetr Valid Password");
            return false;
        }
        return true;
    }
   public JLabel getpasswordLabel(){
       return imageLabel;
   }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel userIdLabel;
    private javax.swing.JTextField userIdtext;
    // End of variables declaration//GEN-END:variables
}
