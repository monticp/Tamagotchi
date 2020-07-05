package com.company;


public class IOHandler{

    public static final int INPUT_COMER = 1;
    public static final int INPUT_JUGAR = 2;

    private Printer printer;
    private ScannerT scannerT;

    public IOHandler (Printer printer, ScannerT scannerT){
        this.printer = printer;
        this.scannerT = scannerT;
    }

    public void run (Tamagotchi tamagotchi) {
        try {
            print(tamagotchi);
            read(tamagotchi);
        }catch (Exception e){
            this.printer.printMovimientoNoPermitido();
            read(tamagotchi);
        }
    }

    public void  print (Tamagotchi tamagotchi){
        printer.printAll(tamagotchi, INPUT_COMER, INPUT_JUGAR);
    }

    public void read (Tamagotchi tamagotchi) {
        try {
            int input = scannerT.scan();
            if (input == INPUT_COMER) {
                this.printer.printHaComido();
                tamagotchi.comer();
                read(tamagotchi);
            } else if (input == INPUT_JUGAR) {
                this.printer.printHaJugado();
                tamagotchi.jugar();
                read(tamagotchi);
            } else {
                throw new MovimientoNoPermitidoException();
            }
        } catch (MovimientoNoPermitidoException e){
            printer.printMovimientoNoPermitido();
            this.read(tamagotchi);
        }
    }

}
