/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class CRUD_Client {
	public static Statement  con() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver") ; 
	   Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/hiba" , "root" , "")  ;
	   Statement st = conn.createStatement();
	   return st;
	}
    public static ArrayList<Client> getClients() throws ClassNotFoundException, SQLException{
    	Statement st =  CRUD_Client.con();
    	String requete = "SELECT * FROM client";
        ResultSet rs = st.executeQuery(requete);
        ArrayList<Client> rs2 = (ArrayList<Client>) rs;
		return rs2;
    }
    public static Client getClient(int id) throws ClassNotFoundException, SQLException{
    	Statement st =  CRUD_Client.con();
    	String requete = "SELECT * FROM client WHERE Id ='"+id+"'";
    	 ResultSet rs = st.executeQuery(requete);
        return (Client) rs;
    }
     //Client
    public void ajouterClient(Client c) throws ClassNotFoundException, SQLException{
    	Statement st =  CRUD_Client.con();
    	String requete = "INSERT INTO client (prenom, nom, age)  VALUES ('"+c.getPrenom()+"', '"+c.getNom()+"', '"+c.getAge()+"')";
    	 ResultSet rs = st.executeQuery(requete);

    }
    
   /* public Boolean modifierClient(Client c){
        return false;
    }*/
    
    public void supprClient(int idClient) throws ClassNotFoundException, SQLException{
    	Statement st =  CRUD_Client.con();
    	String requete = "DELETE FROM client WHERE Id ='"+idClient+ "'";
    	 ResultSet rs = st.executeQuery(requete);
        
        
    }

}
