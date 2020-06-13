package com.company;

public enum CriticalPoint {

    BORED(1, EstadoAburrido.NAME, 15),
    HUNGRY(2, EstadoHambriento.NAME, 20);

    private int id;
    private String name;
    private int criticalPoint;

    private CriticalPoint (int id, String name,  int criticalPoint){
        this.id = id;
        this.name = name;
        this.criticalPoint = criticalPoint;
    }

    public int getId (){
        return this.id;
    }

    public String getName (){
        return this.name;
    }

    public int getCriticalPoint (){
        return this.criticalPoint;
    }
}
