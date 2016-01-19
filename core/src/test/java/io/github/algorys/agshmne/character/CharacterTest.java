package io.github.algorys.agshmne.character;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Observable;
import java.util.Observer;

import org.junit.Test;

import io.github.algorys.agshmne.movement.Position;

public class CharacterTest {

	private final class MyObserver implements Observer {
		private int called = 0;

		@Override
		public void update(Observable o, Object arg) {
			called++;
		}

		public boolean isCalled() {
			return called > 0;
		}

		public int getNbCalled() {
			return called;
		}
	}

	@Test
	public void whenCharacterIsCreated_positionShouldBe00() {
		Character underTest = new Character(null);
		assertEquals(new Position(0, 0), underTest.getPosition());
	}

	@Test
	public void whenCharacterChangePosition_observersShouldBeNotified() {
		Character underTest = new Character(null);
		MyObserver myObserver = new MyObserver();
		underTest.addObserver(myObserver);
		underTest.setPosition(new Position(1, 0));
		assertTrue(myObserver.isCalled());
	}

	@Test
	public void whenCharacterSetSamePosition_observersShouldNotBeNotified() {
		Character underTest = new Character(null);
		MyObserver myObserver = new MyObserver();
		underTest.addObserver(myObserver);
		underTest.setPosition(new Position(0, 0));
		assertFalse(myObserver.isCalled());
	}

}
