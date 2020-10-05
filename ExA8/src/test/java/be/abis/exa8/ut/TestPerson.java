package be.abis.exa8.ut;

import be.abis.exa8.exception.PersonShouldBeAdultException;
import be.abis.exa8.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class TestPerson {

	Person p;

	@Before
	public void setUp(){
		p = new Person(2,"John","Doe",LocalDate.of(1967, 8, 10));
	}

	@Test
	public void testCalculateAge() throws PersonShouldBeAdultException {
		assertThat(p.calculateAge(), is (equalTo(53)));
	}

	@Test
	public void toStringSentenceStartsWithPerson(){
		String sentence = p.toString();
		assertThat(sentence, startsWith("Person"));
	}

	@Test(expected= PersonShouldBeAdultException.class)
	public void calculateAgeShouldThrowExceptionWhenPersonNotAdult() throws PersonShouldBeAdultException {
		Person p2 = new Person(2,"Jane","Smith",LocalDate.of(2007, 8, 10));
		p2.calculateAge();
	}

}
