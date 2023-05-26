package it.unibs.fp.tamazooanimals;

import static org.junit.Assert.*;

import org.junit.Test;

public class HungryTamaTest {
	@Test
	public void tamagordoShouldNotDieDueToTooManyCookies() throws Exception {
		Tamagotchi tama = new HungryTama("gordo", 90);
		tama.receiveBiscuits(100);
		assertTrue(!tama.imSad());
	}

	@Test
	public void tamagordoDiesDueToHunger() throws Exception {
		Tamagotchi tama = new HungryTama("gordo", 0);
		assertTrue(tama.imDead());
	}
}
