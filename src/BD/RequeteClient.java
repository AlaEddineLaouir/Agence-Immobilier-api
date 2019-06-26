package BD;

import Modele.Client;
import Modele.Agent;
import Modele.Apartement;
import Modele.Bien;
import Modele.Locale;
import Modele.Location;
import Modele.Lot_Terrin;
import Modele.Rdv;
import Modele.Villa;

public class RequeteClient {
	
	public static String existeClient(Client c)
	{
		
		return " SELECT * FROM client c WHERE "
				+ "c.nom_utilisateur = '"+c.getNomUtilisateur()+"' AND c.mot_passe = '"+c.getMoteDePasse()+"'  ;";
	}
	
	public static String modifieClient (Client c)
	{
		
		return "update client set telephone='"+c.getNumTelephone()+"' , email='"+c.getEmail()+"' ,   mot_passe='"+c.getMoteDePasse()+"' where  nom_utilisateur='"+c.getNomUtilisateur()+"' ;";
	}
	
	public static String ajouterClient(Client c)
	{
		return "insert into client values('"+c.getNomUtilisateur()+"','"+c.getNom()+"','"+c.getPrenom()+"',null,null,'"+c.getNumTelephone()+"','"+c.getEmail()+"',null,'"+c.getMoteDePasse()+"',false);";
	}
	
	
	
	/*                       Requet Proprietaire                    */
	
	public static String mesAparLouer(Client c)
	{
		
		return " select * from apartement a , bien b where a.id=b.ref and b.proprietaire_id='"+c.getNomUtilisateur()+"'  and b.ref IN "
						+ " ( select bien_louer from location where DATE(date_fin) >= DATE(NOW())"
						+ "); ";
	}
	
	
	public static String mesVillaLouer(Client c)
	{
		return " select * from villa v , bien b where v.id=b.ref and b.proprietaire_id='"+c.getNomUtilisateur()+"'   and b.ref IN "
				+ " ( select bien_louer from location where DATE(date_fin) >= DATE(NOW())"
				+ "); ";
		
	}
	public static String mesLocaleLouer(Client c)
	{
		return " select * from locale l , bien b where l.id=b.ref and b.proprietaire_id='"+c.getNomUtilisateur()+"'  and b.ref IN "
				+ " ( select bien_louer from location where DATE(date_fin) >= DATE(NOW())"
				+ "); ";
	}
	
	public static String mesLotTerrinLouer(Client c)
	{
		System.out.println(" select * from lot_terrin lt , bien b where lt.id=b.ref and b.proprietaire_id='"+c.getNomUtilisateur()+"'     and b.ref IN "
				+ " ( select bien_louer from location where DATE(date_fin) >= DATE(NOW())"
				+ "); ");
		return " select * from lot_terrin lt , bien b where lt.id=b.ref and b.proprietaire_id='"+c.getNomUtilisateur()+"'     and b.ref IN "
				+ " ( select bien_louer from location where DATE(date_fin) >= DATE(NOW())"
				+ "); ";
	}
	
	public static String mesAparNonLouer(Client c)
	{
		String requete="select * from apartement a , bien b where a.id=b.ref and b.proprietaire_id='"+c.getNomUtilisateur()+"'   and b.ref NOT IN "
				+ "( select bien_louer from location where DATE(date_fin) >= DATE(NOW()));";
		
		return requete;
	}
	
	public static String mesVillaNonLouer(Client c)
	{
		return "select * from villa v , bien b where v.id=b.ref and b.proprietaire_id='"+c.getNomUtilisateur()+"'   and b.ref NOT IN "
				+ "( select bien_louer from location where DATE(date_fin) >= DATE(NOW()));";
		
	}
	public static String mesLocaleNonLouer(Client c)
	{
		String requete="select * from locale l , bien b where l.id=b.ref and b.proprietaire_id='"+c.getNomUtilisateur()+"'   and b.ref NOT IN "
				+ "( select bien_louer from location where DATE(date_fin) >= DATE(NOW()));";
		System.out.println(requete);
		return requete;
	}
	
	public static String mesLotTerrinNonLouer(Client c)
	{
		String requete="select * from lot_terrin lt , bien b where lt.id=b.ref and b.proprietaire_id='"+c.getNomUtilisateur()+"'   and b.ref NOT IN "
				+ "( select bien_louer from location where DATE(date_fin) >= DATE(NOW()));";
		System.out.println(requete);
		return requete;
	}
			
	
	
	/*                           Requet Locataire           */
	
	public static String aparLouer(Client c)
	{
		System.out.println(" select * from apartement a , bien b where a.id=b.ref  AND  b.ref IN "
				+ "( SELECT bien_louer FROM location WHERE locataire='"+c.getNomUtilisateur()+"' AND DATE(date_fin) >= DATE(NOW())); ");
		
		
		return " select * from apartement a , bien b where a.id=b.ref  AND  b.ref IN "
				+ "( SELECT bien_louer FROM location WHERE locataire='"+c.getNomUtilisateur()+"' AND DATE(date_fin) >= DATE(NOW())); ";
	}
	public static String villaLouer(Client c)
	{
		System.out.println( " select * from villa v , bien b where v.id=b.ref   AND b.ref IN "
				+ "( SELECT bien_louer FROM location WHERE locataire='"+c.getNomUtilisateur()+"' AND DATE(date_fin) >= DATE(NOW()));");
		
		return " select * from villa v , bien b where v.id=b.ref   AND b.ref IN "
				+ "( SELECT bien_louer FROM location WHERE locataire='"+c.getNomUtilisateur()+"' AND DATE(date_fin) >= DATE(NOW()));";
	}
	public static String lotTerrinLouer(Client c)
	{
		System.out.println(" select * from lot_terrin lt, bien b where lt.id=b.ref   AND b.ref IN "
				+ "( SELECT bien_louer FROM location WHERE locataire='"+c.getNomUtilisateur()+"' AND DATE(date_fin) >= DATE(NOW()));");
		return " select * from lot_terrin lt, bien b where lt.id=b.ref   AND b.ref IN "
				+ "( SELECT bien_louer FROM location WHERE locataire='"+c.getNomUtilisateur()+"' AND DATE(date_fin) >= DATE(NOW()));";
	}
	public static String localeLouer(Client c)
	{
		System.out.println(" select * from locale l , bien b where l.id=b.ref  AND b.ref IN "
				+ "( SELECT bien_louer FROM location WHERE locataire='"+c.getNomUtilisateur()+"' AND DATE(date_fin) >= DATE(NOW()));");
		return " select * from locale l , bien b where l.id=b.ref  AND b.ref IN "
				+ "( SELECT bien_louer FROM location WHERE locataire='"+c.getNomUtilisateur()+"' AND DATE(date_fin) >= DATE(NOW()));";
	}
	
	public static String infoLocationDunBien(Bien b)
	{
		return "SELECT * From Location l where l.bien_louer='"+b.getId()+"' AND DATE(date_fin) >= DATE(NOW()) ;";
	}
	public static String infoPaiementLocation(Location l)
	{
		return "SELECT * From paiement p where p.sur_location='"+l.getId()+"' ;";
	}
	
	/*                            requet client               */
	
	public static String chercheApar(Apartement a,int pmin,int pmax,int smin,int smax)
	{	
		
		
		String requete="select * from apartement a , bien b where a.id=b.ref  and cacher=0 ";
			requete	+= "AND b.ville='"+a.getVille()+"' ";
			requete	+= "AND b.prix between "+pmin+" AND "+pmax+" ";
			requete	+= "AND b.surface between "+smin+" AND "+smax+" ";
			requete	+= " AND a.nombre_piece <="+a.getNombrePiece()+" AND";
			requete	+= " a.climatisation="+a.isClimatisation()+" AND ";
			requete	+= " a.meuble="+a.isMeubler()+" AND ";
			requete	+= " a.balcon="+a.isBalcon()+" AND ";
			requete	+= " a.stationement="+a.isStationnement()+" ;";
		
			
		return requete;
	}
	public static String chercheAparApp(String nomU,String ville,int pmin,int pmax,int smin,int smax)
	{	
		
		
		String requete="select * from apartement a , bien b where a.id=b.ref  AND cacher=0 AND proprietaire_id !='"+nomU+"' ";
			requete	+= "AND b.ville='"+ville+"' ";
			requete	+= "AND b.prix between "+pmin+" AND "+pmax+" ";
			requete	+= "AND b.surface between "+smin+" AND "+smax+" AND "
					+ "b.ref NOT IN (select bien_conc from rdv where client_conc ='"+nomU+"' AND objet_rdv ='visite');";
		System.out.println(requete);
			
		
			
		return requete;
	}
	public static String chercherById(int id,String type)
	{
		String requete=" ";
		switch(type)
		{
		case "apar" :
		{
			requete+="select * from bien b , apartement a where b.ref=a.id AND b.ref="+id+" ;";
		}break;
		case "Lot" :
		{
			requete+=" select * from bien b , lot_terrin a where b.ref=a.id AND b.ref="+id+" ;";
		}break;
		case "locale" :
		{
			requete+="select * from bien b , locale a where b.ref=a.id AND b.ref="+id+";";
		}break;
		case "villa" :
		{
			requete+="select * from bien b , villa a where b.ref=a.id AND b.ref="+id+";";
		}break;
		}
		System.out.println(requete);
		return requete;
	}
	public static String chercheVilla(Villa v,int pmin,int pmax, int smin,int smax)
	{
		String requete="select * from villa v , bien b where v.id=b.ref and cacher=0  AND"
				+ " b.ville='"+v.getVille()+"' AND "
				+ " b.prix between "+pmin+" AND "+pmax+" "
				+ " AND b.surface between "+smin+" AND "+smax+"  AND"
				+ " v.nombre_etage >= "+v.getNombreEtage()+" AND "
				+ " v.nombre_piece >= "+v.getNombrePiece()+" AND"
				+ " v.picine="+v.isPicine()+" AND "
				+ " v.garage="+v.isGarage()+" AND "
				+ " v.jardin="+v.isJardin()+" AND "
				+ " v.climatisation="+v.isClimatisation()+" AND "
				+ " v.meuble="+v.isMeubler()+" AND "
				+ " v.alarm="+v.isAlarm()+" AND "
				+ " v.chemine="+v.isChemine()+" AND "
				+ " v.interPhone="+v.isInterPhone()+" ;";
			
		
		
		
		return requete;
	}
	public static String chercheLotTerrin(Lot_Terrin lt ,int pmin ,int pmax ,int smin,int smax)
	{
		String requete="select * from lot_terrin lt , bien b where lt.id=b.ref and cacher=0  AND"
				+ " b.ville='"+lt.getVille()+"' AND "
				+ " b.prix between "+pmin+" AND "+pmax+" "
				+ " AND b.surface between "+smin+" AND "+smax+" AND"
				+ " lt.agricole="+lt.isAgricol()+" ;";
		System.out.println(requete);
		
			
		
		
		return requete;
	}
	public static String chercheLocale(Locale l ,int pmin,int pmax,int smin,int smax)
	{
		String requete="select * from locale l , bien b where l.id=b.ref and cacher=0  AND"
				+ " b.ville='"+l.getVille()+"' AND "
				+ " b.prix between "+pmin+" AND "+pmax+" "
				+ " AND b.surface between "+smin+" AND "+smax+" AND "
				+ " l.finis_int="+l.isFinisInt()+" AND"
				+ " l.finis_ext="+l.isFinisExt()+" AND"
				+ " l.equiper_gas="+l.isEquiperGas()+" AND"
				+ " l.equiper_elec="+l.isEquipeElec()+" AND"
				+ " l.stationement="+l.isStationnement()+" AND"
				+ " l.alarm="+l.isAlarm()+"  ;";
		       
			
		
		return requete;
	}
	
	
	public static String supprimerBien(Bien b)
	{
		return "update bien set cacher =1 where ref='"+b.getId()+"' ;";
	}
	
	public static String mesRdvNC(Client c)
	{
		String requete= "SELECT * from rdv where client_conc ='"+c.getNomUtilisateur()+"'  AND agent_conc IS NULL ; ";
		System.out.println(requete);
		return requete;
		}
	
	
	public static String mesRdv(String nomU)
	{
		String requete= "SELECT * from rdv where client_conc ='"+nomU+"' AND DATE(date_rdv) >= DATE(NOW()); ";
		System.out.println(requete);
		return requete;
	}
	
	
	public static String modifieRdv(Rdv r)
	{
		String requete="update rdv set date_rdv='"+r.getDateRDV()+"' , moyen_contact='"+r.getMoyenContact()+"' , "
				+ "heure_rdv='"+r.getHeureRDV()+"' "
				+ " where num='"+r.getId()+"' ";
			
				System.out.println(requete);
		return requete;
	}
	
	public static String ajouterRdv(Rdv r , Client c)
	{
		return "insert into rdv (date_rdv,heure_rdv,moyen_contact,objet_rdv,message , client_conc) values('"+r.getDateRDV()+"' , '"+r.getHeureRDV()+"',"
				+ "'"+r.getMoyenContact()+"' , '"+r.getObjetRDV()+"','"+r.getMessage()+"' ,'"+c.getNomUtilisateur()+"' );";
	}
	public static String ajouterRendezVous(Rdv r)
	{
		String requete= "insert into rdv (date_rdv,heure_rdv,moyen_contact,objet_rdv, client_conc , bien_conc , lieu_rdv,vu ) values('"+r.getDateRDV()+"' , '"+r.getHeureRDV()+"',"
				+ "'"+r.getMoyenContact()+"' , '"+r.getObjetRDV()+"','"+r.getClient_conc()+"' , '"+r.getBien_conc()+"'  , 'adr_bien' ,0);";
		
		return requete;
	}
	
	
	
	public static String locationL( Bien b)
	{
		return "Select * from location where  bien_louer='"+b.getId()+"' AND DATE(date_fin) >= DATE(NOW()) ";
	}
	
	public static String locationP(Client c , Bien b)
	{
		return "Select * from location where proprietaire='"+c.getNomUtilisateur()+"' AND bien_louer='"+b.getId()+"' AND DATE(date_fin) >= DATE(NOW()) ";
	}
	
	public static String paiementL(Client c , Bien b)
	{
		System.out.println("select * from paiement where  id_payant='"+c.getNomUtilisateur()+"' AND  sur_location=("
				+ " select id from location where bien_louer="+b.getId()+" AND DATE( date_fin)>= DATE(NOW())  )   ;");
		return "select * from paiement where  id_payant='"+c.getNomUtilisateur()+"' AND  sur_location=("
				+ " select id from location where bien_louer="+b.getId()+" AND DATE( date_fin)>= DATE(NOW())  )   ;";
	}
	public static String paiementP(Client c , Location l)
	
	{
		return "select * from paiement where sur_location='"+l.getId()+"' AND id_payée='"+c.getNomUtilisateur()+"' ;";
	}

	public static String modifieBien(Bien b) {
		// TODO Auto-generated method stub
		String requete="update bien set prix="+b.getPrix()+" where ref="+b.getId()+" ;";
		return requete;
	}

	public static String ajouterBien(Client c, Bien b) {
		String requete ="insert into bien (adress,ville,prix,surface,proprietaire_id) values('"+b.getAdr()+"' , '"+b.getAdr()+"' ,'"+b.getPrix()+"' ,'"+b.getSurface()+"', '"+c.getNomUtilisateur()+"');";
		System.out.println(requete);
		return requete;
	}

	public static String idBien(Bien b) {
		String requete ="select ref from bien where adress='"+b.getAdr()+"' AND surface='"+b.getSurface()+"' AND prix='"+b.getPrix()+"' ;";
		System.out.println(requete);
		return requete;
	}

	public static String recupirerBien(Bien b) {
		// TODO Auto-generated method stub
		return "UPDATE bien set cacher=0 where ref='"+b.getId()+"' ;";
	}

	public static String mesLocation(String nomU) {
		
		System.out.println("SELECT * FROM bien WHERE ref IN ("
				+ "SELECT bien_louer FROM location WHERE locataire='"+nomU+"' AND DATE(date_fin) >= DATE(NOW()) "
				+ ");");
		return "SELECT * FROM bien WHERE  ref IN ("
				+ "SELECT bien_louer FROM location WHERE locataire='"+nomU+"' AND DATE(date_fin) >= DATE(NOW()) "
				+ ");";
	}

	public static String chercheLocaleApp(String nomU, String ville, int prixmin, int prixmax, int surmin, int surmax) {
		
		return null;
	}

	public static String chercherBien(String nomU, String typE, String ville, int prixmin, int prixmax, int surmin,
			int surmax) {
		if(nomU==null)
			nomU=" ";
		
		String requete="select * from "+typE+" a , bien b where a.id=b.ref  AND cacher=0 AND proprietaire_id !='"+nomU+"' ";
		requete	+= "AND b.ville='"+ville+"' ";
		requete	+= "AND b.prix between "+prixmin+" AND "+prixmax+" ";
		requete	+= "AND b.surface between "+surmin+" AND "+surmax+" AND "
				+ "b.ref NOT IN (select bien_conc from rdv where client_conc ='"+nomU+"' AND objet_rdv ='visite' AND DATE(NOW())<DATE(date_rdv)) "
				+ "AND b.ref NOT IN (select bien_louer from location where DATE(date_fin)>DATE(NOW()));";
	System.out.println(requete);
		
	
		
	return requete;
		
	
		
	}

	public static String supprimerRdv(int idrdv) {
		
		return "delete from rdv where num="+idrdv+" AND objet_rdv !='paiement' ;";
	}

	
	
	
	
	
	

}
