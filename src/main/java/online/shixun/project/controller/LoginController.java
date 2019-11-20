package online.shixun.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import online.shixun.project.pojo.User;
import online.shixun.project.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("login")
	public String login(HttpSession session,Model model,User user) {
		boolean result = userService.getUser(user);
		if(result) {
			model.addAttribute("user", user.getUserName());
			session.setAttribute("member", user);
			return "index";
		}else {
			return "redirect:/";
		}
	}

}
