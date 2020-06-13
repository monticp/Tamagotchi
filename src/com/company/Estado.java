package com.company;

import javafx.util.Pair;

public abstract class Estado{

    private String name;


    public abstract Pair<Estado, Integer> aburrirse ();

    public abstract Pair<Estado, Integer> comer();

    public abstract Pair<Estado, Integer> jugar() throws MovimientoNoPermitidoException;

    public String getEstado () {
        return this.name;
    }

    protected void setName (String name){
        this.name = name;
    }

}
