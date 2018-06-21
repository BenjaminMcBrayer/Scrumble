package com.gc.scrumble.oops;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gc.scrumble.oops.entity.Rootword;
import com.gc.scrumble.oops.entity.User;
import com.gc.scrumble.oops.repo.RootwordsRepository;
import com.gc.scrumble.oops.repo.UsersRepository;

@Controller
@SessionAttributes({ "numPlayers", "newusername1", "newusername2", "username1", "username2", "rootword" })
public class LogicController {

	@Autowired
	UsersRepository uP;

	@Autowired
	RootwordsRepository rP;

	@RequestMapping("/oneplayerlogin")
	public String login() {
		return "oneplayerlogin";
	}

	@RequestMapping("add1")
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

//	@RequestMapping("add2")
//	public ModelAndView addPlayerTwo(@RequestParam("newusername2") String username,
//			@RequestParam("newpword2") String pword, HttpSession session, Model model) {
//		User newuser = new User(username, pword);
//		Optional<User> user = uP.findByUsername(username);
//		if (user.isPresent()) {
//			String message = "User name already exists. Please choose another or log in below.";
//			ModelAndView mv = new ModelAndView("dummylogin", "alreadyexists2", message);
//			return mv;
//		} else {
//			uP.save(newuser);
//			model.addAttribute("newusername2", username);
//			String message = "Thank you, " + username;
//			return new ModelAndView("dummylogin", "thankyou2", message);
//		}
//	}

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
	public ModelAndView secondUserLogin1(@RequestParam("username1") String username, @RequestParam("pword1") String pword,
			HttpSession session, Model model) {
		Optional<User> user = uP.findByUsername(username);
		if (user.isPresent() && user.get().getPword().equals(pword)) {
			ModelAndView mv = new ModelAndView("secondlogin", "secondwelcome1", "Welcome to Scrumble, " + username + "!");
			model.addAttribute("username1", username);
			return mv;
		}
		return new ModelAndView("secondlogin", "secondfailure1",
				"User name and password do not match. Please check your credentials, fellow Scrumbler.");
	}

//	@RequestMapping("/login2")
//	public ModelAndView login(@RequestParam("username2") String username, @RequestParam("pword2") String pword,
//			HttpSession session, Model model) {
//		Optional<User> user = uP.findByUsername(username);
//		if (user.isPresent() && user.get().getPword().equals(pword)) {
//			ModelAndView mv = new ModelAndView("dummylogin", "welcome2", "Thank you, " + username);
//			model.addAttribute("username2", username);
//			return mv;
//		}
//		return new ModelAndView("dummylogin", "failure2",
//				"User name and password do not match. Please check your credentials, fellow Scrumbler.");
//	}

	// This method starts immediately upon pressing Play button.
	@RequestMapping("play")
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
