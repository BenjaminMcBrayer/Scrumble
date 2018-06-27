package com.gc.scrumble.oops;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.gc.scrumble.oops.entity.BkpWord;

/*
 * Grand Circus Java Coding Bootcamp
 * Final Project - SCRUMBLE
 * Ben McBrayer, Brent Coppinger, Victoria Rush
 * April 2018 Cohort
 */

public class OwlbotAPI {

//	Main method
//	added here for testing
//
//	public static void main(String[] args) {
//		OwlbotAPI owl = new OwlbotAPI();
//		System.out.println(owl.owlbotValidWord("chicken"));
//	}

	public boolean owlbotValidWord(String word) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		// need to pass in the request factory to the RestTemplate
		RestTemplate restTemplate = new RestTemplate(requestFactory);

		ResponseEntity<BkpWord[]> response = restTemplate.exchange(
				"https://owlbot.info/api/v2/dictionary/" + word + "?format=json", HttpMethod.GET, entity,
				BkpWord[].class);

		if (response.getBody().length != 0) {
			return true;
		} else
			return false;
	}
}
