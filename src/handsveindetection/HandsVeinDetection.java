/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handsveindetection;


import java.sql.SQLException;
import javax.swing.JFrame;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.lob.LobHandler;

/**
 *
 * @author Amar
 */
public class HandsVeinDetection {

    /**
     * @param args the command line 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        AmpleWelComeScreen ampleWelComeScreen= new AmpleWelComeScreen();
        ampleWelComeScreen.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        ampleWelComeScreen.setVisible( true );
        ampleWelComeScreen.setLocation(400, 250);
        try{
        Thread.currentThread().sleep(5000);
        }catch(Exception t){
            t.printStackTrace();;
        }
        ampleWelComeScreen.setVisible( false );
        ampleWelComeScreen.dispose();
        HandsVeinWindow handsVeinWindow= new HandsVeinWindow();
            handsVeinWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            handsVeinWindow.setVisible( true );
            
    }
}
