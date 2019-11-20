package online.shixun.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.project.mapper.AnswerMapper;
import online.shixun.project.pojo.Answer;
import online.shixun.project.pojo.Scores;

@Service
public class AnswerService {
	
	@Autowired
	AnswerMapper answerMapper;

	public List<Answer> getAnswers(int questionId) {
		return answerMapper.getAnswers(questionId);
	}

	public Answer getScore(int answerId) {
		return answerMapper.getScore(answerId);
	}


	public boolean saveScore(int answerScore, int teacherId, String teacherName, String userName) {
		int result = answerMapper.saveScore(answerScore, teacherId, teacherName,userName);
		if(result>0) {
			return true;
		}
		return false;
	}

	public Scores getAllScore(int teacherId, String userName) {
		return answerMapper.getAllScore(teacherId,userName);
	}



}
