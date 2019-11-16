package com.productsSimilarityCalc.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Natalia Avelino Rogerio
 * 
 * Controller responsible for calling the main page
 * OBS: Spring Boot + Spring MVC use as default the MVC design pattern
 *
 */
@Controller
public class HomeController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @return ModelAndView
	 * 
	 * This method invokes the main page, starting the project
	 * 
	 */
	@RequestMapping(value={"/productsSimilarity/index"}, method=RequestMethod.GET)
	public ModelAndView callMain() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		return modelAndView;
	}
}
