package Connection;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import org.springframework.stereotype.Repository;
import Entite.Produit;

@Repository
public class DBConnect extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static int iD;
	static final String url = "jdbc:mysql://localhost:3306/Gestiondeproduit";
	static final String username = "hajarlachheb";
	static final String password = "hajarlachheb";
	private Connection con;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	
	public DBConnect(){
		
		try {
			Class.forName(JDBC_DRIVER);
			this.con = (Connection) DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean TrouverUtilisateur(String nomutilisateur, String motdepasse) {
		boolean result = false;
		try {
			String query= "SELECT * FROM DBUSERS WHERE nomutilisateur=? AND motdepasse=?";
			PreparedStatement st = this.con.prepareStatement(query);
			 st.setString(1,nomutilisateur);
	            st.setString(2, motdepasse);
	            //st.execute();
	            //System.out.println(query);
	            ResultSet rs = st.executeQuery();
	            if(rs.next()) {
	            	result = true;
	            }
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

		public ArrayList<Produit> findAllProduct(){
		    ArrayList<Produit> productList = new ArrayList<Produit>();
		    try {
		        Statement st = this.con.createStatement();
		        ResultSet rs = st.executeQuery("SELECT * FROM  Gestiondeproduit ");
		        while(rs.next()){
		        	Produit product = new Produit(rs.getInt("ID_PRODUIT"),rs.getString("NOM_PRODUIT"),rs.getDouble("PRIX"),rs.getString("FOURNISSEUR"));
		        	productList.add(product);
		           }
		    }catch(Exception ex){
		    	System.out.println(ex.getMessage());
		    }
		    return productList;
		}
		
		public boolean AjouterProduit(String NOM_PRODUIT, double PRIX, String FOURNISSEUR) {
			boolean result = false;
			try {
				String query= "INSERT INTO Gestiondeproduit(NOM_PRODUIT,PRIX,FOURNISSEUR) VALUES (?,?,?)";
				PreparedStatement st = this.con.prepareStatement(query);
	            st.setString(1,NOM_PRODUIT);
	            st.setDouble(2, PRIX);
	            st.setString(3, FOURNISSEUR);
	            int affectedRows= st.executeUpdate();
	            if (affectedRows>0){
	            	result = true;
	            }
			}catch(SQLException e) {
				System.out.println(e.getMessage());
				
			} 
			return result;
			}
		public boolean ModifierProduit(String NOM_PRODUIT, Double PRIX, String FOURNISSEUR) {
			boolean result= false;
			try{
				String query= "UPDATE Gestiondeproduit SET NOM_PRODUIT=?, PRIX=?, FOURNISSEUR=? WHERE ID_PRODUIT=? ;";
				PreparedStatement st = this.con.prepareStatement(query);
				st.setString(1,NOM_PRODUIT);
				st.setDouble(2, PRIX);
				st.setString(3, FOURNISSEUR);
				st.setString(4, Integer.toString(iD));
				int affectedRows= st.executeUpdate();
				if (affectedRows>0){
					result = true;
				}
			}catch(Exception ex){
				System.out.println(ex.getMessage());}
			return result;
			}
		public boolean SupprimerProduit(int id){
			boolean result = false;
			try{
				String query= "DELETE FROM Gestiondeproduit WHERE ID_PRODUIT=? ;";
				PreparedStatement st = this.con.prepareStatement(query);
				st.setString(1, Integer.toString(iD));
	            int affectedRows= st.executeUpdate();
	            if (affectedRows>0){
					result = true;
				}
	            }catch(Exception ex){
	        	System.out.println(ex.getMessage());}
			return result;
			}
		}

