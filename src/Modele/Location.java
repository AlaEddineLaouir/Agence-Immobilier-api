package Modele;

import java.sql.Date;

public class Location {
	private int id;
	private String modalitÚPaiement;
	private Date dateDebut;
	private Date dateFin;
	private double coutLocation;
	
	
	public Location()
	{
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getModalitÚPaiement() {
		return modalitÚPaiement;
	}


	public void setModalitÚPaiement(String modalitÚPaiement) {
		this.modalitÚPaiement = modalitÚPaiement;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public double getCoutLocation() {
		return coutLocation;
	}


	public void setCoutLocation(double coutLocation) {
		this.coutLocation = coutLocation;
	}
	
	
	
}
