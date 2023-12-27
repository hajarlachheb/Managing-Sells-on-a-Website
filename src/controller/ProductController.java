package controller;
import Connection.DBConnect;
import Entite.Produit;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Entite.Produit;
import Entite.Utilisateur;



@Controller
public class ProductController {
@RequestMapping("/home.do")
public String Affichage() {
	return "index";
}
@RequestMapping("/login.do")
public String Login(@RequestParam(name="nomutilisateur") String Login, @RequestParam(name="motdepasse") String Password, Model model)
{
	DBConnect con = new DBConnect();
	if (con.TrouverUtilisateur(Login, Password)) {
		model.addAttribute("Login",Login);
		ArrayList<Produit> products = con.findAllProduct();
		model.addAttribute("Gestiondeproduit", products);
		return "produit";
	}
	model.addAttribute("msg","Votrer nom d'utilisateur ou mot de passe est incorrect :( ");
	return "index";
}
@RequestMapping("/AjouterProduit.do")
public String AjouterProduit(@RequestParam(name="NOM_PRODUIT") String NOM_PRODUIT, @RequestParam(name="PRIX") double PRIX, @RequestParam(name="FOURNISSEUR") String FOURNISSEUR, Model model) {
	DBConnect con = new DBConnect();
	if (con.AjouterProduit(NOM_PRODUIT, PRIX, FOURNISSEUR)) {
		model.addAttribute("msg", "Le produit a ete ajoute avec succes !");
		ArrayList<Produit> products = con.findAllProduct();
		Collections.reverse(products);
		model.addAttribute("produits", products);
		return "produit";
	}
	model.addAttribute("msg", "On n'a pas pu ajouter le produit :( ");
	return "produit";
}
@RequestMapping("/ModifierProduit.do")
public String ModifierProduit(@RequestParam(name="NOM_PRODUIT") String NOM_PRODUIT, @RequestParam(name="PRIX") double PRIX, @RequestParam(name="FOURNISSEUR") String FOURNISSEUR, Model model) {
	DBConnect con = new DBConnect();
	if (con.ModifierProduit(NOM_PRODUIT, PRIX, FOURNISSEUR)) {
		model.addAttribute("msg", "Le produit a ete modifie avec succes!");
		ArrayList<Produit> products = con.findAllProduct();
		Collections.reverse(products);
		model.addAttribute("produits", products);
		return "produit";
	}
	model.addAttribute("msg", "On n'a pas pu modifier le produit :( ");
	return "produit";
}
}
