package ioc;

import lab.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static ioc.HelloWorldTest.getExpectedPerson;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class SimpleAppTest {
	
	private static final String APPLICATION_CONTEXT_XML_FILE_NAME =
            "classpath:ioc.xml";

	private BeanFactory context = new ClassPathXmlApplicationContext(
			APPLICATION_CONTEXT_XML_FILE_NAME);

	@Test
	void testInitPerson() {
		Person person = context.getBean("person", Person.class);
//		FYI: Another way to achieve the bean
//		person = context.getBean(UsualPerson.class);
		assertThat(person, is(getExpectedPerson()));
	}
}
