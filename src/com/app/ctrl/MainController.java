package com.app.ctrl;

import java.text.ParseException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.vo.CustomUserDetails;

@Controller
public class MainController {

	@RequestMapping(value="/manager/test")
    public String managerTest(Model model, HttpSession session, HttpServletRequest request){
          
          return "manager/managerTest";
    }
	
	@RequestMapping(value="/member/test")
	public String memberTest(Model model, HttpSession session, HttpServletRequest request){
		
		return "member/memberTest";
	}
	
	@RequestMapping(value="/admin/usermanager/test")
	public String adminUsermanagerTest(Model model, HttpSession session, HttpServletRequest request){
		
		return "admin/adminTest";
	}
	
	@RequestMapping(value="/")
	public String main(Model model, HttpSession session, HttpServletRequest request){
		
		return "index";
	}
	
	@RequestMapping(value="/user/login")
	public String loginInvalidId(Model model, HttpSession session, HttpServletRequest request){
		
		return "index";
	}
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request){
          return "login";
    }
    
    @RequestMapping(value="/login_duplicate")
    public String loginDuplicate(Model model, HttpServletRequest request){
          
          return "login_duplicate";
    }

   @RequestMapping(value="/logout")
   public String pageLogin(HttpServletRequest request){

	   HttpSession session = request.getSession();
          session.invalidate();

          return "login";
    }
    
    @RequestMapping(value = "/index")
    public String Index(Locale locale, Model model, HttpSession session, HttpServletRequest request) throws ParseException {

        //customUserDetail에 set한 값을 getter를 통해 가져오는 작업을 가능하게 함
//        CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
        
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        Object obj = loggedInUser.getDetails();
        String username = loggedInUser.getName();
        
        //이런식으로 세션에 값을 넣어주면 컨트롤러에서 사용가능
//        session.setAttribute("id", userDetails.getUsername());
//        session.setAttribute("auth", userDetails.getAUTHORITY());
        session.setAttribute("nickname", username);
//        session.setAttribute("loginDate", userDetails.getLoginDate());

          return "index";
    }

}