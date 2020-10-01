package be.abis.exc2.ut;

import be.abis.exc2.exception.SalaryTooLowException;
import be.abis.exc2.model.Person;
import be.abis.exc2.service.AbisPaymentService;
import be.abis.exc2.service.PaymentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestPaymentService {

    PaymentService ps;

    @Mock  Person person;

    @Before
    public void setUp(){
       ps = new AbisPaymentService();
    }

    @Test(expected=SalaryTooLowException.class)
    public void payingSalaryUnder1500shouldThrowException() throws SalaryTooLowException {
        when(person.calculateNetSalary()).thenThrow(SalaryTooLowException.class);
        ps.paySalary(person);
    }
}