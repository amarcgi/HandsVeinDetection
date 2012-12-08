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
