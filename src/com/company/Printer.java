package com.company;

public class Printer {

    public static final int MAGIC_NUMBER_1 = 0;
    public static final int MAGIC_NUMBER_2 = 5;


    public static void printAll (Tamagotchi tamagotchi, int inputComer, int inputJugar){
        System.out.println(" Estado: " + tamagotchi.getEstado() + "\t\t Felicidad: " + tamagotchi.getFelicidad());
        printTamaCase(tamagotchi.getFelicidad());
        System.out.println("\nPresione " + inputComer + " para alimentarla o " + inputJugar + " para jugar");
        System.out.println("\n**********************************************************************************");
    }

    public static void printMovimientoNoPermitido (){
        System.out.println("El movimiento no está permitido...");
    }

    public static void printHaComido (){
        System.out.println("Tamagotchi ha comido.");
    }

    public static void printHaJugado () {
        System.out.println("Tamagotchi ha jugado.");
    }

    public static void printTamaCase (int felicidad){
        if (felicidad >= MAGIC_NUMBER_2 ){
            System.out.println(
                                     "  ________________  "
                            + "\n" + " |    __    __    |  "
                            + "\n" + " |   |  |  |  |   | "
                            + "\n" + " \\                / "
                            + "\n" + "  \\   \\______/   /  "
                            + "\n" + "   \\____________/    "
            );
        }
        else if (felicidad > MAGIC_NUMBER_1){
            System.out.println(
                             "  ________________  "
                    + "\n" + " |   |            |  "
                    + "\n" + " |   ____  ____   |"
                    + "\n" + " \\                / "
                    + "\n" + "  \\    ______    /  "
                    + "\n" + "   \\____________/    "
            );
        }
        else {
            System.out.println(
                              "\n" + "  ________________  "
                            + "\n" + " |                |  "
                            + "\n" + " |    \\/   \\/     |"
                            + "\n" + " \\    /\\   /\\     / "
                            + "\n" + "  \\    _______   /  "
                            + "\n" + "   \\_______( )__/    "
            );
        }
    }
}
