package io.github.algorys.agshmne.character;

import static org.junit.Assert.*;

import org.junit.Test;

public class AttributeTest {

	@Test
	public void testCopyConstructor() {
		Attribute original = new Attribute();
		Attribute copy = new Attribute(original);
		assertNotSame(original, copy);
		assertEquals(original, copy);
	}

	@Test
	public void testCopyConstructor_withValues() {
		Attribute original = createBaseAttribute();
		Attribute copy = new Attribute(original);
		assertNotSame(original, copy);
		assertEquals(original, copy);
	}

	@Test
	public void testSum() {
		Attribute modifier = new Attribute();
		Attribute original = createBaseAttribute();

		original.add(modifier);
		assertEquals(1, original.getCHA());
		assertEquals(2, original.getCON());
		assertEquals(3, original.getDEX());
		assertEquals(4, original.getFOR());
		assertEquals(5, original.getINT());
	}

	@Test
	public void testSum_withValues() {
		Attribute modifier = new Attribute();
		modifier.setCHA(1);
		modifier.setCON(3);
		modifier.setDEX(5);
		modifier.setFOR(7);
		modifier.setINT(11);

		Attribute original = createBaseAttribute();

		original.add(modifier);

		assertEquals(2, original.getCHA());
		assertEquals(5, original.getCON());
		assertEquals(8, original.getDEX());
		assertEquals(11, original.getFOR());
		assertEquals(16, original.getINT());
	}

	private Attribute createBaseAttribute() {
		Attribute original = new Attribute();
		original.setCHA(1);
		original.setCON(2);
		original.setDEX(3);
		original.setFOR(4);
		original.setINT(5);
		return original;
	}
}
