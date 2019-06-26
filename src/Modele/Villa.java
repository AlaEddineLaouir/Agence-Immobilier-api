package Modele;

public class Villa extends Bien{
	private int nombreEtage;
	private int nombrePiece;
	private boolean picine;
	private boolean garage;
	private boolean jardin;
	private boolean climatisation;
	private boolean meubler;
	private boolean alarm;
	private boolean chemine;
	private boolean interPhone;
	private boolean terasse;
	
	
	public boolean isTerasse() {
		return terasse;
	}

	public void setTerasse(boolean terasse) {
		this.terasse = terasse;
	}

	public Villa()
	{
		
	}

	public int getNombreEtage() {
		return nombreEtage;
	}

	public void setNombreEtage(int nombreEtage) {
		this.nombreEtage = nombreEtage;
	}

	public int getNombrePiece() {
		return nombrePiece;
	}

	public void setNombrePiece(int nombrePiece) {
		this.nombrePiece = nombrePiece;
	}

	public boolean isPicine() {
		return picine;
	}

	public void setPicine(boolean picine) {
		this.picine = picine;
	}

	public boolean isGarage() {
		return garage;
	}

	public void setGarage(boolean garage) {
		this.garage = garage;
	}

	public boolean isJardin() {
		return jardin;
	}

	public void setJardin(boolean jardin) {
		this.jardin = jardin;
	}

	public boolean isClimatisation() {
		return climatisation;
	}

	public void setClimatisation(boolean climatisation) {
		this.climatisation = climatisation;
	}

	public boolean isMeubler() {
		return meubler;
	}

	public void setMeubler(boolean meubler) {
		this.meubler = meubler;
	}

	public boolean isAlarm() {
		return alarm;
	}

	public void setAlarm(boolean alarm) {
		this.alarm = alarm;
	}

	public boolean isChemine() {
		return chemine;
	}

	public void setChemine(boolean chemine) {
		this.chemine = chemine;
	}

	public boolean isInterPhone() {
		return interPhone;
	}

	public void setInterPhone(boolean interPhone) {
		this.interPhone = interPhone;
	}
	 @Override
	    public String toString() {
	        return " Elle est bien Villa ";
	    }
	
}
