package Modele;

public class Locale extends Bien {
	
	
	private boolean finisInt;
	private boolean finisExt;
	private boolean equiperGas;
	private boolean equipeElec;
	private boolean stationnement;
	private boolean alarm;
	
	public Locale()
	{
		super();
	}

	

	public boolean isFinisInt() {
		return finisInt;
	}

	public void setFinisInt(boolean finisInt) {
		this.finisInt = finisInt;
	}

	public boolean isFinisExt() {
		return finisExt;
	}

	public void setFinisExt(boolean finisExt) {
		this.finisExt = finisExt;
	}

	public boolean isEquiperGas() {
		return equiperGas;
	}

	public void setEquiperGas(boolean equiperGas) {
		this.equiperGas = equiperGas;
	}

	public boolean isEquipeElec() {
		return equipeElec;
	}

	public void setEquipeElec(boolean equipeElec) {
		this.equipeElec = equipeElec;
	}

	public boolean isStationnement() {
		return stationnement;
	}

	public void setStationnement(boolean stationnement) {
		this.stationnement = stationnement;
	}

	public boolean isAlarm() {
		return alarm;
	}

	public void setAlarm(boolean alarm) {
		this.alarm = alarm;
	}
	 @Override
	    public String toString() {
	        return " Elle est bien Locale ";
	    }
	

}
