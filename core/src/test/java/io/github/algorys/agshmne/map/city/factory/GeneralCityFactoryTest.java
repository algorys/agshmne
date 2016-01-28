package io.github.algorys.agshmne.map.city.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.github.algorys.agshmne.map.city.City;
import io.github.algorys.agshmne.map.city.CityType;
import io.github.algorys.agshmne.map.city.ICityFactory;

public class GeneralCityFactoryTest {
	
	@Test
	public void shouldCreateHamlet() {
		ICityFactory underTest = new GeneralCityFactory(2, 0);
		for (int i = 0; i < 500; i++) {
			City createdCity = underTest.createCity();
			assertEquals(CityType.Hamlet, createdCity.getType());
		}
	}
	
	@Test
	public void shouldCreateTown() {
		ICityFactory underTest = new GeneralCityFactory(2, 2);
		for (int i = 0; i < 500; i++) {
			City createdCity = underTest.createCity();
			assertEquals(CityType.Town, createdCity.getType());
		}
	}
	
	@Test
	public void shouldCreateCity() {
		ICityFactory underTest = new GeneralCityFactory(3, 4);
		for(int i = 0; i < 500; i++) {
			City createdCity = underTest.createCity();
			assertEquals(CityType.City, createdCity.getType());
		}
	}
	
	@Test
	public void shouldCreateCitadel() {
		ICityFactory underTest = new GeneralCityFactory(3, 7);
		for(int i = 0; i < 500; i++) {
			City createdCity = underTest.createCity();
			assertEquals(CityType.Citadel, createdCity.getType());
		}
	}
}
