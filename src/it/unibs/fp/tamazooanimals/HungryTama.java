package it.unibs.fp.tamazooanimals;
/**
 * This class is an extension of Tamagotchi and is used to create 
 * a different species of Tama called HungryTama.
 * @param name Name that the user types in  
 * @param typeName Species name
 */
public class HungryTama extends Tamagotchi{
private static final int CARESSES_AMPLIFICATION = 2;
	
    public HungryTama(String name, int satiety) {
        super(name, SOGLIA_MAX, satiety);
        this.typeName = "hungry";
    }

    @Override
    public void receiveCaresses(int caresses) {
        setSatiety(Math.max(0, getSatiety()-(CARESSES_AMPLIFICATION*caresses/CARESSES_FACTOR)));
    }

    @Override
    public void receiveBiscuits(int biscuits) {
        for(int i=1; i<=biscuits; i++) {
            setSatiety(Math.min(getSatiety() * BISCUIT_FACTOR, SOGLIA_MAX));
        }
    }

    @Override
    public boolean imSad() {
        return getSatiety() < MIN_HAP_SATIETY;
    }

    @Override
    public boolean imDead(){
    	return getSatiety() == 0;
    }
}
