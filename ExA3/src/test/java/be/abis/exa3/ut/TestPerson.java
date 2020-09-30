package be.abis.exa3.ut;

import be.abis.exa3.model.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TestPerson {

	@Test
	public void testCalculateAge() {
		Person p2 = new Person(2,"John","Doe",LocalDate.of(1967, 8, 10));
		assertEquals(p2.calculateAge(),53);
	}

}
