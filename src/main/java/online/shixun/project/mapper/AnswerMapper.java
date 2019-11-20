package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import online.shixun.project.pojo.Answer;
import online.shixun.project.pojo.Scores;

@Mapper
public interface AnswerMapper {
	
	@Select("select * from t_answer where questionId=#{questionId}")
	public List<Answer> getAnswers(int questionId);
	
	@Select("select * from t_answer where answerId=#{answerId}")
	public Answer getScore(int answerId);
	

	public int saveScore(int answerScore, int teacherId, String teacherName, String userName);
	
	@Select("SELECT *,SUM(scores) score FROM t_teacherscore WHERE teacherId=#{teacherId} AND stuName=#{userName}")
	public Scores getAllScore(int teacherId, String userName);

}
