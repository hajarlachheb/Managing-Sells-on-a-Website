package Entite;

public class Utilisateur {

	private String nomutilisateur;
	private String motdepasse;
	

	public String getusername() {
		return nomutilisateur;
	}

	public void setusername(String nomutilisateur) {
		this.nomutilisateur = nomutilisateur;
	}

	public String getpswd() {
		return motdepasse;
	}

	public void setpswd(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public Utilisateur(String nomutilisateur, String motdepasse) {
		super();
		this.nomutilisateur = nomutilisateur;
		this.motdepasse = motdepasse;
	}
	
}
