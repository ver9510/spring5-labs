package ioc;

import lab.model.Person;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static ioc.HelloWorldTest.getExpectedPerson;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleAppTest {
	
	private static final String APPLICATION_CONTEXT_XML_FILE_NAME =
            "classpath:ioc.xml";

	private BeanFactory context=new ClassPathXmlApplicationContext(
			APPLICATION_CONTEXT_XML_FILE_NAME);;

	@Test
	void testInitPerson() {
		Person person = context.getBean("person", Person.class);
		assertThat(person, Is.is(getExpectedPerson()));
	}
}
