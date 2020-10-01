package be.abis.exb1b.ut;

import be.abis.exb1b.exception.PersonShouldBeAdultException;
import be.abis.exb1b.model.Person;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestPerson {

	Person p;

	@BeforeEach
	public void setUp(){
		p = new Person(2,"John","Doe", LocalDate.of(1967, 8, 10));
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

	@Test
	public void calculateAgeShouldThrowExceptionWhenPersonNotAdult() throws PersonShouldBeAdultException {
		Person p2 = new Person(2,"Jane","Smith",LocalDate.of(2007, 8, 10));
		Throwable exception = assertThrows(PersonShouldBeAdultException.class, () -> p2.calculateAge());
		assertEquals("person is not an adult",exception.getMessage());
	}

}
