package orai1002;

import java.util.Scanner;

public class Orai1002 {

    private static String[] pakli = new String[22];
    private static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) {
        feltolt();
        for (int i = 0; i < 3; i++) {
            kirak();
            int oszlop = melyik();
            kever(oszlop);
        }

        ezVolt();
    }

    private static void feltolt() {
        String[] szinek = {"P", "T", "M", "Z"};
        String[] ertekek = {"Ász", "Király", "Felső", "Alsó", "X", "IX", "VIII"};
        int j = 1;
        for (String szin : szinek) {
            for (int i = 1; i < ertekek.length && j < pakli.length; i++) {
                pakli[j++] = szin + "_" + ertekek[i];
            }
        }
    }

    private static void kirak() {
        for (int i = 1; i < pakli.length; i++) {
            System.out.println("  "+ pakli[i]);
            if (i % 7 == 0) {
                System.out.println("");
            }
        }
    }

    private static int melyik() {
        int oszlop = 0;
        boolean jo;
        do {
            System.out.println("Melyik oszlop (1-3): ");
            oszlop = scr.nextInt();
            jo = oszlop >= 1 && oszlop <= 3;
        } while (!jo);

        return oszlop;
    }

    private static void kever(int oszlop) {
        String[] ujPakli = new String[22];
        switch (oszlop) {
            case 1:
                for (int i = 1; i <= 7; i++) {
                    ujPakli[i] = pakli[20 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[21 - (i - 1) * 3];
                }
                break;
            case 2:
                for (int i = 1; i <= 7; i++) {
                    ujPakli[i] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[20 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[21 - (i - 1) * 3];
                }
                break;
            case 3:
                for (int i = 1; i <= 7; i++) {
                    ujPakli[i] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[21 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[20 - (i - 1) * 3];
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    private static void ezVolt() {
        System.out.println("Kiválasztott lap: " + pakli[11]);

    }

}
