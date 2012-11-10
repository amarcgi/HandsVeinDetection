/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handsveindetection.db;

/**
 *
 * @author Amar
 */
public class CustomException extends Throwable{
    
    CustomException(String msg){
        this.message=msg;
    }
    String message;
    
    @Override
    public String toString(){
        return message;
    }
    
}
