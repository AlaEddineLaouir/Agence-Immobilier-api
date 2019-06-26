package Control;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Modele.Apartement;
import Modele.Bien;
import Modele.Client;
import Modele.Locale;
import Modele.Location;
import Modele.Lot_Terrin;
import Modele.Paiement;
import Modele.Rdv;
import Modele.Villa;
import Modele._Bien;
import Modele._Client;
import Modele._Location;
import Modele._Rdv;

/**
 * Servlet implementation class ClientApp
 */
@WebServlet("/App")
public class ClientApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientApp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("request");
		System.out.println(type);
		System.out.println(request.getParameterMap().keySet().size());
		
		if(type != null)
		{
			System.out.println("Aw Wasle Hna");
			switch(type)
			{
			case "seconnecter" :
			{
				seconnecter(request,response);
			}break;
			case "sinscrire" : 
			{
				inscrire(request,response);
			}break;
			case "modifieprofil":
			{
				modifieProfil(request,response);
			}break;
			case "mesLocation" :
			{
				mesLocation(request,response);
			}break;
			case "detailLocation" :
				detailLocation(request,response);
				break;
			case "detailPaiementL":
				detailPaiementL(request,response);
			break;
			case "mesBienLouer" :
				mesBienLouer(request,response);
			break;
			case "mesBienNonLouer" :
				mesBienNonLouer(request,response);
				break;
			case "supprimerBien" :
				supprimerBien(request,response);
				break;
			case "modifieBien" :
				modifieBien(request,response);
				break;
			case "chercher" :
				chercher(request,response);
				break;
			case "fixerVisite" :
			{
				fixerVisite(request,response);
			}break;
			case "mesRDV" :
			{
				mesRDV(request,response);
			}break;
			case "supprimerRdv" :
			{
				supprimerRdv(request,response);
			}break;
			case "modifieRDV" :
			{
				modifieRDV(request,response);
			}break;
			case "fixerDateAjout" :
			{
				ajouterBien(request,response);
			}break;
			default:{
				response.getWriter().println("Verfie le operation sohaiter");
			}break;
			}
		}
	}

	private void ajouterBien(HttpServletRequest request, HttpServletResponse response) {
		try {
			String nomU=request.getParameter("nomU");
			String dateRDV=request.getParameter("dateRDV");
			String heureRDv=request.getParameter("heureRDV");
			String moyenC=request.getParameter("moyenC");
			Rdv r=new Rdv();
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dt=sdf.parse(dateRDV);
			Date date=new java.sql.Date(dt.getTime());
			java.sql.Date dateR=new java.sql.Date(date.getTime());
			
			
			r.setClient_conc(nomU);
			r.setHeureRDV(heureRDv);
			r.setDateRDV(dateR);
			r.setMoyenContact(moyenC);
			r.setObjetRDV("ajouter bien");
			
			
			if(new _Rdv().ajouterRendezVous(r))
				throw new Exception();
			
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			response.setStatus(400);
		}
		
	}

	private void modifieRDV(HttpServletRequest request, HttpServletResponse response) {
		try {
			int numRdv=Integer.parseInt(request.getParameter("idrdv"));
			String heureRdv=request.getParameter("heureRDV");
			String moyenContact=request.getParameter("moyenC");
			String dateRdv=request.getParameter("dateRDV");
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dt=sdf.parse(dateRdv);
			Date date=new java.sql.Date(dt.getTime());
			java.sql.Date dateR=new java.sql.Date(date.getTime());
			
			Rdv r=new Rdv();
			r.setId(numRdv);
			r.setDateRDV(dateR);
			r.setHeureRDV(heureRdv);
			r.setMoyenContact(moyenContact);
			
			
			if(! new _Rdv().modifieRdv(r) )
				response.setStatus(400);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			response.setStatus(400);
		}
	}

	private void supprimerRdv(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idrdv=Integer.parseInt(request.getParameter("idrdv"));
			if(! new _Rdv().supprimerRdv(idrdv))
				throw new Exception();
		}catch(Exception e) {
			response.setStatus(400);
		}
		
	}

	private void mesRDV(HttpServletRequest request, HttpServletResponse response) {
		
		try {

			String nomU=request.getParameter("nomU");
			ArrayList<Rdv> list=new _Rdv().mesRDV(nomU);
            Gson g=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			String listJson=g.toJson(list);
			System.out.println(listJson);
			response.getWriter().print(listJson);
		} catch (IOException e) {
			e.printStackTrace();
			response.setStatus(400);
		}
		
		
	}

	private void fixerVisite(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			String nomU=request.getParameter("nomU");
			String dateRDV=request.getParameter("dateRDV");
			String heureRDv=request.getParameter("heureRDV");
			int idbien=Integer.parseInt(request.getParameter("idbien"));
			String moyenC=request.getParameter("moyenC");
			Rdv r=new Rdv();
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dt=sdf.parse(dateRDV);
			Date date=new java.sql.Date(dt.getTime());
			java.sql.Date dateR=new java.sql.Date(date.getTime());
			
			r.setBien_conc(idbien);
			r.setClient_conc(nomU);
			r.setHeureRDV(heureRDv);
			r.setDateRDV(dateR);
			r.setMoyenContact(moyenC);
			r.setObjetRDV("visite");
			
			
			if(! new _Rdv().ajouterRendezVous(r))
				throw new Exception();
			
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			response.setStatus(400);
		}
		
	}

	private void chercher(HttpServletRequest request, HttpServletResponse response) {
		try {
		
		int prixmin=0;
    	int prixmax=0;
    	int surmin=0;
    	int surmax=0;
    	String type=request.getParameter("type");
    	String nomU=request.getParameter("client");
    	String ville=request.getParameter("ville");
    	
    	prixmin = Integer.parseInt(request.getParameter("prixMin"));
       	prixmax=Integer.parseInt(request.getParameter("prixMax"));
       	surmin=Integer.parseInt(request.getParameter("surfaceMin"));
       	surmax=Integer.parseInt(request.getParameter("surfaceMax"));
       	ArrayList<Bien> listResultat=new _Bien().chercherBien(nomU,type,ville,prixmin,prixmax,surmin,surmax);
       	String jsonList=new Gson().toJson(listResultat);
       	response.getWriter().print(jsonList);
        	
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		response.setStatus(400);
    	}
    	
		
	}

	private void modifieBien(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idBien=Integer.parseInt(request.getParameter("idBien"));
			int prix=Integer.parseInt(request.getParameter("prix"));
			Bien b=new Bien();
			b.setId(idBien);
			b.setPrix(prix);
			if(! new _Bien().modifieBien(b))
			{
				throw new Exception();
			}
			
		}catch(Exception e) {
			response.setStatus(400);
			
		}
		
	}

	private void supprimerBien(HttpServletRequest request, HttpServletResponse response) {
		try {
			Bien b=new Bien();
			int id=Integer.parseInt(request.getParameter("idBien"));
			b.setId(id);
			String etat=request.getParameter("etat");
			if(etat.equals("cacher"))
			{
				if(! new _Bien().recupirerBien(b))
				{
					response.setStatus(400);
				}
				
			}else {
				if(! new _Bien().suprrimerBien(b))
				{
					response.setStatus(400);
				}
			}
			
			
		}catch(Exception e)
		{
			
		}
			
			
	}

	private void mesBienNonLouer(HttpServletRequest request, HttpServletResponse response) {
		try {
			String nomU=request.getParameter("nomU");
			Client c=new Client();
			c.setNomUtilisateur(nomU);
			
			ArrayList<Bien> listMesBienNonLouer=new _Bien().mesBienNonLouer(c);
			System.out.println("gadah ando :"+listMesBienNonLouer.size());			
			String listJson=new Gson().toJson(listMesBienNonLouer);
			System.out.println(listJson);
			response.getWriter().print(listJson);
		}catch(Exception e)
		{
			response.setStatus(400);
		}
		
		
	}

	private void mesBienLouer(HttpServletRequest request, HttpServletResponse response) {
		try {
			String nomU=request.getParameter("nomU");
			Client c=new Client();
			c.setNomUtilisateur(nomU);
			
			ArrayList<Bien> listMesBienLouer=new _Bien().mesBienLouer(c);
			
			String listJson=new Gson().toJson(listMesBienLouer);
			response.getWriter().print(listJson);
			
			
			
		}catch(Exception e)
		{
			response.setStatus(400);
		}
		
	}

	private void detailPaiementL(HttpServletRequest request, HttpServletResponse response) {
		try {
			int idBien=Integer.parseInt(request.getParameter("idBien"));
			String nomUL=request.getParameter("idClient");
			Client c=new Client();
			c.setNomUtilisateur(nomUL);
			Bien b= new Bien();
			b.setId(idBien);
			ArrayList<Paiement> listPaiement=new _Location().infoPaiementL(c, b);
			Gson g=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			String paiementJson=g.toJson(listPaiement);
			System.out.println(paiementJson);
			response.getWriter().print(paiementJson);
		}catch(Exception e)
		{
			response.setStatus(400);
		}
		
	}

	private void detailLocation(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id=Integer.parseInt(request.getParameter("idBien"));
			Bien b=new Bien();
			b.setId(id);
			Location location=new _Location().infoLocationL(b);
			Gson g=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			String locationJson=g.toJson(location);
			System.out.println(locationJson);
			response.getWriter().print(locationJson);
		}catch(Exception e)
		{
			response.setStatus(400);
		}
		
	}

	private void mesLocation(HttpServletRequest request, HttpServletResponse response) {
		String nomU=request.getParameter("nomU");
		ArrayList<Bien> listlocation = new _Bien().mesBienDeLocation(nomU);
		
		for(Bien b : listlocation)
		{
			System.out.println(b.toString());
		}
		
		String jsonResponse=new Gson().toJson(listlocation);
		System.out.println(jsonResponse);
		try {
			response.getWriter().print(jsonResponse);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void modifieProfil(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Client c=new Client();
		String nomU=request.getParameter("nomU");
		String motPasse=request.getParameter("motPasse");
		String email=request.getParameter("email");
		String numTelephone=request.getParameter("telephone");
		c.setNomUtilisateur(nomU);
		try {
			int telephone=Integer.parseInt(numTelephone);				
			c.setNumTelephone(telephone);	
		}catch(Exception e) {}
		
		if(motPasse != null)
			c.setMoteDePasse(motPasse);
		if(email != null)
			c.setEmail(email);
		if(! new _Client().modifieClient(c))
			response.setStatus(400);
		else
			response.getWriter().println("Hola !!");
		
		
	
		
		
	}

	private void inscrire(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String email=request.getParameter("email");
		int telephone=Integer.parseInt(request.getParameter("telephone"));
		String nomU=request.getParameter("nomU");
		String motPasse=request.getParameter("motPasse");
		Client c=new Client();
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setEmail(email);
		c.setNumTelephone(telephone);
		c.setMoteDePasse(motPasse);
		c.setNomUtilisateur(nomU);
		if(new _Client().ajouterClient(c))
		{
			try {
				response.getWriter().print(new Gson().toJson(c));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			response.setStatus(400);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	private void seconnecter(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String nomU=request.getParameter("nomU");
		String motPasse=request.getParameter("motPasse");
		Client c=new Client();
		c.setNomUtilisateur(nomU);
		c.setMoteDePasse(motPasse);
		c=new _Client().existeClient(c);
		String compteClient=new Gson().toJson(c);
		System.out.println(compteClient);
		
		try {
			response.getWriter().print(compteClient);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
