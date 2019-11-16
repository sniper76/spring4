package com.app.ctrl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.svc.TestService;

@Controller
public class TestController {
	@Autowired
    private TestService testService;
    
    @RequestMapping(value = "/testList")
   	public String testList(ModelMap model) throws Exception {
    	String listview = testService.selectNow();
        
    	model.addAttribute("listview", listview);
    	model.addAttribute("message", "Hi man");
        return "testList";
    }
    
    @RequestMapping(value = "/testModel")
    public String testModel(Model model, HttpServletRequest request) throws Exception {
    	Map<String, Object> listview = testService.selectPlayEvolutions();

    	model.addAttribute("listview", listview);
    	model.addAttribute("message", "Hi man");
    	return "testModel";
    }
    
    @RequestMapping(value = "/testMav")
    public ModelAndView testMav(ModelMap model) throws Exception {
    	String listview = testService.selectNow();
    	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("testMav");
    	mav.addObject("listview", listview);
    	mav.addObject("message", "Hi man");
    	return mav;
    }
}
