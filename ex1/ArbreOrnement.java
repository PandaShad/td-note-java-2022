package ex1;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@ComplementClasse(author = "Max", shouldBeSerializable = true)
public class ArbreOrnement extends Arbre implements Externalizable {

    @ComplementChamp(author = "LilShad", ShouldBePersistent = true)
	essenceDarbre essence; // essence de l'arbre
    @ComplementChamp(author = "LilShad", ShouldBePersistent = false)
	boolean milieuUrbain; // peut �tre plant� en milieu urbain
	
	public ArbreOrnement() {
		// TODO Auto-generated constructor stub
	}

	public ArbreOrnement(essenceDarbre essence, boolean milieuUrbain) {
		super();
		this.essence = essence;
		this.milieuUrbain = milieuUrbain;
	}
	
	public essenceDarbre getEssence() {
		return essence;
	}

	public void setEssence(essenceDarbre essence) {
		this.essence = essence;
	}

	public boolean isMilieuUrbain() {
		return milieuUrbain;
	}

	public void setMilieuUrbain(boolean milieuUrbain) {
		this.milieuUrbain = milieuUrbain;
	}

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.nom);
		out.writeObject(this.hauteur);
		out.writeObject(this.essence);
		out.writeObject(this.milieuUrbain);
        
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        nom = (String) in.readObject();
		hauteur = (int) in.readObject();
		essence = (essenceDarbre) in.readObject();
		milieuUrbain = (boolean) in.readObject();
    }
	
}
