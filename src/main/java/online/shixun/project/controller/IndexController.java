package online.shixun.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import online.shixun.project.pojo.Question;
import online.shixun.project.pojo.Teacher;
import online.shixun.project.service.QuestionService;
import online.shixun.project.service.TeacherService;

@Controller
public class IndexController {
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	
	@RequestMapping("getTeachers")
	public String getTeachers(Model model,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
		PageHelper.startPage(pageNum, 3);
		List<Teacher> teachers = teacherService.getTeachers();
		PageInfo<Teacher> pageInfo = new PageInfo<Teacher>(teachers);
		model.addAttribute("teachers", pageInfo);
		return "list";
	}
	
	@RequestMapping("detail")
	public String detail(HttpSession session,Model model,int teacherId) {
		Teacher teacher = teacherService.getTeacherById(teacherId);
		session.setAttribute("teacher", teacher);
		model.addAttribute("teacher", teacher);
		return "detail";
	}

}
