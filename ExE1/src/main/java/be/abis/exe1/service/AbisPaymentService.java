package be.abis.exe1.service;

import be.abis.exe1.exception.SalaryTooLowException;
import be.abis.exe1.model.Person;
import be.abis.exe1.utility.SecurityChecker;

public class AbisPaymentService implements PaymentService {

    SecurityChecker sc =new SecurityChecker();

    public void paySalary(Person person) throws SalaryTooLowException {

        if (sc.isAbisEmployee(person)) {
            double salary = person.calculateNetSalary();
            System.out.println("Paying " + salary + " euros to " + person.getFirstName());
        }
    }

    public String findEncryptedPassword(String pwd){
        return SecurityChecker.encryptPassword(pwd);
    }

}
