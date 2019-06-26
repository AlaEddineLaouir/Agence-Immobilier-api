package Modele;

public class Bien {
	protected int id;
	protected String ville;
	protected String adr;
	protected double prix;
	protected double surface;
	protected String emplacement;
	protected String descAgent;
	protected boolean cacher;
	protected String type;
	
	
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isCacher() {
		return cacher;
	}

	public void setCacher(boolean cacher) {
		this.cacher = cacher;
	}

	public Bien()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public String getDescAgent() {
		return descAgent;
	}

	public void setDescAgent(String descAgent) {
		this.descAgent = descAgent;
	}
	

}
