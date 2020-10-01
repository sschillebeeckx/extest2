package be.abis.exc4b.service;

import be.abis.exc4b.exception.SalaryTooLowException;
import be.abis.exc4b.model.Person;
import be.abis.exc4b.utility.SecurityChecker;

public class AbisPaymentService implements PaymentService {

    SecurityChecker sc =new SecurityChecker();

    public void paySalary(Person person) throws SalaryTooLowException {

        if (sc.isAbisEmployee(person)) {
            double salary = person.calculateNetSalary();
            System.out.println("Paying " + salary + " euros to " + person.getFirstName());
        }
    }
}
