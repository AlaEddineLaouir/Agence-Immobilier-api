package Modele;

public class Agent extends Personne {
	private String motPass;
	private boolean gerant;
	public String getMotPass() {
		return motPass;
	}
	public void setMotPass(String motPass) {
		this.motPass = motPass;
	}
	public boolean isGerant() {
		return gerant;
	}
	public void setGerant(boolean gerant) {
		this.gerant = gerant;
	}
	

}
