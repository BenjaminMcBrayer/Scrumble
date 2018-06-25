package com.gc.scrumble.oops;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.scrumble.oops.entity.Rootword;
import com.gc.scrumble.oops.entity.User;
import com.gc.scrumble.oops.repo.RootwordsRepository;
import com.gc.scrumble.oops.repo.UsersRepository;


@Controller
public class AdminController {
	
	@Autowired
	UsersRepository uP;
	
	@Autowired
	RootwordsRepository rP;
	
	@RequestMapping("/useradmin")
	public ModelAndView userAdmin() {
		return new ModelAndView("useradmin", "users", uP.findAll());
	}
	
	@RequestMapping("/wordadmin")
	public ModelAndView wordAdmin() {
		return new ModelAndView("wordadmin", "words", rP.findAll());
		}

	@RequestMapping(value = { "/deleteuser" })
	public ModelAndView deleteUser(@RequestParam("userid") Long userid) {
		uP.deleteById(userid);
		return new ModelAndView("redirect:/useradmin");
	}

	@RequestMapping(value = { "/deleteword" })
	public ModelAndView deleteWord(@RequestParam("wordid") Long wordid) {
		rP.deleteById(wordid);
		return new ModelAndView("redirect:/wordadmin");
	}

	@RequestMapping("/edituser")
	public ModelAndView editUser(@RequestParam("userid") Long userid) {
		Optional<User> optionalUser = uP.findById(userid);
		User user = optionalUser.get();
		System.out.println(user);
		return new ModelAndView("useredit", "user", user);
	}

	@RequestMapping(value = "/useredit")
	public ModelAndView updateUser(@RequestParam("userid") Long userid, @RequestParam("username") String username, @RequestParam("pword") String pword) {
		User user = new User(userid, username, pword);
		uP.save(user);
		return new ModelAndView("redirect:/useradmin");
	}
	
	@RequestMapping("/editword")
	public ModelAndView editWord(@RequestParam("wordid") Long wordid) {
		Optional<Rootword> optionalRootword = rP.findById(wordid);
		Rootword rootword = optionalRootword.get();
		return new ModelAndView("wordedit", "word", rootword);
	}
	
	@RequestMapping(value = "/wordedit")
	public ModelAndView updateWord(@RequestParam("wordid") Long wordid, @RequestParam("wordname") String wordname) {
		Rootword rootword = new Rootword(wordid, wordname);
		rP.save(rootword);
		return new ModelAndView("redirect:/wordadmin");
	}
	
	@RequestMapping("/addnewword")
	public String addNewWord() {
		return "addnewword";
	}
	
	@RequestMapping(value = "/addword")
	public ModelAndView addWord(@RequestParam("wordname") String wordname) {
		Rootword rootword = new Rootword(wordname);
		rP.save(rootword);
		return new ModelAndView("redirect:/wordadmin");
	}
}