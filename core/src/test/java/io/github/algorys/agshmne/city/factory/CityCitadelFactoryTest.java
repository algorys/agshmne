package io.github.algorys.agshmne.city.factory;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.algorys.agshmne.city.City;
import io.github.algorys.agshmne.city.CityType;

public class CityCitadelFactoryTest {

	@Test
	public void shouldCreateCitadel() {
		CityCitadelFactory underTest = new CityCitadelFactory();
		for(int i = 0; i < 500; i++) {
			City createdCity = underTest.createCity();
			assertEquals(CityType.Citadel, createdCity.getType());
		}
	}

}
