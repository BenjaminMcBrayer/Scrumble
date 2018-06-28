package com.gc.scrumble.oops;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
/*
 * Grand Circus Java Coding Bootcamp
 * Final Project - SCRUMBLE
 * Ben McBrayer, Brent Coppinger, Victoria Rush
 * April 2018 Cohort
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gc.scrumble.oops.entity.Rootword;
import com.gc.scrumble.oops.entity.Score;
import com.gc.scrumble.oops.entity.User;
import com.gc.scrumble.oops.repo.ScoreRepo;
import com.gc.scrumble.oops.repo.UsersRepository;

@Controller
@SessionAttributes({ "rootword", "username1", "username2", "score1", "score2" })
public class OopsController {

	@Value("${oops.apikey}")
	private String key;

	@Autowired
	ScoreRepo sR;

	@Autowired
	UsersRepository uP;

	@RequestMapping("/gameboard")
	public ModelAndView game() {
		return new ModelAndView("gameboard");
	}

	@PostMapping("/index")
	@ResponseBody
	public ModelAndView checkEntries(@RequestParam(name = "entry", required = false) String[] wordarray,
			@ModelAttribute("rootword") Rootword gameWord, @ModelAttribute("username1") String player, Model model) {
		List<String> duplicates = new ArrayList<String>();
		List<String> invalids = new ArrayList<String>();

		// remove empty strings, in case user hits enter twice
		List<String> temparray = new ArrayList<String>();
		for (int m = 0; m <= wordarray.length - 1; m++) {
			if (wordarray[m].isEmpty()) {
			} else {
				temparray.add(wordarray[m]);
			}
		}

		// convert array to hash set to eliminate duplicate words
		Set<String> wordset = new HashSet<>();

		for (String w : temparray) {
			if (wordset.add(w) == false) {
				duplicates.add(w);
			}
		}

		// convert hash set to a new array
		String[] wordlist = new String[wordset.size()];
		wordlist = wordset.toArray(wordlist);

		long scoreval1 = 0;
		boolean validEntry = true;
		model.addAttribute("rootword", gameWord);

		// Create new rootword object so we can use get wordname function
		Rootword workroot = new Rootword();
		workroot = gameWord;
		String temproot = workroot.getWordname();

		// cycling through list of entered words
		for (int i = 0; i <= wordlist.length - 1; i++) {
			validEntry = true;
			temproot = workroot.getWordname();

			// i is the number of entered words
			// k is the length of each entered word
			// j is the length of the root word

			// creating a character string of the root word
			char[] root = temproot.toCharArray();

			// create a character string of the entered word
			char[] eword = wordlist[i].toCharArray();

			// for each letter of the entered word...
			for (int k = 0; k <= (eword.length - 1); k++) {

				int j = 0;

				// loop through letters of root word to find a letter match
				while (j <= (root.length - 1) && eword[k] != root[j]) {
					j++;
				}

				// determine whether we found a match or reached the end
				if (j == (root.length)) {
					invalids.add(wordlist[i]);
					validEntry = false;
					k = eword.length;

				} else {
					String temp = Character.toString(eword[k]);
					temproot = temproot.replaceFirst(temp, "");
					root = temproot.toCharArray();
				}
			}
			if (validEntry) {

				// For backup, comment out the next two lines...
				WordnikAPI nik = new WordnikAPI();
				if (nik.wordnikValidWord(wordlist[i], key)) {
					// Main API call ends here

					// and uncomment these next two
					// OwlbotAPI owl = new OwlbotAPI();
					// if (owl.owlbotValidWord(wordlist[i])) {
					// Backup API call ends here

					scoreval1++;
				} else {
					invalids.add(wordlist[i]);
				}
			}
		}
		model.addAttribute("username1", player);
		Optional<User> user = uP.findByUsername(player);
		long userid = user.get().getUserid();

		Long gameWordId = workroot.getWordid();
		Score gameScore = new Score(scoreval1, userid, gameWordId);
		sR.save(gameScore);

		model.addAttribute("score1", scoreval1);
		model.addAttribute("maxscore", sR.getMaxscore(userid));
		model.addAttribute("maxwordscore", sR.getMaxwordscore(userid, gameWordId));
		model.addAttribute("avgwordscore", sR.getAvgwordscore(gameWordId));
		model.addAttribute("duplicates", duplicates);
		model.addAttribute("invalids", invalids);

		return new ModelAndView("result", "score", scoreval1);

	}

	@PostMapping("/index2")
	@ResponseBody
	public ModelAndView checkEntries2(@RequestParam(name = "entry", required = false) String[] wordarray,
			@ModelAttribute("rootword") Rootword gameWord, @ModelAttribute("username2") String player,
			@ModelAttribute("score1") long scoreval1, Model model) {
		List<String> duplicates = new ArrayList<String>();
		List<String> invalids = new ArrayList<String>();

		// remove empty strings, in case user hits enter twice
		List<String> temparray = new ArrayList<String>();
		for (int m = 0; m <= wordarray.length - 1; m++) {
			if (wordarray[m].isEmpty()) {
			} else {
				temparray.add(wordarray[m]);
			}
		}

		// convert array to hash set to eliminate duplicate words
		Set<String> wordset = new HashSet<>();

		for (String w : temparray) {
			if (wordset.add(w) == false) {
				duplicates.add(w);
			}
		}

		// convert hash set to a new array
		String[] wordlist = new String[wordset.size()];
		wordlist = wordset.toArray(wordlist);

		long scoreval2 = 0;
		boolean validEntry = true;
		model.addAttribute("rootword", gameWord);

		// Create new rootword object so we can use get wordname function
		Rootword workroot = new Rootword();
		workroot = gameWord;
		String temproot = workroot.getWordname();

		// cycling through list of entered words
		for (int i = 0; i <= wordlist.length - 1; i++) {
			validEntry = true;
			temproot = workroot.getWordname();

			// i is the number of entered words
			// k is the length of each entered word
			// j is the length of the root word

			// creating a character string of the root word
			char[] root = temproot.toCharArray();

			// create a character string of the entered word
			char[] eword = wordlist[i].toCharArray();

			// for each letter of the entered word...
			for (int k = 0; k <= (eword.length - 1); k++) {

				int j = 0;

				// loop through letters of root word to find a letter match
				while (j <= (root.length - 1) && eword[k] != root[j]) {
					j++;
				}

				// determine whether we found a match or reached the end
				if (j == (root.length)) {
					invalids.add(wordlist[i]);
					validEntry = false;
					k = eword.length;

				} else {
					String temp = Character.toString(eword[k]);
					temproot = temproot.replaceFirst(temp, "");
					root = temproot.toCharArray();
				}
			}
			if (validEntry) {

				// For backup, comment out the next two lines...
				WordnikAPI nik = new WordnikAPI();
				if (nik.wordnikValidWord(wordlist[i], key)) {
					// Main API call ends here

					// and uncomment these next two
					// OwlbotAPI owl = new OwlbotAPI();
					// if (owl.owlbotValidWord(wordlist[i])) {
					// Backup API call ends here

					scoreval2++;
				} else {
					invalids.add(wordlist[i]);
				}
			}
		}
		model.addAttribute("username2", player);
		Optional<User> user = uP.findByUsername(player);
		long userid = user.get().getUserid();

		Long gameWordId = workroot.getWordid();
		Score gameScore = new Score(scoreval2, userid, gameWordId);
		sR.save(gameScore);

		model.addAttribute("score1", scoreval1);
		model.addAttribute("score2", scoreval2);
		model.addAttribute("maxscore", sR.getMaxscore(userid));
		model.addAttribute("maxwordscore", sR.getMaxwordscore(userid, gameWordId));
		model.addAttribute("avgwordscore", sR.getAvgwordscore(gameWordId));
		model.addAttribute("duplicates", duplicates);
		model.addAttribute("invalids", invalids);

		return new ModelAndView("result2", "score", scoreval2);

	}

}
