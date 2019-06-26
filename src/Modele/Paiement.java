package Modele;

import java.sql.Date;

public class Paiement {
	
	private int id;
	private double monatantPaiement;
	private Date datePaiement;
	
	
	public Paiement()
	{
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getMonatantPaiement() {
		return monatantPaiement;
	}


	public void setMonatantPaiement(double monatantPaiement) {
		this.monatantPaiement = monatantPaiement;
	}


	public Date getDatePaiement() {
		return datePaiement;
	}


	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}
	
	

}
