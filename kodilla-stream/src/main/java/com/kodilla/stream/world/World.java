package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    private final List<Continent> theListOfContinent = new ArrayList<>();

    public void addContinent(Continent continent) {
        theListOfContinent.add(continent);
    }

    public boolean removeContinent(Continent continent) {
        return theListOfContinent.remove(continent);
    }

    public BigDecimal getPeopleQuantity() {
        return theListOfContinent.stream()
                .flatMap(continent -> continent.getTheListOfCountry().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, value) -> sum = sum.add(value));
    }
}
