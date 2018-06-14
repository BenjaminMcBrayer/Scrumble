package com.gc.scrumble.oops;
/*
 * Grand Circus Java Coding Bootcamp
 * Final Project - SCRUMBLE
 * Ben McBrayer, Brent Coppinger, Victoria Rush
 * April 2018 Cohort
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OopsController {
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}

}
