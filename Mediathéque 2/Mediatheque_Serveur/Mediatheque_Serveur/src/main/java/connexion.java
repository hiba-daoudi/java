import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class connexion {
 
 
 public static Connection getconnexion() {
	 String urlpilote = "com.mysql.cj.jdbc.Driver";
	 String urlbase = "jdbc:mysql://localhost:3306/hiba?zeroDateTimeBehavior=CONVERT_TO_NULL ";
	 Connection conn = null;
     try{
       Class.forName(urlpilote) ; 
 }catch (ClassNotFoundException ex){
     Logger.getLogger(connexion.class.getName()).log(Level.SEVERE , null , ex);
 }
     try{
       conn = DriverManager.getConnection(urlbase , "hiba" , "") ; 
 }catch (SQLException ex){
     Logger.getLogger(connexion.class.getName()).log(Level.SEVERE , null , ex);
 }
     return conn;
 }
  
 
}
