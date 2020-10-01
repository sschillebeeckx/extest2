package be.abis.exc4.ut;

import be.abis.exc4.exception.SalaryTooLowException;
import be.abis.exc4.model.Person;
import be.abis.exc4.service.AbisPaymentService;
import be.abis.exc4.service.PaymentService;
import be.abis.exc4.utility.SecurityChecker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestPaymentService {

    @InjectMocks PaymentService ps= new AbisPaymentService();

    @Mock  Person person;
    @Mock  SecurityChecker securityChecker;

    @Before
    public void setUp(){
       // ps = new AbisPaymentService();
    }

    @Test(expected=SalaryTooLowException.class)
    public void payingSalaryUnder1500shouldThrowException() throws SalaryTooLowException {
        when(securityChecker.isAbisEmployee(any(Person.class))).thenReturn(true);
        when(person.calculateNetSalary()).thenThrow(SalaryTooLowException.class);
        ps.paySalary(person);
    }

    @Test
    public void paySalaryToAbisEmployee() throws SalaryTooLowException {
        when(securityChecker.isAbisEmployee(any(Person.class))).thenReturn(true);
        when(person.calculateNetSalary()).thenReturn(3000.0);
        ps.paySalary(person);
        verify(securityChecker).isAbisEmployee(person);
    }
}