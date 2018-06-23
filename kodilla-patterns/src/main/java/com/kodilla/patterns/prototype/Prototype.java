package com.kodilla.patterns.prototype;

public class Prototype<T> implements Cloneable {

//    @Override
//    public T clone() throws CloneNotSupportedException {
//        return (T)super.clone();
//    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
