package Modele;

import java.sql.Date;

public class Rdv {
	private int id;
	private Date dateRDV;
	private String heureRDV;
	private String lieuRDV;
	private String objetRDV;
	private String moyenContact;
	private String message;
	private boolean vu;
	private String client_conc;
	private int bien_conc;
	
	
	
	
	public String getClient_conc() {
		return client_conc;
	}

	public void setClient_conc(String client_conc) {
		this.client_conc = client_conc;
	}

	public int getBien_conc() {
		return bien_conc;
	}

	public void setBien_conc(int bien_conc) {
		this.bien_conc = bien_conc;
	}

	public Rdv()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateRDV() {
		return dateRDV;
	}

	public void setDateRDV(Date dateRDV) {
		this.dateRDV = dateRDV;
	}

	public String getHeureRDV() {
		return heureRDV;
	}

	public void setHeureRDV(String heureRDV) {
		this.heureRDV = heureRDV;
	}

	public String getLieuRDV() {
		return lieuRDV;
	}

	public void setLieuRDV(String lieuRDV) {
		this.lieuRDV = lieuRDV;
	}

	public String getObjetRDV() {
		return objetRDV;
	}

	public void setObjetRDV(String objetRDV) {
		this.objetRDV = objetRDV;
	}

	public String getMoyenContact() {
		return moyenContact;
	}

	public void setMoyenContact(String moyenContact) {
		this.moyenContact = moyenContact;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isVu() {
		return vu;
	}

	public void setVu(boolean vu) {
		this.vu = vu;
	}
	

}
