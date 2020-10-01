package be.abis.exb2.ut;

import be.abis.exb2.exception.PersonShouldBeAdultException;
import be.abis.exb2.model.Person;
import java.time.LocalDate;

import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//to run only tagged tests: Edit configuration -> Test kind: Tags -> TagExpression: agetests

@DisplayName("These are the unit tests for the Person class")
public class TestPerson {
	Person p;

	@BeforeEach
	public void setUp() {
		p = new Person(2, "John", "Doe", LocalDate.of(1967, 8, 10));
	}

	@Nested
	@Tag("agetests")
	@DisplayName("Tests linked with the age of a person")
	class AgeTests {
		@Test
		@DisplayName("This one tests whether the age calculated from the birthday is correct")
		public void testCalculateAge() {
			try {
				assertThat(p.calculateAge(), is(equalTo(53)));
			} catch (PersonShouldBeAdultException e) {
				e.printStackTrace();
			}
		}

		@Test
		@DisplayName("If a person is not an adult, there should be an error message")
		public void calculateAgeShouldThrowExceptionWhenPersonNotAdult() throws PersonShouldBeAdultException {
			Person p2 = new Person(2, "Jane", "Smith", LocalDate.of(2007, 8, 10));
			Throwable exception = assertThrows(PersonShouldBeAdultException.class, () -> p2.calculateAge());
			assertEquals("person is not an adult", exception.getMessage());
		}

	}

	@Test
	@DisplayName("We want to check the toString() outcome")
	public void toStringSentenceStartsWithPerson() {
		String sentence = p.toString();
		assertThat(sentence, startsWith("Person"));
	}
}
