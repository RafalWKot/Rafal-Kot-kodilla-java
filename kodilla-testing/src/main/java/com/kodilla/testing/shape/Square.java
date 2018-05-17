package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {
    private String name;
    private Double side;
    private Double field;

    public Square(Double side) {
        this.side = side;
        name = "Circle";
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public Double getField() {
        field = side * side;
        return field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Objects.equals(name, square.name) &&
                Objects.equals(side, square.side) &&
                Objects.equals(field, square.field);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, side, field);
    }

    @Override
    public String toString() {
        return "Square{" +
                "name='" + name + '\'' +
                ", side=" + side +
                ", field=" + field +
                '}';
    }
}
