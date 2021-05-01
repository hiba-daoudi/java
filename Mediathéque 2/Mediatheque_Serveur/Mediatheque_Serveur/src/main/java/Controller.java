
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

import DB.CRUD_Client;
import Model.*;

public class Controller {
	static void socket() throws IOException, SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiba", "root", "");
		Statement st = conn.createStatement();
		ServerSocket ss = new ServerSocket(3221);
		Socket s = ss.accept();

		System.out.println("client connected");
		DataInputStream input = new DataInputStream(s.getInputStream());
		DataOutputStream output = new DataOutputStream(s.getOutputStream());
		String msg = input.readUTF();
		System.out.println("Client : " + msg);
		String[] tab1 = msg.split("-");
		System.out.println("Client :" + tab1[0] + "bla bla " + tab1[1]);
		switch (tab1[0]) {
		case "1":
			ArrayList<Document> doc = mediatheque.getAllDocuments();
			break;
		case "2":
			Document doc1 = mediatheque.getDocumentByISBN(tab1[1]);
			break;
		case "3":
			ArrayList<Document> doc2 = mediatheque.getDocumentByTitle(tab1[1]);
			break;
		case "4":
			ArrayList<Document> doc3 = mediatheque.getDocumentByAnneEdition(Integer.valueOf(tab1[1]));
			break;
		case "5":
			ArrayList<Document> doc4 = mediatheque.getDocumentByEditor(tab1[1]);
			break;
		default:
			System.out.println("Client : " + tab1[1]);
			String tab[] = tab1[1].split(" ");
			System.out.println("1 " + tab[0] + " 2 " + tab[1]);
			String requete = "SELECT * FROM client WHERE login ='" + tab[0] + "'AND pwd ='" + tab[1] + "'";
			ResultSet rs = st.executeQuery(requete);
			if(rs.next()) {
				output.writeUTF("1"); 
			}else {
				output.writeUTF("0");
			}
			break;
		}
		

		/*
		 * Thread recevoir= new Thread(new Runnable() { String msg ; public ResultSet
		 * rs;
		 * 
		 * @Override public void run() { try { //tant que le client est connecté
		 * 
		 * msg = br.readLine(); while(msg!=null){ System.out.println("Client : "+msg);
		 * String[] tab1 = msg.split(".");
		 * System.out.println("Client :"+tab1[0]+"bla bla "+tab1[1]); switch(tab1[0]) {
		 * case "1": ArrayList<Document> doc = mediatheque.getAllDocuments(); break;
		 * case "2": Document doc1 = mediatheque.getDocumentByISBN(tab1[1]); break; case
		 * "3": ArrayList<Document> doc2 = mediatheque.getDocumentByTitle(tab1[1]);
		 * break; case "4": ArrayList<Document> doc3 =
		 * mediatheque.getDocumentByAnneEdition(Integer.valueOf(tab1[1])); break; case
		 * "5": ArrayList<Document> doc4 = mediatheque.getDocumentByEditor(tab1[1]);
		 * break; default : System.out.println("Client : "+tab1[1]); String tab[] =
		 * msg.split(" "); System.out.println("1 "+tab[0]+" 2 "+tab[1]); String requete
		 * = "SELECT * FROM client WHERE login ='"+tab[0]+"'AND pwd ='"+tab[1]+"'"; rs =
		 * st.executeQuery(requete); break; } msg = br.readLine(); }
		 * 
		 * 
		 * 
		 * } catch (IOException e) { e.printStackTrace(); } catch (SQLException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (NumberFormatException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (ClassNotFoundException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } } }); recevoir.start();
		 */
		/*
		 * OutputStream outp = s.getOutputStream(); PrintWriter pr = new
		 * PrintWriter(outp); Thread envoi= new Thread(new Runnable() {
		 * 
		 * @Override public void run() {
		 * 
		 * try { ResultSet rs; if(rs.next()) { pr.write("1"); pr.flush(); pr.close();
		 * }else { pr.write("0"); pr.flush(); pr.close(); } } catch (SQLException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * String msg = null; pr.write(msg); pr.flush(); pr.close();
		 * 
		 * }
		 * 
		 * }); envoi.start();
		 */
	}

	public static void main(String args[]) throws IOException, SQLException, ClassNotFoundException {
		Controller.socket();
	}
}
