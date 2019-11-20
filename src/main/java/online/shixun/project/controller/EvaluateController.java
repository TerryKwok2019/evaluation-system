package online.shixun.project.controller;

import java.lang.reflect.Array;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import online.shixun.project.pojo.Answer;
import online.shixun.project.pojo.Question;
import online.shixun.project.pojo.Scores;
import online.shixun.project.pojo.Teacher;
import online.shixun.project.pojo.User;
import online.shixun.project.service.AnswerService;
import online.shixun.project.service.QuestionService;

@Controller
public class EvaluateController {
	
	@Autowired
	QuestionService questionService;
	@Autowired
	AnswerService answerService;
	
	@RequestMapping("startEva")
	public String startEva(Model model,@RequestParam(defaultValue="0")int questionNum) {
		Question question = questionService.getQuestion(questionNum);
		List<Answer> answers = answerService.getAnswers(question.getQuestionId());
		model.addAttribute("answers", answers);
		model.addAttribute("questionNum", questionNum);
		model.addAttribute("question",question);
		return "evaList";
	}
	
	@RequestMapping("getScore")
	@ResponseBody
	public String getScore(HttpSession session,int answerScore,Model model) {
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		User user = (User) session.getAttribute("member");
		boolean result = answerService.saveScore(answerScore, teacher.getTeacherId(), teacher.getTeacherName(),user.getUserName());
		if(result) {
			System.out.println(teacher.getTeacherName());
			System.out.println(user.getUserName());
			System.out.println(answerScore);
			Scores score = answerService.getAllScore(teacher.getTeacherId(),user.getUserName());
			model.addAttribute("score", score);
		}
		return "scoreList";
	}
	
	@RequestMapping("getScores")
	public String getScores(HttpSession session,int answerScore,Model model) {
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		User user = (User) session.getAttribute("member");
		boolean result = answerService.saveScore(answerScore, teacher.getTeacherId(), teacher.getTeacherName(),user.getUserName());
		if(result) {
			System.out.println("保存成功！");
			Scores score = answerService.getAllScore(teacher.getTeacherId(),user.getUserName());
			model.addAttribute("scores", score);
			return "scoreList";
		}
		else {
			return "index";
		}
	}
	
	

}
