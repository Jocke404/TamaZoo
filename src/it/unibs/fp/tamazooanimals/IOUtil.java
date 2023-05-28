package it.unibs.fp.tamazooanimals;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.NumeriCasuali;


import static it.unibs.fp.tamazooanimals.Tamagotchi.SOGLIA_MAX;
import static it.unibs.fp.tamazooanimals.Tamagotchi.SOGLIA_MIN;


public class IOUtil {

    private static final String DAI_UN_NOME_AL_TUO_TAMAGOTCHI = "\nDai un nome al tuo amico:\n";
    
     // Il seguente metodo serve a ricevere l'input dell'utente per istanziare il Tamagotchi.
    public static Tamagotchi createTamagotchi() {
        int  random = NumeriCasuali.estraiIntero(0, 2);
        String name = InputDati.leggiStringaNonVuota(DAI_UN_NOME_AL_TUO_TAMAGOTCHI);
        int affection = NumeriCasuali.estraiIntero(SOGLIA_MIN, SOGLIA_MAX);
        int satiety = NumeriCasuali.estraiIntero(SOGLIA_MIN, SOGLIA_MAX);
        Tamagotchi tamA = null;
        switch (random) {
            case 0:
                tamA = new Tamagotchi(name, affection, satiety);
                break;
            case 1:
                tamA = new HungryTama(name, satiety);
                break;
            case 2:
                tamA = new SadTama(name, affection);
                break;
        }
		return tamA;
    }
}
