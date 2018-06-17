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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.gc.scrumble.oops.entity.BkpWord;

/*
 * Grand Circus Java Coding Bootcamp
 * Final Project - SCRUMBLE
 * Ben McBrayer, Brent Coppinger, Victoria Rush
 * April 2018 Cohort
 */
@Controller
public class BkpController {

	@RequestMapping("/bkpindex")
	public ModelAndView findFactType(@RequestParam("entry")String word) {
		ModelAndView mv = new ModelAndView("bkpresult");
		
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
				"https://owlbot.info/api/v2/dictionary/" + word + "?format=json",
				HttpMethod.GET, entity, BkpWord[].class);
		mv.addObject("word", response.getBody());		
		System.out.println("Look for data here " + response);
		return mv;
	}
}
