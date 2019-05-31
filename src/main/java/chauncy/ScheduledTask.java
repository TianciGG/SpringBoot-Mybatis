package chauncy;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
	
	@Scheduled(fixedRate=1000)
	public void add(){
		System.out.println("正在执行。。。"+System.currentTimeMillis());
	}
}
