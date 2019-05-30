package chauncy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import chauncy.config.DBConfig1;
import chauncy.config.DBConfig2;

@ComponentScan(basePackages = "chauncy.*")
@EnableCaching // 开启缓存注解
@EnableAutoConfiguration
@EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })
public class APP {

	public static void main(String[] args) {
		SpringApplication.run(APP.class, args);
	}
}
