package service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class AsyncServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private AsyncService asyncService;
	
	@Test
	public void test1() {
		ExecutorService es = Executors.newFixedThreadPool(1000);
		for (int i = 0; i < 200; i++) {
			es.submit(new Runnable() {
				
				@Override
				public void run() {
					asyncService.doSomething();
					
				}
			});
		}
	}
}
