package com.gc.scrumble.oops;

/*
 * Grand Circus Java Coding Bootcamp
 * Final Project - SCRUMBLE
 * Ben McBrayer, Brent Coppinger, Victoria Rush
 * April 2018 Cohort
 */

import org.springframework.web.client.RestTemplate;

import com.gc.scrumble.oops.entity.Word;

public class WordnikAPI {
	
	public boolean wordnikValidWord(String word, String key) {

		RestTemplate restTemplate = new RestTemplate();

		Word response = restTemplate.getForObject("https://api.wordnik.com/v4/words.json/search/" + word
				+ "?allowRegex=false&caseSensitive=false&minCorpusCount=5&maxCorpusCount=-1&minDictionaryCount=1&maxDictionaryCount=-1&minLength=1&maxLength=-1&limit=10&api_key="
				+ key, Word.class);

		if (response.getCount() != 0) {
			return true;
		} else
			return false;
	}

}
