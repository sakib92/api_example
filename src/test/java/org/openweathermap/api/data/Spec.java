package org.openweathermap.api.data;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.specification.RequestSpecification;

public class Spec {

	public static RequestSpecification initSpec() {
		
		String appId = "60ce8969bc374545080aaac57b5dfe2c"; //This is the appId that was provided when I created a free account

		return new RequestSpecBuilder()
				.setBaseUri("https://api.openweathermap.org/data/2.5/")
				.addQueryParam("appid", appId)
				//.addFilter(new RequestLoggingFilter())
				//.addFilter(new ResponseLoggingFilter())
				.build(); 

	}
}
