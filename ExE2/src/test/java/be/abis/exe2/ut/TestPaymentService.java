package be.abis.exe2.ut;

import be.abis.exe2.exception.SalaryTooLowException;
import be.abis.exe2.model.Address;
import be.abis.exe2.model.Company;
import be.abis.exe2.model.Person;
import be.abis.exe2.service.AbisPaymentService;
import be.abis.exe2.utility.SecurityChecker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest({AbisPaymentService.class,SecurityChecker.class})
@PowerMockIgnore({"com.sun.org.apache.xerces.*", "javax.xml.*", "org.xml.*", "org.w3c.*"})
public class TestPaymentService {

    AbisPaymentService ps;

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
        //verify(securityChecker).isAbisEmployee(person);
    }

    @Test
    public void canYouMockTheStaticMethod(){
        mockStatic(SecurityChecker.class);
        when(SecurityChecker.encryptPassword(any(String.class))).thenReturn("blabla");
        assertEquals("blabla",ps.findEncryptedPassword("guess"));
       // verify(securityChecker,atLeastOnce()).encryptPassword(any(String.class));
    }
}