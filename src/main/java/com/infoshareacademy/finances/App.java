package com.infoshareacademy.finances;


public class App 
{
    public static void main( String[] args ) throws Exception {
        System.out.println("Financial analyser 1.0");
        if (args.length != 0) {
            System.out.println("Input file argument: " + args[0]);

        } else {
            System.out.println("Enter two arguments:");
            System.out.println("first: path to fund zip file");
            System.out.println("second: fund ID");
            System.out.println("example: path_to/omefafun.zip AGI001");
            System.exit(0);
        }

    }
}
