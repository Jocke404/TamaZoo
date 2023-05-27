package it.unibs.fp.tamazooanimals;

public class SadTama extends Tamagotchi {
	
    public SadTama(String name) {
        super(name);
    }


    public SadTama(String name, int satiety) {
        super(name, satiety, 50);
    }

    @Override
    public boolean imSad() {
        return true;
    }

    @Override
    public boolean imDead() {
        return satiety <= 0 || satiety >= 100;
    }

    @Override
    public void receiveBiscuits(int biscuits) {

    }
}
