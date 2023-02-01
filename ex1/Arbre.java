package ex1;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@ComplementClasse(author = "Max", shouldBeSerializable = false)
public class Arbre {

	@ComplementChamp(author = "LilShad", ShouldBePersistent = false)
	String nom; // Nom de l'arbre
	@ComplementChamp(author = "LilShad", ShouldBePersistent = true)
	int hauteur; // Hauteur de l'arbre en m�tres
	@ComplementChamp
	int anneePlantation; // Ann�e durant laquelle l'arbre a �t� plant�
	@ComplementChamp(author = "LilShad", ShouldBePersistent = false)
	LieuPlantation lieu;
	
	
	public Arbre() {
		// TODO Auto-generated constructor stub
	}

	public Arbre(String nom, int hauteur, int anneePlantation) {
		super();
		this.nom = nom;
		this.hauteur = hauteur;
		this.anneePlantation = anneePlantation;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getHauteur() {
		return hauteur;
	}


	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}


	public int getAnneePlantation() {
		return anneePlantation;
	}


	public void setAnneePlantation(int anneePlantation) {
		this.anneePlantation = anneePlantation;
	}


	public LieuPlantation getLieu() {
		return lieu;
	}


	public void setLieu(LieuPlantation lieu) {
		this.lieu = lieu;
	}

}
