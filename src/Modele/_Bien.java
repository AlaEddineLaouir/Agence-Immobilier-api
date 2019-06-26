package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

import BD.*;

public class _Bien {
	public static final int MESLOCATION=0;
	public static final int MESBIENLOUER=1;
	public static final int MESBIENNONLOUER=2;
	
	
	public ArrayList<Apartement> mesApartement(Client c , int type)
	{
		ArrayList<Apartement> list =new ArrayList<Apartement>();
		Connexion cnx=new Connexion();
		
		try {
			switch(type)
			{
			case MESLOCATION :
							cnx.rs=cnx.stat.executeQuery(RequeteClient.aparLouer(c));
				break;
			case MESBIENLOUER :
							cnx.rs=cnx.stat.executeQuery(RequeteClient.mesAparLouer(c));
				break;
			case MESBIENNONLOUER :
							cnx.rs=cnx.stat.executeQuery(RequeteClient.mesAparNonLouer(c));
			    break;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		try {
			while(cnx.rs.next())
			{
				Apartement a=new Apartement();
				a.setId(cnx.rs.getInt("id"));
				a.setVille(cnx.rs.getString("ville"));
				a.setAdr(cnx.rs.getString("adress"));
				a.setPrix(cnx.rs.getDouble("prix"));
				a.setSurface(cnx.rs.getDouble("surface"));
				a.setEmplacement(cnx.rs.getString("emplacement"));
				a.setDescAgent(cnx.rs.getString("desc_agent"));
				a.setEtage(cnx.rs.getInt("etage"));
				a.setNombrePiece(cnx.rs.getInt("nombre_piece"));
				a.setClimatisation(cnx.rs.getBoolean("climatisation"));
				a.setMeubler(cnx.rs.getBoolean("meuble"));
				a.setBalcon(cnx.rs.getBoolean("balcon"));
				a.setStationnement(cnx.rs.getBoolean("stationement"));
				a.setCacher(cnx.rs.getBoolean("cacher"));
				a.setType(cnx.rs.getString("type"));
				list.add(a);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public  ArrayList<Villa> mesVilla(Client c ,int type)
	{
		ArrayList<Villa> list =new ArrayList<Villa>();
		Connexion cnx =new Connexion();
		
		
		try {
			switch(type)
			{	
			case MESLOCATION :
						cnx.rs=cnx.stat.executeQuery(RequeteClient.villaLouer(c));
						break;
			case MESBIENLOUER :
						cnx.rs=cnx.stat.executeQuery(RequeteClient.mesVillaLouer(c));
						break;
			case MESBIENNONLOUER :
						cnx.rs=cnx.stat.executeQuery(RequeteClient.mesVillaNonLouer(c));
						break;
			
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		
		try {
			while(cnx.rs.next())
			{
				Villa v =new Villa();
				v.setId(cnx.rs.getInt("id"));
				v.setVille(cnx.rs.getString("ville"));
				v.setAdr(cnx.rs.getString("adress"));
				v.setPrix(cnx.rs.getDouble("prix"));
				v.setSurface(cnx.rs.getDouble("surface"));
				v.setEmplacement(cnx.rs.getString("emplacement"));
				v.setDescAgent(cnx.rs.getString("desc_agent"));
				v.setNombreEtage(cnx.rs.getInt("nombre_etage"));
				v.setNombrePiece(cnx.rs.getInt("nombre_piece"));
				v.setPicine(cnx.rs.getBoolean("picine"));
				v.setGarage(cnx.rs.getBoolean("garage"));
				v.setJardin(cnx.rs.getBoolean("jardin"));
				v.setClimatisation(cnx.rs.getBoolean("climatisation"));
				v.setMeubler(cnx.rs.getBoolean("meuble"));
				v.setAlarm(cnx.rs.getBoolean("alarm"));
				v.setChemine(cnx.rs.getBoolean("chemine"));
				v.setInterPhone(cnx.rs.getBoolean("interPhone"));
				v.setCacher(cnx.rs.getBoolean("cacher"));
				v.setType(cnx.rs.getString("type"));
				list.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
	
	public ArrayList<Locale> meslocale(Client c , int type)
	{
		Connexion cnx =new Connexion();
		
		ArrayList<Locale> list = new ArrayList<Locale>();
		
		try {
			switch(type)
			{
			case MESLOCATION :
					cnx.rs=cnx.stat.executeQuery(RequeteClient.localeLouer(c));
				break;
			case MESBIENLOUER :
					cnx.rs=cnx.stat.executeQuery(RequeteClient.mesLocaleLouer(c));
				break;
			case MESBIENNONLOUER :
					cnx.rs=cnx.stat.executeQuery(RequeteClient.mesLocaleNonLouer(c));
				break;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		
		try {
			while(cnx.rs.next())
			{
				Locale l=new Locale();
				l.setId(cnx.rs.getInt("id"));
				l.setVille(cnx.rs.getString("ville"));
				l.setAdr(cnx.rs.getString("adress"));
				l.setPrix(cnx.rs.getDouble("prix"));
				l.setSurface(cnx.rs.getDouble("surface"));
				l.setEmplacement(cnx.rs.getString("emplacement"));
				l.setDescAgent(cnx.rs.getString("desc_agent"));
				l.setFinisInt(cnx.rs.getBoolean("finis_int"));
				l.setFinisExt(cnx.rs.getBoolean("finis_ext"));
				l.setEquipeElec(cnx.rs.getBoolean("equiper_elec"));
				l.setEquiperGas(cnx.rs.getBoolean("equiper_gas"));
				l.setStationnement(cnx.rs.getBoolean("stationement"));
				l.setAlarm(cnx.rs.getBoolean("alarm"));
				l.setCacher(cnx.rs.getBoolean("cacher"));
				l.setType(cnx.rs.getString("type"));
				list.add(l);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}

	public ArrayList<Lot_Terrin> mesLotTerrin(Client c , int type)
	{
		Connexion cnx=new Connexion();
		
		ArrayList<Lot_Terrin> list=new ArrayList<Lot_Terrin>();
		
		try {
			switch(type)
			{
			case MESLOCATION :
					cnx.rs=cnx.stat.executeQuery(RequeteClient.lotTerrinLouer(c));
				break;
			case MESBIENLOUER :
					cnx.rs=cnx.stat.executeQuery(RequeteClient.mesLotTerrinLouer(c));
				break;
			case MESBIENNONLOUER :
					cnx.rs=cnx.stat.executeQuery(RequeteClient.mesLotTerrinNonLouer(c));
				break;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		
		try {
			while(cnx.rs.next())
			{
				Lot_Terrin lt=new Lot_Terrin();
				lt.setId(cnx.rs.getInt("id"));
				lt.setVille(cnx.rs.getString("ville"));
				lt.setAdr(cnx.rs.getString("adress"));
				lt.setPrix(cnx.rs.getDouble("prix"));
				lt.setSurface(cnx.rs.getDouble("surface"));
				lt.setEmplacement(cnx.rs.getString("emplacement"));
				lt.setDescAgent(cnx.rs.getString("desc_agent"));
				lt.setAgricol(cnx.rs.getBoolean("agricole"));
				lt.setCacher(cnx.rs.getBoolean("cacher"));
				lt.setType(cnx.rs.getString("type"));
				list.add(lt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	


	
	public  ArrayList<Bien> chercherLotTerrin(Lot_Terrin l , int pmin,int pmax,int smin,int smax)
	{
		 ArrayList<Bien> list =new  ArrayList<Bien>();
		 
		 Connexion cnx=new Connexion();
		 
		 try {
			cnx.rs=cnx.stat.executeQuery(RequeteClient.chercheLotTerrin(l, pmin, pmax, smin, smax));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 try {
				while(cnx.rs.next())
				{
					Lot_Terrin lt=new Lot_Terrin();
					lt.setId(cnx.rs.getInt("id"));
					lt.setVille(cnx.rs.getString("ville"));
					lt.setAdr(cnx.rs.getString("adress"));
					lt.setPrix(cnx.rs.getDouble("prix"));
					lt.setSurface(cnx.rs.getDouble("surface"));
					lt.setEmplacement(cnx.rs.getString("emplacement"));
					lt.setDescAgent(cnx.rs.getString("desc_agent"));
					lt.setAgricol(cnx.rs.getBoolean("agricole"));
					list.add(lt);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		 
	}

	public  ArrayList<Bien> chercherLocale(Locale ll , int pmin,int pmax,int smin,int smax)
	{
		 
		
		 Connexion cnx=new Connexion();
		 
		 try {
			cnx.rs=cnx.stat.executeQuery(RequeteClient.chercheLocale(ll, pmin, pmax, smin, smax));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 
		 ArrayList<Bien> list =new  ArrayList<Bien>();
		 try {
				while(cnx.rs.next())
				{
					 Locale l =new Locale();
					l.setId(cnx.rs.getInt("id"));
					l.setVille(cnx.rs.getString("ville"));
					l.setAdr(cnx.rs.getString("adress"));
					l.setPrix(cnx.rs.getDouble("prix"));
					l.setSurface(cnx.rs.getDouble("surface"));
					l.setEmplacement(cnx.rs.getString("emplacement"));
					l.setDescAgent(cnx.rs.getString("desc_agent"));
					l.setFinisInt(cnx.rs.getBoolean("finis_int"));
					l.setFinisExt(cnx.rs.getBoolean("finis_ext"));
					l.setEquipeElec(cnx.rs.getBoolean("equiper_elec"));
					l.setEquiperGas(cnx.rs.getBoolean("equiper_gas"));
					l.setStationnement(cnx.rs.getBoolean("stationement"));
					l.setAlarm(cnx.rs.getBoolean("alarm"));
					
					list.add(l);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
	}
	
	public  ArrayList<Bien> chercherVilla(Villa ll , int pmin,int pmax,int smin,int smax)
	{
		ArrayList<Bien> list =new ArrayList<Bien>();
		Villa v=new Villa();
		Connexion cnx=new Connexion();
		
		try {
			cnx.rs=cnx.stat.executeQuery(RequeteClient.chercheVilla(ll, pmin, pmax, smin, smax));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			while(cnx.rs.next())
			{
				v.setId(cnx.rs.getInt("id"));
				v.setVille(cnx.rs.getString("ville"));
				v.setAdr(cnx.rs.getString("adress"));
				v.setPrix(cnx.rs.getDouble("prix"));
				v.setSurface(cnx.rs.getDouble("surface"));
				v.setEmplacement(cnx.rs.getString("emplacement"));
				v.setDescAgent(cnx.rs.getString("desc_agent"));
				v.setNombreEtage(cnx.rs.getInt("nombre_etage"));
				v.setNombrePiece(cnx.rs.getInt("nombre_piece"));
				v.setPicine(cnx.rs.getBoolean("picine"));
				v.setGarage(cnx.rs.getBoolean("garage"));
				v.setJardin(cnx.rs.getBoolean("jardin"));
				v.setClimatisation(cnx.rs.getBoolean("climatisation"));
				v.setMeubler(cnx.rs.getBoolean("meuble"));
				v.setAlarm(cnx.rs.getBoolean("alarm"));
				v.setChemine(cnx.rs.getBoolean("chemine"));
				v.setInterPhone(cnx.rs.getBoolean("interPhone"));
				list.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
	
	/*public  ArrayList<Bien> chercherApartement(Apartement ll , int pmin,int pmax,int smin,int smax)
	{
		ArrayList<Bien> list =new ArrayList<Bien>();
		Apartement a=new Apartement();
		Connexion cnx=new Connexion();
		
		try {
			cnx.rs=cnx.stat.executeQuery(RequeteClient.chercheApar(ll, pmin, pmax, smin, smax));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			while(cnx.rs.next())
			{
				
				a.setId(cnx.rs.getInt("id"));
				a.setVille(cnx.rs.getString("ville"));
				a.setAdr(cnx.rs.getString("adress"));
				a.setPrix(cnx.rs.getDouble("prix"));
				a.setSurface(cnx.rs.getDouble("surface"));
				a.setEmplacement(cnx.rs.getString("emplacement"));
				a.setDescAgent(cnx.rs.getString("desc_agent"));
				a.setEtage(cnx.rs.getInt("etage"));
				a.setNombrePiece(cnx.rs.getInt("nombre_piece"));
				a.setClimatisation(cnx.rs.getBoolean("climatisation"));
				a.setMeubler(cnx.rs.getBoolean("meuble"));
				a.setBalcon(cnx.rs.getBoolean("balcon"));
				a.setStationnement(cnx.rs.getBoolean("stationement"));
				list.add(a);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	

	/*public Bien detailleBien(Bien b , String type)
	{
		
		Connexion cnx=new Connexion();
		try {
			cnx.rs=cnx.stat.executeQuery(RequeteClient.chercherById(b.getId(), type));
		} catch (SQLException e) {
			e.printStackTrace();
			return b;
		}
		switch(type)
		{
		case "apar":
		{
			Apartement a=new Apartement();
			try {
				
				while(cnx.rs.next())
				{
					
					a.setId(cnx.rs.getInt("id"));
					a.setVille(cnx.rs.getString("ville"));
					a.setAdr(cnx.rs.getString("adress"));
					a.setPrix(cnx.rs.getDouble("prix"));
					a.setSurface(cnx.rs.getDouble("surface"));
					a.setEmplacement(cnx.rs.getString("emplacement"));
					a.setDescAgent(cnx.rs.getString("desc_agent"));
					a.setEtage(cnx.rs.getInt("etage"));
					a.setNombrePiece(cnx.rs.getInt("nombre_piece"));
					a.setClimatisation(cnx.rs.getBoolean("climatisation"));
					a.setMeubler(cnx.rs.getBoolean("meuble"));
					a.setBalcon(cnx.rs.getBoolean("balcon"));
					a.setStationnement(cnx.rs.getBoolean("stationement"));
					return a;
					
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}break;
		case "Lot" :
		{
			Lot_Terrin lt =new Lot_Terrin();
			try {
				while(cnx.rs.next())
				{
					lt.setId(cnx.rs.getInt("id"));
					lt.setVille(cnx.rs.getString("ville"));
					lt.setAdr(cnx.rs.getString("adress"));
					lt.setPrix(cnx.rs.getDouble("prix"));
					lt.setSurface(cnx.rs.getDouble("surface"));
					lt.setEmplacement(cnx.rs.getString("emplacement"));
					lt.setDescAgent(cnx.rs.getString("desc_agent"));
					lt.setAgricol(cnx.rs.getBoolean("agricole"));
					return lt;
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}break;
		case "villa" :
		{
			Villa v=new Villa();
			try {
				while(cnx.rs.next())
				{
					v.setId(cnx.rs.getInt("id"));
					v.setVille(cnx.rs.getString("ville"));
					v.setAdr(cnx.rs.getString("adress"));
					v.setPrix(cnx.rs.getDouble("prix"));
					v.setSurface(cnx.rs.getDouble("surface"));
					v.setEmplacement(cnx.rs.getString("emplacement"));
					v.setDescAgent(cnx.rs.getString("desc_agent"));
					v.setNombreEtage(cnx.rs.getInt("nombre_etage"));
					v.setNombrePiece(cnx.rs.getInt("nombre_piece"));
					v.setPicine(cnx.rs.getBoolean("picine"));
					v.setGarage(cnx.rs.getBoolean("garage"));
					v.setJardin(cnx.rs.getBoolean("jardin"));
					v.setClimatisation(cnx.rs.getBoolean("climatisation"));
					v.setMeubler(cnx.rs.getBoolean("meuble"));
					v.setAlarm(cnx.rs.getBoolean("alarm"));
					v.setChemine(cnx.rs.getBoolean("chemine"));
					v.setInterPhone(cnx.rs.getBoolean("interPhone"));
					return v;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}break;
		case "locale" :
		{
			Locale l=new Locale();
			try {
				while(cnx.rs.next())
				{
					l.setId(cnx.rs.getInt("id"));
					l.setVille(cnx.rs.getString("ville"));
					l.setAdr(cnx.rs.getString("adress"));
					l.setPrix(cnx.rs.getDouble("prix"));
					l.setSurface(cnx.rs.getDouble("surface"));
					l.setEmplacement(cnx.rs.getString("emplacement"));
					l.setDescAgent(cnx.rs.getString("desc_agent"));
					l.setFinisInt(cnx.rs.getBoolean("finis_int"));
					l.setFinisExt(cnx.rs.getBoolean("finis_ext"));
					l.setEquipeElec(cnx.rs.getBoolean("equiper_elec"));
					l.setEquiperGas(cnx.rs.getBoolean("equiper_gas"));
					l.setStationnement(cnx.rs.getBoolean("stationement"));
					l.setAlarm(cnx.rs.getBoolean("alarm"));
					
					return l;
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}break;
		
		}
		return b;
	}*/
	public boolean suprrimerBien(Bien b)
	{
		 Connexion cnx=new Connexion();
		 try {
				return (cnx.stat.executeUpdate(RequeteClient.supprimerBien(b))==1 && cnx.Deconnexion());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		
	}

	public boolean modifieBien(Bien b) {
		
		 Connexion cnx=new Connexion();
		 try {
				return (cnx.stat.executeUpdate(RequeteClient.modifieBien(b))==1 && cnx.Deconnexion());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		
	}

	public int ajouterBien(Client c, Bien b) throws SQLException{
		Connexion cnx = new Connexion();
		int id=0;
		
			if(cnx.stat.executeUpdate(RequeteClient.ajouterBien(c,b))==1)
			{
				cnx.rs=cnx.stat.executeQuery(RequeteClient.idBien(b));
				cnx.rs.next();
				id=cnx.rs.getInt("ref");
				return id;
			}
		
		return id;
	}

	public boolean existeBien(String adress) {
		Connexion cnx=new Connexion();
		try {
			cnx.rs=cnx.stat.executeQuery("SELECT * FROM bien where adress='"+adress+"' ;");
			return cnx.rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
/*
	public boolean ajouterApartement(Apartement apartement, String proprietaire) {
		Connexion cnx=new Connexion();
		try {
			cnx.connect.setAutoCommit(false);
			cnx.stat.executeUpdate(RequeteAgent.ajouterBien((Bien)apartement,proprietaire));
			cnx.stat.executeUpdate(RequeteAgent.ajouterApartement(apartement));
			cnx.connect.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}

	public ArrayList<Apartement> listApartement() {
		// TODO Auto-generated method stub
		Connexion cnx=new Connexion();
		try {
			cnx.rs=cnx.stat.executeQuery(RequeteAgent.listApartement());
		}catch(SQLException e)
		{
			return null;
		}
		ArrayList<Apartement> list=new ArrayList<Apartement>();
		try {
		while(cnx.rs.next())
		{
			Apartement a =new Apartement();
			a.setId(cnx.rs.getInt("id"));
			a.setVille(cnx.rs.getString("ville"));
			a.setAdr(cnx.rs.getString("adress"));
			a.setPrix(cnx.rs.getDouble("prix"));
			a.setSurface(cnx.rs.getDouble("surface"));
			a.setEmplacement(cnx.rs.getString("emplacement"));
			a.setDescAgent(cnx.rs.getString("desc_agent"));
			a.setEtage(cnx.rs.getInt("etage"));
			a.setNombrePiece(cnx.rs.getInt("nombre_piece"));
			a.setClimatisation(cnx.rs.getBoolean("climatisation"));
			a.setMeubler(cnx.rs.getBoolean("meuble"));
			a.setBalcon(cnx.rs.getBoolean("balcon"));
			a.setStationnement(cnx.rs.getBoolean("stationement"));
			a.setCacher(cnx.rs.getBoolean("cacher"));
			
			list.add(a);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return list;
	}

	public ArrayList<Locale> listLocale() {
		Connexion cnx=new Connexion();
		try {
			cnx.rs=cnx.stat.executeQuery(RequeteAgent.listLocale());
		}catch(SQLException e)
		{
			return null;
		}
		ArrayList<Locale> list =new  ArrayList<Locale>();
		 try {
				while(cnx.rs.next())
				{
					 Locale l =new Locale();
					l.setId(cnx.rs.getInt("id"));
					l.setVille(cnx.rs.getString("ville"));
					l.setAdr(cnx.rs.getString("adress"));
					l.setPrix(cnx.rs.getDouble("prix"));
					l.setSurface(cnx.rs.getDouble("surface"));
					l.setEmplacement(cnx.rs.getString("emplacement"));
					l.setDescAgent(cnx.rs.getString("desc_agent"));
					l.setFinisInt(cnx.rs.getBoolean("finis_int"));
					l.setFinisExt(cnx.rs.getBoolean("finis_ext"));
					l.setEquipeElec(cnx.rs.getBoolean("equiper_elec"));
					l.setEquiperGas(cnx.rs.getBoolean("equiper_gas"));
					l.setStationnement(cnx.rs.getBoolean("stationement"));
					l.setAlarm(cnx.rs.getBoolean("alarm"));
					l.setCacher(cnx.rs.getBoolean("cacher"));
					
					list.add(l);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
	}

	public ArrayList<Villa> listVilla() {
		// TODO Auto-generated method stub
		Connexion cnx=new Connexion();
		try {
			cnx.rs=cnx.stat.executeQuery(RequeteAgent.listVilla());
		}catch(SQLException e)
		{
			return null;
		}
		
		ArrayList<Villa> list =new ArrayList<Villa>();
		try {
			while(cnx.rs.next())
			{
				Villa v =new Villa();
				v.setId(cnx.rs.getInt("id"));
				v.setVille(cnx.rs.getString("ville"));
				v.setAdr(cnx.rs.getString("adress"));
				v.setPrix(cnx.rs.getDouble("prix"));
				v.setSurface(cnx.rs.getDouble("surface"));
				v.setEmplacement(cnx.rs.getString("emplacement"));
				v.setDescAgent(cnx.rs.getString("desc_agent"));
				v.setNombreEtage(cnx.rs.getInt("nombre_etage"));
				v.setNombrePiece(cnx.rs.getInt("nombre_piece"));
				v.setPicine(cnx.rs.getBoolean("picine"));
				v.setGarage(cnx.rs.getBoolean("garage"));
				v.setJardin(cnx.rs.getBoolean("jardin"));
				v.setClimatisation(cnx.rs.getBoolean("climatisation"));
				v.setMeubler(cnx.rs.getBoolean("meuble"));
				v.setAlarm(cnx.rs.getBoolean("alarm"));
				v.setChemine(cnx.rs.getBoolean("chemine"));
				v.setInterPhone(cnx.rs.getBoolean("interPhone"));
				v.setCacher(cnx.rs.getBoolean("cacher"));
				list.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;	
		
	}

	public ArrayList<Lot_Terrin> listLotTerrin() {
		// TODO Auto-generated method stub
		Connexion cnx=new Connexion();
		try {
			cnx.rs=cnx.stat.executeQuery(RequeteAgent.listLoTerrin());
		}catch(SQLException e)
		{
			return null;
		}
		ArrayList<Lot_Terrin> list=new ArrayList<Lot_Terrin>();
		try {
			while(cnx.rs.next())
			{
				Lot_Terrin lt=new Lot_Terrin();
				lt.setId(cnx.rs.getInt("id"));
				lt.setVille(cnx.rs.getString("ville"));
				lt.setAdr(cnx.rs.getString("adress"));
				lt.setPrix(cnx.rs.getDouble("prix"));
				lt.setSurface(cnx.rs.getDouble("surface"));
				lt.setEmplacement(cnx.rs.getString("emplacement"));
				lt.setDescAgent(cnx.rs.getString("desc_agent"));
				lt.setAgricol(cnx.rs.getBoolean("agricole"));
				lt.setCacher(cnx.rs.getBoolean("cacher"));
				list.add(lt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean ajouterLocale(Locale locale, String proprietaire) {
		// TODO Auto-generated method stub
		Connexion cnx=new Connexion();
		try {
			cnx.connect.setAutoCommit(false);
			cnx.stat.executeUpdate(RequeteAgent.ajouterBien((Bien)locale,proprietaire));
			cnx.stat.executeUpdate(RequeteAgent.ajouterLocale(locale));
			cnx.connect.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean ajouterLotTerrin(Lot_Terrin lotTerrin, String proprietaire) {
		// TODO Auto-generated method stub
		Connexion cnx=new Connexion();
		try {
			cnx.connect.setAutoCommit(false);
			cnx.stat.executeUpdate(RequeteAgent.ajouterBien((Bien)lotTerrin,proprietaire));
			cnx.stat.executeUpdate(RequeteAgent.ajouterLotTerrin(lotTerrin));
			cnx.connect.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean ajouterVilla(Villa villa, String proprietaire) {
		// TODO Auto-generated method stub
		Connexion cnx=new Connexion();
		try {
			cnx.connect.setAutoCommit(false);
			cnx.stat.executeUpdate(RequeteAgent.ajouterBien((Bien)villa,proprietaire));
			cnx.stat.executeUpdate(RequeteAgent.ajouterVilla(villa));
			cnx.connect.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}*/

	public boolean recupirerBien(Bien b) {
		// TODO Auto-generated method stub
		Connexion cnx=new Connexion();
		 try {
				return (cnx.stat.executeUpdate(RequeteClient.recupirerBien(b))==1 && cnx.Deconnexion());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}

	public ArrayList<Bien> mesBienDeLocation(String nomU) {
		
		ArrayList<Bien> list =new ArrayList<Bien>();
		
		Client c=new Client();
		c.setNomUtilisateur(nomU);
		
		ArrayList<Apartement> listApar=this.mesApartement(c,MESLOCATION);
		ArrayList<Villa> listVilla=this.mesVilla(c,MESLOCATION);
		ArrayList<Lot_Terrin> listLot=this.mesLotTerrin(c,MESLOCATION);
		ArrayList<Locale> listLocale=this.meslocale(c,MESLOCATION);
		
		System.out.println(listApar.size());
		System.out.println(listLocale.size());
		System.out.println(listLot.size());
		System.out.println(listVilla.size());

			for(Bien b : listApar)
				list.add(b);
			for(Bien b : listVilla)
				list.add(b);
			for(Bien b : listLot)
				list.add(b);
			for(Bien b : listLocale)
				list.add(b);
		
			return list;
		
		
	}

	public ArrayList<Bien> mesBienNonLouer(Client c) {
		
		ArrayList<Bien> list=new ArrayList<Bien>();
		

		ArrayList<Apartement> listApar=this.mesApartement(c,MESBIENNONLOUER);
		ArrayList<Villa> listVilla=this.mesVilla(c,MESBIENNONLOUER);
		ArrayList<Lot_Terrin> listLot=this.mesLotTerrin(c,MESBIENNONLOUER);
		ArrayList<Locale> listLocale=this.meslocale(c,MESBIENNONLOUER);
		
		System.out.println(listApar.size());
		System.out.println(listLocale.size());
		System.out.println(listLot.size());
		System.out.println(listVilla.size());
		
		for(Bien b : listApar)
			list.add(b);
		for(Bien b : listVilla)
			list.add(b);
		for(Bien b : listLot)
			list.add(b);
		for(Bien b : listLocale)
			list.add(b);
		
		
		
		
		return list;
	}

	public ArrayList<Bien> mesBienLouer(Client c) {
ArrayList<Bien> list=new ArrayList<Bien>();
		

		ArrayList<Apartement> listApar=this.mesApartement(c,MESBIENLOUER);
		ArrayList<Villa> listVilla=this.mesVilla(c,MESBIENLOUER);
		ArrayList<Lot_Terrin> listLot=this.mesLotTerrin(c,MESBIENLOUER);
		ArrayList<Locale> listLocale=this.meslocale(c,MESBIENLOUER);
		
		System.out.println(listApar.size());
		System.out.println(listLocale.size());
		System.out.println(listLot.size());
		System.out.println(listVilla.size());
		
		for(Bien b : listApar)
			list.add(b);
		for(Bien b : listVilla)
			list.add(b);
		for(Bien b : listLot)
			list.add(b);
		for(Bien b : listLocale)
			list.add(b);
		
		
		
		
		return list;
	}

	public ArrayList<Bien> chercherBien(String nomU, String type, String ville, int prixmin, int prixmax, int surmin,
			int surmax) {
		
		ArrayList<Bien> listBien=new ArrayList<Bien>();
		Connexion cnx=new Connexion();
		String typE=type.toLowerCase();
		
		try {
			
			cnx.rs=cnx.stat.executeQuery(RequeteClient.chercherBien(nomU,typE,ville,prixmin,  prixmax,  surmin,
						 surmax));
			
		}catch(SQLException e) {e.printStackTrace();}
		
		switch(type)
		{
		case "Apartement" :
		{	
			try {
				
				while(cnx.rs.next())
				{	
					Apartement a=new Apartement();
					a.setId(cnx.rs.getInt("id"));
					a.setVille(cnx.rs.getString("ville"));
					a.setAdr(cnx.rs.getString("adress"));
					a.setPrix(cnx.rs.getDouble("prix"));
					a.setSurface(cnx.rs.getDouble("surface"));
					a.setEmplacement(cnx.rs.getString("emplacement"));
					a.setDescAgent(cnx.rs.getString("desc_agent"));
					a.setEtage(cnx.rs.getInt("etage"));
					a.setNombrePiece(cnx.rs.getInt("nombre_piece"));
					a.setClimatisation(cnx.rs.getBoolean("climatisation"));
					a.setMeubler(cnx.rs.getBoolean("meuble"));
					a.setBalcon(cnx.rs.getBoolean("balcon"));
					a.setStationnement(cnx.rs.getBoolean("stationement"));
					a.setType("apartement");
					listBien.add(a);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}break;
		case "Locale" :
		{	 
		 try {
			 while(cnx.rs.next())
				{
					Locale l =new Locale();
					l.setId(cnx.rs.getInt("id"));
					l.setVille(cnx.rs.getString("ville"));
					l.setAdr(cnx.rs.getString("adress"));
					l.setPrix(cnx.rs.getDouble("prix"));
					l.setSurface(cnx.rs.getDouble("surface"));
					l.setEmplacement(cnx.rs.getString("emplacement"));
					l.setDescAgent(cnx.rs.getString("desc_agent"));
					l.setFinisInt(cnx.rs.getBoolean("finis_int"));
					l.setFinisExt(cnx.rs.getBoolean("finis_ext"));
					l.setEquipeElec(cnx.rs.getBoolean("equiper_elec"));
					l.setEquiperGas(cnx.rs.getBoolean("equiper_gas"));
					l.setStationnement(cnx.rs.getBoolean("stationement"));
					l.setAlarm(cnx.rs.getBoolean("alarm"));
					l.setType("locale"); 
					listBien.add(l);
							
					}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}break;
		case "Villa":
		{
			
			try {
				while(cnx.rs.next())
				{
					Villa v=new Villa();
					v.setId(cnx.rs.getInt("id"));
					v.setVille(cnx.rs.getString("ville"));
					v.setAdr(cnx.rs.getString("adress"));
					v.setPrix(cnx.rs.getDouble("prix"));
					v.setSurface(cnx.rs.getDouble("surface"));
					v.setEmplacement(cnx.rs.getString("emplacement"));
					v.setDescAgent(cnx.rs.getString("desc_agent"));
					v.setNombreEtage(cnx.rs.getInt("nombre_etage"));
					v.setNombrePiece(cnx.rs.getInt("nombre_piece"));
					v.setPicine(cnx.rs.getBoolean("picine"));
					v.setGarage(cnx.rs.getBoolean("garage"));
					v.setJardin(cnx.rs.getBoolean("jardin"));
					v.setClimatisation(cnx.rs.getBoolean("climatisation"));
					v.setMeubler(cnx.rs.getBoolean("meuble"));
					v.setAlarm(cnx.rs.getBoolean("alarm"));
					v.setChemine(cnx.rs.getBoolean("chemine"));
					v.setInterPhone(cnx.rs.getBoolean("interPhone"));
					v.setType("villa");
					listBien.add(v);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}break;
		case "Lot_Terrin" :
		{
			try {
				while(cnx.rs.next())
				{
					Lot_Terrin lt=new Lot_Terrin();
					lt.setId(cnx.rs.getInt("id"));
					lt.setVille(cnx.rs.getString("ville"));
					lt.setAdr(cnx.rs.getString("adress"));
					lt.setPrix(cnx.rs.getDouble("prix"));
					lt.setSurface(cnx.rs.getDouble("surface"));
					lt.setEmplacement(cnx.rs.getString("emplacement"));
					lt.setDescAgent(cnx.rs.getString("desc_agent"));
					lt.setAgricol(cnx.rs.getBoolean("agricole"));
					lt.setCacher(cnx.rs.getBoolean("cacher"));
					lt.setType("lot_terrin");
					listBien.add(lt);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}break;
		}
		
		
		return listBien;
	}

}
