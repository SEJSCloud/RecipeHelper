package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.RecipeService;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeService service;
	
    @RequestMapping("/")
    public String index() {
        return "/index";
    }

}
