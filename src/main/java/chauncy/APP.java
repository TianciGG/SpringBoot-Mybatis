package chauncy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "chauncy.*")
@MapperScan(basePackages="chauncy.*")
@EnableAutoConfiguration
public class APP {

	public static void main(String[] args) {
		SpringApplication.run(APP.class, args);
	}
}
