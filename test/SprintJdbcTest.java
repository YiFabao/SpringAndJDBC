import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yifabao.bean.Person;
import com.yifabao.service.PersonService;

import junit.framework.TestCase;


public class SprintJdbcTest extends TestCase {
	
	private static PersonService psersonService;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans1.xml");
		psersonService=(PersonService) ctx.getBean("personService");
	}

	public void testSavePerson(){
		psersonService.save(new Person("易发宝"));
		System.out.println("保存");
	}
}
