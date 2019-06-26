package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

import BD.Connexion;

import BD.RequeteClient;

public class _Client {
	
	public boolean ajouterClient(Client c)
	{
		Connexion cnx=new Connexion();
		try {
			
				return (cnx.stat.executeUpdate(RequeteClient.ajouterClient(c))==1 && cnx.Deconnexion()  );
			
		}catch(SQLException e)
		{
			return false;
		}
		
	}
	
	
	public boolean modifieClient(Client c)
	{
		Connexion cnx=new Connexion();
		
		try {
			
			return (cnx.stat.executeUpdate(RequeteClient.modifieClient(c))==1 && cnx.Deconnexion());
		}catch(SQLException e)
		{
			return false;
		}
	}
	
	public Client existeClient(Client c)
	{
		Connexion cnx=new Connexion();
		Client cl=null; 
		try {
			
			cnx.rs= cnx.stat.executeQuery(RequeteClient.existeClient(c));
			cnx.rs.next();
			cl=new Client();
			cl.setNomUtilisateur(cnx.rs.getString("nom_utilisateur"));
			cl.setMoteDePasse(cnx.rs.getString("mot_passe"));
			cl.setNom(cnx.rs.getString("nom"));
			cl.setPrenom(cnx.rs.getString("prenom"));
			cl.setAdr(cnx.rs.getString("adress"));
			cl.setDateNAi(cnx.rs.getDate("date_naissance"));
			cl.setNumTelephone(cnx.rs.getInt("telephone"));
			cl.setEmail(cnx.rs.getString("email"));
			cl.setNumIdentité(cnx.rs.getString("num_identite"));
			return cl;
			}catch(SQLException e)
			{
				e.printStackTrace();
				return null;
				
			}finally {
				try {
					cnx.Deconnexion();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

	

	public boolean validerEdentite(String numIdentite, String nomUtilisateur) {
		Connexion cnx=new Connexion();
		try {
			
			if(nomUtilisateur == null)
			{
				System.out.println("SELECT num_identite FROM client WHERE num_identite LIKE '"+numIdentite+"' ;");
				cnx.rs=cnx.stat.executeQuery("SELECT num_identite FROM client WHERE num_identite LIKE '"+numIdentite+"' ;");
			}else {
				System.out.println("SELECT num_identite FROM client WHERE num_identite LIKE '"+numIdentite+"'  AND nom_utilisateur NOT LIKE '"+nomUtilisateur+"'   ;");
				cnx.rs=cnx.stat.executeQuery("SELECT num_identite FROM client WHERE num_identite LIKE '"+numIdentite+"'  AND nom_utilisateur NOT LIKE '"+nomUtilisateur+"'   ;");
			}
			
			return (! cnx.rs.next());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean validertelephone(int num, String nomUtilisateur) {
		
		Connexion cnx=new Connexion();
		try {
			if(nomUtilisateur == null)
			{
				System.out.println("SELECT telephone FROM client WHERE telephone = "+num+" ;");
				cnx.rs=cnx.stat.executeQuery("SELECT telephone FROM client WHERE telephone = "+num+" ;");
			}else
			{
				System.out.println("SELECT telephone FROM client WHERE telephone = "+num+" AND nom_utilisateur NOT LIKE '"+nomUtilisateur+"'  ;");
				cnx.rs=cnx.stat.executeQuery("SELECT telephone FROM client WHERE telephone = "+num+" AND nom_utilisateur NOT LIKE '"+nomUtilisateur+"'  ;");
			}
			return (! cnx.rs.next());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean validerEmail(String email, String nomUtilisateur) {
		Connexion cnx=new Connexion();
		try {
			if(nomUtilisateur != null)
			{
				System.out.println("SELECT email FROM client WHERE email LIKE '"+email+"' AND nom_utilisateur NOT LIKE '"+nomUtilisateur+"' ;");
				cnx.rs=cnx.stat.executeQuery("SELECT email FROM client WHERE email LIKE '"+email+"' AND nom_utilisateur NOT LIKE '"+nomUtilisateur+"' ;");
			}
			else
			{
				System.out.println("SELECT email FROM client WHERE email LIKE '"+email+"';");
				cnx.rs=cnx.stat.executeQuery("SELECT email FROM client WHERE email LIKE '"+email+"' ;");
			}
			return (! cnx.rs.next());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	public boolean validerNomUtilisateur(String nomUtilisateur) {
		Connexion cnx=new Connexion();
		try {
			System.out.println("SELECT nom_utilisateur FROM client WHERE nom_utilisateur LIKE '"+nomUtilisateur+"' ;");
			cnx.rs=cnx.stat.executeQuery("SELECT nom_utilisateur FROM client WHERE nom_utilisateur LIKE '"+nomUtilisateur+"' ;");
			return ( cnx.rs.next());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	

}
