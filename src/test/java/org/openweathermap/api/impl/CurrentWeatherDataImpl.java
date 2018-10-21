package org.openweathermap.api.impl;

import org.openweathermap.api.CurrentWeatherData;
import org.openweathermap.api.data.Spec;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

public class CurrentWeatherDataImpl implements CurrentWeatherData {

	@Override
	public String getCityWeatherByName(String cityName) {
		Response response =
		 given()
			 .spec(Spec.initSpec())
			 .queryParam("q", cityName)
		.expect()
			 .statusCode(200)
		 .when()
		 	.get("weather");
		
		return response.getBody().asString();
	}
	


}
