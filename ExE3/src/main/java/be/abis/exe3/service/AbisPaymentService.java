package be.abis.exe3.service;

import be.abis.exe3.exception.SalaryTooLowException;
import be.abis.exe3.model.Person;
import be.abis.exe3.utility.SecurityChecker;

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
