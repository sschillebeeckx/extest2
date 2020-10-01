package be.abis.exc4b.ut;

import be.abis.exc4b.exception.SalaryTooLowException;
import be.abis.exc4b.model.Address;
import be.abis.exc4b.model.Company;
import be.abis.exc4b.model.Person;
import be.abis.exc4b.service.AbisPaymentService;
import be.abis.exc4b.service.PaymentService;
import be.abis.exc4b.utility.SecurityChecker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestPaymentService {

    PaymentService ps;

    Person person;

    @Spy
    SecurityChecker securityChecker = new SecurityChecker();

    @Before
    public void setUp(){
        Address a = new Address("Diestsevest","32 bus 4B","3000","Leuven","Belgium","BE");
        Company c = new Company("Abis",a);
        person = new Person(1, "Sandy", "Schillebeeckx", LocalDate.of(1978, 4, 10),c);
        ps =  new AbisPaymentService();
    }

    @Test(expected=SalaryTooLowException.class)
    public void payingSalaryUnder1500shouldThrowException() throws SalaryTooLowException {
        person.setGrossSalary(2000);
        ps.paySalary(person);
        verify(securityChecker,atLeastOnce()).isAbisEmployee(person);
    }

    @Test
    public void paySalaryToAbisEmployee() throws SalaryTooLowException {
        person.setGrossSalary(4000);
        ps.paySalary(person);
        verify(securityChecker,atLeastOnce()).isAbisEmployee(person);
    }
}