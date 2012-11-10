/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handsveindetection.db;

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
    private byte [] password;

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
