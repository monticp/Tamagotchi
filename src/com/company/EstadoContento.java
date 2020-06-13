package com.company;

import javafx.util.Pair;

public class EstadoContento extends Estado {

    public static final String NAME = "CONTENTO";

    public static final int EATING_HAPPINESS_CHANGE = 1;
    public static final int PLAYING_HAPPINESS_CHANGE = 2;
    public static final int BOREDOM_HAPPINESS_CHANGE = 0;


    private static EstadoContento estadoContento;

    private EstadoContento (){
        super.setName(NAME);
    }


    public static EstadoContento newEstadoContento(){
        if(estadoContento == null){
            estadoContento = new EstadoContento();
        }
        return estadoContento;
    }

    @Override
    public Pair<Estado, Integer> aburrirse(){
        return new Pair<>(EstadoAburrido.newEstadoAburrido(), BOREDOM_HAPPINESS_CHANGE);
    }

    @Override
    public Pair<Estado, Integer> comer() {
        return new Pair<>(null, EATING_HAPPINESS_CHANGE);
    }

    @Override
    public Pair<Estado, Integer> jugar() {
        return new Pair<>(null, PLAYING_HAPPINESS_CHANGE);
    }

}
