
package DB;
import Model.Client;
import Model.Document;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class CRUD_Document {
     public static ArrayList<Document> getDocuments() throws ClassNotFoundException, SQLException{
    	 Statement st =  CRUD_Client.con();
     	String requete = "SELECT * FROM document";
         ResultSet rs = st.executeQuery(requete);
         ArrayList<Document> rs2 = (ArrayList<Document>) rs;
 		return rs2;
    }
    public Document getDocument(int id) throws ClassNotFoundException, SQLException{
    	Statement st =  CRUD_Client.con();
     	String requete = "SELECT * FROM document WHERE Id ='"+id+"'";
         ResultSet rs = st.executeQuery(requete);
 		return (Document) rs;

    }
    //Document
    public boolean ajouterDocument(Document d) throws ClassNotFoundException, SQLException{
    	Statement st =  CRUD_Client.con();
    	String requete = "INSERT INTO document (annee, Editeur, ISBN,titre)  VALUES ('"+d.getAnneeEdition()+"', '"+d.getEditeur()+"', '"+d.getISBN()+"','"+d.getTitre()+"')";
    	 ResultSet rs = st.executeQuery(requete);
        return false;
    }
    
    public boolean modifierDocument(Document d){
        return false;
    }
    
    public boolean supprDocument(int idDocument){
        
        return false;
    }

}
