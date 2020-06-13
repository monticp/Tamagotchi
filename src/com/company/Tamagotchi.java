package com.company;

import javafx.util.Pair;

import java.util.Timer;
import java.util.TimerTask;

public class Tamagotchi implements Postponable {

    private Pair<Timer, TimerTask> hungryTimerTask;
    private Pair<Timer, TimerTask> boredTimerTask;

    public static final int MAX_FELICIDAD = 10;
    public static final int MIN_FELICIDAD = 0;

    private IOHandler ioHandler;

    private Estado estado;
    private int felicidad = MAX_FELICIDAD;


    public Tamagotchi (IOHandler ioHandler){
        this.ioHandler = ioHandler;
        this.setEstado(EstadoContento.newEstadoContento());
        this.hungryTimerTask = TimerManager.newTimerManager().countTime(
                CriticalPoint.HUNGRY.getCriticalPoint(), this, CriticalPoint.HUNGRY.getId()
        );
        this.boredTimerTask = TimerManager.newTimerManager().countTime(
                CriticalPoint.BORED.getCriticalPoint(), this, CriticalPoint.BORED.getId()
        );
    }


    public int getFelicidad() {
        return this.felicidad;
    }

    public String getEstado () { return this.estado.getEstado(); }


    public void setFelicidad(int felicidad) {
        if (felicidad > MAX_FELICIDAD){
            this.felicidad = MAX_FELICIDAD;
        } else if (felicidad < MIN_FELICIDAD){
            this.felicidad = MIN_FELICIDAD;
        } else {
            this.felicidad = felicidad;
        }
    }

    public void setEstado(Estado estado) {
        if (estado != null) {
            this.estado = estado;
        }
    }

    public void doPostponableTask (int id){
        if (CriticalPoint.BORED.getId() == id) {
            this.setPair(this.estado.aburrirse());
        } else if (CriticalPoint.HUNGRY.getId() == id) {
            this.setPair(new Pair<>(EstadoHambriento.newEstadoHambriento(), 0));
        }
    }

    public void comer() {
        this.setPair(this.estado.comer());
        this.hungryTimerTask = TimerManager.newTimerManager().resetCountTime(
                this.hungryTimerTask, CriticalPoint.HUNGRY.getCriticalPoint(), this, CriticalPoint.HUNGRY.getId()
                );
    }

    public void jugar() throws MovimientoNoPermitidoException{
        this.boredTimerTask = TimerManager.newTimerManager().resetCountTime(
                this.boredTimerTask, CriticalPoint.BORED.getCriticalPoint(), this, CriticalPoint.BORED.getId()
        );
        this.setPair(this.estado.jugar());
    }


    private void setPair (Pair<Estado, Integer> pair){
        this.setEstado(pair.getKey());
        this.setFelicidad(this.getFelicidad() + pair.getValue());
        this.ioHandler.print(this);
    }
}

