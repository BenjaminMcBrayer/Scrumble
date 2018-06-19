package com.gc.scrumble.oops;
import org.springframework.beans.factory.annotation.Value;
/*
 * Grand Circus Java Coding Bootcamp
 * Final Project - SCRUMBLE
 * Ben McBrayer, Brent Coppinger, Victoria Rush
 * April 2018 Cohort
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.gc.scrumble.oops.entity.Word;

@Controller
public class OopsController {

	@Value("${oops.apikey}")
	private String key;
		
//	@RequestMapping("/")
//	public String index() {
//		
//		return "index";
//	}
	
	
	@RequestMapping("/index")
	public ModelAndView findFactType(@RequestParam("entry")String word) {
		ModelAndView mv = new ModelAndView("result");
		
		 WordnikAPI nik = new WordnikAPI();
		 System.out.println(nik.wordnikValidWord(word, key));
		 
//		RestTemplate restTemplate = new RestTemplate();
//		Word response = restTemplate.getForObject("https://api.wordnik.com/v4/words.json/search/" + word + 
//				"?allowRegex=false&caseSensitive=false&minCorpusCount=5&maxCorpusCount=-1&minDictionaryCount=1&maxDictionaryCount=-1&minLength=1&maxLength=-1&limit=10&api_key="
//				+ key, Word.class);
//		System.out.println("Look here jerks " + response);
//		mv.addObject("word", response);		
		return mv;
	}

}
