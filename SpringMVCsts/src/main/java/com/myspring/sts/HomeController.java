package com.myspring.sts;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.models.CarUserModel;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	private List<CarUserModel> usersList = new ArrayList<CarUserModel>();//list tu store car users
	
	@GetMapping(value="/homedir")
	public ModelAndView home(){
		return new ModelAndView("home","mName",new CarUserModel());
	}
	
	@PostMapping(value="/recived")
	public String recivedData(@ModelAttribute("nName")CarUserModel carUserModel, Model model){
		usersList.add(carUserModel);//adding new users to list
		
		model.addAttribute("userName",carUserModel.getName());
		model.addAttribute("userId",carUserModel.getId());
		model.addAttribute("cmodel",carUserModel.rentedModel());
		model.addAttribute("cmark",carUserModel.rentedMark());
		logger.info("recived data: "+carUserModel.getName()+" "+carUserModel.getId()+" "+carUserModel.rentedMark()+" "+carUserModel.rentedMark());
		return "recived";
	}
	@PostMapping(value="/retriveUser")
	public String retriveUserFromList(@RequestParam String userName, Model model){
		
		for(CarUserModel n:usersList){
			if (n.getName().equals(userName)) {
				model.addAttribute("name",n.getName());
				model.addAttribute("id",n.getId());
				return "userFromList";
			}
		}		
		return "noUserFound";
	}
	
	//================================@ModelAtribute on methods examples
	@GetMapping(value="/atributes")
	public String atributesController(){
		return "atributesTesting";
	}
	@GetMapping(value="/atributesTwo")
	public String atributesControllerTwo(){
		return "atributesTesting";
	}
	@ModelAttribute("attrOne")
	public String addParamToModel(){
		return "atribute name= attrOne and attribute value = all this text";
	}
	@ModelAttribute//what is defualt name??
	public String addParamToModelDefault(){
		return "atribute default name= paramToModelDefault and attribute value = all this text";
	}
	/*
	@ModelAttribute("withParam")
	public String setParamAsValue(@RequestParam("someParam") String value){
		return value;
	}
	*/
	@ModelAttribute()
	public void setParamAsValue(Model model){
		model.addAttribute("explicit","some value");
	}
	
}
