package Modele;

import java.sql.SQLException;
import java.util.ArrayList;
import BD.*;

public class _Rdv {
	
	public ArrayList<Rdv> mesRDV(String nomU)
	{
		ArrayList<Rdv> list =new ArrayList<Rdv>();
		Connexion cnx=new Connexion();
		
		
		try {
			cnx.rs=cnx.stat.executeQuery(RequeteClient.mesRdv(nomU));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		try {
			while(cnx.rs.next())
			{
				Rdv r=new Rdv();
				r.setId(cnx.rs.getInt("num"));
				r.setDateRDV(cnx.rs.getDate("date_rdv"));
				r.setHeureRDV(cnx.rs.getString("heure_rdv"));
				r.setLieuRDV(cnx.rs.getString("lieu_rdv"));
				r.setObjetRDV(cnx.rs.getString("objet_rdv"));
				r.setMoyenContact(cnx.rs.getString("moyen_contact"));
				r.setMessage(cnx.rs.getString("message"));
				r.setVu(cnx.rs.getBoolean("vu"));
				
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	
	


	public boolean modifieRdv(Rdv r)
	{
		Connexion cnx=new Connexion();
		
		try {
			return (cnx.stat.executeUpdate(RequeteClient.modifieRdv(r))==1 && cnx.Deconnexion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean ajouterRendezVous(Rdv r)
	{
		Connexion cnx =new Connexion();
		try {
				return (cnx.stat.executeUpdate(RequeteClient.ajouterRendezVous(r)) ==1 && cnx.Deconnexion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}


	


	public boolean supprimerRdv(int idrdv) {
		Connexion cnx=new Connexion();
		try {
			return (cnx.stat.executeUpdate(RequeteClient.supprimerRdv(idrdv))==1 && cnx.Deconnexion());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

}
