package chauncy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import chauncy.config.DBConfig1;
import chauncy.config.DBConfig2;

@ComponentScan(basePackages = "chauncy.*")
@EnableAutoConfiguration
@EnableConfigurationProperties(value={DBConfig1.class,DBConfig2.class})
public class APP {

	public static void main(String[] args) {
		SpringApplication.run(APP.class, args);
	}
}
