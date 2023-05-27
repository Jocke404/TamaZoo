package it.unibs.fp.tamazoo;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.NumeriCasuali;
import it.unibs.fp.tamazooanimals.HungryTama;
import it.unibs.fp.tamazooanimals.IOUtil;
import it.unibs.fp.tamazooanimals.SadTama;
import it.unibs.fp.tamazooanimals.Tamagotchi;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	protected static final int SOGLIA_MAX = 100;
    protected static final int SOGLIA_MIN = 0;
	private static final String DAI_UN_NOME_AL_TUO_TAMAGOTCHI = "Dai un nome al tuo amico:\n";
    private static final int MAX_10 = 10;
    private static final int MIN_1 = 1;
    static ArrayList<Tamagotchi> zoo = new ArrayList<>();
    //static TamaZoo tamaZoo = new TamaZoo();
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
                Tamagotchi tama = each.next();
                switch (choice) {
                    case 1:
                        tama.receiveCaresses(NumeriCasuali.estraiIntero(MIN_1, MAX_10));
                        break;
                    case 2:
                        tama.receiveBiscuits(NumeriCasuali.estraiIntero(MIN_1, MAX_10));
                        break;
                    case 0:
                        finish = true;
                        break;
                }
                //System.out.println(String.format("\nTamagotchi: %s\n", t.toString()));

                if (tama.imDead()) {
                    System.out.println(String.format("-----Il Tamagotchi %s e' morto e verra' sepellito-----", tama.getName()));
                    System.out.println("\t\t-----R.I.P-----");
                    finish = false;
                    each.remove();
                } else {
                	System.out.println(String.format("\nTamagotchi: %s\n", tama.toString()));
                }
            }

            if (zoo.isEmpty()) {
                System.out.println(String.format("----- Il TamaZoo e' vuoto-----"));
                finish = true;
            }
        } while (!finish);
        System.out.println("***ARRIVEDERCI***");
    }
    /*
    // Il seguente metodo serve a ricevere l'input dell'utente per istanziare il Tamagotchi.
    public static IOUtil createTamagotchi() {
        String name = InputDati.leggiStringaNonVuota(DAI_UN_NOME_AL_TUO_TAMAGOTCHI);
       }
       */
}
