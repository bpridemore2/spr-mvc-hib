package com.sprhib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Team;
import com.sprhib.service.TeamService;

@Controller
@RequestMapping(value="/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addTeamPage() {
		ModelAndView modelAndView = new ModelAndView("add-team-form");
		modelAndView.addObject("team", new Team());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingTeam(@ModelAttribute Team team) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		teamService.addTeam(team);
		
		String message = "You was successfully registered. Please login.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginTeamPage() {
		ModelAndView modelAndView = new ModelAndView("login-team-form");
		modelAndView.addObject("team", new Team());
		return modelAndView;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginingTeam(@ModelAttribute Team team) {
		ModelAndView modelAndView = null;
		
		Team teamInApp = teamService.getTeam(team.getName());
		if ( teamInApp != null && teamInApp.getRating().equals(team.getRating())) {
			modelAndView = new ModelAndView("Appworks");
			String message = team.getName() + " was successfully logged in.";
			modelAndView.addObject("message", message);
		} else {
			modelAndView = new ModelAndView("home");
			String message = "Sorry " + team.getName() + ", log in failed, please try again.";
			modelAndView.addObject("message", message);
		}
		
		return modelAndView;
	}
}
