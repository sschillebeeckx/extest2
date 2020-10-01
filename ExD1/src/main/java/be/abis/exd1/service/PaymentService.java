package be.abis.exd1.service;

import be.abis.exd1.exception.SalaryTooLowException;
import be.abis.exd1.model.Person;

public interface PaymentService {

    void paySalary(Person person) throws SalaryTooLowException;
    String findEncryptedPassword(String pwd);
}
