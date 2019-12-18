package com.softtek.academia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringControllerTest {
	
	@RequestMapping("/welcome")
    public ModelAndView sayHello() {
        return new ModelAndView("welcome");
    }
	

}
