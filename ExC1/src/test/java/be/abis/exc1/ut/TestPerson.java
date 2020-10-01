package be.abis.exc1.ut;

import be.abis.exc1.exception.PersonShouldBeAdultException;
import be.abis.exc1.model.Company;
import be.abis.exc1.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestPerson {

	Person p;
	@Mock Company mockCompany;

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

	@Test
	public void calculateNetSalaryOfBelgianPersonUsingMockCompany(){
		Person p2 = new Person(1, "Sandy", "Schillebeeckx", LocalDate.of(1978, 4, 10),mockCompany);
		p2.setGrossSalary(4000);
		when(mockCompany.calculateTaxToPay()).thenReturn(51.0);
		assertEquals(p.calculateNetSalary(), 1960, 0.01);
		verify(mockCompany,times(1)).calculateTaxToPay();
	}

}
