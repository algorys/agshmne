package io.github.algorys.agshmne.map.city.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.github.algorys.agshmne.map.city.City;
import io.github.algorys.agshmne.map.city.CityType;

public class CityHamletFactoryTest {
	@Test
	public void shouldCreateCity() {
		CityHamletFactory underTest = new CityHamletFactory();
		for(int i = 0; i < 500; i++) {
			City createdCity = underTest.createCity();
			assertEquals(CityType.Hamlet, createdCity.getType());
		}
	}
}
