/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handsveindetection.db;

import org.springframework.core.io.FileSystemResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Amar
 */
public class HandsVeinDBInstantiate {
    static HandsVeinDao handsVeinDao=null;
     
   static String url = "handsveindetection\\resources\\handsveinbean.xml";//C:\\Users\\Amar\\Documents\\NetBeansProjects\\temp\\HandsVeinDetection\\src\\handsveindetection\\resources\\handsveinbean.xml";
  
   
   public static  HandsVeinDao getHandsVeinDao(){
        if(handsVeinDao==null){
            ApplicationContext factory =new ClassPathXmlApplicationContext(url);  
          
            handsVeinDao  =(HandsVeinDao)factory.getBean("handsVeinDaoImpl"); 
//            //BeanFactory beans = new XmlBeanFactory(new FileSystemResource(url));
//            ApplicationContext beans = new ClassPathXmlApplicationContext(new FileSystemResource(url));
//            
//            handsVeinDao      =(HandsVeinDao) beans.getBean("handsVeinDaoImpl");
//            return handsVeinDao;
        }
        return handsVeinDao;
    }
     
}
