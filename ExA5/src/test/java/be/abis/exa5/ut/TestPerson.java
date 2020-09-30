package be.abis.exa5.ut;

import be.abis.exa5.model.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestPerson {

	@Test
	public void testCalculateAge() {
		Person p2 = new Person(2,"John","Doe",LocalDate.of(1967, 8, 10));
		assertThat(p2.calculateAge(), is (equalTo(53)));
	}

	@Test
	public void toStringSentenceStartsWithPerson(){
		Person p2 = new Person(2,"John","Doe",LocalDate.of(1967, 8, 10));
		String sentence = p2.toString();
		assertThat(sentence, startsWith("Person"));
	}



}
