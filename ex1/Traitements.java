package ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

public class Traitements {
    static ArrayList<ArbreFruitier> arbreFruitiers = new ArrayList<>();
    static ArbreOrnement[] arbreOrnements = new ArbreOrnement[3];
    static int anneePlantationParDefaut = 2008;

    public static void sortParAnneeOrnement() {
        Comparator<ArbreOrnement> treatment = (ArbreOrnement a1, ArbreOrnement a2) -> {
            return a1.getAnneePlantation() - a2.getAnneePlantation();
        };
        Arrays.sort(arbreOrnements, treatment);
    }

    public static void resetAnneePlantation() {
        Consumer<ArbreFruitier> treatment = (ArbreFruitier a1) -> {
            if(a1.anneePlantation > anneePlantationParDefaut){
                a1.setAnneePlantation(anneePlantationParDefaut);
            }
        };
        arbreFruitiers.forEach(treatment);
    }

    public static void serialiserArbres(String nomFicher) {
        ObjectOutputStream g_arbres;
        try {
            FileOutputStream support = new FileOutputStream(nomFicher);
		    g_arbres = new ObjectOutputStream(support);
		    g_arbres.writeObject(arbreFruitiers);
		    g_arbres.writeObject(arbreOrnements);
		    support.flush();
		    support.close();
        } catch(final java.io.IOException e) {
            System.out.println(e);
        }
    }

    public static void deSerialiserArbres(String nomFicher) throws ClassNotFoundException {
        ObjectInputStream g_arbres;
        try{
            FileInputStream support = new FileInputStream(nomFicher);
            g_arbres = new ObjectInputStream(support);
            arbreFruitiers = (ArrayList<ArbreFruitier>) g_arbres.readObject();
            arbreOrnements = (ArbreOrnement[]) g_arbres.readObject();
			support.close();
        } catch(final java.io.IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ArbreFruitier af1 = new ArbreFruitier("pomme", MoisAnnee.Mars);
        af1.setAnneePlantation(2007);
        af1.setNom("Arbre Fruitier 1");
        ArbreFruitier af2 = new ArbreFruitier("pomme", MoisAnnee.Mars);
        af2.setAnneePlantation(2010);
        af2.setNom("Arbre Fruitier 2");
        ArbreFruitier af3 = new ArbreFruitier("pomme", MoisAnnee.Mars);
        af3.setAnneePlantation(2005);
        af3.setNom("Arbre Fruitier 3");
        arbreFruitiers.add(af1);
        arbreFruitiers.add(af2);
        arbreFruitiers.add(af3);

        ArbreOrnement ao1 = new ArbreOrnement(essenceDarbre.Charme, false);
        ao1.setAnneePlantation(2007);
        ao1.setNom("Arbre Ornement 1");
        ArbreOrnement ao2 = new ArbreOrnement(essenceDarbre.Erable, false);;
        ao2.setAnneePlantation(2001);
        ao2.setNom("Arbre Ornement 2");
        ArbreOrnement ao3 = new ArbreOrnement(essenceDarbre.Peubliers, true);;
        ao3.setAnneePlantation(2009);
        ao3.setNom("Arbre Ornement 3");
        arbreOrnements[0] = ao1;
        arbreOrnements[1] = ao2;
        arbreOrnements[2] = ao3;

        System.out.println("--------- Avant Traitement pour les arbres fruitiers ---------\n");
        for (int i = 0; i < arbreFruitiers.size(); i++) {
            System.out.println(arbreFruitiers.get(i).nom + " : " + arbreFruitiers.get(i).anneePlantation);
        }
        resetAnneePlantation();
        System.out.println("\n--------- Apres Traitement ---------\n");
        for (int i = 0; i < arbreFruitiers.size(); i++) {
            System.out.println(arbreFruitiers.get(i).nom + " : " + arbreFruitiers.get(i).anneePlantation);
        }

        System.out.println("--------- Avant Traitement pour les arbres ornements ---------\n");
        for (int i = 0; i < arbreOrnements.length; i++) {
            System.out.println(arbreOrnements[i].nom + " : " + arbreOrnements[i].anneePlantation);
        }
        sortParAnneeOrnement();
        System.out.println("\n--------- Apres ornements ---------\n");
        for (int i = 0; i < arbreOrnements.length; i++) {
            System.out.println(arbreOrnements[i].nom + " : " + arbreOrnements[i].anneePlantation);
        }

        // System.out.println("Before serialized : ");
        // serialiserArbres("resultatTDNote2022");
        deSerialiserArbres("resultatTDNote2022");
        System.out.println("After deserialized : ");

        arbreFruitiers.forEach(new Consumer<ArbreFruitier>() {
            public void accept(ArbreFruitier a){
                System.out.println(a.getNom() + " " + a.getNomFruit() + " " + a.getHauteur());
            }
        });
    }
}
