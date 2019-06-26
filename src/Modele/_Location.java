package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

import BD.*;

public class _Location {
	
	public Location infoLocationL( Bien b)
	{
		Location l=new Location();
		Connexion cnx=new Connexion();
		
		try {
			cnx.rs=cnx.stat.executeQuery(RequeteClient.locationL( b));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		try {
			cnx.rs.next();
			l.setId(cnx.rs.getInt("id"));
			l.setCoutLocation(cnx.rs.getDouble("cout_location"));
			l.setDateDebut(cnx.rs.getDate("date_debut"));
			l.setDateFin(cnx.rs.getDate("date_fin"));
			l.setModalitéPaiement(cnx.rs.getString("modalite_payment"));
		}catch(SQLException e)
		{
			
		}
		return l;
		
	}
	public Location infoLocationP(Client c , Bien b)
	{
		Location l=new Location();
		Connexion cnx=new Connexion();
		
		try {
			cnx.rs=cnx.stat.executeQuery(RequeteClient.locationP(c, b));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		try {
			cnx.rs.next();
			l.setId(cnx.rs.getInt("id"));
			l.setCoutLocation(cnx.rs.getDouble("cout_location"));
			l.setDateDebut(cnx.rs.getDate("date_debut"));
			l.setDateFin(cnx.rs.getDate("date_fin"));
			l.setModalitéPaiement(cnx.rs.getString("modalite_payment"));
		}catch(SQLException e)
		{
			
		}
		return l;
		
	}
	
	public ArrayList<Paiement> infoPaiementL(Client c ,Bien b )
	{
		ArrayList<Paiement> list =new ArrayList<Paiement>();
		Connexion cnx=new Connexion();
		
		
		try {
			cnx.rs=cnx.stat.executeQuery(RequeteClient.paiementL(c, b));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		try {
			while(cnx.rs.next())
			{
				Paiement p=new Paiement();
				p.setId(cnx.rs.getInt("id"));
				p.setDatePaiement(cnx.rs.getDate("date_paiement"));
				p.setMonatantPaiement(cnx.rs.getDouble("montant_paye"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public ArrayList<Paiement> infoPaiementp(Client c , Location l )
	{
		ArrayList<Paiement> list =new ArrayList<Paiement>();
		Connexion cnx=new Connexion();
		Paiement p=new Paiement();
		
		try {
			cnx.rs=cnx.stat.executeQuery(RequeteClient.paiementP(c, l));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		try {
			while(cnx.rs.next())
			{
				p.setId(cnx.rs.getInt("id"));
				p.setDatePaiement(cnx.rs.getDate("date_paiment"));
				p.setMonatantPaiement(cnx.rs.getDouble("montant_paye"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}

}
