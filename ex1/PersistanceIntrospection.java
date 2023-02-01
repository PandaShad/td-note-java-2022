package ex1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class PersistanceIntrospection {
    ArrayList<String> res = new ArrayList<>();

    public String[] remonterIncoherence (String nomClasse) throws ClassNotFoundException {
        Class<?> cl = Class.forName(nomClasse);
        ComplementClasse[] annotations = cl.getAnnotationsByType(ComplementClasse.class);
        boolean shouldBeSerializable = annotations[0].shouldBeSerializable();
        Field[] fields = cl.getDeclaredFields();
        for(Field field : fields) {
            ComplementChamp[] annotationsField = field.getAnnotationsByType(ComplementChamp.class);
            for(ComplementChamp complementChamp : annotationsField){
                if(shouldBeSerializable == complementChamp.ShouldBePersistent()){
                    res.add(field.getName());
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String[] res = new PersistanceIntrospection().remonterIncoherence("ex1.Arbre");
        for (String incoherence : res) {
            System.out.println(incoherence);
        }
    }
}
