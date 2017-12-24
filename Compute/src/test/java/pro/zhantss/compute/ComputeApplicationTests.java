package pro.zhantss.compute;

import java.util.LinkedHashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Maps;

import pro.zhantss.compute.core.Compute;
import pro.zhantss.compute.core.Functor;
import pro.zhantss.compute.test.Author;
import pro.zhantss.compute.test.TestService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComputeApplicationTests implements ApplicationContextAware {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void test() {
		try {
			TestService service = ComputeApplicationTests.context.getBean(TestService.class);
			service.test();
			service.test();
			service.test2();
			service.test3();
			Author author = service.get("zhantss1");
			System.out.println("===save===");
			System.out.println(author);
			System.out.println("===cache==");
			System.out.println(service.get("zhantss1"));
			Thread.sleep(2000);
			System.exit(0);
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		try {
			Compute compute = ComputeApplicationTests.context.getBean(Compute.class);
			
			LinkedHashMap<String, Object> env = Maps.newLinkedHashMap();
			env.put("a", 10);
			env.put("b", -12);
			env.put("c", 100.0);
			Functor functor = new Functor("a + b + c / 10 % 2", env);
			Object result = compute.execute(functor);
			System.out.println(result);
			System.out.println(compute.execute(functor));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ComputeApplicationTests.context = applicationContext;
	}

}
