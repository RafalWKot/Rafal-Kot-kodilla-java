package com.kodilla.testing.shape;


import java.util.Objects;

public class Triangle implements Shape {
    private String name;
    private Double sideA;
    private Double sideB;
    private Double sideC;
    private Double field;

    public Triangle(Double sideA, Double sideB, Double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        name = "Triangle";
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public Double getField() {
        return field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(name, triangle.name) &&
                Objects.equals(sideA, triangle.sideA) &&
                Objects.equals(sideB, triangle.sideB) &&
                Objects.equals(sideC, triangle.sideC) &&
                Objects.equals(field, triangle.field);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, sideA, sideB, sideC, field);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "name='" + name + '\'' +
                ", sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                ", field=" + field +
                '}';
    }
}