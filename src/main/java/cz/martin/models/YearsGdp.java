package cz.martin.models;

import java.util.HashMap;

//Objekt, který slouží pro splnění úkolu 2 (viz. ukázka v zadání 2)

public class YearsGdp {
    private String country;
    private HashMap<String, Double> gdp;

    public YearsGdp(String country, HashMap<String, Double> gdp) {
        this.country = country;
        this.gdp = gdp;
    }

    //--------------------Getters---------------

    public String getCountry() {
        return country;
    }

    public HashMap<String, Double> getGdp() {
        return gdp;
    }
}
