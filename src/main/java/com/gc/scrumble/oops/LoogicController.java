package com.gc.scrumble.oops;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoogicController {
	@RequestMapping("/")
	public ModelAndView login() {
			
		return new ModelAndView("/login");
	}

}
