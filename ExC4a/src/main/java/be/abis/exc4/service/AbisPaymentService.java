package be.abis.exc4.service;

import be.abis.exc4.exception.SalaryTooLowException;
import be.abis.exc4.model.Person;
import be.abis.exc4.utility.SecurityChecker;

public class AbisPaymentService implements PaymentService {

    SecurityChecker sc ;

    public void paySalary(Person person) throws SalaryTooLowException {

        if (sc.isAbisEmployee(person)) {
            double salary = person.calculateNetSalary();
            System.out.println("Paying " + salary + " euros to " + person.getFirstName());
        }
    }
}
