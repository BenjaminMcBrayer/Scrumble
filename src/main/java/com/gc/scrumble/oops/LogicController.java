package com.gc.scrumble.oops;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gc.scrumble.oops.entity.Rootword;
import com.gc.scrumble.oops.entity.User;
import com.gc.scrumble.oops.repo.RootwordsRepository;
import com.gc.scrumble.oops.repo.ScoreRepo;
import com.gc.scrumble.oops.repo.UsersRepository;

@Controller
@SessionAttributes({ "numPlayers", "newusername1", "newusername2", "user1", "user2", "username1", "username2",
		"rootword", "score" })
public class LogicController {

	@Autowired
	UsersRepository uP;

	@Autowired
	RootwordsRepository rP;

	@Autowired
	ScoreRepo sP;

	// One Player Version Mappings
	@RequestMapping("/oneplayerlogin")
	public String onePlayerLogin() {
		return "oneplayerlogin";
	}

	@RequestMapping("oneplayeradd1")
	public ModelAndView addPlayerOne(@RequestParam("newusername1") String username,
			@RequestParam("newpword1") String pword, HttpSession session, Model model) {
		User newuser = new User(username, pword);
		Optional<User> user = uP.findByUsername(username);
		if (user.isPresent()) {
			String message = "User name already exists. Please choose another or log in below.";
			ModelAndView mv = new ModelAndView("oneplayerlogin", "alreadyexists1", message);
			return mv;
		} else {
			uP.save(newuser);
			model.addAttribute("newusername1", username);
			String message = "Thank you, " + username + ".";
			return new ModelAndView("secondlogin", "thankyou1", message);
		}
	}

	@RequestMapping("login1")
	public ModelAndView userLogin1(@RequestParam("username1") String username, @RequestParam("pword1") String pword,
			HttpSession session, Model model) {
		Optional<User> user = uP.findByUsername(username);
		if (user.isPresent() && user.get().getPword().equals(pword)) {
			ModelAndView mv = new ModelAndView("oneplayerlogin", "welcome1", "Welcome to Scrumble, " + username + "!");
			model.addAttribute("username1", username);
			return mv;
		}
		return new ModelAndView("oneplayerlogin", "failure1",
				"User name and password do not match. Please check your credentials, fellow Scrumbler.");
	}

	@RequestMapping("secondlogin1")
	public ModelAndView secondUserLogin1(@RequestParam("username1") String username,
			@RequestParam("pword1") String pword, HttpSession session, Model model) {
		Optional<User> user = uP.findByUsername(username);
		if (user.isPresent() && user.get().getPword().equals(pword)) {
			ModelAndView mv = new ModelAndView("secondlogin", "secondwelcome1",
					"Welcome to Scrumble, " + username + "!");
			model.addAttribute("username1", username);
			return mv;
		}
		return new ModelAndView("secondlogin", "secondfailure1",
				"User name and password do not match. Please check your credentials, fellow Scrumbler.");
	}

	// Two Player Version Mappings
	@RequestMapping("/twoplayerlogin")
	public String dummylogin() {
		return "twoplayerlogin";
	}

	// Determine and record number of players.
	@RequestMapping("numPlay")
	@ModelAttribute("numPlayers")
	public ModelAndView numPlay(@RequestParam("numPlayers") String numPlayers, HttpSession session, Model model) {
		ModelAndView mv = new ModelAndView("twoplayerlogin1");
		model.addAttribute("numPlayers", numPlayers);
		System.out.println(numPlayers);
		return mv;
	}

	// Register first player (if player is new).
	@RequestMapping("twoplayeradd1")
	@ModelAttribute("numPlayers")
	public ModelAndView addPlayerOne(@ModelAttribute("numPlayers") String numPlayers,
			@RequestParam("newusername1") String username, @RequestParam("newpword1") String pword, HttpSession session,
			Model model) {
		model.addAttribute("numPlayers", numPlayers);
		System.out.println(numPlayers);
		User newuser = new User(username, pword);
		Optional<User> user = uP.findByUsername(username);
		if (user.isPresent()) {
			String message = "User name already exists. Please choose another or log in below.";
			ModelAndView mv = new ModelAndView("twoplayerlogin1", "alreadyexists1", message);
			return mv;
		} else {
			uP.save(newuser);
			model.addAttribute("newusername1", username);
			String message = "Thank you, " + username + ".";
			return new ModelAndView("twoplayersecondlogin", "thankyou1", message);
		}
	}

	// Log in first player (if player is new).
	@RequestMapping("twoplayersecondlogin1")
	@ModelAttribute("numPlayers")
	public ModelAndView firstUserSecondLogin(@ModelAttribute("numPlayers") String numPlayers,
			@RequestParam("username1") String username, @RequestParam("pword1") String pword, HttpSession session,
			Model model) {
		model.addAttribute("numPlayers", numPlayers);
		System.out.println(numPlayers);
		Optional<User> user = uP.findByUsername(username);
		if (numPlayers.equals("1")) {
			if (user.isPresent() && user.get().getPword().equals(pword)) {
				ModelAndView mv = new ModelAndView("readandplay", "secondwelcome1",
						"Welcome to Scrumble, " + username + "!");
				model.addAttribute("username1", username);
				return mv;
			}
		}
		if (numPlayers.equals("2")) {
			if (user.isPresent() && user.get().getPword().equals(pword)) {
				ModelAndView mv = new ModelAndView("twoplayerlogin2", "secondwelcome1",
						"Welcome to Scrumble, " + username + "!");
				model.addAttribute("username1", username);
				return mv;
			}
		}
		return new ModelAndView("twoplayersecondlogin", "secondfailure1",
				"User name and password do not match. Please check your credentials, fellow Scrumbler.");
	}

	// Log in first player (if player is returning).
	@RequestMapping("twoplayerlogin1")
	@ModelAttribute("numPlayers")
	public ModelAndView firstUserFirstLogin(@ModelAttribute("numPlayers") String numPlayers,
			@RequestParam("username1") String username, @RequestParam("pword1") String pword, HttpSession session,
			Model model) {
		model.addAttribute("numPlayers", numPlayers);
		System.out.println(numPlayers);
		Optional<User> user = uP.findByUsername(username);
		if (numPlayers.equals("1")) {
			if (user.isPresent() && user.get().getPword().equals(pword)) {
				ModelAndView mv = new ModelAndView("readandplay", "welcome1", "Welcome to Scrumble, " + username + "!");
				model.addAttribute("username1", username);
				return mv;
			}
		}
		if (numPlayers.equals("2")) {
			if (user.isPresent() && user.get().getPword().equals(pword)) {
				ModelAndView mv = new ModelAndView("twoplayerlogin2", "secondwelcome1",
						"Welcome to Scrumble, " + username + "!");
				model.addAttribute("username1", username);
				return mv;
			}
		}
		return new ModelAndView("twoplayerlogin1", "failure1",
				"User name and password do not match. Please check your credentials, fellow Scrumbler.");
	}

	// Register second player (if player is new).
	@RequestMapping("twoplayeradd2")
	@ModelAttribute("numPlayers")
	public ModelAndView addPlayerTwo(@RequestParam("newusername2") String username,
			@RequestParam("newpword2") String pword, @ModelAttribute("numPlayers") String numPlayers,
			HttpSession session, Model model) {
		model.addAttribute("numPlayers", numPlayers);
		System.out.println(numPlayers);
		User newuser = new User(username, pword);
		Optional<User> user = uP.findByUsername(username);
		if (user.isPresent()) {
			String message = "User name already exists. Please choose another or log in below.";
			ModelAndView mv = new ModelAndView("twoplayerlogin2", "alreadyexists2", message);
			return mv;
		} else {
			uP.save(newuser);
			model.addAttribute("newusername2", username);
			String message = "Thank you, " + username + ".";
			return new ModelAndView("twoplayersecondlogin1", "thankyou2", message);
		}
	}
	
	// Log in second player (if player is returning).
	@RequestMapping("twoplayerlogin2")
	@ModelAttribute("numPlayers")
	public ModelAndView secondUserLogin(@RequestParam("username2") String username2,
			@RequestParam("pword2") String pword, @ModelAttribute("username1") String username1,
			@ModelAttribute("numPlayers") String numPlayers, HttpSession session, Model model) {
		model.addAttribute("numPlayers", numPlayers);
		model.addAttribute("username1", username1);
		Optional<User> user = uP.findByUsername(username2);
		// Add check to make sure the same user is not logging in twice.
		if (user.isPresent() && user.get().getPword().equals(pword)) {
			ModelAndView mv = new ModelAndView("readandplay", "welcome2",
					"Welcome to Scrumble, " + username1 + " and " + username2 + "!");
			model.addAttribute("username2", username2);
			return mv;
		}
		return new ModelAndView("twoplayerlogin2", "failure2",
				"User name and password do not match. Please check your credentials, fellow Scrumbler.");
	}

	// Log in second player (if player is new).
	@RequestMapping("secondlogin2")
	@ModelAttribute("numPlayers")
	public ModelAndView secondUserSecondLogin(@RequestParam("username2") String username2,
			@RequestParam("pword2") String pword, @ModelAttribute("username1") String username1, HttpSession session,
			Model model) {
		model.addAttribute("username1", username1);
		Optional<User> user = uP.findByUsername(username2);
		if (user.isPresent() && user.get().getPword().equals(pword)) {
			ModelAndView mv = new ModelAndView("readandplay", "secondwelcome2",
					"Welcome to Scrumble, " + username1 + " and " + username2 + "!");
			model.addAttribute("username2", username2);
			return mv;
		}
		return new ModelAndView("twoplayersecondlogin1", "secondfailure2",
				"User name and password do not match. Please check your credentials, fellow Scrumbler.");
	}

	// Mappings for Generating Random Root-Words
	// Play (works for both one and two player versions).
	@RequestMapping("play") // This method starts immediately upon pressing Play button.
	public ModelAndView play(HttpSession session, Model model) {
		List<Rootword> rootwordList = new ArrayList<>();
		rootwordList = rP.findAll();
		long listLength = rootwordList.size();
		int randomIndex = (int) (Math.random() * listLength);
		Rootword rootword = rootwordList.get(randomIndex);
		ModelAndView mv = new ModelAndView("gameboard", "rootword", rootword);
		model.addAttribute("rootword", rootword);
		return mv;
	}

	// Play again.
	@RequestMapping("playAgain")
	public ModelAndView playAgain(HttpSession session, Model model) {
		List<Rootword> rootwordList = new ArrayList<>();
		rootwordList = rP.findAll();
		long listLength = rootwordList.size();
		int randomIndex = (int) (Math.random() * listLength);
		Rootword rootword = rootwordList.get(randomIndex);
		ModelAndView mv = new ModelAndView("gameboard", "rootword", rootword);
		model.addAttribute("rootword", rootword);
		return mv;
	}

	// One Player Version: Play (if player is new).
	@RequestMapping("secondplay")
	public ModelAndView secondPlay(HttpSession session, Model model) {
		List<Rootword> rootwordList = new ArrayList<>();
		rootwordList = rP.findAll();
		long listLength = rootwordList.size();
		int randomIndex = (int) (Math.random() * listLength);
		Rootword rootword = rootwordList.get(randomIndex);
		ModelAndView mv = new ModelAndView("gameboard", "rootword", rootword);
		model.addAttribute("rootword", rootword);
		return mv;
	}
}
