package chauncy.test01.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import chauncy.entity.UserEntity;

@CacheConfig(cacheNames = "baseCache")
public interface UserMapper1 {
	
	@Insert("insert into users values(null,#{name},#{age})")
	public int addUser(@Param("name")String name,@Param("age")Integer age);
	
	@Select("select * from users t where t.name=#{name}")
	@Cacheable
	public UserEntity findByUserName(@Param("name")String name);
}
