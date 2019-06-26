package Modele;

public class Apartement extends Bien {
	
		private int etage;
	private int nombrePiece;
	private boolean climatisation;
	private boolean meubler;
	private boolean balcon;
	private boolean stationnement;
	
	public Apartement()
	{
		super();
	}

	

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public int getNombrePiece() {
		return nombrePiece;
	}

	public void setNombrePiece(int nombrePiece) {
		this.nombrePiece = nombrePiece;
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

	public boolean isBalcon() {
		return balcon;
	}

	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}

	public boolean isStationnement() {
		return stationnement;
	}

	public void setStationnement(boolean stationnement) {
		this.stationnement = stationnement;
	}
	 @Override
	    public String toString() {
	        return " Elle est bien entourere par plusieur institution de d'education et de santé ";
	    }

}
