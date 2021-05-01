
package DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import Model.Client;
import Model.Kindle;
public class CRUD_Kindle {
    public static ArrayList<Kindle> getKindles() throws ClassNotFoundException, SQLException{
    	Statement st =  CRUD_Client.con();
    	String requete = "SELECT * FROM kindle";
        ResultSet rs = st.executeQuery(requete);
        ArrayList<Kindle> rs2 = (ArrayList<Kindle>) rs;
        return rs2;
    }
    public static Kindle getKindle(int id) throws ClassNotFoundException, SQLException{
    	Statement st =  CRUD_Client.con();
    	String requete = "SELECT * FROM kindle WHERE Id ='"+id+"'";
    	 ResultSet rs = st.executeQuery(requete);
        return (Kindle) rs;
        
    }
    
    //Kindle
     public void ajouterKindle(Kindle k) throws ClassNotFoundException, SQLException{
    	 Statement st =  CRUD_Client.con();
     	String requete = "INSERT INTO kindle (mac, modele)  VALUES ('"+k.getMac()+"',  '"+k.getModele()+"')";
     	 ResultSet rs = st.executeQuery(requete);
        
    }
    
    public boolean modifierKindle(Kindle k){
    	
        return false;
    }
    
    public void supprKindle(Kindle k) throws ClassNotFoundException, SQLException{
    	Statement st =  CRUD_Client.con();
    	String requete = "DELETE FROM kindle WHERE Id ='"+k.getMac()+ "'";
    	 ResultSet rs = st.executeQuery(requete);
        
    }
}
