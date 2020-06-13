package com.company;

public class Main {

    public static void main(String[] args) {
        try{
            Printer p = new Printer();
            ScannerT s = new ScannerT();
            IOHandler ioh = new IOHandler(p, s);
            Tamagotchi t = new Tamagotchi(ioh);
            ioh.run(t);
        }catch (Exception e){
            System.out.println("\nLa sesión se ha interrumpido. Reinicie y comience nuevamente. \n");
        }
    }
}
