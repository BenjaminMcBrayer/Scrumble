package com.gc.scrumble.oops;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoogicController {
	
	@RequestMapping("/")
	public ModelAndView login(@RequestParam("players")int players,@RequestParam("newplayer")boolean newplayer) {
		if(players==1 && newplayer == false) {
		return new ModelAndView("gameboard");}
		if(players==1&& newplayer == true) {
			//adduser
			return new ModelAndView("gameboard");
		}
		if(players==2&& newplayer == true) {
			//adduser
			return new ModelAndView("login2");
		}
		if(players==2&& newplayer == false) {
			return new ModelAndView("login2");
		}
		System.out.println("Something went wrong");
		return new ModelAndView("/");
	}
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
		
	}
	@RequestMapping("/gameboard")
	public ModelAndView player2(@RequestParam("players")int players) {
		
		return new ModelAndView("/login");
	}

}
