package cz.martin.models;

//Objekt, který slouží pro splnění úkolu 3 (viz. ukázka v zadání 3)
public class Change {
    private String name;
    private String code;
    private double gdpChange;

    public Change(String name, String code, double gdpChange) {
        this.name = name;
        this.code = code;
        this.gdpChange = gdpChange;
    }

    //--------------------Getters---------------

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getGdpChange() {
        return gdpChange;
    }
}
