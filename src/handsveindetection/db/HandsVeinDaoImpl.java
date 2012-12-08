/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handsveindetection.db;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import handsveindetection.buisness.VeinDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
/**
 *
 * @author Amar
 */
public class HandsVeinDaoImpl implements HandsVeinDao{
    JdbcTemplate jdbcTemplate;
    static boolean isDaoObjectInstantiated; 
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String generateId(final HandsVeinDetails handsVeinDetails) {
     //   throw new CustomException("Not supported yet.");
        int indexWhiteSpace=0;
        String userName = handsVeinDetails.getUserName();
        for(int i=0;i<userName.length();i++){
            if(userName.charAt(i)==' '){
                indexWhiteSpace=i;
                break;
            }
        }
        if(indexWhiteSpace!=0)
        handsVeinDetails.setUserName(userName.substring(0, indexWhiteSpace));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String queryInsert= "insert into handsvein(userName,contactNumber,email,address,noofvein,noofcrosspoint)values(?,?,?,?,?,?)";
        jdbcTemplate.update(new AbstractLobPreparedStatementCreator(new org.springframework.jdbc.support.lob.DefaultLobHandler(), queryInsert, "pk") {
                                    @Override
                                    protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException, DataAccessException {
                                        ps.setString(1, handsVeinDetails.getUserName());
                                        ps.setString(2, handsVeinDetails.getContactNumber());  
                                        ps.setString(3, handsVeinDetails.getEmail()); 
                                        ps.setString(4, handsVeinDetails.getAddress());
                                        ps.setLong(5, handsVeinDetails.getNoofvein());
                                        ps.setLong(6, handsVeinDetails.getNoofcrosspoint());  
                                        // lobCreator.setBlobAsBytes(ps, 5, handsVeinDetails.getPassword());
                                       
                                    }
                                  }, keyHolder);
        final int pk = keyHolder.getKey().intValue();
        String generateUserId= handsVeinDetails.getUserName()+"@"+pk;
        
        final String insertUserId ="update handsvein set userGeneratedId=?,registrationDate=Now() where pk=?";
        jdbcTemplate.update(new PreparedStatementCreator() {
          @Override
            public PreparedStatement createPreparedStatement(Connection cnctn) throws SQLException {
                PreparedStatement stmt=   cnctn.prepareStatement(insertUserId);            
                stmt.setString(1,handsVeinDetails.getUserName()+"@"+pk); 
                stmt.setInt(2,pk);
                stmt.executeUpdate();
                return stmt;
          }
         });
        return generateUserId;
    }

    @Override
    public boolean update(HandsVeinDetails handsVeinDetails) {
      //  throw new CustomException("Not supported yet.");
        return true;
    }

    @Override
    public boolean delete(HandsVeinDetails handsVeinDetails) {
     //   throw new CustomException("Not supported yet.");
        return true;
    }

    @Override
    public Collection<HandsVeinDetails> getAllHandsVeinDetailsInDb() {
     //  throw new CustomException("Not supported yet.");
       
        return null;
    }

    @Override
    public boolean checkUserId(final int userId,final String usergeneratedId) {
       
       String queryDbUserID = "select userGeneratedId from handsvein where pk="+userId;
       final Temp temp = new Temp();
       jdbcTemplate.query(queryDbUserID, new ResultSetExtractor<Boolean>() {
             @Override
            public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
               if(rs.next()){
                   if(rs.getString("userGeneratedId")!=null && rs.getString("userGeneratedId").equals(usergeneratedId)){
                     
                       return temp.temp=true;
                   }
               }
               return temp.temp=false;   
        }
        });
        //  InputStream binaryStream = resultSet.getBinaryStream(yourBlobColumnIndex);
         return temp.temp;
  }

    @Override
    public boolean checkPassword(VeinDetails loginveinDetails, int userId) {

         String queryDbPasword = "select * from handsvein where pk="+userId;
       HandsVeinDetails handsVeinDetailsfromDb  =(HandsVeinDetails)jdbcTemplate.queryForObject(queryDbPasword, new Object[]{userId}, new BeanPropertyRowMapper(HandsVeinDetails.class));
     return true;   
  //              String queryDbPasword = "select password from handsvein where pk="+userId;
//       
//         final Temp temp = new Temp();
//        jdbcTemplate.query(queryDbPasword, new ResultSetExtractor<Boolean>() {
//         @Override
//            public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
//             if(rs.next()){
//               //  InputStream is  = rs.getBinaryStream("password");
//                 byte imageBytesfromDb[] =  rs.getBytes("password");
//                 
//             try{
//                 //  int size=is.available();
//                        ImagePHash p= new ImagePHash();
//                        String strimagedb = p.getHash(new ByteArrayInputStream(imageBytesfromDb));
//                        String strimagetaken=p.getHash(new ByteArrayInputStream(imageBytes));
//                        Hamming hamming = new Hamming(strimagedb, strimagetaken);
//                        int hammingDistance  = hamming.getHammingDistance();
//                           System.out.println("hammimg distance "+hammingDistance);
//                           if(hammingDistance<5){
//                              temp.temp=true;
//                          }
//                          else{
//                              temp.temp=false;
//                          }
//                           System.out.println("Hamming Distance"+hammingDistance);
//                           
//                           
//                           
////                          ByteArrayOutputStream bos = new ByteArrayOutputStream();
////
////                          byte passwordBytes[]= new byte[size];
////                   
////                          while((is.read(passwordBytes, 0, size))!=-1){
////                              bos.write(passwordBytes, 0, size);
////                          }
////                          byte dbBytearray[] = bos.toByteArray();
////                          
////                          ImagePHash p= new ImagePHash();
////                          int hammingdistance = p.ImagePHash(dbBytearray,imageBytes);
////                          if(hammingdistance<5){
////                              temp.temp=true;
////                          }
////                          else{
////                              temp.temp=false;
////                          }
////                          boolean temp1=false;
////                          temp1=Arrays.equals(dbBytearray,imageBytes);
////                          System.out.println("tEmp value"+temp1);
//                    
//             }catch(IOException y){
//                 y.printStackTrace();
//                 temp.temp=false;
//             }
//             catch(Exception t){
//                 t.printStackTrace();
//                 temp.temp=false;
//             }
//          }
//            return temp.temp;
//          }
//        });
//        return temp.temp;
    }
    
     
        
    
    
}
abstract class AbstractLobPreparedStatementCreator implements PreparedStatementCreator{
        private final LobHandler lobHandler;
        private final String sql;
        private final String keyColumn;
        public AbstractLobPreparedStatementCreator(LobHandler lobHandler, String sql, String keyColumn) {
            this.lobHandler = lobHandler;
            this.sql = sql;
            this.keyColumn = keyColumn;
        }
        @Override
        public PreparedStatement createPreparedStatement(Connection cnctn) throws SQLException {
            PreparedStatement ps = cnctn.prepareStatement(sql, new String[] { keyColumn });
            LobCreator lobCreator = this.lobHandler.getLobCreator();
            setValues(ps, lobCreator);
            return ps;
        }
     protected abstract void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException, DataAccessException;
}

class Temp{
    boolean temp;
}