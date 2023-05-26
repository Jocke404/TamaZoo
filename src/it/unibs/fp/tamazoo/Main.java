package it.unibs.fp.tamazoo;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.NumeriCasuali;
import it.unibs.fp.tamazooanimals.IOUtil;
import it.unibs.fp.tamazooanimals.Tamagotchi;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    private static final int MAX_10 = 10;
    private static final int MIN_1 = 1;
    static ArrayList<Tamagotchi> zoo = new ArrayList<>();
    static String[] chooses = {"Dai carezze", "Dai biscotti"};
    public static void main(String[] args) {
        System.out.println("Benvenuto nel magico mondo dei Tamagotchi!!!");
        int TamagotchiCount = InputDati.leggiIntero("Inserisci il numero di Tamagotchi da inserire: ", 1, 10);
        for (int i = 0; i < TamagotchiCount; i++) {
            Tamagotchi tama = IOUtil.createTamagotchi();
            zoo.add(tama);
        }
        MyMenu menu = new MyMenu("Scegli cosa fare:", chooses);
        boolean finish = false;
        do {
            int choice = menu.scegli();
            Iterator<Tamagotchi> each = zoo.iterator();
            while (each.hasNext()) {
                Tamagotchi t = each.next();
                switch (choice) {
                    case 1:
                        t.receiveCaresses(NumeriCasuali.estraiIntero(MIN_1, MAX_10));
                        break;
                    case 2:
                        t.receiveBiscuits(NumeriCasuali.estraiIntero(MIN_1, MAX_10));
                        break;
                    case 0:
                        finish = true;
                        break;
                }
                //System.out.println(String.format("\nTamagotchi: %s\n", t.toString()));

                if (t.imDead()) {
                    System.out.println(String.format("-----Il Tamagotchi %s e' morto e verra' sepellito-----", t.getName()));
                    System.out.println("\t\t-----R.I.P-----");
                    finish = false;
                    each.remove();
                } else {
                	System.out.println(String.format("\nTamagotchi: %s\n", t.toString()));
                }
            }

            if (zoo.isEmpty()) {
                System.out.println(String.format("----- Il TamaZoo e' vuoto-----"));
                finish = true;
            }
        } while (!finish);
        System.out.println("***ARRIVEDERCI***");
    }
}
