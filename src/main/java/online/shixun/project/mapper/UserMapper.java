package online.shixun.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import online.shixun.project.pojo.User;
@Mapper
public interface UserMapper {
	
	@Select("select * from t_user where userName = #{userName} and password=#{password}")
	public User getUser(User user);


}
