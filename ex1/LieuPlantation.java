package ex1;

import java.io.Serializable;

public class LieuPlantation implements Serializable {
	
	int departement;
	String commune;
	transient String nomvoie;

	public int getDepartement() {
		return departement;
	}


	public void setDepartement(int departement) {
		this.departement = departement;
	}


	public String getCommune() {
		return commune;
	}


	public void setCommune(String commune) {
		this.commune = commune;
	}


	public String getNomvoie() {
		return nomvoie;
	}


	public void setNomvoie(String nomvoie) {
		this.nomvoie = nomvoie;
	}

	
	public LieuPlantation(int departement, String commune, String nomvoie) {
		super();
		this.departement = departement;
		this.commune = commune;
		this.nomvoie = nomvoie;
	}

	
	public LieuPlantation() {
		// TODO Auto-generated constructor stub
	}

}
