/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handsveindetection.db;

import handsveindetection.buisness.VeinDetails;
import java.util.Collection;

/**
 *
 * @author Amar
 */
public interface HandsVeinDao {
    public String generateId(HandsVeinDetails handsVeinDetails);
    public boolean update(HandsVeinDetails handsVeinDetails);
    public boolean delete(HandsVeinDetails handsVeinDetails);
    public Collection<HandsVeinDetails> getAllHandsVeinDetailsInDb();
    public boolean checkUserId(final int userId,String usergeneratedId);
    public boolean checkPassword(final VeinDetails loginveinDetails,final int userId);
   
}
