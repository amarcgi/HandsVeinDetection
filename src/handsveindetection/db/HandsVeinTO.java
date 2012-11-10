/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handsveindetection.db;

import java.io.Serializable;

/**
 *
 * @author Amar
 */
public class HandsVeinTO implements Serializable{
    String userName;
    String contactNumber;
    String email;
    String address;
    byte[] password;
    HandsVeinTO( String userName, String contactNumber, String email,String address,byte[] password){
        
    this.userName = userName;
    this.contactNumber = contactNumber;
    this.email = email;
    this.address = address;
    this.password=password;
    }
}
