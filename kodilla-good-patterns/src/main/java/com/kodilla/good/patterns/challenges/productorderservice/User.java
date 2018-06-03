package com.kodilla.good.patterns.challenges.productorderservice;

import java.util.Objects;

public class User {
    private final String name;
    private final String surname;
    private final int idUser;

    public User(String name, String surname, int idUser) {
        this.name = name;
        this.surname = surname;
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getIdUser() {
        return idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser == user.idUser &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, surname, idUser);
    }
}
