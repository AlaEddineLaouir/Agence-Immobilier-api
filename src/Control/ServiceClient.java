package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Modele.Client;
import Modele._Client;

/**
 * Servlet implementation class ServiceClient
 */
@WebServlet("/ServiceClient")
public class ServiceClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
   
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=req.getParameter("request");
		System.out.println(type);
		System.out.println(req.getParameterMap().keySet().size());
		
		if(type != null)
		{System.out.println("Aw Wasle Hna");
			switch(type)
			{
			case "seconnecter" :
			{
				

				seconnecter(req,resp);
			}break;
			default:{
				System.out.println("Verfie le operation sohaiter");
			}break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	private void seconnecter(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String nomU=request.getParameter("nomUtilisateur");
		String motPasse=request.getParameter("motPasse");
		Client c=new Client();
		c.setNomUtilisateur(nomU);
		c.setMoteDePasse(motPasse);
		c=new _Client().existeClient(c);
		
		String compteClient=new Gson().toJson(c);
		
		try {
			response.getWriter().print(compteClient);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
