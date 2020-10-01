package be.abis.exc2.service;

import be.abis.exc2.exception.SalaryTooLowException;
import be.abis.exc2.model.Person;

public class AbisPaymentService implements PaymentService{

    public void paySalary(Person person) throws SalaryTooLowException {
            double salary = person.calculateNetSalary();
            System.out.println("Paying " + salary + " euros to " + person.getFirstName());
    }
}
