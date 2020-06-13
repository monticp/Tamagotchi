package com.company;

import javafx.util.Pair;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimerManager {

    public static final int MSTOS = 1000;

    private TimerManager (){ }

    public static TimerManager newTimerManager () {
        return new TimerManager();
    }

    public Pair<Timer, TimerTask> countTime (int seconds, Postponable postponable, int id){
            Timer timer = new Timer();
            int interval = seconds*MSTOS;
            new Thread().start();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    postponable.doPostponableTask(id);
                }
            };
            timer.scheduleAtFixedRate(timerTask, interval, interval);
            return new Pair<>(timer, timerTask);
    }

    public Pair<Timer, TimerTask> resetCountTime (Pair<Timer, TimerTask> pair, int seconds, Postponable postponable, int id) {
        if(pair != null) { cancelCountTime(pair); }
        return this.countTime(seconds, postponable, id);
    }

    public void cancelCountTime (Pair<Timer, TimerTask> pair){
        pair.getValue().cancel();
        pair.getKey().cancel();
    }


    }
