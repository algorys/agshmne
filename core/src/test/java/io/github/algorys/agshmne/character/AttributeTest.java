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

}
