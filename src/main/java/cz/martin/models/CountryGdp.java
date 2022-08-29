package cz.martin.models;

//Objekt, který slouží pro splnění úkolu 1 (viz. ukázka v zadání 1)

public class CountryGdp {
    private String name;
    private double gdp;

    public CountryGdp(String name, double gdp) {
        this.name = name;
        this.gdp = gdp;
    }

    public String getName() {
        return name;
    }

    public double getGdp() {
        return gdp;
    }
}
