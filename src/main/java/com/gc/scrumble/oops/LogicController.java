package com.gc.scrumble.oops;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gc.scrumble.oops.entity.User;
import com.gc.scrumble.oops.repository.DummyUsersRepository;

@Controller
@SessionAttributes({ "numPlayers", "newusername1", "newusername2", "username1", "username2" })
public class LogicController {

	@Autowired
	DummyUsersRepository duP;

	@RequestMapping("/dummylogin")
	public String login() {
		return "dummylogin";
	}

	@RequestMapping("add1")
	public ModelAndView addPlayerOne(@RequestParam("newusername1") String username,
			@RequestParam("newpword1") String pword, HttpSession session, Model model) {
		User user = new User(username, pword);
		duP.save(user);
		model.addAttribute("newusername1", username);
		return new ModelAndView("redirect:/dummylogin", "thankyou1", "Thank you, " + username + ".");
	}

	@RequestMapping("add2")
	public ModelAndView addPlayerTwo(@RequestParam("newusername2") String username,
			@RequestParam("newpword2") String pword, HttpSession session, Model model) {
		User user = new User(username, pword);
		duP.save(user);
		model.addAttribute("newusername2", username);
		return new ModelAndView("redirect:/dummylogin", "thankyou2", "Thank you, " + username + ".");
	}

	@RequestMapping("login1")
	public ModelAndView addUser(@RequestParam("username1") String username, @RequestParam("pword1") String pword,
			HttpSession session, Model model) {
		Optional<User> user = duP.findByUsername(username);
		if (user.isPresent() && user.get().getPword().equals(pword)) {
			ModelAndView mv = new ModelAndView("dummyindex", "welcome1", "Thank you, " + username);
			model.addAttribute("username1", username);
			return mv;
		}
		return new ModelAndView("dummyindex", "failure1",
				"User name and password do not match. Please check your credentials, fellow Scrumbler.");
	}

	@RequestMapping("/login2")
	public ModelAndView login(@RequestParam("username2") String username, @RequestParam("pword2") String pword,
			HttpSession session, Model model) {
		Optional<User> user = duP.findByUsername(username);
		if (user.isPresent() && user.get().getPword().equals(pword)) {
			ModelAndView mv = new ModelAndView("dummyindex", "welcome2", "Thank you, " + username);
			model.addAttribute("username2", username);
			return mv;
		}
		return new ModelAndView("dummyindex", "failure2",
				"User name and password do not match. Please check your credentials, fellow Scrumbler.");
	}

}