package online.shixun.project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.project.mapper.QuestionMapper;
import online.shixun.project.pojo.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionMapper questionMapper;


	public Question getQuestion(int questionNum) {
		return questionMapper.getQuestion(questionNum);
	}



}
