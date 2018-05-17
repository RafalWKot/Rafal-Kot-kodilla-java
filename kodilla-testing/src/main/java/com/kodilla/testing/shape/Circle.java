package com.kodilla.testing.shape;

import java.util.Objects;

public class Circle implements Shape{
    private String name;
    private Double radius;
    private Double field;

    public Circle(Double radius) {
        this.radius = radius;
        name = "Circle";
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public Double getField() {
        field = radius * radius * 3.14;
        return field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Objects.equals(name, circle.name) &&
                Objects.equals(radius, circle.radius) &&
                Objects.equals(field, circle.field);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, radius, field);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "name='" + name + '\'' +
                ", radius=" + radius +
                ", field=" + field +
                '}';
    }
}
