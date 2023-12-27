package Entite;

import java.io.Serializable;

public class Produit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5489168668532511633L;
	private int ID_PRODUIT;
	private String NOM_PRODUIT;
	private double PRIX;
	private String FOURNISSEUR;

	public Produit() {
		super();
	}
	public Produit(String NOM_PRODUIT, double PRIX) {
		super();
		this.NOM_PRODUIT = NOM_PRODUIT;
		this.PRIX = PRIX;
	}
	public int getIdProduit() {
		return ID_PRODUIT;
	}
	public void setIdProduit(int ID_PRODUIT) {
		this.ID_PRODUIT = ID_PRODUIT;
	}
	public String getNomProduit() {
		return NOM_PRODUIT;
	}
	public void setNomProduit(String NOM_PRODUIT) {
		this.NOM_PRODUIT = NOM_PRODUIT;
	}
	public double getPrix() {
		return PRIX;
	}
	public void setPrix(double PRIX) {
		this.PRIX = PRIX;
	}
	public String getFournisseur() {
		return FOURNISSEUR;
	}
	public void setFournisseur(String FOURNISSEUR) {
		this.FOURNISSEUR = FOURNISSEUR;
	}
	
	public Produit(int ID_PRODUIT, String NOM_PRODUIT, Double PRIX, String FOURNISSEUR) {
		super();
		this.ID_PRODUIT = ID_PRODUIT;
		this.NOM_PRODUIT = NOM_PRODUIT;
		this.PRIX = PRIX;
		this.FOURNISSEUR = FOURNISSEUR;
	}
	
	@Override
	public String toString() {
		return "Produit [ID_PRODUIT=" + ID_PRODUIT + ", NOM_PRODUIT=" + NOM_PRODUIT + ", PRIX=" + PRIX + ", FOURNISSEUR=" + FOURNISSEUR + "]";
	}
	
	
}

