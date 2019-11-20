package online.shixun.project.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import online.shixun.project.pojo.Question;

@Mapper
public interface QuestionMapper {
	@Select("select * from t_question limit #{questionNum},1")
	public Question getQuestion(int questionNum);


}
