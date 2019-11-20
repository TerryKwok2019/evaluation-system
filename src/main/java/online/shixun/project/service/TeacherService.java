package online.shixun.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.project.mapper.TeacherMapper;
import online.shixun.project.pojo.Teacher;

@Service
public class TeacherService {
	
	@Autowired
	TeacherMapper teacherMapper;
	
	public List<Teacher> getTeachers() {
		return teacherMapper.getTeachers();
	}

	public Teacher getTeacherById(int teacherId) {
		return teacherMapper.getTeacherById(teacherId);
	}

}
