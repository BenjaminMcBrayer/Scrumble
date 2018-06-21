package com.gc.scrumble.oops;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
/*
 * Grand Circus Java Coding Bootcamp
 * Final Project - SCRUMBLE
 * Ben McBrayer, Brent Coppinger, Victoria Rush
 * April 2018 Cohort
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OopsController {

	@Value("${oops.apikey}")
	private String key;

	@RequestMapping("/gameboard")
	public ModelAndView game() {
		return new ModelAndView("gameboard");
	}
	
	@PostMapping("/index")
	//@RequestMapping(value = "/index", method = RequestMethod.POST)
	public ModelAndView findFactType(@RequestParam(name="entry", required = false) String wordarraytest) {
		
		
System.out.println("wordarray:" + wordarraytest);

String[] wordarray = new String[3];

		String rootword = "rootword";
		// convert array to hash set
		Set<String> wordset = new HashSet<>();
		for (String w : wordarray) {
			if (wordset.add(w) == false) {
				System.out.println("found duplicate: " + w);
			}
		}
		// convert hash set to a new array
		String[] wordlist = new String[wordset.size()];
		wordlist = wordset.toArray(wordlist);
		System.out.println(wordlist);
		
		int score = 0;
		boolean validEntry = true;
		String temproot = rootword;

		System.out.println("rootword= " + rootword + " wordlist= " + wordlist[0] + ", " + wordlist[1]);
		// cycling through list of entered words
		for (int i = 0; i <= wordlist.length - 1; i++) {
			System.out.println("i = " + i);
			validEntry = true;
			temproot = rootword;

			// i is the number of entered words
			// k is the length of each entered word
			// j is the length of the root word

			// creating a character string of the root word
			char[] root = temproot.toCharArray();

			// create a character string of the entered word
			char[] eword = wordlist[i].toCharArray();

			// for each letter of the entered word...
			for (int k = 0; k <= (eword.length - 1); k++) {
				System.out.println("k = " + k);

				int j = 0;

				// loop through letters of root word to find a letter match
				while (j <= (root.length - 1) && eword[k] != root[j]) {
					System.out.println("j = " + j);
					System.out.println("eword[k]= " + eword[k] + ", root[j]= " + root[j]);
					j++;
					System.out.println("temproot size = " + temproot.length());
				}

				// determine whether we found a match or reached the end
				// if (eword[k] == root[j]) {
				if (j == (root.length - 1)) {

					validEntry = false;
					k = eword.length;

				} else {
					String temp = Character.toString(eword[k]);
					temproot = temproot.replaceFirst(temp, "");
					root = temproot.toCharArray();
				}
			}
			if (validEntry) {
				System.out.println("API called for " + wordlist[i]);
				WordnikAPI nik = new WordnikAPI();
				if (nik.wordnikValidWord(wordlist[i], key)) {
					score++;
				}
			}
		}

		return new ModelAndView("result", "score", score);

	}

}
