package chauncy.test01.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserMapper1 {
	
	@Insert("insert into users values(null,#{name},#{age})")
	public int addUser(@Param("name")String name,@Param("age")Integer age);
}
