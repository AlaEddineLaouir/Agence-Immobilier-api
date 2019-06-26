package Modele;

import java.sql.Date;

public class Personne {
	protected String nomUtilisateur ;
	protected String nom;
	protected String prenom;
	protected String adr;
	protected Date dateNAi;
	protected int numTelephone;
	protected String numIdentité;
	protected String email;
	
	
	public Personne ()
	{
		
	}
	
	
	
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
	public Date getDateNAi() {
		return dateNAi;
	}
	public void setDateNAi(Date dateNAi) {
		this.dateNAi = dateNAi;
	}
	public int getNumTelephone() {
		return numTelephone;
	}
	public void setNumTelephone(int numTelephone) {
		this.numTelephone = numTelephone;
	}
	public String getNumIdentité() {
		return numIdentité;
	}
	public void setNumIdentité(String numIdentité) {
		this.numIdentité = numIdentité;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
