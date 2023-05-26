package it.unibs.fp.tamazooanimals;

public class HungryTama extends Tamagotchi{

    public HungryTama(String name) {
        super(name);
        this.affection=SOGLIA_MAX;
    }

    public HungryTama(String name, int satiety) {
        super(name, SOGLIA_MAX, satiety);
    }

    public HungryTama(String name, int affection, int satiety) {
        super(name, SOGLIA_MAX, satiety);
    }

    @Override
    public void receiveCaresses(int caresses) {
        satiety = Math.max(0, satiety-caresses/(CARESSES_FACTOR/2));
    }

    @Override
    public void receiveBiscuit(int biscuits) {
        for(int i=1; i<=biscuits; i++) {
            satiety = Math.min(satiety * BISCUIT_FACTOR, SOGLIA_MAX);
        }
    }

    @Override
    public boolean imSad() {
        return affection < MIN_HAP_AFFECTION || satiety < MIN_HAP_SATIETY;
    }

    @Override
    public boolean imDead(){
        return affection == 0 || satiety == 0;
    }
}
