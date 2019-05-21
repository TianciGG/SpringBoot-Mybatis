package chauncy.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import chauncy.entity.UserEntity;


public interface UserMapper {
	
	@Select("select * from users where name=#{name}")
	UserEntity findUser(@Param("name")String name);
	
	@Insert("insert into users values(null,#{name},#{age})")
	int insertUser(@Param("name")String name,@Param("age")Integer age);
}
