package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Continent {
    private final String continentName;
    private final List<Country> theListOfCountry = new ArrayList<>();

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public void addCountry(Country country) {
        theListOfCountry.add(country);
    }

    public boolean removeCountry(Country country) {
        return theListOfCountry.remove(country);
    }

    public String getContinentName() { return continentName; }

    public List<Country> getTheListOfCountry() {
        return theListOfCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continent continent = (Continent) o;
        return Objects.equals(theListOfCountry, continent.theListOfCountry);
    }

    @Override
    public int hashCode() {

        return Objects.hash(theListOfCountry);
    }
}
