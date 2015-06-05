package com.ui.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class registrationController {

	@RequestMapping(value = "StudentRegistration", method = RequestMethod.GET)
	public ModelAndView studentRegistration(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ModelAndView m=new ModelAndView("/student_admission");
		return m;
	}
	@RequestMapping(value = "SchoolRegistration", method = RequestMethod.GET)
	public ModelAndView schoolRegistration(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ModelAndView m=new ModelAndView("/student_admission");
		return m;
	}
	@RequestMapping(value = "NGORegistration", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ModelAndView m=new ModelAndView("/student_admission");
		return m;
	}
}
