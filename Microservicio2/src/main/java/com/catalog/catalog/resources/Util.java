package com.catalog.catalog.resources;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import com.catalog.catalog.model.Vets;




// Creamos la clase Util la cual basicamente va a manejar todos las instancias de Animals, ademas va a crear el mapa de la info de nuestors animales.
public class Util {
    private static final HashMap<String, List<Vets>> map = new HashMap<>();
    private static Util instance;

    public static synchronized Util getInstance() {
        if(instance == null) {
            instance = new Util();
        }
        return instance;
    }

    public List<Vets> getValue(String key){
        return map.get(key);
    }

    public void add(String key, List<Vets> animals) {
        map.put(key, animals);
    }

    public List<Vets> getVetInfo(String key, String vetIdParamText) {
        //Creamos una lista de Animales(Objetos)
        // Preguntar si es vacia (if)
        List<Vets> list = map.get(key);

        // Pasamos la lista completa a un stream y luego generamos una nueva lista la cual solo tiene los Animales(Objetos) que contienen un valor de atributo especifico.
        // En este caso el parametro es el animalOwner
        List<Vets> filteredList = list.stream().filter(obj -> obj.getVetId().equals(vetIdParamText)).collect(Collectors.toList());

        //Devolvemos la nueva lista
        return filteredList;
    }

    public List<Vets> getVetInfo_vetName(String key, String animalNameParamText) {
        List<Vets> list = map.get(key);
        List<Vets> filteredList = list.stream().filter(obj -> obj.getVetName().equals(animalNameParamText)).collect(Collectors.toList());
        return filteredList;
    }


}
