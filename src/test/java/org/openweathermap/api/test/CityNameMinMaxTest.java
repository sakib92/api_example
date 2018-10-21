package org.openweathermap.api.test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openweathermap.api.CurrentWeatherData;
import org.openweathermap.api.impl.CurrentWeatherDataImpl;

import com.jayway.jsonpath.JsonPath;

@RunWith(Parameterized.class)
public class CityNameMinMaxTest {

	private CurrentWeatherData currentWeatherAPI;
	private String cityName;

	public CityNameMinMaxTest(String cityName) {
		this.cityName = cityName;
	}

	@Before
	public void init() {
		currentWeatherAPI = new CurrentWeatherDataImpl();
	}

	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] { 
			{ "Boston" },
			{ "London" }
		});
	}

	@Test
	public void printCityMinMaxTemp() throws Exception{
		String response = currentWeatherAPI.getCityWeatherByName(cityName);
		Double minTemp = JsonPath.read(response,"$.main.temp_min");
		Double maxTemp = JsonPath.read(response,"$.main.temp_max");
		System.out.printf("For %s, the minimum temperature today is %.2f degrees Kelvin and the maximum temperature for today is %.2f degrees Kelvin. %n", 
				cityName, minTemp, maxTemp);
	}

}
