package it.unibs.fp.tamazooanimals;

public class SadTama extends Tamagotchi {
	/*
    public SadTama(String name) {
        super(name);
    }
    */


    public SadTama(String name, int satiety) {
        super(name, 0, satiety);
        this.typeName = "sad";
    }

    @Override
    public boolean imSad() {
        return true;
    }

    @Override
    public boolean imDead() {
        return getSatiety() == 0 || getSatiety() >= SOGLIA_MAX;
    }

    @Override
    public void receiveBiscuits(int biscuits) {
    	for(int i = 1; i <= biscuits; i++) {
    		setSatiety(Math.min(getSatiety()* BISCUIT_FACTOR, SOGLIA_MAX));
    	}
    }
    
    @Override
    public void receiveCaresses(int caresses) {
    	setSatiety(Math.max(0, getSatiety()- caresses/CARESSES_FACTOR));
    }
    
}
