package Modele;

public class Lot_Terrin extends Bien {
	
	
	private boolean agricol;
	
	public Lot_Terrin()
	{
		super();
	}

	

	public boolean isAgricol() {
		return agricol;
	}

	public void setAgricol(boolean agricol) {
		this.agricol = agricol;
	}
	 @Override
	    public String toString() {
	        return " Elle est bien Lot_terrin ";
	    }
	
	

}
