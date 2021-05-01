

import DB.*;
import Model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class mediatheque {
    
	/*
	 * CRUD_Client cd; CRUD_Document dd; CRUD_Kindle dk;
	 */
    
    public mediatheque(){
		/*
		 * cd=new CRUD_Client(); dd=new CRUD_Document(); dk=new CRUD_Kindle();
		 */
    }
    
    //GETTERS DE CLIENT
    public Client getClientById(int idClient) throws ClassNotFoundException, SQLException{
    	Client cd= CRUD_Client.getClient(idClient);
        return cd;
    	
    }
    public ArrayList<Client> getClientByName(String Nom) throws ClassNotFoundException, SQLException{
    	Statement st =  CRUD_Client.con();
     	String requete = "SELECT * FROM client WHERE Nom ='"+Nom+"'";
         ResultSet rs = st.executeQuery(requete);
         ArrayList<Client> rs2 = (ArrayList<Client>) rs;
    	return  rs2;
    }
    
    public ArrayList<Client> getAllClients() throws ClassNotFoundException, SQLException{
    	ArrayList<Client> cd= CRUD_Client.getClients();
        return cd;
    }
    
    //GETTERS DE DOCUMENT
    public static Document getDocumentByISBN(String ISBN) throws ClassNotFoundException, SQLException {
    	Statement st =  CRUD_Client.con();
     	String requete = "SELECT * FROM document WHERE ISBN ='"+ISBN+"'";
         ResultSet rs = st.executeQuery(requete);
    	return (Document) rs;
    }
    public static ArrayList<Document> getDocumentByTitle(String titre) throws ClassNotFoundException, SQLException{
    	Statement st =  CRUD_Client.con();
     	String requete = "SELECT * FROM document WHERE Titre ='"+titre+"'";
         ResultSet rs = st.executeQuery(requete);
         ArrayList<Document> rs2 = (ArrayList<Document>) rs;
         return rs2;
    }
    public static    ArrayList<Document> getDocumentByEditor(String Editeur) throws ClassNotFoundException, SQLException{
    	Statement st =  CRUD_Client.con();
     	String requete = "SELECT * FROM document WHERE Editeur ='"+Editeur+"'";
         ResultSet rs = st.executeQuery(requete);
         ArrayList<Document> rs2 = (ArrayList<Document>) rs;
         return rs2;
    }
    public static ArrayList<Document> getDocumentByAnneEdition(int annee) throws ClassNotFoundException, SQLException{
    	Statement st =  CRUD_Client.con();
     	String requete = "SELECT * FROM document WHERE Annee ='"+annee+"'";
         ResultSet rs = st.executeQuery(requete);
         ArrayList<Document> rs2 = (ArrayList<Document>) rs;
         return rs2;
    }
    public static ArrayList<Document> getAllDocuments() throws ClassNotFoundException, SQLException{
         ArrayList<Document> rs2 = CRUD_Document.getDocuments();
         return rs2;
    }
    
    //GETTERS DE KINDLE
    public Kindle getKindleById(int idK) throws ClassNotFoundException, SQLException{
    	Kindle k =CRUD_Kindle.getKindle(idK);
        return k;
    }
    
    public ArrayList<Kindle> getKindleByModel(String Model) throws SQLException, ClassNotFoundException{
    	Statement st =  CRUD_Client.con();
    	String requete = "SELECT * FROM kindle WHERE Model ='"+Model+"'";
    	 ResultSet rs = st.executeQuery(requete);
    	  ArrayList<Kindle> rs2 = (ArrayList<Kindle>) rs;
        return  rs2;
        
    }
    
    public Kindle getKindleByMac(String Mac) throws ClassNotFoundException, SQLException{
    	Statement st =  CRUD_Client.con();
    	String requete = "SELECT * FROM kindle WHERE Mac ='"+Mac+"'";
    	 ResultSet rs = st.executeQuery(requete);
        return (Kindle) rs;
    }
    
    public ArrayList<Kindle> getAllKindles() throws ClassNotFoundException, SQLException{
    	ArrayList<Kindle> d=	CRUD_Kindle.getKindles();
        return null;
    } 
 

    //Client
    public Boolean ajouterClient(){
        //Saisir les informations de client
        //Client c=new Client();
        
        //return cd.ajouterClient(c);
        return false;
    }
    
   /* public Boolean modifierClient(Client c){
        
        return false;
    }*/
    
    public Boolean supprClient(int idClient){
        //return CRUD_Client.supprClient(idClient);
        return false;
        
    }
    //Document
    public Boolean ajouterDocument(Document d){
        //Saisir les informations de Document
        //Document d=new Document();
        
        //return cd.ajouterDocument(d);
        
        return false;
    }
    
    /*public Boolean modifierDocument(Document d){
        return false;
    }*/
    
    public Boolean supprDocument(int idDocument){
        //return CRUD_Document.supprDocument(idDocument);
        return false;
        
    }
    //Kindle
     public Boolean ajouterKindle(Kindle k){
        //Saisir les informations de kindle
        //Kindle k=new Kindle();
        
        //return cd.ajouterKindle(k);
        
        return false;
    }
    
    /*public Boolean modifierKindle(Kindle k){
        return false;
    }*/
    
    public Boolean supprKindle(int idKindle){
        //return CRUD_Kindle.supprKindle(idKindle);
        return false;
        
    }
    
    
    //Gestion des emprunts
    
    public Boolean ajouterEmprunt(Client c,Kindle k){
            //return CRUD_Emprunt.ajouterEmprunt(c,k);
            return false;
    }
    
    public Boolean rendreEmprunt(Emprunt e,Date d){
        //return CRUD_Emprunt.rendreEmprunt(e,d);
        return false;
    }
    
    public ArrayList<Kindle> KindlesNonRendu(){
        //return CRUD_Emprunt.KindlesNonRendu();
        return null;
    }
    
    public ArrayList<Emprunt> getEmpruntEnCour(){
        //return CRUD_Emprunt.getEmpruntEnCour();
        return null;
    }
    
    public Boolean SupprEmprunt(int IdEmprunt){
        //retun CRUD_Emprunt.SupprEmprunt(IdEmprunt);
        return false;
    }
    
    /*
        Gestion des communications avec les kindles
    
    */
    
    //////////////MAIN////////////////////
    public static void main(String []args) throws IOException{
        //afficher le menu au gerant
        //1)Gestion des clients
        //2)Gestion des kindles
        //3)Gestion des documents
        
}
}
