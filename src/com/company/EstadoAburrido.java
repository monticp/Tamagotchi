package com.company;
import javafx.util.Pair;

import java.util.Timer;
import java.util.TimerTask;

public class EstadoAburrido extends Estado implements Postponable {

    public static final String NAME = "ABURRIDO";

    public static final int CRITICAL_TIME = 4800;
    public static final int EATING_HAPPINESS_CHANGE = 0;
    public static final int PLAYING_HAPPINESS_CHANGE = 0;
    public static final int BOREDOM_HAPPINESS_CHANGE = -1;

    private static EstadoAburrido estadoAburrido;

    private Pair<Timer, TimerTask> timerTask;

    private boolean criticalTimeOut;


    private EstadoAburrido (){
        super.setName(NAME);
    }


    public static EstadoAburrido newEstadoAburrido() {
        if (estadoAburrido == null) {
            estadoAburrido = new EstadoAburrido();
        }
        estadoAburrido.criticalTimeOut = false;
        estadoAburrido.timerTask = TimerManager.newTimerManager().resetCountTime(
                estadoAburrido.timerTask, CRITICAL_TIME, estadoAburrido, CRITICAL_TIME);
        return estadoAburrido;
    }


    public void doPostponableTask (int random){
        this.criticalTimeOut = true;
    }

    @Override
    public Pair<Estado, Integer> aburrirse(){
        return new Pair<>(null, BOREDOM_HAPPINESS_CHANGE);
    }

    @Override
    public Pair<Estado, Integer> comer() {
        if(!this.criticalTimeOut){
            return new Pair<>(EstadoContento.newEstadoContento(), EATING_HAPPINESS_CHANGE);
        }
        return new Pair<>(null, EATING_HAPPINESS_CHANGE);
    }

    @Override
    public Pair<Estado, Integer> jugar() {
        return new Pair<>(EstadoContento.newEstadoContento(), PLAYING_HAPPINESS_CHANGE);
    }

}
