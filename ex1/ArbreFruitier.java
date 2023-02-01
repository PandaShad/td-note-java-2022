package ex1;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@ComplementClasse(author = "Max", shouldBeSerializable = true)
public class ArbreFruitier extends Arbre implements Externalizable {

	@ComplementChamp(author = "LilShad", ShouldBePersistent = false)
	String nomFruit; // Nom du fruit produit par l'arbre
	@ComplementChamp(author = "LilShad", ShouldBePersistent = false)
	MoisAnnee recolte; // Mois pendant laaquelle se fait la r�colte
	
	public ArbreFruitier(String nomFruit, MoisAnnee recolte) {
		super();
		this.nomFruit = nomFruit;
		this.recolte = recolte;
	}

	public ArbreFruitier() {
		// TODO Auto-generated constructor stub
	}

	public String getNomFruit() {
		return nomFruit;
	}

	public void setNomFruit(String nomFruit) {
		this.nomFruit = nomFruit;
	}

	public MoisAnnee getRecolte() {
		return recolte;
	}

	public void setRecolte(MoisAnnee recolte) {
		this.recolte = recolte;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.nom);
		out.writeObject(this.hauteur);
		out.writeObject(this.anneePlantation);
		out.writeObject(this.lieu);
		out.writeObject(this.nomFruit);
		out.writeObject(this.recolte);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		nom = (String) in.readObject();
		hauteur = (int) in.readObject();
		anneePlantation = (int) in.readObject();
		lieu = (LieuPlantation) in.readObject();
		nomFruit = (String) in.readObject();
		recolte = (MoisAnnee) in.readObject();
	}

}
