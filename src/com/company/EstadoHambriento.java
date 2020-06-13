package com.company;

import javafx.util.Pair;

public class EstadoHambriento extends Estado {

    public static final String NAME = "HAMBRIENTO";

    public static final int EATING_HAPPINESS_CHANGE = 0;
    public static final int BOREDOM_HAPPINESS_CHANGE = 0;


    private static EstadoHambriento estadoHambriento;

    private EstadoHambriento (){
        super.setName(NAME);
    }

    public static EstadoHambriento newEstadoHambriento (){
        if(estadoHambriento == null){
            estadoHambriento = new EstadoHambriento();
        }
        return estadoHambriento;
    }

    @Override
    public Pair<Estado, Integer> aburrirse (){ return new Pair<>(EstadoAburrido.newEstadoAburrido(), BOREDOM_HAPPINESS_CHANGE); }

    @Override
    public Pair<Estado, Integer> comer() {
        return new Pair<>(EstadoContento.newEstadoContento(), EATING_HAPPINESS_CHANGE);
    }

    @Override
    public Pair<Estado, Integer> jugar() throws MovimientoNoPermitidoException{
        throw new MovimientoNoPermitidoException();
    }

}
