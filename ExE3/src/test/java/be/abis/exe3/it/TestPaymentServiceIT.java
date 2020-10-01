package be.abis.exe3.it;


import be.abis.exe3.exception.SalaryTooLowException;
import be.abis.exe3.model.Address;
import be.abis.exe3.model.Company;
import be.abis.exe3.model.Person;
import be.abis.exe3.service.AbisPaymentService;
import be.abis.exe3.service.PaymentService;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TestPaymentServiceIT {

    PaymentService ps;
    Person person;

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
    }

    @Test
    public void paySalaryToAbisEmployee() throws SalaryTooLowException {
        person.setGrossSalary(4000);
        ps.paySalary(person);
    }

    @Test
    public void encryptedPasswordIsReversed(){
        assertEquals("sseug",ps.findEncryptedPassword("guess"));
    }


}