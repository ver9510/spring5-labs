package ioc;

import java.util.ArrayList;
import java.util.List;

import lab.model.Country;
import lab.model.Person;
import lab.model.UsualPerson;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static ioc.HelloWorldTest.getExpectedPerson;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:ioc.xml")
class SpringTCFAppTest {
	
	@Autowired
	private Person person;

	@Test
	void testInitPerson() {
		assertThat(person, Is.is(getExpectedPerson()));
	}

}
