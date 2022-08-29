package cz.martin.models;

import java.util.HashMap;

//Objekt, který reprezentuje zemi
public class Country {
    private String code;
    private String name;

    //Mapa, do které se ukládají hdp za jednotlivé roky
    private HashMap<String, Double> gdp = new HashMap<>();

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    //Metoda, která slouží pro přidání roku do mapy, jako parametr dostane rok a hdp za ten rok
    public void addGdp(String year, double gdp) {
        this.gdp.put(year, gdp);
    }

    //--------------------Getters---------------
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Double> getGdp() {
        return gdp;
    }
}
