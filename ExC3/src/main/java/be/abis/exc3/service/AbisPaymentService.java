package be.abis.exc3.service;

import be.abis.exc3.exception.SalaryTooLowException;
import be.abis.exc3.model.Person;

public class AbisPaymentService implements PaymentService{

    public void paySalary(Person person) throws SalaryTooLowException {
            double salary = person.calculateNetSalary();
            System.out.println("Paying " + salary + " euros to " + person.getFirstName());
    }
}
