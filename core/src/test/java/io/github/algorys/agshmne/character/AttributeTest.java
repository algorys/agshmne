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
		Attribute original = new Attribute();
		original.setCHA(1);
		original.setCON(2);
		original.setDEX(3);
		original.setFOR(4);
		original.setINT(5);
		Attribute copy = new Attribute(original);
		assertNotSame(original, copy);
		assertEquals(original, copy);
	}
	
	@Test
	public void testSum() {
		Attribute modifier = new Attribute();
		Attribute original = new Attribute();
		original.setCHA(1);
		original.setCON(2);
		original.setDEX(3);
		original.setFOR(4);
		original.setINT(5);
		
		original.add(modifier);
		assertEquals(1,original.getCHA());
		assertEquals(2,original.getCON());
		assertEquals(3,original.getDEX());
		assertEquals(4,original.getFOR());
		assertEquals(5,original.getINT());
	}
}
