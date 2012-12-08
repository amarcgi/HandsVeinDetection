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
            HandsVeinWindow handsVeinWindow= new HandsVeinWindow();
            handsVeinWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            handsVeinWindow.setVisible( true );
            
    }
}
