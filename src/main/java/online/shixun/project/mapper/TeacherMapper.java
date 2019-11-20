package online.shixun.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import online.shixun.project.pojo.Teacher;

@Mapper
public interface TeacherMapper {
	@Select("select * from t_teacher")
	public List<Teacher> getTeachers();

	public Teacher getTeacherById(int teacherId);

}
