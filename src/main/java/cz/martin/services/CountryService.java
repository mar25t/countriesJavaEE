package cz.martin.services;

import cz.martin.data.Data;
import cz.martin.models.Change;
import cz.martin.models.Country;
import cz.martin.models.CountryGdp;
import cz.martin.models.YearsGdp;

import java.util.ArrayList;
import java.util.HashMap;

/*
* Time info:
*      Part 1 - 20min
*      Part 2 - 5min
*      Part 3 - 7min
* */
public class CountryService {
    //list, do kterého uložím všechny zpracované země
    private ArrayList<Country> countries;

    //Mapa, která slouží ke splnění úkolu 1. Klic je vzdy kod zeme. Hodnota je objekt "CountryGdp", který obsahuje jméno a hdp
    private HashMap<String, CountryGdp> all = new HashMap<>();

    //List, který slouží ke splnění úkolu 3. Jedná se o list, ve kterém jsou uloženy rozdíly hdp za rok 2010 a 2021
    private ArrayList<Change> changes = new ArrayList<>();

    public CountryService() {
        Data data = new Data();
        countries = data.getCountries();

        //projedu vsechny zeme forem
        for (int i = 0; i < countries.size(); i++) {
            /*
            * Do mapy "all" pridam
            *       klic - kod zeme
            *       hodnota - vytvorim instanci classy CountryGdp, kterou v konstruktoru naplním daty
            * Slouzi ke splneni ukolu 1
            * */
            all.put(countries.get(i).getCode(), new CountryGdp(countries.get(i).getName(), countries.get(i).getGdp().get("2021")));

            //Pokud zeme ma vyplnene hdp za rok 2010 i 2021, spocitam rozdil a pridam ho do listu change (slouzi pro ukol 3)
            if(countries.get(i).getGdp().get("2010") != -1 && countries.get(i).getGdp().get("2021") != -1) {
                changes.add(new Change(countries.get(i).getName(), countries.get(i).getCode(), countries.get(i).getGdp().get("2021") - countries.get(i).getGdp().get("2010")));
            }
        }

        //Protože list v ukolu 3 ma byt serazeny (a streamy asi neumis) pouzije se algoritmus bubble sort, který list seřadí od nejvetšího růstu po nejmenší
        for (int i = 0; i < changes.size(); i++) {
            for (int j = 0; j < changes.size(); j++) {
                if(changes.get(i).getGdpChange() > changes.get(j).getGdpChange()) {
                    Change c = changes.get(i);
                    changes.set(i, changes.get(j));
                    changes.set(j, c);
                }
            }
        }
    }

    //Metoda, která slouží k nalezení země podle kódu
    //Pouziva se u ukolu 2, kde si uzivatel vybira, data ktere zeme chce zobrazit
    public YearsGdp findCountryByCode(String code) {
        //Projedu všechny zeme forem
        for (int i = 0; i < countries.size(); i++) {
            //pokud je kod zeme na indexu "i" stejna jako hledany kod, vratim tuto zemi
            if(countries.get(i).getCode().trim().equalsIgnoreCase(code.trim())) {
                return new YearsGdp(countries.get(i).getName(), countries.get(i).getGdp());
            }
        }

        //Pokud program dojde až sem, znamená to, že hledany kod není v seznamu. Metoda proto vrati null.
        return null;
    }

    //----------------Getters---------------

    //Ukol 1
    public HashMap<String, CountryGdp> getAll() {
        return all;
    }

    //Ukol3
    public ArrayList<Change> getChanges() {
        return changes;
    }
}
