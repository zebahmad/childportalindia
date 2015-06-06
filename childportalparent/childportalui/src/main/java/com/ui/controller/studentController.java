package com.ui.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class studentController {

	@RequestMapping(value = "StudentDetailsUpdate", method = RequestMethod.GET)
	public ModelAndView studentDetailsUpdate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ModelAndView m=new ModelAndView("/student-details-update");
		return m;
	}
}