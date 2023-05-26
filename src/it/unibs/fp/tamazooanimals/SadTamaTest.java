package it.unibs.fp.tamazooanimals;

import static org.junit.Assert.*;

import org.junit.Test;

public class SadTamaTest {
	@Test
	public void SadTamaShouldDieWhenRepletionIsZero() throws Exception {
		final Tamagotchi tama = new SadTama("triste", 50);
		assertFalse(tama.imDead());
	}
	
	@Test
	public void SadTamaIsEverUnhappyDespiteCaresses() throws Exception {
		final Tamagotchi tama = new SadTama("triste", 50);
		tama.receiveCaresses(100);
		tama.receiveCaresses(100);
		tama.receiveCaresses(100);
		tama.receiveCaresses(100);
		tama.receiveCaresses(100);
		assertFalse(!tama.imSad());
	}
}
