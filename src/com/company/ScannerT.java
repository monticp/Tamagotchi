package com.company;

public class ScannerT {

    public static int scan () {
        java.util.Scanner s = new java.util.Scanner(System.in);
        int input = s.nextInt();
        System.out.println(input);
        return input;
    }
}
