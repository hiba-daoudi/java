
import Model.*;

import java.io.*;
import java.net.*;
import java.util.*;


public class Kindle {
    
    
    


	public static Socket Connexion() throws UnknownHostException, IOException{
        //Suivi de la localisation
    	 Socket s = new Socket("localhost",3221);
    	 
        return s;
    }
    
    public static Boolean Authentification() throws IOException{
    	Socket s = Kindle.Connexion();
    	DataInputStream input = new DataInputStream (s.getInputStream());
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
    	System.out.println("ecrire votre login et mdp separe par un espace");
    	BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String msg = br.readLine();
        String g = "9-"+msg;
        output.writeUTF(g);
         
        String z = input.readUTF();
        String x = "1";
        System.out.println(z);
        if (z.equals(x)) { System.out.println("gg"); 
        return true;
        }else {
         System.out.println("verifier login et mdp"); 
 		return false;
        }

       
       

    }
    
    //GETTERS DE DOCUMENT
    public static Document getDocumentByISBN() throws IOException{
    	Socket s = Kindle.Connexion();
    	System.out.println("Donner l ISBN du doc  :");
    	BufferedReader br = new BufferedReader( new InputStreamReader(System.in)); 
		  String ISBN =br.readLine();
    	String msg = "2-"+ISBN;
    	ObjectInputStream input = new ObjectInputStream (s.getInputStream());
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        output.writeUTF(msg);
    	
    	
        return null;
    }
    public static ArrayList<Document> getDocumentByTitle() throws IOException{
    	Socket s = Kindle.Connexion();
    	System.out.println("Donner le titre du doc :");
    	BufferedReader br = new BufferedReader( new InputStreamReader(System.in)); 
		  String titre =br.readLine();
    	String msg = "3-"+titre;
    	ObjectInputStream input = new ObjectInputStream (s.getInputStream());
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        output.writeUTF(msg);
        return null;
    }
    
    public static    ArrayList<Document> getDocumentByEditor() throws IOException{
    	Socket s = Kindle.Connexion();
    	System.out.println("Donner le nom de editeur :");
    	BufferedReader br = new BufferedReader( new InputStreamReader(System.in)); 
		  String Editeur =br.readLine();
    	String msg = "5-"+Editeur;
    	ObjectInputStream input = new ObjectInputStream (s.getInputStream());
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        output.writeUTF(msg);
        return null;
    }
  
    public static ArrayList<Document> getDocumentByAnneEdition() throws IOException{
    	Socket s = Kindle.Connexion();
    	System.out.println("Donner l'annee de edition :");
    	BufferedReader br = new BufferedReader( new InputStreamReader(System.in)); 
		  String annee =br.readLine();
    	String msg = "4-"+annee;
    	ObjectInputStream input = new ObjectInputStream (s.getInputStream());
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        output.writeUTF(msg);
        return null;
    }
    public static ArrayList<Document> getAllDocuments() throws IOException, ClassNotFoundException{
    	Socket s = Kindle.Connexion();
    	String msg = "1- ";
    	ObjectInputStream input = new ObjectInputStream (s.getInputStream());
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        output.writeUTF(msg);
        Object O = input.readObject();
        return null;
    }
    
    
    public static void main(String []args) throws UnknownHostException, IOException{
         
    	 boolean B = false;
do {
    	 B=Kindle.Authentification();
}while(B==false);
         
        /* 
		System.out.println("si vous voulez afficher tous les documents tapez 1\n"
				+ "si vous voulez chercher un document par son ISBN tapez 2\n"
				+ "si vous voulez chercher un document par son titre tapez 3\n"
				+ "si vous voulez chercher un document par son année d'edition tapez 4\n"
				+ "si vous voulez chercher un document par son editeur tapez 5\n");
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in)); 
		  String msg =br.readLine();
		switch(msg) {
		  case "1":
			  ArrayList<Document> doc = Kindle.getAllDocuments();
		    break;
		  case "2":
		      Document doc1 = Kindle.getDocumentByISBN();
		    break;
		  case "3":
			  ArrayList<Document> doc2 = Kindle.getDocumentByTitle();
		  break;
		  case "4":
			  ArrayList<Document> doc3 =  Kindle.getDocumentByAnneEdition();
		  break;
		  case "5":
			  ArrayList<Document> doc4 =  Kindle.getDocumentByEditor();
		  break;
		}
		 
    }*/}
}
